import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class uhd
{
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<uhg>>> a = new ConcurrentHashMap();
  
  public static uhd a()
  {
    return uhf.a();
  }
  
  private void a(String paramString, uhg paramuhg)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.a.get(paramString);
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(paramuhg.hashCode()), new WeakReference(paramuhg));
    this.a.put(paramString, localConcurrentHashMap1);
    upe.b("WSSimpleEventBus", 2, "registerReceiver event Name:" + paramString + ",key：[" + paramuhg.getClass().getSimpleName() + ":" + paramuhg.hashCode() + "], subscribers size:" + localConcurrentHashMap1.size());
  }
  
  private void b(String paramString, uhg paramuhg)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.a.get(paramString);
    if (localConcurrentHashMap == null) {
      return;
    }
    localConcurrentHashMap.remove(Integer.valueOf(paramuhg.hashCode()));
    if (localConcurrentHashMap.size() == 0) {
      this.a.remove(paramString);
    }
    upe.b("WSSimpleEventBus", 2, "unRegisterReceiver event Name:" + paramString + ",key：[" + paramuhg.getClass().getSimpleName() + ":" + paramuhg.hashCode() + "], subscribers size:" + localConcurrentHashMap.size());
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
          ((uhg)localWeakReference.get()).a(paramWSSimpleBaseEvent);
        }
      }
    }
  }
  
  public void a(uhg paramuhg)
  {
    if (paramuhg == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramuhg.getEventClass().iterator();
      while (localIterator.hasNext()) {
        a(((Class)localIterator.next()).getName(), paramuhg);
      }
    }
  }
  
  public void b(uhg paramuhg)
  {
    if (paramuhg == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramuhg.getEventClass().iterator();
      while (localIterator.hasNext()) {
        b(((Class)localIterator.next()).getName(), paramuhg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uhd
 * JD-Core Version:    0.7.0.1
 */