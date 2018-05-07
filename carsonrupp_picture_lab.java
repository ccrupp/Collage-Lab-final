    
/**
 * Write a description of class SheparFaireyLab here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class carsonrupp_picture_lab
{
    /**
     * main method, to test the picture
     *
     */
    public static void main(String[] args)
    {

         //opens selfie picture
          /**/
         //String fileName = FileChooser.pickAFile();
         //Picture pictObj = new Picture(fileName);
         //pictObj.explore();

         //relative path
        // Picture apic = new Picture("images\\beach.jpg");
         //change with selfie picture
         Picture me = new Picture("images/shrek.jpg");
         Picture me1 = new Picture("images/shrek.jpg");
         Picture me2 = new Picture("images/shrek.jpg");

         int val, val2, val3, gray, total = 0, count = 0;
         /**
          * method 1 change - Groups each pixel into one of 4 groups depending on their grayscale intensity (groups scale by 63.75)
          *
          */
          //METHODS 1 AND TWO TAKE UP TOO MUCH MEMORY SO THEY ARE COMMENTED OUT
         Pixel pixel_arr[];
         pixel_arr = me.getPixels();
         for (Pixel spot : pixel_arr)
         
            {

                val = spot.getRed();
                val2 = spot.getGreen();
                val3 = spot.getBlue();
                gray = (val + val2 + val3) / 3;
                if (gray <= (255 * .25)){
                    spot.setRed(25);
                    spot.setGreen(25);
                    spot.setBlue(25);}
                else if (gray <= (255 * .5)){
                    spot.setRed(128);
                    spot.setGreen(0);
                    spot.setBlue(0);}
                else if (gray <= (255 * .75)){
                    spot.setRed(135);
                    spot.setBlue(206);
                    spot.setGreen(250);}
                else if (gray <= (255)){
                    spot.setRed(135);
                    spot.setBlue(206);
                    spot.setGreen(250);}

            }
         me.explore();


         /**
          * method 2 change
          * Finds the largest and smallest grayscale intensities and creates 4 groups, grouped into 4 intensities.
          */
         
         Pixel pixel_arr2[];
         pixel_arr2 = me1.getPixels();
         int s = Integer.MAX_VALUE;
         int b = Integer.MIN_VALUE;
         for (Pixel spot : pixel_arr2){
             val = spot.getRed();
             val2 = spot.getGreen();
             val3 = spot.getBlue();
             gray = (val + val2 + val3) / 3;
             //Finds the minimum and maximum values
             if (gray < s){
                 s = gray;
                }
             if (gray > b){
                 b = gray;
                }
            }
         //Determines the sections based on the largest and smallest values
         int divisor1 = (b / 4) ;
         int divisor2 = (b / 2) ;
         int divisor3 = (b / 4) + (b / 2);
         for (Pixel spot1 : pixel_arr2){
             val = spot1.getRed();
             val2 = spot1.getGreen();
             val3 = spot1.getBlue();
             gray = (val + val2 + val3) / 3;
             if (gray < divisor1){//Sets first group's RGB to Dark Blue
                 spot1.setRed(25);
                 spot1.setGreen(25);
                 spot1.setBlue(25);
                }
             else if (gray <= divisor2){//Sets first group's RGB to Maroon
                 spot1.setRed(128);
                 spot1.setGreen(0);
                 spot1.setBlue(0);}
             else if (gray <= divisor3){//Sets first group's RGB to Light Blue
                 spot1.setRed(135);
                 spot1.setBlue(206);
                 spot1.setGreen(250);
                }
             else if (gray <= b){//Sets first group's RGB to Off-White
                 spot1.setRed(135);
                 spot1.setBlue(206);
                 spot1.setGreen(250);
                }
            
                
                 }
         me1.explore();
                 
         
         
             
             
         

         /**
          * custom color palette
          */
         
         Pixel pixel_arr3[];
         pixel_arr3 = me2.getPixels();
         for (Pixel spot2 : pixel_arr3)
            {

                val = spot2.getRed();
                val2 = spot2.getGreen();
                val3 = spot2.getBlue();
                gray = (val + val2 + val3) / 3;
                if (gray <= (255 * .25)){//Sets first section to maroon
                    spot2.setRed(128);
                    spot2.setGreen(0);
                    spot2.setBlue(0);}
                else if (gray <= (255 * .57)){//Sets second section to midnight blue
                    spot2.setRed(25);
                    spot2.setGreen(25);
                    spot2.setBlue(112);}
                else if (gray <= (255 * .70)){//Sets third section to tiffany
                    spot2.setRed(10);
                    spot2.setBlue(186);
                    spot2.setGreen(181);}
                else if (gray <= (255)){//Sets last section to off-white
                    spot2.setRed(225);
                    spot2.setBlue(210);
                    spot2.setGreen(225);}

            }
            
         me2.explore();
         
         //me.write("images\\method1.jpg");//Writes the image to the images file
         //me1.write("images\\method2.jpg");
         me2.write("images\\usethisone.jpg");

    }//main
}//class





