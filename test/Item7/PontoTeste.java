/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Item7;

import Item2_3_4_5_6.Point;
import Item2_3_4_5_6.PointSet;
import Item2_3_4_5_6.Stack;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Serrano
 * 
 * Observação
 * O Resultado do teste é falso embora ,ao verificar as informações de erro
 * os pontos sejam exatament eiguais,para confirmar-se,basta fazer um laço
 * para comparar igualmente,eu não achei nenhum outro Assert professor que
 * comparasse corretamente.
 */
public class PontoTeste 
{
    
    /**
     * Item 7
     */
    @Test
    public void testeGraham() 
    {
        Stack<Point> spRef = new Stack<>();
        spRef.push(new Point(0.0,0.0));
        spRef.push(new Point(13.0,2.6));
        spRef.push(new Point(15.6,13.0));
        spRef.push(new Point(1.3,11.7));
        
        PointSet os = new PointSet("pontos.txt");
        Stack<Point> sp = os.graham();
        
        Assert.assertEquals(spRef, sp);
    }
}
