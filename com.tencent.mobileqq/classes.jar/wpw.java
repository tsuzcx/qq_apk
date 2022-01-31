import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
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

public class wpw
{
  public static String a;
  private static final wpw jdField_a_of_type_Wpw = new wpw();
  public static String b = "ACTION_PRAISED_UPDATE";
  public static String c = "ACTION_DRAFT_SYSTEM_CHANGE";
  private WeakReference<NativePlugin.JSContext> jdField_a_of_type_JavaLangRefWeakReference;
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<wpy>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "SUBSCRIBE_IPC_MODULE";
  }
  
  private wpw()
  {
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      if (i != 0) {
        QIPCServerHelper.getInstance().register(new wpx(this, "SUBSCRIBE_IPC_MODULE"));
      }
      return;
      i = 0;
    }
  }
  
  public static wpw a()
  {
    return jdField_a_of_type_Wpw;
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
      ((NativePlugin.JSContext)this.jdField_a_of_type_JavaLangRefWeakReference.get()).callJs("onSubscribeDoLikeUpdateEvent", paramPraisedUpdateEvents);
      QLog.d("SimpleEventBus", 2, "notifyMiniProgram onSubscribeDoLikeUpdateEvent success ");
      return;
    }
    catch (JSONException paramPraisedUpdateEvents)
    {
      paramPraisedUpdateEvents.printStackTrace();
    }
  }
  
  private void a(String paramString, wpy paramwpy)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(paramwpy.hashCode()), new WeakReference(paramwpy));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localConcurrentHashMap1);
    QLog.d("SimpleEventBus", 2, "registerReceiver event Name:" + paramString + ",key：[" + paramwpy.getClass().getSimpleName() + ":" + paramwpy.hashCode() + "], subscribers size:" + localConcurrentHashMap1.size());
  }
  
  private void b(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((paramSimpleBaseEvent instanceof PraisedUpdateEvents))) {
      a((PraisedUpdateEvents)paramSimpleBaseEvent);
    }
  }
  
  private void b(String paramString, wpy paramwpy)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localConcurrentHashMap == null) {
      return;
    }
    localConcurrentHashMap.remove(Integer.valueOf(paramwpy.hashCode()));
    if (localConcurrentHashMap.size() == 0) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
    QLog.d("SimpleEventBus", 2, "unRegisterReceiver event Name:" + paramString + ",key：[" + paramwpy.getClass().getSimpleName() + ":" + paramwpy.hashCode() + "], subscribers size:" + localConcurrentHashMap.size());
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    Object localObject = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramSimpleBaseEvent.getClass().getName());
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
          ((wpy)localWeakReference.get()).a(paramSimpleBaseEvent);
        }
      }
    }
  }
  
  public void a(NativePlugin.JSContext paramJSContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramJSContext);
  }
  
  public void a(wpy paramwpy)
  {
    if (paramwpy == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramwpy.a().iterator();
      while (localIterator.hasNext()) {
        a(((Class)localIterator.next()).getName(), paramwpy);
      }
    }
  }
  
  public void b(wpy paramwpy)
  {
    if (paramwpy == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramwpy.a().iterator();
      while (localIterator.hasNext()) {
        b(((Class)localIterator.next()).getName(), paramwpy);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wpw
 * JD-Core Version:    0.7.0.1
 */