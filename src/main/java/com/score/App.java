package com.score;

import com.score.factory.ScoreStrategyFactory;
import com.score.service.NameScoreServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {



        if(args==null || args.length< 1)
            throw new RuntimeException("file path required");

        String dept = args.length>=2 && args[1]!=null && !args[1].equals("") ? args[1]:"";

        int score = new NameScoreServiceImpl().calculateScore(readFile(args[0]),
                ScoreStrategyFactory.getStrategy(dept));

        System.out.println(score);


    }


    public static List<String> readFile(String filePath) {

        try {
            List<String> strings = Files.readAllLines(Paths.get(filePath));
            return strings.parallelStream().flatMap(line -> Stream.of(line.split(","))).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
