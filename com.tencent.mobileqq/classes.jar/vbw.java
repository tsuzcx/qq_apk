import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class vbw
{
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<vbz>>> a = new ConcurrentHashMap();
  
  public static vbw a()
  {
    return vby.a();
  }
  
  private void a(String paramString, vbz paramvbz)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.a.get(paramString);
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(paramvbz.hashCode()), new WeakReference(paramvbz));
    this.a.put(paramString, localConcurrentHashMap1);
    vmp.b("WSSimpleEventBus", 2, "registerReceiver event Name:" + paramString + ",key：[" + paramvbz.getClass().getSimpleName() + ":" + paramvbz.hashCode() + "], subscribers size:" + localConcurrentHashMap1.size());
  }
  
  private void b(String paramString, vbz paramvbz)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.a.get(paramString);
    if (localConcurrentHashMap == null) {
      return;
    }
    localConcurrentHashMap.remove(Integer.valueOf(paramvbz.hashCode()));
    if (localConcurrentHashMap.size() == 0) {
      this.a.remove(paramString);
    }
    vmp.b("WSSimpleEventBus", 2, "unRegisterReceiver event Name:" + paramString + ",key：[" + paramvbz.getClass().getSimpleName() + ":" + paramvbz.hashCode() + "], subscribers size:" + localConcurrentHashMap.size());
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
          ((vbz)localWeakReference.get()).a(paramWSSimpleBaseEvent);
        }
      }
    }
  }
  
  public void a(vbz paramvbz)
  {
    if (paramvbz == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramvbz.a().iterator();
      while (localIterator.hasNext()) {
        a(((Class)localIterator.next()).getName(), paramvbz);
      }
    }
  }
  
  public void b(vbz paramvbz)
  {
    if (paramvbz == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramvbz.a().iterator();
      while (localIterator.hasNext()) {
        b(((Class)localIterator.next()).getName(), paramvbz);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbw
 * JD-Core Version:    0.7.0.1
 */