import java.text.SimpleDateFormat
import java.util.*

fun String.toDate(): Date {
    val formatter = SimpleDateFormat("yyyy-mm-dd")
    return formatter.parse(this)
}
