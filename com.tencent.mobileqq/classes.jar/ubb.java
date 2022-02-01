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
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.ad.fragment.ReadinjoyAdPKFragment;
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
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class ubb
{
  public static GdtAppReceiver a;
  private static ArrayList<Integer> a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(12), Integer.valueOf(25), Integer.valueOf(30), Integer.valueOf(41), Integer.valueOf(1000) }));
  }
  
  public static GdtHandler.Params a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, snh paramsnh, int paramInt, boolean paramBoolean, oml paramoml)
  {
    return a(paramContext, paramAdvertisementInfo, paramsnh, paramInt, paramBoolean, true, false, paramoml);
  }
  
  public static GdtHandler.Params a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, snh paramsnh, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, oml paramoml)
  {
    if ((paramBoolean2) && (!a(paramAdvertisementInfo, paramInt))) {
      return null;
    }
    olj localolj = new olj();
    localolj.b = paramBoolean1;
    localolj.d = paramBoolean3;
    if (paramoml != null) {
      if (paramoml.b) {
        break label105;
      }
    }
    label105:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      localolj.jdField_a_of_type_Boolean = paramBoolean1;
      localolj.c = paramoml.jdField_a_of_type_Boolean;
      localolj.jdField_a_of_type_Long = paramoml.jdField_a_of_type_Long;
      if (paramsnh != null) {
        localolj.jdField_a_of_type_Long = paramsnh.a();
      }
      return olg.a(paramAdvertisementInfo, (Activity)paramContext, localolj);
    }
  }
  
  public static String a(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo != null))
    {
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo);
        if (paramVideoInfo.has("pop_sheet"))
        {
          paramVideoInfo = new JSONObject(paramVideoInfo.optString("pop_sheet")).getString("h5Url");
          boolean bool = TextUtils.isEmpty(paramVideoInfo);
          if (!bool) {
            return paramVideoInfo;
          }
        }
      }
      catch (Exception paramVideoInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadinJoyActionUtil", 0, "getH5UrlFromPopSheet error:" + paramVideoInfo.getMessage());
        }
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ReadinJoyActionUtil", 0, "getH5UrlFromPopSheet params pop_sheet is empty");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ReadinJoyActionUtil", 0, "getH5UrlFromPopSheet params videoInfo is error");
    }
    return null;
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
  private static omm a(AdvertisementInfo paramAdvertisementInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnull +141 -> 144
    //   6: aload_0
    //   7: getfield 207	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lomq;
    //   10: ifnull +134 -> 144
    //   13: aload_0
    //   14: getfield 207	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lomq;
    //   17: getfield 212	omq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   20: ifnull +124 -> 144
    //   23: aload_0
    //   24: getfield 207	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lomq;
    //   27: getfield 212	omq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   30: invokeinterface 218 1 0
    //   35: iconst_2
    //   36: if_icmplt +108 -> 144
    //   39: aload_0
    //   40: getfield 222	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:clickPos	I
    //   43: bipush 101
    //   45: if_icmpne +20 -> 65
    //   48: aload_0
    //   49: getfield 207	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lomq;
    //   52: getfield 212	omq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   55: iconst_0
    //   56: invokeinterface 226 2 0
    //   61: checkcast 228	omm
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 222	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:clickPos	I
    //   69: bipush 102
    //   71: if_icmpne +71 -> 142
    //   74: aload_0
    //   75: getfield 207	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lomq;
    //   78: getfield 212	omq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   81: iconst_1
    //   82: invokeinterface 226 2 0
    //   87: checkcast 228	omm
    //   90: astore_2
    //   91: aload_2
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: astore_2
    //   98: invokestatic 120	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   101: ifeq -10 -> 91
    //   104: ldc 122
    //   106: iconst_3
    //   107: new 124	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   114: ldc 230
    //   116: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 135	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 142	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload_0
    //   133: areturn
    //   134: astore_2
    //   135: aload_1
    //   136: astore_0
    //   137: aload_2
    //   138: astore_1
    //   139: goto -43 -> 96
    //   142: aload_1
    //   143: areturn
    //   144: aconst_null
    //   145: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramAdvertisementInfo	AdvertisementInfo
    //   1	64	1	localomm	omm
    //   93	43	1	localException1	Exception
    //   138	5	1	localObject1	Object
    //   90	8	2	localObject2	Object
    //   134	4	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   6	39	93	java/lang/Exception
    //   39	65	93	java/lang/Exception
    //   65	91	134	java/lang/Exception
  }
  
  private static onj a(snh paramsnh, String paramString)
  {
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)paramsnh.a();
    int j = localReadInJoyXListView.getFirstVisiblePosition();
    int i = Math.max(localReadInJoyXListView.getHeaderViewsCount(), j);
    int k;
    if (i < paramsnh.a().size() + localReadInJoyXListView.getHeaderViewsCount())
    {
      k = i - localReadInJoyXListView.getHeaderViewsCount();
      BaseArticleInfo localBaseArticleInfo = paramsnh.b(k);
      if ((66 == paramsnh.getItemViewType(k)) && (localBaseArticleInfo != null) && (TextUtils.equals(localBaseArticleInfo.getInnerUniqueID(), paramString)))
      {
        int m = i - j;
        if ((m >= 0) && (m < localReadInJoyXListView.getChildCount())) {
          paramsnh = localReadInJoyXListView.getChildAt(i - j);
        }
      }
    }
    for (;;)
    {
      if ((paramsnh != null) && ((paramsnh.getTag() instanceof onj)))
      {
        return (onj)paramsnh.getTag();
        if ((k >= 0) && (k < paramsnh.a().size())) {
          paramsnh = paramsnh.getView(k, null, localReadInJoyXListView);
        }
      }
      else
      {
        return null;
        i += 1;
        break;
        return null;
      }
      paramsnh = null;
    }
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
    //   10: new 289	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo
    //   13: dup
    //   14: invokespecial 290	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:<init>	()V
    //   17: astore_1
    //   18: aload_1
    //   19: getfield 294	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:advertiser_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   22: aload_0
    //   23: getfield 297	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAdvertiseId	J
    //   26: invokevirtual 303	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   29: aload_0
    //   30: getfield 306	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateLogo	Ljava/lang/String;
    //   33: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifne +14 -> 50
    //   39: aload_1
    //   40: getfield 310	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:corporate_logo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   43: aload_0
    //   44: getfield 306	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateLogo	Ljava/lang/String;
    //   47: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 317	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateImageName	Ljava/lang/String;
    //   54: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +14 -> 71
    //   60: aload_1
    //   61: getfield 320	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:corporate_image_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   64: aload_0
    //   65: getfield 317	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateImageName	Ljava/lang/String;
    //   68: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   71: new 322	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo
    //   74: dup
    //   75: invokespecial 323	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:<init>	()V
    //   78: astore_2
    //   79: aload_0
    //   80: getfield 326	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVideoUrl	Ljava/lang/String;
    //   83: ifnull +14 -> 97
    //   86: aload_2
    //   87: getfield 329	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:video_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   90: aload_0
    //   91: getfield 326	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVideoUrl	Ljava/lang/String;
    //   94: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   97: new 331	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo
    //   100: dup
    //   101: invokespecial 332	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:<init>	()V
    //   104: astore_3
    //   105: aload_3
    //   106: getfield 336	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:advertiser_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo;
    //   109: aload_1
    //   110: invokevirtual 339	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   113: aload_3
    //   114: getfield 343	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:video_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo;
    //   117: aload_2
    //   118: invokevirtual 344	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   121: aload_3
    //   122: getfield 348	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:mini_program_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: aload_0
    //   126: getfield 351	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:miniProgramType	I
    //   129: invokevirtual 356	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   132: new 358	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo
    //   135: dup
    //   136: invokespecial 359	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:<init>	()V
    //   139: astore_1
    //   140: aload_1
    //   141: getfield 362	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:aid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   144: aload_0
    //   145: getfield 365	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAid	J
    //   148: invokevirtual 303	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   151: aload_1
    //   152: getfield 368	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:traceid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   155: aload_0
    //   156: getfield 371	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdTraceId	Ljava/lang/String;
    //   159: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   162: aload_1
    //   163: getfield 374	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:view_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   166: aload_0
    //   167: getfield 377	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdViewId	Ljava/lang/String;
    //   170: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   173: aload_1
    //   174: getfield 380	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:product_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   177: aload_0
    //   178: getfield 383	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductId	Ljava/lang/String;
    //   181: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   184: aload_1
    //   185: getfield 386	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:via	Lcom/tencent/mobileqq/pb/PBStringField;
    //   188: aload_0
    //   189: getfield 389	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVia	Ljava/lang/String;
    //   192: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   195: aload_1
    //   196: getfield 393	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:noco_id	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   199: aload_0
    //   200: getfield 396	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdNocoId	J
    //   203: invokevirtual 399	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   206: new 401	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo
    //   209: dup
    //   210: invokespecial 402	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:<init>	()V
    //   213: astore 4
    //   215: aload 4
    //   217: getfield 405	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:exposure_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   220: aload_0
    //   221: getfield 408	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdApurl	Ljava/lang/String;
    //   224: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   227: aload 4
    //   229: getfield 411	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   232: aload_0
    //   233: getfield 414	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdRl	Ljava/lang/String;
    //   236: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   239: aload 4
    //   241: getfield 417	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:effect_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   244: aload_0
    //   245: getfield 420	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdEffectUrl	Ljava/lang/String;
    //   248: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   251: aload 4
    //   253: getfield 423	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:landing_page_report_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   256: aload_0
    //   257: getfield 426	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdLandingPageReportUrl	Ljava/lang/String;
    //   260: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   263: aload 4
    //   265: getfield 430	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   268: aload_1
    //   269: invokevirtual 431	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   272: new 433	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls
    //   275: dup
    //   276: invokespecial 434	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:<init>	()V
    //   279: astore_1
    //   280: aload_0
    //   281: getfield 437	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SClickUrl	Ljava/util/ArrayList;
    //   284: ifnull +14 -> 298
    //   287: aload_1
    //   288: getfield 441	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:api_click_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   291: aload_0
    //   292: getfield 437	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SClickUrl	Ljava/util/ArrayList;
    //   295: invokevirtual 446	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   298: aload_0
    //   299: getfield 449	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SExposureUrl	Ljava/util/ArrayList;
    //   302: ifnull +14 -> 316
    //   305: aload_1
    //   306: getfield 452	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:api_exposure_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   309: aload_0
    //   310: getfield 449	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SExposureUrl	Ljava/util/ArrayList;
    //   313: invokevirtual 446	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   316: aload_0
    //   317: getfield 455	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SVideoPlayUrl	Ljava/util/ArrayList;
    //   320: ifnull +14 -> 334
    //   323: aload_1
    //   324: getfield 458	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:video_play_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   327: aload_0
    //   328: getfield 455	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SVideoPlayUrl	Ljava/util/ArrayList;
    //   331: invokevirtual 446	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   334: aload 4
    //   336: getfield 462	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:thirdparty_monitor_urls	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls;
    //   339: aload_1
    //   340: invokevirtual 463	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   343: new 465	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo
    //   346: dup
    //   347: invokespecial 466	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:<init>	()V
    //   350: astore 6
    //   352: aload_0
    //   353: getfield 469	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdLandingPage	Ljava/lang/String;
    //   356: astore_2
    //   357: aload_2
    //   358: astore_1
    //   359: aload_0
    //   360: getfield 207	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lomq;
    //   363: ifnull +23 -> 386
    //   366: aload_2
    //   367: astore_1
    //   368: aload_0
    //   369: getfield 207	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lomq;
    //   372: getfield 472	omq:j	I
    //   375: ldc_w 473
    //   378: if_icmpne +8 -> 386
    //   381: aload_2
    //   382: invokestatic 475	ubb:a	(Ljava/lang/String;)Ljava/lang/String;
    //   385: astore_1
    //   386: aload 6
    //   388: getfield 478	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:landing_page	Lcom/tencent/mobileqq/pb/PBStringField;
    //   391: aload_1
    //   392: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   395: aload 6
    //   397: getfield 481	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:canvas_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   400: aload_0
    //   401: getfield 484	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCanvasJson	Ljava/lang/String;
    //   404: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   407: aload 6
    //   409: getfield 487	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:dest_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   412: aload_0
    //   413: getfield 490	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdDestType	I
    //   416: invokevirtual 356	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   419: new 492	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo
    //   422: dup
    //   423: invokespecial 493	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:<init>	()V
    //   426: astore 5
    //   428: aload_0
    //   429: getfield 496	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   432: invokestatic 501	com/tencent/gdtad/aditem/GdtBaseAdItem:a	(Ljava/lang/String;)Lcom/tencent/gdtad/aditem/GdtBaseAdItem;
    //   435: astore_1
    //   436: aload 5
    //   438: getfield 504	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:app_package_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   441: aload_1
    //   442: getfield 506	com/tencent/gdtad/aditem/GdtBaseAdItem:a	Ljava/lang/String;
    //   445: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   448: new 90	org/json/JSONObject
    //   451: dup
    //   452: aload_0
    //   453: getfield 496	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   456: invokespecial 93	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   459: astore_2
    //   460: aload_2
    //   461: ldc_w 508
    //   464: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   467: astore_1
    //   468: aload_2
    //   469: ldc_w 510
    //   472: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   475: astore_2
    //   476: aload_1
    //   477: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   480: ifne +12 -> 492
    //   483: aload 5
    //   485: getfield 513	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:pkg_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   488: aload_1
    //   489: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   492: aload_2
    //   493: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   496: ifne +12 -> 508
    //   499: aload 5
    //   501: getfield 516	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:app_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   504: aload_2
    //   505: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   508: aload 5
    //   510: getfield 519	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:android_app_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   513: aload_0
    //   514: getfield 383	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductId	Ljava/lang/String;
    //   517: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   520: aload 5
    //   522: getfield 522	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:pkg_download_schema	Lcom/tencent/mobileqq/pb/PBStringField;
    //   525: aload_0
    //   526: getfield 525	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAppDownLoadSchema	Ljava/lang/String;
    //   529: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   532: aload 5
    //   534: getfield 528	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:customized_invoke_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   537: aload_0
    //   538: getfield 531	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCustomizedInvokeUrl	Ljava/lang/String;
    //   541: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   544: invokestatic 120	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   547: ifeq +32 -> 579
    //   550: ldc 122
    //   552: iconst_0
    //   553: new 124	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   560: ldc_w 533
    //   563: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload_0
    //   567: getfield 536	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   570: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 538	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: aload 5
    //   581: getfield 541	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:channel_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   584: astore_2
    //   585: aload_0
    //   586: getfield 536	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   589: ifnonnull +349 -> 938
    //   592: ldc 151
    //   594: astore_1
    //   595: aload_2
    //   596: aload_1
    //   597: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   600: aload_0
    //   601: invokestatic 547	oqj:g	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   604: ifeq +38 -> 642
    //   607: aload_0
    //   608: getfield 207	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lomq;
    //   611: getfield 212	omq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   614: ifnull +28 -> 642
    //   617: aload_0
    //   618: getfield 207	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lomq;
    //   621: getfield 212	omq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   624: invokeinterface 218 1 0
    //   629: iconst_2
    //   630: if_icmplt +12 -> 642
    //   633: aload_0
    //   634: invokestatic 549	ubb:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lomm;
    //   637: astore_1
    //   638: aload_1
    //   639: ifnonnull +307 -> 946
    //   642: new 551	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   645: dup
    //   646: invokespecial 552	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   649: astore_1
    //   650: aload_1
    //   651: getfield 555	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:product_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   654: aload_0
    //   655: getfield 558	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductType	I
    //   658: invokevirtual 356	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   661: aload_1
    //   662: getfield 562	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:display_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo;
    //   665: aload_3
    //   666: invokevirtual 563	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   669: aload_1
    //   670: getfield 567	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   673: aload 4
    //   675: invokevirtual 568	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   678: aload_1
    //   679: getfield 572	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:dest_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo;
    //   682: aload 6
    //   684: invokevirtual 573	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   687: new 575	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo
    //   690: dup
    //   691: invokespecial 576	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:<init>	()V
    //   694: astore_2
    //   695: aload_0
    //   696: getfield 88	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   699: astore_3
    //   700: aload_3
    //   701: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   704: ifne +93 -> 797
    //   707: new 90	org/json/JSONObject
    //   710: dup
    //   711: aload_3
    //   712: invokespecial 93	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   715: astore_3
    //   716: aload_2
    //   717: getfield 579	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:ad_trace_data	Lcom/tencent/mobileqq/pb/PBStringField;
    //   720: aload_3
    //   721: ldc_w 581
    //   724: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   727: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   730: aload_2
    //   731: getfield 584	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   734: aload_3
    //   735: ldc_w 586
    //   738: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   741: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   744: aload_2
    //   745: getfield 589	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   748: aload_3
    //   749: ldc_w 591
    //   752: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   755: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   758: aload_2
    //   759: getfield 594	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_token	Lcom/tencent/mobileqq/pb/PBStringField;
    //   762: aload_3
    //   763: ldc_w 596
    //   766: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   769: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   772: aload_2
    //   773: getfield 599	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_username	Lcom/tencent/mobileqq/pb/PBStringField;
    //   776: aload_3
    //   777: ldc_w 601
    //   780: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   783: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   786: aload_2
    //   787: getfield 604	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:pos_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   790: aload_0
    //   791: getfield 607	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdPosID	J
    //   794: invokevirtual 303	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   797: aload_1
    //   798: getfield 611	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:wechat_app_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo;
    //   801: aload_2
    //   802: invokevirtual 612	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   805: aload_1
    //   806: getfield 616	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:app_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo;
    //   809: aload 5
    //   811: invokevirtual 617	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   814: aload_0
    //   815: getfield 496	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   818: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   821: ifne +180 -> 1001
    //   824: new 90	org/json/JSONObject
    //   827: dup
    //   828: aload_0
    //   829: getfield 496	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   832: invokespecial 93	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   835: ldc_w 619
    //   838: ldc 151
    //   840: invokevirtual 622	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   843: astore_0
    //   844: invokestatic 120	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   847: ifeq +29 -> 876
    //   850: ldc 122
    //   852: iconst_0
    //   853: new 124	java/lang/StringBuilder
    //   856: dup
    //   857: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   860: ldc_w 624
    //   863: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: aload_0
    //   867: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokestatic 538	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   876: aload_1
    //   877: getfield 627	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:ext_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   880: aload_0
    //   881: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   884: aload_1
    //   885: areturn
    //   886: astore_2
    //   887: aload_1
    //   888: astore_0
    //   889: invokestatic 120	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   892: ifeq -884 -> 8
    //   895: ldc 122
    //   897: iconst_0
    //   898: new 124	java/lang/StringBuilder
    //   901: dup
    //   902: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   905: ldc_w 629
    //   908: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: aload_2
    //   912: invokevirtual 135	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   915: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   921: invokestatic 538	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   924: aload_1
    //   925: areturn
    //   926: astore_2
    //   927: aconst_null
    //   928: astore_1
    //   929: aload_2
    //   930: invokevirtual 630	java/lang/Exception:printStackTrace	()V
    //   933: aconst_null
    //   934: astore_2
    //   935: goto -459 -> 476
    //   938: aload_0
    //   939: getfield 536	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   942: astore_1
    //   943: goto -348 -> 595
    //   946: aload_1
    //   947: getfield 632	omm:b	Ljava/lang/String;
    //   950: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   953: ifne +15 -> 968
    //   956: aload 4
    //   958: getfield 411	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   961: aload_1
    //   962: getfield 632	omm:b	Ljava/lang/String;
    //   965: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   968: aload_1
    //   969: getfield 633	omm:a	Ljava/lang/String;
    //   972: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   975: ifne -333 -> 642
    //   978: aload 6
    //   980: getfield 478	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:landing_page	Lcom/tencent/mobileqq/pb/PBStringField;
    //   983: aload_1
    //   984: getfield 633	omm:a	Ljava/lang/String;
    //   987: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   990: goto -348 -> 642
    //   993: astore_3
    //   994: aload_3
    //   995: invokevirtual 154	org/json/JSONException:printStackTrace	()V
    //   998: goto -201 -> 797
    //   1001: aload_1
    //   1002: getfield 627	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:ext_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1005: ldc 151
    //   1007: invokevirtual 314	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   1010: aload_1
    //   1011: astore_0
    //   1012: invokestatic 120	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1015: ifeq -1007 -> 8
    //   1018: ldc 122
    //   1020: iconst_0
    //   1021: ldc_w 635
    //   1024: invokestatic 538	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1027: aload_1
    //   1028: areturn
    //   1029: astore_2
    //   1030: goto -101 -> 929
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1033	0	paramAdvertisementInfo	AdvertisementInfo
    //   1	1027	1	localObject1	Object
    //   78	724	2	localObject2	Object
    //   886	26	2	localException1	Exception
    //   926	4	2	localException2	Exception
    //   934	1	2	localObject3	Object
    //   1029	1	2	localException3	Exception
    //   104	673	3	localObject4	Object
    //   993	2	3	localJSONException	JSONException
    //   213	744	4	localReportInfo	qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo
    //   426	384	5	localAppInfo	tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo
    //   350	629	6	localDestInfo	tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo
    // Exception table:
    //   from	to	target	type
    //   824	876	886	java/lang/Exception
    //   876	884	886	java/lang/Exception
    //   448	468	926	java/lang/Exception
    //   707	797	993	org/json/JSONException
    //   468	476	1029	java/lang/Exception
  }
  
  public static void a()
  {
    if ((BaseApplicationImpl.getContext() != null) && (jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver != null))
    {
      BaseApplicationImpl.getContext().unregisterReceiver(jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = null;
    }
  }
  
  public static void a(int paramInt, GdtHandler.Params paramParams, long paramLong)
  {
    if ((paramParams == null) || (paramLong == -2147483648L)) {}
    do
    {
      return;
      if ((paramParams == null) || (paramLong == -2147483648L))
      {
        acqy.d("ReadinJoyActionUtil", " enterTimeMillis:" + paramLong + " gdtParams:" + paramParams);
        return;
      }
    } while ((paramInt != 0) && (paramInt != 3) && (paramInt != 56) && (paramInt != 2));
    long l = SystemClock.elapsedRealtime();
    acqy.b("ReadinJoyActionUtil", String.format("leave %d", new Object[] { Long.valueOf(l) }));
    if (paramLong == -2147483648L) {
      acqy.d("ReadinJoyActionUtil", "leave error");
    }
    paramLong = l - paramLong;
    acqy.b("ReadinJoyActionUtil", String.format("dwell %d", new Object[] { Long.valueOf(paramLong) }));
    acrd localacrd = new acrd();
    localacrd.jdField_a_of_type_ComTencentAdTangramAd = paramParams.a;
    localacrd.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(42);
    localacrd.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(paramLong);
    acrc.a(localacrd);
  }
  
  public static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("param_ad_info", paramAdvertisementInfo);
    ReadinjoyAdPKFragment.a(paramActivity, ReadinjoyAdPKFragment.class, localBundle);
  }
  
  private static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, snh paramsnh, int paramInt, boolean paramBoolean)
  {
    if ((paramsnh != null) && (paramBoolean)) {
      a(paramActivity, paramAdvertisementInfo, paramInt);
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
    if (paramsnh != null) {
      localBundle.putLong("param_ad_app_info_video_playposition", paramsnh.a());
    }
    a(paramActivity);
    ReadInJoyNativeAdAppFragment.a(paramActivity, ReadInJoyNativeAdAppFragment.class, localBundle);
  }
  
  public static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, snh paramsnh, int paramInt, boolean paramBoolean, oml paramoml)
  {
    paramoml = a(paramActivity, paramAdvertisementInfo, paramsnh, paramInt, paramBoolean, paramoml);
    if (((paramAdvertisementInfo instanceof AdvertisementInfo)) && (paramoml != null))
    {
      paramoml.d = true;
      paramoml.c = true;
      if (a(paramoml, paramActivity, paramAdvertisementInfo)) {
        return;
      }
    }
    Object localObject = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).aid.set(paramAdvertisementInfo.mAdAid);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).traceid.set(paramAdvertisementInfo.mAdTraceId);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).view_id.set(paramAdvertisementInfo.mAdViewId);
    paramoml = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    paramoml.exposure_url.set(paramAdvertisementInfo.mAdApurl);
    paramoml.click_url.set(paramAdvertisementInfo.mAdRl);
    paramoml.trace_info.set((MessageMicro)localObject);
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.set(paramoml);
    GdtAd localGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    localObject = paramAdvertisementInfo.mAdLandingPage;
    paramoml = (oml)localObject;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramoml = Uri.parse((String)localObject).buildUpon();
      if ((bgnt.b(BaseApplicationImpl.getApplication()) != 1) || (paramInt == 0)) {
        break label354;
      }
      paramoml.appendQueryParameter("autodownload", "1");
    }
    for (;;)
    {
      paramoml = paramoml.toString();
      localObject = new GdtVideoCeilingData();
      ((GdtVideoCeilingData)localObject).setVideoData(localGdtVideoData);
      ((GdtVideoCeilingData)localObject).setAd(localGdtAd);
      ((GdtVideoCeilingData)localObject).setWebUrl(paramoml);
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
      a(paramActivity, paramAdvertisementInfo, paramsnh, 0, null);
      return;
      label354:
      paramoml.appendQueryParameter("autodownload", "0");
    }
    a(paramActivity, paramAdvertisementInfo, paramsnh, 0, false);
    return;
    label378:
    if (paramInt == 5)
    {
      b(paramActivity, paramAdvertisementInfo, paramsnh, 0, false);
      return;
    }
    if (((GdtVideoCeilingData)localObject).getStyle() == -2147483648) {
      ((GdtVideoCeilingData)localObject).setStyle(1);
    }
    paramAdvertisementInfo = new Bundle();
    paramAdvertisementInfo.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    ReadInJoyVideoCeilingFragment.a(paramActivity, ReadInJoyVideoCeilingFragment.class, (GdtVideoCeilingData)localObject, paramAdvertisementInfo);
  }
  
  public static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, snh paramsnh, int paramInt, boolean paramBoolean1, boolean paramBoolean2, oml paramoml)
  {
    Object localObject = a(paramActivity, paramAdvertisementInfo, paramsnh, paramInt, paramBoolean1, paramoml);
    if (((paramAdvertisementInfo instanceof AdvertisementInfo)) && (localObject != null))
    {
      ((GdtHandler.Params)localObject).f = paramBoolean2;
      if (paramoml == null)
      {
        ((GdtHandler.Params)localObject).d = false;
        ((GdtHandler.Params)localObject).c = false;
      }
      if (a((GdtHandler.Params)localObject, paramActivity, paramAdvertisementInfo)) {
        return;
      }
    }
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).aid.set(paramAdvertisementInfo.mAdAid);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).traceid.set(paramAdvertisementInfo.mAdTraceId);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).view_id.set(paramAdvertisementInfo.mAdViewId);
    paramoml = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    paramoml.exposure_url.set(paramAdvertisementInfo.mAdApurl);
    paramoml.click_url.set(paramAdvertisementInfo.mAdRl);
    paramoml.trace_info.set((MessageMicro)localObject);
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.set(paramoml);
    GdtAd localGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setDirectPlay(paramBoolean2);
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    localObject = paramAdvertisementInfo.mAdLandingPage;
    paramoml = (oml)localObject;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramoml = Uri.parse((String)localObject).buildUpon();
      if ((bgnt.b(BaseApplicationImpl.getApplication()) != 1) || (paramInt == 0)) {
        break label373;
      }
      paramoml.appendQueryParameter("autodownload", "1");
    }
    for (;;)
    {
      paramoml = paramoml.toString();
      localObject = new GdtVideoCeilingData();
      ((GdtVideoCeilingData)localObject).setVideoData(localGdtVideoData);
      ((GdtVideoCeilingData)localObject).setAd(localGdtAd);
      ((GdtVideoCeilingData)localObject).setWebUrl(paramoml);
      paramInt = paramAdvertisementInfo.mAdJumpMode;
      if (QLog.isColorLevel()) {
        QLog.d("ReadinJoyActionUtil", 0, "jump mode = " + paramInt);
      }
      if (paramInt != 4) {
        break label397;
      }
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdAppJson)) {
        break;
      }
      a(paramActivity, paramAdvertisementInfo, paramsnh, 0, null);
      return;
      label373:
      paramoml.appendQueryParameter("autodownload", "0");
    }
    a(paramActivity, paramAdvertisementInfo, paramsnh, 0, false);
    return;
    label397:
    if (paramInt == 5)
    {
      b(paramActivity, paramAdvertisementInfo, paramsnh, 0, false);
      return;
    }
    if (((GdtVideoCeilingData)localObject).getStyle() == -2147483648) {
      ((GdtVideoCeilingData)localObject).setStyle(1);
    }
    paramAdvertisementInfo = new Bundle();
    paramAdvertisementInfo.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    ReadInJoyVideoCeilingFragment.a(paramActivity, ReadInJoyVideoCeilingFragment.class, (GdtVideoCeilingData)localObject, paramAdvertisementInfo);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, snh paramsnh, int paramInt)
  {
    Object localObject2 = pha.d(paramArticleInfo);
    int i;
    int j;
    label32:
    int k;
    label45:
    Object localObject3;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label622;
      }
      j = 0;
      if (paramArticleInfo.videoJumpChannelID <= 0) {
        break label628;
      }
      k = paramArticleInfo.videoJumpChannelID;
      oat.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pha.b(paramArticleInfo.mAlgorithmID, pha.a(paramArticleInfo), paramInt, i), false);
      oat.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pha.b(paramArticleInfo.mAlgorithmID, pha.a(paramArticleInfo), paramInt, i));
      localObject3 = ube.b(paramArticleInfo.mChannelID);
      if ((!snh.i(paramArticleInfo)) && (!snh.g(paramArticleInfo)) && (!snh.j(paramArticleInfo)) && (!snh.k(paramArticleInfo))) {
        break label635;
      }
      oat.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.jdField_a_of_type_Long), (String)localObject3, (String)localObject3, 0, 0, Long.toString(paramArticleInfo.mFeedId), paramArticleInfo.businessId + "", Integer.toString(paramArticleInfo.mStrategyId), pha.a(paramArticleInfo.mAlgorithmID, pha.a(paramArticleInfo), paramInt, i, j, bgnt.h(paramActivity), String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha.jdField_a_of_type_Long), paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pha.f(paramArticleInfo), k, paramArticleInfo), false);
    }
    Object localObject1;
    for (;;)
    {
      oat.a((String)localObject3, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pha.a(paramArticleInfo.mAlgorithmID, pha.a(paramArticleInfo), paramInt, i, j, bgnt.h(paramActivity), (String)localObject2, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pha.f(paramArticleInfo), k, paramArticleInfo));
      paramsnh = new ArrayList();
      localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = pha.a();
      ((ReportInfo)localObject1).mSource = 0;
      ((ReportInfo)localObject1).mSourceArticleId = paramArticleInfo.mArticleID;
      ((ReportInfo)localObject1).mChannelId = paramInt;
      ((ReportInfo)localObject1).mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject1).mStrategyId = paramArticleInfo.mStrategyId;
      ((ReportInfo)localObject1).mOperation = 1;
      ((ReportInfo)localObject1).mServerContext = paramArticleInfo.mServerContext;
      ((ReportInfo)localObject1).mReadTimeLength = -1;
      ((ReportInfo)localObject1).mInnerId = paramArticleInfo.innerUniqueID;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label753;
      }
      localObject2 = new rgh();
      ((rgh)localObject2).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha != null) {
        ((rgh)localObject2).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha.jdField_a_of_type_Long;
      }
      ((rgh)localObject2).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((rgh)localObject2).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.d;
      localObject3 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject3 == null) || (((List)localObject3).isEmpty())) {
        break label746;
      }
      ((rgh)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        rha localrha = (rha)((Iterator)localObject3).next();
        if (localrha != null) {
          ((rgh)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localrha.jdField_a_of_type_Long));
        }
      }
      i = 0;
      break;
      label622:
      j = 1;
      break label32;
      label628:
      k = 56;
      break label45;
      label635:
      localObject1 = pha.a(paramArticleInfo.mAlgorithmID, pha.a(paramArticleInfo), paramInt, i, j, bgnt.h(paramActivity), (String)localObject2, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pha.f(paramArticleInfo), k, paramArticleInfo);
      paramsnh = (snh)localObject1;
      if (paramInt == 0) {
        paramsnh = och.a(k, (String)och.a.get(ReadInJoyChannelActivity.class), (String)localObject1);
      }
      oat.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject3, (String)localObject3, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), paramsnh, false);
    }
    label746:
    ((ReportInfo)localObject1).mFeedsReportData = ((rgh)localObject2);
    label753:
    paramsnh.add(localObject1);
    pmh.a().a(paramsnh);
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (paramArticleInfo.mChannelID == 56L) {
        nxw.a(new omp().a(paramActivity).a(nxw.jdField_a_of_type_Int).b(nxw.W).a((AdvertisementInfo)paramArticleInfo).d(((AdvertisementInfo)paramArticleInfo).clickPos).a());
      }
    }
    else {
      return;
    }
    if ((oqj.l((AdvertisementInfo)paramArticleInfo)) && (oqr.jdField_a_of_type_Boolean)) {
      paramInt = nxw.ap;
    }
    for (;;)
    {
      nxw.a(new omp().a(paramActivity).a(nxw.jdField_a_of_type_Int).b(paramInt).a((AdvertisementInfo)paramArticleInfo).d(((AdvertisementInfo)paramArticleInfo).clickPos).a());
      return;
      if (a((AdvertisementInfo)paramArticleInfo, paramInt)) {
        paramInt = nxw.T;
      } else if (pha.a(paramArticleInfo)) {
        paramInt = nxw.S;
      } else {
        paramInt = nxw.N;
      }
    }
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, snh paramsnh, int paramInt, oml paramoml)
  {
    GdtHandler.Params localParams;
    if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
    {
      a(paramActivity, paramArticleInfo, paramInt);
      if (paramInt == 0)
      {
        pmh.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (paramsnh != null) {
          paramsnh.notifyDataSetChanged();
        }
      }
      localParams = a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramsnh, paramInt, true, paramoml);
      if (!a(localParams, paramActivity, (AdvertisementInfo)paramArticleInfo))
      {
        paramoml = paramArticleInfo.mArticleContentUrl;
        if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) || (!oqj.g((AdvertisementInfo)paramArticleInfo))) {
          break label366;
        }
        paramsnh = a((AdvertisementInfo)paramArticleInfo);
        if (paramsnh == null) {
          break label372;
        }
      }
    }
    label342:
    label366:
    label372:
    for (paramsnh = paramsnh.a;; paramsnh = "")
    {
      if (!TextUtils.isEmpty(paramsnh)) {}
      for (;;)
      {
        paramoml = paramsnh;
        if (AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo))
        {
          paramoml = paramsnh;
          if (bgnt.h(null)) {
            if (!paramsnh.contains("?")) {
              break label342;
            }
          }
        }
        for (paramArticleInfo = paramsnh + "&";; paramArticleInfo = paramsnh + "?")
        {
          paramoml = paramArticleInfo + "acttype=42";
          a(paramActivity);
          paramArticleInfo = new Intent(paramActivity, QQBrowserActivity.class);
          paramArticleInfo.putExtra("startOpenPageTime", System.currentTimeMillis());
          paramArticleInfo.putExtra("url", paramoml);
          paramArticleInfo.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
          if ((localParams != null) && (localParams.a != null))
          {
            if (localParams.a.getNocoId() != 0L) {
              paramArticleInfo.putExtra("GdtNocoId", localParams.a.getNocoId());
            }
            if (!TextUtils.isEmpty(localParams.a.getUrlForEffect())) {
              paramArticleInfo.putExtra("GdtWebReportQQ_ACTION_URL", localParams.a.getUrlForAction());
            }
            if (!TextUtils.isEmpty(localParams.a.getTraceId())) {
              paramArticleInfo.putExtra("GdtWebReportQQ_TRACE_ID", localParams.a.getTraceId());
            }
          }
          paramActivity.startActivity(paramArticleInfo);
          return;
        }
        paramsnh = paramoml;
      }
    }
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, snh paramsnh, int paramInt, boolean paramBoolean, oml paramoml)
  {
    if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) || (!(paramArticleInfo instanceof AdvertisementInfo))) {}
    do
    {
      return;
      switch (((AdvertisementInfo)paramArticleInfo).mAdJumpMode)
      {
      default: 
        return;
      case 0: 
      case 1: 
      case 6: 
      case 7: 
        a(paramActivity, paramArticleInfo, paramsnh, paramInt, paramoml);
        return;
      case 2: 
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramsnh, paramInt, paramBoolean, paramoml);
        return;
      case 4: 
        if (TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdAppJson))
        {
          a(paramActivity, paramArticleInfo, paramsnh, paramInt, paramoml);
          return;
        }
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramsnh, paramInt, true);
        return;
      case 3: 
        int i = ((AdvertisementInfo)paramArticleInfo).clickPos;
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, null, paramInt, paramBoolean, paramoml);
        ((AdvertisementInfo)paramArticleInfo).clickPos = i;
        a(paramActivity, paramArticleInfo, paramsnh, paramInt);
        pmh.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      }
    } while (paramsnh == null);
    paramsnh.notifyDataSetChanged();
    return;
    b(paramActivity, (AdvertisementInfo)paramArticleInfo, paramsnh, paramInt, true);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, snh paramsnh, int paramInt, boolean paramBoolean1, boolean paramBoolean2, oml paramoml)
  {
    if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) || (!(paramArticleInfo instanceof AdvertisementInfo))) {
      return;
    }
    if (paramoml == null) {
      paramoml = new oml();
    }
    for (;;)
    {
      if ((((AdvertisementInfo)paramArticleInfo).mAdProductType == 6) && (a(paramActivity, 2086, paramArticleInfo)))
      {
        a(paramActivity, paramArticleInfo, paramInt);
        if (paramInt != 0) {
          break;
        }
        pmh.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (paramsnh == null) {
          break;
        }
        paramsnh.notifyDataSetChanged();
        return;
      }
      switch (((AdvertisementInfo)paramArticleInfo).mAdJumpMode)
      {
      default: 
        return;
      case 0: 
      case 1: 
      case 6: 
      case 7: 
        a(paramActivity, paramArticleInfo, paramsnh, paramInt, paramoml);
        return;
      case 2: 
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramsnh, paramInt, paramBoolean1, paramoml);
        return;
      case 4: 
        if (TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdAppJson))
        {
          a(paramActivity, paramArticleInfo, paramsnh, paramInt, null);
          return;
        }
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramsnh, paramInt, true);
        return;
      case 3: 
        paramoml.jdField_a_of_type_Boolean = a(paramArticleInfo, paramsnh);
        int i = ((AdvertisementInfo)paramArticleInfo).clickPos;
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramsnh, paramInt, paramBoolean1, paramBoolean2, paramoml);
        ((AdvertisementInfo)paramArticleInfo).clickPos = i;
        a(paramActivity, paramArticleInfo, paramsnh, paramInt);
        pmh.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (paramsnh == null) {
          break;
        }
        paramsnh.notifyDataSetChanged();
        return;
      case 5: 
        b(paramActivity, (AdvertisementInfo)paramArticleInfo, paramsnh, paramInt, true);
        return;
      }
    }
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
      bies.a(paramContext, 7);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadinJoyActionUtil", 0, "closeFloatWindow error:" + paramContext.getMessage());
    }
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, snh paramsnh, int paramInt, boolean paramBoolean, oml paramoml)
  {
    int i = paramAdvertisementInfo.clickPos;
    a(paramContext, paramAdvertisementInfo, paramsnh, paramInt, paramBoolean, paramoml);
    if (i >= 0) {
      paramAdvertisementInfo.setClickPos(i);
    }
    a(paramContext, paramAdvertisementInfo, paramInt);
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, snh paramsnh, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramAdvertisementInfo.clickPos;
    a(paramContext, paramAdvertisementInfo, paramsnh, paramInt, paramBoolean1, paramBoolean2);
    if (i >= 0) {
      paramAdvertisementInfo.setClickPos(i);
    }
    a(paramContext, paramAdvertisementInfo, paramInt);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    int i;
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (paramArticleInfo.mChannelID != 56L) {
        break label30;
      }
      i = nxw.O;
    }
    for (;;)
    {
      a(paramContext, paramArticleInfo, paramInt, i);
      label30:
      do
      {
        return;
        if ((oqj.l((AdvertisementInfo)paramArticleInfo)) && (oqr.jdField_a_of_type_Boolean))
        {
          i = nxw.ap;
          break;
        }
        if (pha.a(paramArticleInfo))
        {
          i = nxw.S;
          break;
        }
      } while ((oqj.g((AdvertisementInfo)paramArticleInfo)) && (((AdvertisementInfo)paramArticleInfo).isClickFromPkFragment));
      if (a((AdvertisementInfo)paramArticleInfo, paramInt)) {
        i = nxw.T;
      } else if (((AdvertisementInfo)paramArticleInfo).isCommentAd()) {
        i = nxw.aq;
      } else {
        i = nxw.N;
      }
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      nxw.a(new omp().a(paramContext).a(nxw.jdField_a_of_type_Int).b(paramInt2).a((AdvertisementInfo)paramArticleInfo).e(new JSONObject()).a());
      b(paramContext, paramArticleInfo, paramInt1);
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, snh paramsnh, int paramInt)
  {
    if ((paramsnh != null) && (paramArticleInfo != null) && ((paramArticleInfo instanceof AdvertisementInfo)) && ((paramContext instanceof Activity)))
    {
      paramsnh.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = a(paramContext, (AdvertisementInfo)paramArticleInfo, paramsnh, paramInt, false, null);
      if (paramsnh.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params == null) {
        break label57;
      }
    }
    label57:
    for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
    {
      paramsnh.jdField_a_of_type_Long = l;
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
  
  public static void a(ViewBase paramViewBase1, ViewBase paramViewBase2, Activity paramActivity, ArticleInfo paramArticleInfo, snh paramsnh, int paramInt1, int paramInt2)
  {
    if ((paramViewBase2 == null) || (paramActivity == null) || (paramArticleInfo == null)) {
      break label12;
    }
    label12:
    while (!(paramArticleInfo instanceof AdvertisementInfo)) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramArticleInfo;
    a(paramActivity, localAdvertisementInfo, paramsnh, paramInt1);
    if ((paramInt2 == 6) && ((paramsnh == null) || (paramsnh.a() == null) || (!paramsnh.a().b()))) {}
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
        oqj.a(localAdvertisementInfo, i, null);
        paramViewBase2 = null;
        if (paramsnh != null) {
          paramViewBase2 = paramsnh.a();
        }
        if ((oqj.g((AdvertisementInfo)paramArticleInfo)) && ((paramInt2 == 4) || (paramInt2 == 3) || (paramInt2 == 1)))
        {
          if (paramInt2 == 1) {
            i = 3;
          }
          oqj.a(paramActivity, 1);
          a(paramActivity);
          a(paramActivity, (AdvertisementInfo)paramArticleInfo);
          nxw.a(new omp().a(paramActivity).a(nxw.jdField_a_of_type_Int).b(nxw.ak).a((AdvertisementInfo)paramArticleInfo).d(i).a());
          return;
        }
        if (a(paramArticleInfo, paramViewBase1, paramActivity, paramInt1, paramViewBase2, localAdvertisementInfo)) {
          break;
        }
        boolean bool2 = true;
        if ((paramInt2 != 6) && (paramInt2 != 5) && ((paramsnh == null) || ((paramInt1 != 0) && (!pil.b(paramInt1))) || ((snh.a(localAdvertisementInfo, paramInt1) != 104) && (snh.a(localAdvertisementInfo, paramInt1) != 105))))
        {
          bool1 = bool2;
          if (j != 0) {
            break label320;
          }
          if (paramInt2 != 101)
          {
            bool1 = bool2;
            if (paramInt2 != 102) {
              break label320;
            }
          }
        }
        boolean bool1 = false;
        label320:
        paramViewBase1 = new oml();
        if (paramInt2 == 8) {
          paramViewBase1.c = true;
        }
        if (a(paramActivity, paramsnh, paramArticleInfo)) {
          break;
        }
        a(paramActivity, localAdvertisementInfo, paramsnh, paramInt1, bool1, oqi.b((AdvertisementInfo)paramArticleInfo), paramViewBase1);
        oqr.a().b(4);
        return;
      }
    }
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
  
  public static void a(rwy paramrwy)
  {
    a(3, paramrwy.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, paramrwy.jdField_a_of_type_Long);
    paramrwy.jdField_a_of_type_Long = -2147483648L;
    paramrwy.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
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
  
  public static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramContext == null) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage))) {}
    while (!oqj.m(paramAdvertisementInfo)) {
      return false;
    }
    pha.d(paramContext, paramAdvertisementInfo.mAdLandingPage);
    return true;
  }
  
  public static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, snh paramsnh, int paramInt, boolean paramBoolean)
  {
    paramsnh = a(paramContext, paramAdvertisementInfo, paramsnh, paramInt, paramBoolean, null);
    if (paramsnh == null) {
      return false;
    }
    return b(paramsnh, paramContext, paramAdvertisementInfo);
  }
  
  public static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, snh paramsnh, int paramInt, boolean paramBoolean, oml paramoml)
  {
    paramsnh = a(paramContext, paramAdvertisementInfo, paramsnh, paramInt, paramBoolean, paramoml);
    if (paramsnh == null) {
      return false;
    }
    return b(paramsnh, paramContext, paramAdvertisementInfo);
  }
  
  public static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, snh paramsnh, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramsnh = a(paramContext, paramAdvertisementInfo, paramsnh, paramInt, paramBoolean1, null);
    if (paramsnh == null) {
      return false;
    }
    paramsnh.f = paramBoolean2;
    return b(paramsnh, paramContext, paramAdvertisementInfo);
  }
  
  public static boolean a(Context paramContext, AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramContext == null) || (!(paramContext instanceof Activity)) || (paramAdData == null) || (paramAdvertisementInfo == null)) {}
    while (!opz.a(paramAdData)) {
      return false;
    }
    a(paramContext);
    oqj.b(paramAdvertisementInfo);
    opz.a(paramContext, paramAdData);
    paramContext = (QQAppInterface)pha.a();
    nxw.a(new omp().a(paramContext).a(BaseApplication.getContext()).a(nxw.jdField_a_of_type_Int).b(nxw.ae).a(paramAdvertisementInfo).d(nxw.a(paramAdData)).a());
    return true;
  }
  
  private static boolean a(Context paramContext, snh paramsnh, ArticleInfo paramArticleInfo)
  {
    if ((paramsnh == null) || (paramsnh.a() != 0)) {}
    onj localonj;
    do
    {
      do
      {
        return false;
      } while (!TextUtils.isEmpty(a(paramArticleInfo, "AdsIconText")));
      pha.a(paramArticleInfo);
      paramArticleInfo.innerUniqueID = a(paramArticleInfo, "landing_page_rowkey");
      localonj = a(paramsnh, paramArticleInfo.innerUniqueID);
    } while (localonj == null);
    a(paramContext, paramArticleInfo, paramsnh.a());
    paramsnh.a(localonj.a(), paramArticleInfo);
    return true;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null) {
      QLog.e("ReadinJoyActionUtil", 3, "JumpToGdtAdPage error advertisementInfo is null");
    }
    do
    {
      do
      {
        return false;
      } while (!(paramAdvertisementInfo instanceof AdvertisementInfo));
      if ((paramInt != 0) || (!TextUtils.isEmpty(a(paramAdvertisementInfo, "AdsIconText")))) {
        break;
      }
    } while (!oqp.b(paramAdvertisementInfo));
    return true;
    if ((paramInt == 2) || (paramInt == 5) || (paramInt == 3) || (paramInt == 56) || (paramInt == 4) || (paramInt == 2000001) || (paramInt == 95555552) || ((oqj.a(paramInt)) && (!a(paramAdvertisementInfo.mAdJumpMode)) && (jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramAdvertisementInfo.mAdProductType)))) || (oqp.b(paramAdvertisementInfo))) {
      return true;
    }
    QLog.e("ReadinJoyActionUtil", 3, "readInjoy product not go Gdt QQB channelId:" + paramInt + " AdProductType:" + paramAdvertisementInfo.mAdProductType);
    return false;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, Context paramContext)
  {
    if ((AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (!oqj.c(paramAdvertisementInfo))) {}
    while ((paramAdvertisementInfo.mAdProductType == 30) || (paramAdvertisementInfo.mAdProductType == 41) || (((paramAdvertisementInfo.mAdProductType == 1000) || (paramAdvertisementInfo.mAdProductType == 25)) && (!a(paramAdvertisementInfo.mAdCustomizedInvokeUrl, paramContext)))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    return (jdField_a_of_type_Boolean) && (paramArticleInfo != null) && ((paramArticleInfo instanceof AdvertisementInfo)) && (((AdvertisementInfo)paramArticleInfo).mAdFeedId != 0L) && (!TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdInteractionReportUrl));
  }
  
  public static boolean a(ArticleInfo paramArticleInfo, ViewBase paramViewBase, Activity paramActivity, int paramInt, seu paramseu, AdvertisementInfo paramAdvertisementInfo)
  {
    Object localObject1;
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
          a(paramActivity, paramArticleInfo, paramInt, nxw.ai);
          return true;
        }
      }
      localObject1 = null;
      if (paramAdvertisementInfo.mImaxShowAdType == 1002)
      {
        localObject2 = paramViewBase.findViewBaseByName("id_article_double_image");
        if (localObject2 != null) {
          localObject1 = ((ViewBase)localObject2).getNativeView();
        }
      }
    }
    for (;;)
    {
      ((AdvertisementInfo)paramArticleInfo).isHideForAnimate = true;
      if (paramseu != null) {
        paramseu.b(0);
      }
      localObject2 = new int[2];
      paramseu = paramViewBase.getNativeView();
      if (localObject1 != null) {
        if ((localObject1 instanceof NativeReadInjoyImageView))
        {
          ReadInjoyIMAXAdFragment.a = ((NativeReadInjoyImageView)localObject1).getDrawable();
          paramseu = (seu)localObject1;
        }
      }
      for (;;)
      {
        paramseu.getLocationOnScreen((int[])localObject2);
        if (((AdvertisementInfo)paramArticleInfo).mImaxShowAdType == 1001)
        {
          localObject1 = paramViewBase.findViewBaseByName("id_video_bg");
          if (localObject1 != null) {
            ((ViewBase)localObject1).getNativeView().setVisibility(4);
          }
          localObject1 = paramViewBase.findViewBaseByName("id_view_Ad_CompleteGudie");
          if (localObject1 != null) {
            ((ViewBase)localObject1).getNativeView().setVisibility(4);
          }
          localObject1 = paramViewBase.findViewBaseByName("id_large_video_icon");
          if (localObject1 != null) {
            ((ViewBase)localObject1).getNativeView().setVisibility(4);
          }
          localObject1 = paramViewBase.findViewBaseByName("id_large_video_duration");
          if (localObject1 != null) {
            ((ViewBase)localObject1).getNativeView().setVisibility(4);
          }
          if (((AdvertisementInfo)paramArticleInfo).isIMaxAndNewStyle)
          {
            paramViewBase = paramViewBase.findViewBaseByName("id_artilce_title");
            if (paramViewBase != null) {
              paramViewBase.getNativeView().setVisibility(4);
            }
          }
        }
        int i = localObject2[1];
        int j = localObject2[0];
        int k = paramseu.getWidth();
        int m = paramseu.getHeight();
        paramViewBase = new psm();
        paramViewBase.jdField_b_of_type_Int = i;
        paramViewBase.jdField_a_of_type_Int = j;
        paramViewBase.c = k;
        paramViewBase.d = m;
        paramViewBase.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
        a(paramActivity);
        ReadInjoyIMAXAdFragment.a(paramActivity, paramViewBase);
        a(paramActivity, paramArticleInfo, paramInt, nxw.ai);
        return true;
        localObject1 = paramViewBase.findViewBaseByName("id_article_large_imge");
        if (localObject1 == null) {
          break label516;
        }
        localObject1 = ((ViewBase)localObject1).getNativeView();
        break;
        paramseu = (seu)localObject1;
        if ((localObject1 instanceof FrameLayout))
        {
          paramseu = (seu)localObject1;
          if (((FrameLayout)localObject1).getChildCount() > 0)
          {
            View localView = ((FrameLayout)localObject1).getChildAt(0);
            paramseu = (seu)localObject1;
            if ((localView instanceof NativeReadInjoyImageView))
            {
              ReadInjoyIMAXAdFragment.a = ((NativeReadInjoyImageView)localView).getDrawable();
              paramseu = (seu)localObject1;
              continue;
              return false;
            }
          }
        }
      }
      label516:
      localObject1 = null;
    }
  }
  
  public static boolean a(ArticleInfo paramArticleInfo, snh paramsnh)
  {
    if ((paramsnh != null) && (paramsnh.a() != null) && (paramsnh.a().b()) && (paramsnh.a().a() != null))
    {
      paramsnh = paramsnh.a().a();
      if ((paramsnh.b) && (paramsnh.a != null) && (AdvertisementInfo.isAdvertisementInfo(paramsnh.a)))
      {
        paramsnh = (AdvertisementInfo)paramsnh.a;
        if ((!TextUtils.isEmpty(paramsnh.mAdTraceId)) && ((paramArticleInfo instanceof AdvertisementInfo)) && (paramsnh.mAdTraceId.equals(((AdvertisementInfo)paramArticleInfo).mAdTraceId))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(GdtHandler.Params paramParams, Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramParams == null) {
      return false;
    }
    return b(paramParams, paramContext, paramAdvertisementInfo);
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
  
  private static void b(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, snh paramsnh, int paramInt, boolean paramBoolean)
  {
    if ((paramsnh != null) && (paramBoolean)) {
      a(paramActivity, paramAdvertisementInfo, paramInt);
    }
    Bundle localBundle = new Bundle();
    pey.a(localBundle, paramAdvertisementInfo);
    long l2 = 0L;
    long l1 = l2;
    if (paramsnh != null)
    {
      l1 = l2;
      if (paramsnh.a() != null)
      {
        l1 = l2;
        if (paramsnh.a().a() != null)
        {
          l1 = l2;
          if (paramsnh.a().a().c == paramAdvertisementInfo.mArticleID) {
            l1 = paramsnh.a();
          }
        }
      }
    }
    localBundle.putLong("param_ad_app_info_video_playposition", l1);
    a(paramActivity);
    NativeAdVideoFragment.a(paramActivity, NativeAdVideoFragment.class, localBundle);
  }
  
  private static void b(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    int i;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label119;
      }
    }
    label119:
    for (int j = 0;; j = 1)
    {
      String str1 = pha.d(paramArticleInfo);
      String str2 = ube.b(paramInt);
      oat.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, str2, str2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pha.a(paramArticleInfo.mAlgorithmID, pha.a(paramArticleInfo), paramInt, i, j, bgnt.h(paramContext), str1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pha.f(paramArticleInfo), paramArticleInfo), false);
      return;
      i = 0;
      break;
    }
  }
  
  public static boolean b(Context paramContext, AdvertisementInfo paramAdvertisementInfo, snh paramsnh, int paramInt, boolean paramBoolean)
  {
    paramContext = a(paramContext, paramAdvertisementInfo, paramsnh, paramInt, paramBoolean, false, false, null);
    if (paramContext == null) {
      return false;
    }
    GdtHandler.a(paramContext);
    QLog.i("ReadinJoyActionUtil", 3, "kandian JumpToTangramSDK");
    return true;
  }
  
  public static boolean b(Context paramContext, AdvertisementInfo paramAdvertisementInfo, snh paramsnh, int paramInt, boolean paramBoolean, oml paramoml)
  {
    if (oqj.m(paramAdvertisementInfo))
    {
      a(paramContext, paramAdvertisementInfo);
      return true;
    }
    paramsnh = a(paramContext, paramAdvertisementInfo, paramsnh, paramInt, paramBoolean, paramoml);
    if (paramsnh == null) {
      return false;
    }
    return b(paramsnh, paramContext, paramAdvertisementInfo);
  }
  
  public static boolean b(GdtHandler.Params paramParams, Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = true;
    if ((paramParams == null) || (paramAdvertisementInfo == null) || (paramContext == null)) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        oqj.b(paramAdvertisementInfo);
        if ((paramAdvertisementInfo.mAdJumpMode != 7) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage))) {
          break;
        }
        a(paramContext);
        pha.d(paramContext, paramAdvertisementInfo.mAdLandingPage);
      } while (!QLog.isColorLevel());
      QLog.i("ReadinJoyActionUtil", 3, "JumpToGdtAdPage tovialo true");
      return true;
      GdtHandler.a(paramParams);
    } while (!QLog.isColorLevel());
    QLog.i("ReadinJoyActionUtil", 3, "kandian JumpToTangramSDK");
    return true;
  }
  
  public static boolean c(Context paramContext, AdvertisementInfo paramAdvertisementInfo, snh paramsnh, int paramInt, boolean paramBoolean, oml paramoml)
  {
    paramsnh = a(paramContext, paramAdvertisementInfo, paramsnh, paramInt, paramBoolean, false, false, paramoml);
    if (paramsnh == null) {
      return false;
    }
    if (paramoml == null)
    {
      paramsnh.d = false;
      paramsnh.c = false;
    }
    return b(paramsnh, paramContext, paramAdvertisementInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ubb
 * JD-Core Version:    0.7.0.1
 */