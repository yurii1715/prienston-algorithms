package edu.coursera.puzzle8;

import edu.coursera.puzzle8.Board;
import edu.coursera.puzzle8.Solver;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolverTest {

    @Test
    public void test() {

        int b[][] = new int[][]{
                {0, 1, 3},
                {4, 2, 5},
                {7, 8, 6}};

        Solver solver = new Solver(new Board(b));

        solver.solution()
                .forEach(System.out::println);

        assertThat(solver.isSolvable()).isTrue();
        assertThat(solver.moves()).isEqualTo(4);
    }

    @Test
    public void test_1() {

        int b[][] = new int[][]{
                {6, 0, 5},
                {8, 7, 4},
                {3, 2, 1}};

        Solver solver = new Solver(new Board(b));

        solver.solution()
                .forEach(System.out::println);

        assertThat(solver.isSolvable()).isTrue();
        assertThat(solver.moves()).isEqualTo(29);
    }

    @Test
    public void test4x4() {
        int b[][] = new int[][]{
                {0, 9, 1, 10},
                {3, 5, 4, 2},
                {14, 6, 11, 7},
                {12, 13, 8, 15}};

        Solver solver = new Solver(new Board(b));

        solver.solution()
                .forEach(System.out::println);
    }

    @Test
    public void test4x4_1() {
        int b[][] = new int[][]{
                {2, 9, 3, 5},
                {8, 11, 12, 7},
                {15, 4, 0, 13},
                {6, 1, 10, 14}};

        Solver solver = new Solver(new Board(b));

        solver.solution()
                .forEach(System.out::println);
    }

    @Test
    public void test_unsolvable() {

        int b[][] = new int[][]{
                {0, 1, 3},
                {4, 2, 5},
                {7, 6, 8}};

        Solver solver = new Solver(new Board(b));

        assertThat(solver.isSolvable()).isFalse();
        assertThat(solver.moves()).isEqualTo(-1);
        assertThat(solver.solution()).isEqualTo(null);
    }
}