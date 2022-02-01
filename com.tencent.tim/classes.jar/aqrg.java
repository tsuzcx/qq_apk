import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

public class aqrg<V>
  implements Manager
{
  private final ArrayList<aqrg.b<V>> CY = new ArrayList();
  
  public static <E> aqrg.a<E> a(aqrg.a<E> parama)
  {
    return new aqrg.c(parama);
  }
  
  public void A(String paramString, V paramV)
  {
    if (paramString == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      synchronized (this.CY)
      {
        i = this.CY.size() - 1;
        if (i >= 0)
        {
          aqrg.b localb = (aqrg.b)this.CY.get(i);
          if (paramString.equals(localb.scid))
          {
            this.CY.remove(i);
            localArrayList.add(localb);
          }
        }
        else
        {
          paramString = localArrayList.iterator();
          if (!paramString.hasNext()) {
            break;
          }
          ??? = (aqrg.b)paramString.next();
          ((aqrg.b)???).b.g(paramV, ((aqrg.b)???).params);
        }
      }
      i -= 1;
    }
  }
  
  public void a(String arg1, aqrg.a<V> parama, Object paramObject)
  {
    if (parama != null)
    {
      parama = new aqrg.b(parama, paramObject, ???);
      synchronized (this.CY)
      {
        this.CY.add(parama);
        return;
      }
    }
  }
  
  public void onDestroy()
  {
    synchronized (this.CY)
    {
      this.CY.clear();
      return;
    }
  }
  
  public static abstract interface a<E>
  {
    public abstract void g(E paramE, Object paramObject);
  }
  
  static class b<E>
  {
    public aqrg.a<E> b;
    public Object params;
    public String scid;
    
    public b(aqrg.a<E> parama, Object paramObject, String paramString)
    {
      this.b = parama;
      this.params = paramObject;
      this.scid = paramString;
    }
  }
  
  static class c<E>
    extends WeakReference<aqrg.a<E>>
    implements aqrg.a<E>
  {
    public c(aqrg.a<E> parama)
    {
      super();
    }
    
    public void g(E paramE, Object paramObject)
    {
      aqrg.a locala = (aqrg.a)get();
      if (locala != null) {
        locala.g(paramE, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqrg
 * JD-Core Version:    0.7.0.1
 */