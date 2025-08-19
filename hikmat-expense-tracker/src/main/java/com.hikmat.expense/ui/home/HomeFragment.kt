package com.hikmat.expense.ui.home

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hikmat.expense.R
import com.hikmat.expense.models.Expense
import com.hikmat.expense.ui.home.adapter.ExpenseAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var expenseRecyclerView: RecyclerView
    private lateinit var expenseAdapter: ExpenseAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        expenseRecyclerView = view.findViewById(R.id.recycler_view_expenses)
        expenseRecyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        homeViewModel.getAllExpenses().observe(viewLifecycleOwner, { expenses ->
            expenseAdapter = ExpenseAdapter(expenses)
            expenseRecyclerView.adapter = expenseAdapter
        })
    }
}