package javaFXPaintClone;

/**Imports the necessary Java utilities for this GUI application*/
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

/**
 * @author Jordan Jancic, 000269500
 * Date Completed: April 14, 2018
 */
public class JavaFXPaintClone extends Application {
    /**Instance variables for the main method.*/
    private Shape shape;
    private GraphicsContext gc;
    private TextField locationX = new TextField("0");
    private TextField locationY = new TextField("0");
    private TextField radius = new TextField("10");
    private TextField colorRText = new TextField("R");
    private TextField colorGText = new TextField("G");
    private TextField colorBText = new TextField("B");
    private Label locationLabel, radiusLabel, colorLabel, logoLabel;
    private Label r, g, bb;
    private Label notifications;
    private double newRadius;
    private double rColor;
    private double gColor;
    private double bColor;

    /**
     * @param stage The main stage
     * @throws Exception
     */
    /**This is the Dragged event handler. When the mouse is dragged,
     this method is called and enables the user to draw by using the mouse.*/
    private void dragged(MouseEvent e) {
        if (e.getX()<130) {                                                     //Checks if user is drawing outside of the drawing area.
            System.out.println("YOU CANT DRAW HERE");                           //informs the user that they cannot draw in this area.
        }
        else if (e.getX()>130){                                                 //checks if the user is drawing in the appropriate drawing area.
            /**Tries to obtain values from the RGB Textfields.*/
            try {
                rColor = Double.parseDouble(colorRText.getText());
                gColor = Double.parseDouble(colorGText.getText());
                bColor = Double.parseDouble(colorBText.getText());
            }
            /**Catches the exception if the RGB fields are empty.*/
            catch(Exception exception) {
                notifications.setText("RGB Values must be\ngreater than or\nequal to zero\nand less than 255");             //sets notification window to the proper notification.
                throw new IllegalArgumentException("RGB Values must be greater than or equal to zero and less than 255");   //throws the exception.
            }
            /**Tries to obtain values from the Radius text field.*/
            try {
            newRadius = Double.parseDouble(radius.getText());                           //parses the string from the radius textfield to a new double variable.
            if (newRadius == 0) {                                                       //checks if the text in radius field is equal to zero.
                notifications.setText("Radial value must\nbe greater than\nzero.");     //if it is equal to zero, it sets the notification window to say this.
            }
            }
            /**Catches the exception if the Radius field is left blank*/
            catch(Exception exception) {
                notifications.setText("Radius field cannot\nbe left blank.");               //sets the notification window to tell the user that the radius field is blank.
                throw new IllegalArgumentException("Radius field cannot be left blank.");   //throws new exception.
            }
            if (newRadius > 0) {                                                                                                //checks if the radius is greater than 0.
                gc.fillRect(e.getX()-shape.getRadius()/2,e.getY()-shape.getRadius()/2,shape.getRadius(),shape.getRadius());     //ensures that the shape being drawn is in the center of the mouse.  Also sets the size of the shape by calling the shapes getRadius method.
                notifications.setText("STATUS GOOD");                                                                           //sets notification to tell the user that all inputs are valid.
            }
        }
        }
    /**This method is called when the mouse buttons is pressed down.*/
    private void down(MouseEvent e) {
                            
        if (e.getX()<120) {                                                     //checks if the user's mouse is outside of the drawing area.
            System.out.println("YOU CANT DRAW HERE");                           //informs the user that they cannot draw in this area.
            throw new IllegalArgumentException("Can't draw here.");             //throws new exception.
        }
        else if (e.getX()>120){                                                 //checks if the user's mouse is in the drawing area
            /**Tries to obtain the values from the RGB textfields.*/
            try {
            rColor = Double.parseDouble(colorRText.getText());
            gColor = Double.parseDouble(colorGText.getText());
            bColor = Double.parseDouble(colorBText.getText());
            }
            /**catches the exception if the RGB fields are empty.*/
            catch(Exception exception) {
                notifications.setText("RGB Values must be\ngreater than or\nequal to zero\nand less than 255");             //sets the notification window to this.
                throw new IllegalArgumentException("RGB Values must be greater than or equal to zero and less than 255");   //throws the exception.
            }
            try {
            newRadius = Double.parseDouble(radius.getText());                   //tries to get the value from the radius textField.

            if (newRadius == 0) {                                               //checks if the radius value is equal to zero.

                notifications.setText("Radial value must\nbe greater than\nzero.");     //sets the notification window to tell the user that the radial value must be greater than zero.
            }
            }
            /**Catches the exception if the radius field is left blank.*/
            catch(Exception exception) {
                notifications.setText("Radius field cannot\nbe left blank.");               //sets the notification window to tellthe user the radius field can't be left blank.
                throw new IllegalArgumentException("Radius field cannot be left blank.");   //throws new exception.
            }
            /**Checks if the radius is greater than zero.*/
            if (newRadius > 0) {
                shape.setRadius(newRadius);                                             //sets the radius of the shape by calling the shapes setRadius method.
                                                                                        //shape.draw(gc,(int)rColor, (int)gColor, (int)bColor);//draws the shape and sends color values from the RGB fields to the shape's draw method.
                gc.setFill(Color.rgb((int)rColor, (int)gColor, (int)bColor));           //this collects the color values from the RGB textfields.  The drag method relies on this line of code as well.
                gc.fillRect(e.getX()-shape.getRadius()/2,e.getY()-shape.getRadius()/2,shape.getRadius(),shape.getRadius());     //ensures that the shape being drawn is in the center of the mouse.  Also sets the size of the shape by calling the shapes getRadius method.
                notifications.setText("STATUS GOOD");                                                                           //sets notification to tell the user that all inputs are valid.
            }
        }
    }
    /**Generates the main draw area and user interface*/
    private void generateDrawArea() {
            gc.setFill(Color.rgb(0, 0, 0));
            gc.fillRect(0, 0, 800, 600);
            gc.setFill(Color.rgb(224,224,224));
            gc.fillRect(0,0,120,600);   
            gc.setFill(Color.rgb(255,255,255));
            gc.fillRect(5,250,110,130);
    }
    /**@param e the actionEvent value
     This method draws the shape when the DRAW IT button is pressed*/
    private void drawShape(ActionEvent e) {
        /**Tries to obtain the color values from the RGB textFields.*/
        try {
            double rColor = Double.parseDouble(colorRText.getText());
            double gColor = Double.parseDouble(colorGText.getText());
            double bColor = Double.parseDouble(colorBText.getText());

            if (radius.getText().equals("0")) {                                 //checks if radius field is equal to zero.
                notifications.setText("RADIUS CANNOT\nEQUAL ZERO");             //sets notification window to tell the user that the radius cannot equal zero.
            }
            else if (radius.getText().equals("")) {                             //checks  if radius window is blank
                notifications.setText("RADIUS CANNOT\nBE LEFT BLANK");          //sets notification window to tell the user that the radius cannot be left blank.
            }
            else if (rColor > 255 || rColor < 0) {                                              //checks if the red RGB value is between 0 and 255.
                notifications.setText("RGB Values must\nbe between 0\nand 255");                //sets notification window to tell the user that the RGB Values must be between 0 and 255.
                throw new IllegalArgumentException("RGB Values must be between 0 and 255");     //throws new exception.
            }
            else if (gColor > 255 || gColor < 0) {                                              //checks if the green RGB value is between 0 and 255.
                notifications.setText("RGB Values must\nbe between 0\nand 255");                //sets notification window to tell the user that the RGB Values must be between 0 and 255.
                throw new IllegalArgumentException("RGB Values must be between 0 and 255");     //throws new exception.
            }
            else if (bColor > 255 || bColor < 0) {                                              //checks if the blue RGB value is between 0 and 255.
                notifications.setText("RGB Values must\nbe between 0\nand 255");                //sets notification window to tell the user that the RGB Values must be between 0 and 255.
                throw new IllegalArgumentException("RGB Values must be between 0 and 255");     //throws new exception.
            }
            else {
                double tempX = Double.parseDouble(locationX.getText());             //gets x Value from x location textfield and sets it to tempX variable name.
                double tempY = Double.parseDouble(locationY.getText());             //gets y Value from x location textfield and sets it to tempY variable name.
                double tempRadius = Double.parseDouble(radius.getText());           //gets radius value from radius textfield and sets it to tempRadius variable name.
                shape.setRadius(tempRadius);                                        //calls the shapes setRadius method to set the size of the radius.
                gc.setFill(Color.rgb((int)rColor, (int)gColor, (int)bColor));       //sets the color of the shape.
                gc.fillRect(tempX+120,tempY,shape.getRadius(),shape.getRadius());   //creates the shape.
                notifications.setText("STATUS GOOD");                               //notifies user that the program is running fine.
            }
            
        }
        /**@param exception passes exception value.
         * Catches the exception if either location windows are left blank.*/
        catch (IllegalArgumentException exception) {
            notifications.setText("Bad location value.\nValue must be\ngreater than zero\nand field must not\nbe left blank.");     //sets notification window to say this.
        }
    }
    /**@param e passes exception value through parameters
     sets the radius of the shape*/
    private void setRadius(ActionEvent e) {
        double newRadius = Double.parseDouble(radius.getText());                //sets the value of newRadius to the parsed value from the radius textfield.
        shape.setRadius(newRadius);                                             //passes value to the setRadius method.
    }
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();                                                 //creates new pane.
        Scene scene = new Scene(root, 800, 600);                                // set the size here
        stage.setTitle("Atobe Photochop v1.0");                                 // set the window title here
        stage.setScene(scene);                                                  //sets the scene
        // 1. Create the model
        shape = new Shape(0,0,0,20, 20, 20);                                    //creates new default shape.
        
