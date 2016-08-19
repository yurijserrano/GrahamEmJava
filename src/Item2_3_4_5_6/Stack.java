/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Item2_3_4_5_6;

/**
 *
 * @author Serrano
 * @param <E>
 */


public class Stack<E> implements IStack<E>
{
    private final Node<E> header, trailer;
    int size;
    
    public Stack() 
    {
        header  = new Node<>(null);
        trailer = new Node<>(null);
        header.setNext(trailer);
        size = 0;
    }

    @Override
    public int size() 
    {
        return size;
    }

    @Override
    public boolean isEmpty() 
    {
        return (size == 0);
    }

    @Override
    public E top() throws EmptyStackException 
    {
        if (isEmpty()) throw new EmptyStackException();
                return header.getNext().element();
    }
    
    public E nextTop() throws EmptyStackException 
    {
        if (isEmpty()) 
                throw new EmptyStackException();
        else 
        {
            
            Node<E> top = header.getNext();
            Node<E> next = top.getNext();
            
            if (next == trailer)
                return null;
            else
                return next.element();
        }
    }

    @Override
    public void push(E e) 
    {
        
        Node<E> no = new Node<>(e);
        no.setNext(header.getNext());
        header.setNext(no);
        size++;
    }

    @Override
    public E pop() throws EmptyStackException 
    {
        E elem = top();
        Node<E> top = header.getNext();
        Node<E> next = top.getNext();
        
        header.setNext(next);
        top.setNext(null);
        
        size--;
        
        return elem;
    }
    
    @Override
    public String toString() 
    {
        String s = "{";
        Node<E> no = header.getNext();
        
        while (no != trailer) 
        {
            s = s + no.element() + ", ";
            no = no.getNext();
        }
        
        s = s.substring(0, s.length() - 2);
        
        return s + "}";
    }
    
}