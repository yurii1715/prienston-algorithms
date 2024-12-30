package edu.coursera.collinear;

import edu.coursera.kdtree.PointSET;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class PointSETTest {

    public static Set<Point2D> TEST_DATA = Set.of(
            new Point2D(0.1, 0.1),
            new Point2D(0.1, 0.3),
            new Point2D(0.4, 0.1),
            new Point2D(0.6, 0.5),
            new Point2D(0.5, 0.8),
            new Point2D(0.1, 0.9)
    );

    @Test
    public void shouldFindNearest() {
        PointSET pointSET = new PointSET();
        TEST_DATA.forEach(pointSET::insert);

        assertThat(pointSET.nearest(new Point2D(0.3, 0.3))).isEqualTo(new Point2D(0.1, 0.3));
    }

    @Test
    public void shouldFindNearest_1() {
        PointSET pointSET = new PointSET();
        TEST_DATA.forEach(pointSET::insert);

        assertThat(pointSET.nearest(new Point2D(0.3, 0.65))).isEqualTo(new Point2D(0.5, 0.8));
    }

    @Test
    public void shouldRange() {
        PointSET pointSET = new PointSET();
        TEST_DATA.forEach(pointSET::insert);

        RectHV rectHV = new RectHV(0.05, 0.05, 0.5, 0.6);

        assertThat(pointSET.range(rectHV)).containsExactlyInAnyOrder(
                new Point2D(0.1, 0.1),
                new Point2D(0.1, 0.3),
                new Point2D(0.4, 0.1));
    }

}