        // 2. Create the GUI components
        Canvas canvas = new Canvas(800,600);                                    //sets the size of the canvas.
        Button b = new Button("Draw It!");                                      //Creates the draw it button.
        locationLabel = new Label("Location");                                  //creates location label.
        radiusLabel = new Label("Radius");                                      //creates radius label.
        colorLabel = new Label("Color");                                        //creates color label.
        logoLabel = new Label("PHOTOCHOP v1.0");                                //creates title of program label.
        r = new Label("R");                                                     //creates R label.
        g = new Label("G");                                                     //creates G label.
        bb = new Label("B");                                                    //creates B labal.
        colorRText = new TextField("255");                                      //sets r textfield default value to 255, red.
        colorGText = new TextField("0");                                        //sets g textfield default value to 0.
        colorBText = new TextField("0");                                        //sets b textfield default value to 0.
        notifications = new Label("STATUS GOOD");                               //sets notification window to default value STATUS GOOD.

        // 3. Add components to the root
        /**Adds all necessary components to the root.*/
        root.getChildren().add(canvas);                                         //adds the canvas
        root.getChildren().add(b);                                              //adds the draw it button
        root.getChildren().add(locationLabel);                                  //adds the locaiton label.
        root.getChildren().add(colorRText);                                     //adds the color r textfield.
        root.getChildren().add(colorGText);                                     //adds the color g textfield.
        root.getChildren().add(colorBText);                                     //adds the color b textfield.
        root.getChildren().add(locationX);                                      //adds the location x textfield.
        root.getChildren().add(locationY);                                      //adds the location y textfield.
        root.getChildren().add(radiusLabel);                                    //adds the radius label.
        root.getChildren().add(colorLabel);                                     //adds the color label.
        root.getChildren().add(radius);                                         //adds the radius textField.
        root.getChildren().add(logoLabel);                                      //adds the name of the program label.
        root.getChildren().add(r);                                              //adds r label.
        root.getChildren().add(g);                                              //adds b label.
        root.getChildren().add(bb);                                             //adds g label.
        root.getChildren().add(notifications);                                  //adds notifications window.

