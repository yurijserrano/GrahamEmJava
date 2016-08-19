package Item2_3_4_5_6;

/**
 *
 * @author Serrano
 * @param <E>
 */
public class Vector<E> implements IndexList<E>, Cloneable
{
    
    private E[] A;
    private int size;
    
    @SuppressWarnings("unchecked")
    public Vector(int capacity)
    {
        A = (E[]) new Object [capacity];
        size = 0;
    }
    
    public Vector(E[] A, int size)
    {
        this.A = A;
        this.size = size;
    }
    

    @Override
    public int size() 
    {
        return size;
    }
    
    public int capacity() 
    {
        return A.length;
    }
    
    public E[] getArray() 
    {
        return A;
    }
    
    @Override
    public boolean isEmpty() 
    {
        return (size == 0);
    }

    @Override
    public E get(int i) throws ArrayIndexOutOfBoundsException 
    {
            return A[i];
    }

    @Override
    public E set(int i, E e) throws ArrayIndexOutOfBoundsException 
    {
        E obj = A[i];
        A[i] = e;
        return obj;
    }

    @Override
    public void add(int i, E e) throws ArrayIndexOutOfBoundsException 
    {
        if (size == A.length)
            this.expand();
        
        for (int j = size - 1; j >= i; j--)
            A[j+1] = A[j];

        A[i] = e;
        size++;
    }
    
    public void add(E e) 
    {
        if (e != null) 
        {
            if (size == A.length) 
                this.expand();
            
            A[size] = e;
            size++;
        }
    }
    
    public void addAll(E[] elements) 
    {
        for (E e : elements) 
        {
            add(e);
        }
    }
    
    private void expand() 
    {
        @SuppressWarnings("unchecked")
        E[] obj = (E[]) new Object [2 * A.length];
        for (int i = 0; i < size; i++) 
        {
            obj[i] = A[i];
        }
        A = obj;
    }

    @Override
    public void remove(int i) throws ArrayIndexOutOfBoundsException 
    {
        if (i == A.length - 1)
            A[i] = null;
        else 
        {
           for (int j = i; j <= size - 1; j++)
            A[j] = A [j+1]; 
        }
        size--;
    }
    
    @Override
    public int indexOf(E e) 
    {
        for (int i = 0; i < size; i++) 
        {
            if (A[i].equals(e)) 
            {
                return i;
            }
        }
        return -1;
    }
    
       
    @SuppressWarnings({"unchecked", "unchecked"})
    public int buscaBinaria (E e, int low, int high) 
    {
        if (low > high) 
        { 
            return -1;                
        }            
            
        int mid = (low + high)/2;
        if (A[mid].equals(e)) 
        {
            return mid;
        }
        else if (((Comparable) A[mid]).compareTo(e) > 0) 
        {
            return buscaBinaria (e, low, mid - 1);
        }
        else 
        {
            return buscaBinaria (e, mid + 1, high);
        }
    }
    
    public int lastIndexOf (E e) 
    {
        int index = -1;
        
        for (int i = 0; i < size; i++) 
        {
            if (A[i].equals(e)) 
            {
                index = i;
            }
        }
        return index;
    }
    
    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException 
    {
        @SuppressWarnings("unchecked")
        E[] obj = (E[]) new Object[A.length];
        for (int i = 0; i < size; i++)
            obj[i] = A[i];
        
        @SuppressWarnings("unchecked")
        Vector v = new Vector (obj, size);
        
        return v;
    }
    
    @Override
    public void sort() 
    {
        mergeSort();
    }
    
    public void selectSort() 
    {
        for (int i = 0; i < size - 1; i++) 
        {
            int menor = getIndexMenor(i, size - 1);
            trocaElementos(i, menor);
        }
    }
    
    @SuppressWarnings("unchecked")
    private int getIndexMenor(int low, int high) 
    {
        int menor = low;
        for (int i = low + 1; i <= high; i++) 
        {
            if (((Comparable) A[i]).compareTo(A[menor]) < 0) 
                menor = i;
        }
        return menor;
    }
    
    private void trocaElementos(int i, int j) 
    {
        E temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    @SuppressWarnings("unchecked")
    public void insertionSort() 
    {
        for (int i = 1; i < size; i++) 
        {
            E cur = A[i];
            int j;
            for (j = i-1; j >= 0 && ((Comparable) A[j]).compareTo(cur) > 0; j--)
                A[j+1] = A[j];
            A[j+1] = cur;
        }
    }
    
    public void mergeSort() 
    {
        if (this.capacity() > 1) 
        {
            int last = this.capacity() - 1;
            int mid = last/2;
            Vector<E> v1 = subVector(0,mid);
            Vector<E> v2 = subVector(mid + 1,last);
            v1.mergeSort();
            v2.mergeSort();
            Vector<E> result = merge(v1, v2);
            A = result.getArray();
        }
    }
    
    public Vector<E> subVector (int low, int high) 
    {
        Vector<E> sub = new Vector<>(high - low + 1);
        
        for (int i = low; i <= high; i++) 
        {
            sub.add(A[i]);
        }
        return sub;
    }
    
    @SuppressWarnings("unchecked")
    public Vector<E> merge(Vector<E> v1, Vector<E> v2) 
    {
        Vector<E> v3 = new Vector<>(v1.capacity() + v2.capacity());
        int i = 0, j = 0;
        
        while (i < v1.size() && j < v2.size()) 
        {
            if (((Comparable)v1.get(i)).compareTo(v2.get(j)) < 0) 
            {
                v3.add(v1.get(i));
                i++;
            }
            else 
            {
                v3.add(v2.get(j));
                j++;
            }
        }
        
        for ( ; i < v1.size(); i++)
            v3.add(v1.get(i));
                 
        for ( ; j < v2.size(); j++)
            v3.add(v2.get(j));
           
        return v3;
    }
    
    @Override
    public String toString() 
    {
        String result = "[";
        
        for (int i = 0; i < size - 1; i++) 
        {
            result = result + A[i] + " ";
        }
        
        result = result + A[size - 1] + "]";
        return result;
    }
}
