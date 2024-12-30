package edu.coursera.collinear;

import edu.coursera.collinear.BruteCollinearPoints;
import edu.coursera.collinear.LineSegment;
import edu.coursera.collinear.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BruteCollinearPointsTest {

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

        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
        assertThat(bruteCollinearPoints.numberOfSegments()).isEqualTo(0);
        assertThat(bruteCollinearPoints.segments().length).isEqualTo(0);
    }

    @Test
    public void easiestOne() {
        Point[] points = Arrays.asList(
                        new Point(99, 99),
                        new Point(88, 88),
                        new Point(-1, -1),
                        new Point(123, 123))
                .toArray(new Point[0]);

        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
        assertThat(bruteCollinearPoints.numberOfSegments()).isEqualTo(1);
        assertThat(bruteCollinearPoints.segments().length).isEqualTo(1);

        LineSegment s = bruteCollinearPoints.segments()[0];
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

        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
        assertThat(bruteCollinearPoints.numberOfSegments()).isEqualTo(2);
        assertThat(bruteCollinearPoints.segments().length).isEqualTo(2);

        List<String> sLists =
                Arrays.stream(bruteCollinearPoints.segments())
                        .map(LineSegment::toString)
                        .toList();

        assertThat(sLists).containsExactlyInAnyOrder("(-1, -1) -> (123, 123)", "(-1, -1) -> (4, -1)");
    }

}