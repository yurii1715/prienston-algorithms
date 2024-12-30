package edu.coursera.collinear;

import edu.coursera.collinear.Point;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {


    @Test
    void slopeTo() {
        Point p1 = new Point(4, 6);
        Point p2 = new Point(2, 2);

        assertThat(p2.slopeTo(p1)).isEqualTo(2.0);
    }

    @Test
    void slopeTo_horizontalLine_zero() {
        Point p1 = new Point(4, 4);
        Point p2 = new Point(2, 4);

        assertThat(p2.slopeTo(p1)).isEqualTo(0);
    }

    @Test
    void slopeTo_verticalLine_infinity() {
        Point p1 = new Point(4, 4);
        Point p2 = new Point(4, 2);

        assertThat(p2.slopeTo(p1)).isEqualTo(Double.POSITIVE_INFINITY);
    }

    @Test
    void slopeTo_degenerateSegment_negativeInfinity() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);

        assertThat(p2.slopeTo(p1)).isEqualTo(Double.NEGATIVE_INFINITY);
    }

    @Test
    public void slopeOrder() {
        Point p0 = new Point(2, 2);
        Point p1 = new Point(3, 4);
        Point p2 = new Point(4, 3);

        Comparator<Point> comparator = p0.slopeOrder();

        assertThat(comparator.compare(p1, p2)).isEqualTo(1);
        assertThat(comparator.compare(p2, p1)).isEqualTo(-1);
    }

    @Test
    public void slopeOrder_infinityVs0() {
        Point p0 = new Point(2, 2);
        Point p1 = new Point(2, 4);
        Point p2 = new Point(4, 2);

        Comparator<Point> comparator = p0.slopeOrder();

        assertThat(comparator.compare(p1, p2)).isEqualTo(1);
        assertThat(comparator.compare(p2, p1)).isEqualTo(-1);
    }

    @Test
    public void slopeOrder_degenerateVs0() {
        Point p0 = new Point(2, 2);
        Point p1 = new Point(2, 2);
        Point p2 = new Point(4, 2);

        Comparator<Point> comparator = p0.slopeOrder();

        assertThat(comparator.compare(p1, p2)).isEqualTo(-1);
        assertThat(comparator.compare(p2, p1)).isEqualTo(1);
    }

    @Test
    public void slopeOrder_samePoints() {
        Point p0 = new Point(2, 2);
        Point p1 = new Point(2, 3);
        Point p2 = new Point(2, 3);

        Comparator<Point> comparator = p0.slopeOrder();

        assertThat(comparator.compare(p1, p2)).isEqualTo(0);
        assertThat(comparator.compare(p2, p1)).isEqualTo(0);
    }

    @Test
    public void test() {
        Point p0 = new Point(57, 132);
        Point p1 = new Point(34, 99);

        assertThat(p0.slopeTo(p1)).isEqualTo(p1.slopeTo(p0));
    }

    @Test
    public void test1() {
        Point p0 = new Point(1, 2);
        Point p1 = new Point(2, 1);

        assertThat(p0.slopeTo(p1)).isEqualTo(p1.slopeTo(p0));
    }

    @Test
    public void test2() {
        Point p0 = new Point(-1, -2);
        Point p1 = new Point(-2, -1);

        assertThat(p0.slopeTo(p1)).isEqualTo(p1.slopeTo(p0));
    }
}