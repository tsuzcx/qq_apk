import com.tencent.biz.pubaccount.NativeAd.report.ExposeMode;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"fillFunExtJsonForClick", "", "advertisementInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "type", "", "funcExtDataJson", "Lorg/json/JSONObject;", "funcExt", "fillFunExtJsonForExpose", "origin", "exposeMode", "Lcom/tencent/biz/pubaccount/NativeAd/report/ExposeMode;", "fillSuperMaskFlag", "Lcom/tencent/biz/pubaccount/NativeAd/data/AdRequestData;", "channelID", "fillToReqMap", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/MaterialData;", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "findLocalResJson", "fixSuperMaskResTypeUpdateError", "getAdId", "isFileExist", "", "isInvalidType", "isManifestFileExit", "toSuperMaskResInfo", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class uja
{
  @Nullable
  public static final JSONObject a(@NotNull AdvertisementInfo paramAdvertisementInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAdvertisementInfo, "$this$findLocalResJson");
    long l = paramAdvertisementInfo.mAdAid;
    paramAdvertisementInfo = paramAdvertisementInfo.mAdvertisementExtInfo;
    if (paramAdvertisementInfo != null)
    {
      paramAdvertisementInfo = String.valueOf(paramAdvertisementInfo.j);
      if (paramAdvertisementInfo == null) {}
    }
    for (;;)
    {
      paramAdvertisementInfo = ujh.a.a(String.valueOf(l), paramAdvertisementInfo);
      if (paramAdvertisementInfo == null) {
        break;
      }
      return paramAdvertisementInfo.a();
      paramAdvertisementInfo = "";
    }
    return null;
  }
  
  @NotNull
  public static final ujq a(@NotNull AdvertisementInfo paramAdvertisementInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAdvertisementInfo, "$this$toSuperMaskResInfo");
    long l = paramAdvertisementInfo.mAdAid;
    Object localObject = paramAdvertisementInfo.mAdvertisementExtInfo;
    if (localObject != null)
    {
      localObject = String.valueOf(((ufz)localObject).j);
      if (localObject == null) {}
    }
    for (;;)
    {
      return new ujq(String.valueOf(l), (String)localObject, paramAdvertisementInfo.mAdvertisementExtInfo.q);
      localObject = "";
    }
  }
  
  public static final void a(@Nullable AdvertisementInfo paramAdvertisementInfo, int paramInt, @NotNull ExposeMode paramExposeMode, @Nullable JSONObject paramJSONObject1, @NotNull JSONObject paramJSONObject2)
  {
    Intrinsics.checkParameterIsNotNull(paramExposeMode, "exposeMode");
    Intrinsics.checkParameterIsNotNull(paramJSONObject2, "funcExt");
    if (paramAdvertisementInfo != null)
    {
      ufz localufz = paramAdvertisementInfo.mAdvertisementExtInfo;
      if ((localufz != null) && (localufz.m == 3))
      {
        paramJSONObject2.put("is_transparent", "1");
        if (paramInt == 37)
        {
          if (paramExposeMode != ExposeMode.LOOSE) {
            break label129;
          }
          paramJSONObject2.put("stat_type", "2");
          QLog.d("ReadInJoySuperMaskAd", 1, "fillReportDataAndReportAdEvent: 宽口径曝光");
        }
      }
    }
    for (;;)
    {
      if (paramJSONObject1 != null) {
        paramJSONObject1.put("exposure_info_report", paramJSONObject2.toString());
      }
      return;
      if (paramAdvertisementInfo == null) {
        break;
      }
      paramAdvertisementInfo = paramAdvertisementInfo.mAdvertisementExtInfo;
      if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.m != 2)) {
        break;
      }
      paramJSONObject2.put("is_transparent", "");
      break;
      label129:
      QLog.d("ReadInJoySuperMaskAd", 1, "fillReportDataAndReportAdEvent: 严口径曝光");
    }
  }
  
  public static final void a(@Nullable AdvertisementInfo paramAdvertisementInfo, int paramInt, @Nullable JSONObject paramJSONObject1, @NotNull JSONObject paramJSONObject2)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject2, "funcExt");
    if (paramAdvertisementInfo != null)
    {
      ufz localufz = paramAdvertisementInfo.mAdvertisementExtInfo;
      if ((localufz != null) && (localufz.m == 3))
      {
        paramJSONObject2.put("is_transparent", "1");
        if (!ujj.a.a()) {
          break label150;
        }
        paramJSONObject2.put("volumn", "1");
        if (paramInt == 27) {
          ujj.a.a(false);
        }
        label70:
        if (paramInt == 26)
        {
          if (!ujg.a.a()) {
            break label175;
          }
          paramJSONObject2.put("is_jump_mc", "2");
          ukq.a("ReadInJoySuperMaskAd", "is_jump_mc = 2");
        }
      }
    }
    for (;;)
    {
      if (paramJSONObject1 != null) {
        paramJSONObject1.put("click_info_report", paramJSONObject2.toString());
      }
      return;
      if (paramAdvertisementInfo == null) {
        break;
      }
      paramAdvertisementInfo = paramAdvertisementInfo.mAdvertisementExtInfo;
      if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.m != 2)) {
        break;
      }
      paramJSONObject2.put("is_transparent", "");
      break;
      label150:
      paramJSONObject2.put("volumn", "0");
      if (paramInt != 28) {
        break label70;
      }
      ujj.a.a(true);
      break label70;
      label175:
      paramJSONObject2.put("is_jump_mc", "1");
      ukq.a("ReadInJoySuperMaskAd", "is_jump_mc = 1");
    }
  }
  
  public static final void a(@Nullable MaterialData paramMaterialData)
  {
    if (paramMaterialData != null) {
      try
      {
        Object localObject1 = new File(paramMaterialData.res_path, "manifest.json");
        if ((!((File)localObject1).exists()) || (!((File)localObject1).isFile()) || (!((File)localObject1).canRead()))
        {
          ujg.a(ujg.a, "dbUpdateNoManifest", null, 2, null);
        }
        else
        {
          Object localObject2 = new StringBuffer();
          fd.a((StringBuffer)localObject2, ((File)localObject1).getPath());
          localObject1 = ((StringBuffer)localObject2).toString();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "buffer.toString()");
          localObject2 = new JSONObject((String)localObject1);
          localObject1 = ((JSONObject)localObject2).optString("animFileName");
          if (localObject1 != null) {}
          for (;;)
          {
            paramMaterialData.animFileName = ((String)localObject1);
            paramMaterialData.superMaskType = ((JSONObject)localObject2).optInt("superMaskType", 0);
            ujg.a(ujg.a, "updateSuperMaskTypeSuccess", null, 2, null);
            break;
            localObject1 = "";
          }
        }
        return;
      }
      catch (Exception paramMaterialData)
      {
        ujg.a(ujg.a, "updateSuperMaskTypeError", null, 2, null);
      }
    }
    for (;;) {}
  }
  
  public static final void a(@NotNull MaterialData paramMaterialData, @Nullable ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMaterialData, "$this$fillToReqMap");
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("adId", paramMaterialData.adid);
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("adSource", paramMaterialData.ad_source);
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("adMaterial", paramMaterialData.ad_material);
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("version", Integer.valueOf(paramMaterialData.res_version));
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("md5", paramMaterialData.res_md5);
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("adType", Integer.valueOf(paramMaterialData.ad_type));
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("subAdId", paramMaterialData.sub_adid);
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("startTime", Long.valueOf(paramMaterialData.start_time));
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("endTime", Long.valueOf(paramMaterialData.end_time));
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("deliveryEffect", Integer.valueOf(paramMaterialData.delivery_effect));
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("normalMask", Integer.valueOf(paramMaterialData.normal_mask));
    }
  }
  
  public static final void a(@NotNull oha paramoha, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Intrinsics.checkParameterIsNotNull(paramoha, "$this$fillSuperMaskFlag");
    if (paramInt == 0)
    {
      if (ujd.a.a().getAndAdd(1) == 0) {
        bool1 = true;
      }
      paramoha.b = bool1;
      if (paramoha.b) {
        QLog.d("ReadInJoySuperMaskAd", 1, "request SuperMask in recommend");
      }
    }
    do
    {
      do
      {
        return;
      } while (!plm.c(paramInt));
      bool1 = bool2;
      if (ujd.a.b().getAndAdd(1) == 0) {
        bool1 = true;
      }
      paramoha.b = bool1;
    } while (!paramoha.b);
    QLog.d("ReadInJoySuperMaskAd", 1, "request SuperMask in daily");
  }
  
  public static final boolean a(@NotNull MaterialData paramMaterialData)
  {
    Intrinsics.checkParameterIsNotNull(paramMaterialData, "$this$isFileExist");
    if (paramMaterialData.animFileName == null) {
      return FileUtils.fileExists(paramMaterialData.res_path);
    }
    paramMaterialData = new File(paramMaterialData.res_path, paramMaterialData.animFileName);
    return (paramMaterialData.exists()) && (paramMaterialData.isFile()) && (paramMaterialData.canRead());
  }
  
  public static final boolean b(@NotNull MaterialData paramMaterialData)
  {
    Intrinsics.checkParameterIsNotNull(paramMaterialData, "$this$isManifestFileExit");
    paramMaterialData = new File(paramMaterialData.res_path, "manifest.json");
    return (paramMaterialData.exists()) && (paramMaterialData.isFile()) && (paramMaterialData.canRead());
  }
  
  public static final boolean c(@Nullable MaterialData paramMaterialData)
  {
    if (paramMaterialData == null) {}
    while ((paramMaterialData.superMaskType == 0) || (paramMaterialData.superMaskType == 1)) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uja
 * JD-Core Version:    0.7.0.1
 */