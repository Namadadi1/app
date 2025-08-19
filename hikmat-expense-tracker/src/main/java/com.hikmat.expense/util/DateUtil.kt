import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtil {
    private const val DATE_FORMAT = "yyyy-MM-dd"

    fun formatDate(date: Date): String {
        val formatter = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        return formatter.format(date)
    }

    fun parseDate(dateString: String): Date? {
        return try {
            val formatter = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
            formatter.parse(dateString)
        } catch (e: Exception) {
            null
        }
    }
}