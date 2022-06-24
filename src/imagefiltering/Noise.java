/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagefiltering;

/**
 *
 * @author mahmoud
 */
public class Noise {

public void addGrayNoiseSaltAndPepper(byte[][] grayInput,byte[][] grayNoisy, float p)
{
    //
    int noise_value;
    float tmp;
    float low = p/2;
    float high = 1 - low;
    
    for (int i = 0; i < grayInput.length; i++) {
        for (int j = 0; j < grayInput[0].length; j++) {
            tmp = (float) Math.random();
            
            if (tmp <= low) {
                noise_value = 0;
                grayNoisy[i][j] = (byte) ImageIo.clip(noise_value + (grayInput[i][j] & 0xFF));
            }
            else if (tmp >= high) {
                noise_value = 255;
                grayNoisy[i][j] = (byte) ImageIo.clip(noise_value + (grayInput[i][j] & 0xFF));
            }
            else
                grayNoisy[i][j] = grayInput[i][j];
        }  
    }
}

public void addColorNoiseSaltAndPepper(byte[][] rInput,byte[][] gInput,byte[][] bInput,byte[][] rInputNoisy,byte[][] gInputNoisy,byte[][] bInputNoisy, float p)
{
    //
    int noise_value;
    float tmp;
    float low = p/2;
    float high = 1 - low;
    
    for (int i = 0; i < rInput.length; i++) {
        for (int j = 0; j < rInput[0].length; j++) {
            tmp = (float) Math.random();
            
            if (tmp <= low) {
                noise_value = 0;
                rInputNoisy[i][j] = (byte) ImageIo.clip(noise_value + (rInput[i][j] & 0xFF));
                gInputNoisy[i][j] = (byte) ImageIo.clip(noise_value + (gInput[i][j] & 0xFF));
                bInputNoisy[i][j] = (byte) ImageIo.clip(noise_value + (bInput[i][j] & 0xFF));

            }
            else if (tmp >= high) {
                noise_value = 255;
                rInputNoisy[i][j] = (byte) ImageIo.clip(noise_value + (rInput[i][j] & 0xFF));
                gInputNoisy[i][j] = (byte) ImageIo.clip(noise_value + (gInput[i][j] & 0xFF));
                bInputNoisy[i][j] = (byte) ImageIo.clip(noise_value + (bInput[i][j] & 0xFF));
            }
            else {
                rInputNoisy[i][j] = rInput[i][j];
                gInputNoisy[i][j] = gInput[i][j];
                bInputNoisy[i][j] = bInput[i][j];
            }
        }  
    } 
}

}
