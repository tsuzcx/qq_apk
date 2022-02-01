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
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.ad.fragment.ReadinjoyAdPKFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdPopSheetBrowserFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyForCanvasFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoCeilingFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
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
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
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

public class ods
{
  public static boolean awz;
  public static GdtAppReceiver mGdtAppReceiver;
  private static ArrayList<Integer> mb = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(12), Integer.valueOf(25), Integer.valueOf(30), Integer.valueOf(41), Integer.valueOf(1000) }));
  
  public static GdtHandler.Params a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ndi paramndi, int paramInt, boolean paramBoolean, kks paramkks)
  {
    return a(paramContext, paramAdvertisementInfo, paramndi, paramInt, paramBoolean, true, false, paramkks);
  }
  
  public static GdtHandler.Params a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ndi paramndi, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, kks paramkks)
  {
    if ((paramBoolean2) && (!a(paramAdvertisementInfo, paramInt))) {
      return null;
    }
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = a(paramAdvertisementInfo);
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.processId = 1;
    localParams.activity = new WeakReference((Activity)paramContext);
    localParams.ad = new GdtAd(localAdInfo);
    localParams.reportForClick = true;
    localParams.aOV = paramBoolean1;
    if (paramAdvertisementInfo.clickPos > 0)
    {
      com.tencent.TMG.utils.QLog.d("ReadinJoyActionUtil", 0, "test click pos " + paramAdvertisementInfo.clickPos);
      localParams.componentID = paramAdvertisementInfo.clickPos;
      paramAdvertisementInfo.resetClickPos();
    }
    if (paramndi != null) {
      localParams.videoStartPositionMillis = paramndi.di();
    }
    if ((localParams.videoStartPositionMillis <= 0L) && (paramkks != null) && (paramkks.sl > 0L)) {
      localParams.videoStartPositionMillis = paramkks.sl;
    }
    if (mGdtAppReceiver == null)
    {
      mGdtAppReceiver = new GdtAppReceiver();
      mGdtAppReceiver.register(BaseApplicationImpl.getContext());
    }
    localParams.appReceiver = new WeakReference(mGdtAppReceiver);
    if ((paramInt != 3) && (paramInt != 4) && (paramAdvertisementInfo.mAdJumpMode != 6) && (!paramBoolean3) && (paramInt != 2000001))
    {
      localParams.n = ReadInJoyVideoCeilingFragment.class;
      if (paramkks != null) {
        a(localParams, paramkks.isAutoPlaying, paramAdvertisementInfo, paramContext);
      }
    }
    localParams.p = ReadInJoyForCanvasFragment.class;
    if ((paramkks != null) && (paramkks.afY)) {
      localParams.reportForClick = false;
    }
    localParams.extra = new Bundle();
    localParams.extra.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    return localParams;
  }
  
  public static String a(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (paramVideoInfo.advertisementInfo != null) && (paramVideoInfo.advertisementInfo.mAdExtInfo != null))
    {
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.advertisementInfo.mAdExtInfo);
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
        if (com.tencent.TMG.utils.QLog.isColorLevel()) {
          com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 0, "getH5UrlFromPopSheet error:" + paramVideoInfo.getMessage());
        }
        return null;
      }
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 0, "getH5UrlFromPopSheet params pop_sheet is empty");
      }
      return null;
    }
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 0, "getH5UrlFromPopSheet params videoInfo is error");
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
  
  /* Error */
  private static kkt a(AdvertisementInfo paramAdvertisementInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnull +142 -> 145
    //   6: aload_0
    //   7: getfield 254	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lkkw;
    //   10: ifnull +135 -> 145
    //   13: aload_0
    //   14: getfield 254	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lkkw;
    //   17: getfield 260	kkw:gi	Ljava/util/List;
    //   20: ifnull +125 -> 145
    //   23: aload_0
    //   24: getfield 254	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lkkw;
    //   27: getfield 260	kkw:gi	Ljava/util/List;
    //   30: invokeinterface 266 1 0
    //   35: iconst_2
    //   36: if_icmplt +109 -> 145
    //   39: aload_0
    //   40: getfield 84	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:clickPos	I
    //   43: bipush 101
    //   45: if_icmpne +20 -> 65
    //   48: aload_0
    //   49: getfield 254	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lkkw;
    //   52: getfield 260	kkw:gi	Ljava/util/List;
    //   55: iconst_0
    //   56: invokeinterface 270 2 0
    //   61: checkcast 272	kkt
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 84	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:clickPos	I
    //   69: bipush 102
    //   71: if_icmpne +72 -> 143
    //   74: aload_0
    //   75: getfield 254	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lkkw;
    //   78: getfield 260	kkw:gi	Ljava/util/List;
    //   81: iconst_1
    //   82: invokeinterface 270 2 0
    //   87: checkcast 272	kkt
    //   90: astore_2
    //   91: aload_2
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: astore_2
    //   98: invokestatic 229	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   101: ifeq -10 -> 91
    //   104: ldc 86
    //   106: iconst_3
    //   107: new 88	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 274
    //   117: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: invokevirtual 234	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   124: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 237	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1	64	1	localkkt	kkt
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
  
  private static klc.a a(ndi paramndi, String paramString)
  {
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)paramndi.b();
    int j = localReadInJoyXListView.getFirstVisiblePosition();
    int i = Math.max(localReadInJoyXListView.getHeaderViewsCount(), j);
    int k;
    if (i < paramndi.getData().size() + localReadInJoyXListView.getHeaderViewsCount())
    {
      k = i - localReadInJoyXListView.getHeaderViewsCount();
      BaseArticleInfo localBaseArticleInfo = paramndi.c(k);
      if ((66 == paramndi.getItemViewType(k)) && (localBaseArticleInfo != null) && (TextUtils.equals(localBaseArticleInfo.getInnerUniqueID(), paramString)))
      {
        int m = i - j;
        if ((m >= 0) && (m < localReadInJoyXListView.getChildCount())) {
          paramndi = localReadInJoyXListView.getChildAt(i - j);
        }
      }
    }
    for (;;)
    {
      if ((paramndi != null) && ((paramndi.getTag() instanceof klc.a)))
      {
        return (klc.a)paramndi.getTag();
        if ((k >= 0) && (k < paramndi.getData().size())) {
          paramndi = paramndi.getView(k, null, localReadInJoyXListView);
        }
      }
      else
      {
        return null;
        i += 1;
        break;
        return null;
      }
      paramndi = null;
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
    //   10: new 335	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo
    //   13: dup
    //   14: invokespecial 336	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:<init>	()V
    //   17: astore_1
    //   18: aload_1
    //   19: getfield 340	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:advertiser_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   22: aload_0
    //   23: getfield 343	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAdvertiseId	J
    //   26: invokevirtual 349	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   29: aload_0
    //   30: getfield 352	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateLogo	Ljava/lang/String;
    //   33: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifne +14 -> 50
    //   39: aload_1
    //   40: getfield 356	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:corporate_logo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   43: aload_0
    //   44: getfield 352	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateLogo	Ljava/lang/String;
    //   47: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 363	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateImageName	Ljava/lang/String;
    //   54: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +14 -> 71
    //   60: aload_1
    //   61: getfield 366	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:corporate_image_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   64: aload_0
    //   65: getfield 363	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateImageName	Ljava/lang/String;
    //   68: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   71: new 368	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo
    //   74: dup
    //   75: invokespecial 369	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:<init>	()V
    //   78: astore_2
    //   79: aload_0
    //   80: getfield 372	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVideoUrl	Ljava/lang/String;
    //   83: ifnull +14 -> 97
    //   86: aload_2
    //   87: getfield 375	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:video_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   90: aload_0
    //   91: getfield 372	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVideoUrl	Ljava/lang/String;
    //   94: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   97: new 377	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo
    //   100: dup
    //   101: invokespecial 378	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:<init>	()V
    //   104: astore_3
    //   105: aload_3
    //   106: getfield 382	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:advertiser_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo;
    //   109: aload_1
    //   110: invokevirtual 385	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   113: aload_3
    //   114: getfield 389	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:video_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo;
    //   117: aload_2
    //   118: invokevirtual 390	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   121: aload_3
    //   122: getfield 394	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:mini_program_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: aload_0
    //   126: getfield 397	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:miniProgramType	I
    //   129: invokevirtual 402	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   132: new 404	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo
    //   135: dup
    //   136: invokespecial 405	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:<init>	()V
    //   139: astore_1
    //   140: aload_1
    //   141: getfield 408	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:aid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   144: aload_0
    //   145: getfield 411	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAid	J
    //   148: invokevirtual 349	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   151: aload_1
    //   152: getfield 414	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:traceid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   155: aload_0
    //   156: getfield 417	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdTraceId	Ljava/lang/String;
    //   159: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   162: aload_1
    //   163: getfield 420	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:view_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   166: aload_0
    //   167: getfield 423	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdViewId	Ljava/lang/String;
    //   170: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   173: aload_1
    //   174: getfield 426	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:product_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   177: aload_0
    //   178: getfield 429	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductId	Ljava/lang/String;
    //   181: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   184: aload_1
    //   185: getfield 432	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:via	Lcom/tencent/mobileqq/pb/PBStringField;
    //   188: aload_0
    //   189: getfield 435	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVia	Ljava/lang/String;
    //   192: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   195: aload_1
    //   196: getfield 439	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:noco_id	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   199: aload_0
    //   200: getfield 442	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdNocoId	J
    //   203: invokevirtual 445	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   206: new 447	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo
    //   209: dup
    //   210: invokespecial 448	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:<init>	()V
    //   213: astore 4
    //   215: aload 4
    //   217: getfield 451	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:exposure_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   220: aload_0
    //   221: getfield 454	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdApurl	Ljava/lang/String;
    //   224: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   227: aload 4
    //   229: getfield 457	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   232: aload_0
    //   233: getfield 460	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdRl	Ljava/lang/String;
    //   236: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   239: aload 4
    //   241: getfield 463	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:effect_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   244: aload_0
    //   245: getfield 466	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdEffectUrl	Ljava/lang/String;
    //   248: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   251: aload 4
    //   253: getfield 469	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:landing_page_report_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   256: aload_0
    //   257: getfield 472	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdLandingPageReportUrl	Ljava/lang/String;
    //   260: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   263: aload 4
    //   265: getfield 476	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   268: aload_1
    //   269: invokevirtual 477	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   272: new 479	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls
    //   275: dup
    //   276: invokespecial 480	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:<init>	()V
    //   279: astore_1
    //   280: aload_0
    //   281: getfield 483	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SClickUrl	Ljava/util/ArrayList;
    //   284: ifnull +14 -> 298
    //   287: aload_1
    //   288: getfield 487	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:api_click_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   291: aload_0
    //   292: getfield 483	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SClickUrl	Ljava/util/ArrayList;
    //   295: invokevirtual 492	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   298: aload_0
    //   299: getfield 495	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SExposureUrl	Ljava/util/ArrayList;
    //   302: ifnull +14 -> 316
    //   305: aload_1
    //   306: getfield 498	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:api_exposure_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   309: aload_0
    //   310: getfield 495	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SExposureUrl	Ljava/util/ArrayList;
    //   313: invokevirtual 492	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   316: aload_0
    //   317: getfield 501	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SVideoPlayUrl	Ljava/util/ArrayList;
    //   320: ifnull +14 -> 334
    //   323: aload_1
    //   324: getfield 504	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:video_play_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   327: aload_0
    //   328: getfield 501	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SVideoPlayUrl	Ljava/util/ArrayList;
    //   331: invokevirtual 492	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   334: aload 4
    //   336: getfield 508	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:thirdparty_monitor_urls	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls;
    //   339: aload_1
    //   340: invokevirtual 509	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   343: new 511	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo
    //   346: dup
    //   347: invokespecial 512	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:<init>	()V
    //   350: astore 6
    //   352: aload_0
    //   353: getfield 515	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdLandingPage	Ljava/lang/String;
    //   356: astore_2
    //   357: aload_2
    //   358: astore_1
    //   359: aload_0
    //   360: getfield 254	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lkkw;
    //   363: ifnull +23 -> 386
    //   366: aload_2
    //   367: astore_1
    //   368: aload_0
    //   369: getfield 254	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lkkw;
    //   372: getfield 518	kkw:aJA	I
    //   375: ldc_w 519
    //   378: if_icmpne +8 -> 386
    //   381: aload_2
    //   382: invokestatic 522	ods:fr	(Ljava/lang/String;)Ljava/lang/String;
    //   385: astore_1
    //   386: aload 6
    //   388: getfield 525	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:landing_page	Lcom/tencent/mobileqq/pb/PBStringField;
    //   391: aload_1
    //   392: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   395: aload 6
    //   397: getfield 528	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:canvas_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   400: aload_0
    //   401: getfield 531	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCanvasJson	Ljava/lang/String;
    //   404: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   407: aload 6
    //   409: getfield 534	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:dest_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   412: aload_0
    //   413: getfield 537	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdDestType	I
    //   416: invokevirtual 402	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   419: new 539	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo
    //   422: dup
    //   423: invokespecial 540	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:<init>	()V
    //   426: astore 5
    //   428: aload_0
    //   429: getfield 543	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   432: invokestatic 548	com/tencent/gdtad/aditem/GdtBaseAdItem:a	(Ljava/lang/String;)Lcom/tencent/gdtad/aditem/GdtBaseAdItem;
    //   435: astore_1
    //   436: aload 5
    //   438: getfield 551	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:app_package_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   441: aload_1
    //   442: getfield 554	com/tencent/gdtad/aditem/GdtBaseAdItem:packageName	Ljava/lang/String;
    //   445: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   448: new 201	org/json/JSONObject
    //   451: dup
    //   452: aload_0
    //   453: getfield 543	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   456: invokespecial 204	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   459: astore_2
    //   460: aload_2
    //   461: ldc_w 556
    //   464: invokevirtual 214	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   467: astore_1
    //   468: aload_2
    //   469: ldc_w 558
    //   472: invokevirtual 214	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   475: astore_2
    //   476: aload_1
    //   477: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   480: ifne +12 -> 492
    //   483: aload 5
    //   485: getfield 561	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:pkg_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   488: aload_1
    //   489: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   492: aload_2
    //   493: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   496: ifne +12 -> 508
    //   499: aload 5
    //   501: getfield 564	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:app_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   504: aload_2
    //   505: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   508: aload 5
    //   510: getfield 567	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:android_app_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   513: aload_0
    //   514: getfield 429	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductId	Ljava/lang/String;
    //   517: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   520: aload 5
    //   522: getfield 570	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:pkg_download_schema	Lcom/tencent/mobileqq/pb/PBStringField;
    //   525: aload_0
    //   526: getfield 573	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAppDownLoadSchema	Ljava/lang/String;
    //   529: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   532: aload 5
    //   534: getfield 576	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:customized_invoke_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   537: aload_0
    //   538: getfield 579	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCustomizedInvokeUrl	Ljava/lang/String;
    //   541: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   544: invokestatic 229	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   547: ifeq +32 -> 579
    //   550: ldc 86
    //   552: iconst_0
    //   553: new 88	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   560: ldc_w 581
    //   563: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload_0
    //   567: getfield 584	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   570: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 108	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: aload 5
    //   581: getfield 587	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:channel_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   584: astore_2
    //   585: aload_0
    //   586: getfield 584	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   589: ifnonnull +349 -> 938
    //   592: ldc 246
    //   594: astore_1
    //   595: aload_2
    //   596: aload_1
    //   597: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   600: aload_0
    //   601: invokestatic 593	knd:m	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   604: ifeq +38 -> 642
    //   607: aload_0
    //   608: getfield 254	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lkkw;
    //   611: getfield 260	kkw:gi	Ljava/util/List;
    //   614: ifnull +28 -> 642
    //   617: aload_0
    //   618: getfield 254	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lkkw;
    //   621: getfield 260	kkw:gi	Ljava/util/List;
    //   624: invokeinterface 266 1 0
    //   629: iconst_2
    //   630: if_icmplt +12 -> 642
    //   633: aload_0
    //   634: invokestatic 595	ods:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lkkt;
    //   637: astore_1
    //   638: aload_1
    //   639: ifnonnull +307 -> 946
    //   642: new 597	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   645: dup
    //   646: invokespecial 598	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   649: astore_1
    //   650: aload_1
    //   651: getfield 601	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:product_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   654: aload_0
    //   655: getfield 604	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductType	I
    //   658: invokevirtual 402	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   661: aload_1
    //   662: getfield 608	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:display_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo;
    //   665: aload_3
    //   666: invokevirtual 609	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   669: aload_1
    //   670: getfield 613	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   673: aload 4
    //   675: invokevirtual 614	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   678: aload_1
    //   679: getfield 618	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:dest_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo;
    //   682: aload 6
    //   684: invokevirtual 619	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   687: new 621	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo
    //   690: dup
    //   691: invokespecial 622	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:<init>	()V
    //   694: astore_2
    //   695: aload_0
    //   696: getfield 199	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   699: astore_3
    //   700: aload_3
    //   701: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   704: ifne +93 -> 797
    //   707: new 201	org/json/JSONObject
    //   710: dup
    //   711: aload_3
    //   712: invokespecial 204	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   715: astore_3
    //   716: aload_2
    //   717: getfield 625	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:ad_trace_data	Lcom/tencent/mobileqq/pb/PBStringField;
    //   720: aload_3
    //   721: ldc_w 627
    //   724: invokevirtual 214	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   727: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   730: aload_2
    //   731: getfield 630	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   734: aload_3
    //   735: ldc_w 632
    //   738: invokevirtual 214	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   741: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   744: aload_2
    //   745: getfield 635	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   748: aload_3
    //   749: ldc_w 637
    //   752: invokevirtual 214	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   755: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   758: aload_2
    //   759: getfield 640	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_token	Lcom/tencent/mobileqq/pb/PBStringField;
    //   762: aload_3
    //   763: ldc_w 642
    //   766: invokevirtual 214	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   769: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   772: aload_2
    //   773: getfield 645	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_username	Lcom/tencent/mobileqq/pb/PBStringField;
    //   776: aload_3
    //   777: ldc_w 647
    //   780: invokevirtual 214	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   783: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   786: aload_2
    //   787: getfield 650	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:pos_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   790: aload_0
    //   791: getfield 653	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdPosID	J
    //   794: invokevirtual 349	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   797: aload_1
    //   798: getfield 657	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:wechat_app_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo;
    //   801: aload_2
    //   802: invokevirtual 658	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   805: aload_1
    //   806: getfield 662	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:app_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo;
    //   809: aload 5
    //   811: invokevirtual 663	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   814: aload_0
    //   815: getfield 543	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   818: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   821: ifne +180 -> 1001
    //   824: new 201	org/json/JSONObject
    //   827: dup
    //   828: aload_0
    //   829: getfield 543	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   832: invokespecial 204	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   835: ldc_w 665
    //   838: ldc 246
    //   840: invokevirtual 668	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   843: astore_0
    //   844: invokestatic 229	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   847: ifeq +29 -> 876
    //   850: ldc 86
    //   852: iconst_0
    //   853: new 88	java/lang/StringBuilder
    //   856: dup
    //   857: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   860: ldc_w 670
    //   863: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: aload_0
    //   867: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokestatic 108	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   876: aload_1
    //   877: getfield 673	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:ext_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   880: aload_0
    //   881: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   884: aload_1
    //   885: areturn
    //   886: astore_2
    //   887: aload_1
    //   888: astore_0
    //   889: invokestatic 229	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   892: ifeq -884 -> 8
    //   895: ldc 86
    //   897: iconst_0
    //   898: new 88	java/lang/StringBuilder
    //   901: dup
    //   902: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   905: ldc_w 675
    //   908: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: aload_2
    //   912: invokevirtual 234	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   915: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   921: invokestatic 108	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   924: aload_1
    //   925: areturn
    //   926: astore_2
    //   927: aconst_null
    //   928: astore_1
    //   929: aload_2
    //   930: invokevirtual 676	java/lang/Exception:printStackTrace	()V
    //   933: aconst_null
    //   934: astore_2
    //   935: goto -459 -> 476
    //   938: aload_0
    //   939: getfield 584	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   942: astore_1
    //   943: goto -348 -> 595
    //   946: aload_1
    //   947: getfield 679	kkt:rl	Ljava/lang/String;
    //   950: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   953: ifne +15 -> 968
    //   956: aload 4
    //   958: getfield 457	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   961: aload_1
    //   962: getfield 679	kkt:rl	Ljava/lang/String;
    //   965: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   968: aload_1
    //   969: getfield 682	kkt:aak	Ljava/lang/String;
    //   972: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   975: ifne -333 -> 642
    //   978: aload 6
    //   980: getfield 525	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:landing_page	Lcom/tencent/mobileqq/pb/PBStringField;
    //   983: aload_1
    //   984: getfield 682	kkt:aak	Ljava/lang/String;
    //   987: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   990: goto -348 -> 642
    //   993: astore_3
    //   994: aload_3
    //   995: invokevirtual 249	org/json/JSONException:printStackTrace	()V
    //   998: goto -201 -> 797
    //   1001: aload_1
    //   1002: getfield 673	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:ext_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1005: ldc 246
    //   1007: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   1010: aload_1
    //   1011: astore_0
    //   1012: invokestatic 229	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1015: ifeq -1007 -> 8
    //   1018: ldc 86
    //   1020: iconst_0
    //   1021: ldc_w 684
    //   1024: invokestatic 108	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  public static void a(int paramInt, GdtHandler.Params paramParams, long paramLong)
  {
    if ((paramParams == null) || (paramLong == -2147483648L)) {}
    do
    {
      return;
      if ((paramParams == null) || (paramLong == -2147483648L))
      {
        tkw.e("ReadinJoyActionUtil", " enterTimeMillis:" + paramLong + " gdtParams:" + paramParams);
        return;
      }
    } while ((paramInt != 0) && (paramInt != 3) && (paramInt != 56) && (paramInt != 2));
    long l = SystemClock.elapsedRealtime();
    tkw.i("ReadinJoyActionUtil", String.format("leave %d", new Object[] { Long.valueOf(l) }));
    if (paramLong == -2147483648L) {
      tkw.e("ReadinJoyActionUtil", "leave error");
    }
    paramLong = l - paramLong;
    tkw.i("ReadinJoyActionUtil", String.format("dwell %d", new Object[] { Long.valueOf(paramLong) }));
    tla.a locala = new tla.a();
    locala.ad = paramParams.ad;
    locala.a.landing_page_action_type.set(42);
    locala.a.latency_ms.set(paramLong);
    tla.a(locala);
  }
  
  private static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, ndi paramndi, int paramInt, boolean paramBoolean) {}
  
  public static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, ndi paramndi, int paramInt, boolean paramBoolean, kks paramkks)
  {
    paramkks = a(paramActivity, paramAdvertisementInfo, paramndi, paramInt, paramBoolean, paramkks);
    if (((paramAdvertisementInfo instanceof AdvertisementInfo)) && (paramkks != null))
    {
      paramkks.videoCeilingSupportedIfInstalled = true;
      paramkks.videoCeilingSupportedIfNotInstalled = true;
      if (a(paramkks, paramActivity, paramAdvertisementInfo)) {
        return;
      }
    }
    Object localObject = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).aid.set(paramAdvertisementInfo.mAdAid);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).traceid.set(paramAdvertisementInfo.mAdTraceId);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).view_id.set(paramAdvertisementInfo.mAdViewId);
    paramkks = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    paramkks.exposure_url.set(paramAdvertisementInfo.mAdApurl);
    paramkks.click_url.set(paramAdvertisementInfo.mAdRl);
    paramkks.trace_info.set((MessageMicro)localObject);
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.set(paramkks);
    GdtAd localGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    localObject = paramAdvertisementInfo.mAdLandingPage;
    paramkks = (kks)localObject;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramkks = Uri.parse((String)localObject).buildUpon();
      if ((aqiw.getNetworkType(BaseApplicationImpl.getApplication()) != 1) || (paramInt == 0)) {
        break label354;
      }
      paramkks.appendQueryParameter("autodownload", "1");
    }
    for (;;)
    {
      paramkks = paramkks.toString();
      localObject = new GdtVideoCeilingData();
      ((GdtVideoCeilingData)localObject).setVideoData(localGdtVideoData);
      ((GdtVideoCeilingData)localObject).setAd(localGdtAd);
      ((GdtVideoCeilingData)localObject).setWebUrl(paramkks);
      paramInt = paramAdvertisementInfo.mAdJumpMode;
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("ReadinJoyActionUtil", 0, "jump mode = " + paramInt);
      }
      if (paramInt != 4) {
        break label378;
      }
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdAppJson)) {
        break;
      }
      a(paramActivity, paramAdvertisementInfo, paramndi, 0, null);
      return;
      label354:
      paramkks.appendQueryParameter("autodownload", "0");
    }
    a(paramActivity, paramAdvertisementInfo, paramndi, 0, false);
    return;
    label378:
    if (paramInt == 5)
    {
      b(paramActivity, paramAdvertisementInfo, paramndi, 0, false);
      return;
    }
    if (((GdtVideoCeilingData)localObject).getStyle() == -2147483648) {
      ((GdtVideoCeilingData)localObject).setStyle(1);
    }
    paramAdvertisementInfo = new Bundle();
    paramAdvertisementInfo.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    ReadInJoyVideoCeilingFragment.a(paramActivity, ReadInJoyVideoCeilingFragment.class, (GdtVideoCeilingData)localObject, paramAdvertisementInfo);
  }
  
  public static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, ndi paramndi, int paramInt, boolean paramBoolean1, boolean paramBoolean2, kks paramkks)
  {
    Object localObject = a(paramActivity, paramAdvertisementInfo, paramndi, paramInt, paramBoolean1, paramkks);
    if (((paramAdvertisementInfo instanceof AdvertisementInfo)) && (localObject != null))
    {
      ((GdtHandler.Params)localObject).directPlay = paramBoolean2;
      if (paramkks == null)
      {
        ((GdtHandler.Params)localObject).videoCeilingSupportedIfInstalled = false;
        ((GdtHandler.Params)localObject).videoCeilingSupportedIfNotInstalled = false;
      }
      if (a((GdtHandler.Params)localObject, paramActivity, paramAdvertisementInfo)) {
        return;
      }
    }
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).aid.set(paramAdvertisementInfo.mAdAid);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).traceid.set(paramAdvertisementInfo.mAdTraceId);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).view_id.set(paramAdvertisementInfo.mAdViewId);
    paramkks = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    paramkks.exposure_url.set(paramAdvertisementInfo.mAdApurl);
    paramkks.click_url.set(paramAdvertisementInfo.mAdRl);
    paramkks.trace_info.set((MessageMicro)localObject);
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.set(paramkks);
    GdtAd localGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setDirectPlay(paramBoolean2);
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    localObject = paramAdvertisementInfo.mAdLandingPage;
    paramkks = (kks)localObject;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramkks = Uri.parse((String)localObject).buildUpon();
      if ((aqiw.getNetworkType(BaseApplicationImpl.getApplication()) != 1) || (paramInt == 0)) {
        break label373;
      }
      paramkks.appendQueryParameter("autodownload", "1");
    }
    for (;;)
    {
      paramkks = paramkks.toString();
      localObject = new GdtVideoCeilingData();
      ((GdtVideoCeilingData)localObject).setVideoData(localGdtVideoData);
      ((GdtVideoCeilingData)localObject).setAd(localGdtAd);
      ((GdtVideoCeilingData)localObject).setWebUrl(paramkks);
      paramInt = paramAdvertisementInfo.mAdJumpMode;
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("ReadinJoyActionUtil", 0, "jump mode = " + paramInt);
      }
      if (paramInt != 4) {
        break label397;
      }
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdAppJson)) {
        break;
      }
      a(paramActivity, paramAdvertisementInfo, paramndi, 0, null);
      return;
      label373:
      paramkks.appendQueryParameter("autodownload", "0");
    }
    a(paramActivity, paramAdvertisementInfo, paramndi, 0, false);
    return;
    label397:
    if (paramInt == 5)
    {
      b(paramActivity, paramAdvertisementInfo, paramndi, 0, false);
      return;
    }
    if (((GdtVideoCeilingData)localObject).getStyle() == -2147483648) {
      ((GdtVideoCeilingData)localObject).setStyle(1);
    }
    paramAdvertisementInfo = new Bundle();
    paramAdvertisementInfo.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    ReadInJoyVideoCeilingFragment.a(paramActivity, ReadInJoyVideoCeilingFragment.class, (GdtVideoCeilingData)localObject, paramAdvertisementInfo);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, ndi paramndi, int paramInt, kks paramkks)
  {
    GdtHandler.Params localParams;
    if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
    {
      e(paramActivity, paramArticleInfo, paramInt);
      if (paramInt == 0)
      {
        lbz.a().H(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (paramndi != null) {
          paramndi.notifyDataSetChanged();
        }
      }
      localParams = a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramndi, paramInt, true, paramkks);
      if (!a(localParams, paramActivity, (AdvertisementInfo)paramArticleInfo))
      {
        paramkks = paramArticleInfo.mArticleContentUrl;
        if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) || (!knd.m((AdvertisementInfo)paramArticleInfo))) {
          break label366;
        }
        paramndi = a((AdvertisementInfo)paramArticleInfo);
        if (paramndi == null) {
          break label372;
        }
      }
    }
    label342:
    label366:
    label372:
    for (paramndi = paramndi.aak;; paramndi = "")
    {
      if (!TextUtils.isEmpty(paramndi)) {}
      for (;;)
      {
        paramkks = paramndi;
        if (AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo))
        {
          paramkks = paramndi;
          if (aqiw.isWifiConnected(null)) {
            if (!paramndi.contains("?")) {
              break label342;
            }
          }
        }
        for (paramArticleInfo = paramndi + "&";; paramArticleInfo = paramndi + "?")
        {
          paramkks = paramArticleInfo + "acttype=42";
          cn(paramActivity);
          paramArticleInfo = new Intent(paramActivity, QQBrowserActivity.class);
          paramArticleInfo.putExtra("startOpenPageTime", System.currentTimeMillis());
          paramArticleInfo.putExtra("url", paramkks);
          paramArticleInfo.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
          if ((localParams != null) && (localParams.ad != null))
          {
            if (localParams.ad.getNocoId() != 0L) {
              paramArticleInfo.putExtra("GdtNocoId", localParams.ad.getNocoId());
            }
            if (!TextUtils.isEmpty(localParams.ad.getUrlForEffect())) {
              paramArticleInfo.putExtra("GdtWebReportQQ_ACTION_URL", localParams.ad.getUrlForAction());
            }
            if (!TextUtils.isEmpty(localParams.ad.getTraceId())) {
              paramArticleInfo.putExtra("GdtWebReportQQ_TRACE_ID", localParams.ad.getTraceId());
            }
          }
          paramActivity.startActivity(paramArticleInfo);
          return;
        }
        paramndi = paramkks;
      }
    }
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, ndi paramndi, int paramInt, boolean paramBoolean, kks paramkks)
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
        a(paramActivity, paramArticleInfo, paramndi, paramInt, paramkks);
        return;
      case 2: 
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramndi, paramInt, paramBoolean, paramkks);
        return;
      case 4: 
        if (TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdAppJson))
        {
          a(paramActivity, paramArticleInfo, paramndi, paramInt, paramkks);
          return;
        }
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramndi, paramInt, true);
        return;
      case 3: 
        int i = ((AdvertisementInfo)paramArticleInfo).clickPos;
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, null, paramInt, paramBoolean, paramkks);
        ((AdvertisementInfo)paramArticleInfo).clickPos = i;
        b(paramActivity, paramArticleInfo, paramndi, paramInt);
        lbz.a().H(paramArticleInfo.mArticleID, System.currentTimeMillis());
      }
    } while (paramndi == null);
    paramndi.notifyDataSetChanged();
    return;
    b(paramActivity, (AdvertisementInfo)paramArticleInfo, paramndi, paramInt, true);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, ndi paramndi, int paramInt, boolean paramBoolean1, boolean paramBoolean2, kks paramkks)
  {
    if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) || (!(paramArticleInfo instanceof AdvertisementInfo))) {
      return;
    }
    if (paramkks == null) {
      paramkks = new kks();
    }
    for (;;)
    {
      switch (((AdvertisementInfo)paramArticleInfo).mAdJumpMode)
      {
      default: 
        return;
      case 0: 
      case 1: 
      case 6: 
      case 7: 
        a(paramActivity, paramArticleInfo, paramndi, paramInt, paramkks);
        return;
      case 2: 
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramndi, paramInt, paramBoolean1, paramkks);
        return;
      case 4: 
        if (TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdAppJson))
        {
          a(paramActivity, paramArticleInfo, paramndi, paramInt, null);
          return;
        }
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramndi, paramInt, true);
        return;
      case 3: 
        paramkks.isAutoPlaying = a(paramArticleInfo, paramndi);
        int i = ((AdvertisementInfo)paramArticleInfo).clickPos;
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramndi, paramInt, paramBoolean1, paramBoolean2, paramkks);
        ((AdvertisementInfo)paramArticleInfo).clickPos = i;
        b(paramActivity, paramArticleInfo, paramndi, paramInt);
        lbz.a().H(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (paramndi == null) {
          break;
        }
        paramndi.notifyDataSetChanged();
        return;
      case 5: 
        b(paramActivity, (AdvertisementInfo)paramArticleInfo, paramndi, paramInt, true);
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
    paramActivity.overridePendingTransition(2130771991, 17432577);
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ndi paramndi, int paramInt, boolean paramBoolean, kks paramkks)
  {
    int i = paramAdvertisementInfo.clickPos;
    a(paramContext, paramAdvertisementInfo, paramndi, paramInt, paramBoolean, paramkks);
    if (i >= 0) {
      paramAdvertisementInfo.setClickPos(i);
    }
    e(paramContext, paramAdvertisementInfo, paramInt);
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ndi paramndi, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramAdvertisementInfo.clickPos;
    a(paramContext, paramAdvertisementInfo, paramndi, paramInt, paramBoolean1, paramBoolean2);
    if (i >= 0) {
      paramAdvertisementInfo.setClickPos(i);
    }
    e(paramContext, paramAdvertisementInfo, paramInt);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      jzk.a(new kku.a().a(paramContext).a(jzk.aEJ).b(paramInt2).a((AdvertisementInfo)paramArticleInfo).e(new JSONObject()).a());
      f(paramContext, paramArticleInfo, paramInt1);
    }
  }
  
  public static void a(ViewBase paramViewBase1, ViewBase paramViewBase2, Activity paramActivity, ArticleInfo paramArticleInfo, ndi paramndi, int paramInt1, int paramInt2)
  {
    if ((paramViewBase2 == null) || (paramActivity == null) || (paramArticleInfo == null)) {}
    while (!(paramArticleInfo instanceof AdvertisementInfo)) {
      return;
    }
    paramViewBase2.setOnClickListener(new odt(paramArticleInfo, paramActivity, paramndi, paramInt1, paramInt2, paramViewBase1));
  }
  
  private static void a(GdtHandler.Params paramParams, boolean paramBoolean, AdvertisementInfo paramAdvertisementInfo, Context paramContext)
  {
    if (((paramBoolean) && (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (!knd.i(paramAdvertisementInfo))) || ((paramBoolean) && ((paramAdvertisementInfo.mAdProductType == 1000) || (paramAdvertisementInfo.mAdProductType == 25)) && (TextUtils.isEmpty(paramAdvertisementInfo.mAdCustomizedInvokeUrl))) || (!paramBoolean))
    {
      paramParams.videoCeilingSupportedIfNotInstalled = true;
      paramParams.videoCeilingSupportedIfInstalled = true;
      return;
    }
    if (((paramAdvertisementInfo.mAdProductType == 1000) || (paramAdvertisementInfo.mAdProductType == 25)) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdCustomizedInvokeUrl)) && (!a(paramAdvertisementInfo, paramContext)))
    {
      paramParams.videoCeilingSupportedIfNotInstalled = true;
      paramParams.videoCeilingSupportedIfInstalled = true;
      return;
    }
    if ((paramAdvertisementInfo.mAdProductType == 30) || (paramAdvertisementInfo.mAdProductType == 41))
    {
      paramParams.videoCeilingSupportedIfNotInstalled = true;
      paramParams.videoCeilingSupportedIfInstalled = true;
      return;
    }
    paramParams.videoCeilingSupportedIfNotInstalled = false;
    paramParams.videoCeilingSupportedIfInstalled = false;
  }
  
  public static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ndi paramndi, int paramInt, boolean paramBoolean)
  {
    paramndi = a(paramContext, paramAdvertisementInfo, paramndi, paramInt, paramBoolean, null);
    if (paramndi == null) {
      return false;
    }
    return b(paramndi, paramContext, paramAdvertisementInfo);
  }
  
  public static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ndi paramndi, int paramInt, boolean paramBoolean, kks paramkks)
  {
    paramndi = a(paramContext, paramAdvertisementInfo, paramndi, paramInt, paramBoolean, paramkks);
    if (paramndi == null) {
      return false;
    }
    return b(paramndi, paramContext, paramAdvertisementInfo);
  }
  
  public static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ndi paramndi, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramndi = a(paramContext, paramAdvertisementInfo, paramndi, paramInt, paramBoolean1, null);
    if (paramndi == null) {
      return false;
    }
    paramndi.directPlay = paramBoolean2;
    return b(paramndi, paramContext, paramAdvertisementInfo);
  }
  
  public static boolean a(Context paramContext, AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramContext == null) || (!(paramContext instanceof Activity)) || (paramAdData == null) || (paramAdvertisementInfo == null)) {}
    while (!kmx.a(paramAdData)) {
      return false;
    }
    cn(paramContext);
    knd.f(paramAdvertisementInfo);
    kmx.b(paramContext, paramAdData);
    paramContext = (QQAppInterface)kxm.getAppRuntime();
    jzk.a(new kku.a().a(paramContext).a(BaseApplication.getContext()).a(jzk.aEJ).b(jzk.aFN).a(paramAdvertisementInfo).d(jzk.a(paramAdData)).a());
    return true;
  }
  
  private static boolean a(Context paramContext, ndi paramndi, ArticleInfo paramArticleInfo)
  {
    if ((paramndi == null) || (paramndi.nh() != 0)) {}
    klc.a locala;
    do
    {
      do
      {
        return false;
      } while (!TextUtils.isEmpty(a(paramArticleInfo, "AdsIconText")));
      kxm.a(paramArticleInfo);
      paramArticleInfo.innerUniqueID = a(paramArticleInfo, "landing_page_rowkey");
      locala = a(paramndi, paramArticleInfo.innerUniqueID);
    } while (locala == null);
    e(paramContext, paramArticleInfo, paramndi.nh());
    paramndi.a(locala.a(), paramArticleInfo);
    return true;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null) {
      com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 3, "JumpToGdtAdPage error advertisementInfo is null");
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
    } while (!kni.v(paramAdvertisementInfo));
    return true;
    if ((paramInt == 2) || (paramInt == 5) || (paramInt == 3) || (paramInt == 56) || (paramInt == 4) || (paramInt == 2000001) || (paramInt == 95555552) || ((knd.dh(paramInt)) && (!el(paramAdvertisementInfo.mAdJumpMode)) && (mb.contains(Integer.valueOf(paramAdvertisementInfo.mAdProductType)))) || (kni.v(paramAdvertisementInfo))) {
      return true;
    }
    com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 3, "readInjoy product not go Gdt QQB channelId:" + paramInt + " AdProductType:" + paramAdvertisementInfo.mAdProductType);
    return false;
  }
  
  private static boolean a(AdvertisementInfo paramAdvertisementInfo, Context paramContext)
  {
    paramAdvertisementInfo = new Intent("android.intent.action.VIEW", Uri.parse(paramAdvertisementInfo.mAdCustomizedInvokeUrl));
    paramAdvertisementInfo.addFlags(268435456);
    try
    {
      paramContext = paramAdvertisementInfo.resolveActivityInfo(paramContext.getPackageManager(), 0);
      paramAdvertisementInfo = "";
      if (paramContext != null) {
        paramAdvertisementInfo = paramContext.packageName;
      }
      boolean bool = TextUtils.isEmpty(paramAdvertisementInfo);
      if (!bool) {
        break label59;
      }
    }
    catch (Exception paramAdvertisementInfo)
    {
      label59:
      while (!com.tencent.TMG.utils.QLog.isColorLevel()) {}
      com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 1, "resolveActivityInfo error!", paramAdvertisementInfo);
    }
    return false;
    return true;
    return false;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo, ViewBase paramViewBase, Activity paramActivity, int paramInt, mye parammye, AdvertisementInfo paramAdvertisementInfo)
  {
    return false;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo, ndi paramndi)
  {
    if ((paramndi != null) && (paramndi.a() != null) && (paramndi.a().isPlaying()) && (paramndi.a().c() != null))
    {
      paramndi = paramndi.a().c();
      if ((paramndi.aqp) && (paramndi.d != null) && (AdvertisementInfo.isAdvertisementInfo(paramndi.d)))
      {
        paramndi = (AdvertisementInfo)paramndi.d;
        if ((!TextUtils.isEmpty(paramndi.mAdTraceId)) && ((paramArticleInfo instanceof AdvertisementInfo)) && (paramndi.mAdTraceId.equals(((AdvertisementInfo)paramArticleInfo).mAdTraceId))) {
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
      if (paramString == null) {
        return false;
      }
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("ReadinJoyActionUtil", 2, "jumpToLandingPage: packageName = " + paramString.packageName);
      }
      if (!TextUtils.isEmpty(paramString.packageName))
      {
        cn(paramActivity);
        paramActivity.startActivity(localIntent);
        return true;
      }
    }
    catch (Exception paramString)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("ReadinJoyActionUtil", 0, "jumpScheme: e = " + paramString.getMessage());
      }
    }
    return false;
  }
  
  public static boolean ac(ArticleInfo paramArticleInfo)
  {
    return (awz) && (paramArticleInfo != null) && ((paramArticleInfo instanceof AdvertisementInfo)) && (((AdvertisementInfo)paramArticleInfo).mAdFeedId != 0L) && (!TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdInteractionReportUrl));
  }
  
  public static void b(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("param_ad_info", paramAdvertisementInfo);
    ReadinjoyAdPKFragment.a(paramActivity, ReadinjoyAdPKFragment.class, localBundle);
  }
  
  private static void b(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, ndi paramndi, int paramInt, boolean paramBoolean) {}
  
  public static void b(Activity paramActivity, ArticleInfo paramArticleInfo, ndi paramndi, int paramInt)
  {
    Object localObject2 = kxm.f(paramArticleInfo);
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
      kbp.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), kxm.b(paramArticleInfo.mAlgorithmID, kxm.a(paramArticleInfo), paramInt, i), false);
      kbp.d("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), kxm.b(paramArticleInfo.mAlgorithmID, kxm.a(paramArticleInfo), paramInt, i));
      localObject3 = odv.aB(paramArticleInfo.mChannelID);
      if ((!ndi.S(paramArticleInfo)) && (!ndi.ak(paramArticleInfo)) && (!ndi.T(paramArticleInfo)) && (!ndi.U(paramArticleInfo))) {
        break label635;
      }
      kbp.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin), (String)localObject3, (String)localObject3, 0, 0, Long.toString(paramArticleInfo.mFeedId), paramArticleInfo.businessId + "", Integer.toString(paramArticleInfo.mStrategyId), kxm.a(paramArticleInfo.mAlgorithmID, kxm.a(paramArticleInfo), paramInt, i, j, aqiw.isWifiConnected(paramActivity), String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin), paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, kxm.h(paramArticleInfo), k, paramArticleInfo), false);
    }
    Object localObject1;
    for (;;)
    {
      kbp.d((String)localObject3, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), kxm.a(paramArticleInfo.mAlgorithmID, kxm.a(paramArticleInfo), paramInt, i, j, aqiw.isWifiConnected(paramActivity), (String)localObject2, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, kxm.h(paramArticleInfo), k, paramArticleInfo));
      paramndi = new ArrayList();
      localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = kxm.getLongAccountUin();
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
      localObject2 = new ReportInfo.a();
      ((ReportInfo.a)localObject2).vd = paramArticleInfo.mSocialFeedInfo.mFeedId;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) {
        ((ReportInfo.a)localObject2).vg = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
      }
      ((ReportInfo.a)localObject2).aSx = paramArticleInfo.mSocialFeedInfo.mLikeCount;
      ((ReportInfo.a)localObject2).aSy = paramArticleInfo.mSocialFeedInfo.mCommentCount;
      localObject3 = paramArticleInfo.mSocialFeedInfo.iS;
      if ((localObject3 == null) || (((List)localObject3).isEmpty())) {
        break label746;
      }
      ((ReportInfo.a)localObject2).iR = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        SocializeFeedsInfo.e locale = (SocializeFeedsInfo.e)((Iterator)localObject3).next();
        if (locale != null) {
          ((ReportInfo.a)localObject2).iR.add(Long.valueOf(locale.uin));
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
      localObject1 = kxm.a(paramArticleInfo.mAlgorithmID, kxm.a(paramArticleInfo), paramInt, i, j, aqiw.isWifiConnected(paramActivity), (String)localObject2, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, kxm.h(paramArticleInfo), k, paramArticleInfo);
      paramndi = (ndi)localObject1;
      if (paramInt == 0) {
        paramndi = kct.e(k, (String)kct.cZ.get(ReadInJoyChannelActivity.class), (String)localObject1);
      }
      kbp.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject3, (String)localObject3, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), paramndi, false);
    }
    label746:
    ((ReportInfo)localObject1).mFeedsReportData = ((ReportInfo.a)localObject2);
    label753:
    paramndi.add(localObject1);
    lbz.a().cb(paramndi);
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (paramArticleInfo.mChannelID == 56L) {
        jzk.a(new kku.a().a(paramActivity).a(jzk.aEJ).b(jzk.aFF).a((AdvertisementInfo)paramArticleInfo).d(((AdvertisementInfo)paramArticleInfo).clickPos).a());
      }
    }
    else {
      return;
    }
    if ((knd.r((AdvertisementInfo)paramArticleInfo)) && (knj.agB)) {
      paramInt = jzk.aFY;
    }
    for (;;)
    {
      jzk.a(new kku.a().a(paramActivity).a(jzk.aEJ).b(paramInt).a((AdvertisementInfo)paramArticleInfo).d(((AdvertisementInfo)paramArticleInfo).clickPos).a());
      return;
      if (a((AdvertisementInfo)paramArticleInfo, paramInt)) {
        paramInt = jzk.aFC;
      } else if (kxm.j(paramArticleInfo)) {
        paramInt = jzk.aFB;
      } else {
        paramInt = jzk.aFw;
      }
    }
  }
  
  public static void b(Context paramContext, ArticleInfo paramArticleInfo, ndi paramndi, int paramInt)
  {
    if ((paramndi != null) && (paramArticleInfo != null) && ((paramArticleInfo instanceof AdvertisementInfo)) && ((paramContext instanceof Activity)))
    {
      paramndi.a = a(paramContext, (AdvertisementInfo)paramArticleInfo, paramndi, paramInt, false, null);
      if (paramndi.a == null) {
        break label57;
      }
    }
    label57:
    for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
    {
      paramndi.sr = l;
      return;
    }
  }
  
  public static boolean b(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramContext == null) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage))) {}
    while (!knd.s(paramAdvertisementInfo)) {
      return false;
    }
    kxm.C(paramContext, paramAdvertisementInfo.mAdLandingPage);
    return true;
  }
  
  public static boolean b(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ndi paramndi, int paramInt, boolean paramBoolean)
  {
    paramContext = a(paramContext, paramAdvertisementInfo, paramndi, paramInt, paramBoolean, false, false, null);
    if (paramContext == null) {
      return false;
    }
    GdtHandler.a(paramContext);
    com.tencent.TMG.utils.QLog.i("ReadinJoyActionUtil", 3, "kandian JumpToTangramSDK");
    return true;
  }
  
  public static boolean b(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ndi paramndi, int paramInt, boolean paramBoolean, kks paramkks)
  {
    if (knd.s(paramAdvertisementInfo))
    {
      b(paramContext, paramAdvertisementInfo);
      return true;
    }
    paramndi = a(paramContext, paramAdvertisementInfo, paramndi, paramInt, paramBoolean, paramkks);
    if (paramndi == null) {
      return false;
    }
    return b(paramndi, paramContext, paramAdvertisementInfo);
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
        knd.f(paramAdvertisementInfo);
        if ((paramAdvertisementInfo.mAdJumpMode != 7) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage))) {
          break;
        }
        cn(paramContext);
        kxm.C(paramContext, paramAdvertisementInfo.mAdLandingPage);
      } while (!com.tencent.TMG.utils.QLog.isColorLevel());
      com.tencent.TMG.utils.QLog.i("ReadinJoyActionUtil", 3, "JumpToGdtAdPage tovialo true");
      return true;
      GdtHandler.a(paramParams);
    } while (!com.tencent.TMG.utils.QLog.isColorLevel());
    com.tencent.TMG.utils.QLog.i("ReadinJoyActionUtil", 3, "kandian JumpToTangramSDK");
    return true;
  }
  
  public static void c(mtg parammtg)
  {
    a(3, parammtg.a, parammtg.sr);
    parammtg.sr = -2147483648L;
    parammtg.a = null;
  }
  
  public static boolean c(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ndi paramndi, int paramInt, boolean paramBoolean, kks paramkks)
  {
    paramndi = a(paramContext, paramAdvertisementInfo, paramndi, paramInt, paramBoolean, false, false, paramkks);
    if (paramndi == null) {
      return false;
    }
    if (paramkks == null)
    {
      paramndi.videoCeilingSupportedIfInstalled = false;
      paramndi.videoCeilingSupportedIfNotInstalled = false;
    }
    return b(paramndi, paramContext, paramAdvertisementInfo);
  }
  
  public static void cn(Context paramContext)
  {
    try
    {
      arlc.aT(paramContext, 7);
      return;
    }
    catch (Exception paramContext)
    {
      while (!com.tencent.TMG.utils.QLog.isColorLevel()) {}
      com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 0, "closeFloatWindow error:" + paramContext.getMessage());
    }
  }
  
  public static void e(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    int i;
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (paramArticleInfo.mChannelID != 56L) {
        break label30;
      }
      i = jzk.aFx;
    }
    for (;;)
    {
      a(paramContext, paramArticleInfo, paramInt, i);
      label30:
      do
      {
        return;
        if ((knd.r((AdvertisementInfo)paramArticleInfo)) && (knj.agB))
        {
          i = jzk.aFY;
          break;
        }
        if (kxm.j(paramArticleInfo))
        {
          i = jzk.aFB;
          break;
        }
      } while ((knd.m((AdvertisementInfo)paramArticleInfo)) && (((AdvertisementInfo)paramArticleInfo).isClickFromPkFragment));
      if (a((AdvertisementInfo)paramArticleInfo, paramInt)) {
        i = jzk.aFC;
      } else if (((AdvertisementInfo)paramArticleInfo).isCommentAd()) {
        i = jzk.aFZ;
      } else {
        i = jzk.aFw;
      }
    }
  }
  
  public static boolean el(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 5);
  }
  
  private static void f(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
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
      String str1 = kxm.f(paramArticleInfo);
      String str2 = odv.aB(paramInt);
      kbp.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, str2, str2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), kxm.a(paramArticleInfo.mAlgorithmID, kxm.a(paramArticleInfo), paramInt, i, j, aqiw.isWifiConnected(paramContext), str1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, kxm.h(paramArticleInfo), paramArticleInfo), false);
      return;
      i = 0;
      break;
    }
  }
  
  public static String fr(String paramString)
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
      if (com.tencent.TMG.utils.QLog.isColorLevel())
      {
        str = paramString;
        com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 0, "appendUrlParameter, before url:" + paramString);
      }
      str = paramString;
      localObject = Uri.parse(paramString).buildUpon();
      str = paramString;
      ((Uri.Builder)localObject).appendQueryParameter("adclickts", String.valueOf(System.currentTimeMillis()));
      str = paramString;
      paramString = ((Uri.Builder)localObject).build().toString();
      localObject = paramString;
      str = paramString;
      if (com.tencent.TMG.utils.QLog.isColorLevel())
      {
        str = paramString;
        com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 0, "appendUrlParameter, after url:" + paramString);
        localObject = paramString;
      }
    }
    catch (Exception paramString)
    {
      do
      {
        localObject = str;
      } while (!com.tencent.TMG.utils.QLog.isColorLevel());
      com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 0, "appendUrlParameter, url:" + str + " , error:" + paramString.getMessage());
    }
    return localObject;
    return str;
  }
  
  public static void h(Context paramContext, String paramString1, String paramString2, String paramString3)
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
  
  public static void unRegisterReceiver()
  {
    if ((BaseApplicationImpl.getContext() != null) && (mGdtAppReceiver != null))
    {
      BaseApplicationImpl.getContext().unregisterReceiver(mGdtAppReceiver);
      mGdtAppReceiver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ods
 * JD-Core Version:    0.7.0.1
 */