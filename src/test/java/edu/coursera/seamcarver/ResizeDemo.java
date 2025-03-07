package edu.coursera.seamcarver; /******************************************************************************
 *  Compilation:  javac edu.coursera.seamcarver.ResizeDemo.java
 *  Execution:    java edu.coursera.seamcarver.ResizeDemo input.png columnsToRemove rowsToRemove
 *  Dependencies: edu.coursera.seamcaver.SeamCarver.java SCUtility.java
 *                
 *
 *  Read image from file specified as command line argument. Use edu.coursera.seamcaver.SeamCarver
 *  to remove number of rows and columns specified as command line arguments.
 *  Show the images and print time elapsed to screen.
 *
 ******************************************************************************/

import edu.coursera.seamcaver.SeamCarver;
import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class ResizeDemo {
    public static void main(String[] args) {
        Picture inputImg = new Picture("seamcarver/marginal.jpeg");
        int removeColumns = 200;
        int removeRows = 2;

        StdOut.printf("image is %d columns by %d rows\n", inputImg.width(), inputImg.height());
        SeamCarver sc = new SeamCarver(inputImg);

        Stopwatch sw = new Stopwatch();

        for (int i = 0; i < removeRows; i++) {
            int[] horizontalSeam = sc.findHorizontalSeam();
            sc.removeHorizontalSeam(horizontalSeam);
        }

        for (int i = 0; i < removeColumns; i++) {
            int[] verticalSeam = sc.findVerticalSeam();
            sc.removeVerticalSeam(verticalSeam);
        }
        Picture outputImg = sc.picture();

        StdOut.printf("new image size is %d columns by %d rows\n", sc.width(), sc.height());

        StdOut.println("Resizing time: " + sw.elapsedTime() + " seconds.");
        inputImg.show();
        outputImg.show();
    }
    
}
