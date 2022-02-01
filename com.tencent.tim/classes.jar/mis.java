import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mis
{
  public static <T> int a(Iterable<T> paramIterable, mis.b<T> paramb)
  {
    if (paramIterable != null)
    {
      int i = 0;
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        if (paramb.f(paramIterable.next())) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static <T, E> List<E> a(Iterable<T> paramIterable, mis.a<T, E> parama)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (parama != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localArrayList.add(parama.apply(paramIterable.next()));
      }
    }
    return localArrayList;
  }
  
  public static <T> List<T> a(Iterable<T> paramIterable, mis.b<T> paramb)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (paramb != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        if (paramb.f(localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public static abstract interface a<T, E>
  {
    public abstract E apply(T paramT);
  }
  
  public static abstract interface b<T>
  {
    public abstract boolean f(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mis
 * JD-Core Version:    0.7.0.1
 */