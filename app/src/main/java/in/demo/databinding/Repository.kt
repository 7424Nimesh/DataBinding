package `in`.demo.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

/**
 * Created by Nimesh Shah on 3/3/20.
 */

/**
 * Simple fake repository
 */
object Repository {

    // List of Actor
    private val actorNames: List<String> = listOf("Amitabh","Govinda","Hritik","Salman","Sahrukh","Ranvir","Ranbir","Varun")

    // this data is private because we dont want to expose this data
    // Variable should be private because MutableLiveData's value can be change
    private val _currentRandomActorName = MutableLiveData<String>()

    // Here we variable is not set private because it's value can't change
    val currentRandomActorName: LiveData<String>
        get() = _currentRandomActorName

    init {
        _currentRandomActorName.value = actorNames.first()
    }

    fun getRandomActorName(): String {
        val random = Random()
        return actorNames[random.nextInt(actorNames.size)]
    }

    fun changeCurrentRandomActorName() {
        _currentRandomActorName.value = getRandomActorName()
    }
}