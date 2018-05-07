
/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class TestPicture17
{

    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
      /*
      //make custom color       R   G   B
      Color sample = new Color(255,255,255);
      Color sample2 = Color.orange;
      System.out.println(sample);
      //opens picture using a dialog box
      /*
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
*/
     //opens a pictue using a path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");

     //relative path
     /*
     Picture apic = new Picture("images\\beach.jpg");
     Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
     Picture ferris2 = new Picture("images/2000 ferris wheel2.jpg");
     Picture ferris3 = new Picture("images/2000 ferris wheel2.jpg");
     Picture wall = new Picture("images/wall.jpg");
     Picture wall2 = new Picture("images/wall.jpg");
     
     ferris1.gray();
     ferris1.explore();
     ferris1.mirrorVertical();
     ferris1.explore();
     */
     Picture temple = new Picture("images/temple.jpg");
     Picture mike = new Picture("images/Prisonmike.png");   
     Picture mike2 = new Picture("images/Prisonmike.png");
     Picture mike3 = new Picture("images/Prisonmike.png");
     Picture mike4 = new Picture("images/Prisonmike.png");
     Picture mike5 = new Picture("images/Prisonmike.png");
     Picture mikedwight = new Picture("images/mikedwight.jpg");
     Picture canvas = new Picture("images/mycanvas.jpg");
     
     mike.gray();
     canvas.copy(mike,0,0);
     canvas.copy(mike2,0,786);
     mike3.negative();
     canvas.copy(mike3,700,0);
     mike4.shepar();
     canvas.copy(mike4,1400,0);
     mike5.mirrorneg();
     canvas.copy(mike5,0,393);
     mikedwight.copyrecursive(mikedwight,2);
     canvas.copy(mikedwight,700,393);
     canvas.explore();
     canvas.write("images\\prisonmikedone.jpg");
     
/*
     //apic.explore();
     //ferris1.explore();//In order to see it, you need to explore it.

     //makes an array of pixels
     Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     pixels = ferris1.getPixels();

     //how many pixels or how large array
    System.out.println("This is a large array"+pixels.length  );


    /*
        //access each index
    System.out.println(pixels[17]);//not recommended
    //access each pixel

    Pixel spot = ferris1.getPixel(100,100);
    Pixel hair = ferris1.getPixel(400,575);
    System.out.println(pixels[17].getColor());
    System.out.println("The spot is" + spot);
/*
    pixels[17].setColor(Color.blue);
    spot.setColor(new Color(252,252,252));
    hair.setColor(new Color(250,235,215));
    pixels[500034].setColor(Color.blue);

    //ferris1.explore();
/*
   // loop to access indexes of array or collection
   Pixel pixel_arr[];
   pixel_arr = ferris1.getPixels();
   int i = 0;
    //for each loop spot  is a ?
    for (Pixel spot1 : pixel_arr)
    {
        if(i %50 == 0)
        {
        spot1.setColor(Color.green);
    }
    i++;
}
//ferris1.explore();


 /*

 /**
  * Method to clear red from picture
  * @param none
  * @return none
  */
/*
 Pixel pixel_arr2[];
 pixel_arr2 = ferris1.getPixels();
 i = 0;
 for (Pixel spot1 : pixel_arr2)
 {
     spot1.setRed(0);
}
//ferris1.explore();
 /*
    for (Pixel pixelObj : pixels)
        {
            //set the red value of the current pixel to the new value


        }
    ferris1.explore();

/**/
 /**
  * Method to reduce red from picture by a factor of n
  * @param none
  * @return none
  */

/**/
/*
int value;
final double  FACTOR = .5;
Pixel pixel_arr3[];
pixel_arr3 = ferris2.getPixels();
    for (Pixel pixelObj : pixel_arr3)
    {

        //get the redvalue
        value = pixelObj.getBlue();
        value *= FACTOR;
        //System.out.println(value);
        pixelObj.setBlue(value);

        //decrease the red value by 50%

        //set the red value of the current pixel to the new value


    }
    // use new picture when changing or it will make changes to
    // pic you already changed
    ferris2.explore();

*/

    //write/save a picture as a file
//     /*
//     ferris1.write("images/ferris11.jpg");
// 
// 
// value = 0;
// Pixel pixel_arr4[];
// pixel_arr4 = wall.getPixels();
// final double FACTOR2 = .3;
//     for (Pixel change : pixel_arr4)
//     {
//         value = change.getRed();
//         value *= FACTOR2;
//         change.setRed(value);
//     }
// wall2.explore();
// wall.explore();
  }//main
}//class
