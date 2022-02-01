import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskReportUtil.doUseReport.1;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoySuperMaskReportUtil;", "", "()V", "ANIM_FILE_NAME_ERROR", "", "CHANNEL_ID_ERROR", "MANIFEST_ERROR", "MASK_TYPE_ERROR", "NO_FILE_ERROR", "VERSION_ERROR", "WINDOW_INTERCEPT_ERROR", "doUseReport", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "success", "", "reason", "doUserReportWithMaterial", "materialData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/MaterialData;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tqk
{
  public static final tqk a = new tqk();
  
  public final void a(@Nullable AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "reason");
    if (((paramAdvertisementInfo instanceof AdvertisementInfo)) && (tqa.l(paramAdvertisementInfo))) {
      ThreadManager.getSubThreadHandler().post((Runnable)new ReadInJoySuperMaskReportUtil.doUseReport.1(paramBoolean, paramString));
    }
  }
  
  public final void a(@Nullable MaterialData paramMaterialData, boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "reason");
    if (paramMaterialData != null) {
      tny.b(paramMaterialData, paramBoolean, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqk
 * JD-Core Version:    0.7.0.1
 */