fun main(args: Array<String>) {
    val listOfArchives = mutableListOf<Archive>()
    val archiveMenu = Menu(listOfArchives)
    var archive: Archive?
    var notesMenu: Menu<Note>
    var note: Note?
    val inp = UserInput()
    while (true) {    // Основной цикл работы с архивами
        archive = archiveMenu.startMenu("Список архивов", "Создать архив", "Введите имя архива") { name -> Archive(name) }
        if (archive == null) return
        do {    // Цикл работы с заметками
            notesMenu = Menu(archive.notesList)
            note = notesMenu.startMenu("Список заметок", "Создать заметку", "Введите текст заметки") { name -> Note(name) }
            if (note != null) {
                println(note.getNameString())
                inp.getEnter()
            }
        } while (note != null)
    }
}