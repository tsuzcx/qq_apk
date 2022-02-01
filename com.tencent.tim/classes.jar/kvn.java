import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class kvn
{
  kvn.a a;
  HashMap<String, HashSet<Object>> dx = new HashMap();
  
  public kvn(kvn.a parama)
  {
    this.a = parama;
  }
  
  private void g(String paramString, Object paramObject)
  {
    HashSet localHashSet2 = (HashSet)this.dx.get(paramString);
    if ((localHashSet2 != null) && (localHashSet2.contains(paramObject))) {
      return;
    }
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null) {
      localHashSet1 = new HashSet();
    }
    localHashSet1.add(paramObject);
    this.dx.put(paramString, localHashSet1);
  }
  
  public void a(String paramString, Object paramObject, boolean paramBoolean)
  {
    g(paramString, paramObject);
    if (paramBoolean) {}
    while (this.a == null) {
      return;
    }
    this.a.h(paramString, paramObject);
  }
  
  public void aHu()
  {
    if ((this.a != null) && (!this.dx.isEmpty()))
    {
      Iterator localIterator1 = this.dx.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        Iterator localIterator2 = ((HashSet)localEntry.getValue()).iterator();
        while (localIterator2.hasNext())
        {
          Object localObject = localIterator2.next();
          this.a.h((String)localEntry.getKey(), localObject);
        }
      }
    }
  }
  
  public void clearAll()
  {
    this.dx.clear();
  }
  
  public void f(String paramString, Object paramObject)
  {
    a(paramString, paramObject, true);
  }
  
  public static abstract interface a
  {
    public abstract void h(String paramString, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kvn
 * JD-Core Version:    0.7.0.1
 */