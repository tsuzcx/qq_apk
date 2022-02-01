import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ris
  implements rir
{
  private List<rip> jC = new ArrayList();
  
  public void a(rip paramrip)
  {
    if (paramrip == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.jC.contains(paramrip)) {
      throw new IllegalStateException("Observer " + paramrip + " is already registered.");
    }
    this.jC.add(paramrip);
  }
  
  public void b(rip paramrip)
  {
    if (paramrip == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    int i;
    synchronized (this.jC)
    {
      i = this.jC.indexOf(paramrip);
      if (i == -1) {
        throw new IllegalStateException("Observer " + paramrip + " was not registered.");
      }
    }
    this.jC.remove(i);
  }
  
  public void buP()
  {
    Iterator localIterator = this.jC.iterator();
    while (localIterator.hasNext()) {
      ((rip)localIterator.next()).buP();
    }
  }
  
  public void xA(int paramInt)
  {
    Iterator localIterator = this.jC.iterator();
    while (localIterator.hasNext()) {
      ((rip)localIterator.next()).xA(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ris
 * JD-Core Version:    0.7.0.1
 */