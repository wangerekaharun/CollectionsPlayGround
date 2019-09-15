var yearEntered = 0
fun main(){
    enterMessageLabel()
}
 fun enterMessageLabel(){
     val enterYearLabel = "Enter Year"
     enterYearLabel.print()
     val yearEnteredString = readLine()
     if (yearEnteredString?.length!! > 4 || yearEnteredString.length < 4){
        println("Value entered not a valid year")
         return
     }else{
         yearEntered = yearEnteredString.toIntOrNull()!!
         val leapDesc = "$yearEntered is a leap year"
         val notLeapYearDesc = "$yearEntered is not a leap year"
         if ( leapYearCheck(yearEntered)) leapDesc.print() else notLeapYearDesc.print()
         enterMessageLabel()
     }

 }

fun leapYearCheck(yearEntered: Int) : Boolean {
       return when {
           yearEntered % 4 == 0 && yearEntered % 100 != 0  ->  true
           yearEntered % 400 == 0 && yearEntered % 100 == 0 ->  true
           else -> false
       }
}
