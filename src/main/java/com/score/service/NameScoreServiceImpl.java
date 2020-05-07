package com.score.service;

import com.score.strategy.NameScoreStrategy;

import java.util.List;

public class NameScoreServiceImpl implements NameScoreService {


    @Override
    public int calculateScore(List<String> names, NameScoreStrategy strategy) {
        System.out.println("calculating for " + strategy.getClass().getName());

        return names
                .stream()
                .map(strategy.extractName())
                .sorted()
                .map(strategy.calculateScore())
                .mapToInt(strategy.multiplyWithScore())
                .sum();
    }

}
