import common.qzone.component.cache.common.SoftHashMap;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class fjv
  extends AbstractCollection
{
  public fjv(SoftHashMap paramSoftHashMap) {}
  
  public void clear()
  {
    this.a.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.a.containsValue(paramObject);
  }
  
  public Iterator iterator()
  {
    return new fju(this.a);
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
 * Qualified Name:     fjv
 * JD-Core Version:    0.7.0.1
 */