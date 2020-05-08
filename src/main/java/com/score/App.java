package com.score;

import com.score.factory.ScoreStrategyFactory;
import com.score.service.NameScoreServiceImpl;
import com.score.util.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        if (args == null || args.length < 1)
            throw new RuntimeException("file path required");

        LocalTime start = LocalTime.now();

        String dept = Utils.getDept(args);
        int score = new NameScoreServiceImpl().calculateScore(Utils.readFile(args[0]), ScoreStrategyFactory.getStrategy(dept));
        System.out.println("Total score : " + score);

        System.out.println("Total time taken in millis " + start.until(LocalTime.now(), ChronoUnit.MILLIS));


    }


}
