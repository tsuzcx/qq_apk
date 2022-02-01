package wf7;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class fk<K, V>
{
  private int pZ = -1;
  private LinkedHashMap<K, V> qa = new LinkedHashMap();
  
  public fk(int paramInt)
  {
    this.pZ = paramInt;
  }
  
  public void a(K paramK)
  {
    this.qa.remove(paramK);
  }
  
  public LinkedHashMap<K, V> dK()
  {
    return this.qa;
  }
  
  public V get(K paramK)
  {
    return this.qa.get(paramK);
  }
  
  public V put(K paramK, V paramV)
  {
    if (this.qa.size() >= this.pZ)
    {
      Object localObject = this.qa.keySet();
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        this.qa.remove(((Iterator)localObject).next());
      }
    }
    return this.qa.put(paramK, paramV);
  }
  
  public int size()
  {
    return this.qa.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.fk
 * JD-Core Version:    0.7.0.1
 */