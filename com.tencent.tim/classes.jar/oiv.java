import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class oiv
{
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<oix>>> bE = new ConcurrentHashMap();
  
  public static oiv a()
  {
    return oiv.a.b();
  }
  
  private void a(String paramString, oix paramoix)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.bE.get(paramString);
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(paramoix.hashCode()), new WeakReference(paramoix));
    this.bE.put(paramString, localConcurrentHashMap1);
    ooz.d("WSSimpleEventBus", 2, "registerReceiver event Name:" + paramString + ",key：[" + paramoix.getClass().getSimpleName() + ":" + paramoix.hashCode() + "], subscribers size:" + localConcurrentHashMap1.size());
  }
  
  private void b(String paramString, oix paramoix)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.bE.get(paramString);
    if (localConcurrentHashMap == null) {
      return;
    }
    localConcurrentHashMap.remove(Integer.valueOf(paramoix.hashCode()));
    if (localConcurrentHashMap.size() == 0) {
      this.bE.remove(paramString);
    }
    ooz.d("WSSimpleEventBus", 2, "unRegisterReceiver event Name:" + paramString + ",key：[" + paramoix.getClass().getSimpleName() + ":" + paramoix.hashCode() + "], subscribers size:" + localConcurrentHashMap.size());
  }
  
  public void a(oix paramoix)
  {
    if (paramoix == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramoix.getEventClass().iterator();
      while (localIterator.hasNext()) {
        a(((Class)localIterator.next()).getName(), paramoix);
      }
    }
  }
  
  public void b(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    Object localObject = (ConcurrentHashMap)this.bE.get(paramWSSimpleBaseEvent.getClass().getName());
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((oix)localWeakReference.get()).a(paramWSSimpleBaseEvent);
        }
      }
    }
  }
  
  public void b(oix paramoix)
  {
    if (paramoix == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramoix.getEventClass().iterator();
      while (localIterator.hasNext()) {
        b(((Class)localIterator.next()).getName(), paramoix);
      }
    }
  }
  
  static class a
  {
    private static final oiv a = new oiv(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oiv
 * JD-Core Version:    0.7.0.1
 */