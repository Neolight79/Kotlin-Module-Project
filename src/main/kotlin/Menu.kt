class Menu<E : Listable>(private val itemsList: MutableList<E>) {
    private val inp = UserInput()
    fun startMenu(vararg titles: String, newInstance: (name: String) -> E): E? {
        var chosenNumber: Int?
        var newName: String?
        while (true) {
            print("\u001b[2J") // Очищаем консоль
            do {
                println(titles[0])  // Например "Список заметок" или "Список архивов"
                println("0. ${titles[1]}")  // Например "Создать заметку" или "Создать архив"
                for (i in 1..itemsList.size) println("$i. ${itemsList[i - 1].getNameString()}")
                println("${itemsList.size + 1}. Выход")
                chosenNumber = inp.getNumber(0..itemsList.size + 1)
            } while (chosenNumber == null)
            when (chosenNumber) {
                itemsList.size + 1 -> return null   // Выход
                0 -> {  // Создать новый объект: Архив или Заметку
                    do {
                        println(titles[2])  // Например "Введите новую заметку" или "Введите название архива"
                        newName = inp.getText(2..100)   // Строка от 2 до 100 символов подойдет
                    } while (newName == null)
                    itemsList.add(newInstance(newName))
                }
                else -> return itemsList[chosenNumber - 1]
            }
        }
    }
}
