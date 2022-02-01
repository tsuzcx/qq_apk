import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdDownloadUtil;", "", "()V", "doGameDownload", "", "view", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "doNormalAppDownload", "doSoftAppDownload", "isAmsAppAd", "adData", "isAppInstalled", "packageName", "", "isShowOuterDownloadProgress", "advertisementInfo", "openApp", "context", "Landroid/app/Activity;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ufg
{
  public static final ufg a = new ufg();
  
  private final boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    ufz localufz;
    if (paramAdvertisementInfo != null)
    {
      localufz = paramAdvertisementInfo.mAdvertisementExtInfo;
      if (localufz == null) {
        break label52;
      }
    }
    label52:
    for (int i = localufz.j;; i = 0)
    {
      bool1 = bool2;
      if (i == 32)
      {
        bool1 = bool2;
        if (paramAdvertisementInfo.mAdProductType == 12) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  public final boolean a(@Nullable Activity paramActivity, @Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    String str = null;
    if (paramActivity == null) {
      return false;
    }
    if (b(paramAdvertisementInfo)) {
      return uvp.a((Context)paramActivity, paramAdvertisementInfo, null, 2, true);
    }
    if (paramAdvertisementInfo != null) {
      str = paramAdvertisementInfo.getPackageName();
    }
    if (!TextUtils.isEmpty((CharSequence)str)) {
      return uks.a((Context)paramActivity, str);
    }
    return false;
  }
  
  public final boolean a(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    while (((!ufc.c(paramAdvertisementInfo)) || (!ufc.a(paramAdvertisementInfo))) && (!ufc.d(paramAdvertisementInfo)) && (!ufc.e(paramAdvertisementInfo)) && (!ufc.f(paramAdvertisementInfo)) && (!ufc.g(paramAdvertisementInfo))) {
      return false;
    }
    return true;
  }
  
  public final boolean a(@NotNull RIJDownloadView paramRIJDownloadView, @Nullable AdvertisementInfo paramAdvertisementInfo, @Nullable ule paramule)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJDownloadView, "view");
    if (acik.a())
    {
      if (paramule != null)
      {
        paramAdvertisementInfo = ufc.a(paramule);
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.b(paramRIJDownloadView, paramule);
        }
      }
      return true;
    }
    Context localContext = paramRIJDownloadView.getContext();
    if (paramAdvertisementInfo != null) {}
    for (boolean bool = paramAdvertisementInfo.isBottomAd;; bool = false)
    {
      ukl.a(localContext, paramAdvertisementInfo, true, bool, (DialogInterface.OnClickListener)new ufh(paramAdvertisementInfo, paramule, paramRIJDownloadView));
      return false;
    }
  }
  
  public final boolean a(@Nullable String paramString)
  {
    boolean bool = bhfn.a((Context)BaseApplicationImpl.getContext(), paramString);
    QLog.d("AD_DOWNLOAD_TAG", 1, "isAppInstalled = " + bool + "  packageName = " + paramString);
    return bool;
  }
  
  public final boolean b(@NotNull RIJDownloadView paramRIJDownloadView, @Nullable AdvertisementInfo paramAdvertisementInfo, @Nullable ule paramule)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJDownloadView, "view");
    String str;
    if (NetworkUtil.isMobileNetWork(paramRIJDownloadView.getContext())) {
      if (paramAdvertisementInfo != null)
      {
        str = paramAdvertisementInfo.mAdExtInfo;
        if (str != null) {
          if (!ukr.a(str)) {
            break label81;
          }
        }
      }
    }
    label81:
    for (int i = 1;; i = 0)
    {
      if ((!acik.a()) && (i == 0)) {
        break label87;
      }
      if (paramule != null)
      {
        paramAdvertisementInfo = ufc.a(paramule);
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.b(paramRIJDownloadView, paramule);
        }
      }
      return true;
      str = "";
      break;
    }
    label87:
    tjk.a(paramRIJDownloadView.getContext(), paramAdvertisementInfo, true, 8);
    return false;
  }
  
  public final boolean c(@NotNull RIJDownloadView paramRIJDownloadView, @Nullable AdvertisementInfo paramAdvertisementInfo, @Nullable ule paramule)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJDownloadView, "view");
    if ((paramAdvertisementInfo != null) && (!ufc.a(paramAdvertisementInfo)))
    {
      tjk.a(paramRIJDownloadView.getContext(), paramAdvertisementInfo, true, 8);
      return false;
    }
    return b(paramRIJDownloadView, paramAdvertisementInfo, paramule);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufg
 * JD-Core Version:    0.7.0.1
 */