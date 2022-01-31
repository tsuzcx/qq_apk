import common.qzone.component.cache.common.SoftHashMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

public class fjp
  extends AbstractSet
{
  public fjp(SoftHashMap paramSoftHashMap) {}
  
  public void clear()
  {
    this.a.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    fjn localfjn;
    do
    {
      return false;
      paramObject = (Map.Entry)paramObject;
      localfjn = SoftHashMap.a(this.a, paramObject.getKey());
    } while ((localfjn == null) || (!localfjn.equals(paramObject)));
    return true;
  }
  
  public Iterator iterator()
  {
    return new fjo(this.a);
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
      localArrayList.add(new fjt((Map.Entry)localIterator.next()));
    }
    return localArrayList.toArray();
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    ArrayList localArrayList = new ArrayList(size());
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new fjt((Map.Entry)localIterator.next()));
    }
    return localArrayList.toArray(paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fjp
 * JD-Core Version:    0.7.0.1
 */