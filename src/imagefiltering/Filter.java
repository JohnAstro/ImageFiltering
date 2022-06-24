/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imagefiltering;

import java.util.Arrays;

/**
 *
 * @author jonat
 */
public class Filter {
    public void handleBorder(byte[][] input, byte[][]output, int hmask, int vmask) {
        int h = input.length;
        int w = input[0].length;
        //top rows
        for (int i = 0; i < hmask; i++) {
            for (int j = 0; j < w; j++) {
                output[i][j] = input[i][j];
            }
        }
        //bottom rows
        for (int i = h - hmask; i < h; i++) {
            for (int j = 0; j < w; j++) {
                output[i][j] = input[i][j];
            }
        }
        //left columns
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < vmask; j++) {
                output[i][j] = input[i][j];
            }
        }
        //right columns
        for (int i = 0; i < h; i++) {
            for (int j = w - vmask; j < w; j++) {
                output[i][j] = input[i][j];
            }
        }
    }
    
    public void mean(byte[][] input, byte[][] output, int maskSize) {
        System.out.println("Mask has: row size =" + maskSize + " column size= " + maskSize);
        
        // Decide border handling regions
        int h = (int) Math.floor((maskSize / 2));
        int v = (int) Math.floor((maskSize / 2));
        System.out.println("Boundary Rows/columns (left right top bottom) h = :" + h);
        
        // Handle borders:
        handleBorder(input, output, h, v);
        //handleBorder2(input, output, h, v);

        // Convolution
        int m2 = (int) Math.floor((maskSize / 2));
        int n2 = (int) Math.floor((maskSize / 2));
        //System.out.println("m2 = :" + m2 + " n2 = " + n2);
        
        int[] myCurrentValues = new int[maskSize * maskSize];
        
        for (int i = m2; i < output.length - m2; i++) {
            for (int j = n2; j < output[0].length - n2; j++) {
                int k = 0;
                for (int x = -m2; x <= m2; x++) {
                    for (int y = -n2; y <= n2; y++) {
                        myCurrentValues[k++] = (input[i + x][ j + y] & 0xff);
                    }
                }
                // i have my windows values
                Arrays.sort(myCurrentValues);

                output[i][j]= (byte) myCurrentValues[(maskSize * maskSize) / 2];
            }
        }
    }
    
    public void min(byte[][] input, byte[][] output, int maskSize) {
        System.out.println("Mask has: row size =" + maskSize + " column size= " + maskSize);
        
        // Decide border handling regions
        int h = (int) Math.floor((maskSize / 2));
        int v = (int) Math.floor((maskSize / 2));
        System.out.println("Boundary Rows/columns (left right top bottom) h = :" + h);
        
        // Handle borders:
        handleBorder(input, output, h, v);
        //handleBorder2(input, output, h, v);

        // Convolution
        int m2 = (int) Math.floor((maskSize / 2));
        int n2 = (int) Math.floor((maskSize / 2));
        //System.out.println("m2 = :" + m2 + " n2 = " + n2);
        
        int[] myCurrentValues = new int[maskSize * maskSize];
        
        for (int i = m2; i < output.length - m2; i++) {
            for (int j = n2; j < output[0].length - n2; j++) {
                int k = 0;
                for (int x = -m2; x <= m2; x++) {
                    for (int y = -n2; y <= n2; y++) {
                        myCurrentValues[k++] = (input[i + x][ j + y] & 0xff);
                    }
                }
                // i have my windows values
                Arrays.sort(myCurrentValues);
                
                // initialize the minimum value
                output[i][j]= (byte) myCurrentValues[0];
            }
        }
    }
    
    public void max(byte[][] input, byte[][] output, int maskSize) {
        System.out.println("Mask has: row size =" + maskSize + " column size= " + maskSize);
        
        // Decide border handling regions
        int h = (int) Math.floor((maskSize / 2));
        int v = (int) Math.floor((maskSize / 2));
        System.out.println("Boundary Rows/columns (left right top bottom) h = :" + h);
        
        // Handle borders:
        handleBorder(input, output, h, v);
        //handleBorder2(input, output, h, v);

        // Convolution
        int m2 = (int) Math.floor((maskSize / 2));
        int n2 = (int) Math.floor((maskSize / 2));
        //System.out.println("m2 = :" + m2 + " n2 = " + n2);
        
        int[] myCurrentValues = new int[maskSize * maskSize];
        
        for (int i = m2; i < output.length - m2; i++) {
            for (int j = n2; j < output[0].length - n2; j++) {
                int k = 0;
                for (int x = -m2; x <= m2; x++) {
                    for (int y = -n2; y <= n2; y++) {
                        myCurrentValues[k++] = (input[i + x][ j + y] & 0xff);
                    }
                }
                // i have my windows values
                Arrays.sort(myCurrentValues);
                
                // initialize the maximum value
                output[i][j]= (byte) myCurrentValues[(maskSize * maskSize) - 1];
            }
        }
    }
}
