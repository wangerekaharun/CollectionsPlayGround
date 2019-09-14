import java.util.*

data class Albums(
    val albumName : String,
    val releaseDate : Date,
    val genre : String,
    val averageRating :Double,
    val artistes : List<String>
)