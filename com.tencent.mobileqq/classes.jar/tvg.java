import android.content.Context;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/impl/SuperMaskReportMgr;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/ISuperMaskReport;", "()V", "APP_KEY_FOR_USER_ACTION", "", "CLICK_POS_AD_AREA", "", "DOWNLOAD_KEY", "FETCH_KEY", "NORMAL_TYPE", "SUPER_TYPE", "USE_KEY", "strictExposeCache", "Ljava/util/concurrent/atomic/AtomicBoolean;", "bigTR5", "clearStrictExposeCache", "", "fillReportDataAndReportAdEvent", "advertisementInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "funcExtDataJson", "Lorg/json/JSONObject;", "funcExt", "type", "origin", "exposeMode", "getCurrentAdShouldStrictExpose", "", "onClickReport", "clickPos", "adInfo", "", "onErrorReport", "data", "success", "reason", "content", "detailKey", "onPreloadAction", "adId", "action", "version", "onShowAction", "onSuperMaskExpose", "reportSuperMaskAdEvent", "setCurrentAdShouldStrictExpose", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tvg
{
  private static final AtomicBoolean a;
  public static final tvg a;
  
  static
  {
    jdField_a_of_type_Tvg = new tvg();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    UserAction.registerTunnel(new TunnelInfo("000000EYXY3ATYB3"));
  }
  
  private final String a()
  {
    try
    {
      String str = pay.a().a("ad_mengceng", String.valueOf(1)).a();
      return str;
    }
    catch (JSONException localJSONException) {}
    return "";
  }
  
  public final void a()
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
  }
  
  public void a(int paramInt, @Nullable Object paramObject)
  {
    if (!(paramObject instanceof AdvertisementInfo)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      localObject = (AdvertisementInfo)localObject;
      boolean bool;
      if (localObject != null)
      {
        if (((AdvertisementInfo)localObject).mAdvertisementExtInfo != null)
        {
          paramObject = new trn().a(BaseApplication.getContext()).a(obb.b).b(obb.ap).a((AdvertisementInfo)paramObject).e(new JSONObject()).e(paramInt);
          if (paramInt != 1) {
            break label109;
          }
          bool = true;
          obb.a(paramObject.a(bool).a());
        }
        if (paramInt != 1) {
          break label114;
        }
        jdField_a_of_type_Tvg.a("successShowMask");
      }
      for (;;)
      {
        return;
        label109:
        bool = false;
        break;
        label114:
        jdField_a_of_type_Tvg.a("exposeMask");
      }
    }
  }
  
  public final void a(@Nullable AdvertisementInfo paramAdvertisementInfo, @Nullable JSONObject paramJSONObject1, @NotNull JSONObject paramJSONObject2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject2, "funcExt");
    if (!twr.l(paramAdvertisementInfo)) {}
    do
    {
      return;
      if ((paramInt2 != obb.ap) && (paramAdvertisementInfo != null)) {
        a("feedsMaskExpose");
      }
    } while (paramAdvertisementInfo == null);
    if (paramInt1 == obb.b)
    {
      tuw.a(paramAdvertisementInfo, paramInt2, paramInt3, paramJSONObject1, paramJSONObject2);
      return;
    }
    tuw.a(paramAdvertisementInfo, paramInt1, paramJSONObject1, paramJSONObject2);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    Object localObject2 = tve.a.a();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof AdvertisementInfo)) {
      localObject1 = null;
    }
    localObject2 = (AdvertisementInfo)localObject1;
    if (localObject2 != null)
    {
      localObject1 = String.valueOf(((AdvertisementInfo)localObject2).mAdAid);
      if (localObject1 != null) {
        if (!twr.m((AdvertisementInfo)localObject2)) {
          break label203;
        }
      }
    }
    label203:
    for (localObject2 = "1";; localObject2 = "0")
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("adId", localObject1);
      localHashMap.put("action", paramString);
      localHashMap.put("type", localObject2);
      localObject2 = pay.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "ReadInJoyUtils.getQQApp()");
      localObject2 = StatisticCollector.getInstance((Context)((QQAppInterface)localObject2).getApplication());
      Object localObject3 = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "BaseApplicationImpl.getApplication()");
      localObject3 = ((BaseApplicationImpl)localObject3).getRuntime();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "BaseApplicationImpl.getApplication().runtime");
      ((StatisticCollector)localObject2).collectPerformance("000000EYXY3ATYB3", ((AppRuntime)localObject3).getAccount(), "actKandianAdSuperMask", true, 0L, 0L, localHashMap, null);
      twp.a("ReadInJoySuperMaskAd", "[actKandianAdSuperMask] action = " + paramString + "  adId = " + (String)localObject1);
      return;
      localObject1 = "";
      break;
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
      twp.a("ReadInJoySuperMaskAd", "[actKandianAdResoucePreload] action = " + paramString2 + "  adId = " + paramString1);
      return;
    }
  }
  
  public void a(@Nullable JSONObject paramJSONObject, boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString3, "detailKey");
  }
  
  public final boolean a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public final boolean a(@Nullable AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2)
  {
    if (!twr.l(paramAdvertisementInfo)) {
      return false;
    }
    if (paramInt1 != obb.ap) {
      return false;
    }
    if (paramInt2 == obb.b) {
      obb.a(null, "0X8008C80", "0X8008C80", 0, 0, "", "", "", a());
    }
    for (;;)
    {
      return true;
      odq.a(null, "", "0X8009819", "0X8009819", 0, 0, "", "", "", a(), false);
    }
  }
  
  public final void b()
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false);
  }
  
  public void b(int paramInt, @Nullable Object paramObject)
  {
    if (!(paramObject instanceof AdvertisementInfo)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      localObject = (AdvertisementInfo)localObject;
      if ((localObject != null) && (((AdvertisementInfo)localObject).mAdvertisementExtInfo != null))
      {
        if (paramInt != 1) {
          break label35;
        }
        twx.a = true;
      }
      for (;;)
      {
        return;
        label35:
        obb.a(new trn().a(BaseApplication.getContext()).a(paramInt).b(obb.ap).a((AdvertisementInfo)paramObject).e(new JSONObject()).a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvg
 * JD-Core Version:    0.7.0.1
 */