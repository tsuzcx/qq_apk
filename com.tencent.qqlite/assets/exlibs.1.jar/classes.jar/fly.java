import common.qzone.component.cache.common.SoftHashMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class fly
  extends AbstractSet
{
  public fly(SoftHashMap paramSoftHashMap) {}
  
  public void clear()
  {
    this.a.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.a.containsKey(paramObject);
  }
  
  public Iterator iterator()
  {
    return new flx(this.a);
  }
  
  public boolean remove(Object paramObject)
  {
    if (this.a.containsKey(paramObject))
    {
      this.a.remove(paramObject);
      return true;
    }
    return false;
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
      localArrayList.add(localIterator.next());
    }
    return localArrayList.toArray();
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    ArrayList localArrayList = new ArrayList(size());
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(localIterator.next());
    }
    return localArrayList.toArray(paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fly
 * JD-Core Version:    0.7.0.1
 */