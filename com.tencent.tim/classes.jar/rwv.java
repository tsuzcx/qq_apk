import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class rwv
{
  private static final rwv a = new rwv();
  public static String aDa = "SUBSCRIBE_IPC_MODULE";
  public static String aDb = "ACTION_PRAISED_UPDATE";
  public static String aDc = "ACTION_DRAFT_SYSTEM_CHANGE";
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<rwx>>> bE = new ConcurrentHashMap();
  private WeakReference<NativePlugin.JSContext> dm;
  
  private rwv()
  {
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      if (i != 0) {
        QIPCServerHelper.getInstance().register(new rww(this, "SUBSCRIBE_IPC_MODULE"));
      }
      return;
      i = 0;
    }
  }
  
  public static rwv a()
  {
    return a;
  }
  
  private void a(PraisedUpdateEvents paramPraisedUpdateEvents)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("feedid", paramPraisedUpdateEvents.mTargetFeedId);
      localJSONObject.put("likestatus", paramPraisedUpdateEvents.mPraisedStatus);
      paramPraisedUpdateEvents = new JSONObject();
      paramPraisedUpdateEvents.put("data", localJSONObject);
      ((NativePlugin.JSContext)this.dm.get()).callJs("onSubscribeDoLikeUpdateEvent", paramPraisedUpdateEvents);
      QLog.d("SimpleEventBus", 2, "notifyMiniProgram onSubscribeDoLikeUpdateEvent success ");
      return;
    }
    catch (JSONException paramPraisedUpdateEvents)
    {
      paramPraisedUpdateEvents.printStackTrace();
    }
  }
  
  private void a(String paramString, rwx paramrwx)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.bE.get(paramString);
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(paramrwx.hashCode()), new WeakReference(paramrwx));
    this.bE.put(paramString, localConcurrentHashMap1);
    QLog.d("SimpleEventBus", 2, "registerReceiver event Name:" + paramString + ",key：[" + paramrwx.getClass().getSimpleName() + ":" + paramrwx.hashCode() + "], subscribers size:" + localConcurrentHashMap1.size());
  }
  
  private void b(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((this.dm != null) && (this.dm.get() != null) && ((paramSimpleBaseEvent instanceof PraisedUpdateEvents))) {
      a((PraisedUpdateEvents)paramSimpleBaseEvent);
    }
  }
  
  private void b(String paramString, rwx paramrwx)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.bE.get(paramString);
    if (localConcurrentHashMap == null) {
      return;
    }
    localConcurrentHashMap.remove(Integer.valueOf(paramrwx.hashCode()));
    if (localConcurrentHashMap.size() == 0) {
      this.bE.remove(paramString);
    }
    QLog.d("SimpleEventBus", 2, "unRegisterReceiver event Name:" + paramString + ",key：[" + paramrwx.getClass().getSimpleName() + ":" + paramrwx.hashCode() + "], subscribers size:" + localConcurrentHashMap.size());
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    Object localObject = (ConcurrentHashMap)this.bE.get(paramSimpleBaseEvent.getClass().getName());
    if (localObject == null) {}
    for (;;)
    {
      return;
      b(paramSimpleBaseEvent);
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((rwx)localWeakReference.get()).onReceiveEvent(paramSimpleBaseEvent);
        }
      }
    }
  }
  
  public void a(NativePlugin.JSContext paramJSContext)
  {
    this.dm = new WeakReference(paramJSContext);
  }
  
  public void a(rwx paramrwx)
  {
    if (paramrwx == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramrwx.getEventClass().iterator();
      while (localIterator.hasNext()) {
        a(((Class)localIterator.next()).getName(), paramrwx);
      }
    }
  }
  
  public void b(rwx paramrwx)
  {
    if ((paramrwx == null) || (paramrwx.getEventClass() == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramrwx.getEventClass().iterator();
      while (localIterator.hasNext()) {
        b(((Class)localIterator.next()).getName(), paramrwx);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwv
 * JD-Core Version:    0.7.0.1
 */