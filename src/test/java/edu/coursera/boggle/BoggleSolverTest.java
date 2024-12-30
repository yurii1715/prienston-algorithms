package edu.coursera.boggle;

import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class BoggleSolverTest {

//    @Test
//    public void shouldLoadDictionary() {
//        edu.coursera.boggle.BoggleSolver boggleSolver = createBoggleSolver("dictionary-nursery.txt");
//        assertThat(boggleSolver.trie.contains("LAUGHED")).isTrue();
//        assertThat(boggleSolver.trie.contains("HUITA")).isFalse();
//        assertThat(boggleSolver.trie.contains("PENKNIFE")).isTrue();
//    }

    @Test
    public void shouldCountScore() {
        BoggleSolver boggleSolver = createBoggleSolver("dictionary-nursery.txt");

        assertThat(boggleSolver.scoreOf("HUITA")).isZero();
        assertThat(boggleSolver.scoreOf("AN")).isZero();
        assertThat(boggleSolver.scoreOf("AND")).isEqualTo(1);
        assertThat(boggleSolver.scoreOf("AGOG")).isEqualTo(1);
        assertThat(boggleSolver.scoreOf("AGAIN")).isEqualTo(2);
        assertThat(boggleSolver.scoreOf("ADMIRE")).isEqualTo(3);
        assertThat(boggleSolver.scoreOf("AGAINST")).isEqualTo(5);
        assertThat(boggleSolver.scoreOf("ALEHOUSE")).isEqualTo(11);
        assertThat(boggleSolver.scoreOf("BELLEISLE")).isEqualTo(11);
        assertThat(boggleSolver.scoreOf("CATERPILLARS")).isEqualTo(11);
    }

    @Test
    public void shouldFindWords() {
        BoggleSolver boggleSolver = createBoggleSolver("dictionary-common.txt");
        BoggleBoard board = new BoggleBoard("board-points26539.txt");

        HashSet<String> words = (HashSet<String>) boggleSolver.getAllValidWords(board);
        assertThat(words).hasSize(792);
    }

    @Test
    public void shouldCorrectHandleQuCase() {
        BoggleSolver boggleSolver = createBoggleSolver("dictionary-16q.txt");
        BoggleBoard board = new BoggleBoard("board-16q.txt");

        HashSet<String> words = (HashSet<String>) boggleSolver.getAllValidWords(board);
        assertThat(words).hasSize(15);
        assertThat(words).contains("QUQUQU");
    }

    private static BoggleSolver createBoggleSolver(String filename) {
        In in = new In(filename);
        String[] allLines = in.readAllLines();

        BoggleSolver boggleSolver = new BoggleSolver(allLines);
        return boggleSolver;
    }

}