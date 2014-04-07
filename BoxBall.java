import java.awt.*;
import java.awt.geom.*;

/**
 * Class BoxBall - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Michael KÃ¶lling (mik)
 * @author David J. Barnes
 * @author Bruce Quig
 *
 * @version 2011.07.31
 */

public class BoxBall
{
    //private static final int GRAVITY = 1;  // effect of gravity
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int upPosition;    
    private final int leftPosition;
    private final int downPosition;
    private final int rightPosition;
    private Canvas canvas;
    private int ySpeed;                // initial downward speed
    private int xSpeed;
    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int upPosition,int rightPosition ,int downPosition,int leftPosition, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        this.upPosition=upPosition;
        this.rightPosition=rightPosition;
        this.leftPosition=leftPosition;
        this.downPosition=downPosition;
        canvas = drawingCanvas;
        ySpeed=1;
        xSpeed=1;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        
        yPosition += ySpeed;
        xPosition += xSpeed;
        
        // cuando toca alguno de los lados del cuadrado cambia la dirección de la bola.
        //tiene en cuenta que el circulo tiene x,y en la esquina superior izquierda de un cuadrado en el
        //que está inscrito
        if(yPosition == (downPosition - diameter) || yPosition == (upPosition)){
            ySpeed = -ySpeed;
        }
        if(xPosition == (rightPosition-diameter) || xPosition == (leftPosition)){
            xSpeed =- xSpeed;
        }

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
