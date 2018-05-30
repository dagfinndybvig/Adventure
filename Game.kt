//Game.kt

import Room

	val noway=Room(0,"limbo","no exit",0,0,0,0)
	val dungeon=Room(1,"the dungeon","dark and cobwebby",3,0,0,4)
	val attic=Room(2,"the attic","dusty, long forgotten",0,0,0,3)
	val entrance=Room(3,"the once resplendent entrance hall","reduced to a shadow of former glory",0,1,2,0)
	val tunnel=Room(4,"a tunnel","a twisty passage",0,0,1,3)

	val rooms = hashMapOf(0 to noway,
			    1 to dungeon, 
			    2 to attic,
			    3 to entrance,
			    4 to tunnel)

var current_room = 3 //Start at entrance


fun get_input(){
val inn = readLine()!!
	if (inn=="e") current_room=rooms[current_room]!!.e
	if (inn=="w") current_room=rooms[current_room]!!.w
	if (inn=="n") current_room=rooms[current_room]!!.n
	if (inn=="s") current_room=rooms[current_room]!!.s
	if (inn=="q") current_room=0 //Go to limbo and quit
}


fun main(args : Array<String>){
println("\u001b[2J")
println()
println("--- WELCOME TO ADVENTURE ---")
println()
println("You have journeyed to Castle Kotlin in search of treasure.")
println("As you enter, the mighty doors slam shut behind you!")
println()

while (current_room!=0){
	rooms[current_room]!!.describe()
	get_input()
	}
println("            Goodbye!")
println()
}
