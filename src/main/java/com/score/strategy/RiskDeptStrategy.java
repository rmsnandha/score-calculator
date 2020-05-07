package com.score.strategy;

import java.util.function.ToIntFunction;

public class RiskDeptStrategy implements  NameScoreStrategy{

    /*
     do not want to multiply with index position
     */

    @Override
    public ToIntFunction<? super Integer> multiplyWithScore() {
        return t->t;
    }
}
