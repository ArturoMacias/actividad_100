import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private BouncingBall[] myBalls;
    private Random rnd;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        rnd = new Random();
    }

    /**
     * Simulate n bouncing balls
     * EJERCICIO
     * Se pide que modifiques el método bounce de la clase BallDemo para que 
     * el usuario introduzca por parámetro cuántas bolas quiere que aparezcan 
     * en pantalla. El radio y color de las bolas debe ser aleatorio. 
     * Su posicion de inicio también debe ser aleatoria, pero siempre 
     * de la mitad de la pantalla hacia la izquierda. La animación debe 
     * terminar cuando alguna bola se salga del suelo por la derecha. Por cada
     * avance que hagas hasta conseguir obtener la solución final, realiza un commit.
     */
    public void bounce(int numberOfBalls)
    {
        int ground = 400;   // position of the ground line
        myBalls = new BouncingBall[numberOfBalls];
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        // crate and show the balls
        for (int i=0;i<myBalls.length;i++){
            int x =rnd.nextInt(301);
            int y =rnd.nextInt(251);
            int diameter = rnd.nextInt(50);
            //estas tres variables almacenan los tres componentes del color
            int red = rnd.nextInt(256);
            int green = rnd.nextInt(256);
            int blue = rnd.nextInt(256);
            //nuevo objeto de la clase color, que recibe en el constructor un valor para 
            //cada color primario
            Color color = new Color(red,green,blue);
            //añade bola con las características requeridas
            myBalls[i] = new BouncingBall(x,y,diameter,color,ground,myCanvas);
            myBalls[i].draw();
        }
       
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            //cuando llega la primera se para
            for (int i=0;i<myBalls.length;i++){
                myBalls[i].move();
                if (myBalls[i].getXPosition()>=550){
                finished = true;
                }
            }
            
        }
    }
}
