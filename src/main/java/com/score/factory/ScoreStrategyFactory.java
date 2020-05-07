package com.score.factory;

import com.score.strategy.DefaultScoreStrategy;
import com.score.strategy.NameScoreStrategy;
import com.score.strategy.RiskDeptStrategy;

public class ScoreStrategyFactory {

    public static NameScoreStrategy getStrategy(String dept) {

        switch (dept) {
            case "RISK":
                return new RiskDeptStrategy();

            default:
                return new DefaultScoreStrategy();
        }

    }

}
