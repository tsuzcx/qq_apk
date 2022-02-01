import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.3;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.4;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdDislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AttachedAdData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class jzk
{
  public static String Vj;
  public static String Vk;
  private static volatile String Vl;
  public static String Vm = "game_gift_report";
  public static int aEJ = 1;
  public static int aEK = 2;
  public static int aEL = 3;
  public static int aEM = 4;
  public static int aEN = 5;
  public static int aEO = 6;
  public static int aEP = 7;
  public static int aEQ = 8;
  public static int aER = 9;
  public static int aES = 15;
  public static int aET = 80;
  public static int aEU = 81;
  public static int aEV = 108;
  public static int aEW = 109;
  public static int aEX = 110;
  public static int aEY = 119;
  public static int aEZ = 16;
  public static int aFA;
  public static int aFB;
  public static int aFC;
  public static int aFD;
  public static int aFE;
  public static int aFF;
  public static int aFG;
  public static int aFH;
  public static int aFI;
  public static int aFJ;
  public static int aFK;
  public static int aFL;
  public static int aFM;
  public static int aFN;
  public static int aFO;
  public static int aFP;
  public static int aFQ;
  public static int aFR;
  public static int aFS;
  public static int aFT;
  public static int aFU;
  public static int aFV;
  public static int aFW;
  public static int aFX;
  public static int aFY;
  public static int aFZ;
  public static int aFa = 17;
  public static int aFb = 18;
  public static int aFc = 19;
  public static int aFd = 20;
  public static int aFe = 21;
  public static int aFf = 23;
  public static int aFg = 116;
  public static int aFh = 117;
  public static int aFi = 118;
  public static int aFj = 24;
  public static int aFk = 25;
  public static int aFl = 26;
  public static int aFm = 27;
  public static int aFn = 28;
  public static int aFo = 27;
  public static int aFp = 1;
  public static int aFq = 2;
  public static int aFr = 3;
  public static int aFs = 4;
  public static int aFt = 5;
  public static int aFu = 42;
  public static int aFv = 1;
  public static int aFw = 3;
  public static int aFx = 4;
  public static int aFy = 5;
  public static int aFz = 7;
  public static int aGA;
  public static int aGB;
  public static int aGC;
  public static int aGa;
  public static int aGb;
  public static int aGc;
  public static int aGd;
  public static int aGe;
  public static int aGf;
  public static int aGg;
  public static int aGh;
  public static int aGi;
  public static int aGj;
  public static int aGk;
  public static int aGl;
  public static int aGm;
  public static int aGn;
  public static int aGo;
  public static int aGp;
  public static int aGq;
  public static int aGr;
  public static int aGs;
  public static int aGt;
  public static int aGu;
  public static int aGv;
  public static int aGw;
  public static int aGx;
  public static int aGy;
  public static int aGz;
  
  static
  {
    aFA = 10;
    aFB = 11;
    aFC = 8;
    aFD = 12;
    aFE = 13;
    aFF = 15;
    aFG = 17;
    aFH = 18;
    aFI = 20;
    aFJ = 21;
    aFK = 22;
    aFL = 23;
    aFM = 24;
    aFN = 25;
    aFO = 26;
    aFP = 27;
    aFQ = 28;
    aFR = 29;
    aFS = 30;
    aFT = 31;
    aFU = 32;
    aFV = 34;
    aFW = 35;
    aFX = 36;
    aFY = 37;
    aFZ = 38;
    aGa = 39;
    aGb = 1;
    aGc = 1;
    aGd = 2;
    aGe = 3;
    aGf = 4;
    aGg = 8;
    aGh = 15;
    aGi = 16;
    aGj = 17;
    aGk = 21;
    aGl = 1000;
    aGm = 1;
    aGn = 2;
    Vj = "ad_complain_tel";
    Vk = "ad_complain_txt";
    aGo = 1;
    aGp = 2;
    aGq = 1;
    aGr = 2;
    aGs = 9;
    aGt = 10;
    aGu = 35;
    aGv = 34;
    aGw = 37;
    aGx = 18;
    aGy = 38;
    aGz = 39;
    aGA = 33;
    aGC = 2;
  }
  
  public static boolean C(Context paramContext, String paramString)
  {
    boolean bool1;
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = aqiz.isAppInstalled(paramContext, paramString);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("NativeAdUtils", 2, "isAppInstall pkg:" + paramString + " " + bool2);
    return bool2;
  }
  
  public static double a(BaseArticleInfo paramBaseArticleInfo, Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {
      return 0.0D;
    }
    SosoInterface.SosoLbsInfo localSosoLbsInfo = aczc.a("readinjoy_feed_ad_distance");
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null))
    {
      paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mAdExtInfo)) {}
    }
    for (;;)
    {
      return 0.0D;
      try
      {
        paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.mAdExtInfo);
        double d1 = paramBaseArticleInfo.getDouble(paramString1);
        double d2 = paramBaseArticleInfo.getDouble(paramString2);
        double d3 = localSosoLbsInfo.a.cd;
        double d4 = localSosoLbsInfo.a.ce;
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "getADPosition cached latitude =  " + d3 + " longitude = " + d4 + " adLatitude = " + d1 + " adLongitude = " + d2);
        }
        if ((d3 <= 0.0D) || (d3 >= 90.0D) || (d4 <= 0.0D) || (d4 >= 180.0D) || (d1 <= 0.0D) || (d1 >= 90.0D) || (d2 <= 0.0D) || (d2 >= 180.0D)) {
          continue;
        }
        return TencentLocationUtils.distanceBetween(d3, d4, d1, d2);
      }
      catch (Exception paramBaseArticleInfo) {}
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition not  cached ......");
      }
      if (yQ())
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "getADPosition Permission PERMISSION_GRANTED");
        }
        bK(paramContext);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("NativeAdUtils", 2, "getADPosition Permission DENY,need to permission ...");
      }
    }
  }
  
  public static double a(double[] paramArrayOfDouble, Context paramContext)
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = aczc.a("readinjoy_feed_ad_distance");
    double d1;
    double d2;
    double d3;
    double d4;
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null))
    {
      d1 = paramArrayOfDouble[0];
      d2 = paramArrayOfDouble[1];
      d3 = localSosoLbsInfo.a.cd;
      d4 = localSosoLbsInfo.a.ce;
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition cached latitude =  " + d3 + " longitude = " + d4 + " adLatitude = " + d1 + " adLongitude = " + d2);
      }
      if ((d3 > 0.0D) && (d3 < 90.0D) && (d4 > 0.0D) && (d4 < 180.0D) && (d1 > 0.0D) && (d1 < 90.0D) && (d2 > 0.0D) && (d2 < 180.0D)) {}
    }
    for (;;)
    {
      return 0.0D;
      return TencentLocationUtils.distanceBetween(d3, d4, d1, d2);
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition not  cached ......");
      }
      if (yQ())
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "getADPosition Permission PERMISSION_GRANTED");
        }
        bK(paramContext);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("NativeAdUtils", 2, "getADPosition Permission DENY,need to permission ...");
      }
    }
  }
  
  public static int a(Context paramContext, jyt paramjyt)
  {
    if ((paramContext == null) || (paramjyt == null)) {}
    do
    {
      DownloadInfo localDownloadInfo;
      do
      {
        do
        {
          return -1;
          paramContext = paramjyt.mPackageName;
          paramjyt = paramjyt.mAppid;
          if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty(paramjyt))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramjyt + " false");
        return -1;
        localDownloadInfo = aryy.a().c(paramjyt);
        if (localDownloadInfo != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramjyt + " false");
      return -1;
      if (localDownloadInfo.getState() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramjyt + " true");
        }
        return localDownloadInfo.progress;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramjyt + " false");
    return -1;
  }
  
  public static int a(AdData paramAdData)
  {
    if (kmx.a(paramAdData)) {
      return aFN;
    }
    return aFv;
  }
  
  public static VideoAdInfo a(AdvertisementInfo paramAdvertisementInfo)
  {
    VideoAdInfo localVideoAdInfo = new VideoAdInfo();
    if (paramAdvertisementInfo != null)
    {
      localVideoAdInfo.rr = paramAdvertisementInfo.mAdFetchTime;
      localVideoAdInfo.aGT = paramAdvertisementInfo.mAdPosLayout;
      localVideoAdInfo.rt = paramAdvertisementInfo.mAdPosID;
      localVideoAdInfo.mChannelID = paramAdvertisementInfo.mChannelID;
      localVideoAdInfo.aGU = paramAdvertisementInfo.mAdKdPos;
      localVideoAdInfo.VZ = paramAdvertisementInfo.mAdCl;
      localVideoAdInfo.mImg = paramAdvertisementInfo.mAdImg;
      localVideoAdInfo.Wa = paramAdvertisementInfo.mAdImgs;
      localVideoAdInfo.Wb = paramAdvertisementInfo.mAdTxt;
      localVideoAdInfo.mDesc = paramAdvertisementInfo.mAdDesc;
      localVideoAdInfo.Wc = paramAdvertisementInfo.mAdRl;
      localVideoAdInfo.Wd = paramAdvertisementInfo.mAdApurl;
      localVideoAdInfo.We = paramAdvertisementInfo.mAdTraceId;
      localVideoAdInfo.Wf = paramAdvertisementInfo.mAdProductId;
      localVideoAdInfo.aGV = paramAdvertisementInfo.mAdProductType;
      localVideoAdInfo.mAdType = paramAdvertisementInfo.mAdType;
      localVideoAdInfo.Wg = paramAdvertisementInfo.mAdLandingPage;
      localVideoAdInfo.Wh = paramAdvertisementInfo.mAdPrice;
      localVideoAdInfo.Wi = paramAdvertisementInfo.mAdBtnTxt;
      localVideoAdInfo.Wj = paramAdvertisementInfo.mAdViewId;
      localVideoAdInfo.Wk = paramAdvertisementInfo.mAdCustomizedInvokeUrl;
      localVideoAdInfo.Wl = paramAdvertisementInfo.mAdCorporationName;
      localVideoAdInfo.Wm = paramAdvertisementInfo.mAdCorporateImageName;
      localVideoAdInfo.Wn = paramAdvertisementInfo.mAdCorporateLogo;
      localVideoAdInfo.mAdUin = paramAdvertisementInfo.mAdUin;
      localVideoAdInfo.Wo = paramAdvertisementInfo.mAdExt;
      localVideoAdInfo.mVideoUrl = paramAdvertisementInfo.mAdVideoUrl;
      localVideoAdInfo.aGW = paramAdvertisementInfo.mAdCostType;
      localVideoAdInfo.ru = paramAdvertisementInfo.mAdAid;
      localVideoAdInfo.mAdLayout = paramAdvertisementInfo.mAdLayout;
      localVideoAdInfo.mAdMaterialId = paramAdvertisementInfo.mAdMaterialId;
      localVideoAdInfo.mVia = paramAdvertisementInfo.mAdVia;
      localVideoAdInfo.mAdExtInfo = paramAdvertisementInfo.mAdExtInfo;
      localVideoAdInfo.mAdJumpMode = paramAdvertisementInfo.mAdJumpMode;
      localVideoAdInfo.mAdAppJson = paramAdvertisementInfo.mAdAppJson;
      localVideoAdInfo.mAdAppDownLoadSchema = paramAdvertisementInfo.mAdAppDownLoadSchema;
      localVideoAdInfo.mAdCanvasJson = paramAdvertisementInfo.mAdCanvasJson;
      localVideoAdInfo.mAdLandingPageReportUrl = paramAdvertisementInfo.mAdLandingPageReportUrl;
      localVideoAdInfo.mAdAdvertiseId = paramAdvertisementInfo.mAdAdvertiseId;
      localVideoAdInfo.mAdDestType = paramAdvertisementInfo.mAdDestType;
      localVideoAdInfo.mAdEffectUrl = paramAdvertisementInfo.mAdEffectUrl;
      localVideoAdInfo.mAdNocoId = paramAdvertisementInfo.mAdNocoId;
      localVideoAdInfo.Wq = paramAdvertisementInfo.mAdDownloadApiUrl;
      localVideoAdInfo.mC2SSwitch = paramAdvertisementInfo.mC2SSwitch;
      localVideoAdInfo.mC2SClickUrl = paramAdvertisementInfo.mC2SClickUrl;
      localVideoAdInfo.mC2SExposureUrl = paramAdvertisementInfo.mC2SExposureUrl;
      localVideoAdInfo.replay = paramAdvertisementInfo.replay;
      paramAdvertisementInfo = paramAdvertisementInfo.mAdDislikeInfos;
      if ((paramAdvertisementInfo != null) && (!paramAdvertisementInfo.isEmpty()))
      {
        localVideoAdInfo.jO = new ArrayList(paramAdvertisementInfo.size());
        int i = 0;
        while (i < paramAdvertisementInfo.size())
        {
          AdDislikeInfo localAdDislikeInfo = (AdDislikeInfo)paramAdvertisementInfo.get(i);
          VideoAdInfo.NegFeedback localNegFeedback = new VideoAdInfo.NegFeedback();
          localNegFeedback.Wy = localAdDislikeInfo.agQ;
          localNegFeedback.rw = localAdDislikeInfo.vf;
          localVideoAdInfo.jO.add(localNegFeedback);
          i += 1;
        }
      }
      localVideoAdInfo.lP(localVideoAdInfo.mAdExtInfo);
    }
    return localVideoAdInfo;
  }
  
  public static AdvertisementInfo a(VideoAdInfo paramVideoAdInfo)
  {
    AdvertisementInfo localAdvertisementInfo = new AdvertisementInfo();
    if (paramVideoAdInfo != null)
    {
      localAdvertisementInfo.mAdTraceId = paramVideoAdInfo.We;
      localAdvertisementInfo.mAdFetchTime = paramVideoAdInfo.rr;
      localAdvertisementInfo.mAdViewId = paramVideoAdInfo.Wj;
      localAdvertisementInfo.mAdPosID = paramVideoAdInfo.rt;
      localAdvertisementInfo.mAdKdPos = paramVideoAdInfo.aGU;
      localAdvertisementInfo.mAdProductId = paramVideoAdInfo.Wf;
      localAdvertisementInfo.mAdProductType = paramVideoAdInfo.aGV;
      localAdvertisementInfo.mAdRl = paramVideoAdInfo.Wc;
      localAdvertisementInfo.mAdAdvertiseId = paramVideoAdInfo.mAdAdvertiseId;
      localAdvertisementInfo.mAdVideoUrl = paramVideoAdInfo.mVideoUrl;
      localAdvertisementInfo.mAdAid = paramVideoAdInfo.ru;
      localAdvertisementInfo.mAdTraceId = paramVideoAdInfo.We;
      localAdvertisementInfo.mAdViewId = paramVideoAdInfo.Wj;
      localAdvertisementInfo.mAdProductId = paramVideoAdInfo.Wf;
      localAdvertisementInfo.mAdVia = paramVideoAdInfo.mVia;
      localAdvertisementInfo.mAdNocoId = paramVideoAdInfo.mAdNocoId;
      localAdvertisementInfo.mAdApurl = paramVideoAdInfo.Wd;
      localAdvertisementInfo.mAdRl = paramVideoAdInfo.Wc;
      localAdvertisementInfo.mAdEffectUrl = paramVideoAdInfo.mAdEffectUrl;
      localAdvertisementInfo.mAdLandingPageReportUrl = paramVideoAdInfo.mAdLandingPageReportUrl;
      localAdvertisementInfo.mAdLandingPage = paramVideoAdInfo.Wg;
      localAdvertisementInfo.mAdCanvasJson = paramVideoAdInfo.mAdCanvasJson;
      localAdvertisementInfo.mAdDestType = paramVideoAdInfo.mAdDestType;
      localAdvertisementInfo.mAdExt = paramVideoAdInfo.Wo;
      localAdvertisementInfo.mAdExtInfo = paramVideoAdInfo.mAdExtInfo;
      localAdvertisementInfo.mAdAppDownLoadSchema = paramVideoAdInfo.mAdAppDownLoadSchema;
      localAdvertisementInfo.mAdCustomizedInvokeUrl = paramVideoAdInfo.Wk;
      localAdvertisementInfo.mAdProductType = paramVideoAdInfo.aGV;
      VideoAdInfo.a(paramVideoAdInfo);
      localAdvertisementInfo.mC2SSwitch = paramVideoAdInfo.mC2SSwitch;
      localAdvertisementInfo.mC2SClickUrl = paramVideoAdInfo.mC2SClickUrl;
      localAdvertisementInfo.mC2SExposureUrl = paramVideoAdInfo.mC2SExposureUrl;
      localAdvertisementInfo.mPopFormH5Url = paramVideoAdInfo.mPopFormH5Url;
      localAdvertisementInfo.mShowAdButton = paramVideoAdInfo.mShowAdButton;
      localAdvertisementInfo.replay = paramVideoAdInfo.replay;
      localAdvertisementInfo.mRevisionVideoType = paramVideoAdInfo.mRevisionVideoType;
      localAdvertisementInfo.isMultiyVideo = paramVideoAdInfo.isMultiyVideo;
      localAdvertisementInfo.processAdExt(paramVideoAdInfo.Wo);
    }
    return localAdvertisementInfo;
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo, Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    double d = a(paramBaseArticleInfo, paramContext, paramString1, paramString2);
    paramBaseArticleInfo = localObject;
    if (d > 0.0D) {
      paramBaseArticleInfo = b(d);
    }
    return paramBaseArticleInfo;
  }
  
  public static JSONObject a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0) && (paramInt1 == paramInt2)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bt", paramInt1);
      localJSONObject.put("et", paramInt2);
      localJSONObject.put("bf", paramInt3);
      localJSONObject.put("ef", paramInt4);
      localJSONObject.put("pp", paramInt8);
      localJSONObject.put("pa", paramInt5);
      localJSONObject.put("pb", paramInt6);
      localJSONObject.put("duration", paramInt7);
      localJSONObject.put("ps", paramInt9);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAdvertisementInfo != null) {}
    for (;;)
    {
      try
      {
        localJSONObject.put("traceid", paramAdvertisementInfo.mAdTraceId);
        localJSONObject.put("pull_time", paramAdvertisementInfo.mAdFetchTime);
        localJSONObject.put("apurl", paramAdvertisementInfo.mAdApurl);
        localJSONObject.put("rl", paramAdvertisementInfo.mAdRl);
        localJSONObject.put("viewid", paramAdvertisementInfo.mAdViewId);
        localJSONObject.put("posid", paramAdvertisementInfo.mAdPosID);
        localJSONObject.put("channel_id", paramAdvertisementInfo.mChannelID);
        localJSONObject.put("kd_pos", paramAdvertisementInfo.mAdKdPos);
        localJSONObject.put("cl", paramAdvertisementInfo.mAdCl);
        localJSONObject.put("pos_layout", paramAdvertisementInfo.mAdPosLayout);
        localJSONObject.put("product_id", paramAdvertisementInfo.mAdProductId);
        localJSONObject.put("product_type", paramAdvertisementInfo.mAdProductType);
        localJSONObject.put("ad_type", paramAdvertisementInfo.mAdType);
        localJSONObject.put("price", paramAdvertisementInfo.mAdPrice);
        localJSONObject.put("customized_invoke_url", paramAdvertisementInfo.mAdCustomizedInvokeUrl);
        localJSONObject.put("corporation_name", paramAdvertisementInfo.mAdCorporationName);
        localJSONObject.put("corporate_image_name", paramAdvertisementInfo.mAdCorporateImageName);
        localJSONObject.put("corporate_logo", paramAdvertisementInfo.mAdCorporateLogo);
        localJSONObject.put("ad_uin", paramAdvertisementInfo.mAdUin);
        localJSONObject.put("ext", paramAdvertisementInfo.mAdExt);
        localJSONObject.put("video_url", paramAdvertisementInfo.mVideoVid);
        localJSONObject.put("cost_type", paramAdvertisementInfo.mAdCostType);
        localJSONObject.put("aid", paramAdvertisementInfo.mAdAid);
        localJSONObject.put("img", paramAdvertisementInfo.mAdImg);
        localJSONObject.put("img_s", paramAdvertisementInfo.mAdImgs);
        localJSONObject.put("txt", paramAdvertisementInfo.mAdTxt);
        localJSONObject.put("desc", paramAdvertisementInfo.mAdDesc);
        localJSONObject.put("ad_layout", paramAdvertisementInfo.mAdLayout);
        localJSONObject.put("ad_material_id", paramAdvertisementInfo.mAdMaterialId);
        localJSONObject.put("algo_id", "" + paramAdvertisementInfo.mAlgorithmID);
        localJSONObject.put("replay", paramAdvertisementInfo.replay);
        a(localJSONObject, paramAdvertisementInfo);
        if (paramAdvertisementInfo.mProgressFromFeeds)
        {
          if (paramAdvertisementInfo.downloadState == 0) {
            localJSONObject.put("download_state", "0");
          }
        }
        else
        {
          if (paramVideoAdInfo != null)
          {
            if (localJSONObject.isNull("apurl")) {
              localJSONObject.put("apurl", paramVideoAdInfo.Wd);
            }
            localJSONObject.put("via", paramVideoAdInfo.mVia);
            localJSONObject.put("dis_channel", paramVideoAdInfo.aGX);
            localJSONObject.put("button_url", paramVideoAdInfo.Wp);
          }
          localJSONObject.put("cookie", cZ());
          if (paramInt <= 0) {
            break;
          }
          localJSONObject.put("click_pos", paramInt);
          return localJSONObject;
        }
        if (paramAdvertisementInfo.downloadState == 3)
        {
          localJSONObject.put("download_state", "1");
          continue;
        }
        if (paramAdvertisementInfo.downloadState != 4) {
          break label572;
        }
      }
      catch (JSONException paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
        return localJSONObject;
      }
      localJSONObject.put("download_state", "2");
      continue;
      label572:
      if ((paramAdvertisementInfo.downloadState == 5) || (paramAdvertisementInfo.downloadState == 1)) {
        localJSONObject.put("download_state", "3");
      }
    }
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.clickPos > 0)) {
      localJSONObject.put("click_pos", paramAdvertisementInfo.clickPos);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(AdData paramAdData)
  {
    return a(paramAdData, null);
  }
  
  public static JSONObject a(AdData paramAdData, HashMap<String, Object> paramHashMap)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramAdData != null)
      {
        if (!TextUtils.isEmpty(paramAdData.abq)) {
          localJSONObject.put("article_id", paramAdData.abq);
        }
        if (!TextUtils.isEmpty(paramAdData.rowkey)) {
          localJSONObject.put("rowkey", paramAdData.rowkey);
        }
        if (!TextUtils.isEmpty(paramAdData.abt)) {
          localJSONObject.put("tags", paramAdData.abt);
        }
        if (kmx.a(paramAdData))
        {
          localJSONObject.put("game_component_type", paramAdData.a.aaa);
          localJSONObject.put("game_pkg", paramAdData.a.packageName);
        }
        if (paramAdData.aB != null) {
          localJSONObject.put("article_ad_ext", paramAdData.aB.toString());
        }
      }
      if ((paramHashMap != null) && (paramHashMap.size() > 0))
      {
        paramAdData = paramHashMap.keySet().iterator();
        while (paramAdData.hasNext())
        {
          String str = (String)paramAdData.next();
          Object localObject = paramHashMap.get(str);
          if (localObject != null) {
            localJSONObject.put(str, localObject);
          }
        }
      }
      return localJSONObject;
    }
    catch (Exception paramAdData)
    {
      paramAdData.printStackTrace();
      return null;
    }
  }
  
  private static JSONObject a(QQAppInterface paramQQAppInterface, AdData paramAdData, int paramInt1, int paramInt2, JSONObject paramJSONObject)
  {
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramQQAppInterface.getAccount());
      localJSONObject.put("ts", NetConnInfoCenter.getServerTimeMillis());
      localJSONObject.put("dinfo", b(paramQQAppInterface.getApplication().getApplicationContext()));
      localJSONObject.put("ver", "3.4.4");
      localJSONObject.put("type", paramInt1);
      localJSONObject.put("stype", paramInt2);
      localJSONObject.put("isdpg", 1);
      if (paramAdData != null)
      {
        if (paramInt1 != 1) {
          break label184;
        }
        paramQQAppInterface = paramAdData.alE;
        localJSONObject.put("ext", paramQQAppInterface);
        localJSONObject.put("oudid", paramAdData.alH);
        if (!(paramAdData instanceof AttachedAdData)) {
          break label192;
        }
        localJSONObject.put("aname", paramAdData.title);
        localJSONObject.put("posid", paramAdData.aZS);
      }
      for (;;)
      {
        if (paramJSONObject == null) {
          break label226;
        }
        localJSONObject.put("exposureExtraInfo", paramJSONObject);
        return localJSONObject;
        label184:
        paramQQAppInterface = paramAdData.alF;
        break;
        label192:
        localJSONObject.put("aname", paramAdData.appName);
        localJSONObject.put("posid", paramAdData.alD);
      }
      return localJSONObject;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static JSONObject a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, HashMap<String, Object> paramHashMap)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("article_id", paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("rowkey", paramString2);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localJSONObject.put("tags", paramString3);
      }
      if ((!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString5)))
      {
        localJSONObject.put("game_component_type", paramString4);
        localJSONObject.put("game_pkg", paramString5);
      }
      if ((paramHashMap != null) && (paramHashMap.size() > 0))
      {
        paramString1 = paramHashMap.keySet().iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (String)paramString1.next();
          paramString3 = paramHashMap.get(paramString2);
          if (paramString3 != null) {
            localJSONObject.put(paramString2, paramString3);
          }
        }
      }
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
  }
  
  public static JSONObject a(HashMap<String, Object> paramHashMap)
  {
    return a(null, paramHashMap);
  }
  
  private static void a(int paramInt, AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo)
  {
    if (paramInt == aEK)
    {
      if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mC2SSwitch != 1)) {
        break label271;
      }
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, " C2S AD_EXPOSURE: advertisementInfo = " + paramAdvertisementInfo.toString() + " clickurl = " + paramAdvertisementInfo.mC2SClickUrl + " exposureUrl = " + paramAdvertisementInfo.mC2SExposureUrl);
      }
      tlb.a(0, 1, ods.a(paramAdvertisementInfo));
    }
    label270:
    label271:
    label379:
    do
    {
      do
      {
        break label270;
        break label270;
        if (paramInt == aEJ)
        {
          if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mC2SSwitch != 1)) {
            break label379;
          }
          if (QLog.isColorLevel()) {
            QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo = " + paramAdvertisementInfo.toString() + " clickurl = " + paramAdvertisementInfo.mC2SClickUrl + " exposureUrl = " + paramAdvertisementInfo.mC2SExposureUrl);
          }
          tlb.a(1, 1, ods.a(paramAdvertisementInfo));
        }
        for (;;)
        {
          if (paramInt == aFo)
          {
            if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mC2SSwitch != 1)) {
              break label495;
            }
            if (QLog.isColorLevel()) {
              QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo = " + paramAdvertisementInfo.toString() + " clickurl = " + paramAdvertisementInfo.mC2SVideoPlayUrl + " videoClickUrl = " + paramAdvertisementInfo.mC2SVideoPlayUrl);
            }
            tlb.a(2, 1, ods.a(paramAdvertisementInfo));
          }
          return;
          if ((paramVideoAdInfo == null) || (paramVideoAdInfo.mC2SSwitch != 1)) {
            break;
          }
          AdvertisementInfo localAdvertisementInfo = a(paramVideoAdInfo);
          if (localAdvertisementInfo == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("NativeAdUtils", 2, " C2S AD_EXPOSURE: advertisementInfo1 = " + localAdvertisementInfo.toString() + " videoAdInfo = " + paramVideoAdInfo.toString() + " clickurl = " + localAdvertisementInfo.mC2SClickUrl + " exposureUrl = " + localAdvertisementInfo.mC2SExposureUrl);
          }
          tlb.a(0, 1, ods.a(localAdvertisementInfo));
          break;
          if ((paramVideoAdInfo != null) && (paramVideoAdInfo.mC2SSwitch == 1))
          {
            localAdvertisementInfo = a(paramVideoAdInfo);
            if ((localAdvertisementInfo != null) && (localAdvertisementInfo.mC2SSwitch == 1))
            {
              if (QLog.isColorLevel()) {
                QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo1 = " + localAdvertisementInfo.toString() + " videoAdInfo = " + paramVideoAdInfo.toString() + " clickurl = " + localAdvertisementInfo.mC2SClickUrl + " exposureUrl = " + localAdvertisementInfo.mC2SExposureUrl);
              }
              tlb.a(1, 1, ods.a(localAdvertisementInfo));
            }
          }
        }
      } while ((paramVideoAdInfo == null) || (paramVideoAdInfo.mC2SSwitch != 1));
      paramAdvertisementInfo = a(paramVideoAdInfo);
    } while ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mC2SSwitch != 1));
    label495:
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo1 = " + paramAdvertisementInfo.toString() + " videoAdInfo = " + paramVideoAdInfo.toString() + " clickurl = " + paramAdvertisementInfo.mC2SVideoPlayUrl + " videoClickUrl = " + paramAdvertisementInfo.mC2SVideoPlayUrl);
    }
    tlb.a(2, 1, ods.a(paramAdvertisementInfo));
  }
  
  public static void a(Activity paramActivity, jyt paramjyt, aryx paramaryx)
  {
    if ((paramActivity == null) || (paramjyt == null)) {}
    String str1;
    String str2;
    String str3;
    do
    {
      return;
      str1 = paramjyt.mPackageName;
      str2 = paramjyt.mAppid;
      str3 = paramjyt.Vi;
      paramjyt = paramjyt.mAppName;
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(paramjyt)));
    Bundle localBundle = new Bundle();
    localBundle.putString(aryv.PARAM_TASK_PACKNAME, str1);
    localBundle.putString(aryv.PARAM_SNG_APPID, str2);
    localBundle.putString(aryv.PARAM_URL, str3);
    localBundle.putString(aryv.PARAM_APPNAME, paramjyt);
    localBundle.putInt(aryv.PARAM_ACTIONCODE, 2);
    localBundle.putInt(aryv.PARAM_WOWNLOAD_TYPE, 0);
    localBundle.putBoolean(aryv.PARAM_BLOCK_NOTIFY, false);
    localBundle.putInt(aryv.PARAM_SHOW_NOTIFICATION, 0);
    localBundle.putBoolean(aryv.PARAM_IS_APK, true);
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "downloadApk pkg:" + str1 + ", appid:" + str2 + ", name:" + paramjyt + ", url:" + str3);
    }
    if (paramaryx != null) {
      aryy.a().a(paramaryx);
    }
    aryr.d(paramActivity, localBundle, "biz_src_yyb", null, 0);
  }
  
  public static void a(Context paramContext, jyq paramjyq)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("page_id", paramjyq.pageId);
      localJSONObject.put("oper_module", paramjyq.rc);
      localJSONObject.put("oper_id", paramjyq.rd);
      localJSONObject.put("obj_id", paramjyq.Va);
      localJSONObject.put("obj_type", paramjyq.Vb);
      localJSONObject.put("game_pkg", paramjyq.Vc);
      localJSONObject.put("app_id", paramjyq.appId);
      localJSONObject.put("ex1", paramjyq.ex1);
      localJSONObject.put("ex2", paramjyq.ex2);
      localJSONObject.put("ex3", paramjyq.Vd);
      localJSONObject.put("loc_id", paramjyq.Ve);
      paramjyq = new JSONObject();
      paramjyq.put(Vm, String.valueOf(localJSONObject));
      a(new kku.a().a(paramContext).a(aEY).b(aGa).e(paramjyq).a());
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, AdvertisementInfo paramAdvertisementInfo, float paramFloat, long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("exposureArea", paramFloat);
      localJSONObject.put("exposureTime", paramLong);
      HashMap localHashMap = new HashMap();
      localHashMap.put("article_id", String.valueOf(paramAdvertisementInfo.mArticleID));
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mRowKey)) {
        localHashMap.put("rowkey", paramAdvertisementInfo.mRowKey);
      }
      a(new kku.a().a(paramQQAppInterface).a(BaseApplication.getContext()).a(aEK).b(paramInt).a(paramAdvertisementInfo).c(localJSONObject).d(a(localHashMap)).a());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    if (knc.i(paramAdData))
    {
      a(new kku.a().a(paramQQAppInterface).a(BaseApplication.getContext()).a(aEK).b(a(paramAdData)).a(kne.a(paramAdData)).d(a(paramAdData)).a());
      return;
    }
    d(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 5, 1, null).toString());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, float paramFloat, long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("exposureArea", paramFloat);
      localJSONObject.put("exposureTime", paramLong);
      if (knc.i(paramAdData))
      {
        a(new kku.a().a(paramQQAppInterface).a(BaseApplication.getContext()).a(aEK).b(a(paramAdData)).a(kne.a(paramAdData)).c(localJSONObject).d(a(paramAdData)).a());
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
      d(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 5, 1, localJSONObject).toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, int paramInt)
  {
    if (knc.a(paramAdData, false))
    {
      a(new kku.a().a(paramQQAppInterface).a(BaseApplication.getContext()).a(aEJ).b(aFv).a(kne.a(paramAdData)).d(a(paramAdData)).d(paramInt).a());
      return;
    }
    d(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 1, 3, null).toString());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    anot.a(paramQQAppInterface, "dc04719", "ad", "0", paramString1.toUpperCase(), paramString2.toUpperCase(), paramInt1, paramInt2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", paramQQAppInterface.getCurrentUin());
      localJSONObject.put("adId", paramString1);
      localJSONObject.put("channelId", paramString2);
      localJSONObject.put("info", paramString3);
      localJSONObject.put("version", "3.4.4");
      localJSONObject.put("actionCode", paramInt1);
      localJSONObject.put("subType", paramInt2);
      if (paramInt1 == 4) {
        localJSONObject.put("extValue", paramInt3);
      }
      paramString2 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "doAdReport json:" + paramString2);
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = new WebSsoBody.WebSsoRequestBody();
        paramString1.data.set(paramString2);
        paramString2 = new NewIntent(paramQQAppInterface.getApplication(), kbs.class);
        paramString2.putExtra("cmd", "KdAdReportSsoSvr.kandian_ad");
        paramString2.putExtra("data", paramString1.toByteArray());
        paramString2.setObserver(new jzl());
        paramQQAppInterface.startServlet(paramString2);
      }
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  public static void a(kku paramkku)
  {
    if (paramkku == null) {}
    Context localContext;
    int i;
    int j;
    AdvertisementInfo localAdvertisementInfo;
    VideoAdInfo localVideoAdInfo;
    long l;
    String str;
    JSONObject localJSONObject1;
    int k;
    JSONObject localJSONObject2;
    Bundle localBundle;
    JSONObject localJSONObject3;
    JSONObject localJSONObject4;
    JSONObject localJSONObject5;
    JSONObject localJSONObject6;
    int m;
    boolean bool;
    do
    {
      return;
      AppInterface localAppInterface = paramkku.a();
      localContext = paramkku.getContext();
      i = paramkku.getType();
      j = paramkku.getOrigin();
      localAdvertisementInfo = paramkku.a();
      localVideoAdInfo = paramkku.a();
      l = paramkku.ce();
      str = paramkku.ip();
      localJSONObject1 = paramkku.n();
      k = paramkku.getClickPos();
      localJSONObject2 = paramkku.o();
      localBundle = paramkku.e();
      localJSONObject3 = paramkku.p();
      localJSONObject4 = paramkku.q();
      localJSONObject5 = paramkku.s();
      localJSONObject6 = paramkku.r();
      m = paramkku.no();
      bool = paramkku.zC();
      paramkku = localAppInterface;
      if (localAppInterface == null)
      {
        paramkku = localAppInterface;
        if (BaseApplicationImpl.sProcessId == 1)
        {
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
          paramkku = localAppInterface;
          if (localAppRuntime != null)
          {
            paramkku = localAppInterface;
            if ((localAppRuntime instanceof QQAppInterface)) {
              paramkku = (QQAppInterface)localAppRuntime;
            }
          }
        }
      }
    } while (paramkku == null);
    ThreadManager.post(new NativeAdUtils.3(localJSONObject3, paramkku.getAccount(), i, j, m, localContext, localAdvertisementInfo, localVideoAdInfo, k, localJSONObject1, localJSONObject2, localBundle, str, l, localJSONObject4, localJSONObject6, localJSONObject5, paramkku, bool), 5, null, true);
  }
  
  private static void a(JSONObject paramJSONObject, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramJSONObject != null) && (paramAdvertisementInfo != null) && (paramAdvertisementInfo.gameAdComData != null)) {}
    while ((paramJSONObject == null) || (paramAdvertisementInfo == null) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdExtInfo))) {
      try
      {
        paramJSONObject.put("pkg_name", paramAdvertisementInfo.gameAdComData.WX);
        paramJSONObject.put("game_adtag", new JSONObject(paramAdvertisementInfo.gameAdComData.Xt).optString("ADTAG"));
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
    }
    try
    {
      paramJSONObject.put("extra_data", paramAdvertisementInfo.mAdExtInfo);
      paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
      paramJSONObject.put("game_adtag", paramAdvertisementInfo.optString("game_adtag"));
      paramJSONObject.put("pkg_name", paramAdvertisementInfo.optString("game_pkg_name"));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private static boolean a(int paramInt1, int paramInt2, AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo)
  {
    return (paramInt2 == aFP) || (paramInt1 == aFl);
  }
  
  public static boolean a(Context paramContext, jyt paramjyt)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramContext != null)
    {
      if (paramjyt != null) {
        break label22;
      }
      bool2 = bool1;
    }
    label22:
    String str1;
    String str2;
    DownloadInfo localDownloadInfo;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool2;
            str1 = paramjyt.mPackageName;
            str2 = paramjyt.mAppid;
            bool2 = bool1;
          } while (TextUtils.isEmpty(str1));
          bool2 = bool1;
        } while (TextUtils.isEmpty(str2));
        localDownloadInfo = aryy.a().c(str2);
        bool2 = bool1;
      } while (localDownloadInfo == null);
      paramjyt = "";
      if (TextUtils.isEmpty(localDownloadInfo.filePath)) {
        break;
      }
      paramjyt = localDownloadInfo.filePath;
      bool1 = bool3;
      if (!TextUtils.isEmpty(paramjyt))
      {
        bool1 = bool3;
        if (new File(paramjyt).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("NativeAdUtils", 2, "isPkgExist(" + bool1 + ") pkg:" + str1 + ", appid:" + str2 + ", path:" + paramjyt);
    return bool1;
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
    if (localDownloadInfo.downloadType == 0)
    {
      localTMAssistantDownloadTaskInfo2 = aryy.a().b(localDownloadInfo.urlStr);
      paramContext = paramjyt;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = paramjyt;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      paramjyt = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = aryy.a().a(localDownloadInfo);
        paramjyt = paramContext;
      }
    }
    for (;;)
    {
      paramContext = paramjyt;
      if (localTMAssistantDownloadTaskInfo1 != null)
      {
        paramContext = paramjyt;
        if (localTMAssistantDownloadTaskInfo1.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo1.mSavePath;
        }
      }
      paramjyt = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        break;
      }
      localDownloadInfo.filePath = paramContext;
      localDownloadInfo.setState(4);
      aryy.a().j(localDownloadInfo);
      paramjyt = paramContext;
      break;
      localTMAssistantDownloadTaskInfo2 = aryy.a().a(localDownloadInfo);
      paramContext = paramjyt;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = paramjyt;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      paramjyt = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = aryy.a().b(localDownloadInfo.urlStr);
        paramjyt = paramContext;
      }
    }
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!(paramBaseArticleInfo instanceof AdvertisementInfo)) {}
    for (;;)
    {
      return false;
      paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
      if (paramBaseArticleInfo.mLocalInfo != null) {
        try
        {
          String str1 = paramBaseArticleInfo.mLocalInfo.ahh;
          double d = Double.parseDouble(paramBaseArticleInfo.mLocalInfo.ahi);
          if ((Double.parseDouble(str1) != 0.0D) || (d != 0.0D))
          {
            str1 = paramBaseArticleInfo.mLocalInfo.store_address;
            String str2 = paramBaseArticleInfo.mLocalInfo.distance_description;
            paramBaseArticleInfo = paramBaseArticleInfo.mLocalInfo.store_url;
            if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
            {
              boolean bool = TextUtils.isEmpty(paramBaseArticleInfo);
              if (!bool)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("NativeAdUtils", 2, "hasAddLocationInfo is -> true");
                }
                return true;
              }
            }
          }
        }
        catch (Exception paramBaseArticleInfo) {}
      }
    }
    return false;
  }
  
  public static boolean a(jyt paramjyt)
  {
    String str1 = paramjyt.mPackageName;
    String str2 = paramjyt.mAppid;
    String str3 = paramjyt.Vi;
    paramjyt = paramjyt.mAppName;
    Bundle localBundle = new Bundle();
    localBundle.putInt(aryv.PARAM_ACTIONCODE, 5);
    localBundle.putString(aryv.PARAM_TASK_PACKNAME, str1);
    localBundle.putString(aryv.PARAM_SNG_APPID, str2);
    localBundle.putString(aryv.PARAM_URL, str3);
    localBundle.putString(aryv.PARAM_APPNAME, paramjyt);
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "installApk pkg:" + str1 + ", appid:" + str2 + ", name:" + paramjyt + ", url:" + str3);
    }
    return aryr.G(localBundle);
  }
  
  public static double[] a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!(paramBaseArticleInfo instanceof AdvertisementInfo)) {}
    for (;;)
    {
      return null;
      paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
      if (paramBaseArticleInfo.mLocalInfo != null) {
        try
        {
          String str = paramBaseArticleInfo.mLocalInfo.ahh;
          double d1 = jzp.a(paramBaseArticleInfo.mLocalInfo.ahi, 0.0D);
          double d2 = jzp.a(str, 0.0D);
          if ((d2 != 0.0D) || (d1 != 0.0D)) {
            return new double[] { d1, d2 };
          }
        }
        catch (Exception paramBaseArticleInfo) {}
      }
    }
    return null;
  }
  
  public static String b(double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return "";
    }
    paramDouble = Math.ceil(paramDouble);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramDouble < 1000.0D) {
      localStringBuilder.append((int)paramDouble).append('m');
    }
    for (;;)
    {
      return localStringBuilder.toString();
      long l = Math.round(paramDouble / 1000.0D);
      if (l < 1000L) {
        localStringBuilder.append(l).append("km");
      } else {
        localStringBuilder.append("999km");
      }
    }
  }
  
  private static JSONObject b(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("dma", kms.iu());
        localJSONObject.put("hwm", aqgz.getModel());
        localJSONObject.put("hwma", aqgz.BY());
        localJSONObject.put("osver", aqgz.getDeviceOSVersion());
        localJSONObject.put("imei", kms.getIMEI());
        localJSONObject.put("brd", aqgz.getManufacturer());
        localJSONObject.put("ns", jqc.hS());
        localJSONObject.put("andid", alla.getString(paramContext.getContentResolver(), "android_id"));
        localJSONObject.put("mid", "mid");
        localJSONObject.put("pf", "android");
        localJSONObject.put("wn", rpc.al(paramContext));
        switch (abxt.Aa())
        {
        case 1: 
        case 2: 
          localJSONObject.put("mnc", "");
          localJSONObject.put("rma", kxm.getWifiMacAddress(paramContext));
          return localJSONObject;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return localJSONObject;
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    if (knc.i(paramAdData))
    {
      a(new kku.a().a(paramQQAppInterface).a(BaseApplication.getContext()).a(aEU).b(a(paramAdData)).a(kne.a(paramAdData)).d(a(paramAdData)).a());
      return;
    }
    d(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 81, 1, null).toString());
  }
  
  private static void bK(Context paramContext)
  {
    if (aGB >= 3) {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition doStartADLocation retryLocationCount >= 3");
      }
    }
    while ((paramContext == null) || (!aqiw.isNetworkAvailable(paramContext))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "getADPosition doStartADLocation network is Available...");
    }
    aczc.a(new jzo("readinjoy_feed_ad_distance"));
    aGB += 1;
  }
  
  /* Error */
  public static JSONObject c(Context paramContext)
  {
    // Byte code:
    //   0: new 385	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 804	org/json/JSONObject:<init>	()V
    //   7: astore 6
    //   9: invokestatic 1673	kms:getIMEI	()Ljava/lang/String;
    //   12: astore 5
    //   14: invokestatic 1651	kms:iu	()Ljava/lang/String;
    //   17: astore 4
    //   19: aload 5
    //   21: invokestatic 325	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +328 -> 352
    //   27: aload 5
    //   29: invokevirtual 1754	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   32: astore_3
    //   33: aload 6
    //   35: ldc_w 1756
    //   38: aload_3
    //   39: invokestatic 1761	arwv:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   42: invokevirtual 1754	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   45: invokevirtual 835	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   48: pop
    //   49: aload 6
    //   51: ldc_w 1763
    //   54: iconst_1
    //   55: invokevirtual 810	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   58: pop
    //   59: aload 4
    //   61: astore 5
    //   63: aload_3
    //   64: astore 4
    //   66: aload 5
    //   68: astore_3
    //   69: new 1765	tlm$a
    //   72: dup
    //   73: invokespecial 1766	tlm$a:<init>	()V
    //   76: astore 5
    //   78: aload 5
    //   80: ldc_w 1768
    //   83: putfield 1771	tlm$a:aJy	Ljava/lang/String;
    //   86: invokestatic 1312	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   89: aload 5
    //   91: invokestatic 1776	tlm:a	(Landroid/content/Context;Ltlm$a;)Ltlm$b;
    //   94: astore 5
    //   96: aload 5
    //   98: ifnull +51 -> 149
    //   101: aload 5
    //   103: getfield 1781	tlm$b:b	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   106: ifnull +43 -> 149
    //   109: aload 6
    //   111: ldc_w 1756
    //   114: aload 5
    //   116: getfield 1781	tlm$b:b	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   119: getfield 1785	tencent/gdt/qq_ad_get$QQAdGet$DeviceInfo:muid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   122: invokevirtual 1787	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   125: invokevirtual 835	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   128: pop
    //   129: aload 6
    //   131: ldc_w 1763
    //   134: aload 5
    //   136: getfield 1781	tlm$b:b	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   139: getfield 1790	tencent/gdt/qq_ad_get$QQAdGet$DeviceInfo:muid_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   142: invokevirtual 1794	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   145: invokevirtual 810	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   148: pop
    //   149: aload 6
    //   151: ldc_w 1796
    //   154: invokestatic 1801	jxp:na	()I
    //   157: invokevirtual 810	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   160: pop
    //   161: aload 6
    //   163: ldc_w 1709
    //   166: aload_0
    //   167: invokestatic 1715	rpc:al	(Landroid/content/Context;)Ljava/lang/String;
    //   170: invokevirtual 835	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   173: pop
    //   174: iconst_0
    //   175: istore_1
    //   176: invokestatic 1804	aqgz:LU	()I
    //   179: istore_2
    //   180: iload_2
    //   181: istore_1
    //   182: aload 6
    //   184: ldc_w 1806
    //   187: iload_1
    //   188: invokevirtual 810	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   191: pop
    //   192: aload 6
    //   194: ldc_w 1808
    //   197: invokestatic 1668	aqgz:getDeviceOSVersion	()Ljava/lang/String;
    //   200: invokevirtual 835	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   203: pop
    //   204: aload 6
    //   206: ldc_w 1810
    //   209: invokestatic 1813	aqgz:getQQVersion	()Ljava/lang/String;
    //   212: invokevirtual 835	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   215: pop
    //   216: aload 6
    //   218: ldc_w 1815
    //   221: invokestatic 1820	com/tencent/common/config/AppSetting:getAppId	()I
    //   224: invokestatic 1823	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   227: invokevirtual 835	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   230: pop
    //   231: aload 6
    //   233: ldc_w 1825
    //   236: invokestatic 1829	cz:s	()J
    //   239: invokestatic 1832	cz:f	(J)Ljava/lang/String;
    //   242: invokevirtual 835	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   245: pop
    //   246: aload 6
    //   248: ldc_w 1724
    //   251: aload_0
    //   252: invokestatic 1729	kxm:getWifiMacAddress	(Landroid/content/Context;)Ljava/lang/String;
    //   255: invokevirtual 835	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   258: pop
    //   259: aload 6
    //   261: ldc_w 1646
    //   264: aload_3
    //   265: invokevirtual 835	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload 6
    //   271: ldc_w 1834
    //   274: iconst_2
    //   275: invokevirtual 810	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   278: pop
    //   279: aload 6
    //   281: ldc_w 1675
    //   284: invokestatic 1678	aqgz:getManufacturer	()Ljava/lang/String;
    //   287: invokevirtual 835	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   290: pop
    //   291: aload 6
    //   293: ldc_w 1653
    //   296: invokestatic 1658	aqgz:getModel	()Ljava/lang/String;
    //   299: invokevirtual 835	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   302: pop
    //   303: aload 6
    //   305: ldc_w 1660
    //   308: invokestatic 1663	aqgz:BY	()Ljava/lang/String;
    //   311: invokevirtual 835	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   314: pop
    //   315: aload 6
    //   317: ldc_w 1670
    //   320: aload 4
    //   322: invokevirtual 835	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   325: pop
    //   326: aload_0
    //   327: ifnull +22 -> 349
    //   330: aload 6
    //   332: ldc_w 1687
    //   335: aload_0
    //   336: invokevirtual 1693	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   339: ldc_w 1695
    //   342: invokestatic 1701	alla:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   345: invokevirtual 835	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   348: pop
    //   349: aload 6
    //   351: areturn
    //   352: aload 4
    //   354: astore_3
    //   355: aload 4
    //   357: invokestatic 325	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   360: ifne +98 -> 458
    //   363: aload 4
    //   365: ldc_w 1836
    //   368: ldc_w 901
    //   371: invokevirtual 1840	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   374: invokevirtual 1356	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   377: astore_3
    //   378: aload 6
    //   380: ldc_w 1756
    //   383: aload_3
    //   384: invokestatic 1761	arwv:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   387: invokevirtual 1754	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   390: invokevirtual 835	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   393: pop
    //   394: aload 6
    //   396: ldc_w 1763
    //   399: iconst_3
    //   400: invokevirtual 810	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   403: pop
    //   404: goto +54 -> 458
    //   407: astore_0
    //   408: ldc_w 338
    //   411: iconst_1
    //   412: new 340	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 1842
    //   422: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload_0
    //   426: invokevirtual 1843	java/lang/Exception:toString	()Ljava/lang/String;
    //   429: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 362	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: aload 6
    //   440: areturn
    //   441: astore_0
    //   442: aload_0
    //   443: invokevirtual 1023	java/lang/Exception:printStackTrace	()V
    //   446: aconst_null
    //   447: areturn
    //   448: astore 5
    //   450: goto -268 -> 182
    //   453: astore 5
    //   455: goto -209 -> 246
    //   458: aload 5
    //   460: astore 4
    //   462: goto -393 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	paramContext	Context
    //   175	13	1	i	int
    //   179	2	2	j	int
    //   32	352	3	localObject1	Object
    //   17	444	4	localObject2	Object
    //   12	123	5	localObject3	Object
    //   448	1	5	localException1	Exception
    //   453	6	5	localException2	Exception
    //   7	432	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   330	349	407	java/lang/Exception
    //   9	59	441	java/lang/Exception
    //   69	96	441	java/lang/Exception
    //   101	149	441	java/lang/Exception
    //   149	174	441	java/lang/Exception
    //   182	231	441	java/lang/Exception
    //   246	326	441	java/lang/Exception
    //   355	404	441	java/lang/Exception
    //   408	438	441	java/lang/Exception
    //   176	180	448	java/lang/Exception
    //   231	246	453	java/lang/Exception
  }
  
  public static void c(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    a(paramQQAppInterface, paramAdData, 0);
  }
  
  public static String cZ()
  {
    for (;;)
    {
      try
      {
        if (Vl == null)
        {
          localObject1 = BaseApplicationImpl.getApplication().peekAppRuntime();
          if (localObject1 == null) {
            Vl = "";
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("NativeAdUtils", 2, "getAdCookie cookie=" + Vl);
          }
          localObject1 = Vl;
          return localObject1;
        }
        Object localObject1 = awit.a((AppRuntime)localObject1, true, false);
        if (localObject1 != null) {
          Vl = ((SharedPreferences)localObject1).getString("sp_key_ad_cookie", "");
        } else {
          Vl = "";
        }
      }
      finally {}
    }
  }
  
  private static void d(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "nativeEngineAdReport json:" + paramString);
      }
      if (!TextUtils.isEmpty(paramString))
      {
        WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
        localWebSsoRequestBody.data.set(paramString);
        paramString = new NewIntent(paramQQAppInterface.getApplication(), kbs.class);
        paramString.putExtra("cmd", "KdAdReportSsoSvr.kandian_ad_report");
        paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
        paramString.setObserver(new jzm());
        paramQQAppInterface.startServlet(paramString);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static String eb(String paramString)
  {
    return arwu.toMD5(paramString);
  }
  
  public static void lA(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      Vl = str;
      ThreadManager.executeOnFileThread(new NativeAdUtils.4(str));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void launchApp(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "launchApp pkg:" + paramString);
      }
      paramString = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
    } while (paramString == null);
    paramContext.startActivity(paramString);
  }
  
  private static boolean yQ()
  {
    boolean bool2 = true;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    boolean bool1;
    if (localBaseActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition activity null");
      }
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (Build.VERSION.SDK_INT < 23);
      bool1 = bool2;
    } while (localBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jzk
 * JD-Core Version:    0.7.0.1
 */