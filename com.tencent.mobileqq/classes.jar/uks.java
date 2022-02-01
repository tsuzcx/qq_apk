import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import com.tencent.biz.pubaccount.NativeAd.report.ExposeMode;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdGestureView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class uks
{
  private static HashSet<Integer> a = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(56), Integer.valueOf(40531), Integer.valueOf(14), Integer.valueOf(40174), Integer.valueOf(8), Integer.valueOf(1), Integer.valueOf(13), Integer.valueOf(15), Integer.valueOf(5), Integer.valueOf(11), Integer.valueOf(40466), Integer.valueOf(41541), Integer.valueOf(40013), Integer.valueOf(58), Integer.valueOf(16), Integer.valueOf(53), Integer.valueOf(52), Integer.valueOf(41629), Integer.valueOf(55), Integer.valueOf(40007), Integer.valueOf(59), Integer.valueOf(10), Integer.valueOf(9), Integer.valueOf(54), Integer.valueOf(41504) }));
  
  public static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return 0;
    }
    if (paramAdvertisementInfo.gameAdComData != null) {
      return oix.a(paramAdvertisementInfo.gameAdComData.s, 0);
    }
    return ((Integer)ukr.a(paramAdvertisementInfo.mAdExtInfo, "game_button_type", Integer.valueOf(0))).intValue();
  }
  
  public static int a(ArticleInfo paramArticleInfo)
  {
    int j = 2050;
    int i;
    if (paramArticleInfo.mFeedType == 38) {
      i = 2051;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramArticleInfo.mFeedType != 39);
      if (e(paramArticleInfo)) {
        return 2053;
      }
      if (g(paramArticleInfo)) {
        return 2054;
      }
      if (h(paramArticleInfo)) {
        return 2052;
      }
      i = j;
    } while (!i(paramArticleInfo));
    return 2057;
  }
  
  public static int a(String paramString, boolean paramBoolean)
  {
    int j = 10000;
    int k = 3000;
    int i;
    if (paramBoolean)
    {
      i = 10000;
      if (!TextUtils.isEmpty(paramString)) {
        break label33;
      }
    }
    for (;;)
    {
      return i;
      i = 3000;
      break;
      try
      {
        label33:
        paramString = new JSONObject(paramString).optString("cards_show_timming");
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new JSONObject(paramString);
          if (paramBoolean)
          {
            k = paramString.optInt("show_cards");
            i = j;
            if (k >= 0) {
              i = k;
            }
          }
          else
          {
            j = paramString.optInt("change_color");
            i = k;
            if (j >= 0) {
              i = j;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return i;
  }
  
  public static long a(swi paramswi, boolean paramBoolean)
  {
    if (!a(paramswi)) {}
    for (;;)
    {
      return -1L;
      if ((paramswi != null) && (paramswi.jdField_a_of_type_Skq != null) && (paramswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null))
      {
        paramswi = paramswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a;
        try
        {
          paramswi = new JSONObject(paramswi.v);
          if (paramswi != null)
          {
            paramswi = paramswi.optJSONObject("GesturesAd_info");
            if (paramswi != null)
            {
              if (paramBoolean) {
                return paramswi.optInt("showGesturesAd_beginTime");
              }
              int i = paramswi.optInt("showGesturesAd_endTime");
              return i;
            }
          }
        }
        catch (Exception paramswi)
        {
          paramswi.printStackTrace();
        }
      }
    }
    return -1L;
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
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
  
  public static ShapeDrawable a(int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    float f9 = AIOUtils.dp2px(1.0F, paramContext.getResources());
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
  
  public static String a(long paramLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramLong != 0L)
    {
      if (paramLong <= 99990000L) {
        break label45;
      }
      localStringBuilder.append("9999万+");
    }
    for (;;)
    {
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
      label45:
      if (paramLong > 10000L)
      {
        double d = paramLong / 10000.0D;
        localStringBuilder.append(new DecimalFormat("0.0").format(d));
        localStringBuilder.append("万");
      }
      else
      {
        localStringBuilder.append(paramLong);
      }
    }
  }
  
  @NonNull
  public static String a(Context paramContext, VideoInfo paramVideoInfo, int paramInt)
  {
    String str2 = "详情";
    String str3 = "查看详情";
    Object localObject = str3;
    String str1 = str2;
    if (a(paramVideoInfo))
    {
      localObject = str3;
      str1 = str2;
      if (paramVideoInfo.a.c != 12) {}
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramVideoInfo.a.jdField_r_of_type_JavaLangString);
        if (bhfn.a(paramContext, ((JSONObject)localObject).optString("pkg_name")))
        {
          if (paramInt != 1) {
            break;
          }
          return "打开";
        }
        if (oil.a(BaseApplicationImpl.getContext(), ((JSONObject)localObject).optString("pkg_name")))
        {
          str1 = "安装";
          localObject = anvx.a(2131699425);
        }
      }
      catch (JSONException paramContext)
      {
        str1 = "下载";
        localObject = "立即下载";
        continue;
        paramContext = "购买";
        localObject = "立即购买";
        continue;
        paramContext = "详情";
        localObject = "查看详情";
        continue;
        if (TextUtils.isEmpty(paramVideoInfo.a.J)) {
          return localObject;
        }
        paramContext = paramVideoInfo.a.J;
      }
      switch (paramVideoInfo.a.jdField_r_of_type_Int)
      {
      default: 
        paramContext = str1;
        if (paramInt == 1)
        {
          if (TextUtils.isEmpty(paramVideoInfo.a.I)) {
            break label243;
          }
          return paramVideoInfo.a.I;
          str1 = "下载";
          localObject = "立即下载";
        }
        break;
      case 1: 
      case 28: 
        label243:
        return paramContext;
      }
    }
    return "立即打开";
  }
  
  @NonNull
  public static String a(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    String str = "";
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdProductType == 12))
    {
      try
      {
        if (bhfn.a(paramContext, new JSONObject(paramAdvertisementInfo.mAdExt).optString("pkg_name"))) {
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
  
  public static String a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return "";
    }
    if (paramAdvertisementInfo.gameAdComData != null) {
      return paramAdvertisementInfo.gameAdComData.d;
    }
    return (String)ukr.a(paramAdvertisementInfo.mAdExtInfo, "game_pkg_name", "");
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
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static JSONObject a(int paramInt1, int paramInt2)
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
  
  public static JSONObject a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject)
  {
    if ((paramAdvertisementInfo == null) || (paramJSONObject == null) || (!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdExt))) {
      return paramJSONObject;
    }
    for (;;)
    {
      try
      {
        if (!ois.a(paramContext, new JSONObject(paramAdvertisementInfo.mAdExt).optString("pkg_name"))) {
          break label103;
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
      label103:
      int i = 1;
    }
  }
  
  public static void a()
  {
    Object localObject = ulc.a(2);
    if ((localObject instanceof ugc)) {
      try
      {
        localObject = (ugc)localObject;
        int i;
        JSONObject localJSONObject1;
        JSONObject localJSONObject2;
        if (((ugc)localObject).a())
        {
          i = 3;
          if (((ugc)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mOrigin > 0) {
            i = ((ugc)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mOrigin;
          }
          localJSONObject1 = new JSONObject();
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("stat_type", 2);
          localJSONObject2.put("webview_click", ((ugc)localObject).jdField_a_of_type_Long);
          localJSONObject2.put("webview_start", ((ugc)localObject).b);
          localJSONObject2.put("webview_head", ((ugc)localObject).c);
          localJSONObject2.put("webview_body", ((ugc)localObject).d);
          localJSONObject2.put("webview_close", System.currentTimeMillis());
          if (!((ugc)localObject).jdField_a_of_type_Boolean) {
            break label194;
          }
          localJSONObject2.put("wvalive", 1);
        }
        for (;;)
        {
          localJSONObject1.put("statistics_data_report", localJSONObject2.toString());
          ois.a(new ufy().a(25).b(i).a(((ugc)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(localJSONObject1).a());
          ulc.a(2);
          return;
          label194:
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
  
  public static void a(Activity paramActivity, int paramInt)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    paramActivity.setDrawingCacheEnabled(true);
    paramActivity.buildDrawingCache();
    Bitmap localBitmap = Bitmap.createBitmap(paramActivity.getDrawingCache());
    paramActivity.setDrawingCacheEnabled(false);
    if (localBitmap == null) {
      return;
    }
    ulc.a(paramInt, localBitmap);
  }
  
  public static void a(VideoAdInfo paramVideoAdInfo)
  {
    a(ulb.a(paramVideoAdInfo));
  }
  
  public static void a(VideoInfo paramVideoInfo, swi paramswi)
  {
    if ((paramVideoInfo == null) || (!paramVideoInfo.c) || (paramswi == null) || (paramVideoInfo.a == null) || (TextUtils.isEmpty(paramVideoInfo.a.v))) {
      return;
    }
    for (;;)
    {
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.a.v);
        if (!paramVideoInfo.has("AdsIconText")) {
          break;
        }
        if (!TextUtils.isEmpty(paramVideoInfo.optString("AdsIconText")))
        {
          if (paramswi.a() != null) {
            paramswi.a().setText(paramVideoInfo.optString("AdsIconText"));
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
      if (paramswi.jdField_a_of_type_Int == 4)
      {
        if (paramswi.a() != null) {
          paramswi.a().setVisibility(8);
        }
      }
      else if (paramswi.a() != null) {
        paramswi.a().setVisibility(8);
      }
    }
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    do
    {
      return;
      try
      {
        paramAdvertisementInfo = new GdtAd(uvp.a(paramAdvertisementInfo));
        acam.a().a(paramAdvertisementInfo);
        return;
      }
      catch (Exception paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.e("ReadInJoyAdUtils", 2, "preLoadAdForMiniProgram fail");
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo, int paramInt, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    skq localskq = null;
    if (paramVideoFeedsPlayManager != null) {
      localskq = paramVideoFeedsPlayManager.a();
    }
    if (paramAdvertisementInfo != null)
    {
      paramAdvertisementInfo.setClickPos(paramInt);
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdVideoUrl)) {
        a(localskq, true);
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
        if (!MiniAppLauncher.startMiniApp(paramContext, paramArticleInfo.mArticleContentUrl, 2103, null)) {
          MiniAppLauncher.startMiniApp(paramContext, paramArticleInfo.mSmallMiniGameInfo.k, 2103, null);
        }
        if (paramArticleInfo.mSmallMiniGameInfo != null) {
          ois.a(paramContext, paramArticleInfo, paramInt, 1);
        }
        if (!paramArticleInfo.hasChannelInfo()) {
          continue;
        }
        paramInt = paramArticleInfo.mChannelInfoId;
        if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
          continue;
        }
        i = 0;
        String str = pqw.b(paramArticleInfo);
        olh.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, "0X8007625", "0X8007625", 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pqf.a(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), 0, paramInt, i, NetworkUtil.isWifiConnected(paramContext), str, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pqw.d(paramArticleInfo), paramArticleInfo), false);
      }
      catch (Exception paramContext)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ReadInJoyAdUtils", 2, "jump to mini game error " + paramContext.getMessage());
        continue;
      }
      paramContext = new rqg();
      paramContext.d = 0;
      paramContext.e = 0;
      paramContext.c = 1;
      omx.a(paramArticleInfo, (int)paramArticleInfo.mChannelID, 25, -1L, paramContext);
      return;
      paramInt = 0;
      continue;
      i = 1;
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    Object localObject = a(paramBaseArticleInfo.mSubscribeName);
    paramBaseArticleInfo = (BaseArticleInfo)localObject;
    if (((String)localObject).length() > 13) {
      paramBaseArticleInfo = ((String)localObject).substring(0, 12) + "…";
    }
    localObject = new JSONObject();
    ((JSONObject)localObject).put("info_source_text", paramBaseArticleInfo);
    paramJSONObject.put("id_info_source", localObject);
  }
  
  public static void a(AdData paramAdData)
  {
    a(ukt.a(paramAdData));
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
  
  public static void a(JSONObject paramJSONObject, ufz paramufz)
  {
    if (paramufz == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject;
          if (!TextUtils.isEmpty(paramufz.c))
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("iconUrl", paramufz.c);
            paramJSONObject.put("id_pk_icon", localObject);
          }
          if ((paramufz.a != null) && (paramufz.c.length() >= 2))
          {
            localObject = (ufv)paramufz.a.get(0);
            JSONObject localJSONObject;
            if (!TextUtils.isEmpty(((ufv)localObject).d))
            {
              localJSONObject = new JSONObject();
              localJSONObject.put("iconUrl", ((ufv)localObject).d);
              paramJSONObject.put("id_pk_image_bg_left", localJSONObject);
            }
            if (!TextUtils.isEmpty(((ufv)localObject).c))
            {
              localJSONObject = new JSONObject();
              localJSONObject.put("text", ((ufv)localObject).c);
              paramJSONObject.put("id_pk_label_left", localJSONObject);
            }
            paramufz = (ufv)paramufz.a.get(1);
            if (!TextUtils.isEmpty(paramufz.d))
            {
              localObject = new JSONObject();
              ((JSONObject)localObject).put("iconUrl", paramufz.d);
              paramJSONObject.put("id_pk_image_bg_right", localObject);
            }
            if (!TextUtils.isEmpty(paramufz.c))
            {
              localObject = new JSONObject();
              ((JSONObject)localObject).put("text", paramufz.c);
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
  
  public static void a(skq paramskq)
  {
    if ((paramskq != null) && (paramskq.jdField_a_of_type_Rpz != null)) {
      paramskq.jdField_a_of_type_Rpz.e = false;
    }
  }
  
  public static void a(skq paramskq, boolean paramBoolean)
  {
    if ((paramskq != null) && (paramskq.jdField_a_of_type_Rpz != null)) {
      paramskq.jdField_a_of_type_Rpz.e = paramBoolean;
    }
  }
  
  public static void a(uli paramuli, shl paramshl, swu paramswu)
  {
    if ((paramuli == null) || (paramshl == null) || (paramswu == null)) {}
    while ((!(paramswu instanceof swi)) || (!a((swi)paramswu)) || (((swi)paramswu).a() == null) || (!((swi)paramswu).a().a())) {
      return;
    }
    paramuli.e();
    paramshl.a(paramswu);
  }
  
  public static boolean a(int paramInt)
  {
    return (a.contains(Integer.valueOf(paramInt))) || (plm.b(paramInt));
  }
  
  public static boolean a(Context paramContext, String paramString)
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
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    if ((HippyQQEngine.getModuleOnlineConfig("TKDMiniGame") == 1) && (paramInt == 41708) && (!TextUtils.isEmpty(paramString)) && (paramString.contains("h5GameSource")))
    {
      QLog.d("ReadInJoyAdUtils", 2, "jumpToMiniGameHippyTab scheme: " + paramString);
      Intent localIntent = osg.b(paramContext, 0, paramInt);
      if (!(paramContext instanceof BaseActivity)) {
        localIntent.setFlags(268435456);
      }
      localIntent.putExtra("key_channel_jump_scheme", paramString);
      paramContext.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  public static boolean a(Rect paramRect)
  {
    if ((paramRect.width() <= 0) || (paramRect.height() <= 0)) {}
    while ((paramRect.left < 0) || (paramRect.top < 0) || (paramRect.right < 0) || (paramRect.bottom < 0)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(VideoAdInfo paramVideoAdInfo)
  {
    if (!TextUtils.isEmpty(paramVideoAdInfo.D)) {}
    for (;;)
    {
      return true;
      Object localObject = paramVideoAdInfo.v;
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("video_rowkey")) {
          paramVideoAdInfo.D = ((JSONObject)localObject).optString("video_rowkey", "");
        }
        boolean bool = TextUtils.isEmpty(paramVideoAdInfo.D);
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
  
  public static boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.a != null) && (!TextUtils.isEmpty(paramVideoInfo.a.F));
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    int i = a(paramAdvertisementInfo);
    a(paramAdvertisementInfo);
    return i == 3;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      paramArticleInfo = (AdvertisementInfo)paramArticleInfo;
      bool1 = bool2;
      if (paramArticleInfo.mChannelID == 0L)
      {
        bool1 = bool2;
        if (paramArticleInfo.mAdMaterialId == 185)
        {
          bool1 = bool2;
          if (TextUtils.isEmpty(uvp.a(paramArticleInfo, "AdsIconText"))) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {
      return false;
    }
    paramBaseArticleInfo = ((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo;
    if (paramBaseArticleInfo == null)
    {
      ukq.a("bindAdColorIcon", "adExtInfo is empty");
      return false;
    }
    return new JSONObject(paramBaseArticleInfo).has("ad_color_tags");
  }
  
  public static boolean a(skq paramskq)
  {
    if ((paramskq != null) && (paramskq.jdField_a_of_type_Rpz != null)) {
      return paramskq.jdField_a_of_type_Rpz.e;
    }
    return false;
  }
  
  public static boolean a(swi paramswi)
  {
    if ((paramswi != null) && (paramswi.jdField_a_of_type_Skq != null) && (paramswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null))
    {
      paramswi = paramswi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a;
      try
      {
        paramswi = new JSONObject(paramswi.v).optJSONObject("GesturesAd_info");
        if (paramswi != null)
        {
          int i = paramswi.optInt("showGesturesAdType");
          if (i > 0) {
            return true;
          }
        }
      }
      catch (Exception paramswi)
      {
        paramswi.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean a(ugp paramugp)
  {
    String str = bmhv.a("sp_key_ad_soft_total_area");
    if ((TextUtils.isEmpty(str)) || ("0".equals(str))) {}
    int i;
    int j;
    do
    {
      return true;
      i = oix.a(bmhv.a("sp_key_ad_soft_ad_max"), 25);
      j = paramugp.b();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdUtils", 2, "isOverAdFrequency: dayDisplayCount=" + j + ",adShowMaxCount=" + i);
      }
    } while (j > i);
    return false;
  }
  
  public static int b(AdvertisementInfo paramAdvertisementInfo)
  {
    if (g(paramAdvertisementInfo)) {
      return 116;
    }
    return 39;
  }
  
  public static String b(AdvertisementInfo paramAdvertisementInfo)
  {
    String str = anvx.a(2131712281);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
      paramAdvertisementInfo = str;
      if (localJSONObject.has("AdsIconText")) {
        paramAdvertisementInfo = localJSONObject.optString("AdsIconText");
      }
      return paramAdvertisementInfo;
    }
    catch (JSONException paramAdvertisementInfo)
    {
      paramAdvertisementInfo.printStackTrace();
    }
    return str;
  }
  
  public static void b(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    do
    {
      return;
      try
      {
        ugc localugc = new ugc();
        localugc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
        localugc.jdField_a_of_type_JavaLangString = String.valueOf(paramAdvertisementInfo.mAdAid);
        if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage))
        {
          paramAdvertisementInfo = Uri.parse(paramAdvertisementInfo.mAdLandingPage).getQueryParameter("adtag");
          if (!TextUtils.isEmpty(paramAdvertisementInfo))
          {
            int i = paramAdvertisementInfo.lastIndexOf(".");
            if ((i > 0) && (i < paramAdvertisementInfo.length() - 1)) {
              localugc.jdField_a_of_type_JavaLangString = paramAdvertisementInfo.substring(i + 1);
            }
          }
        }
        localugc.jdField_a_of_type_Long = System.currentTimeMillis();
        ulc.a(2, localugc);
        ThreadManager.getSubThreadHandler().post(new ReadInJoyAdUtils.1());
        return;
      }
      catch (Exception paramAdvertisementInfo) {}
    } while (!QLog.isColorLevel());
    QLog.e("ReadInJoyAdUtils", 2, "addGdtWebClickReport fail message:" + paramAdvertisementInfo.getMessage());
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {}
    JSONObject localJSONObject;
    do
    {
      return;
      localJSONObject = new JSONObject(((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo);
      if (localJSONObject == null)
      {
        ukq.a("ReadInJoyAdUtils", "adExtInfo is empty");
        return;
      }
      Object localObject = localJSONObject.optJSONArray("ad_bubble_texts");
      if ((localObject == null) || (((JSONArray)localObject).length() <= 1))
      {
        ukq.a("ReadInJoyAdUtils", "bindBubble JSONArray is empty");
        return;
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("article_model", paramBaseArticleInfo);
      paramJSONObject.put("id_article_bubble_view", localObject);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyAdUtils", 2, "bindBubble ad_bubble_texts:" + localJSONObject.optString("ad_bubble_texts"));
  }
  
  public static boolean b(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.a != null) && (!TextUtils.isEmpty(paramVideoInfo.a.F)) && (!TextUtils.isEmpty(paramVideoInfo.a.E));
  }
  
  public static boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    return a(paramAdvertisementInfo) == 1;
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {}
    do
    {
      return false;
      paramBaseArticleInfo = new JSONObject(((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo);
      if (paramBaseArticleInfo == null)
      {
        ukq.a("ReadInJoyAdUtils", "adExtInfo is empty");
        return false;
      }
    } while (!paramBaseArticleInfo.has("ad_bg_img"));
    return true;
  }
  
  public static void c(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {}
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      JSONObject localJSONObject;
      do
      {
        return;
        localAdvertisementInfo = (AdvertisementInfo)paramBaseArticleInfo;
        localJSONObject = new JSONObject(localAdvertisementInfo.mAdExtInfo);
        if (localJSONObject == null)
        {
          ukq.a("ReadInJoyAdUtils", "adExtInfo is empty");
          return;
        }
      } while (!b(paramBaseArticleInfo));
      paramBaseArticleInfo = localJSONObject.optJSONArray("ad_bg_img");
      if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.length() >= 1))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("atmosphere_image_url", (String)paramBaseArticleInfo.get(0));
        paramJSONObject.put("id_atmosphere_image", localJSONObject);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyAdUtils", 2, "ad_bg_img:" + localAdvertisementInfo.mAdExtInfo);
  }
  
  public static boolean c(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) {}
    try
    {
      paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExt).optString("pkg_name");
      boolean bool3 = bhfn.a(BaseApplicationImpl.getContext(), paramAdvertisementInfo);
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramAdvertisementInfo) {}
    return false;
  }
  
  public static boolean c(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 38) && (paramBaseArticleInfo.smallGameData != null) && (paramBaseArticleInfo.mSmallMiniGameInfo.a());
  }
  
  public static void d(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {
      return;
    }
    if (new JSONObject(((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo) == null)
    {
      ukq.a("ReadInJoyAdUtils", "adExtInfo is empty");
      return;
    }
    if (b(paramBaseArticleInfo))
    {
      paramJSONObject.put("style_ID", "ReadInjoy_ad_large_atmosphere_cell");
      return;
    }
    paramJSONObject.put("style_ID", "ReadInjoy_ad_large_cell");
  }
  
  public static boolean d(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    while ((TextUtils.isEmpty(paramAdvertisementInfo.mPopFormH5Url)) || (!ukr.d(paramAdvertisementInfo))) {
      return false;
    }
    return true;
  }
  
  public static boolean d(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 38) && (paramBaseArticleInfo.mSmallMiniGameInfo != null) && (!paramBaseArticleInfo.mSmallMiniGameInfo.a());
  }
  
  public static void e(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
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
  
  public static boolean e(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo.mInteractType == 2) && (!TextUtils.isEmpty(paramAdvertisementInfo.mInteractImageList));
  }
  
  public static boolean e(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 39) && (paramBaseArticleInfo.mSmallMiniGameInfo != null) && (paramBaseArticleInfo.mSmallMiniGameInfo.d.equals("1"));
  }
  
  public static void f(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {}
    do
    {
      return;
      paramBaseArticleInfo = ((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo;
      if (paramBaseArticleInfo == null)
      {
        ukq.a("bindAdColorIcon", "adExtInfo is empty");
        return;
      }
      paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo).optJSONArray("ad_color_tags");
    } while ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.length() < 1));
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("color_label_path", (String)paramBaseArticleInfo.get(0));
    paramJSONObject.put("id_ad_color_label_img", localJSONObject);
  }
  
  public static boolean f(AdvertisementInfo paramAdvertisementInfo)
  {
    return paramAdvertisementInfo.downloadState != 3;
  }
  
  public static boolean f(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 39);
  }
  
  public static void g(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!(paramBaseArticleInfo instanceof AdvertisementInfo)) {
      return;
    }
    paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
    try
    {
      uko.a(new JSONObject(paramBaseArticleInfo.mAdExtInfo), paramJSONObject);
      return;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static boolean g(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (5001 == paramAdvertisementInfo.mAdvertisementExtInfo.i);
  }
  
  public static boolean g(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 39) && (paramBaseArticleInfo.mSmallMiniGameInfo != null) && (paramBaseArticleInfo.mSmallMiniGameInfo.d.equals("5"));
  }
  
  public static void h(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    int i = 0;
    if (!(paramBaseArticleInfo instanceof AdvertisementInfo)) {
      return;
    }
    Object localObject1 = ((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo;
    if (localObject1 == null)
    {
      ukq.a("bindAdSourceTag", "adExtInfo is empty");
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localObject1 = new JSONObject((String)localObject1).optJSONArray("ad_tags");
      if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0))
      {
        ukq.a("bindAdSourceTag", "JSONArray is empty");
        return;
      }
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
      return;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if (i < ((JSONArray)localObject1).length())
      {
        Object localObject2 = ((JSONArray)localObject1).get(i);
        if (((localObject2 instanceof String)) && (i < 3)) {
          localArrayList.add(i, (String)localObject2);
        }
      }
      else
      {
        if ((localArrayList.size() > 0) && (localArrayList.get(0) != null))
        {
          paramJSONObject.put("ad_tag_text1", localArrayList.get(0));
          ukq.a("bindAdSourceTag", "one: " + (String)localArrayList.get(0));
        }
        if ((localArrayList.size() > 1) && (localArrayList.get(1) != null))
        {
          paramJSONObject.put("ad_tag_text2", localArrayList.get(1));
          ukq.a("bindAdSourceTag", "two: " + (String)localArrayList.get(1));
        }
        if ((localArrayList.size() > 2) && (localArrayList.get(2) != null))
        {
          paramJSONObject.put("ad_tag_text3", localArrayList.get(2));
          ukq.a("bindAdSourceTag", "three: " + (String)localArrayList.get(2));
        }
        localJSONObject.put("article_model", paramBaseArticleInfo);
        paramJSONObject.put("id_blur_img", localJSONObject);
        paramJSONObject.remove("id_article_double_image");
        paramJSONObject.remove("id_article_large_imge");
        return;
      }
      i += 1;
    }
  }
  
  public static boolean h(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (1003 == paramAdvertisementInfo.mAdvertisementExtInfo.i);
  }
  
  public static boolean h(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 39) && (paramBaseArticleInfo.mSmallMiniGameInfo != null) && (paramBaseArticleInfo.mSmallMiniGameInfo.d.equals("2"));
  }
  
  public static boolean i(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (1022 == paramAdvertisementInfo.mAdvertisementExtInfo.i);
  }
  
  public static boolean i(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && ((j(paramBaseArticleInfo)) || ((paramBaseArticleInfo.mSubArtilceList != null) && (paramBaseArticleInfo.mSubArtilceList.size() > 0) && (j((BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0)))));
  }
  
  public static boolean j(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdvertisementExtInfo == null)) {}
    while ((1014 != paramAdvertisementInfo.mAdvertisementExtInfo.i) && (1015 != paramAdvertisementInfo.mAdvertisementExtInfo.i)) {
      return false;
    }
    return true;
  }
  
  public static boolean j(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 39) && (paramBaseArticleInfo.mSmallMiniGameInfo != null) && (paramBaseArticleInfo.mSmallMiniGameInfo.d.equals("4"));
  }
  
  public static boolean k(AdvertisementInfo paramAdvertisementInfo)
  {
    return (j(paramAdvertisementInfo)) && (paramAdvertisementInfo.mAdvertisementExtInfo.jdField_r_of_type_Int == 1);
  }
  
  public static boolean k(BaseArticleInfo paramBaseArticleInfo)
  {
    return (h(paramBaseArticleInfo)) || (e(paramBaseArticleInfo)) || (f(paramBaseArticleInfo)) || (g(paramBaseArticleInfo)) || (i(paramBaseArticleInfo));
  }
  
  public static boolean l(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExtInfo).optJSONObject("GesturesAd_info");
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
  
  public static boolean l(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (TextUtils.isEmpty(paramBaseArticleInfo.mVideoVid))) {}
    while ((!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) || ((!paramBaseArticleInfo.mVideoVid.startsWith("http://")) && (!paramBaseArticleInfo.mVideoVid.startsWith("https://")))) {
      return false;
    }
    return true;
  }
  
  public static boolean m(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.adExperimentData == null)) {}
    while (paramAdvertisementInfo.adExperimentData.a() != ExposeMode.LOOSE) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uks
 * JD-Core Version:    0.7.0.1
 */