package `in`.demo.databinding

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Nimesh Shah on 3/3/20.
 */
class MainViewModel: ViewModel() {

    val currentRandomActorName: LiveData<String>
        get() = Repository.currentRandomActorName

    fun onChangeRandomActorClick() = Repository.changeCurrentRandomActorName()

    val editTextContent = MutableLiveData<String>()

    private val _displayedEditTextContent = MutableLiveData<String>()
    val displayedEditTextContent: LiveData<String>
        get() = _displayedEditTextContent

    fun onDisplayEditTextContentClick() {
        _displayedEditTextContent.value = editTextContent.value
    }

    fun onSelectRandomEditTextActor() {
        editTextContent.value = Repository.getRandomActorName()
    }
}