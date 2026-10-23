fun openArchiveMenu() {
    while (true) {
        val menuItems = mutableListOf<MenuItem>()
        menuItems.add(MenuItem("Создать архив") { createArchive() })

        archiveList.forEach { archive ->
            menuItems.add(MenuItem("Открыть архив: ${archive.name}") {
                openNoteMenu(archive)
            })
        }

        menuItems.add(MenuItem("Выход из программы") {
            println("До свидания!")
            System.exit(0)
        })

        val archiveMenu = MenuProcessing("ГЛАВНОЕ МЕНЮ (СПИСОК АРХИВОВ)", menuItems)
        val shouldContinue = archiveMenu.show()
        if (!shouldContinue) break
    }
}

fun createArchive() {
    while (true) {
        println("\nВведите название для нового архива:")
        val name = scanner.nextLine().trim()
        if (name.isEmpty()) {
            println("Ошибка: Имя архива не может быть пустым.")
            continue
        }
        val newArchive = Archive(name)
        archiveList.add(newArchive)
        println("Успешно: Архив '$name' создан!")
        break
    }
}