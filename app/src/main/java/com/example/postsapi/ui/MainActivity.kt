package com.example.postsapi.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.postsapi.databinding.ActivityMainBinding
import com.example.postsapi.ui.boss.BossesViewModel
import com.example.postsapi.ui.spirit.SpiritAdapter


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private val viewModel: BossesViewModel by viewModels()
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.apply {
                val adapter = SpiritAdapter(){
                    viewModel.getSpirits(it)
                }
                rvPosts.adapter = adapter

                //start observing our data
                viewModel.spirits.observe(this@MainActivity) { spirits ->
                    if (spirits.isEmpty()) {
                        //show a progress bar if the list is empty
                        binding.pbPosts.visibility = View.VISIBLE
                    } else {
                        //otherwise hide the progress bar
                        binding.pbPosts.visibility = View.GONE

                        adapter.submitList(spirits)
                    }
                }
            }
        }

}