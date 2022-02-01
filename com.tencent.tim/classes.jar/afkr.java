import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class afkr
{
  private static afkr a;
  ArrayList<WeakReference<afkq>> wh = new ArrayList();
  
  public static afkr a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new afkr();
      }
      return a;
    }
    finally {}
  }
  
  public void My(int paramInt)
  {
    if ((this.wh != null) && (this.wh.size() > 0))
    {
      Iterator localIterator = this.wh.iterator();
      while (localIterator.hasNext())
      {
        afkq localafkq = (afkq)((WeakReference)localIterator.next()).get();
        if (localafkq != null) {
          localafkq.Mx(paramInt);
        }
      }
    }
  }
  
  public void a(afkq paramafkq)
  {
    if (paramafkq == null) {
      return;
    }
    synchronized (this.wh)
    {
      Iterator localIterator = this.wh.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramafkq) {
          return;
        }
      }
    }
    paramafkq = new WeakReference(paramafkq);
    this.wh.add(paramafkq);
  }
  
  public void b(afkq paramafkq)
  {
    if (paramafkq == null) {
      return;
    }
    synchronized (this.wh)
    {
      Iterator localIterator = this.wh.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramafkq) {
          localIterator.remove();
        }
      }
    }
  }
  
  public void destory()
  {
    synchronized (this.wh)
    {
      this.wh.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afkr
 * JD-Core Version:    0.7.0.1
 */