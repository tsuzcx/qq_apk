import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.YYBDownloadEngine.pauseDownload.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.YYBDownloadEngine.queryDownloadState.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.YYBDownloadEngine.startDownload.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/engine/YYBDownloadEngine;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/engine/IDownloadEngine;", "()V", "buildDownloadParams", "Landroid/os/Bundle;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "cancelDownload", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "getLocalPakPathBySDK", "", "localInfo", "Lcom/tencent/open/downloadnew/DownloadInfo;", "installApp", "", "isAppPkgExist", "needReplaceUrl", "pauseDownload", "queryDownloadState", "startDownload", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class uey
  extends uex
{
  public static final uey a = new uey();
  
  private final Bundle a(ule paramule)
  {
    if (paramule == null) {
      return new Bundle();
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(bjmy.f, paramule.d);
    localBundle.putString(bjmy.b, paramule.a);
    localBundle.putString(bjmy.j, paramule.c);
    localBundle.putString(bjmy.l, paramule.e);
    localBundle.putInt(bjmy.k, 2);
    localBundle.putInt(bjmy.F, 0);
    localBundle.putBoolean(bjmy.x, false);
    localBundle.putInt(bjmy.I, 0);
    localBundle.putBoolean(bjmy.y, true);
    localBundle.putBoolean(bjmy.h, true);
    localBundle.putBoolean(bjmy.r, false);
    localBundle.putBoolean(bjmy.K, false);
    localBundle.putString("sendTime", "_" + GlobalUtil.calcMD5AsString(paramule.c));
    localBundle.putString(bjmy.i, paramule.f);
    return localBundle;
  }
  
  private final String a(DownloadInfo paramDownloadInfo)
  {
    paramDownloadInfo = bjjq.a().a(paramDownloadInfo.d);
    if ((paramDownloadInfo != null) && (paramDownloadInfo.mState == 4)) {
      return paramDownloadInfo.mSavePath;
    }
    return null;
  }
  
  private final boolean c(ule paramule)
  {
    return (TextUtils.isEmpty((CharSequence)paramule.c)) && (!TextUtils.isEmpty((CharSequence)paramule.b));
  }
  
  public void a(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable ule paramule)
  {
    ThreadManagerV2.executeOnSubThread((Runnable)new YYBDownloadEngine.queryDownloadState.1(paramRIJDownloadView, paramule));
  }
  
  public boolean a(@Nullable ule paramule)
  {
    Object localObject3 = null;
    if (paramule != null) {}
    for (Object localObject1 = paramule.c; TextUtils.isEmpty((CharSequence)localObject1); localObject1 = null) {
      return false;
    }
    Object localObject2 = bjjq.a().b((String)localObject1);
    label43:
    Object localObject4;
    if (localObject2 != null)
    {
      if (localObject2 == null) {
        break label193;
      }
      localObject4 = ((DownloadInfo)localObject2).l;
      localObject1 = localObject4;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        localObject1 = a((DownloadInfo)localObject2);
      }
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!new File((String)localObject1).exists())) {
        break label201;
      }
    }
    label193:
    label201:
    for (boolean bool = true;; bool = false)
    {
      localObject4 = new StringBuilder().append("isAppDownloaded = ").append(bool).append("  packageName = ");
      localObject2 = localObject3;
      if (paramule != null) {
        localObject2 = paramule.d;
      }
      QLog.d("AD_DOWNLOAD_TAG", 1, (String)localObject2 + " localAPKPath = " + (String)localObject1);
      return bool;
      localObject2 = bjjq.a();
      if (paramule != null)
      {
        localObject1 = paramule.d;
        if (localObject1 == null) {}
      }
      for (;;)
      {
        localObject2 = ((bjjq)localObject2).c((String)localObject1);
        break label43;
        break;
        localObject1 = "";
      }
    }
  }
  
  public void b(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable ule paramule)
  {
    ThreadManagerV2.executeOnSubThread((Runnable)new YYBDownloadEngine.startDownload.1(paramRIJDownloadView, paramule));
  }
  
  public boolean b(@Nullable ule paramule)
  {
    bjjq localbjjq = bjjq.a();
    if (paramule != null) {}
    for (paramule = paramule.c;; paramule = null)
    {
      paramule = localbjjq.b(paramule);
      return bjjq.a().a(paramule);
    }
  }
  
  public void c(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable ule paramule)
  {
    ThreadManagerV2.executeOnSubThread((Runnable)new YYBDownloadEngine.pauseDownload.1(paramule));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uey
 * JD-Core Version:    0.7.0.1
 */