class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val expenseRepository: ExpenseRepository = ExpenseRepository(AppDatabase.getDatabase(application).expenseDao())
    val allExpenses: LiveData<List<Expense>> = expenseRepository.getAllExpenses()

    fun insertExpense(expense: Expense) {
        viewModelScope.launch {
            expenseRepository.insertExpense(expense)
        }
    }

    fun deleteExpense(expense: Expense) {
        viewModelScope.launch {
            expenseRepository.deleteExpense(expense)
        }
    }
}