package `in`.demo.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

/**
 * Created by Nimesh Shah on 3/3/20.
 */
object Repository {

    private val actorNames: List<String> = listOf("Amitabh","Govinda","Hritik","Salman","Sahrukh","Ranvir","Ranbir","Varun")

    private val _currentRandomActorName = MutableLiveData<String>()
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