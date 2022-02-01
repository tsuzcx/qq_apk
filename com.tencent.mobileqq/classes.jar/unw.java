import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class unw
{
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<unz>>> a = new ConcurrentHashMap();
  
  public static unw a()
  {
    return uny.a();
  }
  
  private void a(String paramString, unz paramunz)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.a.get(paramString);
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(paramunz.hashCode()), new WeakReference(paramunz));
    this.a.put(paramString, localConcurrentHashMap1);
    uya.b("WSSimpleEventBus", 2, "registerReceiver event Name:" + paramString + ",key：[" + paramunz.getClass().getSimpleName() + ":" + paramunz.hashCode() + "], subscribers size:" + localConcurrentHashMap1.size());
  }
  
  private void b(String paramString, unz paramunz)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.a.get(paramString);
    if (localConcurrentHashMap == null) {
      return;
    }
    localConcurrentHashMap.remove(Integer.valueOf(paramunz.hashCode()));
    if (localConcurrentHashMap.size() == 0) {
      this.a.remove(paramString);
    }
    uya.b("WSSimpleEventBus", 2, "unRegisterReceiver event Name:" + paramString + ",key：[" + paramunz.getClass().getSimpleName() + ":" + paramunz.hashCode() + "], subscribers size:" + localConcurrentHashMap.size());
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    Object localObject = (ConcurrentHashMap)this.a.get(paramWSSimpleBaseEvent.getClass().getName());
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((unz)localWeakReference.get()).a(paramWSSimpleBaseEvent);
        }
      }
    }
  }
  
  public void a(unz paramunz)
  {
    if (paramunz == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramunz.a().iterator();
      while (localIterator.hasNext()) {
        a(((Class)localIterator.next()).getName(), paramunz);
      }
    }
  }
  
  public void b(unz paramunz)
  {
    if (paramunz == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramunz.a().iterator();
      while (localIterator.hasNext()) {
        b(((Class)localIterator.next()).getName(), paramunz);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unw
 * JD-Core Version:    0.7.0.1
 */