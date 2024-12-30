package edu.coursera.kdtree;

import edu.coursera.kdtree.KdTree;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class KdTreeTest {

    Point2D p1 =  new Point2D(.7, .2);
    Point2D p2 = new Point2D(.5, .4);
    Point2D p3 = new Point2D(.2, .3);
    Point2D p4 = new Point2D(.4, .7);
    Point2D p5 = new Point2D(.9, .6);


    /*
                  p1
            p2         p5
        p3     p4
     */
    public List<Point2D> TEST_DATA_1 = List.of(
           p1, p2, p3, p4, p5
    );

    public static Set<Point2D> TEST_DATA_2 = Set.of(
            new Point2D(0.1, 0.1),
            new Point2D(0.1, 0.3),
            new Point2D(0.4, 0.1),
            new Point2D(0.6, 0.5),
            new Point2D(0.5, 0.8),
            new Point2D(0.1, 0.9)
    );

//    @Test
//    public void shouldInsert() {
//        edu.coursera.kdtree.KdTree tree = new edu.coursera.kdtree.KdTree();
//
//        TEST_DATA_1.forEach(tree::insert);
//
//        // Verify p1
//        edu.coursera.kdtree.KdTree.KdNode p1Node = tree.root;
//        assertThat(p1Node.point).isEqualTo(p1);
//
//        // Verify p2
//        edu.coursera.kdtree.KdTree.KdNode p2Node = p1Node.left;
//        assertThat(p2Node.point).isEqualTo(p2);
//
//        // Verify p3
//        edu.coursera.kdtree.KdTree.KdNode p3Node = p2Node.left;
//        assertThat(p3Node.point).isEqualTo(p3);
//
//        // Verify p4
//        edu.coursera.kdtree.KdTree.KdNode p4Node = p2Node.right;
//        assertThat(p4Node.point).isEqualTo(p4);
//
//        // Verify p5
//        edu.coursera.kdtree.KdTree.KdNode p5Node = p1Node.right;
//        assertThat(p5Node.point).isEqualTo(p5);
//    }


    @Test
    public void shouldContainsInserted() {
        KdTree kdTree = new KdTree();
        TEST_DATA_2.forEach(kdTree::insert);

        Point2D[] testData = TEST_DATA_2.toArray(new Point2D[0]);
        Arrays.sort(testData, Comparator.comparing((a) -> Math.random()));

        Arrays.stream(testData).forEach(point
                -> assertThat(kdTree.contains(point)).isTrue());
    }

    @Test
    public void shouldFindNearest() {
        KdTree KdTree = new KdTree();
        TEST_DATA_2.forEach(KdTree::insert);

        assertThat(KdTree.nearest(new Point2D(0.3, 0.3))).isEqualTo(new Point2D(0.1, 0.3));
    }

    @Test
    public void shouldFindNearest_1() {
        KdTree KdTree = new KdTree();
        TEST_DATA_2.forEach(KdTree::insert);

        assertThat(KdTree.nearest(new Point2D(0.3, 0.65))).isEqualTo(new Point2D(0.5, 0.8));
    }

    @Test
    public void shouldRange() {
        KdTree KdTree = new KdTree();
        TEST_DATA_2.forEach(KdTree::insert);

        RectHV rectHV = new RectHV(0.05, 0.05, 0.5, 0.6);

        assertThat(KdTree.range(rectHV)).containsExactlyInAnyOrder(
                new Point2D(0.1, 0.1),
                new Point2D(0.1, 0.3),
                new Point2D(0.4, 0.1));
    }

    @Test
    public void rangeTest() {
        KdTree kdTree = new KdTree();

        kdTree.insert(new Point2D(.7, .2));
        kdTree.insert(new Point2D(.5, .4));
        kdTree.insert(new Point2D(.2, .3));
        kdTree.insert(new Point2D(.4, .7));
        kdTree.insert(new Point2D(.9, .6));

        assertThat(kdTree.range(new RectHV(0.164,  0.158, 0.234, 0.417)))
                .containsExactlyInAnyOrder(new Point2D(.2, .3));
    }
}