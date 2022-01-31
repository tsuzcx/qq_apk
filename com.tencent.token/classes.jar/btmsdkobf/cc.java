package btmsdkobf;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class cc
{
  private int hu = -1;
  private LinkedHashMap hv = new LinkedHashMap();
  
  public cc(int paramInt)
  {
    this.hu = paramInt;
  }
  
  public void a(Object paramObject)
  {
    try
    {
      this.hv.remove(paramObject);
      return;
    }
    catch (Throwable paramObject) {}
  }
  
  public LinkedHashMap aT()
  {
    return this.hv;
  }
  
  public Object get(Object paramObject)
  {
    return this.hv.get(paramObject);
  }
  
  public Object put(Object paramObject1, Object paramObject2)
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
      return this.hv.put(paramObject1, paramObject2);
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