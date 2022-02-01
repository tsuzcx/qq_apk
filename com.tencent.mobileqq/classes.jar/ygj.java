import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ygj
  implements ygi
{
  private List<ygg> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((ygg)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((ygg)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(ygg paramygg)
  {
    if (paramygg == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(paramygg)) {
      throw new IllegalStateException("Observer " + paramygg + " is already registered.");
    }
    this.a.add(paramygg);
  }
  
  public void b(ygg paramygg)
  {
    if (paramygg == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    int i;
    synchronized (this.a)
    {
      i = this.a.indexOf(paramygg);
      if (i == -1) {
        throw new IllegalStateException("Observer " + paramygg + " was not registered.");
      }
    }
    this.a.remove(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygj
 * JD-Core Version:    0.7.0.1
 */