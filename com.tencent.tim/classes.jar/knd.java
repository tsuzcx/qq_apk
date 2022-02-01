import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.utils.ReadInJoyAdUtils.1;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdGestureView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class knd
{
  private static HashSet<Integer> M = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(56), Integer.valueOf(40531), Integer.valueOf(14), Integer.valueOf(40174), Integer.valueOf(8), Integer.valueOf(1), Integer.valueOf(13), Integer.valueOf(15), Integer.valueOf(5), Integer.valueOf(11), Integer.valueOf(40466), Integer.valueOf(41541), Integer.valueOf(40013), Integer.valueOf(58), Integer.valueOf(16), Integer.valueOf(53), Integer.valueOf(52), Integer.valueOf(41629), Integer.valueOf(55), Integer.valueOf(40007), Integer.valueOf(59), Integer.valueOf(10), Integer.valueOf(9), Integer.valueOf(54), Integer.valueOf(41504) }));
  
  public static boolean D(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      paramString = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
    } while (paramString == null);
    try
    {
      paramString.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
      paramContext.startActivity(paramString);
      return true;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static long a(mtg.b paramb, boolean paramBoolean)
  {
    if (!a(paramb)) {}
    for (;;)
    {
      return -1L;
      if ((paramb != null) && (paramb.a != null) && (paramb.a.d != null) && (paramb.a.d.b != null))
      {
        paramb = paramb.a.d.b;
        try
        {
          paramb = new JSONObject(paramb.mAdExtInfo);
          if (paramb != null)
          {
            paramb = paramb.optJSONObject("GesturesAd_info");
            if (paramb != null)
            {
              if (paramBoolean) {
                return paramb.optInt("showGesturesAd_beginTime");
              }
              int i = paramb.optInt("showGesturesAd_endTime");
              return i;
            }
          }
        }
        catch (Exception paramb)
        {
          paramb.printStackTrace();
        }
      }
    }
    return -1L;
  }
  
  public static ShapeDrawable a(int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    float f9 = wja.dp2px(1.0F, paramContext.getResources());
    float f1 = 6;
    float f2 = 6;
    float f3 = 6;
    float f4 = 6;
    float f5 = 6;
    float f6 = 6;
    float f7 = 6;
    float f8 = 6;
    paramContext = new RectF(f9, f9, f9, f9);
    f9 = 5;
    float f10 = 5;
    float f11 = 5;
    float f12 = 5;
    float f13 = 5;
    float f14 = 5;
    float f15 = 5;
    float f16 = 5;
    paramContext = new ShapeDrawable(new RoundRectShape(new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, paramContext, new float[] { f9, f10, f11, f12, f13, f14, f15, f16 }));
    LinearGradient localLinearGradient = new LinearGradient(50.0F, 50.0F, 50.0F, 50.0F, paramInt, paramInt, Shader.TileMode.REPEAT);
    paramContext.getPaint().setShader(localLinearGradient);
    return paramContext;
  }
  
  @NonNull
  public static String a(Activity paramActivity, VideoInfo paramVideoInfo, int paramInt)
  {
    String str3 = "详情";
    String str4 = "查看详情";
    String str1 = str4;
    String str2 = str3;
    if (c(paramVideoInfo))
    {
      str1 = str4;
      str2 = str3;
      if (paramVideoInfo.b.aGV == 12)
      {
        str1 = str4;
        str2 = str3;
        try
        {
          if (aqiz.isAppInstalled(paramActivity, new JSONObject(paramVideoInfo.b.Wo).optString("pkg_name")))
          {
            paramActivity = "打开";
            if (paramInt == 1) {
              return paramActivity;
            }
            return "立即打开";
          }
        }
        catch (JSONException paramActivity)
        {
          str2 = "下载";
          str1 = "立即下载";
        }
      }
    }
    switch (paramVideoInfo.b.aGY)
    {
    default: 
      paramActivity = str2;
    }
    for (;;)
    {
      if (paramInt != 1) {
        break label175;
      }
      if (TextUtils.isEmpty(paramVideoInfo.b.Ww)) {
        break;
      }
      return paramVideoInfo.b.Ww;
      paramActivity = "购买";
      str1 = "立即购买";
      continue;
      paramActivity = "详情";
      str1 = "查看详情";
    }
    label175:
    if (TextUtils.isEmpty(paramVideoInfo.b.Wx)) {
      return str1;
    }
    return paramVideoInfo.b.Wx;
  }
  
  @NonNull
  public static String a(Activity paramActivity, VideoInfo paramVideoInfo, Resources paramResources)
  {
    Object localObject;
    if (paramResources == null) {
      localObject = "";
    }
    label156:
    do
    {
      do
      {
        for (;;)
        {
          return localObject;
          localObject = "";
          paramResources = (Resources)localObject;
          if (paramVideoInfo != null)
          {
            paramResources = (Resources)localObject;
            if (paramVideoInfo.b != null)
            {
              paramResources = (Resources)localObject;
              if (!TextUtils.isEmpty(paramVideoInfo.b.Wi)) {
                paramResources = paramVideoInfo.b.Wi;
              }
            }
          }
          if (((paramVideoInfo != null) && (paramVideoInfo.b != null) && (h(paramVideoInfo.b))) && ((paramVideoInfo == null) || (paramVideoInfo.b == null) || (paramVideoInfo.b.aGV != 12))) {
            break label156;
          }
          localObject = paramResources;
          try
          {
            if (!aqiz.isAppInstalled(paramActivity, new JSONObject(paramVideoInfo.b.Wo).optString("pkg_name")))
            {
              boolean bool = TextUtils.isEmpty(paramResources);
              localObject = paramResources;
              if (bool) {
                return paramResources;
              }
            }
          }
          catch (JSONException paramActivity)
          {
            localObject = paramResources;
          }
        }
      } while (!TextUtils.isEmpty(paramResources));
      return paramResources;
      localObject = paramResources;
    } while (!TextUtils.isEmpty(paramResources));
    return paramResources;
  }
  
  @NonNull
  public static String a(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    String str = "";
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdProductType == 12))
    {
      try
      {
        if (aqiz.isAppInstalled(paramContext, new JSONObject(paramAdvertisementInfo.mAdExt).optString("pkg_name"))) {
          return "打开";
        }
        paramContext = str;
        if (!TextUtils.isEmpty("")) {
          return paramContext;
        }
        return "下载";
      }
      catch (JSONException paramContext)
      {
        paramContext = str;
        if (!TextUtils.isEmpty("")) {
          return paramContext;
        }
      }
      return "下载";
    }
    else
    {
      paramContext = str;
      if (TextUtils.isEmpty("")) {
        paramContext = "查看";
      }
    }
    return paramContext;
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null)
    {
      localObject1 = null;
      return localObject1;
    }
    Object localObject1 = paramBaseArticleInfo.getSubscribeName();
    Object localObject2;
    if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
    {
      localObject2 = (AdvertisementInfo)paramBaseArticleInfo;
      if (!AdvertisementInfo.isAppAdvertisementInfo(paramBaseArticleInfo)) {}
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(((AdvertisementInfo)localObject2).mAdExt).getString("appname");
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        int j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyAdUtils", 2, "cannot get name from app advertisement");
        continue;
      }
      j = paramBaseArticleInfo.mSubscribeName.length();
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
      {
        i = 9;
        if (j > i)
        {
          localObject1 = new StringBuilder();
          localObject2 = paramBaseArticleInfo.mSubscribeName;
          if (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
            break label160;
          }
          i = 8;
          return ((String)localObject2).substring(0, i) + "…";
          localObject1 = localJSONException.mAdCorporateImageName;
        }
      }
      else
      {
        i = 18;
        continue;
      }
      break;
      label160:
      int i = 17;
    }
  }
  
  public static JSONObject a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject)
  {
    if ((paramAdvertisementInfo == null) || (paramJSONObject == null) || (!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdExt))) {
      return paramJSONObject;
    }
    for (;;)
    {
      try
      {
        if (!jzk.C(paramContext, new JSONObject(paramAdvertisementInfo.mAdExt).optString("pkg_name"))) {
          break label102;
        }
        i = 2;
        paramJSONObject.put("action_type", i);
        return paramJSONObject;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ReadInJoyAdUtils", 2, "doGdtWebClickReport fail message:" + paramContext.getMessage());
      return paramJSONObject;
      label102:
      int i = 1;
    }
  }
  
  public static void a(VideoInfo paramVideoInfo, mtg.b paramb)
  {
    if ((paramVideoInfo == null) || (!paramVideoInfo.isAD) || (paramb == null) || (paramVideoInfo.b == null) || (TextUtils.isEmpty(paramVideoInfo.b.mAdExtInfo))) {
      return;
    }
    for (;;)
    {
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.b.mAdExtInfo);
        if (!paramVideoInfo.has("AdsIconText")) {
          break;
        }
        if (!TextUtils.isEmpty(paramVideoInfo.optString("AdsIconText")))
        {
          if (paramb.r() != null) {
            paramb.r().setText(paramVideoInfo.optString("AdsIconText"));
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ReadInJoyAdUtils", 2, "detail ad  video adInconText:" + paramVideoInfo.optString("AdsIconText"));
          return;
        }
      }
      catch (Exception paramVideoInfo)
      {
        paramVideoInfo.printStackTrace();
        return;
      }
      if (paramb.itemType == 4)
      {
        if (paramb.c() != null) {
          paramb.c().setVisibility(8);
        }
      }
      else if (paramb.r() != null) {
        paramb.r().setVisibility(8);
      }
    }
  }
  
  public static void a(ReadInJoyAdGestureView paramReadInJoyAdGestureView, LinearLayout paramLinearLayout)
  {
    if ((paramReadInJoyAdGestureView == null) || (paramLinearLayout == null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramReadInJoyAdGestureView.getLayoutParams();
    if (paramLinearLayout.getHeight() != 0) {
      localLayoutParams.bottomMargin = paramLinearLayout.getHeight();
    }
    paramReadInJoyAdGestureView.setLayoutParams(localLayoutParams);
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo, int paramInt, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    VideoFeedsPlayManager.b localb = null;
    if (paramVideoFeedsPlayManager != null) {
      localb = paramVideoFeedsPlayManager.a();
    }
    if (paramAdvertisementInfo != null)
    {
      paramAdvertisementInfo.setClickPos(paramInt);
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdVideoUrl)) {
        a(localb, true);
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, Context paramContext, int paramInt)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mFeedType == 39) && (!TextUtils.isEmpty(paramArticleInfo.mArticleContentUrl))) {}
    for (;;)
    {
      try
      {
        MiniAppLauncher.startMiniApp(paramContext, paramArticleInfo.mArticleContentUrl, 2103, null);
        jzk.a(paramContext, new jyq.a().a(504L).b(50104L).c(5040104L).a(paramArticleInfo.innerUniqueID).b(paramArticleInfo.mTitle).h(String.valueOf(paramInt)).c(paramArticleInfo.mSubscribeName).f("1").g(paramArticleInfo.mArticleContentUrl).a());
        if (paramArticleInfo.hasChannelInfo())
        {
          paramInt = paramArticleInfo.mChannelInfoId;
          if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
            continue;
          }
          i = 0;
          String str = kxm.f(paramArticleInfo);
          kbp.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, "0X8007625", "0X8007625", 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), kxm.a(paramArticleInfo.mAlgorithmID, kxm.a(paramArticleInfo), 0, paramInt, i, aqiw.isWifiConnected(paramContext), str, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, kxm.h(paramArticleInfo), paramArticleInfo), false);
          return;
        }
      }
      catch (Exception paramArticleInfo)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ReadInJoyAdUtils", 2, "jump to mini game error " + paramArticleInfo.getMessage());
      }
      paramInt = 0;
      continue;
      i = 1;
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    Object localObject = el(paramBaseArticleInfo.mSubscribeName);
    paramBaseArticleInfo = (BaseArticleInfo)localObject;
    if (((String)localObject).length() > 13) {
      paramBaseArticleInfo = ((String)localObject).substring(0, 12) + "…";
    }
    localObject = new JSONObject();
    ((JSONObject)localObject).put("info_source_text", paramBaseArticleInfo);
    paramJSONObject.put("id_info_source", localObject);
  }
  
  public static void a(VideoFeedsPlayManager.b paramb, boolean paramBoolean)
  {
    if ((paramb != null) && (paramb.a != null)) {
      paramb.a.amC = paramBoolean;
    }
  }
  
  public static void a(mrp parammrp, mtg parammtg, mtg.l paraml)
  {
    if ((parammrp == null) || (parammtg == null) || (paraml == null)) {}
    while ((!(paraml instanceof mtg.b)) || (!a((mtg.b)paraml)) || (((mtg.b)paraml).a() == null) || (!((mtg.b)paraml).a().Af())) {
      return;
    }
    parammrp.aRE();
    parammtg.e(paraml);
  }
  
  public static void a(JSONObject paramJSONObject, kkw paramkkw)
  {
    if (paramkkw == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject;
          if (!TextUtils.isEmpty(paramkkw.aao))
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("iconUrl", paramkkw.aao);
            paramJSONObject.put("id_pk_icon", localObject);
          }
          if ((paramkkw.gi != null) && (paramkkw.aao.length() >= 2))
          {
            localObject = (kkt)paramkkw.gi.get(0);
            JSONObject localJSONObject;
            if (!TextUtils.isEmpty(((kkt)localObject).aal))
            {
              localJSONObject = new JSONObject();
              localJSONObject.put("iconUrl", ((kkt)localObject).aal);
              paramJSONObject.put("id_pk_image_bg_left", localJSONObject);
            }
            if (!TextUtils.isEmpty(((kkt)localObject).buttonTxt))
            {
              localJSONObject = new JSONObject();
              localJSONObject.put("text", ((kkt)localObject).buttonTxt);
              paramJSONObject.put("id_pk_label_left", localJSONObject);
            }
            paramkkw = (kkt)paramkkw.gi.get(1);
            if (!TextUtils.isEmpty(paramkkw.aal))
            {
              localObject = new JSONObject();
              ((JSONObject)localObject).put("iconUrl", paramkkw.aal);
              paramJSONObject.put("id_pk_image_bg_right", localObject);
            }
            if (!TextUtils.isEmpty(paramkkw.buttonTxt))
            {
              localObject = new JSONObject();
              ((JSONObject)localObject).put("text", paramkkw.buttonTxt);
              paramJSONObject.put("id_pk_label_right", localObject);
              return;
            }
          }
        }
        catch (Exception paramJSONObject) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyAdUtils", 2, "bindPkButton error message:" + paramJSONObject.getMessage());
  }
  
  public static boolean a(VideoFeedsPlayManager.b paramb)
  {
    if ((paramb != null) && (paramb.a != null)) {
      return paramb.a.amC;
    }
    return false;
  }
  
  public static boolean a(mtg.b paramb)
  {
    if ((paramb != null) && (paramb.a != null) && (paramb.a.d != null) && (paramb.a.d.b != null))
    {
      paramb = paramb.a.d.b;
      try
      {
        paramb = new JSONObject(paramb.mAdExtInfo);
        if (paramb == null) {
          return false;
        }
        paramb = paramb.optJSONObject("GesturesAd_info");
        if (paramb != null)
        {
          int i = paramb.optInt("showGesturesAdType");
          if (i > 0) {
            return true;
          }
        }
      }
      catch (Exception paramb)
      {
        paramb.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean a(muc parammuc)
  {
    String str = awit.sn("sp_key_ad_soft_total_area");
    if ((TextUtils.isEmpty(str)) || ("0".equals(str))) {}
    int i;
    int j;
    do
    {
      return true;
      i = jzp.o(awit.sn("sp_key_ad_soft_ad_max"), 25);
      j = parammuc.pH();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdUtils", 2, "isOverAdFrequency: dayDisplayCount=" + j + ",adShowMaxCount=" + i);
      }
    } while (j > i);
    return false;
  }
  
  public static void aEK()
  {
    Object localObject = knq.get(2);
    if ((localObject != null) && ((localObject instanceof kkz))) {
      try
      {
        localObject = (kkz)localObject;
        int i;
        JSONObject localJSONObject1;
        JSONObject localJSONObject2;
        if (((kkz)localObject).isVaild())
        {
          i = jzk.aFw;
          if (((kkz)localObject).advertisementInfo.mOrigin > 0) {
            i = ((kkz)localObject).advertisementInfo.mOrigin;
          }
          localJSONObject1 = new JSONObject();
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("stat_type", jzk.aGC);
          localJSONObject2.put("webview_click", ((kkz)localObject).clickTime);
          localJSONObject2.put("webview_start", ((kkz)localObject).so);
          localJSONObject2.put("webview_head", ((kkz)localObject).sp);
          localJSONObject2.put("webview_body", ((kkz)localObject).sq);
          localJSONObject2.put("webview_close", System.currentTimeMillis());
          if (!((kkz)localObject).agf) {
            break label203;
          }
          localJSONObject2.put("wvalive", 1);
        }
        for (;;)
        {
          localJSONObject1.put("statistics_data_report", localJSONObject2.toString());
          jzk.a(new kku.a().a(jzk.aFk).b(i).a(((kkz)localObject).advertisementInfo).e(localJSONObject1).a());
          knq.remove(2);
          return;
          label203:
          localJSONObject2.put("wvalive", 0);
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyAdUtils", 2, "doGdtWebClickReport fail message:" + localException.getMessage());
        }
      }
    }
  }
  
  public static String b(AdvertisementInfo paramAdvertisementInfo)
  {
    Object localObject1;
    if (paramAdvertisementInfo == null) {
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      String str = "";
      try
      {
        if (knk.w(paramAdvertisementInfo)) {}
        localObject1 = str;
        if (!g(paramAdvertisementInfo))
        {
          localObject1 = str;
          if (!j(paramAdvertisementInfo))
          {
            int i = f(paramAdvertisementInfo);
            if ((AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (i == 2))
            {
              Object localObject2 = new JSONObject(paramAdvertisementInfo.mAdExt);
              localObject1 = ((JSONObject)localObject2).optString("pkg_name");
              localObject2 = ((JSONObject)localObject2).optString("appname");
              if (i == 2) {
                localObject1 = c(paramAdvertisementInfo);
              }
              if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdCustomizedInvokeUrl))
              {
                if (aqiz.isAppInstalled(BaseApplicationImpl.getContext(), (String)localObject1)) {
                  return ek((String)localObject2);
                }
                if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdBtnTxt)) {
                  return paramAdvertisementInfo.mAdBtnTxt;
                }
              }
              if (aqiz.isAppInstalled(BaseApplicationImpl.getContext(), (String)localObject1)) {
                return ek((String)localObject2);
              }
              if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdBtnTxt)) {
                return paramAdvertisementInfo.mAdBtnTxt;
              }
            }
            if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdBtnTxt)) {
              return paramAdvertisementInfo.mAdBtnTxt;
            }
            localObject1 = str;
            if (i != 1)
            {
              boolean bool = AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo);
              localObject1 = str;
              if (!bool)
              {
                localObject1 = str;
                if (i == 2) {
                  return "";
                }
              }
            }
          }
        }
      }
      catch (JSONException paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
    }
    return "";
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {}
    do
    {
      do
      {
        do
        {
          return;
          localJSONObject = new JSONObject(((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo);
          paramJSONObject.put("id_info_operate_parent", new JSONObject());
          paramJSONObject.put("id_large_cell_container", new JSONObject());
          if (!localJSONObject.has("AdsIconText")) {
            break;
          }
          paramBaseArticleInfo = new JSONObject();
          if (!TextUtils.isEmpty(localJSONObject.optString("AdsIconText")))
          {
            paramBaseArticleInfo.put("info_status_text", localJSONObject.optString("AdsIconText"));
            paramJSONObject.put("id_info_status", paramBaseArticleInfo);
          }
        } while (!QLog.isColorLevel());
        QLog.d("ReadInJoyAdUtils", 2, "bindAdStatus AdsIconText:" + localJSONObject.optString("AdsIconText"));
        return;
      } while (TextUtils.isEmpty(paramBaseArticleInfo.mArticleSubscriptText));
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("info_status_text", paramBaseArticleInfo.mArticleSubscriptText);
      paramJSONObject.put("id_info_status", localJSONObject);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyAdUtils", 2, "bindAdStatus mArticleSubscriptText:" + paramBaseArticleInfo.mArticleSubscriptText);
  }
  
  public static void b(AdData paramAdData)
  {
    e(kne.a(paramAdData));
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 38) && (paramBaseArticleInfo.smallGameData != null);
  }
  
  public static String c(AdvertisementInfo paramAdvertisementInfo)
  {
    return (String)knc.a(paramAdvertisementInfo.mAdExtInfo, "game_pkg_name", "");
  }
  
  public static JSONObject c(int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("click_type", paramInt1);
      localJSONObject1.put("gesture_type", paramInt2);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("click_info_report", localJSONObject1.toString());
      return localJSONObject2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static void c(VideoAdInfo paramVideoAdInfo)
  {
    e(knl.b(paramVideoAdInfo));
  }
  
  public static boolean c(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.b != null) && (!TextUtils.isEmpty(paramVideoInfo.b.Wt));
  }
  
  public static boolean d(Rect paramRect)
  {
    if ((paramRect.width() <= 0) || (paramRect.height() <= 0)) {}
    while ((paramRect.left < 0) || (paramRect.top < 0) || (paramRect.right < 0) || (paramRect.bottom < 0)) {
      return false;
    }
    return true;
  }
  
  public static boolean dh(int paramInt)
  {
    return (M.contains(Integer.valueOf(paramInt))) || (kys.du(paramInt));
  }
  
  public static void e(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    do
    {
      return;
      try
      {
        paramAdvertisementInfo = new GdtAd(ods.a(paramAdvertisementInfo));
        tgh.a().a(paramAdvertisementInfo);
        return;
      }
      catch (Exception paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.e("ReadInJoyAdUtils", 2, "preLoadAdForMiniProgram fail");
  }
  
  public static void e(VideoFeedsPlayManager.b paramb)
  {
    if ((paramb != null) && (paramb.a != null)) {
      paramb.a.amC = false;
    }
  }
  
  public static String ek(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.length();
    if ((i > 0) && (i <= 2)) {
      return "";
    }
    return "";
  }
  
  private static String el(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static int f(AdvertisementInfo paramAdvertisementInfo)
  {
    return ((Integer)knc.a(paramAdvertisementInfo.mAdExtInfo, "game_button_type", Integer.valueOf(0))).intValue();
  }
  
  public static void f(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null) {}
    try
    {
      kkz localkkz = new kkz();
      localkkz.advertisementInfo = paramAdvertisementInfo;
      localkkz.hT = String.valueOf(paramAdvertisementInfo.mAdAid);
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage))
      {
        paramAdvertisementInfo = Uri.parse(paramAdvertisementInfo.mAdLandingPage).getQueryParameter("adtag");
        if (!TextUtils.isEmpty(paramAdvertisementInfo))
        {
          int i = paramAdvertisementInfo.lastIndexOf(".");
          if ((i > 0) && (i < paramAdvertisementInfo.length() - 1)) {
            localkkz.hT = paramAdvertisementInfo.substring(i + 1);
          }
        }
      }
      localkkz.clickTime = System.currentTimeMillis();
      knq.put(2, localkkz);
      ThreadManager.getSubThreadHandler().post(new ReadInJoyAdUtils.1());
      return;
    }
    catch (Exception paramAdvertisementInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInJoyAdUtils", 2, "addGdtWebClickReport fail message:" + paramAdvertisementInfo.getMessage());
    }
  }
  
  public static int g(AdvertisementInfo paramAdvertisementInfo)
  {
    if (m(paramAdvertisementInfo)) {
      return 116;
    }
    return 39;
  }
  
  public static boolean g(AdvertisementInfo paramAdvertisementInfo)
  {
    int i = f(paramAdvertisementInfo);
    paramAdvertisementInfo = c(paramAdvertisementInfo);
    return (i == 3) || ((i == 1) && (knp.b(null, paramAdvertisementInfo)));
  }
  
  public static void h(Activity paramActivity, int paramInt)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    paramActivity.setDrawingCacheEnabled(true);
    paramActivity.buildDrawingCache();
    Bitmap localBitmap = Bitmap.createBitmap(paramActivity.getDrawingCache());
    paramActivity.setDrawingCacheEnabled(false);
    if (localBitmap == null) {
      return;
    }
    knq.put(paramInt, localBitmap);
  }
  
  public static boolean h(VideoAdInfo paramVideoAdInfo)
  {
    return j(jzk.a(paramVideoAdInfo));
  }
  
  public static boolean h(AdvertisementInfo paramAdvertisementInfo)
  {
    return f(paramAdvertisementInfo) == 1;
  }
  
  public static boolean i(VideoAdInfo paramVideoAdInfo)
  {
    if (!TextUtils.isEmpty(paramVideoAdInfo.Wr)) {}
    for (;;)
    {
      return true;
      Object localObject = paramVideoAdInfo.mAdExtInfo;
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("video_rowkey")) {
          paramVideoAdInfo.Wr = ((JSONObject)localObject).optString("video_rowkey", "");
        }
        boolean bool = TextUtils.isEmpty(paramVideoAdInfo.Wr);
        if (bool) {
          return false;
        }
      }
      catch (JSONException paramVideoAdInfo)
      {
        paramVideoAdInfo.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean i(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) {}
    try
    {
      paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExt).optString("pkg_name");
      boolean bool3 = aqiz.isAppInstalled(BaseApplicationImpl.getContext(), paramAdvertisementInfo);
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramAdvertisementInfo) {}
    return false;
  }
  
  public static Bitmap j(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramString = new URL(paramString).openConnection();
      i = ((HttpURLConnection)paramString).getContentLength();
      paramString.connect();
      localInputStream = paramString.getInputStream();
      localBufferedInputStream = new BufferedInputStream(localInputStream, i);
      localBitmap = BitmapFactory.decodeStream(localBufferedInputStream);
      paramString = localBitmap;
    }
    catch (Exception localException1)
    {
      int i;
      InputStream localInputStream;
      BufferedInputStream localBufferedInputStream;
      Bitmap localBitmap;
      int j;
      label102:
      Matrix localMatrix;
      paramString = null;
      label168:
      localException1.printStackTrace();
      return paramString;
    }
    try
    {
      i = localBitmap.getWidth();
      paramString = localBitmap;
      j = localBitmap.getHeight();
      if ((i <= 0) || (j <= 0)) {
        break label180;
      }
      paramString = localBitmap;
      f2 = paramInt1 / i;
      paramString = localBitmap;
      f1 = paramInt2 / j;
    }
    catch (Exception localException2)
    {
      break label168;
      f1 = 1.0F;
      f2 = 1.0F;
      break label102;
    }
    paramString = localBitmap;
    localMatrix = new Matrix();
    paramString = localBitmap;
    localMatrix.postScale(f2, f1);
    paramString = localBitmap;
    localBitmap = Bitmap.createBitmap(localBitmap, 0, 0, i, j, localMatrix, true);
    paramString = localBitmap;
    localBufferedInputStream.close();
    paramString = localBitmap;
    localInputStream.close();
    return localBitmap;
  }
  
  public static boolean j(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    while ((TextUtils.isEmpty(paramAdvertisementInfo.mPopFormH5Url)) || (!knc.d(paramAdvertisementInfo))) {
      return false;
    }
    return true;
  }
  
  public static boolean k(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo.mInteractType == 2) && (!TextUtils.isEmpty(paramAdvertisementInfo.mInteractImageList));
  }
  
  public static boolean l(AdvertisementInfo paramAdvertisementInfo)
  {
    return paramAdvertisementInfo.downloadState != 3;
  }
  
  public static boolean m(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (5001 == paramAdvertisementInfo.mAdvertisementExtInfo.aJz);
  }
  
  public static boolean n(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (1003 == paramAdvertisementInfo.mAdvertisementExtInfo.aJz);
  }
  
  public static boolean o(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (5002 == paramAdvertisementInfo.mAdvertisementExtInfo.aJz);
  }
  
  public static boolean p(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (1022 == paramAdvertisementInfo.mAdvertisementExtInfo.aJz);
  }
  
  public static boolean q(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (1009 == paramAdvertisementInfo.mAdvertisementExtInfo.aJz);
  }
  
  public static boolean r(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && ((1014 == paramAdvertisementInfo.mAdvertisementExtInfo.aJz) || (1015 == paramAdvertisementInfo.mAdvertisementExtInfo.aJz));
  }
  
  public static boolean s(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null) {
      try
      {
        paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
        if (paramAdvertisementInfo == null) {
          return false;
        }
        paramAdvertisementInfo = paramAdvertisementInfo.optJSONObject("GesturesAd_info");
        if (paramAdvertisementInfo != null)
        {
          int i = paramAdvertisementInfo.optInt("showGesturesAdType");
          if (i > 0) {
            return true;
          }
        }
      }
      catch (Exception paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     knd
 * JD-Core Version:    0.7.0.1
 */