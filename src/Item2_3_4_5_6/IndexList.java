

package Item2_3_4_5_6;

/**
 *
 * @author Serrano
 * @param <E>
 */
public interface IndexList<E>
{
    
    public boolean isEmpty();
    public int size();
    public E get(int index) throws ArrayIndexOutOfBoundsException;
    public E set(int index, E element) throws ArrayIndexOutOfBoundsException;
    public void add(int index, E element) throws ArrayIndexOutOfBoundsException;
    public void remove(int index) throws ArrayIndexOutOfBoundsException;
    public int indexOf(E e);
    public void sort(); 
}