import java.util.Scanner

data class Note(val title: String, val content: String)
data class Archive(val name: String, val notes: MutableList<Note> = mutableListOf())

val archiveList = mutableListOf<Archive>()
val scanner = Scanner(System.`in`)

fun main() {
    println("Добро пожаловать в приложение 'Заметки'!")
    openArchiveMenu()
}