        // 4. Configure the components (colors, fonts, size, location)
        
        notifications.setLayoutX(5);                                            //sets notification window to proper location
        notifications.setLayoutY(250);                                          //sets notification window to proper location
        
        r.setLayoutX(60);                                                       //sets position of r label.
        r.setLayoutY(150);                                                      //sets position of r label.
        
        g.setLayoutX(60);                                                       //sets position of g label.
        g.setLayoutY(180);                                                      //sets position of g label.
        
        bb.setLayoutX(60);                                                      //sets position of b label.
        bb.setLayoutY(210);                                                     //sets position of b label.
        
        
        logoLabel.setLayoutX(12);                                               //sets position of program title label.
        logoLabel.setLayoutY(0);                                                //sets position of program title label.
        
        b.setLayoutX(30);                                                       //sets position of draw it button.
        b.setLayoutY(400);                                                      //sets position of draw it button.
        
        radius.setLayoutX(0);                                                   //sets position of radius button.
        radius.setLayoutY(100);                                                 //sets position of radius button.
        radius.setPrefSize(50, 20);                                             //sets size of radius button.
        
        colorLabel.setLayoutX(5);                                               //sets position of color label.
        colorLabel.setLayoutY(130);                                             //sets position of color label.
        
        colorRText.setLayoutX(5);                                               //sets position of RGB textfield.
        colorRText.setLayoutY(150);                                             //sets position of RGB textfield.
        colorRText.setPrefSize(50, 20);                                         //sets size of RGB textfield.
        
        colorGText.setLayoutX(5);                                               //sets position of RGB textfield.
        colorGText.setLayoutY(180);                                             //sets position of RGB textfield.
        colorGText.setPrefSize(50, 20);                                         //sets size of RGB textfield.
        
        colorBText.setLayoutX(5);                                               //sets position of RGB textfield.
        colorBText.setLayoutY(211);                                             //sets position of RGB textfield.
        colorBText.setPrefSize(50, 20);                                         //sets size of RGB textfield.
        
        locationX.setLayoutX(0);                                                //sets position of location textfield.
        locationX.setLayoutY(50);                                               //sets position of location textfield.
        locationX.setPrefSize(50, 20);                                          //sets size of location textfield.
        
        locationY.setLayoutX(55);                                               //sets position of location textfield.
        locationY.setLayoutY(50);                                               //sets position of location textfield.
        locationY.setPrefSize(50, 20);                                          //sets size of location textfield.
        
        locationLabel.setLayoutX(5);                                            //sets location of location label.
        locationLabel.setLayoutY(25);                                           //sets location of location label.
        radiusLabel.setLayoutX(5);                                              //sets location of radius label.
        radiusLabel.setLayoutY(80);                                             //sets location of radius label.
        
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::down);           //calls event handler for when the mouse is pressed.
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::dragged);        //calls event handler for when the mouse is dragged.
        
        b.setOnAction(this::drawShape);                                         //calls the drawshape method when thie draw it button is pressed.
        // 5. Add Event Handlers and do final setup
        gc = canvas.getGraphicsContext2D();                                     //gets 2d context.
        generateDrawArea();                                                     //generates the GUI and draw area.
        // 6. Show the stage
        stage.show();                                                           //shows the stage.
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
