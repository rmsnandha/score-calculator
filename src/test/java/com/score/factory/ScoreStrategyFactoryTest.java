package com.score.factory;

import com.score.strategy.DefaultScoreStrategy;
import org.junit.Assert;
import org.junit.Test;

public class ScoreStrategyFactoryTest{

    @Test
    public void default_strategy_should_returned(){
        Assert.assertTrue(ScoreStrategyFactory.getStrategy("") instanceof DefaultScoreStrategy);
    }


}