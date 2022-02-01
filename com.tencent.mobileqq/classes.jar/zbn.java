import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class zbn
  implements zbm
{
  private List<zbk> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((zbk)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((zbk)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(zbk paramzbk)
  {
    if (paramzbk == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(paramzbk)) {
      throw new IllegalStateException("Observer " + paramzbk + " is already registered.");
    }
    this.a.add(paramzbk);
  }
  
  public void b(zbk paramzbk)
  {
    if (paramzbk == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    int i;
    synchronized (this.a)
    {
      i = this.a.indexOf(paramzbk);
      if (i == -1) {
        throw new IllegalStateException("Observer " + paramzbk + " was not registered.");
      }
    }
    this.a.remove(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zbn
 * JD-Core Version:    0.7.0.1
 */