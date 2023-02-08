package com.example.postsapi.ui.spirit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postsapi.model.BossesAPi
import com.example.postsapi.model.BossesApiImpl
import com.example.postsapi.model.Spirit
import com.example.postsapi.utils.Provider
import kotlinx.coroutines.launch

class SpiritViewModel : ViewModel() {


    private var postsApi: BossesAPi = BossesApiImpl(Provider.client)
    private val _spirit: MutableLiveData<List<Spirit>> = MutableLiveData()
    val spirits: LiveData<List<Spirit>> get() = _spirit

    init {
        loadSpiritFromApi()
    }

    private fun loadSpiritFromApi(){
        viewModelScope.launch {
            _spirit.value = postsApi.getSpiritLimitBy(10)
        }
    }
    fun getSpirits(limit:Int){
        viewModelScope.launch {
            _spirit.value = postsApi.getSpiritLimitBy(limit)
        }
    }
}