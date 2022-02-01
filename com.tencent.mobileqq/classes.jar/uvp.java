import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.NativeAd.fragment.NativeAdVideoFragment;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdAppFragment;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdPopSheetBrowserFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoCeilingFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.ad_jump.TKDAdJumpData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdPKFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class uvp
{
  public static GdtAppReceiver a;
  private static ArrayList<Integer> a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(12), Integer.valueOf(25), Integer.valueOf(30), Integer.valueOf(41), Integer.valueOf(1000) }));
  }
  
  public static JumpMode a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, szd paramszd, int paramInt, boolean paramBoolean, ufu paramufu)
  {
    paramufu = a(paramActivity, paramAdvertisementInfo, paramszd, paramInt, paramBoolean, paramufu);
    if ((paramAdvertisementInfo != null) && (paramufu != null))
    {
      a(paramufu, true, paramAdvertisementInfo, paramActivity);
      paramufu = a(paramufu, paramActivity, paramAdvertisementInfo);
      if (paramufu != JumpMode.FAIL) {
        return paramufu;
      }
    }
    Object localObject = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).aid.set(paramAdvertisementInfo.mAdAid);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).traceid.set(paramAdvertisementInfo.mAdTraceId);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).view_id.set(paramAdvertisementInfo.mAdViewId);
    paramufu = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    paramufu.exposure_url.set(paramAdvertisementInfo.mAdApurl);
    paramufu.click_url.set(paramAdvertisementInfo.mAdRl);
    paramufu.trace_info.set((MessageMicro)localObject);
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.set(paramufu);
    GdtAd localGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    localObject = paramAdvertisementInfo.mAdLandingPage;
    paramufu = (ufu)localObject;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramufu = Uri.parse((String)localObject).buildUpon();
      if ((NetworkUtil.getNetworkType(BaseApplicationImpl.getApplication()) != 1) || (paramInt == 0)) {
        break label353;
      }
      paramufu.appendQueryParameter("autodownload", "1");
    }
    for (;;)
    {
      paramufu = paramufu.toString();
      localObject = new GdtVideoCeilingData();
      ((GdtVideoCeilingData)localObject).setVideoData(localGdtVideoData);
      ((GdtVideoCeilingData)localObject).setAd(localGdtAd);
      ((GdtVideoCeilingData)localObject).setWebUrl(paramufu);
      paramInt = paramAdvertisementInfo.mAdJumpMode;
      if (QLog.isColorLevel()) {
        QLog.d("ReadinJoyActionUtil", 0, "jump mode = " + paramInt);
      }
      if (paramInt != 4) {
        break label378;
      }
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdAppJson)) {
        break;
      }
      return a(paramActivity, paramAdvertisementInfo, paramszd, 0, null);
      label353:
      paramufu.appendQueryParameter("autodownload", "0");
    }
    a(paramActivity, paramAdvertisementInfo, paramszd, 0, false);
    return JumpMode.UNKNOWN;
    label378:
    if (paramInt == 5)
    {
      b(paramActivity, paramAdvertisementInfo, paramszd, 0, false);
      return JumpMode.AMS;
    }
    if (((GdtVideoCeilingData)localObject).getStyle() == -2147483648) {
      ((GdtVideoCeilingData)localObject).setStyle(1);
    }
    paramAdvertisementInfo = new Bundle();
    paramAdvertisementInfo.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    ReadInJoyVideoCeilingFragment.a(paramActivity, ReadInJoyVideoCeilingFragment.class, (GdtVideoCeilingData)localObject, paramAdvertisementInfo);
    return JumpMode.WEBVIEW_LANDINGPAGE;
  }
  
  public static JumpMode a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, szd paramszd, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ufu paramufu)
  {
    if (paramAdvertisementInfo == null) {
      paramufu = JumpMode.FAIL;
    }
    do
    {
      return paramufu;
      localObject = a(paramActivity, paramAdvertisementInfo, paramszd, paramInt, paramBoolean1, paramufu);
      if (localObject == null) {
        break;
      }
      ((GdtHandler.Params)localObject).f = paramBoolean2;
      if (paramufu == null) {
        a((GdtHandler.Params)localObject, true, paramAdvertisementInfo, paramActivity);
      }
      localObject = a((GdtHandler.Params)localObject, paramActivity, paramAdvertisementInfo);
      paramufu = (ufu)localObject;
    } while (localObject != JumpMode.FAIL);
    Object localObject = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).aid.set(paramAdvertisementInfo.mAdAid);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).traceid.set(paramAdvertisementInfo.mAdTraceId);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).view_id.set(paramAdvertisementInfo.mAdViewId);
    paramufu = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    paramufu.exposure_url.set(paramAdvertisementInfo.mAdApurl);
    paramufu.click_url.set(paramAdvertisementInfo.mAdRl);
    paramufu.trace_info.set((MessageMicro)localObject);
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.set(paramufu);
    GdtAd localGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setDirectPlay(paramBoolean2);
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    localObject = paramAdvertisementInfo.mAdLandingPage;
    paramufu = (ufu)localObject;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramufu = Uri.parse((String)localObject).buildUpon();
      if ((NetworkUtil.getNetworkType(BaseApplicationImpl.getApplication()) != 1) || (paramInt == 0)) {
        break label381;
      }
      paramufu.appendQueryParameter("autodownload", "1");
    }
    for (;;)
    {
      paramufu = paramufu.toString();
      localObject = new GdtVideoCeilingData();
      ((GdtVideoCeilingData)localObject).setVideoData(localGdtVideoData);
      ((GdtVideoCeilingData)localObject).setAd(localGdtAd);
      ((GdtVideoCeilingData)localObject).setWebUrl(paramufu);
      paramInt = paramAdvertisementInfo.mAdJumpMode;
      if (QLog.isColorLevel()) {
        QLog.d("ReadinJoyActionUtil", 0, "jump mode = " + paramInt);
      }
      if (paramInt != 4) {
        break label406;
      }
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdAppJson)) {
        break;
      }
      return a(paramActivity, paramAdvertisementInfo, paramszd, 0, null);
      label381:
      paramufu.appendQueryParameter("autodownload", "0");
    }
    a(paramActivity, paramAdvertisementInfo, paramszd, 0, false);
    return JumpMode.UNKNOWN;
    label406:
    if (paramInt == 5)
    {
      b(paramActivity, paramAdvertisementInfo, paramszd, 0, false);
      return JumpMode.AMS;
    }
    if (((GdtVideoCeilingData)localObject).getStyle() == -2147483648) {
      ((GdtVideoCeilingData)localObject).setStyle(1);
    }
    paramAdvertisementInfo = new Bundle();
    paramAdvertisementInfo.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    ReadInJoyVideoCeilingFragment.a(paramActivity, ReadInJoyVideoCeilingFragment.class, (GdtVideoCeilingData)localObject, paramAdvertisementInfo);
    return JumpMode.WEBVIEW_LANDINGPAGE;
  }
  
  public static JumpMode a(Activity paramActivity, ArticleInfo paramArticleInfo, szd paramszd, int paramInt, ufu paramufu)
  {
    if (!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) {
      return JumpMode.FAIL;
    }
    if (paramInt == 0)
    {
      pvj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if (paramszd != null) {
        paramszd.notifyDataSetChanged();
      }
    }
    int i = ((AdvertisementInfo)paramArticleInfo).clickPos;
    GdtHandler.Params localParams = a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramszd, paramInt, true, paramufu);
    if ((localParams != null) && (paramufu == null)) {
      a(localParams, true, (AdvertisementInfo)paramArticleInfo, paramActivity);
    }
    paramszd = a(localParams, paramActivity, (AdvertisementInfo)paramArticleInfo);
    ((AdvertisementInfo)paramArticleInfo).clickPos = i;
    if (paramszd == JumpMode.FAIL)
    {
      paramufu = paramArticleInfo.mArticleContentUrl;
      if (uks.g((AdvertisementInfo)paramArticleInfo))
      {
        paramszd = a((AdvertisementInfo)paramArticleInfo);
        if (paramszd == null) {
          break label447;
        }
        paramszd = paramszd.a;
        if (!TextUtils.isEmpty(paramszd)) {
          label148:
          if ((AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo)) && (NetworkUtil.isWifiConnected(null)))
          {
            if (paramszd.contains("?")) {}
            for (paramszd = paramszd + "&";; paramszd = paramszd + "?")
            {
              paramszd = paramszd + "acttype=42";
              label214:
              a(paramActivity);
              if (!uks.j((AdvertisementInfo)paramArticleInfo)) {
                break;
              }
              paramszd = pqx.a(paramActivity, paramszd);
              a(paramActivity, paramArticleInfo, paramInt, paramszd);
              return paramszd;
            }
            paramufu = new Intent(paramActivity, QQBrowserActivity.class);
            paramufu.putExtra("startOpenPageTime", System.currentTimeMillis());
            paramufu.putExtra("url", paramszd);
            paramufu.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
            if ((localParams != null) && (localParams.a != null))
            {
              if (localParams.a.getNocoId() != 0L) {
                paramufu.putExtra("GdtNocoId", localParams.a.getNocoId());
              }
              if (!TextUtils.isEmpty(localParams.a.getUrlForEffect())) {
                paramufu.putExtra("GdtWebReportQQ_ACTION_URL", localParams.a.getUrlForAction());
              }
              if (!TextUtils.isEmpty(localParams.a.getTraceId())) {
                paramufu.putExtra("GdtWebReportQQ_TRACE_ID", localParams.a.getTraceId());
              }
            }
            paramActivity.startActivity(paramufu);
            paramszd = JumpMode.WEBVIEW_LANDINGPAGE;
          }
        }
      }
    }
    for (;;)
    {
      a(paramActivity, paramArticleInfo, paramInt, paramszd);
      return paramszd;
      break label214;
      paramszd = paramufu;
      break label148;
      label447:
      paramszd = "";
      break;
    }
  }
  
  public static JumpMode a(Activity paramActivity, ArticleInfo paramArticleInfo, szd paramszd, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ufu paramufu)
  {
    if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) || (!(paramArticleInfo instanceof AdvertisementInfo))) {
      return JumpMode.FAIL;
    }
    if (ugj.a(paramArticleInfo))
    {
      JumpMode localJumpMode = TKDAdJumpData.NormalAdJumpData.obtainJumpData(paramArticleInfo).doJumpAction(paramActivity);
      if (localJumpMode != JumpMode.FAIL)
      {
        a(paramActivity, paramArticleInfo, paramInt, localJumpMode);
        return JumpMode.AMS;
      }
    }
    if (paramufu == null) {
      paramufu = new ufu();
    }
    for (;;)
    {
      if ((((AdvertisementInfo)paramArticleInfo).mAdProductType == 6) && (a(paramActivity, 2086, paramArticleInfo)))
      {
        a(paramActivity, paramArticleInfo, paramInt, JumpMode.MINIGAME);
        if (paramInt == 0)
        {
          pvj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
          if (paramszd != null) {
            paramszd.notifyDataSetChanged();
          }
        }
        return JumpMode.MINIGAME;
      }
      switch (((AdvertisementInfo)paramArticleInfo).mAdJumpMode)
      {
      default: 
        return JumpMode.FAIL;
      case 2: 
        return c(paramActivity, (AdvertisementInfo)paramArticleInfo, paramszd, paramInt, paramBoolean1, paramufu);
      case 0: 
      case 1: 
      case 6: 
      case 7: 
        return a(paramActivity, paramArticleInfo, paramszd, paramInt, paramufu);
      case 4: 
        if (TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdAppJson)) {
          return a(paramActivity, paramArticleInfo, paramszd, paramInt, null);
        }
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramszd, paramInt, true);
        return JumpMode.UNKNOWN;
      case 3: 
        paramufu.jdField_a_of_type_Boolean = a(paramArticleInfo, paramszd);
        int i = ((AdvertisementInfo)paramArticleInfo).clickPos;
        paramufu = a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramszd, paramInt, paramBoolean1, paramBoolean2, paramufu);
        ((AdvertisementInfo)paramArticleInfo).clickPos = i;
        a(paramActivity, paramArticleInfo, paramInt, paramufu);
        pvj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (paramszd != null) {
          paramszd.notifyDataSetChanged();
        }
        return paramufu;
      }
      b(paramActivity, (AdvertisementInfo)paramArticleInfo, paramszd, paramInt, true);
      return JumpMode.AMS;
    }
  }
  
  public static JumpMode a(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramContext == null) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage))) {
      return JumpMode.FAIL;
    }
    if (uks.l(paramAdvertisementInfo)) {
      return pqx.a(paramContext, paramAdvertisementInfo.mAdLandingPage);
    }
    return JumpMode.FAIL;
  }
  
  public static JumpMode a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, szd paramszd, int paramInt, boolean paramBoolean)
  {
    paramszd = a(paramContext, paramAdvertisementInfo, paramszd, paramInt, paramBoolean, null);
    if (paramszd == null) {
      return JumpMode.FAIL;
    }
    return b(paramszd, paramContext, paramAdvertisementInfo);
  }
  
  public static JumpMode a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, szd paramszd, int paramInt, boolean paramBoolean, ufu paramufu)
  {
    paramszd = a(paramContext, paramAdvertisementInfo, paramszd, paramInt, paramBoolean, paramufu);
    if (paramszd == null) {
      return JumpMode.FAIL;
    }
    return b(paramszd, paramContext, paramAdvertisementInfo);
  }
  
  public static JumpMode a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, szd paramszd, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramszd = a(paramContext, paramAdvertisementInfo, paramszd, paramInt, paramBoolean1, null);
    if (paramszd == null) {
      return JumpMode.FAIL;
    }
    paramszd.f = paramBoolean2;
    return b(paramszd, paramContext, paramAdvertisementInfo);
  }
  
  public static JumpMode a(Context paramContext, AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramContext == null) || (!(paramContext instanceof Activity)) || (paramAdData == null) || (paramAdvertisementInfo == null)) {
      return JumpMode.FAIL;
    }
    if (uki.a(paramAdData))
    {
      a(paramContext);
      uks.b(paramAdvertisementInfo);
      paramContext = uki.a(paramContext, paramAdData);
      QQAppInterface localQQAppInterface = (QQAppInterface)pkh.a();
      ois.a(new ufy().a(localQQAppInterface).a(BaseApplication.getContext()).a(1).b(25).a(paramContext).a(paramAdvertisementInfo).d(ois.a(paramAdData)).a());
      return paramContext;
    }
    return JumpMode.FAIL;
  }
  
  public static JumpMode a(GdtHandler.Params paramParams, Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramParams == null) {
      return JumpMode.FAIL;
    }
    return b(paramParams, paramContext, paramAdvertisementInfo);
  }
  
  public static GdtHandler.Params a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, szd paramszd, int paramInt, boolean paramBoolean, ufu paramufu)
  {
    return a(paramContext, paramAdvertisementInfo, paramszd, paramInt, paramBoolean, true, false, paramufu);
  }
  
  public static GdtHandler.Params a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, szd paramszd, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ufu paramufu)
  {
    if ((paramBoolean2) && (!a(paramAdvertisementInfo, paramInt))) {
      return null;
    }
    udz localudz = new udz();
    localudz.b = paramBoolean1;
    localudz.d = paramBoolean3;
    if (paramufu != null) {
      if (paramufu.b) {
        break label105;
      }
    }
    label105:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      localudz.jdField_a_of_type_Boolean = paramBoolean1;
      localudz.c = paramufu.jdField_a_of_type_Boolean;
      localudz.jdField_a_of_type_Long = paramufu.jdField_a_of_type_Long;
      if (paramszd != null) {
        localudz.jdField_a_of_type_Long = paramszd.a();
      }
      return udx.a(paramAdvertisementInfo, (Activity)paramContext, localudz);
    }
  }
  
  public static String a(ArticleInfo paramArticleInfo, String paramString)
  {
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      paramArticleInfo = ((AdvertisementInfo)paramArticleInfo).mAdExtInfo;
      if (!TextUtils.isEmpty(paramArticleInfo)) {}
    }
    else
    {
      return "";
    }
    try
    {
      paramArticleInfo = new JSONObject(paramArticleInfo).optString(paramString);
      return paramArticleInfo;
    }
    catch (JSONException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    Object localObject = paramString;
    String str;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.startsWith("http"))
      {
        localObject = paramString;
        if (!paramString.startsWith("https")) {}
      }
      else
      {
        str = paramString;
      }
    }
    try
    {
      if (QLog.isColorLevel())
      {
        str = paramString;
        QLog.e("ReadinJoyActionUtil", 0, "appendUrlParameter, before url:" + paramString);
      }
      str = paramString;
      localObject = Uri.parse(paramString).buildUpon();
      str = paramString;
      ((Uri.Builder)localObject).appendQueryParameter("adclickts", String.valueOf(System.currentTimeMillis()));
      str = paramString;
      paramString = ((Uri.Builder)localObject).build().toString();
      localObject = paramString;
      str = paramString;
      if (QLog.isColorLevel())
      {
        str = paramString;
        QLog.e("ReadinJoyActionUtil", 0, "appendUrlParameter, after url:" + paramString);
        localObject = paramString;
      }
    }
    catch (Exception paramString)
    {
      do
      {
        localObject = str;
      } while (!QLog.isColorLevel());
      QLog.e("ReadinJoyActionUtil", 0, "appendUrlParameter, url:" + str + " , error:" + paramString.getMessage());
    }
    return localObject;
    return str;
  }
  
  /* Error */
  public static qq_ad_get.QQAdGetRsp.AdInfo a(AdvertisementInfo paramAdvertisementInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnonnull +7 -> 10
    //   6: aload_1
    //   7: astore_0
    //   8: aload_0
    //   9: areturn
    //   10: new 609	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo
    //   13: dup
    //   14: invokespecial 610	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:<init>	()V
    //   17: astore_1
    //   18: aload_1
    //   19: getfield 613	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:advertiser_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   22: aload_0
    //   23: getfield 616	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAdvertiseId	J
    //   26: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   29: aload_0
    //   30: getfield 619	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateLogo	Ljava/lang/String;
    //   33: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifne +14 -> 50
    //   39: aload_1
    //   40: getfield 622	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:corporate_logo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   43: aload_0
    //   44: getfield 619	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateLogo	Ljava/lang/String;
    //   47: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 625	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateImageName	Ljava/lang/String;
    //   54: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +14 -> 71
    //   60: aload_1
    //   61: getfield 628	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:corporate_image_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   64: aload_0
    //   65: getfield 625	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateImageName	Ljava/lang/String;
    //   68: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   71: new 630	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo
    //   74: dup
    //   75: invokespecial 631	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:<init>	()V
    //   78: astore_2
    //   79: aload_0
    //   80: getfield 139	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVideoUrl	Ljava/lang/String;
    //   83: ifnull +14 -> 97
    //   86: aload_2
    //   87: getfield 634	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:video_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   90: aload_0
    //   91: getfield 139	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVideoUrl	Ljava/lang/String;
    //   94: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   97: new 636	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo
    //   100: dup
    //   101: invokespecial 637	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:<init>	()V
    //   104: astore_3
    //   105: aload_3
    //   106: getfield 641	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:advertiser_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo;
    //   109: aload_1
    //   110: invokevirtual 642	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   113: aload_3
    //   114: getfield 646	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:video_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo;
    //   117: aload_2
    //   118: invokevirtual 647	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   121: aload_3
    //   122: getfield 651	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:mini_program_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: aload_0
    //   126: getfield 654	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:miniProgramType	I
    //   129: invokevirtual 658	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   132: new 50	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo
    //   135: dup
    //   136: invokespecial 52	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:<init>	()V
    //   139: astore_1
    //   140: aload_1
    //   141: getfield 56	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:aid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   144: aload_0
    //   145: getfield 62	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAid	J
    //   148: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   151: aload_1
    //   152: getfield 72	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:traceid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   155: aload_0
    //   156: getfield 76	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdTraceId	Ljava/lang/String;
    //   159: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   162: aload_1
    //   163: getfield 84	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:view_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   166: aload_0
    //   167: getfield 87	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdViewId	Ljava/lang/String;
    //   170: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   173: aload_1
    //   174: getfield 661	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:product_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   177: aload_0
    //   178: getfield 664	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductId	Ljava/lang/String;
    //   181: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   184: aload_1
    //   185: getfield 667	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:via	Lcom/tencent/mobileqq/pb/PBStringField;
    //   188: aload_0
    //   189: getfield 670	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVia	Ljava/lang/String;
    //   192: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   195: aload_1
    //   196: getfield 674	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:noco_id	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   199: aload_0
    //   200: getfield 677	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdNocoId	J
    //   203: invokevirtual 680	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   206: new 89	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo
    //   209: dup
    //   210: invokespecial 90	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:<init>	()V
    //   213: astore 4
    //   215: aload 4
    //   217: getfield 93	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:exposure_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   220: aload_0
    //   221: getfield 96	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdApurl	Ljava/lang/String;
    //   224: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   227: aload 4
    //   229: getfield 99	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   232: aload_0
    //   233: getfield 102	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdRl	Ljava/lang/String;
    //   236: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   239: aload 4
    //   241: getfield 683	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:effect_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   244: aload_0
    //   245: getfield 686	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdEffectUrl	Ljava/lang/String;
    //   248: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   251: aload 4
    //   253: getfield 689	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:landing_page_report_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   256: aload_0
    //   257: getfield 692	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdLandingPageReportUrl	Ljava/lang/String;
    //   260: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   263: aload 4
    //   265: getfield 106	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   268: aload_1
    //   269: invokevirtual 109	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   272: new 694	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls
    //   275: dup
    //   276: invokespecial 695	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:<init>	()V
    //   279: astore_1
    //   280: aload_0
    //   281: getfield 698	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SClickUrl	Ljava/util/ArrayList;
    //   284: ifnull +14 -> 298
    //   287: aload_1
    //   288: getfield 702	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:api_click_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   291: aload_0
    //   292: getfield 698	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SClickUrl	Ljava/util/ArrayList;
    //   295: invokevirtual 707	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   298: aload_0
    //   299: getfield 710	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SExposureUrl	Ljava/util/ArrayList;
    //   302: ifnull +14 -> 316
    //   305: aload_1
    //   306: getfield 713	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:api_exposure_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   309: aload_0
    //   310: getfield 710	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SExposureUrl	Ljava/util/ArrayList;
    //   313: invokevirtual 707	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   316: aload_0
    //   317: getfield 716	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SVideoPlayUrl	Ljava/util/ArrayList;
    //   320: ifnull +14 -> 334
    //   323: aload_1
    //   324: getfield 719	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:video_play_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   327: aload_0
    //   328: getfield 716	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SVideoPlayUrl	Ljava/util/ArrayList;
    //   331: invokevirtual 707	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   334: aload 4
    //   336: getfield 723	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:thirdparty_monitor_urls	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls;
    //   339: aload_1
    //   340: invokevirtual 724	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   343: new 726	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo
    //   346: dup
    //   347: invokespecial 727	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:<init>	()V
    //   350: astore 6
    //   352: aload_0
    //   353: getfield 145	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdLandingPage	Ljava/lang/String;
    //   356: astore_2
    //   357: aload_2
    //   358: astore_1
    //   359: aload_0
    //   360: getfield 731	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lufz;
    //   363: ifnull +23 -> 386
    //   366: aload_2
    //   367: astore_1
    //   368: aload_0
    //   369: getfield 731	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lufz;
    //   372: getfield 735	ufz:j	I
    //   375: ldc_w 736
    //   378: if_icmpne +8 -> 386
    //   381: aload_2
    //   382: invokestatic 738	uvp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   385: astore_1
    //   386: aload 6
    //   388: getfield 741	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:landing_page	Lcom/tencent/mobileqq/pb/PBStringField;
    //   391: aload_1
    //   392: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   395: aload 6
    //   397: getfield 744	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:canvas_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   400: aload_0
    //   401: getfield 747	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCanvasJson	Ljava/lang/String;
    //   404: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   407: aload 6
    //   409: getfield 750	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:dest_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   412: aload_0
    //   413: getfield 753	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdDestType	I
    //   416: invokevirtual 658	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   419: new 755	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo
    //   422: dup
    //   423: invokespecial 756	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:<init>	()V
    //   426: astore 5
    //   428: aload_0
    //   429: getfield 759	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   432: invokestatic 764	com/tencent/gdtad/aditem/GdtBaseAdItem:a	(Ljava/lang/String;)Lcom/tencent/gdtad/aditem/GdtBaseAdItem;
    //   435: astore_1
    //   436: aload 5
    //   438: getfield 767	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:app_package_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   441: aload_1
    //   442: getfield 768	com/tencent/gdtad/aditem/GdtBaseAdItem:a	Ljava/lang/String;
    //   445: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   448: new 563	org/json/JSONObject
    //   451: dup
    //   452: aload_0
    //   453: getfield 759	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   456: invokespecial 565	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   459: astore_2
    //   460: aload_2
    //   461: ldc_w 770
    //   464: invokevirtual 569	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   467: astore_1
    //   468: aload_2
    //   469: ldc_w 772
    //   472: invokevirtual 569	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   475: astore_2
    //   476: aload_1
    //   477: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   480: ifne +12 -> 492
    //   483: aload 5
    //   485: getfield 775	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:pkg_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   488: aload_1
    //   489: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   492: aload_2
    //   493: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   496: ifne +12 -> 508
    //   499: aload 5
    //   501: getfield 778	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:app_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   504: aload_2
    //   505: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   508: aload 5
    //   510: getfield 781	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:android_app_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   513: aload_0
    //   514: getfield 664	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductId	Ljava/lang/String;
    //   517: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   520: aload 5
    //   522: getfield 784	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:pkg_download_schema	Lcom/tencent/mobileqq/pb/PBStringField;
    //   525: aload_0
    //   526: getfield 787	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAppDownLoadSchema	Ljava/lang/String;
    //   529: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   532: aload 5
    //   534: getfield 790	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:customized_invoke_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   537: aload_0
    //   538: getfield 793	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCustomizedInvokeUrl	Ljava/lang/String;
    //   541: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   544: invokestatic 208	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   547: ifeq +32 -> 579
    //   550: ldc 210
    //   552: iconst_0
    //   553: new 212	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   560: ldc_w 795
    //   563: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload_0
    //   567: getfield 798	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   570: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 227	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: aload 5
    //   581: getfield 801	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:channel_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   584: astore_2
    //   585: aload_0
    //   586: getfield 798	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   589: ifnonnull +351 -> 940
    //   592: ldc_w 416
    //   595: astore_1
    //   596: aload_2
    //   597: aload_1
    //   598: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   601: aload_0
    //   602: invokestatic 329	uks:g	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   605: ifeq +38 -> 643
    //   608: aload_0
    //   609: getfield 731	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lufz;
    //   612: getfield 804	ufz:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   615: ifnull +28 -> 643
    //   618: aload_0
    //   619: getfield 731	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lufz;
    //   622: getfield 804	ufz:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   625: invokeinterface 809 1 0
    //   630: iconst_2
    //   631: if_icmplt +12 -> 643
    //   634: aload_0
    //   635: invokestatic 332	uvp:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lufv;
    //   638: astore_1
    //   639: aload_1
    //   640: ifnonnull +308 -> 948
    //   643: new 111	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   646: dup
    //   647: invokespecial 112	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   650: astore_1
    //   651: aload_1
    //   652: getfield 812	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:product_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   655: aload_0
    //   656: getfield 441	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductType	I
    //   659: invokevirtual 658	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   662: aload_1
    //   663: getfield 816	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:display_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo;
    //   666: aload_3
    //   667: invokevirtual 817	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   670: aload_1
    //   671: getfield 116	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   674: aload 4
    //   676: invokevirtual 117	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   679: aload_1
    //   680: getfield 821	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:dest_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo;
    //   683: aload 6
    //   685: invokevirtual 822	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   688: new 824	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo
    //   691: dup
    //   692: invokespecial 825	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:<init>	()V
    //   695: astore_2
    //   696: aload_0
    //   697: getfield 561	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   700: astore_3
    //   701: aload_3
    //   702: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   705: ifne +93 -> 798
    //   708: new 563	org/json/JSONObject
    //   711: dup
    //   712: aload_3
    //   713: invokespecial 565	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   716: astore_3
    //   717: aload_2
    //   718: getfield 828	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:ad_trace_data	Lcom/tencent/mobileqq/pb/PBStringField;
    //   721: aload_3
    //   722: ldc_w 830
    //   725: invokevirtual 569	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   728: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   731: aload_2
    //   732: getfield 833	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   735: aload_3
    //   736: ldc_w 835
    //   739: invokevirtual 569	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   742: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   745: aload_2
    //   746: getfield 838	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   749: aload_3
    //   750: ldc_w 840
    //   753: invokevirtual 569	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   756: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   759: aload_2
    //   760: getfield 843	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_token	Lcom/tencent/mobileqq/pb/PBStringField;
    //   763: aload_3
    //   764: ldc_w 845
    //   767: invokevirtual 569	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   770: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   773: aload_2
    //   774: getfield 848	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_username	Lcom/tencent/mobileqq/pb/PBStringField;
    //   777: aload_3
    //   778: ldc_w 850
    //   781: invokevirtual 569	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   784: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   787: aload_2
    //   788: getfield 853	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:pos_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   791: aload_0
    //   792: getfield 856	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdPosID	J
    //   795: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   798: aload_1
    //   799: getfield 860	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:wechat_app_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo;
    //   802: aload_2
    //   803: invokevirtual 861	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   806: aload_1
    //   807: getfield 865	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:app_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo;
    //   810: aload 5
    //   812: invokevirtual 866	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   815: aload_0
    //   816: getfield 759	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   819: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   822: ifne +181 -> 1003
    //   825: new 563	org/json/JSONObject
    //   828: dup
    //   829: aload_0
    //   830: getfield 759	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   833: invokespecial 565	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   836: ldc_w 868
    //   839: ldc_w 416
    //   842: invokevirtual 871	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   845: astore_0
    //   846: invokestatic 208	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   849: ifeq +29 -> 878
    //   852: ldc 210
    //   854: iconst_0
    //   855: new 212	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   862: ldc_w 873
    //   865: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: aload_0
    //   869: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: invokestatic 227	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   878: aload_1
    //   879: getfield 876	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:ext_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   882: aload_0
    //   883: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   886: aload_1
    //   887: areturn
    //   888: astore_2
    //   889: aload_1
    //   890: astore_0
    //   891: invokestatic 208	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   894: ifeq -886 -> 8
    //   897: ldc 210
    //   899: iconst_0
    //   900: new 212	java/lang/StringBuilder
    //   903: dup
    //   904: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   907: ldc_w 878
    //   910: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: aload_2
    //   914: invokevirtual 606	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   917: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   923: invokestatic 227	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   926: aload_1
    //   927: areturn
    //   928: astore_2
    //   929: aconst_null
    //   930: astore_1
    //   931: aload_2
    //   932: invokevirtual 879	java/lang/Exception:printStackTrace	()V
    //   935: aconst_null
    //   936: astore_2
    //   937: goto -461 -> 476
    //   940: aload_0
    //   941: getfield 798	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   944: astore_1
    //   945: goto -349 -> 596
    //   948: aload_1
    //   949: getfield 881	ufv:b	Ljava/lang/String;
    //   952: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   955: ifne +15 -> 970
    //   958: aload 4
    //   960: getfield 99	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   963: aload_1
    //   964: getfield 881	ufv:b	Ljava/lang/String;
    //   967: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   970: aload_1
    //   971: getfield 336	ufv:a	Ljava/lang/String;
    //   974: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   977: ifne -334 -> 643
    //   980: aload 6
    //   982: getfield 741	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:landing_page	Lcom/tencent/mobileqq/pb/PBStringField;
    //   985: aload_1
    //   986: getfield 336	ufv:a	Ljava/lang/String;
    //   989: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   992: goto -349 -> 643
    //   995: astore_3
    //   996: aload_3
    //   997: invokevirtual 572	org/json/JSONException:printStackTrace	()V
    //   1000: goto -202 -> 798
    //   1003: aload_1
    //   1004: getfield 876	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:ext_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1007: ldc_w 416
    //   1010: invokevirtual 81	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   1013: aload_1
    //   1014: astore_0
    //   1015: invokestatic 208	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1018: ifeq -1010 -> 8
    //   1021: ldc 210
    //   1023: iconst_0
    //   1024: ldc_w 883
    //   1027: invokestatic 227	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1030: aload_1
    //   1031: areturn
    //   1032: astore_2
    //   1033: goto -102 -> 931
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1036	0	paramAdvertisementInfo	AdvertisementInfo
    //   1	1030	1	localObject1	Object
    //   78	725	2	localObject2	Object
    //   888	26	2	localException1	Exception
    //   928	4	2	localException2	Exception
    //   936	1	2	localObject3	Object
    //   1032	1	2	localException3	Exception
    //   104	674	3	localObject4	Object
    //   995	2	3	localJSONException	JSONException
    //   213	746	4	localReportInfo	qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo
    //   426	385	5	localAppInfo	tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo
    //   350	631	6	localDestInfo	tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo
    // Exception table:
    //   from	to	target	type
    //   825	878	888	java/lang/Exception
    //   878	886	888	java/lang/Exception
    //   448	468	928	java/lang/Exception
    //   708	798	995	org/json/JSONException
    //   468	476	1032	java/lang/Exception
  }
  
  /* Error */
  private static ufv a(AdvertisementInfo paramAdvertisementInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnull +142 -> 145
    //   6: aload_0
    //   7: getfield 731	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lufz;
    //   10: ifnull +135 -> 145
    //   13: aload_0
    //   14: getfield 731	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lufz;
    //   17: getfield 804	ufz:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   20: ifnull +125 -> 145
    //   23: aload_0
    //   24: getfield 731	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lufz;
    //   27: getfield 804	ufz:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   30: invokeinterface 809 1 0
    //   35: iconst_2
    //   36: if_icmplt +109 -> 145
    //   39: aload_0
    //   40: getfield 320	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:clickPos	I
    //   43: bipush 101
    //   45: if_icmpne +20 -> 65
    //   48: aload_0
    //   49: getfield 731	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lufz;
    //   52: getfield 804	ufz:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   55: iconst_0
    //   56: invokeinterface 887 2 0
    //   61: checkcast 334	ufv
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 320	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:clickPos	I
    //   69: bipush 102
    //   71: if_icmpne +72 -> 143
    //   74: aload_0
    //   75: getfield 731	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lufz;
    //   78: getfield 804	ufz:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   81: iconst_1
    //   82: invokeinterface 887 2 0
    //   87: checkcast 334	ufv
    //   90: astore_2
    //   91: aload_2
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: astore_2
    //   98: invokestatic 208	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   101: ifeq -10 -> 91
    //   104: ldc 210
    //   106: iconst_3
    //   107: new 212	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 889
    //   117: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: invokevirtual 606	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   124: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 587	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload_0
    //   134: areturn
    //   135: astore_2
    //   136: aload_1
    //   137: astore_0
    //   138: aload_2
    //   139: astore_1
    //   140: goto -44 -> 96
    //   143: aload_1
    //   144: areturn
    //   145: aconst_null
    //   146: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramAdvertisementInfo	AdvertisementInfo
    //   1	64	1	localufv	ufv
    //   93	44	1	localException1	Exception
    //   139	5	1	localObject1	Object
    //   90	8	2	localObject2	Object
    //   135	4	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   6	39	93	java/lang/Exception
    //   39	65	93	java/lang/Exception
    //   65	91	135	java/lang/Exception
  }
  
  private static uha a(szd paramszd, String paramString)
  {
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)paramszd.a();
    int j = localReadInJoyXListView.getFirstVisiblePosition();
    int i = Math.max(localReadInJoyXListView.getHeaderViewsCount(), j);
    int k;
    if (i < paramszd.a().size() + localReadInJoyXListView.getHeaderViewsCount())
    {
      k = i - localReadInJoyXListView.getHeaderViewsCount();
      BaseArticleInfo localBaseArticleInfo = paramszd.b(k);
      if ((66 == paramszd.getItemViewType(k)) && (localBaseArticleInfo != null) && (TextUtils.equals(localBaseArticleInfo.getInnerUniqueID(), paramString)))
      {
        int m = i - j;
        if ((m >= 0) && (m < localReadInJoyXListView.getChildCount())) {
          paramszd = localReadInJoyXListView.getChildAt(i - j);
        }
      }
    }
    for (;;)
    {
      if ((paramszd != null) && ((paramszd.getTag() instanceof uha)))
      {
        return (uha)paramszd.getTag();
        if ((k >= 0) && (k < paramszd.a().size())) {
          paramszd = paramszd.getView(k, null, localReadInJoyXListView);
        }
      }
      else
      {
        return null;
        i += 1;
        break;
        return null;
      }
      paramszd = null;
    }
  }
  
  public static void a()
  {
    if ((BaseApplicationImpl.getContext() != null) && (jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver != null))
    {
      BaseApplicationImpl.getContext().unregisterReceiver(jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = null;
    }
  }
  
  public static void a(int paramInt, GdtHandler.Params paramParams, long paramLong) {}
  
  public static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("param_ad_info", paramAdvertisementInfo);
    ReadinjoyAdPKFragment.a(paramActivity, ReadinjoyAdPKFragment.class, localBundle);
  }
  
  private static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, szd paramszd, int paramInt, boolean paramBoolean)
  {
    if ((paramszd != null) && (paramBoolean)) {
      a(paramActivity, paramAdvertisementInfo, paramInt, JumpMode.UNKNOWN);
    }
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
    if (paramszd != null) {
      localBundle.putLong("param_ad_app_info_video_playposition", paramszd.a());
    }
    a(paramActivity);
    ReadInJoyNativeAdAppFragment.a(paramActivity, ReadInJoyNativeAdAppFragment.class, localBundle);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, int paramInt, JumpMode paramJumpMode)
  {
    Object localObject3 = pqw.b(paramArticleInfo);
    int i;
    int j;
    label32:
    int k;
    label45:
    Object localObject4;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label630;
      }
      j = 0;
      if (paramArticleInfo.videoJumpChannelID <= 0) {
        break label636;
      }
      k = paramArticleInfo.videoJumpChannelID;
      olh.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pqf.b(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), paramInt, i), false);
      olh.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pqf.b(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), paramInt, i));
      localObject4 = uvs.b(paramArticleInfo.mChannelID);
      if ((!ppe.i(paramArticleInfo)) && (!ppe.g(paramArticleInfo)) && (!ppe.j(paramArticleInfo)) && (!ppe.k(paramArticleInfo))) {
        break label643;
      }
      olh.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Long), (String)localObject4, (String)localObject4, 0, 0, Long.toString(paramArticleInfo.mFeedId), paramArticleInfo.businessId + "", Integer.toString(paramArticleInfo.mStrategyId), pqf.a(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramActivity), String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long), paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pqw.d(paramArticleInfo), k, paramArticleInfo), false);
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      olh.a((String)localObject4, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pqf.a(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramActivity), (String)localObject3, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pqw.d(paramArticleInfo), k, paramArticleInfo));
      localObject1 = new ArrayList();
      localObject2 = new ReportInfo();
      ((ReportInfo)localObject2).mUin = pkh.a();
      ((ReportInfo)localObject2).mSource = 0;
      ((ReportInfo)localObject2).mSourceArticleId = paramArticleInfo.mArticleID;
      ((ReportInfo)localObject2).mChannelId = paramInt;
      ((ReportInfo)localObject2).mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject2).mStrategyId = paramArticleInfo.mStrategyId;
      ((ReportInfo)localObject2).mOperation = 1;
      ((ReportInfo)localObject2).mServerContext = paramArticleInfo.mServerContext;
      ((ReportInfo)localObject2).mReadTimeLength = -1;
      ((ReportInfo)localObject2).mInnerId = paramArticleInfo.innerUniqueID;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label765;
      }
      localObject3 = new rqf();
      ((rqf)localObject3).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy != null) {
        ((rqf)localObject3).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long;
      }
      ((rqf)localObject3).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((rqf)localObject3).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.d;
      localObject4 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject4 == null) || (((List)localObject4).isEmpty())) {
        break label758;
      }
      ((rqf)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        rqy localrqy = (rqy)((Iterator)localObject4).next();
        if (localrqy != null) {
          ((rqf)localObject3).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localrqy.jdField_a_of_type_Long));
        }
      }
      i = 0;
      break;
      label630:
      j = 1;
      break label32;
      label636:
      k = 56;
      break label45;
      label643:
      localObject2 = pqf.a(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramActivity), (String)localObject3, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pqw.d(paramArticleInfo), k, paramArticleInfo);
      localObject1 = localObject2;
      if (paramInt == 0) {
        localObject1 = omx.a(k, (String)omx.a.get(ReadInJoyChannelActivity.class), (String)localObject2);
      }
      olh.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject4, (String)localObject4, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), (String)localObject1, false);
    }
    label758:
    ((ReportInfo)localObject2).mFeedsReportData = ((rqf)localObject3);
    label765:
    ((List)localObject1).add(localObject2);
    pvj.a().a((List)localObject1);
    pwx.a.b(paramInt, paramArticleInfo);
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (paramArticleInfo.mChannelID == 56L)
      {
        ohz.a((AdvertisementInfo)paramArticleInfo);
        ois.a(new ufy().a(paramActivity).a(1).b(15).a(paramJumpMode).a((AdvertisementInfo)paramArticleInfo).d(((AdvertisementInfo)paramArticleInfo).clickPos).a());
      }
    }
    else {
      return;
    }
    if ((uks.j((AdvertisementInfo)paramArticleInfo)) && (uky.jdField_a_of_type_Boolean)) {
      paramInt = 37;
    }
    for (;;)
    {
      ois.a(new ufy().a(paramActivity).a(1).b(paramInt).a(paramJumpMode).a((AdvertisementInfo)paramArticleInfo).d(((AdvertisementInfo)paramArticleInfo).clickPos).a());
      return;
      if (a((AdvertisementInfo)paramArticleInfo, paramInt)) {
        paramInt = 8;
      } else if (pqw.a(paramArticleInfo)) {
        paramInt = 11;
      } else {
        paramInt = 3;
      }
    }
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, szd paramszd, int paramInt, boolean paramBoolean, ufu paramufu)
  {
    if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) || (!(paramArticleInfo instanceof AdvertisementInfo))) {}
    do
    {
      return;
      if (ugj.a(paramArticleInfo))
      {
        JumpMode localJumpMode = TKDAdJumpData.NormalAdJumpData.obtainJumpData(paramArticleInfo).doJumpAction(paramActivity);
        if (localJumpMode != JumpMode.FAIL)
        {
          a(paramActivity, paramArticleInfo, paramInt, localJumpMode);
          return;
        }
      }
      switch (((AdvertisementInfo)paramArticleInfo).mAdJumpMode)
      {
      default: 
        return;
      case 0: 
      case 1: 
      case 6: 
      case 7: 
        a(paramActivity, paramArticleInfo, paramszd, paramInt, paramufu);
        return;
      case 2: 
        c(paramActivity, (AdvertisementInfo)paramArticleInfo, paramszd, paramInt, paramBoolean, paramufu);
        return;
      case 4: 
        if (TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdAppJson))
        {
          a(paramActivity, paramArticleInfo, paramszd, paramInt, paramufu);
          return;
        }
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramszd, paramInt, true);
        return;
      case 3: 
        int i = ((AdvertisementInfo)paramArticleInfo).clickPos;
        paramufu = a(paramActivity, (AdvertisementInfo)paramArticleInfo, null, paramInt, paramBoolean, paramufu);
        ((AdvertisementInfo)paramArticleInfo).clickPos = i;
        a(paramActivity, paramArticleInfo, paramInt, paramufu);
        pvj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      }
    } while (paramszd == null);
    paramszd.notifyDataSetChanged();
    return;
    b(paramActivity, (AdvertisementInfo)paramArticleInfo, paramszd, paramInt, true);
  }
  
  public static void a(Activity paramActivity, String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("ad", paramAdvertisementInfo);
    localIntent.putExtra("fragmentClass", ReadInJoyAdIMAXBrowserFragment.class);
    localIntent.setClass(BaseApplicationImpl.getApplication(), QQBrowserActivity.class);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130771979, 17432577);
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      biwn.a(paramContext, 7);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadinJoyActionUtil", 0, "closeFloatWindow error:" + paramContext.getMessage());
    }
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, szd paramszd, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramAdvertisementInfo.clickPos;
    paramszd = a(paramContext, paramAdvertisementInfo, paramszd, paramInt, paramBoolean1, paramBoolean2);
    if (i >= 0) {
      paramAdvertisementInfo.setClickPos(i);
    }
    a(paramContext, paramAdvertisementInfo, paramInt, paramszd);
  }
  
  private static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    int i;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label120;
      }
    }
    label120:
    for (int j = 0;; j = 1)
    {
      String str1 = pqw.b(paramArticleInfo);
      String str2 = uvs.b(paramInt);
      olh.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, str2, str2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pqf.a(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramContext), str1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pqw.d(paramArticleInfo), paramArticleInfo), false);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, JumpMode paramJumpMode)
  {
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      ois.a(new ufy().a(paramContext).a(1).b(paramInt2).a(paramJumpMode).a((AdvertisementInfo)paramArticleInfo).e(new JSONObject()).a());
      a(paramContext, paramArticleInfo, paramInt1);
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt, JumpMode paramJumpMode)
  {
    int i;
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (paramArticleInfo.mChannelID != 56L) {
        break label31;
      }
      i = 4;
    }
    for (;;)
    {
      a(paramContext, paramArticleInfo, paramInt, i, paramJumpMode);
      label31:
      do
      {
        return;
        if ((uks.j((AdvertisementInfo)paramArticleInfo)) && (uky.jdField_a_of_type_Boolean))
        {
          i = 37;
          break;
        }
        if (a((AdvertisementInfo)paramArticleInfo, paramInt))
        {
          i = 8;
          break;
        }
        if (pqw.a(paramArticleInfo))
        {
          i = 11;
          break;
        }
      } while ((uks.g((AdvertisementInfo)paramArticleInfo)) && (((AdvertisementInfo)paramArticleInfo).isClickFromPkFragment));
      if (((AdvertisementInfo)paramArticleInfo).isCommentAd()) {
        i = 38;
      } else {
        i = 3;
      }
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, szd paramszd, int paramInt)
  {
    if ((paramszd != null) && (paramArticleInfo != null) && ((paramArticleInfo instanceof AdvertisementInfo)) && ((paramContext instanceof Activity)))
    {
      paramszd.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = a(paramContext, (AdvertisementInfo)paramArticleInfo, paramszd, paramInt, false, null);
      if (paramszd.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params == null) {
        break label57;
      }
    }
    label57:
    for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
    {
      paramszd.jdField_a_of_type_Long = l;
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("h5url", paramString1);
    localIntent.putExtra("adrl", paramString2);
    localIntent.putExtra("traceId", paramString3);
    localIntent.putExtra("fragmentClass", ReadInJoyAdPopSheetBrowserFragment.class);
    localIntent.setClass(BaseApplicationImpl.getApplication(), QQTranslucentBrowserActivity.class);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(ViewBase paramViewBase, Activity paramActivity, ArticleInfo paramArticleInfo, szd paramszd, int paramInt1, int paramInt2)
  {
    AdvertisementInfo localAdvertisementInfo;
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      localAdvertisementInfo = (AdvertisementInfo)paramArticleInfo;
      a(paramActivity, localAdvertisementInfo, paramszd, paramInt1);
      if ((paramInt2 != 6) || ((paramszd != null) && (paramszd.a() != null) && (paramszd.a().b()))) {
        break label379;
      }
    }
    label310:
    label379:
    for (int i = 5;; i = paramInt2)
    {
      int j = 0;
      if (paramInt2 == 103)
      {
        j = 1;
        i = 101;
      }
      if (paramInt2 == 104)
      {
        i = 102;
        j = 1;
      }
      for (;;)
      {
        uks.a(localAdvertisementInfo, i, null);
        spg localspg = null;
        if (paramszd != null) {
          localspg = paramszd.a();
        }
        if ((uks.g((AdvertisementInfo)paramArticleInfo)) && ((paramInt2 == 4) || (paramInt2 == 3) || (paramInt2 == 1)))
        {
          if (paramInt2 == 1) {
            i = 3;
          }
          uks.a(paramActivity, 1);
          a(paramActivity);
          a(paramActivity, (AdvertisementInfo)paramArticleInfo);
          ois.a(new ufy().a(paramActivity).a(1).b(31).a(JumpMode.PK_MIDDLE).a((AdvertisementInfo)paramArticleInfo).d(i).a());
        }
        boolean bool1;
        do
        {
          do
          {
            return;
          } while ((paramViewBase != null) && (a(paramArticleInfo, paramViewBase, paramActivity, paramInt1, localspg, localAdvertisementInfo)));
          boolean bool2 = true;
          if ((paramInt2 != 6) && (paramInt2 != 5) && ((paramszd == null) || ((paramInt1 != 0) && (!plm.b(paramInt1))) || ((ppe.a(localAdvertisementInfo, paramInt1) != 104) && (ppe.a(localAdvertisementInfo, paramInt1) != 105))))
          {
            bool1 = bool2;
            if (j != 0) {
              break label310;
            }
            if (paramInt2 != 101)
            {
              bool1 = bool2;
              if (paramInt2 != 102) {
                break label310;
              }
            }
          }
          bool1 = false;
          paramViewBase = new ufu();
          if (paramInt2 == 8) {
            paramViewBase.c = true;
          }
        } while (a(paramActivity, paramszd, paramArticleInfo));
        a(paramActivity, localAdvertisementInfo, paramszd, paramInt1, bool1, ukr.b((AdvertisementInfo)paramArticleInfo), paramViewBase);
        ujj.a.b(-1);
        ukq.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId -1 : doAdClickAction");
        return;
      }
    }
  }
  
  public static void a(ViewBase paramViewBase1, ViewBase paramViewBase2, Activity paramActivity, ArticleInfo paramArticleInfo, szd paramszd, int paramInt1, int paramInt2)
  {
    if ((paramViewBase2 == null) || (paramActivity == null) || (paramArticleInfo == null)) {
      return;
    }
    a(paramViewBase1, paramActivity, paramArticleInfo, paramszd, paramInt1, paramInt2);
  }
  
  public static void a(GdtHandler.Params paramParams, boolean paramBoolean, AdvertisementInfo paramAdvertisementInfo, Context paramContext)
  {
    if (a(paramAdvertisementInfo, paramContext))
    {
      paramParams.c = false;
      paramParams.d = false;
      return;
    }
    paramParams.c = true;
    paramParams.d = true;
  }
  
  public static void a(shl paramshl)
  {
    a(3, paramshl.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, paramshl.jdField_a_of_type_Long);
    paramshl.jdField_a_of_type_Long = -2147483648L;
    paramshl.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 5);
  }
  
  public static boolean a(Context paramContext, int paramInt, ArticleInfo paramArticleInfo)
  {
    try
    {
      boolean bool = MiniAppLauncher.startMiniApp(paramContext, ((AdvertisementInfo)paramArticleInfo).mAdLandingPage, paramInt, null);
      if (bool) {
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, szd paramszd, int paramInt, boolean paramBoolean)
  {
    paramszd = a(paramContext, paramAdvertisementInfo, paramszd, paramInt, paramBoolean, false, false, null);
    if (paramszd == null) {
      return false;
    }
    a(paramszd, true, paramAdvertisementInfo, paramContext);
    GdtHandler.a(paramszd);
    QLog.i("ReadinJoyActionUtil", 3, "kandian JumpToTangramSDK");
    return true;
  }
  
  private static boolean a(Context paramContext, szd paramszd, ArticleInfo paramArticleInfo)
  {
    if ((paramszd == null) || (paramszd.a() != 0)) {}
    uha localuha;
    do
    {
      do
      {
        return false;
      } while (!uks.a(paramArticleInfo));
      pqa.b(paramArticleInfo);
      paramArticleInfo.innerUniqueID = a(paramArticleInfo, "landing_page_rowkey");
      localuha = a(paramszd, paramArticleInfo.innerUniqueID);
    } while (localuha == null);
    a(paramContext, paramArticleInfo, paramszd.a(), JumpMode.VIDEO_FLOAT);
    paramszd.a(localuha.a(), paramArticleInfo);
    return true;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null) {
      QLog.e("ReadinJoyActionUtil", 3, "JumpToGdtAdPage error advertisementInfo is null");
    }
    while ((!(paramAdvertisementInfo instanceof AdvertisementInfo)) || (uks.a(paramAdvertisementInfo))) {
      return false;
    }
    if ((paramInt == 2) || (paramInt == 5) || (paramInt == 3) || (paramInt == 56) || (paramInt == 4) || (paramInt == 2000001) || (paramInt == 95555552) || ((uks.a(paramInt)) && (!a(paramAdvertisementInfo.mAdJumpMode)) && (jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramAdvertisementInfo.mAdProductType))))) {
      return true;
    }
    QLog.e("ReadinJoyActionUtil", 3, "readInjoy product not go Gdt QQB channelId:" + paramInt + " AdProductType:" + paramAdvertisementInfo.mAdProductType);
    return false;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, Context paramContext)
  {
    if ((AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (!uks.c(paramAdvertisementInfo))) {}
    while ((paramAdvertisementInfo.mAdProductType == 30) || (paramAdvertisementInfo.mAdProductType == 41) || (((paramAdvertisementInfo.mAdProductType == 1000) || (paramAdvertisementInfo.mAdProductType == 25)) && (!a(paramAdvertisementInfo.mAdCustomizedInvokeUrl, paramContext)))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    return (jdField_a_of_type_Boolean) && ((paramArticleInfo instanceof AdvertisementInfo)) && (((AdvertisementInfo)paramArticleInfo).mAdFeedId != 0L) && (!TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdInteractionReportUrl));
  }
  
  public static boolean a(ArticleInfo paramArticleInfo, ViewBase paramViewBase, Activity paramActivity, int paramInt, spg paramspg, AdvertisementInfo paramAdvertisementInfo)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if ((paramAdvertisementInfo.mImaxShowAdType == 1001) || (paramAdvertisementInfo.mImaxShowAdType == 1002))
    {
      if (((AdvertisementInfo)paramArticleInfo).isHideForAnimate) {
        return true;
      }
      if (paramAdvertisementInfo.mImaxShowAdType == 1001)
      {
        localObject1 = paramViewBase.findViewBaseByName("id_view_Ad_CompleteGudie");
        if ((localObject1 != null) && (((ViewBase)localObject1).getNativeView() != null) && (((ViewBase)localObject1).getNativeView().getVisibility() == 0))
        {
          a(paramActivity, paramAdvertisementInfo.mAdLandingPage, paramAdvertisementInfo);
          a(paramActivity, paramArticleInfo, paramInt, 29, JumpMode.IMAX_MIDDLE);
          return true;
        }
      }
      localObject1 = null;
      if (paramAdvertisementInfo.mImaxShowAdType == 1002)
      {
        localObject3 = paramViewBase.findViewBaseByName("idArticleDoubleImage");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = paramViewBase.findViewBaseByName("id_article_double_image");
        }
        if (localObject2 != null) {
          localObject1 = ((ViewBase)localObject2).getNativeView();
        }
      }
    }
    for (;;)
    {
      ((AdvertisementInfo)paramArticleInfo).isHideForAnimate = true;
      if (paramspg != null)
      {
        paramspg.a(ReportConstants.VideoEndType.AD_AREA_CLICK);
        paramspg.b(0);
      }
      localObject2 = new int[2];
      paramspg = paramViewBase.getNativeView();
      if (localObject1 != null) {
        if ((localObject1 instanceof NativeReadInjoyImageView))
        {
          ReadInjoyIMAXAdFragment.a = ((NativeReadInjoyImageView)localObject1).getDrawable();
          paramspg = (spg)localObject1;
        }
      }
      for (;;)
      {
        paramspg.getLocationOnScreen((int[])localObject2);
        if (((AdvertisementInfo)paramArticleInfo).mImaxShowAdType == 1001)
        {
          localObject1 = paramViewBase.findViewBaseByName("id_video_bg");
          if (localObject1 != null) {
            ((ViewBase)localObject1).getNativeView().setVisibility(4);
          }
          localObject1 = paramViewBase.findViewBaseByName("idViewAdCompleteGudie");
          if (localObject1 != null) {
            ((ViewBase)localObject1).getNativeView().setVisibility(4);
          }
          localObject1 = paramViewBase.findViewBaseByName("idLargeVideoIcon");
          if (localObject1 != null) {
            ((ViewBase)localObject1).getNativeView().setVisibility(4);
          }
          localObject1 = paramViewBase.findViewBaseByName("idLargeVideoDuration");
          if (localObject1 != null) {
            ((ViewBase)localObject1).getNativeView().setVisibility(4);
          }
          if (((AdvertisementInfo)paramArticleInfo).isIMaxAndNewStyle)
          {
            paramViewBase = paramViewBase.findViewBaseByName("idArtilceTitle");
            if (paramViewBase != null) {
              paramViewBase.getNativeView().setVisibility(4);
            }
          }
        }
        int i = localObject2[1];
        int j = localObject2[0];
        int k = paramspg.getWidth();
        int m = paramspg.getHeight();
        paramViewBase = new qbs();
        paramViewBase.jdField_b_of_type_Int = i;
        paramViewBase.jdField_a_of_type_Int = j;
        paramViewBase.c = k;
        paramViewBase.d = m;
        paramViewBase.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
        a(paramActivity);
        ReadInjoyIMAXAdFragment.a(paramActivity, paramViewBase);
        a(paramActivity, paramArticleInfo, paramInt, 29, JumpMode.IMAX_MIDDLE);
        return true;
        localObject1 = paramViewBase.findViewBaseByName("id_article_large_imge");
        if (localObject1 == null) {
          break label546;
        }
        localObject1 = ((ViewBase)localObject1).getNativeView();
        break;
        paramspg = (spg)localObject1;
        if ((localObject1 instanceof FrameLayout))
        {
          paramspg = (spg)localObject1;
          if (((FrameLayout)localObject1).getChildCount() > 0)
          {
            localObject3 = ((FrameLayout)localObject1).getChildAt(0);
            paramspg = (spg)localObject1;
            if ((localObject3 instanceof NativeReadInjoyImageView))
            {
              ReadInjoyIMAXAdFragment.a = ((NativeReadInjoyImageView)localObject3).getDrawable();
              paramspg = (spg)localObject1;
              continue;
              return false;
            }
          }
        }
      }
      label546:
      localObject1 = null;
    }
  }
  
  public static boolean a(ArticleInfo paramArticleInfo, szd paramszd)
  {
    if ((paramszd != null) && (paramszd.a() != null) && (paramszd.a().b()) && (paramszd.a().a() != null))
    {
      paramszd = paramszd.a().a();
      if ((paramszd.b) && (paramszd.a != null) && (AdvertisementInfo.isAdvertisementInfo(paramszd.a)))
      {
        paramszd = (AdvertisementInfo)paramszd.a;
        if ((!TextUtils.isEmpty(paramszd.mAdTraceId)) && ((paramArticleInfo instanceof AdvertisementInfo)) && (paramszd.mAdTraceId.equals(((AdvertisementInfo)paramArticleInfo).mAdTraceId))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return false;
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramString.addFlags(268435456);
        try
        {
          paramContext = paramString.resolveActivityInfo(paramContext.getPackageManager(), 0);
          paramString = "";
          if (paramContext != null) {
            paramString = paramContext.packageName;
          }
          boolean bool = TextUtils.isEmpty(paramString);
          if (!bool) {
            return true;
          }
        }
        catch (Exception paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("ReadinJoyActionUtil", 1, "resolveActivityInfo error!", paramString);
    return false;
  }
  
  public static JumpMode b(Context paramContext, AdvertisementInfo paramAdvertisementInfo, szd paramszd, int paramInt, boolean paramBoolean, ufu paramufu)
  {
    if (uks.l(paramAdvertisementInfo)) {
      return a(paramContext, paramAdvertisementInfo);
    }
    JumpMode localJumpMode = JumpMode.FAIL;
    if (ugj.a(paramAdvertisementInfo)) {
      localJumpMode = TKDAdJumpData.NormalAdJumpData.obtainJumpData(paramAdvertisementInfo).doJumpAction(paramContext);
    }
    if (localJumpMode != JumpMode.FAIL)
    {
      a(paramContext, paramAdvertisementInfo, paramInt, localJumpMode);
      return JumpMode.AMS;
    }
    paramszd = a(paramContext, paramAdvertisementInfo, paramszd, paramInt, paramBoolean, paramufu);
    if (paramszd == null) {
      return JumpMode.FAIL;
    }
    return b(paramszd, paramContext, paramAdvertisementInfo);
  }
  
  public static JumpMode b(GdtHandler.Params paramParams, Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramParams == null) || (paramAdvertisementInfo == null) || (paramContext == null)) {
      return JumpMode.FAIL;
    }
    uks.b(paramAdvertisementInfo);
    if ((paramAdvertisementInfo.mAdJumpMode == 7) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage)))
    {
      a(paramContext);
      if (QLog.isColorLevel()) {
        QLog.i("ReadinJoyActionUtil", 3, "JumpToGdtAdPage tovialo true");
      }
      return pqx.a(paramContext, paramAdvertisementInfo.mAdLandingPage);
    }
    if ((paramAdvertisementInfo.mAdvertisementExtInfo == null) || (paramAdvertisementInfo.mAdvertisementExtInfo.j == 32))
    {
      GdtHandler.a(paramParams);
      if (QLog.isColorLevel()) {
        QLog.i("ReadinJoyActionUtil", 3, "kandian JumpToTangramSDK");
      }
      return JumpMode.AMS;
    }
    return pqx.a(paramContext, paramAdvertisementInfo.mAdLandingPage);
  }
  
  private static void b(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, szd paramszd, int paramInt, boolean paramBoolean)
  {
    if ((paramszd != null) && (paramBoolean)) {
      a(paramActivity, paramAdvertisementInfo, paramInt, JumpMode.AMS);
    }
    Bundle localBundle = new Bundle();
    pib.a(localBundle, paramAdvertisementInfo);
    long l2 = 0L;
    long l1 = l2;
    if (paramszd != null)
    {
      l1 = l2;
      if (paramszd.a() != null)
      {
        l1 = l2;
        if (paramszd.a().a() != null)
        {
          l1 = l2;
          if (paramszd.a().a().c == paramAdvertisementInfo.mArticleID) {
            l1 = paramszd.a();
          }
        }
      }
    }
    localBundle.putLong("param_ad_app_info_video_playposition", l1);
    a(paramActivity);
    NativeAdVideoFragment.a(paramActivity, NativeAdVideoFragment.class, localBundle);
  }
  
  public static JumpMode c(Context paramContext, AdvertisementInfo paramAdvertisementInfo, szd paramszd, int paramInt, boolean paramBoolean, ufu paramufu)
  {
    int i = paramAdvertisementInfo.clickPos;
    paramszd = a(paramContext, paramAdvertisementInfo, paramszd, paramInt, paramBoolean, paramufu);
    if (i >= 0) {
      paramAdvertisementInfo.setClickPos(i);
    }
    a(paramContext, paramAdvertisementInfo, paramInt, paramszd);
    return paramszd;
  }
  
  public static JumpMode d(Context paramContext, AdvertisementInfo paramAdvertisementInfo, szd paramszd, int paramInt, boolean paramBoolean, ufu paramufu)
  {
    paramszd = a(paramContext, paramAdvertisementInfo, paramszd, paramInt, paramBoolean, false, false, paramufu);
    if (paramszd == null) {
      return JumpMode.FAIL;
    }
    a(paramszd, true, paramAdvertisementInfo, paramContext);
    return b(paramszd, paramContext, paramAdvertisementInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvp
 * JD-Core Version:    0.7.0.1
 */