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
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
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

public class udy
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
  
  public static JumpMode a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity)
  {
    return a(paramAdvertisementInfo, paramActivity, null);
  }
  
  public static JumpMode a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, udz paramudz)
  {
    uvp.a(paramActivity);
    int i = udw.a(paramAdvertisementInfo);
    ukq.a("ReadInJoyAdJumpUtils", "adType = " + i);
    switch (i)
    {
    case 5: 
    default: 
      return a(a(paramAdvertisementInfo), paramActivity);
    case 2: 
    case 6: 
      return JumpMode.FAIL;
    case 4: 
      boolean bool = false;
      if (a(paramAdvertisementInfo))
      {
        bool = a(paramAdvertisementInfo.mAdvertisementSoftInfo.g, paramActivity);
        ukq.a("ReadInJoyAdJumpUtils", "jumpScheme result = " + bool);
      }
      if (!bool) {
        return a(a(paramAdvertisementInfo), paramActivity);
      }
      return JumpMode.ANDROID_DEEP_LINK;
    case 7: 
      a(paramActivity, paramAdvertisementInfo);
      return JumpMode.PK_MIDDLE;
    }
    udz localudz = paramudz;
    if (paramudz == null) {
      localudz = new udz();
    }
    if (((paramAdvertisementInfo.mAdvertisementExtInfo == null) || (paramAdvertisementInfo.mAdvertisementExtInfo.j == 32)) && (a(paramAdvertisementInfo, paramActivity, localudz)))
    {
      ukq.a("ReadInJoyAdJumpUtils", "jumpToGdt" + localudz.toString());
      return JumpMode.AMS;
    }
    return a(a(paramAdvertisementInfo), paramActivity);
  }
  
  private static JumpMode a(String paramString, Activity paramActivity)
  {
    ukq.a("ReadInJoyAdJumpUtils", "jumpUrl 。url = " + paramString);
    return pqx.a(paramActivity, paramString);
  }
  
  private static String a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (uki.a(paramAdvertisementInfo)) {
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
      return uvp.a(paramString2);
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
    pib.a(localBundle, paramAdvertisementInfo);
    localBundle.putLong("param_ad_app_info_video_playposition", paramInt);
    uvp.a(paramActivity);
    NativeAdVideoFragment.a(paramActivity, NativeAdVideoFragment.class, localBundle);
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, udz paramudz)
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
    localBundle.putLong("param_ad_app_info_video_playposition", paramudz.b);
    uvp.a(paramActivity);
    ReadInJoyNativeAdAppFragment.a(paramActivity, ReadInJoyNativeAdAppFragment.class, localBundle);
  }
  
  private static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo == null)) {}
    while ((!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.h)) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.g))) {
      return false;
    }
    return true;
  }
  
  private static boolean a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, GdtHandler.Params paramParams, udz paramudz)
  {
    boolean bool = false;
    if (paramParams == null) {
      return false;
    }
    if ((paramAdvertisementInfo.mChannelID == 0L) || (paramAdvertisementInfo.mChannelID == 2L) || (paramAdvertisementInfo.isCommentAd())) {
      bool = ukr.b(paramAdvertisementInfo);
    }
    paramParams.f = bool;
    return a(paramParams, paramActivity, paramAdvertisementInfo);
  }
  
  private static boolean a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, udz paramudz)
  {
    int i = a(paramAdvertisementInfo);
    ukq.a("ReadInJoyAdJumpUtils", "gdtType = " + i);
    udz localudz = paramudz;
    if (paramudz == null) {
      localudz = new udz();
    }
    paramudz = udx.a(paramAdvertisementInfo, paramActivity, localudz);
    switch (i)
    {
    default: 
      return false;
    case 2: 
      return b(paramAdvertisementInfo, paramActivity, paramudz, localudz);
    case 3: 
      return a(paramAdvertisementInfo, paramActivity, paramudz, localudz);
    case 4: 
      return c(paramAdvertisementInfo, paramActivity, paramudz, localudz);
    case 5: 
      a(paramAdvertisementInfo, paramActivity, localudz);
      return true;
    }
    a(paramAdvertisementInfo, paramActivity, localudz.b);
    return true;
  }
  
  private static boolean a(GdtHandler.Params paramParams, Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramParams == null) || (paramAdvertisementInfo == null) || (paramContext == null)) {
      return false;
    }
    uks.b(paramAdvertisementInfo);
    GdtHandler.a(paramParams);
    ukq.a("ReadInJoyAdJumpUtils", "jumpToGdtAdRealPage");
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
        ukq.a("ReadInJoyAdJumpUtils", "jumpScheme: ActivityInfo = null");
        return false;
      }
      ukq.a("ReadInJoyAdJumpUtils", "jumpScheme: packageName = " + paramString.packageName);
      if (!TextUtils.isEmpty(paramString.packageName))
      {
        uvp.a(paramActivity);
        paramActivity.startActivity(localIntent);
        return true;
      }
    }
    catch (Exception paramString)
    {
      ukq.a("ReadInJoyAdJumpUtils", "jumpScheme: e = " + paramString.getMessage());
    }
    return false;
  }
  
  private static boolean b(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, GdtHandler.Params paramParams, udz paramudz)
  {
    if (paramParams == null) {
      return false;
    }
    return a(paramParams, paramActivity, paramAdvertisementInfo);
  }
  
  private static boolean c(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, GdtHandler.Params paramParams, udz paramudz)
  {
    if (paramParams == null) {
      return false;
    }
    uvp.a(paramParams, true, paramAdvertisementInfo, paramActivity);
    if (a(paramParams, paramActivity, paramAdvertisementInfo)) {
      return true;
    }
    paramudz = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    paramudz.aid.set(paramAdvertisementInfo.mAdAid);
    paramudz.traceid.set(paramAdvertisementInfo.mAdTraceId);
    paramudz.view_id.set(paramAdvertisementInfo.mAdViewId);
    paramParams = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    paramParams.exposure_url.set(paramAdvertisementInfo.mAdApurl);
    paramParams.click_url.set(paramAdvertisementInfo.mAdRl);
    paramParams.trace_info.set(paramudz);
    paramudz = new qq_ad_get.QQAdGetRsp.AdInfo();
    paramudz.report_info.set(paramParams);
    GdtAd localGdtAd = new GdtAd(paramudz);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    paramudz = paramAdvertisementInfo.mAdLandingPage;
    paramParams = paramudz;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramParams = Uri.parse(paramudz).buildUpon();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udy
 * JD-Core Version:    0.7.0.1
 */