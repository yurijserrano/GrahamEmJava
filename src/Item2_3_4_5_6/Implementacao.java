

package Item2_3_4_5_6;

/**
 *
 * @author Serrano
 */
public class Implementacao 
{
     public static void main(String[] args) 
     {
        PointSet pontos = new PointSet("pontos.txt");
        Stack<Point> pilha = pontos.graham();
        System.out.println(pilha);
     }
    
}
