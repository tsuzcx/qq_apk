import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ntf<T>
{
  private List<ntg<T>> kC = new ArrayList();
  private T payload;
  
  public ntf(T paramT)
  {
    this.payload = paramT;
  }
  
  public void a(ntg<T> paramntg)
  {
    try
    {
      if (!this.kC.contains(paramntg)) {
        this.kC.add(paramntg);
      }
      return;
    }
    finally
    {
      paramntg = finally;
      throw paramntg;
    }
  }
  
  public void b(ntg<T> paramntg)
  {
    try
    {
      this.kC.remove(paramntg);
      return;
    }
    finally
    {
      paramntg = finally;
      throw paramntg;
    }
  }
  
  public T get()
  {
    return this.payload;
  }
  
  public void notifyObservers()
  {
    try
    {
      Iterator localIterator = this.kC.iterator();
      while (localIterator.hasNext()) {
        ((ntg)localIterator.next()).a(this);
      }
    }
    finally {}
  }
  
  public void set(T paramT)
  {
    this.payload = paramT;
    notifyObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ntf
 * JD-Core Version:    0.7.0.1
 */