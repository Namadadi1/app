package com.hikmat.expense.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hikmat.expense.R
import com.hikmat.expense.models.Expense
import com.hikmat.expense.ui.add.AddExpenseViewModel
import kotlinx.android.synthetic.main.fragment_add_expense.*

class AddExpenseFragment : Fragment() {

    private lateinit var addExpenseViewModel: AddExpenseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_expense, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addExpenseViewModel = ViewModelProvider(this).get(AddExpenseViewModel::class.java)

        btn_save_expense.setOnClickListener {
            val name = et_expense_name.text.toString()
            val amount = et_expense_amount.text.toString().toDoubleOrNull()

            if (name.isNotBlank() && amount != null) {
                val expense = Expense(name = name, amount = amount)
                addExpenseViewModel.insertExpense(expense)
                clearFields()
            } else {
                // Handle error
            }
        }
    }

    private fun clearFields() {
        et_expense_name.text.clear()
        et_expense_amount.text.clear()
    }
}