var yearEntered = 0
fun main(){
    enterMessageLabel()
}
 fun enterMessageLabel(){
     val enterYearLabel = "Enter Year"
     enterYearLabel.print()
     yearEntered = readLine()?.toIntOrNull()!!
     val leapDesc = "$yearEntered is a leap year"
     val notLeapYearDesc = "$yearEntered is not a leap year"
     if ( leapYearCheck(yearEntered)) leapDesc.print() else notLeapYearDesc.print()
     enterMessageLabel()
 }

fun leapYearCheck(yearEntered: Int) : Boolean {
       return when {
            yearEntered % 4 == 0 ->  true
            yearEntered % 100 == 0 ->  false
            yearEntered % 400 == 0 ->  true
           else -> false
       }
}
