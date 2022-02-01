import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/impl/SuperMaskResMgr;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/ISuperMaskRes;", "()V", "TAG", "", "hasInit", "", "getHasInit", "()Z", "setHasInit", "(Z)V", "reqResList", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getReqResList", "()Ljava/util/concurrent/ConcurrentHashMap;", "setReqResList", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "addNewRes", "", "data", "doInit", "findResDataFromLocal", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/ISuperMaskRes$SuperMaskJson;", "adId", "adSource", "getLocalResList", "initLocalRes", "removeInvalidRes", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tvh
  implements tux
{
  @NotNull
  private static ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public static final tvh a;
  private static volatile boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Tvh = new tvh();
  }
  
  private final void b()
  {
    a(b());
    a(true);
    QLog.d("ReadInJoySuperMaskAd", 1, "SuperMaskResMgr init finish");
  }
  
  @NotNull
  public ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> a()
  {
    return jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  @Nullable
  public tuy a(@Nullable String paramString1, @Nullable String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return null;
      paramString1 = ttv.a(pay.a()).a(paramString2 + "_" + paramString1);
      if (tuw.c(paramString1)) {
        tuw.a(paramString1);
      }
    } while (paramString1 == null);
    return new tuy(paramString1.toJson());
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 136	tvh:a	()Z
    //   6: ifne +28 -> 34
    //   9: invokestatic 142	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   12: invokestatic 145	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   15: invokestatic 151	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   18: ifeq +19 -> 37
    //   21: getstatic 156	com/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/impl/SuperMaskResMgr$initLocalRes$1:a	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/impl/SuperMaskResMgr$initLocalRes$1;
    //   24: checkcast 158	java/lang/Runnable
    //   27: bipush 10
    //   29: aconst_null
    //   30: iconst_1
    //   31: invokestatic 164	com/tencent/mobileqq/app/ThreadManagerV2:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: invokespecial 66	tvh:b	()V
    //   41: goto -7 -> 34
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	tvh
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	44	finally
    //   37	41	44	finally
  }
  
  public void a(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof MaterialData)) {
      paramObject = null;
    }
    for (;;)
    {
      Object localObject = (MaterialData)paramObject;
      if ((localObject != null) && (tuw.a((MaterialData)localObject)))
      {
        paramObject = new ConcurrentHashMap();
        tuw.a((MaterialData)localObject, paramObject);
        if (!TextUtils.isEmpty((CharSequence)((MaterialData)localObject).adid))
        {
          Map localMap = (Map)jdField_a_of_type_Tvh.a();
          localObject = ((MaterialData)localObject).adid;
          Intrinsics.checkExpressionValueIsNotNull(localObject, "it.adid");
          localMap.put(localObject, paramObject);
        }
      }
      return;
    }
  }
  
  public void a(@NotNull ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> paramConcurrentHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramConcurrentHashMap, "<set-?>");
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
  }
  
  public void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  @NotNull
  public ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> b()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    long l1 = System.currentTimeMillis();
    Object localObject1 = ttv.a(pay.a());
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "AdMaterialResManager.get…eadInJoyUtils.getQQApp())");
    localObject1 = ((ttv)localObject1).a();
    if (((HashMap)localObject1).size() <= 0)
    {
      l2 = System.currentTimeMillis();
      twp.a("ReadInJoySuperMaskAd", "getLocalResList time cost : " + (l2 - l1));
      return localConcurrentHashMap;
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "allDBData");
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject3 = ((Map.Entry)localObject2).getValue();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "it.value");
      if (tuw.a((MaterialData)localObject3))
      {
        localObject3 = new ConcurrentHashMap();
        Object localObject4 = ((Map.Entry)localObject2).getValue();
        Intrinsics.checkExpressionValueIsNotNull(localObject4, "it.value");
        tuw.a((MaterialData)localObject4, (ConcurrentHashMap)localObject3);
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
    twp.a("ReadInJoySuperMaskAd", "getLocalResList time cost : " + (l2 - l1));
    return localConcurrentHashMap;
  }
  
  public void b(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof MaterialData)) {
      paramObject = null;
    }
    for (;;)
    {
      paramObject = (MaterialData)paramObject;
      if ((paramObject != null) && (!TextUtils.isEmpty((CharSequence)paramObject.adid))) {
        jdField_a_of_type_Tvh.a().remove(paramObject.adid);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvh
 * JD-Core Version:    0.7.0.1
 */