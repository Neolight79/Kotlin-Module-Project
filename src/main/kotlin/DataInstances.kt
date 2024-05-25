interface Listable {
    fun getNameString(): String
}

data class Note(var note: String) : Listable {
    override fun getNameString() = note
}

data class Archive(var name: String) : Listable {
    val notesList : MutableList<Note> = mutableListOf()
    override fun getNameString() = name
}
