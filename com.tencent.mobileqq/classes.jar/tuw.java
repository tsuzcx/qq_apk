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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"fillFunExtJsonForClick", "", "advertisementInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "type", "", "funcExtDataJson", "Lorg/json/JSONObject;", "funcExt", "fillFunExtJsonForExpose", "origin", "exposeMode", "fillSuperMaskFlag", "Lcom/tencent/biz/pubaccount/NativeAd/data/AdRequestData;", "channelID", "fillToReqMap", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/MaterialData;", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "findLocalResJson", "fixSuperMaskResTypeUpdateError", "getAdId", "isFileExit", "", "isInvalidType", "isManifestFileExit", "toSuperMaskResInfo", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class tuw
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
      paramAdvertisementInfo = tvh.a.a(String.valueOf(l), paramAdvertisementInfo);
      if (paramAdvertisementInfo == null) {
        break;
      }
      return paramAdvertisementInfo.a();
      paramAdvertisementInfo = "";
    }
    return null;
  }
  
  @NotNull
  public static final tvp a(@NotNull AdvertisementInfo paramAdvertisementInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAdvertisementInfo, "$this$toSuperMaskResInfo");
    long l = paramAdvertisementInfo.mAdAid;
    Object localObject = paramAdvertisementInfo.mAdvertisementExtInfo;
    if (localObject != null)
    {
      localObject = String.valueOf(((tro)localObject).j);
      if (localObject == null) {}
    }
    for (;;)
    {
      return new tvp(String.valueOf(l), (String)localObject, paramAdvertisementInfo.mAdvertisementExtInfo.r);
      localObject = "";
    }
  }
  
  public static final void a(@Nullable AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, @Nullable JSONObject paramJSONObject1, @NotNull JSONObject paramJSONObject2)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject2, "funcExt");
    if (paramAdvertisementInfo != null)
    {
      tro localtro = paramAdvertisementInfo.mAdvertisementExtInfo;
      if ((localtro != null) && (localtro.n == 3))
      {
        paramJSONObject2.put("is_transparent", "1");
        if (paramInt1 == obb.ap)
        {
          if (paramInt2 != 1) {
            break label122;
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
      if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.n != 2)) {
        break;
      }
      paramJSONObject2.put("is_transparent", "");
      break;
      label122:
      QLog.d("ReadInJoySuperMaskAd", 1, "fillReportDataAndReportAdEvent: 严口径曝光");
    }
  }
  
  public static final void a(@Nullable AdvertisementInfo paramAdvertisementInfo, int paramInt, @Nullable JSONObject paramJSONObject1, @NotNull JSONObject paramJSONObject2)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject2, "funcExt");
    if (paramAdvertisementInfo != null)
    {
      tro localtro = paramAdvertisementInfo.mAdvertisementExtInfo;
      if ((localtro != null) && (localtro.n == 3))
      {
        paramJSONObject2.put("is_transparent", "1");
        if (!tvi.a.a()) {
          break label152;
        }
        paramJSONObject2.put("volumn", "1");
        if (paramInt == obb.D) {
          tvi.a.a(false);
        }
        label71:
        if (paramInt == obb.C)
        {
          if (!tvg.a.a()) {
            break label178;
          }
          paramJSONObject2.put("is_jump_mc", "2");
          twp.a("ReadInJoySuperMaskAd", "is_jump_mc = 2");
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
      if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.n != 2)) {
        break;
      }
      paramJSONObject2.put("is_transparent", "");
      break;
      label152:
      paramJSONObject2.put("volumn", "0");
      if (paramInt != obb.E) {
        break label71;
      }
      tvi.a.a(true);
      break label71;
      label178:
      paramJSONObject2.put("is_jump_mc", "1");
      twp.a("ReadInJoySuperMaskAd", "is_jump_mc = 1");
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
          tvg.a.a("dbUpdateNoManifest");
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
            tvg.a.a("updateSuperMaskTypeSuccess");
            break;
            localObject1 = "";
          }
        }
        return;
      }
      catch (Exception paramMaterialData)
      {
        tvg.a.a("updateSuperMaskTypeError");
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
  
  public static final void a(@NotNull oaa paramoaa, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Intrinsics.checkParameterIsNotNull(paramoaa, "$this$fillSuperMaskFlag");
    if (paramInt == 0)
    {
      if (tvd.a.a().getAndAdd(1) == 0) {
        bool1 = true;
      }
      paramoaa.a = bool1;
      if (paramoaa.a) {
        QLog.d("ReadInJoySuperMaskAd", 1, "request SuperMask in recommend");
      }
    }
    do
    {
      do
      {
        return;
      } while (!pcl.c(paramInt));
      bool1 = bool2;
      if (tvd.a.b().getAndAdd(1) == 0) {
        bool1 = true;
      }
      paramoaa.a = bool1;
    } while (!paramoaa.a);
    QLog.d("ReadInJoySuperMaskAd", 1, "request SuperMask in daily");
  }
  
  public static final boolean a(@NotNull MaterialData paramMaterialData)
  {
    Intrinsics.checkParameterIsNotNull(paramMaterialData, "$this$isFileExit");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tuw
 * JD-Core Version:    0.7.0.1
 */