package com.mycodinglab.angelapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mycodinglab.angelapp.databinding.FragmentTopStockListBinding
import com.mycodinglab.angelapp.ui.HomeViewModel
import com.mycodinglab.angelapp.ui.StocDetailAdapter


import dagger.hilt.android.AndroidEntryPoint


/**
 * A simple [Fragment] subclass.
 * Use the [TopStockListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

@AndroidEntryPoint
class TopStockListFragment : Fragment() {


    private val homeViewModel: HomeViewModel by activityViewModels()
    private var binding: FragmentTopStockListBinding? = null
    private lateinit var stocRecyclerAdapter: StocDetailAdapter
    private var progressBar: ProgressBar? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTopStockListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        observeForData()
    }

    private fun showEmptyView(message: String) {
        binding?.emptyView?.visibility = View.VISIBLE
        binding?.emptyViewText?.text = message
    }

    private fun observeForData() {
        progressBar?.visibility = View.VISIBLE
        binding?.homeRecyclerview?.visibility = View.GONE
        homeViewModel.fetchTopStock().observe(viewLifecycleOwner,{
            progressBar?.visibility = View.GONE
            if (it.isNullOrEmpty()) {
                showEmptyView("Not able to load data from server!")
                return@observe
            }
            binding?.homeRecyclerview?.visibility = View.VISIBLE
            binding?.categoryRecyclerView?.visibility = View.GONE
            stocRecyclerAdapter.submitList(it)
        })

    }

    private fun setUpRecyclerView() {
        stocRecyclerAdapter= StocDetailAdapter()
        binding?.homeRecyclerview?.layoutManager = LinearLayoutManager(context)
        binding?.homeRecyclerview?.adapter = stocRecyclerAdapter
        progressBar = binding?.progressBar
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}