package edu.coursera.percolation;

import edu.coursera.percolation.Percolation;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PercolationTest {



    @Test
    public void test() {
        // numeration from 1
        /*

        0 0 0
        0 0 0
        0 0 0

         */
        Percolation percolation = new Percolation(3);

        assertThat(percolation.numberOfOpenSites()).isEqualTo(0);
        assertThat(percolation.isOpen(1, 1)).isEqualTo(false);
        assertThat(percolation.isFull(1, 1)).isEqualTo(false);
        assertThat(percolation.percolates()).isFalse();

        /*

        0 0 0
        0 1 0
        0 0 0

         */

        percolation.open(2, 2);
        assertThat(percolation.numberOfOpenSites()).isEqualTo(1);
        assertThat(percolation.isOpen(2, 2)).isTrue();
        assertThat(percolation.isFull(2, 2)).isFalse();
        assertThat(percolation.percolates()).isFalse();

       /*

        1 0 0
        0 1 0
        0 0 0

         */

        percolation.open(1, 1);
        assertThat(percolation.isOpen(1, 1)).isTrue();
        assertThat(percolation.isFull(1, 1)).isTrue();
        assertThat(percolation.percolates()).isFalse();


        /*

        1 1 0
        0 1 0
        0 0 0

         */

        percolation.open(1, 2);
        assertThat(percolation.isOpen(1, 2)).isTrue();
        assertThat(percolation.isFull(1, 2)).isTrue();
        assertThat(percolation.isFull(2, 2)).isTrue();
        assertThat(percolation.percolates()).isFalse();

        /*

        1 1 0
        0 1 1
        0 0 0

         */

        percolation.open(2, 3);
        assertThat(percolation.isOpen(2, 3)).isTrue();
        assertThat(percolation.isFull(2, 3)).isTrue();
        assertThat(percolation.percolates()).isFalse();

         /*

        1 1 0
        0 1 1
        0 0 1

         */

        percolation.open(3, 3);
        assertThat(percolation.isOpen(3, 3)).isTrue();
        assertThat(percolation.isFull(3, 3)).isTrue();
        assertThat(percolation.percolates()).isTrue();

    }

    @Test
    public void test3() {
        Percolation percolation = new Percolation(4);

        percolation.open(2, 4);
        percolation.open(2, 2);
        percolation.open(2, 1);
        percolation.open(4, 4);
        percolation.open(4, 3);
        percolation.open(3, 4);
        percolation.open(4, 1);
        percolation.open(3, 3);
        percolation.open(1, 3);

        System.out.println(percolation);

        assertThat(percolation.percolates()).isFalse();
    }

    @Test
    public void smallest() {
        Percolation percolation = new Percolation(1);

        assertThat(percolation.percolates()).isFalse();

    }

}