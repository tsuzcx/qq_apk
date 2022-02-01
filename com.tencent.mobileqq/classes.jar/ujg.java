import android.content.Context;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.biz.pubaccount.NativeAd.report.ExposeMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskReportMgr;", "", "()V", "APP_KEY_FOR_USER_ACTION", "", "CLICK_POS_AD_AREA", "", "DOWNLOAD_KEY", "FETCH_KEY", "NORMAL_TYPE", "SUPER_TYPE", "USE_KEY", "feedsExposeCache", "Ljava/util/concurrent/CopyOnWriteArraySet;", "strictExposeCache", "Ljava/util/concurrent/atomic/AtomicBoolean;", "bigTR5", "clearStrictExposeCache", "", "fillSuperMaskReportData", "advertisementInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "funcExtDataJson", "Lorg/json/JSONObject;", "funcExt", "type", "origin", "exposeMode", "Lcom/tencent/biz/pubaccount/NativeAd/report/ExposeMode;", "(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/biz/pubaccount/NativeAd/report/ExposeMode;)V", "getCurrentAdShouldStrictExpose", "", "onErrorReport", "data", "success", "reason", "content", "detailKey", "onPreloadAction", "adId", "action", "version", "onShowAction", "traceId", "reportClick", "clickPos", "adInfo", "reportExpose", "reportSuperMaskAdEvent", "setCurrentAdShouldStrictExpose", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ujg
{
  private static final CopyOnWriteArraySet<String> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet;
  private static final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  public static final ujg a;
  
  static
  {
    jdField_a_of_type_Ujg = new ujg();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    UserAction.registerTunnel(new TunnelInfo("000000EYXY3ATYB3"));
  }
  
  private final String a()
  {
    try
    {
      String str = pqf.a().a("ad_mengceng", String.valueOf(1)).a();
      return str;
    }
    catch (JSONException localJSONException) {}
    return "";
  }
  
  public final void a()
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
  }
  
  public final void a(int paramInt, @Nullable Object paramObject)
  {
    if (!(paramObject instanceof AdvertisementInfo)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      localObject = (AdvertisementInfo)localObject;
      if ((localObject != null) && (((AdvertisementInfo)localObject).mAdvertisementExtInfo != null))
      {
        if (paramInt == 1) {
          uky.a = true;
        }
      }
      else {
        return;
      }
      localObject = (ReportAction)null;
      ActionEntity localActionEntity = (ActionEntity)null;
      switch (paramInt)
      {
      }
      for (;;)
      {
        ois.a(new ufy().a(BaseApplication.getContext()).a(paramInt).b(37).a((ReportAction)localObject).a(localActionEntity).a((AdvertisementInfo)paramObject).e(new JSONObject()).a());
        break;
        localObject = ReportAction.CLOSE;
        continue;
        localObject = ReportAction.CLICK;
        localActionEntity = ActionEntity.MUTE;
        continue;
        localObject = ReportAction.CLICK;
        localActionEntity = ActionEntity.CANCEL_MUTE;
      }
    }
  }
  
  public final void a(@NotNull ExposeMode paramExposeMode, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramExposeMode, "exposeMode");
    if (!(paramObject instanceof AdvertisementInfo)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      localObject = (AdvertisementInfo)localObject;
      boolean bool;
      if (localObject != null)
      {
        if (((AdvertisementInfo)localObject).mAdvertisementExtInfo != null)
        {
          paramObject = new ufy().a(BaseApplication.getContext()).a(2).b(37).a((AdvertisementInfo)paramObject).e(new JSONObject()).a(paramExposeMode);
          if (paramExposeMode != ExposeMode.LOOSE) {
            break label119;
          }
          bool = true;
          ois.a(paramObject.a(bool).a());
        }
        if (paramExposeMode != ExposeMode.LOOSE) {
          break label124;
        }
        a(jdField_a_of_type_Ujg, "successShowMask", null, 2, null);
      }
      for (;;)
      {
        return;
        label119:
        bool = false;
        break;
        label124:
        a(jdField_a_of_type_Ujg, "exposeMask", null, 2, null);
      }
    }
  }
  
  public final void a(@Nullable AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2)
  {
    if (!uks.j(paramAdvertisementInfo)) {}
    while (paramInt1 != 37) {
      return;
    }
    switch (paramInt2)
    {
    default: 
      olh.a(null, "", "0X8009819", "0X8009819", 0, 0, "", "", "", a(), false);
      return;
    }
    ois.a(null, "0X8008C80", "0X8008C80", 0, 0, "", "", "", a());
  }
  
  public final void a(@Nullable AdvertisementInfo paramAdvertisementInfo, @Nullable JSONObject paramJSONObject1, @Nullable JSONObject paramJSONObject2, @Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable ExposeMode paramExposeMode)
  {
    if ((paramAdvertisementInfo == null) || (paramJSONObject1 == null) || (paramJSONObject2 == null) || (paramInteger1 == null) || (paramInteger2 == null) || (paramExposeMode == null)) {}
    while (!uks.j(paramAdvertisementInfo)) {
      return;
    }
    if ((paramInteger2.intValue() != 37) && (paramInteger1.intValue() == 2) && (!jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(paramAdvertisementInfo.mAdTraceId)))
    {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramAdvertisementInfo.mAdTraceId);
      String str = paramAdvertisementInfo.mAdTraceId;
      Intrinsics.checkExpressionValueIsNotNull(str, "advertisementInfo.mAdTraceId");
      a("feedsMaskExpose", str);
    }
    if (paramInteger1.intValue() == 2)
    {
      uja.a(paramAdvertisementInfo, paramInteger2.intValue(), paramExposeMode, paramJSONObject1, paramJSONObject2);
      return;
    }
    uja.a(paramAdvertisementInfo, paramInteger1.intValue(), paramJSONObject1, paramJSONObject2);
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "action");
    Intrinsics.checkParameterIsNotNull(paramString2, "traceId");
    Object localObject2 = uje.a.a();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof AdvertisementInfo)) {
      localObject1 = null;
    }
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localObject1;
    label72:
    HashMap localHashMap;
    if (localAdvertisementInfo != null)
    {
      localObject1 = String.valueOf(localAdvertisementInfo.mAdAid);
      if (localObject1 != null)
      {
        if (!uks.k(localAdvertisementInfo)) {
          break label244;
        }
        localObject2 = "1";
        localHashMap = new HashMap();
        localHashMap.put("adId", localObject1);
        localHashMap.put("action", paramString1);
        localHashMap.put("type", localObject2);
        if (localAdvertisementInfo == null) {
          break label252;
        }
        localHashMap.put("traceId", localAdvertisementInfo.mAdTraceId);
      }
    }
    for (;;)
    {
      paramString2 = pnn.a();
      Intrinsics.checkExpressionValueIsNotNull(paramString2, "RIJQQAppInterfaceUtil.getQQApp()");
      paramString2 = StatisticCollector.getInstance((Context)paramString2.getApplication());
      localObject2 = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplicationImpl.getApplication()");
      localObject2 = ((BaseApplicationImpl)localObject2).getRuntime();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplicationImpl.getApplication().runtime");
      paramString2.collectPerformance("000000EYXY3ATYB3", ((AppRuntime)localObject2).getAccount(), "actKandianAdSuperMask", true, 0L, 0L, localHashMap, null);
      ukq.a("ReadInJoySuperMaskAd", "[actKandianAdSuperMask] action = " + paramString1 + "  adId = " + (String)localObject1);
      return;
      localObject1 = "";
      break;
      label244:
      localObject2 = "0";
      break label72;
      label252:
      localHashMap.put("traceId", paramString2);
    }
  }
  
  public final void a(@Nullable String paramString1, @NotNull String paramString2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString2, "action");
    HashMap localHashMap = new HashMap();
    if (paramString1 != null) {}
    for (Object localObject1 = paramString1;; localObject1 = "")
    {
      localHashMap.put("adId", localObject1);
      localHashMap.put("action", paramString2);
      localHashMap.put("version", String.valueOf(paramInt));
      localObject1 = StatisticCollector.getInstance(BaseApplication.getContext());
      Object localObject2 = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplicationImpl.getApplication()");
      localObject2 = ((BaseApplicationImpl)localObject2).getRuntime();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplicationImpl.getApplication().runtime");
      ((StatisticCollector)localObject1).collectPerformance("000000EYXY3ATYB3", ((AppRuntime)localObject2).getAccount(), "actKandianAdResoucePreload", true, 0L, 0L, localHashMap, null);
      ukq.a("ReadInJoySuperMaskAd", "[actKandianAdResoucePreload] action = " + paramString2 + "  adId = " + paramString1);
      return;
    }
  }
  
  public final void a(@Nullable JSONObject paramJSONObject, boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString3, "detailKey");
  }
  
  public final boolean a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public final void b()
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujg
 * JD-Core Version:    0.7.0.1
 */