package edu.coursera.seamcarver;

import edu.coursera.seamcaver.SeamCarver;
import edu.princeton.cs.algs4.Picture;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static edu.coursera.seamcaver.SeamCarver.BORDER_CELL_ENERGY;
import static org.assertj.core.api.Assertions.assertThat;

class SeamCarverTest {

    Picture threeFour = new Picture(3, 4);

    {
        threeFour.set(0, 0, new Color(225, 101, 51));
        threeFour.set(1, 0, new Color(225, 101, 153));
        threeFour.set(2, 0, new Color(225, 101, 255));

        threeFour.set(0, 1, new Color(225, 153, 51));
        threeFour.set(1, 1, new Color(225, 153, 153));
        threeFour.set(2, 1, new Color(225, 153, 255));

        threeFour.set(0, 2, new Color(225, 203, 51));
        threeFour.set(1, 2, new Color(225, 204, 153));
        threeFour.set(2, 2, new Color(225, 205, 255));

        threeFour.set(0, 3, new Color(225, 255, 51));
        threeFour.set(1, 3, new Color(225, 255, 153));
        threeFour.set(2, 3, new Color(225, 255, 255));
    }

    @Test
    public void shouldComputeBorderEnergy() {
        SeamCarver seamCarver = new SeamCarver(threeFour);

        assertBorderEnergy(seamCarver, 0, 0);
        assertBorderEnergy(seamCarver, 1, 0);
        assertBorderEnergy(seamCarver, 2, 0);

        assertBorderEnergy(seamCarver, 0, 1);
        assertBorderEnergy(seamCarver, 2, 1);

        assertBorderEnergy(seamCarver, 0, 2);
        assertBorderEnergy(seamCarver, 2, 2);

        assertBorderEnergy(seamCarver, 0, 3);
        assertBorderEnergy(seamCarver, 1, 3);
        assertBorderEnergy(seamCarver, 2, 3);
    }

    @Test
    public void shouldComputeInsideCellsEnergy() {
        SeamCarver seamCarver = new SeamCarver(threeFour);

        assertHasEnergy(seamCarver, 1, 2, Math.sqrt(52024));
        assertHasEnergy(seamCarver, 1, 1, Math.sqrt(52225));
    }

    @Test
    public void shouldRemoveVerticalSeam() {
        SeamCarver seamCarver = new SeamCarver(threeFour);

        var seamToRemove = new int[]{0, 1, 2, 1};
        seamCarver.removeVerticalSeam(seamToRemove);

        Picture newPicture = seamCarver.picture();

        assertThat(newPicture.width()).isEqualTo(threeFour.width() - 1);
        assertThat(newPicture.height()).isEqualTo(threeFour.height());

        assertCellEquals(newPicture, 1, 0, 0, 0);
        assertCellEquals(newPicture, 2, 1, 0, 0);

        assertCellEquals(newPicture, 0, 0, 1, 1);
        assertCellEquals(newPicture, 2, 1, 1, 1);

        assertCellEquals(newPicture, 0, 0, 2, 2);
        assertCellEquals(newPicture, 1, 1, 2, 2);

        assertCellEquals(newPicture, 0, 0, 3, 3);
        assertCellEquals(newPicture, 2, 1, 3, 3);
    }

    @Test
    public void shouldRemoveHorizontalSeam() {
        SeamCarver seamCarver = new SeamCarver(threeFour);

        var seamToRemove = new int[]{1, 2, 3};
        seamCarver.removeHorizontalSeam(seamToRemove);

        Picture newPicture = seamCarver.picture();

        assertThat(newPicture.width()).isEqualTo(threeFour.width());
        assertThat(newPicture.height()).isEqualTo(threeFour.height() - 1);

        assertCellEquals(newPicture, 0, 0, 0, 0);
        assertCellEquals(newPicture, 0, 0, 2, 1);
        assertCellEquals(newPicture, 0, 0, 3, 2);

        assertCellEquals(newPicture, 1, 1, 0, 0);
        assertCellEquals(newPicture, 1, 1, 1, 1);
        assertCellEquals(newPicture, 1, 1, 3, 2);

        assertCellEquals(newPicture, 2, 2, 0, 0);
        assertCellEquals(newPicture, 2, 2, 1, 1);
        assertCellEquals(newPicture, 2, 2, 2, 2);
    }

    private void assertCellEquals(Picture newPicture, int oldCol, int newCol, int oldRow, int newRow) {
        assertThat(newPicture.get(newCol, newRow)).isEqualTo(threeFour.get(oldCol, oldRow));
    }

    private static void assertBorderEnergy(SeamCarver seamCarver, int col, int row) {
        assertHasEnergy(seamCarver, col, row, BORDER_CELL_ENERGY);
    }

    private static void assertHasEnergy(SeamCarver seamCarver, int col, int row, double borderCellEnergy) {
        assertThat(seamCarver.energy(col, row)).isEqualTo(borderCellEnergy);
    }

}