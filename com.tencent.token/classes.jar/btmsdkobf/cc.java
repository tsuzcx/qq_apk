package btmsdkobf;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class cc<K, V>
{
  private int hu = -1;
  private LinkedHashMap<K, V> hv = new LinkedHashMap();
  
  public cc(int paramInt)
  {
    this.hu = paramInt;
  }
  
  public void a(K paramK)
  {
    try
    {
      this.hv.remove(paramK);
      return;
    }
    catch (Throwable paramK) {}
  }
  
  public LinkedHashMap<K, V> aT()
  {
    return this.hv;
  }
  
  public V get(K paramK)
  {
    return this.hv.get(paramK);
  }
  
  public V put(K paramK, V paramV)
  {
    Object localObject;
    if (this.hv.size() >= this.hu)
    {
      localObject = this.hv.keySet();
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {}
      }
    }
    try
    {
      this.hv.remove(((Iterator)localObject).next());
      label56:
      return this.hv.put(paramK, paramV);
    }
    catch (Throwable localThrowable)
    {
      break label56;
    }
  }
  
  public int size()
  {
    return this.hv.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cc
 * JD-Core Version:    0.7.0.1
 */