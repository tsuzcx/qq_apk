import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class zfi
  implements zfh
{
  private List<zff> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((zff)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((zff)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(zff paramzff)
  {
    if (paramzff == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(paramzff)) {
      throw new IllegalStateException("Observer " + paramzff + " is already registered.");
    }
    this.a.add(paramzff);
  }
  
  public void b(zff paramzff)
  {
    if (paramzff == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    int i;
    synchronized (this.a)
    {
      i = this.a.indexOf(paramzff);
      if (i == -1) {
        throw new IllegalStateException("Observer " + paramzff + " was not registered.");
      }
    }
    this.a.remove(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zfi
 * JD-Core Version:    0.7.0.1
 */