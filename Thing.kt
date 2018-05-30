//Thing.kt


class Thing(val number: Int, val name: String, val desc: String, var loc: Int){

fun describe(){
	println("There is ${this.name} here. It is ${this.desc}.")
	}
}
