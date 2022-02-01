import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aveg<K, V>
  implements Map<K, V>
{
  private final HashMap<K, V> mMap = new HashMap();
  private final HashMap<V, K> qu = new HashMap();
  
  public void clear()
  {
    this.mMap.clear();
    this.qu.clear();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.mMap.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return this.qu.containsKey(paramObject);
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return this.mMap.entrySet();
  }
  
  public V get(Object paramObject)
  {
    return this.mMap.get(paramObject);
  }
  
  public K h(Object paramObject)
  {
    return this.qu.get(paramObject);
  }
  
  public boolean isEmpty()
  {
    return this.mMap.isEmpty();
  }
  
  public Set<K> keySet()
  {
    return this.mMap.keySet();
  }
  
  public V put(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      return null;
    }
    Object localObject = remove(paramK);
    removeByValue(paramV);
    this.mMap.put(paramK, paramV);
    this.qu.put(paramV, paramK);
    return localObject;
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (Map.Entry)paramMap.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if ((localObject1 != null) && (localObject2 != null)) {
        put(localObject1, localObject2);
      }
    }
  }
  
  public V remove(Object paramObject)
  {
    paramObject = this.mMap.remove(paramObject);
    if (paramObject != null) {
      this.qu.remove(paramObject);
    }
    return paramObject;
  }
  
  public K removeByValue(Object paramObject)
  {
    paramObject = this.qu.remove(paramObject);
    if (paramObject != null) {
      this.mMap.remove(paramObject);
    }
    return paramObject;
  }
  
  public int size()
  {
    return this.mMap.size();
  }
  
  public Collection<V> values()
  {
    return this.mMap.values();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aveg
 * JD-Core Version:    0.7.0.1
 */