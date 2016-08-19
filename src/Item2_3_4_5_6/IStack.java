
package Item2_3_4_5_6;

/**
 *
 * @author Serrano
 * @param <E>
 */
public interface IStack<E>
{
    
    public int size();
    public boolean isEmpty();
    public E top() throws EmptyStackException;
    public void push(E e);
    public E pop() throws EmptyStackException;
}