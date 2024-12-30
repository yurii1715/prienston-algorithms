package edu.coursera.percolation;

import edu.coursera.percolation.PercolationStats;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PercolationStatsTest {

    PercolationStats percolationStats;

    @Test
    public void test() {
        percolationStats = new PercolationStats(10, 3);
    }

    @Test
    public void test1() {
        percolationStats = new PercolationStats(4, 1);
    }
}