package edu.coursera.seamcarver;

import edu.coursera.seamcaver.SeamCarver;
import edu.princeton.cs.algs4.Picture;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeamCarverSeamTest {

    @Test
    public void shouldCreateVerticaSeam4x6() {
        String fileName = "seamcarver/4x6.png";
        int[] expectedResult = new int[]{1, 2, 1, 1, 2, 1};
        assertVerticalSeam(fileName, expectedResult);
    }

    @Test
    public void shouldCreateVerticaSeam5x6() {
        String fileName = "seamcarver/5x6.png";
        int[] expectedResult = new int[]{1, 2, 2, 3, 2, 1};
        assertVerticalSeam(fileName, expectedResult);
    }

    @Test
    public void shouldCreateVerticaSeam6x5() {
        String fileName = "seamcarver/6x5.png";
        int[] expectedResult = new int[]{3, 4, 3, 2, 1};
        assertVerticalSeam(fileName, expectedResult);
    }

    @Test
    public void shouldCreateVerticaSeam7x3() {
        String fileName = "seamcarver/7x3.png";
        int[] expectedResult = new int[]{2, 3, 2};
        assertVerticalSeam(fileName, expectedResult);
    }

    @Test
    public void shouldCreateVerticaSeam7x10() {
        String fileName = "seamcarver/7x10.png";
        int[] expectedResult = new int[]{2, 3, 4, 3, 4, 3, 3, 2, 2, 1};
        assertVerticalSeam(fileName, expectedResult);
    }

    @Test
    public void shouldCreateVerticaSeam10x10() {
        String fileName = "seamcarver/10x10.png";
        int[] expectedResult = new int[]{6, 7, 7, 7, 7, 7, 8, 8, 7, 6};
        assertVerticalSeam(fileName, expectedResult);
    }

    @Test
    public void shouldCreateVerticaSeam10x12() {
        String fileName = "seamcarver/10x12.png";
        int[] expectedResult = new int[]{5, 6, 7, 8, 7, 7, 6, 7, 6, 5, 6, 5};
        assertVerticalSeam(fileName, expectedResult);
    }

    @Test
    public void shouldCreateVerticaSeam12x10() {
        String fileName = "seamcarver/12x10.png";
        int[] expectedResult = new int[]{6, 7, 7, 6, 6, 7, 7, 7, 8, 7};
        assertVerticalSeam(fileName, expectedResult);
    }

    @Test
    public void shouldCreateHorizontalSeam12x10() {
        String fileName = "seamcarver/12x10.png";
        int[] expectedResult = new int[]{7, 8, 7, 8, 7, 6, 5, 6, 6, 5, 4, 3};
        assertHorizontalSeam(fileName, expectedResult);
    }

    @Test
    public void shouldCreateHorizontalSeam4x6() {
        String fileName = "seamcarver/4x6.png";
        int[] expectedResult = new int[]{1, 2, 1, 0};
        assertHorizontalSeam(fileName, expectedResult);
    }

    private void assertVerticalSeam(String fileName, int[] expectedResult) {
        var picture = new Picture(fileName);

        var seamCarver = new SeamCarver(picture);

        var verticalSeam = seamCarver.findVerticalSeam();

        assertThat(verticalSeam).containsExactly(expectedResult);
    }

    private void assertHorizontalSeam(String fileName, int[] expectedResult) {
        var picture = new Picture(fileName);

        var seamCarver = new SeamCarver(picture);

        var horizontalSeam = seamCarver.findHorizontalSeam();

        assertThat(horizontalSeam).containsExactly(expectedResult);
    }

}
