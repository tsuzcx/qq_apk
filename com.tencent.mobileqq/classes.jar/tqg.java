import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.fragment.NativeAdVideoFragment;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdAppFragment;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoCeilingFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdPKFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class tqg
{
  private static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    switch (paramAdvertisementInfo.mAdJumpMode)
    {
    }
    do
    {
      do
      {
        return 2;
        return 3;
      } while (TextUtils.isEmpty(paramAdvertisementInfo.mAdAppJson));
      return 5;
      return 4;
      return 6;
    } while (TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage));
    return 1;
  }
  
  private static String a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (twh.a(paramAdvertisementInfo)) {
      return a(paramAdvertisementInfo.gameAdComData.p, paramAdvertisementInfo.gameAdComData.q, "");
    }
    if (paramAdvertisementInfo.isSoftAd()) {
      return a(paramAdvertisementInfo.mAdvertisementSoftInfo.f, paramAdvertisementInfo.mAdvertisementSoftInfo.h, "");
    }
    return paramAdvertisementInfo.mAdLandingPage;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      return uhs.a(paramString2);
      if (!TextUtils.isEmpty(paramString3)) {
        paramString2 = paramString3;
      } else {
        paramString2 = paramString1;
      }
    }
  }
  
  private static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("param_ad_info", paramAdvertisementInfo);
    ReadinjoyAdPKFragment.a(paramActivity, ReadinjoyAdPKFragment.class, localBundle);
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, int paramInt)
  {
    Bundle localBundle = new Bundle();
    oyv.a(localBundle, paramAdvertisementInfo);
    localBundle.putLong("param_ad_app_info_video_playposition", paramInt);
    uhs.a(paramActivity);
    NativeAdVideoFragment.a(paramActivity, NativeAdVideoFragment.class, localBundle);
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, tqh paramtqh)
  {
    String str = paramAdvertisementInfo.mAdAppJson;
    Bundle localBundle = new Bundle();
    localBundle.putString("param_ad_json", str);
    localBundle.putString("param_ad_app_info_trace_id", paramAdvertisementInfo.mAdTraceId);
    localBundle.putLong("param_ad_app_info_pull_time", paramAdvertisementInfo.mAdFetchTime);
    localBundle.putString("param_ad_app_info_view_id", paramAdvertisementInfo.mAdViewId);
    localBundle.putLong("param_ad_app_info_pos_id", paramAdvertisementInfo.mAdPosID);
    localBundle.putInt("param_ad_app_info_kd_pos", paramAdvertisementInfo.mAdKdPos);
    localBundle.putString("param_ad_app_info_product_id", paramAdvertisementInfo.mAdProductId);
    localBundle.putInt("param_ad_app_info_product_type", paramAdvertisementInfo.mAdProductType);
    localBundle.putString("param_ad_app_info_ap_url", paramAdvertisementInfo.mAdApurl);
    localBundle.putLong("param_ad_app_info_video_playposition", paramtqh.b);
    uhs.a(paramActivity);
    ReadInJoyNativeAdAppFragment.a(paramActivity, ReadInJoyNativeAdAppFragment.class, localBundle);
  }
  
  private static void a(String paramString, Activity paramActivity)
  {
    pay.d(paramActivity, paramString);
    twp.a("ReadInJoyAdJumpUtils", "jumpUrl 。url = " + paramString);
  }
  
  private static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo == null)) {}
    while ((!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.h)) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.g))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity)
  {
    return a(paramAdvertisementInfo, paramActivity, null, null);
  }
  
  private static boolean a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, GdtHandler.Params paramParams, tqh paramtqh)
  {
    boolean bool = false;
    if (paramParams == null) {
      return false;
    }
    if ((paramAdvertisementInfo.mChannelID == 0L) || (paramAdvertisementInfo.mChannelID == 2L) || (paramAdvertisementInfo.isCommentAd())) {
      bool = twq.b(paramAdvertisementInfo);
    }
    paramParams.f = bool;
    return a(paramParams, paramActivity, paramAdvertisementInfo);
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, tqh paramtqh)
  {
    return a(paramAdvertisementInfo, paramActivity, paramtqh, null);
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, tqh paramtqh, tqf paramtqf)
  {
    uhs.a(paramActivity);
    int i = tqd.a(paramAdvertisementInfo);
    twp.a("ReadInJoyAdJumpUtils", "adType = " + i);
    boolean bool;
    switch (i)
    {
    case 5: 
    default: 
      a(a(paramAdvertisementInfo), paramActivity);
    case 2: 
    case 6: 
      do
      {
        return false;
      } while (paramtqf == null);
      paramtqf.a(paramAdvertisementInfo, paramActivity);
      return false;
    case 4: 
      if (a(paramAdvertisementInfo))
      {
        bool = a(paramAdvertisementInfo.mAdvertisementSoftInfo.g, paramActivity);
        twp.a("ReadInJoyAdJumpUtils", "jumpScheme result = " + bool);
      }
      break;
    }
    while (!bool)
    {
      a(a(paramAdvertisementInfo), paramActivity);
      return false;
      a(paramActivity, paramAdvertisementInfo);
      return false;
      paramtqf = paramtqh;
      if (paramtqh == null) {
        paramtqf = new tqh();
      }
      if (b(paramAdvertisementInfo, paramActivity, paramtqf))
      {
        twp.a("ReadInJoyAdJumpUtils", "jumpToGdt" + paramtqf.toString());
        return true;
      }
      a(a(paramAdvertisementInfo), paramActivity);
      return false;
      bool = false;
    }
  }
  
  private static boolean a(GdtHandler.Params paramParams, Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramParams == null) || (paramAdvertisementInfo == null) || (paramContext == null)) {
      return false;
    }
    twr.b(paramAdvertisementInfo);
    GdtHandler.a(paramParams);
    twp.a("ReadInJoyAdJumpUtils", "jumpToGdtAdRealPage");
    return true;
  }
  
  public static boolean a(String paramString, Activity paramActivity)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      localIntent.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
      localIntent.putExtra("big_brother_ref_source_key", "biz_src_feeds_kandian");
      paramString = localIntent.resolveActivityInfo(paramActivity.getPackageManager(), 0);
      if (paramString == null)
      {
        twp.a("ReadInJoyAdJumpUtils", "jumpScheme: ActivityInfo = null");
        return false;
      }
      twp.a("ReadInJoyAdJumpUtils", "jumpScheme: packageName = " + paramString.packageName);
      if (!TextUtils.isEmpty(paramString.packageName))
      {
        uhs.a(paramActivity);
        paramActivity.startActivity(localIntent);
        return true;
      }
    }
    catch (Exception paramString)
    {
      twp.a("ReadInJoyAdJumpUtils", "jumpScheme: e = " + paramString.getMessage());
    }
    return false;
  }
  
  private static boolean b(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, GdtHandler.Params paramParams, tqh paramtqh)
  {
    if (paramParams == null) {
      return false;
    }
    return a(paramParams, paramActivity, paramAdvertisementInfo);
  }
  
  private static boolean b(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, tqh paramtqh)
  {
    int i = a(paramAdvertisementInfo);
    twp.a("ReadInJoyAdJumpUtils", "gdtType = " + i);
    tqh localtqh = paramtqh;
    if (paramtqh == null) {
      localtqh = new tqh();
    }
    paramtqh = tqe.a(paramAdvertisementInfo, paramActivity, localtqh);
    switch (i)
    {
    default: 
      return false;
    case 2: 
      return b(paramAdvertisementInfo, paramActivity, paramtqh, localtqh);
    case 3: 
      return a(paramAdvertisementInfo, paramActivity, paramtqh, localtqh);
    case 4: 
      return c(paramAdvertisementInfo, paramActivity, paramtqh, localtqh);
    case 5: 
      a(paramAdvertisementInfo, paramActivity, localtqh);
      return true;
    }
    a(paramAdvertisementInfo, paramActivity, localtqh.b);
    return true;
  }
  
  private static boolean c(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, GdtHandler.Params paramParams, tqh paramtqh)
  {
    if (paramParams == null) {
      return false;
    }
    uhs.a(paramParams, true, paramAdvertisementInfo, paramActivity);
    if (a(paramParams, paramActivity, paramAdvertisementInfo)) {
      return true;
    }
    paramtqh = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    paramtqh.aid.set(paramAdvertisementInfo.mAdAid);
    paramtqh.traceid.set(paramAdvertisementInfo.mAdTraceId);
    paramtqh.view_id.set(paramAdvertisementInfo.mAdViewId);
    paramParams = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    paramParams.exposure_url.set(paramAdvertisementInfo.mAdApurl);
    paramParams.click_url.set(paramAdvertisementInfo.mAdRl);
    paramParams.trace_info.set(paramtqh);
    paramtqh = new qq_ad_get.QQAdGetRsp.AdInfo();
    paramtqh.report_info.set(paramParams);
    GdtAd localGdtAd = new GdtAd(paramtqh);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    paramtqh = paramAdvertisementInfo.mAdLandingPage;
    paramParams = paramtqh;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramParams = Uri.parse(paramtqh).buildUpon();
      if ((NetworkUtil.getNetworkType(BaseApplicationImpl.getApplication()) != 1) || (paramAdvertisementInfo.mChannelID == 0L)) {
        break label292;
      }
      paramParams.appendQueryParameter("autodownload", "1");
    }
    for (;;)
    {
      paramParams = paramParams.toString();
      paramAdvertisementInfo = new GdtVideoCeilingData();
      paramAdvertisementInfo.setVideoData(localGdtVideoData);
      paramAdvertisementInfo.setAd(localGdtAd);
      paramAdvertisementInfo.setWebUrl(paramParams);
      if (paramAdvertisementInfo.getStyle() == -2147483648) {
        paramAdvertisementInfo.setStyle(1);
      }
      paramParams = new Bundle();
      paramParams.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
      ReadInJoyVideoCeilingFragment.a(paramActivity, ReadInJoyVideoCeilingFragment.class, paramAdvertisementInfo, paramParams);
      return false;
      label292:
      paramParams.appendQueryParameter("autodownload", "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqg
 * JD-Core Version:    0.7.0.1
 */