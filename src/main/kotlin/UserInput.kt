import java.util.InputMismatchException
import java.util.Scanner

class UserInput {
    companion object {
        val input = Scanner(System.`in`)
    }

    fun getNumber(intRange: IntRange): Int? {
        val number: Int
        try {
            number = input.nextInt()
            input.nextLine()
            if (number in intRange) return number
            throw InputMismatchException("NotInRange")
        } catch (ife: InputMismatchException) {
            if (ife.message != "NotInRange") input.nextLine()
            println("Введите число от ${intRange.first} до ${intRange.last}")
            return null
        }
    }
    fun getText(lengthRange: IntRange): String? {
        val text = input.nextLine()
        if (text.length in lengthRange) return text
        println("Введите строку от ${lengthRange.first} до ${lengthRange.last} символов")
        return null
    }

    fun getEnter() {
        input.nextLine()
    }
}