import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class yvc
  implements yvb
{
  private List<yuz> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((yuz)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((yuz)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(yuz paramyuz)
  {
    if (paramyuz == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(paramyuz)) {
      throw new IllegalStateException("Observer " + paramyuz + " is already registered.");
    }
    this.a.add(paramyuz);
  }
  
  public void b(yuz paramyuz)
  {
    if (paramyuz == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    int i;
    synchronized (this.a)
    {
      i = this.a.indexOf(paramyuz);
      if (i == -1) {
        throw new IllegalStateException("Observer " + paramyuz + " was not registered.");
      }
    }
    this.a.remove(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yvc
 * JD-Core Version:    0.7.0.1
 */