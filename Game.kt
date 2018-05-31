//Game.kt

import Room
import Thing

//---Rooms

	val noway=Room(0,"limbo","no exit",0,0,0,0)
	val dungeon=Room(1,"the dungeon","dark and cobwebby",3,0,0,4)
	val attic=Room(2,"the attic","dusty, long forgotten",0,0,0,3)
	val entrance=Room(3,"the once resplendent entrance hall","reduced to a shadow of former glory",0,1,2,0)
	val tunnel=Room(4,"a tunnel","a twisty passage",0,0,1,3)
	val player=Room(999,"the player","inventory",0,0,0,0)

	val rooms = hashMapOf(0 to noway,
			    1 to dungeon, 
			    2 to attic,
			    3 to entrance,
			    4 to tunnel,
			    999 to  player)
	var current_room = 3 //Entrance


//---Things

	val sword=Thing(1,"a sword","rusty but sharp",2)
	val lamp=Thing(2,"a lamp","glowing magically",3)
	val note=Thing(3,"a note signed by Count Kotlin","saying 'Find my medallion and you shall be free'",3)
	val towel=Thing(4,"a towel","somewhat frayed",999)

	val things = hashMapOf(1 to sword,
			       2 to lamp,
			       3 to note,
			       4 to towel)
	
//Actions

fun present(thing: Thing) = (thing.loc==current_room)
fun have(thing: Thing) = (thing.loc==999)
fun available(thing: Thing) = (present(thing) or have(thing))

fun look(){go(current_room)}

fun inv(){
   println()
   things.forEach {(_,value) -> if (have(value)) value.describe_inv()}
   println("   - yourself; a computer scientist")
	println()
}

fun go(dir: Int){
   if (dir!=0) {
	current_room=dir
	if (available(lamp)){
	   rooms[current_room]!!.describe()
           things.forEach {(_,value) -> if (present(value)) value.describe()}
           println()}
   	else {println("It's dark!")}
               }

   else {println("Can't go there!")}
}


fun take(thing: Thing){thing.loc=999;println("Taken.")}
fun drop(thing: Thing){thing.loc=current_room; println("Dropped.")}

fun deal_with(cmd: String, name: String, thing: Thing){
	if ((cmd==name) and (present(thing))) {take(thing);return}
	if ((cmd==name) and (have(thing))) {drop(thing);return}
	if (cmd==name) println("Can't do that!")
} 


//The game


fun get_input(){
	var inn = readLine()!!
	if (inn=="e") go(rooms[current_room]!!.e)
	if (inn=="w") go(rooms[current_room]!!.w)
	if (inn=="n") go(rooms[current_room]!!.n)
	if (inn=="s") go(rooms[current_room]!!.s)
	deal_with(inn,"sword",sword)
	deal_with(inn,"lamp",lamp)
	deal_with(inn,"note",note)
	deal_with(inn,"towel",towel)
	if (inn=="look") look()
	if (inn=="inv") inv()
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

go(current_room) //Start at entrance

while (current_room!=0){get_input();println()}

println("            Goodbye!")
println()
}
