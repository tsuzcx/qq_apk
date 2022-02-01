import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.DownloadClickState;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdGameGiftUtil.showGiftDialog.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdGameGiftUtil;", "", "()V", "doGiftPackageDownload", "", "context", "Landroid/content/Context;", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "view", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "showGiftDialog", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ufi
{
  public static final ufi a = new ufi();
  
  private final void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, RIJDownloadView paramRIJDownloadView, ule paramule)
  {
    Object localObject;
    if (paramAdvertisementInfo != null)
    {
      localObject = paramRIJDownloadView.a();
      if (localObject != null) {
        ((ule)localObject).b = true;
      }
      ufg localufg = ufg.a;
      if (paramule == null) {
        break label85;
      }
      localObject = paramule.d;
      if (!localufg.a((String)localObject)) {
        break label91;
      }
      if ((paramContext instanceof Activity))
      {
        if (!ufg.a.a((Activity)paramContext, paramAdvertisementInfo)) {
          break label91;
        }
        ufd.a(ufd.a, paramContext, DownloadClickState.OPEN_APP, paramAdvertisementInfo, null, 8, null);
      }
    }
    label85:
    label91:
    do
    {
      return;
      localObject = null;
      break;
      boolean bool;
      if (paramule != null)
      {
        localObject = ufc.a(paramule);
        if (localObject != null)
        {
          bool = ((uex)localObject).a(paramule);
          if (!bool) {
            continue;
          }
          localObject = bmqk.a();
          if (paramule == null) {
            break label166;
          }
        }
      }
      for (paramRIJDownloadView = paramule.a;; paramRIJDownloadView = null)
      {
        ((bmql)localObject).b(paramRIJDownloadView);
        ufd.a(ufd.a, paramContext, DownloadClickState.INSTALL_APP, paramAdvertisementInfo, null, 8, null);
        return;
        bool = false;
        break;
      }
    } while (!ufg.a.a(paramRIJDownloadView, paramAdvertisementInfo, paramule));
    label166:
    ufd.a(ufd.a, paramContext, DownloadClickState.START_DOWNLOAD, paramAdvertisementInfo, null, 8, null);
  }
  
  public final void a(@Nullable AdvertisementInfo paramAdvertisementInfo, @Nullable Context paramContext, @NotNull RIJDownloadView paramRIJDownloadView, @Nullable ule paramule)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJDownloadView, "view");
    ThreadManagerV2.executeOnSubThread((Runnable)new RIJAdGameGiftUtil.showGiftDialog.1(paramAdvertisementInfo, paramContext, paramRIJDownloadView, paramule));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufi
 * JD-Core Version:    0.7.0.1
 */