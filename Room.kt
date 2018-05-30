//Room.kt

class Room(val number : Int, val name : String, val desc: String, val e: Int, val w: Int, val n: Int, val s: Int){

fun describe(){
        println()
        println("You are in ${this.name}. It is ${this.desc}.")
        println("You can go:")
                if (this.e!=0) println("   East")
                if (this.w!=0) println("   West")
                if (this.n!=0) println("   North")
                if (this.s!=0) println("   South")
        println()
 }



}


