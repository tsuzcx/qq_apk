import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class aqso<E>
{
  private HashMap<String, CopyOnWriteArrayList<E>> map = new HashMap();
  
  public void C(String paramString, E paramE)
  {
    try
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList2 = (CopyOnWriteArrayList)this.map.get(paramString);
      CopyOnWriteArrayList localCopyOnWriteArrayList1 = localCopyOnWriteArrayList2;
      if (localCopyOnWriteArrayList2 == null)
      {
        localCopyOnWriteArrayList1 = new CopyOnWriteArrayList();
        this.map.put(paramString, localCopyOnWriteArrayList1);
      }
      localCopyOnWriteArrayList1.add(paramE);
      return;
    }
    finally {}
  }
  
  public List<E> bf(String paramString)
  {
    try
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.map.remove(paramString);
      paramString = localCopyOnWriteArrayList;
      if (localCopyOnWriteArrayList == null) {
        paramString = Collections.emptyList();
      }
      return paramString;
    }
    finally {}
  }
  
  public void d(String paramString, Object paramObject, boolean paramBoolean)
  {
    try
    {
      paramString = (CopyOnWriteArrayList)this.map.get(paramString);
      if (paramString != null)
      {
        if (paramBoolean)
        {
          Iterator localIterator = paramString.iterator();
          while (localIterator.hasNext())
          {
            Object localObject1 = localIterator.next();
            Object localObject2 = ((WeakReference)localObject1).get();
            if ((localObject2 == null) || (localObject2 == paramObject)) {
              paramString.remove(localObject1);
            }
          }
        }
        paramString.remove(paramObject);
      }
    }
    finally {}
  }
  
  public List<E> get(String paramString)
  {
    try
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.map.get(paramString);
      paramString = localCopyOnWriteArrayList;
      if (localCopyOnWriteArrayList == null) {
        paramString = Collections.emptyList();
      }
      return paramString;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqso
 * JD-Core Version:    0.7.0.1
 */