class ReportViewModel(application: Application) : AndroidViewModel(application) {

    private val expenseRepository: ExpenseRepository = ExpenseRepository(AppDatabase.getDatabase(application).expenseDao())
    private val _weeklyReport = MutableLiveData<List<Expense>>()
    val weeklyReport: LiveData<List<Expense>> get() = _weeklyReport

    fun generateWeeklyReport(startDate: LocalDate, endDate: LocalDate) {
        viewModelScope.launch {
            _weeklyReport.value = expenseRepository.getExpensesBetweenDates(startDate, endDate)
        }
    }

    fun getTotalExpenditure(): LiveData<Double> {
        return Transformations.map(weeklyReport) { expenses ->
            expenses.sumOf { it.amount }
        }
    }
}