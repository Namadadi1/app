class AiAdvisor {

    fun suggestExpenditure(expenses: List<Expense>): String {
        val totalSpent = expenses.sumOf { it.amount }
        val averageSpent = totalSpent / expenses.size

        return when {
            totalSpent > 100000 -> "Consider reducing your spending. You're averaging more than $averageSpent per item."
            totalSpent > 50000 -> "Your spending is moderate. Keep an eye on your expenses."
            else -> "Your spending is within a reasonable range. Good job!"
        }
    }
}