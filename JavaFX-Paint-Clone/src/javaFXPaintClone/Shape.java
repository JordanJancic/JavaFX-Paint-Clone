/*
 * This is the shape object class. This is where the shape is configured.
 */
package javaFXPaintClone;
/**imports all necessary java utilities*/
import javafx.scene.paint.Color;

/**
 * @author Jordan Jancic, 000269500
 * Assignment 8
 * Professor: John Weber
 * Date Completed: April 14, 2018
 */
public class Shape {
    /**The shape class instance variables.*/
    private double xValue;
    private double yValue;
    private double radiusValue;
    private Color color;
    
    /**@param xValue the x coordinate for the shape.
     @param yValue the y coordinate for the shape.
     @param radiusValue the radius value for the shape.
     @param r the red color value for the shape.
     @param g the green color value for the shape.
     @param b the blue color value for the shape.
     this is the Shape constructor that configures the shape object.*/ 
    public Shape(double xValue, double yValue, double radiusValue, int r, int b, int g) {
        this.xValue = xValue;                                                   //sets the x value to the passed value.
        this.yValue = yValue;                                                   //sets the y value to the passed value.
        this.radiusValue = radiusValue;                                         //sets the radius value to the passed value.
        this.color = Color.rgb(r, g, b);                                        //sets the rgb color values to the passed value.
    }
    /**returns the x value
     * @return e*/
    public double getX() {
        return xValue;
    }
    /**returns the y value
     * @return e*/
    public double getY() {
        return yValue;
    }
    /**returns the radius value
     * @return e*/
    public double getRadius() {
        return radiusValue;
    }
    /**@param n sets radiusValue from n value.
     * sets the radius value*/
    public void setRadius(double n) {
        this.radiusValue = n;
    }
    /**@param r passes red value
     * @param g passes green value
     * @param b passes blue value
     * Sets color of shape.*/
    public void setColor(int r, int g, int b) {
        color = Color.rgb(r, g, b);                                             //sets variable color to the passed values.
    }
    /**returns color value
     * @return .*/
    public Color getColor() {
        return color;
    }
    
    
    
}
