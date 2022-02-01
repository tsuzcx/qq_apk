import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class mpt<K, V>
{
  private Map ex = new LinkedHashMap();
  
  public void a(V paramV, mpt.a parama)
  {
    this.ex.put(parama, paramV);
  }
  
  public boolean a(K paramK, mpt.b paramb)
  {
    Iterator localIterator = this.ex.keySet().iterator();
    while (localIterator.hasNext())
    {
      mpt.a locala = (mpt.a)localIterator.next();
      if ((locala != null) && (!locala.p(paramK)))
      {
        if ((paramb != null) && (this.ex.get(locala) != null)) {
          paramb.X(this.ex.get(locala));
        }
        return false;
      }
    }
    if (paramb != null) {
      paramb.aRb();
    }
    return true;
  }
  
  public static abstract interface a<V>
  {
    public abstract boolean p(V paramV);
  }
  
  public static abstract interface b<V>
  {
    public abstract void X(V paramV);
    
    public abstract void aRb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mpt
 * JD-Core Version:    0.7.0.1
 */