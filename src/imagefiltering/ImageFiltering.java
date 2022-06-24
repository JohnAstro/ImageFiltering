/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package imagefiltering;

import java.awt.image.BufferedImage;

/**
 *
 * @author jonat
 */
public class ImageFiltering {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         // 1- Read an image:
        BufferedImage inImage = ImageIo.readImage("UTB.jpg");
        ImageIo.getBufferedImageType(inImage,"Main-Example-01: InImage");
        
        // get rgb byteData
        Object[] byteArrays = ImageIo.getColorByteImageArray2DFromBufferedImage(inImage);
        byte[][] rByteData = (byte[][]) byteArrays[0];
        byte[][] gByteData = (byte[][]) byteArrays[1];
        byte[][] bByteData = (byte[][]) byteArrays[2];
        
        
        // 2- Convert to Gray (3-channels go to one)
        BufferedImage grayImage = ImageIo.toGray(inImage);
        ImageIo.writeImage(grayImage, "jpg", "UTB-gray.jpg"); 
        
        //3 Extract 2-d byte arrays
        //Get 1 array
        byte[][] byteData = ImageIo.getGrayByteImageArray2DFromBufferedImage(grayImage);
        
        // processing...
        Noise noiseGenerator = new Noise();
        Filter fltr = new Filter();
        
        // Median filtering
        // get salt and pepper images
        byte[][] outputNoisy10 = new byte[byteData.length][byteData[0].length];
        noiseGenerator.addGrayNoiseSaltAndPepper(byteData, outputNoisy10, 0.10f);
        
        byte[][] outputNoisy15 = new byte[byteData.length][byteData[0].length];
        noiseGenerator.addGrayNoiseSaltAndPepper(byteData, outputNoisy15, 0.15f);
        
        byte[][] outputNoisy20 = new byte[byteData.length][byteData[0].length];
        noiseGenerator.addGrayNoiseSaltAndPepper(byteData, outputNoisy20, 0.20f);
        
        // write salt and pepper images
        BufferedImage outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputNoisy10);
        ImageIo.writeImage(outimage, "jpg", "UTB_saltPepper10.jpg");
        
        outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputNoisy15);
        ImageIo.writeImage(outimage, "jpg", "UTB_saltPepper15.jpg");
        
        outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputNoisy20);
        ImageIo.writeImage(outimage, "jpg", "UTB_saltPepper20.jpg");
        
        
