package com.score.strategy;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class DefaultScoreStrategyTest {

    NameScoreStrategy defaultStrategy = new DefaultScoreStrategy();


    @Test
    public void testCalculateScore() {
        Function<? super String, Integer> calculateScore = defaultStrategy.calculateScore();

        assertSame(1, calculateScore.apply("A"));
        assertSame(0, calculateScore.apply(""));
        assertSame(2, calculateScore.apply("AA"));


    }

    @Test
    public void testMultiplyScoreWithIndex() {
        ToIntFunction<? super Integer> toIntFunction = defaultStrategy.multiplyWithScore();
        assertSame(5, Stream.of(1, 2).mapToInt(toIntFunction).sum());

    }

    @Test
    public void testExtractName() {
        Function<String, String> extractName = defaultStrategy.extractName();
        assertEquals("LINDA", extractName.apply("\"LINDA\""));
    }

}