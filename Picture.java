    import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

  }

  public static void main(String[] args)
  {
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
  }

/**
 * Takes the average RGB values of the image in order to create varying intensities of only gray.
 * 
 */
public void gray(){
       Pixel pixel_arr4[];
       pixel_arr4 = this.getPixels();
       int value1, value2, value3;
       int average;
       for (Pixel spot : pixel_arr4)
       {
           value1 = spot.getRed();
           value2 = spot.getBlue();
           value3 = spot.getGreen();
           average = (value1+value2+value3) / 3;
           spot.setRed(average);
           spot.setBlue(average);
           spot.setGreen(average);

       }
    }
    
       /**
        * Method to mirror aroudn a vertical line in the middle of the pic
        */
public void mirrorVertical()
{
    int width = this.getWidth();
    int mirrorPoint = width / 2;
    
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    
    //loop through all the rows
    //Starts from (0,0) and copies the point to the other tside
    for (int y = 0 ; y < getHeight(); y++)
    {
        for ( int x = 0 ; x < mirrorPoint ; x++)
        {
            leftPixel = getPixel(x,y);
            rightPixel = getPixel(width - 1 -x, y);
            rightPixel.setColor(leftPixel.getColor());
        }
    }   
}
    /**
       * Method to mirror around a horizontal line in the middle
       * based on the height. It copies the top mirrored to the
       * bottom
     */
public void mirrorHorizontal ()
{
    int height = this.getHeight();
    int mirrorPoint = height/2;
    
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    
    for (int x = 0; x < getWidth(); x++){
        for (int y = 0; y < mirrorPoint; y ++){
            topPixel = getPixel(x,y);
            bottomPixel = getPixel(x, height - 1 - y);
            bottomPixel.setColor(topPixel.getColor());
        }
    }
}
/**
 * Makes the image smaller based on a multiplier (2 will make the image half the size)
 */
public void copysmaller (Picture file, int amt){
    Picture pic = file;
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    for (int sourceX = 0, targetX = 0;
        sourceX<pic.getWidth();
        sourceX+=amt,targetX++)
    {
        for (int sourceY = 0, targetY = 0;
            sourceY < pic.getHeight();
            sourceY+=amt, targetY++)
            {
                sourcePixel = pic.getPixel(sourceX,sourceY);
                targetPixel = this.getPixel(targetX,targetY);
                targetPixel.setColor(sourcePixel.getColor());
            }
        }
    }

/**
 * Copies the image onto itself but smaller until it gets to 6 smaller images, also changes the rgb 
 * values based on the image before it.
 */
public void copyrecursive (Picture file, int amt){
    Picture pic = file;
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    if (amt == 6)
    {}
    else{
        for (int sourceX = 0, targetX = 0;
            sourceX<pic.getWidth();
            sourceX+=amt,targetX++)
        {
            for (int sourceY = 0, targetY = 0;
                sourceY < pic.getHeight();
                sourceY+=amt, targetY++)
                {
                    sourcePixel = pic.getPixel(sourceX,sourceY);
                    targetPixel = this.getPixel(targetX,targetY);
                    targetPixel.setColor(sourcePixel.getColor());
                    targetPixel.setRed(sourcePixel.getBlue());
                    targetPixel.setGreen(sourcePixel.getRed());
                    targetPixel.setBlue(sourcePixel.getGreen());
                }
            }
        copyrecursive(pic,amt + 1);
    }
}
/**
 * Posterization method, Groups the RGB values into 4 groups and sets the
 * new RGB values accordingly
 */
public void shepar(){
    Pixel pixel_arr[];
    pixel_arr = this.getPixels();
    int val, val2, val3, gray;
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
            }
/**
 * Sets the RGB values to the inverse
 */
public void negative(){
    Pixel sourcePixel = null;
    for (int sourceX = 0; sourceX < getWidth(); sourceX++){
        for (int sourceY = 0; sourceY < getHeight(); sourceY++){
            sourcePixel = getPixel(sourceX,sourceY);
            int red = sourcePixel.getRed();
            int green = sourcePixel.getGreen();
            int blue = sourcePixel.getBlue();
            sourcePixel.setRed(255 - red);
            sourcePixel.setGreen(255 - green);
            sourcePixel.setBlue(255 - blue);
        }
    }
}
/**
 * Mirrors the image horizontally while switching RGB values then mirrors verticall
 */
public void mirrorneg(){
    int height = this.getHeight();
    int mirrorPoint = height/2;
    
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    
    for (int x = 0; x < getWidth(); x++){
        for (int y = 0; y < mirrorPoint; y ++){
            topPixel = getPixel(x,y);
            bottomPixel = getPixel(x, height - 1 - y);
            bottomPixel.setBlue(topPixel.getGreen());
            bottomPixel.setGreen(topPixel.getBlue());
            bottomPixel.setBlue(topPixel.getRed());
            
        }
    }
    this.mirrorVertical();
    
}
    
/*
{
    int width = this.getWidth();
    width = (width / 2) + 195;
    int mirrorPoint = (width / 2) ;
    
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    
    //loop through all the rows
    //Starts from (0,0) and copies the point to the other tside
    for (int y = 0 ; y < getHeight(); y++)
    {
        for ( int x = 195 ; x < mirrorPoint ; x++)
        {
            leftPixel = getPixel(x,y);
            rightPixel = getPixel(width - 1 -x, y);
            rightPixel.setColor(leftPixel.getColor());
        }
    }   
}
 */   
public void copy(Picture file, int x, int y){
    String sourceFile = ("images\\KatieFancy.jpg");
    Picture sourcePicture = file;

    Pixel sourcePixel = null;
    Pixel targetPixel = null;

    for (int sourceX = 0, targetX=x;
         sourceX < sourcePicture.getWidth();
         sourceX++, targetX++)
   {
       for (int sourceY = 0, targetY = y;
            sourceY < sourcePicture.getHeight();
            sourceY++, targetY++){
                sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
                targetPixel = this.getPixel(targetX,targetY);
                targetPixel.setColor(sourcePixel.getColor());
              }
       
   }//End of Gray
}
} // this } is the end of class Picture, put all new methods before this
