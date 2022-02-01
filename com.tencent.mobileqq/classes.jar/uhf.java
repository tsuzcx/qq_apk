import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class uhf
{
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<uhi>>> a = new ConcurrentHashMap();
  
  public static uhf a()
  {
    return uhh.a();
  }
  
  private void a(String paramString, uhi paramuhi)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.a.get(paramString);
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(paramuhi.hashCode()), new WeakReference(paramuhi));
    this.a.put(paramString, localConcurrentHashMap1);
    uqf.b("WSSimpleEventBus", 2, "registerReceiver event Name:" + paramString + ",key：[" + paramuhi.getClass().getSimpleName() + ":" + paramuhi.hashCode() + "], subscribers size:" + localConcurrentHashMap1.size());
  }
  
  private void b(String paramString, uhi paramuhi)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.a.get(paramString);
    if (localConcurrentHashMap == null) {
      return;
    }
    localConcurrentHashMap.remove(Integer.valueOf(paramuhi.hashCode()));
    if (localConcurrentHashMap.size() == 0) {
      this.a.remove(paramString);
    }
    uqf.b("WSSimpleEventBus", 2, "unRegisterReceiver event Name:" + paramString + ",key：[" + paramuhi.getClass().getSimpleName() + ":" + paramuhi.hashCode() + "], subscribers size:" + localConcurrentHashMap.size());
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
          ((uhi)localWeakReference.get()).a(paramWSSimpleBaseEvent);
        }
      }
    }
  }
  
  public void a(uhi paramuhi)
  {
    if (paramuhi == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramuhi.getEventClass().iterator();
      while (localIterator.hasNext()) {
        a(((Class)localIterator.next()).getName(), paramuhi);
      }
    }
  }
  
  public void b(uhi paramuhi)
  {
    if (paramuhi == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramuhi.getEventClass().iterator();
      while (localIterator.hasNext()) {
        b(((Class)localIterator.next()).getName(), paramuhi);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhf
 * JD-Core Version:    0.7.0.1
 */