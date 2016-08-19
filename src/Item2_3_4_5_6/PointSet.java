/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Item2_3_4_5_6;

/**
 *
 * @author Serrano
 * 
 * Item 2
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PointSet 
{
    
    private final Vector<Point> vector;
    
    public PointSet(String filename) 
    {
        vector = LeArquivo(filename);
    }
    
    public int size() 
    {
        return vector.size();
    }
    
    private static Vector<Point> LeArquivo(String filename) 
    {
        /**
         * Leitura do Arquivo
         * 
         * Item 3
         */
        
        Path file = FileSystems.getDefault().getPath("entrada","pontos.txt");
        System.out.println(file.toAbsolutePath());
        Charset charset = Charset.forName("UTF-8");
        
        try 
        {
            BufferedReader reader = Files.newBufferedReader(file, charset);
            String line = reader.readLine();
            int num = Integer.parseInt(line);
            
            Vector<Point> vetor = new Vector<>(num);
            
            for (int i = 0; i < num; i++) 
            {
                
                line = reader.readLine();
                String[] tokens = line.split("\t");
                double x = Double.parseDouble(tokens[0]);
                double y = Double.parseDouble(tokens[1]);
                Point ponto = new Point(x, y);
                vetor.add(ponto);
            }
            return vetor;
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(PointSet.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    /**
     * Item 4
     */
    private Point min() 
    {
        
        Point min = vector.get(0);
        
        for (int i = 1; i < vector.size(); i++) 
        {
            
            Point ponto = vector.get(i);
            
            if (ponto.getY() < min.getY())
                min = ponto;
        }
        return min;
    }
    
    /**
     * A ordenação é baseada nos pontos
     * 
     * Item 5
     */
    private void sort() 
    {
        
        Point min = min();
        
        for (int i = 1; i < vector.size(); i++) 
        {
            
            Point cur = vector.get(i);
            int j;
            
            for (j = i-1; j >= 0 &&vector.get(j).polarAngle(min) > cur.polarAngle(min); j--) 
            {                
                vector.set(j+1, vector.get(j));
            }                
            vector.set(j+1, cur);
        } 
    }
    
    
    /**
     * Item 6
     * @return 
     */
    
    public Stack<Point> graham() 
    {
        
        sort();
        
        Stack<Point> pilha = new Stack<>();
        pilha.push(vector.get(0));
        pilha.push(vector.get(1));
        pilha.push(vector.get(2));
        
        for (int i = 3; i <vector.size(); i++) 
        {
            Point ponto = vector.get(i);
            while (ponto.ADireita(pilha.nextTop(), pilha.top())) 
            {
                pilha.pop();
            }
            pilha.push(ponto);
        }
        
        return pilha;
    }
    
    @Override
    public String toString() 
    {
        String texto = "[";
        
        for (int i = 0; i < vector.size(); i++) 
        {
            texto = texto + vector.get(i) + ",";
        }
        texto = texto.substring(0, texto.length() - 1);
        return texto + "]";
    }
    
    
}

