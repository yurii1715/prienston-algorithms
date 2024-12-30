package edu.coursera.wordnet;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SAPTest {

    public static final Digraph graph1 = new Digraph(12);

    static {
        graph1.addEdge(10, 9);
        graph1.addEdge(11, 9);

        graph1.addEdge(9, 5);
        graph1.addEdge(8, 5);
        graph1.addEdge(6, 3);
        graph1.addEdge(7, 3);


        graph1.addEdge(5, 1);
        graph1.addEdge(4, 1);
        graph1.addEdge(3, 1);

        graph1.addEdge(1, 0);
        graph1.addEdge(2, 0);
    }

    public static final Digraph graph2 = new Digraph(25);

    static {
        graph2.addEdge(24, 20);
        graph2.addEdge(23, 20);


        graph2.addEdge(24, 20);
        graph2.addEdge(23, 20);

        graph2.addEdge(13, 7);
        graph2.addEdge(14, 7);
        graph2.addEdge(15, 9);
        graph2.addEdge(16, 9);
        graph2.addEdge(17, 10);
        graph2.addEdge(18, 10);
        graph2.addEdge(19, 12);
        graph2.addEdge(20, 12);

        graph2.addEdge(7, 3);
        graph2.addEdge(8, 3);
        graph2.addEdge(9, 3);

        graph2.addEdge(10, 5);
        graph2.addEdge(11, 5);
        graph2.addEdge(12, 5);

        graph2.addEdge(3, 1);
        graph2.addEdge(4, 1);

        graph2.addEdge(5, 2);
        graph2.addEdge(6, 2);

        graph2.addEdge(2, 0);
        graph2.addEdge(1, 0);
    }

    @Test
    public void shouldFindLength() {
        SAP sap = new SAP(graph1);

        assertThat(sap.length(3, 10)).isEqualTo(4);
    }

    @Test
    public void shouldFindAncestor() {
        SAP sap = new SAP(graph1);

        assertThat(sap.ancestor(3, 10)).isEqualTo(1);
    }

    @Test
    public void shouldFindLengthForSet() {
        SAP sap = new SAP(graph2);

        assertThat(sap.length(List.of(13, 23, 24), List.of(6, 16, 17))).isEqualTo(4);
    }

    @Test
    public void shouldFindAncestorForSet() {
        SAP sap = new SAP(graph2);

        assertThat(sap.ancestor(List.of(13, 23, 24), List.of(6, 16, 17))).isEqualTo(3);
    }

    @Test
    public void shouldFindLengthDigraph3() {
        SAP sap = readFile("wordnet/digraph3.txt");
        assertThat(sap.length(10, 7)).isEqualTo(3);
    }

    @Test
    public void shouldFindLengthDigraph9() {
        SAP sap = readFile("wordnet/digraph9.txt");
        assertThat(sap.length(4, 7)).isEqualTo(3);
    }

    public SAP readFile(String fileName) {
        In in = new In(fileName);
        Digraph G = new Digraph(in);
        return new SAP(G);
    }
}