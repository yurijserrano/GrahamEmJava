package Item2_3_4_5_6;

/**
 *
 * @author Serrano
 */
@SuppressWarnings("serial")
public class EmptyStackException extends RuntimeException
{
    
    public EmptyStackException()
    {
        super();
    }
    
    public EmptyStackException(String err) 
    {
        super(err);
    }
}
