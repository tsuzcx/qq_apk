import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class xic
  implements xib
{
  private List<xhz> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((xhz)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((xhz)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(xhz paramxhz)
  {
    if (paramxhz == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(paramxhz)) {
      throw new IllegalStateException("Observer " + paramxhz + " is already registered.");
    }
    this.a.add(paramxhz);
  }
  
  public void b(xhz paramxhz)
  {
    if (paramxhz == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    int i;
    synchronized (this.a)
    {
      i = this.a.indexOf(paramxhz);
      if (i == -1) {
        throw new IllegalStateException("Observer " + paramxhz + " was not registered.");
      }
    }
    this.a.remove(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xic
 * JD-Core Version:    0.7.0.1
 */