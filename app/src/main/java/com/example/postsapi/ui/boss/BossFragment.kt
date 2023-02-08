package com.example.postsapi.ui.boss

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.postsapi.databinding.FragmentBossesBinding

class BossFragment : Fragment() {

    private var _binding: FragmentBossesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bossViewModel by viewModels<BossesViewModel>()

        _binding = FragmentBossesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.apply {
            val adapter = BossesAdapter() {
                bossViewModel.getBosses(it)
            }
            rvBosses.adapter = adapter

            //start observing our data
            bossViewModel.posts.observe(viewLifecycleOwner) { bosses ->
                if (bosses.isEmpty()) {
                    //show a progress bar if the list is empty
                    binding.pbBosses.visibility = View.VISIBLE
                } else {
                    //otherwise hide the progress bar
                    binding.pbBosses.visibility = View.GONE

                    adapter.submitList(bosses)
                }
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}