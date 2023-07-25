package ru.almaz;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        App app = new App();
        System.out.println("Вводите по очереди номера отправлений:");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            app.findOrNot(scanner.nextLine());
        }
    }
}