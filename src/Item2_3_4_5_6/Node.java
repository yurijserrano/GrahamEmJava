
package Item2_3_4_5_6;

/**
 *
 * @author Serrano
 * @param <E>
 */
public class Node<E> implements Position<E>
{
    private E element;
    private Node<E> next;
    
    public Node(E element) 
    {
        this.element = element;
        next = null;
    }
    
    public Node(E element, Node<E> next) 
    {
        this.element = element;
        this.next = next;
    }
    
    @Override
    public E element() 
    {
        return element;
    }
    
    public Node<E> getNext() 
    {
        return next;
    }
    
    public void setElement(E e) 
    {
        this.element = e;
    }
    
    public void setNext(Node<E> no) 
    {
        next = no;
    }
}
