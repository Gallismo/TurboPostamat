package ru.almaz;

import ru.almaz.exceptions.EmptyListException;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class App {
    private final Set<String> parsedNames;

    public App() throws FileNotFoundException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("list.txt"));
        int ret = fileChooser.showDialog(null, "Открыть файл");

        if (ret == JFileChooser.APPROVE_OPTION) {
            ListParser parser = new ListParser(fileChooser.getSelectedFile());
            parsedNames = parser.parse();
        } else {
            throw new EmptyListException("Список отправлений пуст! Не указан файл со списком отправлений!");
        }

        if (parsedNames.isEmpty()) throw new EmptyListException("Список отправлений пуст!");

        System.out.println("Количество отправлений: " + parsedNames.size());
    }

    public void findOrNot(String nameToFind) throws InterruptedException {
        boolean founded = parsedNames.contains(nameToFind);
        if (founded) {
            System.out.println("Отправление присутсвует в списке!");
            parsedNames.remove(nameToFind);
            System.out.println("Осталось: " + parsedNames.size());

            if (parsedNames.isEmpty()) {
                System.out.println("Список закончился!");
                Thread.sleep(5 * 1000);
                System.exit(0);
            }
        } else {
            System.out.println("Не найдено!");
        }
    }
}
