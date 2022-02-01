import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.GameCenterDownloadEngine.pauseDownload.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.GameCenterDownloadEngine.queryDownloadState.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.GameCenterDownloadEngine.startDownload.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import cooperation.wadl.ipc.WadlParams;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/engine/GameCenterDownloadEngine;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/engine/IDownloadEngine;", "()V", "buildDownloadParams", "Lcooperation/wadl/ipc/WadlParams;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "cancelDownload", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "installApp", "", "isAppPkgExist", "isGameDownloadData", "pauseDownload", "queryDownloadState", "startDownload", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class uew
  extends uex
{
  public static final uew a = new uew();
  
  private final WadlParams a(ule paramule)
  {
    if (paramule.jdField_a_of_type_CooperationWadlIpcWadlParams == null) {
      paramule.jdField_a_of_type_CooperationWadlIpcWadlParams = ufc.a(paramule);
    }
    return paramule.jdField_a_of_type_CooperationWadlIpcWadlParams;
  }
  
  private final boolean c(ule paramule)
  {
    return (paramule.jdField_a_of_type_Boolean) && (paramule.jdField_a_of_type_CooperationWadlIpcWadlParams != null);
  }
  
  public void a(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable ule paramule)
  {
    ThreadManagerV2.executeOnSubThread((Runnable)new GameCenterDownloadEngine.queryDownloadState.1(paramRIJDownloadView, paramule));
  }
  
  public boolean a(@Nullable ule paramule)
  {
    if (paramule != null) {}
    for (String str = paramule.i; TextUtils.isEmpty((CharSequence)str); str = null) {
      return false;
    }
    if (paramule != null)
    {
      paramule = paramule.i;
      if (paramule == null) {}
    }
    for (;;)
    {
      return new File(paramule).exists();
      paramule = "";
    }
  }
  
  public void b(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable ule paramule)
  {
    ThreadManagerV2.executeOnSubThread((Runnable)new GameCenterDownloadEngine.startDownload.1(paramRIJDownloadView, paramule));
  }
  
  public boolean b(@Nullable ule paramule)
  {
    if (paramule != null) {
      a.a(paramule);
    }
    bmql localbmql = bmqk.a();
    if (paramule != null) {}
    for (paramule = paramule.jdField_a_of_type_CooperationWadlIpcWadlParams;; paramule = null)
    {
      localbmql.b(paramule);
      return true;
    }
  }
  
  public void c(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable ule paramule)
  {
    ThreadManagerV2.executeOnSubThread((Runnable)new GameCenterDownloadEngine.pauseDownload.1(paramule));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uew
 * JD-Core Version:    0.7.0.1
 */