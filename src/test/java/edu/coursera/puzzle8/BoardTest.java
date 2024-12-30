package edu.coursera.puzzle8;

import edu.coursera.puzzle8.Board;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    @Test
    public void testToString() {
        int b[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Board board = new Board(b);

        System.out.println(board);
    }

    @Test
    public void hammingTest_random() {
        int b[][] = new int[][]{{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
        Board board = new Board(b);

        assertThat(board.hamming()).isEqualTo(5);
    }

    @Test
    public void hammingTest_goalBord() {
        int b[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Board board = new Board(b);

        assertThat(board.hamming()).isEqualTo(0);
    }

    @Test
    public void manhattanTest_random() {
        int b[][] = new int[][]{{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
        Board board = new Board(b);

        assertThat(board.manhattan()).isEqualTo(10);
    }

    @Test
    public void manhattanTest_goalBord() {
        int b[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Board board = new Board(b);

        assertThat(board.manhattan()).isEqualTo(0);
    }

    @Test
    public void twin_zero00() {
        int b[][] = new int[][]{{0, 2}, {3, 1}};
        int expectedB[][] = new int[][]{{0, 1}, {3, 2}};

        Board board = new Board(b);
        Board expectedBoard = new Board(expectedB);

        assertThat(board.twin()).isEqualTo(expectedBoard);
    }

    @Test
    public void twin_zero01() {
        int b[][] = new int[][]{{1, 0}, {3, 2}};
        int expectedB[][] = new int[][]{{3, 0}, {1, 2}};

        Board board = new Board(b);
        Board expectedBoard = new Board(expectedB);

        assertThat(board.twin()).isEqualTo(expectedBoard);
    }

    @Test
    public void twin_zero10() {
        int b[][] = new int[][]{{1, 3}, {0, 2}};
        int expectedB[][] = new int[][]{{3, 1}, {0, 2}};

        Board board = new Board(b);
        Board expectedBoard = new Board(expectedB);

        assertThat(board.twin()).isEqualTo(expectedBoard);
    }

    @Test
    public void twin_zero11() {
        int b[][] = new int[][]{{1, 3}, {2, 0}};
        int expectedB[][] = new int[][]{{3, 1}, {2, 0}};

        Board board = new Board(b);
        Board expectedBoard = new Board(expectedB);

        assertThat(board.twin()).isEqualTo(expectedBoard);
    }

    @Test
    public void testNeighbors_zeroMiddle() {
        int b[][] = new int[][]{
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 5}};

        int expected1[][] = new int[][]{
                {1, 0, 3},
                {4, 2, 6},
                {7, 8, 5}};

        int expected2[][] = new int[][]{
                {1, 2, 3},
                {4, 6, 0},
                {7, 8, 5}};

        int expected3[][] = new int[][]{
                {1, 2, 3},
                {4, 8, 6},
                {7, 0, 5}};

        int expected4[][] = new int[][]{
                {1, 2, 3},
                {0, 4, 6},
                {7, 8, 5}};

        Board board = new Board(b);

        List<Board> expectedNeighbors = Stream.of(expected1, expected2, expected3, expected4)
                .map(Board::new).toList();

        assertThat(board.neighbors()).containsExactlyInAnyOrderElementsOf(expectedNeighbors);
    }

    @Test
    public void testNeighbors_zeroUp() {
        int b[][] = new int[][]{
                {1, 0, 3},
                {4, 2, 6},
                {7, 8, 5}};

        int expected1[][] = new int[][]{
                {0, 1, 3},
                {4, 2, 6},
                {7, 8, 5}};

        int expected2[][] = new int[][]{
                {1, 3, 0},
                {4, 2, 6},
                {7, 8, 5}};

        int expected3[][] = new int[][]{
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 5}};

        Board board = new Board(b);

        List<Board> expectedNeighbors = Stream.of(expected1, expected2, expected3)
                .map(Board::new).toList();

        assertThat(board.neighbors()).containsExactlyInAnyOrderElementsOf(expectedNeighbors);
    }

    @Test
    public void testNeighbors_zeroUpLeftCorner() {
        int b[][] = new int[][]{
                {0, 1, 3},
                {4, 2, 6},
                {7, 8, 5}};

        int expected1[][] = new int[][]{
                {1, 0, 3},
                {4, 2, 6},
                {7, 8, 5}};

        int expected2[][] = new int[][]{
                {4, 1, 3},
                {0, 2, 6},
                {7, 8, 5}};

        Board board = new Board(b);

        List<Board> expectedNeighbors = Stream.of(expected1, expected2)
                .map(Board::new).toList();

        assertThat(board.neighbors()).containsExactlyInAnyOrderElementsOf(expectedNeighbors);
    }

    @Test
    public void manhattanTest_2x2() {
        int b[][] = new int[][]{{1, 3}, {2, 0}};
        Board board = new Board(b);

        assertThat(board.manhattan()).isEqualTo(4);
    }
}