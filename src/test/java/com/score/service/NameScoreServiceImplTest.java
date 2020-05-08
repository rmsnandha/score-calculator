package com.score.service;

import com.score.factory.ScoreStrategyFactory;
import com.score.strategy.NameScoreStrategy;
import com.score.util.Utils;
import org.junit.Test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class NameScoreServiceImplTest {


    NameScoreService nameScoreService = new NameScoreServiceImpl();

    NameScoreStrategy defaultScoreStrategy = ScoreStrategyFactory.getStrategy("");
    NameScoreStrategy riskDeptScoreStrategy = ScoreStrategyFactory.getStrategy("RISK");

    @Test
    public void testCalculateWithDefaultScoring() {

        int score = nameScoreService.calculateScore(Arrays.asList("\"A\"", "\"LINDA\""), defaultScoreStrategy);
        assertEquals(81, score);

    }

    @Test
    public void should_returnZERO_when_no_names_passed() {
        int score = nameScoreService.calculateScore(Collections.emptyList(), defaultScoreStrategy);
        assertEquals(0, score);

    }


    @Test
    public void testCalculateScore_ForRiskDept_which_doNot_multiplyScore_WithIndex() {

        int score = nameScoreService.calculateScore(Arrays.asList("\"A\"", "\"LINDA\""), riskDeptScoreStrategy);
        assertEquals(41, score);

    }

    @Test
    public void testFileNamesTotalCount() {
        Path path = FileSystems.getDefault().getPath("src/test/resources/names.txt").toAbsolutePath();
        int score = nameScoreService.calculateScore(Utils.readFile(path.toString()), defaultScoreStrategy);
        assertEquals(871198282, score);

    }



}