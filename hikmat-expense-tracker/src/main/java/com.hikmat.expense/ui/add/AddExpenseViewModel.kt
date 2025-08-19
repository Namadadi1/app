class AddExpenseViewModel(application: Application) : AndroidViewModel(application) {

    private val expenseRepository: ExpenseRepository = ExpenseRepository(AppDatabase.getDatabase(application).expenseDao())

    private val _expenseName = MutableLiveData<String>()
    val expenseName: LiveData<String> get() = _expenseName

    private val _expenseAmount = MutableLiveData<Double>()
    val expenseAmount: LiveData<Double> get() = _expenseAmount

    fun setExpenseName(name: String) {
        _expenseName.value = name
    }

    fun setExpenseAmount(amount: Double) {
        _expenseAmount.value = amount
    }

    fun addExpense() {
        val name = _expenseName.value ?: return
        val amount = _expenseAmount.value ?: return
        val expense = Expense(name = name, amount = amount, date = System.currentTimeMillis())
        viewModelScope.launch {
            expenseRepository.insertExpense(expense)
        }
    }
}