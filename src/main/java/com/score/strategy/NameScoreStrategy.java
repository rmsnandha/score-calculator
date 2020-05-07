package com.score.strategy;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public interface NameScoreStrategy {


    /**
     *
     * <p>
     * example
     * pre requisite
     * (A=1, B=2, C=3, etc...)     *
     * "LINDA -> 12 + 9 + 14 + 4 + 1 =  score 40
     * <p>
     * ASCII   A=65 , to get 1  for A = (65-64 )
     */

    default Function<? super String, Integer> calculateScore() {
        return name -> name.chars().reduce(0, (x, y) -> x + (y - 64) );
    }

    /**
     * returns function which manage index state, and multiply the index with score
     * example
     * [1, 4, 3] -> (1 * 1 ) + (2 * 4 ) + ( 3 * 3 ) -> 18
     */
    default ToIntFunction<? super Integer> multiplyWithScore() {
        final AtomicInteger index = new AtomicInteger(1);
        return score -> score * index.getAndIncrement();
    }

    /**
     * @return valid first-name or last-name or combination of both which can be used for score calculation ,
     * custom strategy class can override this.
     */
    default Function<String, String> extractName() {
        return name -> name.replaceAll("\"", "");
    }


}
