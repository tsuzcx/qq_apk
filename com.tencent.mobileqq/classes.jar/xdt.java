import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class xdt
  implements xds
{
  private List<xdq> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((xdq)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((xdq)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(xdq paramxdq)
  {
    if (paramxdq == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(paramxdq)) {
      throw new IllegalStateException("Observer " + paramxdq + " is already registered.");
    }
    this.a.add(paramxdq);
  }
  
  public void b(xdq paramxdq)
  {
    if (paramxdq == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    int i;
    synchronized (this.a)
    {
      i = this.a.indexOf(paramxdq);
      if (i == -1) {
        throw new IllegalStateException("Observer " + paramxdq + " was not registered.");
      }
    }
    this.a.remove(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xdt
 * JD-Core Version:    0.7.0.1
 */