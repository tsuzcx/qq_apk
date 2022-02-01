import android.content.Context;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdAppDownloadUtil.getAppDownloadState.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_action/download_action/AdAppDownloadUtil;", "", "()V", "TAG", "", "coverStateToAdState", "", "state", "getAppDownloadState", "", "downloadData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "callback", "Landroid/webkit/ValueCallback;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_action/download_action/AdAppDownloadUtil$DownloadStateInfo;", "getDownloadInfo", "Lcom/tencent/open/downloadnew/DownloadInfo;", "getDownloadInfoByPkgName", "packageName", "getDownloadInfoByUrl", "url", "isAppInstalled", "", "pkgName", "isPackageExistByDownloadInfo", "info", "DownloadStateInfo", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class udr
{
  public static final udr a = new udr();
  
  public final int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 2: 
      return 3;
    case 3: 
      return 4;
    }
    return 5;
  }
  
  @Nullable
  public final DownloadInfo a(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return bjjq.a().b(paramString);
  }
  
  @Nullable
  public final DownloadInfo a(@Nullable ule paramule)
  {
    if (paramule == null) {
      return null;
    }
    String str = paramule.c;
    paramule = paramule.d;
    return a(str);
  }
  
  public final void a(@Nullable ule paramule, @NotNull ValueCallback<uds> paramValueCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramValueCallback, "callback");
    ThreadManagerV2.executeOnSubThread((Runnable)new AdAppDownloadUtil.getAppDownloadState.1(paramule, paramValueCallback));
  }
  
  public final boolean a(@Nullable DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return false;
    }
    paramDownloadInfo = paramDownloadInfo.l;
    if ((!TextUtils.isEmpty((CharSequence)paramDownloadInfo)) && (new File(paramDownloadInfo).exists())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean a(@Nullable String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return ois.a((Context)BaseApplicationImpl.getContext(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udr
 * JD-Core Version:    0.7.0.1
 */