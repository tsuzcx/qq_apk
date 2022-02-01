import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class aynj
  implements ayni
{
  private List<ayng> jC = new ArrayList();
  
  public void a(ayng paramayng)
  {
    if (paramayng == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.jC.contains(paramayng)) {
      throw new IllegalStateException("Observer " + paramayng + " is already registered.");
    }
    this.jC.add(paramayng);
  }
  
  public void b(ayng paramayng)
  {
    if (paramayng == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    synchronized (this.jC)
    {
      int i = this.jC.indexOf(paramayng);
      if (i != -1) {
        this.jC.remove(i);
      }
      return;
    }
  }
  
  public void buP()
  {
    Iterator localIterator = this.jC.iterator();
    while (localIterator.hasNext()) {
      ((ayng)localIterator.next()).buP();
    }
  }
  
  public void xA(int paramInt)
  {
    Iterator localIterator = this.jC.iterator();
    while (localIterator.hasNext()) {
      ((ayng)localIterator.next()).xA(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aynj
 * JD-Core Version:    0.7.0.1
 */