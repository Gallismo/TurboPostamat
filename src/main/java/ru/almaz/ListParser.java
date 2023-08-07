package ru.almaz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ListParser {

    private final Scanner scanner;

    private static final String REGEX = "\\d+-\\d+-\\d+";
    private static final String REGEX2 = "ii\\d+";

    public ListParser (File file) throws FileNotFoundException {
        scanner = new Scanner(file);
    }

    public Set<String> parse() {
        Set<String> parsedList = new HashSet<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.matches(REGEX)) parsedList.add(line);
            else if (line.matches(REGEX2)) parsedList.add(line);
        }

        return parsedList;
    }
}
