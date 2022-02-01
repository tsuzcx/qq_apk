import common.qzone.component.cache.common.SoftHashMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

public class hzg
  extends AbstractSet
{
  public hzg(SoftHashMap paramSoftHashMap) {}
  
  public void clear()
  {
    this.a.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    hze localhze;
    do
    {
      return false;
      paramObject = (Map.Entry)paramObject;
      localhze = SoftHashMap.a(this.a, paramObject.getKey());
    } while ((localhze == null) || (!localhze.equals(paramObject)));
    return true;
  }
  
  public Iterator iterator()
  {
    return new hzf(this.a);
  }
  
  public boolean remove(Object paramObject)
  {
    return SoftHashMap.b(this.a, paramObject) != null;
  }
  
  public int size()
  {
    return this.a.size();
  }
  
  public Object[] toArray()
  {
    ArrayList localArrayList = new ArrayList(size());
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new hzk((Map.Entry)localIterator.next()));
    }
    return localArrayList.toArray();
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    ArrayList localArrayList = new ArrayList(size());
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new hzk((Map.Entry)localIterator.next()));
    }
    return localArrayList.toArray(paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hzg
 * JD-Core Version:    0.7.0.1
 */