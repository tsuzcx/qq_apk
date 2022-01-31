import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class vpb
  implements vpa
{
  private List<voy> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((voy)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((voy)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(voy paramvoy)
  {
    if (paramvoy == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(paramvoy)) {
      throw new IllegalStateException("Observer " + paramvoy + " is already registered.");
    }
    this.a.add(paramvoy);
  }
  
  public void b(voy paramvoy)
  {
    if (paramvoy == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    int i;
    synchronized (this.a)
    {
      i = this.a.indexOf(paramvoy);
      if (i == -1) {
        throw new IllegalStateException("Observer " + paramvoy + " was not registered.");
      }
    }
    this.a.remove(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vpb
 * JD-Core Version:    0.7.0.1
 */