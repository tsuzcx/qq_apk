import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskResMgr.initLocalRes.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskResMgr;", "", "()V", "TAG", "", "hasInit", "", "getHasInit", "()Z", "setHasInit", "(Z)V", "lock", "getLock", "()Ljava/lang/Object;", "reqResList", "Ljava/util/concurrent/ConcurrentHashMap;", "getReqResList", "()Ljava/util/concurrent/ConcurrentHashMap;", "setReqResList", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "addNewRes", "", "data", "doInit", "findResDataFromLocal", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskResMgr$SuperMaskJson;", "adId", "adSource", "getLocalResList", "initLocalRes", "removeInvalidRes", "SuperMaskJson", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ujh
{
  @NotNull
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  @NotNull
  private static ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public static final ujh a;
  private static volatile boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Ujh = new ujh();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private final void b()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      boolean bool = jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = jdField_a_of_type_Ujh.b();
      jdField_a_of_type_Boolean = true;
      QLog.d("ReadInJoySuperMaskAd", 1, "SuperMaskResMgr init finish");
      Unit localUnit = Unit.INSTANCE;
      return;
    }
  }
  
  @NotNull
  public final ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> a()
  {
    return jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  @Nullable
  public final uji a(@Nullable String paramString1, @Nullable String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return null;
      paramString1 = uic.a(pnn.a()).a(paramString2 + "_" + paramString1);
      if (uja.c(paramString1)) {
        uja.a(paramString1);
      }
    } while (paramString1 == null);
    return new uji(paramString1.toJson());
  }
  
  public final void a()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))
    {
      ThreadManagerV2.post((Runnable)SuperMaskResMgr.initLocalRes.1.a, 10, null, true);
      return;
    }
    b();
  }
  
  public final void a(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof MaterialData)) {
      paramObject = null;
    }
    for (;;)
    {
      Object localObject = (MaterialData)paramObject;
      if ((localObject != null) && (uja.a((MaterialData)localObject)))
      {
        paramObject = new ConcurrentHashMap();
        uja.a((MaterialData)localObject, paramObject);
        if (!TextUtils.isEmpty((CharSequence)((MaterialData)localObject).adid))
        {
          Map localMap = (Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
          localObject = ((MaterialData)localObject).adid;
          Intrinsics.checkExpressionValueIsNotNull(localObject, "it.adid");
          localMap.put(localObject, paramObject);
        }
      }
      return;
    }
  }
  
  public final boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  @NotNull
  public final ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> b()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    long l1 = System.currentTimeMillis();
    Object localObject1 = uic.a(pnn.a());
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "AdMaterialResManager.get…InterfaceUtil.getQQApp())");
    localObject1 = ((uic)localObject1).a();
    if (((HashMap)localObject1).size() <= 0)
    {
      l2 = System.currentTimeMillis();
      ukq.a("ReadInJoySuperMaskAd", "getLocalResList time cost : " + (l2 - l1));
      return localConcurrentHashMap;
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "allDBData");
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject3 = ((Map.Entry)localObject2).getValue();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "it.value");
      if (uja.a((MaterialData)localObject3))
      {
        localObject3 = new ConcurrentHashMap();
        Object localObject4 = ((Map.Entry)localObject2).getValue();
        Intrinsics.checkExpressionValueIsNotNull(localObject4, "it.value");
        uja.a((MaterialData)localObject4, (ConcurrentHashMap)localObject3);
        if (!TextUtils.isEmpty((CharSequence)((MaterialData)((Map.Entry)localObject2).getValue()).adid))
        {
          localObject4 = (Map)localConcurrentHashMap;
          localObject2 = ((MaterialData)((Map.Entry)localObject2).getValue()).adid;
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.value.adid");
          ((Map)localObject4).put(localObject2, localObject3);
        }
      }
    }
    long l2 = System.currentTimeMillis();
    ukq.a("ReadInJoySuperMaskAd", "getLocalResList time cost : " + (l2 - l1));
    return localConcurrentHashMap;
  }
  
  public final void b(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof MaterialData)) {
      paramObject = null;
    }
    for (;;)
    {
      paramObject = (MaterialData)paramObject;
      if ((paramObject != null) && (!TextUtils.isEmpty((CharSequence)paramObject.adid))) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramObject.adid);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujh
 * JD-Core Version:    0.7.0.1
 */