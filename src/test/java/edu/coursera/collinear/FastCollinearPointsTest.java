package edu.coursera.collinear;

import edu.coursera.collinear.FastCollinearPoints;
import edu.coursera.collinear.LineSegment;
import edu.coursera.collinear.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FastCollinearPointsTest {

    @Test
    public void randomPoints() {
        Point[] points = Arrays.asList(
                        new Point(1, 3),
                        new Point(14, 17),
                        new Point(-8, 0),
                        new Point(53, 53),
                        new Point(99, 99),
                        new Point(88, 88))
                .toArray(new Point[0]);

        FastCollinearPoints FastCollinearPoints = new FastCollinearPoints(points);
        assertThat(FastCollinearPoints.numberOfSegments()).isEqualTo(0);
        assertThat(FastCollinearPoints.segments().length).isEqualTo(0);
    }

    @Test
    public void easiestOne() {
        Point[] points = Arrays.asList(
                        new Point(99, 99),
                        new Point(88, 88),
                        new Point(-1, -1),
                        new Point(123, 123))
                .toArray(new Point[0]);

        FastCollinearPoints FastCollinearPoints = new FastCollinearPoints(points);
        assertThat(FastCollinearPoints.numberOfSegments()).isEqualTo(1);
        assertThat(FastCollinearPoints.segments().length).isEqualTo(1);

        LineSegment s = FastCollinearPoints.segments()[0];
        assertThat(s.toString()).isEqualTo("(-1, -1) -> (123, 123)");
    }

    @Test
    public void twoSegments() {
        Point[] points = Arrays.asList(
                        new Point(99, 99),
                        new Point(88, 88),
                        new Point(-1, -1),
                        new Point(123, 123),
                        new Point(2, -1),
                        new Point(3, -1),
                        new Point(4, -1))
                .toArray(new Point[0]);

        FastCollinearPoints FastCollinearPoints = new FastCollinearPoints(points);
        assertThat(FastCollinearPoints.numberOfSegments()).isEqualTo(2);
        assertThat(FastCollinearPoints.segments().length).isEqualTo(2);

        List<String> sLists =
                Arrays.stream(FastCollinearPoints.segments())
                        .map(LineSegment::toString)
                        .toList();

        assertThat(sLists).containsExactlyInAnyOrder("(-1, -1) -> (123, 123)", "(-1, -1) -> (4, -1)");
    }

    @Test
    public void twoSegments_input6() {
        Point[] points = Arrays.asList(
                        new Point(19000, 10000),
                        new Point(18000, 10000),
                        new Point(32000, 10000),
                        new Point(21000, 10000),
                        new Point(1234, 5678),
                        new Point(14000, 10000))
                .toArray(new Point[0]);

        FastCollinearPoints FastCollinearPoints = new FastCollinearPoints(points);
        assertThat(FastCollinearPoints.numberOfSegments()).isEqualTo(1);
        assertThat(FastCollinearPoints.segments().length).isEqualTo(1);

        List<String> sLists =
                Arrays.stream(FastCollinearPoints.segments())
                        .map(LineSegment::toString)
                        .toList();

        assertThat(sLists).containsExactlyInAnyOrder("(14000, 10000) -> (32000, 10000)");
    }

    @Test
    public void twoSegments_input8() {
        Point[] points = Arrays.asList(
                        new Point(10000, 0),
                        new Point(0, 10000),
                        new Point(3000, 7000),
                        new Point(7000, 3000),
                        new Point(20000, 21000),
                        new Point(3000, 4000),
                        new Point(14000, 15000),
                        new Point(6000, 7000))
                .toArray(new Point[0]);

        FastCollinearPoints FastCollinearPoints = new FastCollinearPoints(points);
        assertThat(FastCollinearPoints.numberOfSegments()).isEqualTo(2);
        assertThat(FastCollinearPoints.segments().length).isEqualTo(2);

        List<String> sLists =
                Arrays.stream(FastCollinearPoints.segments())
                        .map(LineSegment::toString)
                        .toList();

        assertThat(sLists).containsExactlyInAnyOrder("(3000, 4000) -> (20000, 21000)",
                "(10000, 0) -> (0, 10000)");
    }

}