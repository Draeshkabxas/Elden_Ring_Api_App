package com.example.postsapi.ui.spirit

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.postsapi.R
import com.example.postsapi.databinding.FragmentSpiritBinding

class SpiritFragment : Fragment(R.layout.fragment_spirit) {


    private var _binding: FragmentSpiritBinding? = null
    private val binding get() = _binding!!
    val spiritViewModel by viewModels<SpiritViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding=FragmentSpiritBinding.bind(view)
            val adapter = SpiritAdapter() {
                spiritViewModel.getSpirits(it)
            }
            binding.rvSpirits.adapter = adapter

            //start observing our data
            spiritViewModel.spirits.observe(viewLifecycleOwner) { spirits ->
                if (spirits.isEmpty()) {
                    //show a progress bar if the list is empty
                    binding.pbSpirits.visibility = View.VISIBLE
                } else {
                    //otherwise hide the progress bar
                    binding.pbSpirits.visibility = View.GONE

                    adapter.submitList(spirits)
                }
            }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}