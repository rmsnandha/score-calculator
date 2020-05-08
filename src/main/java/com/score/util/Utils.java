package com.score.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {


    public static List<String> readFile(String filePath) {
            Objects.requireNonNull(filePath);
        try {
            List<String> strings = Files.readAllLines(Paths.get(filePath));
            return strings.parallelStream().flatMap(line -> Stream.of(line.split(","))).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public static String getDept(String[] args) {
        Objects.requireNonNull(args);
        return args.length>=2 && args[1]!=null && !args[1].equals("") ? args[1]:"";
    }
}