//        // get salt and pepper rgb
//        byte[][] routputNoisy10 = new byte[byteData.length][byteData[0].length];
//        byte[][] goutputNoisy10 = new byte[byteData.length][byteData[0].length];
//        byte[][] boutputNoisy10 = new byte[byteData.length][byteData[0].length];
//        noiseGenerator.addColorNoiseSaltAndPepper(rByteData, gByteData, bByteData, routputNoisy10, goutputNoisy10, boutputNoisy10, 0.10f);
//        
//        // write image
//        BufferedImage outimageColor = ImageIo.setColorByteImageArray2DToBufferedImage(routputNoisy10, goutputNoisy10, boutputNoisy10);
//        ImageIo.writeImage(outimageColor, "jpg", "UTB_color_saltPepper_10.jpg");
        
        
        // filter noise images 3x3
        byte[][] outputMedian3x3_10 = new byte [byteData.length][byteData[0].length];
        fltr.mean(outputNoisy10, outputMedian3x3_10, 3);
        
        byte[][] outputMedian3x3_15 = new byte [byteData.length][byteData[0].length];
        fltr.mean(outputNoisy15, outputMedian3x3_15, 3);
        
        byte[][] outputMedian3x3_20 = new byte [byteData.length][byteData[0].length];
        fltr.mean(outputNoisy20, outputMedian3x3_20, 3);
        
        // write filtered images 3x3
        outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputMedian3x3_10);
        ImageIo.writeImage(outimage, "jpg", "UTB_saltPepperFilterd_3x3_0.10.jpg");
        
        outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputMedian3x3_15);
        ImageIo.writeImage(outimage, "jpg", "UTB_saltPepperFilterd_3x3_0.15.jpg");
        
        outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputMedian3x3_20);
        ImageIo.writeImage(outimage, "jpg", "UTB_saltPepperFilterd_3x3_0.20.jpg");
        
        
        // filter noise images 5x5
        byte[][] outputMedian5x5_10 = new byte [byteData.length][byteData[0].length];
        fltr.mean(outputNoisy10, outputMedian5x5_10, 5);
        
        byte[][] outputMedian5x5_15 = new byte [byteData.length][byteData[0].length];
        fltr.mean(outputNoisy15, outputMedian5x5_15, 5);
        
        byte[][] outputMedian5x5_20 = new byte [byteData.length][byteData[0].length];
        fltr.mean(outputNoisy20, outputMedian5x5_20, 5);
        
        // write filtered images 5x5
        outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputMedian5x5_10);
        ImageIo.writeImage(outimage, "jpg", "UTB_saltPepperFilterd_5x5_0.10.jpg");
        
        outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputMedian5x5_15);
        ImageIo.writeImage(outimage, "jpg", "UTB_saltPepperFilterd_5x5_0.15.jpg");
        
        outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputMedian5x5_20);
        ImageIo.writeImage(outimage, "jpg", "UTB_saltPepperFilterd_5x5_0.20.jpg");
        
        
        // filter noise images 7x7
        byte[][] outputMedian7x7_10 = new byte [byteData.length][byteData[0].length];
        fltr.mean(outputNoisy10, outputMedian7x7_10, 7);
        
        byte[][] outputMedian7x7_15 = new byte [byteData.length][byteData[0].length];
        fltr.mean(outputNoisy15, outputMedian7x7_15, 7);
        
        byte[][] outputMedian7x7_20 = new byte [byteData.length][byteData[0].length];
        fltr.mean(outputNoisy20, outputMedian7x7_20, 7);
        
        // write filtered images 5x5
        outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputMedian7x7_10);
        ImageIo.writeImage(outimage, "jpg", "UTB_saltPepperFilterd_7x7_0.10.jpg");
        
        outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputMedian7x7_15);
        ImageIo.writeImage(outimage, "jpg", "UTB_saltPepperFilterd_7x7_0.15.jpg");
        
        outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputMedian7x7_20);
        ImageIo.writeImage(outimage, "jpg", "UTB_saltPepperFilterd_7x7_0.20.jpg");
        
        
        // min filtering
        byte[][] outputMin3x3 = new byte[byteData.length][byteData[0].length];
        fltr.min(byteData, outputMin3x3, 3);
        
        byte[][] outputMin5x5 = new byte[byteData.length][byteData[0].length];
        fltr.min(byteData, outputMin5x5, 5);
        
        byte[][] outputMin7x7 = new byte[byteData.length][byteData[0].length];
        fltr.min(byteData, outputMin7x7, 7);
        
        // write image
        outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputMin3x3);
        ImageIo.writeImage(outimage, "jpg", "UTB_minFiltered_3x3.jpg");
        
        outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputMin5x5);
        ImageIo.writeImage(outimage, "jpg", "UTB_minFiltered_5x5.jpg");
        
        outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputMin7x7);
        ImageIo.writeImage(outimage, "jpg", "UTB_minFiltered_7x7.jpg");
        
        
        // max filtering
        byte[][] outputMax3x3 = new byte[byteData.length][byteData[0].length];
        fltr.max(byteData, outputMax3x3, 3);
        
        byte[][] outputMax5x5 = new byte[byteData.length][byteData[0].length];
        fltr.max(byteData, outputMax5x5, 5);
        
        byte[][] outputMax7x7 = new byte[byteData.length][byteData[0].length];
        fltr.max(byteData, outputMax7x7, 7);
        
        // write image
        outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputMax3x3);
        ImageIo.writeImage(outimage, "jpg", "UTB_maxFiltered_3x3.jpg");
        
        outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputMax5x5);
        ImageIo.writeImage(outimage, "jpg", "UTB_maxFiltered_5x5.jpg");
        
        outimage = ImageIo.setGrayByteImageArray2DToBufferedImage(outputMax7x7);
        ImageIo.writeImage(outimage, "jpg", "UTB_maxFiltered_7x7.jpg");
    }
    
}
