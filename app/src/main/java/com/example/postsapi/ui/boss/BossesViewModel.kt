package com.example.postsapi.ui.boss

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postsapi.model.*
import com.example.postsapi.utils.Provider
import kotlinx.coroutines.launch

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 07,Feb,2023
 */
class BossesViewModel: ViewModel() {

    private var postsApi: BossesAPi = BossesApiImpl(Provider.client)
    private val _posts: MutableLiveData<List<Boss>> = MutableLiveData()
    private val _spirit: MutableLiveData<List<Spirit>> = MutableLiveData()
    val posts: LiveData<List<Boss>> get() = _posts
    val spirits: LiveData<List<Spirit>> get() = _spirit

    init {
        loadBossesFromApi()
    }

    private fun loadBossesFromApi(){
        viewModelScope.launch {
            _posts.value = postsApi.getBosses()
            //_spirit.value = postsApi.getSpiritLimitBy(10)
        }
    }

    fun getBosses(limit:Int){
        viewModelScope.launch {
            _posts.value = postsApi.getBossesLimitBy(limit)
        }
    }
    fun getSpirits(limit:Int){
        viewModelScope.launch {
            _spirit.value = postsApi.getSpiritLimitBy(limit)
        }
    }
}
