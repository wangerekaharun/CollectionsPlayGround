

val badMeetsEvil = Albums("Bad Meets Evil","2016-07-01".toDate(),"HipHop",5.2, listOf("Eminem","Royce"))
val africanGiant = Albums("African Giant","2019-07-12".toDate(),"AfroMMusic",8.0, listOf("Burna Boy"))
val redPillBlues = Albums("Red Pill Blues","2017-05-19".toDate(),"Pop",7.3, listOf("Maroon 5"))
val testimony1990 = Albums("Testimony 1990","2018-09-23".toDate(),"HipHop",9.2, listOf("Khaligraph"))
val royalty = Albums("Royalty","2017-02-24".toDate(),"RNB",6.3, listOf("Chris Brown"))
val kamiKaze = Albums("Kamikaze","2019-02-01".toDate(),"HipHop",2.2, listOf("Eminem"))
val nextYear = Albums("Next Year","2018-08-08".toDate(),"HipHop",2.2, listOf("Octoppizzo"))


fun main(){
    //TODO 1 Create list,map and map both mutable and immutable
    //creating collections

    //list and mutable list
    val albumList = listOf(badMeetsEvil,africanGiant,redPillBlues,testimony1990,royalty,kamiKaze)
    val mutableAlbumList = mutableListOf(badMeetsEvil,africanGiant,redPillBlues,testimony1990,royalty,kamiKaze)

    //set and mutable set
    val albumSet = setOf(badMeetsEvil,africanGiant,redPillBlues,testimony1990,royalty,kamiKaze)
    val mutableAlbumSet = mutableSetOf(badMeetsEvil,africanGiant,redPillBlues,testimony1990,royalty,kamiKaze)

    //map and mutable map
    val albumMap = mapOf(badMeetsEvil.albumName to badMeetsEvil,africanGiant.albumName to africanGiant,kamiKaze.albumName to kamiKaze)
    val mutableAlbumMap = mapOf(badMeetsEvil.albumName to badMeetsEvil,africanGiant.albumName to africanGiant, kamiKaze.albumName to kamiKaze)

    //TODO 2 Aggregating
    println(albumList.count())
    println(albumList.maxBy { it.averageRating }) // max() if it is a number
    println(albumList.minBy { it.averageRating }) // min() if it ia a number
    arrayListOf(4.2,3.4,8.9).average().print()
    arrayListOf(1,2,3,4,6,6,7).sum().print()
    albumList.sumByDouble { it.averageRating }.print()
    listOf(1,2,3).fold(3){ acc, i ->
        acc + i
    }.print()

    //TODO 3 Searching
    albumList.first { it.averageRating > 4.0 }.print<Albums>()
    albumList.find { it.averageRating > 9.0 }?.print<Albums>()
    albumList.last { it.averageRating > 4.2 }.print<Albums>()
    albumList.findLast { it.averageRating > 9.0 }?.print<Albums>()
    albumList.single { it.averageRating == 9.2 }.print<Albums>()
    albumList.singleOrNull { it.averageRating == 9.4 }?.print<Albums>()



    //TODO 4 Filtering
    albumList.filter { it.averageRating > 5.0 }.print<Albums>()
    albumList.filterNot { it.averageRating > 6.2 }.print<Albums>()
    val mutableAlbums = mutableListOf<Albums>()
    albumList.filterTo(mutableAlbums,{it.averageRating > 7.5}).print<Albums>()
    albumList.filterNotTo(mutableAlbums,{it.averageRating > 7.5}).print<Albums>()
    albumList.filterIndexed { index, albums -> index == 2  }.print<Albums>()

    //TODO 5 Transformation
    albumList.map { it.averageRating +1.0 }.print<Albums>()
    albumList.mapIndexed { index, albums ->  index to albums.albumName}.print<Albums>()
    albumList.map { it.artistes }.print<Albums>()
    albumList.flatMap { it.artistes }.print<Albums>()
    val artistList = albumList.flatMap { it.artistes }
    artistList.distinct().print<String>()
    albumList.associate { it.albumName to it.averageRating }.print<Albums>()
    albumList.groupBy ({ it.albumName}, {it.averageRating }).print<Albums>()

    //TODO 6 Checks and Actions
    //acting on lists
    albumList.onEach { it.print<Albums>() }
    albumList.forEach { it.print<Albums>() }
    val listOfFunctions = listOf({ print("first ") }, { print("second ") })
    listOfFunctions.forEachIndexed { index, fn -> if (index == 0) fn() else "Won't do it".print()
    }

    //checks
    albumList.all { it.averageRating >2 }.print<Boolean>()
    albumList.contains(kamiKaze).print<Boolean>()
    val isAlbumThere = nextYear in albumList
    isAlbumThere.print<Boolean>()
    albumList.containsAll(listOf(kamiKaze,africanGiant,nextYear)).print<Boolean>()
    albumMap.contains("Kamikaze").print<Boolean>()
    "Kamikaze" in albumMap

    //TODO 7 Operators
    val intList: List<Int> = listOf(1, 2, 3)
    val aMap: Map<String, Int> = mapOf("hi" to 1, "hello" to 2)
    val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
    var mutableMap: MutableMap<String, Int> = mutableMapOf("hi" to 1, "hello" to 2)

    (intList+1).print<Int>()
    (intList+ listOf(4,5,6)).print<Int>()
    (intList-3).print<Int>()
    (intList - listOf(3,2)).print<Int>()
    (aMap + Pair("Hi", 2)).print<String>()
    (aMap + mapOf(Pair("hello", 2), Pair("Goodbye", 3))).print<String>()
    (aMap - "hello").print<String>()
    (aMap - listOf("hello", "hi")).print<String>()
    mutableList -= 2
    mutableList.print<Int>()

    mutableList += 2
    mutableList.print<Int>()
    mutableMap.minusAssign("hello")
    mutableMap.print<String>()
    mutableMap.plusAssign("test" to 3)
    mutableMap.print<String>()



    //TODO Cool Stuff

    //the old way
    var count = 0
    var total = 0.0
    for (album in albumList){
        if (album.genre == "HipHop"){
            count ++
            total += album.averageRating
        }
    }
    val average = total/ count
    average.print()

    //using collections
    val avg = albumList.filter { it.genre == "HipHop"  }
        .map { it.averageRating }
        .average()
        .print()
}