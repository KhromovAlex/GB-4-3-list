package com.example.gb_4_3_list.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gb_4_3_list.databinding.FragmentRedditListBinding
import com.example.gb_4_3_list.domain.entity.Post
import com.example.gb_4_3_list.presentation.adapter.RedditListAdapter
import com.example.gb_4_3_list.presentation.viewmodel.RedditListViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class RedditListFragment : Fragment() {
    private var _binding: FragmentRedditListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RedditListViewModel by viewModel()
    private val listAdapter = RedditListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRedditListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.postList.layoutManager = LinearLayoutManager(requireContext())
        binding.postList.adapter = listAdapter
        viewModel.liveData.observe(viewLifecycleOwner, ::renderData)
    }

    private fun renderData(pagingData: PagingData<Post>?) {
        lifecycleScope.launch {
            if (pagingData != null) {
                listAdapter.submitData(pagingData)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
