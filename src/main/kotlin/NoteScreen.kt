fun openNoteMenu(archive: Archive) {
    while (true) {
        val menuItems = mutableListOf<MenuItem>()
        menuItems.add(MenuItem("Создать заметку") { createNote(archive) })

        archive.notes.forEach { note ->
            menuItems.add(MenuItem("Посмотреть заметку: ${note.title}") {
                showNoteContent(note)
            })
        }

        menuItems.add(MenuItem("Назад в главное меню") { println("Возвращаемся...") })

        val noteMenu = MenuProcessing("АРХИВ [${archive.name}] -> СПИСОК ЗАМЕТОК", menuItems)
        val shouldContinue = noteMenu.show()
        if (!shouldContinue) break
    }
}

fun createNote(archive: Archive) {
    var title: String
    var content: String

    while (true) {
        println("\nВведите заголовок заметки:")
        title = scanner.nextLine().trim()
        if (title.isEmpty()) {
            println("Ошибка: Заголовок не может быть пустым!")
            continue
        }
        break
    }

    while (true) {
        println("Введите текст заметки:")
        content = scanner.nextLine().trim()
        if (content.isEmpty()) {
            println("Ошибка: Текст заметки не может быть пустым!")
            continue
        }
        break
    }

    val newNote = Note(title, content)
    archive.notes.add(newNote)
    println("Успешно: Заметка '${title}' добавлена в архив '${archive.name}'!")
}

fun showNoteContent(note: Note) {
    println("\n=== ПРОСМОТР ЗАМЕТКИ ===")
    println("Заголовок: ${note.title}")
    println("Текст: ${note.content}")
    println("========================")
    println("Нажмите Enter, чтобы вернуться назад...")
    scanner.nextLine()
}