package com.score.service;

import com.score.strategy.NameScoreStrategy;

import java.util.List;


public interface NameScoreService {

     int calculateScore(List<String> names, NameScoreStrategy strategy);
}
