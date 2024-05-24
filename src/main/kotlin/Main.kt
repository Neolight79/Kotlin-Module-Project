interface Listable {
    fun printName()
}

data class Note(var note: String) : Listable {
    override fun printName() {
        println(note)
    }
    companion object {
        const val TEXT_LIST = "Список заметок"
        const val TEXT_CREATE = "Создать заметку"
    }
}

data class Archive(var name: String) : Listable {
    val notesList : MutableList<Note> = mutableListOf()
    override fun printName() {
        println(name)
    }
    companion object {
        const val TEXT_LIST = "Список архивов"
        const val TEXT_CREATE = "Создать архив"
    }
}

class Menu<E : Listable>(val itemsList: MutableList<E?>) {
    fun printItems(textCreate: String, textList: String, newInstance: (name: String) -> E?) {
        for (item in itemsList) {
            println(textList)
            item?.printName()
            println(textCreate)
        }
        itemsList.add(newInstance("Четвертая заметка"))
    }
}

fun main(args: Array<String>) {
    val zametka = Note("Тест заметки")
    val zam_text = Note.TEXT_LIST
    println("Hello World!")
    zametka.printName()
    println(zam_text)
    println("---------------------")

    // Теперь пробуем создать массив заметок и передать его в объект Meny для вывода на экран
    val listOfNotes = mutableListOf<Note?>()
    listOfNotes.add(Note("Первая заметка"))
    listOfNotes.add(Note("Вторая заметка"))
    listOfNotes.add(Note("Третья заметка"))
    val menu1 = Menu(listOfNotes)
    menu1.printItems(Note.TEXT_CREATE, Note.TEXT_LIST) { name -> Note(name) }
    menu1.printItems(Note.TEXT_CREATE, Note.TEXT_LIST) { name -> Note(name) }
    menu1.printItems(Note.TEXT_CREATE, Note.TEXT_LIST) { name -> Note(name) }
}