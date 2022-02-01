import NS_KING_SOCIALIZE_META.stMetaTag;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import NS_MOBILE_FEEDS.s_button;
import NS_MOBILE_FEEDS.s_droplist_option;
import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stImgReplacement;
import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaGdtAdInfo;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForArk;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class urv
{
  public static int a;
  public static int b;
  
  static
  {
    jdField_a_of_type_Int = 94691;
    jdField_b_of_type_Int = 94692;
  }
  
  public static stSimpleMetaGdtAdInfo a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {
      return null;
    }
    stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = new stSimpleMetaGdtAdInfo();
    localstSimpleMetaGdtAdInfo.floatingLayerCardStyle = new stFloatingLayerCardStyle();
    localstSimpleMetaGdtAdInfo.bottomButton = new s_button();
    localstSimpleMetaGdtAdInfo.bottomButton.stMapABTest = new HashMap();
    localstSimpleMetaGdtAdInfo.user = new stSimpleMetaPerson();
    localstSimpleMetaGdtAdInfo.pictureUrl = new stImgReplacement();
    localstSimpleMetaGdtAdInfo.left_top_button = new stNewIconStyle();
    Object localObject2 = a(paramstSimpleMetaFeed);
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        localstSimpleMetaGdtAdInfo.isWeishiGdtTangramAdv = true;
        localstSimpleMetaGdtAdInfo.gdtTangramAdJson = paramstSimpleMetaFeed.gdt_ad_info;
        localstSimpleMetaGdtAdInfo.cellId = paramstSimpleMetaFeed.id;
        localstSimpleMetaGdtAdInfo.floatingLayerCardStyle.cardType = 1001;
        localObject1 = paramstSimpleMetaFeed.tags;
        if (((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).product_type.get() == 12)
        {
          localstSimpleMetaGdtAdInfo.cookie = new HashMap();
          localstSimpleMetaGdtAdInfo.cookie.put(Integer.valueOf(0), "app");
          if (((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).app_info != null) {
            localstSimpleMetaGdtAdInfo.appid = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).app_info.app_package_name.get();
          }
          localstSimpleMetaGdtAdInfo.bottomButton.text = anni.a(2131715020);
          localstSimpleMetaGdtAdInfo.bottomButton.button_background_img = "https://qzonestyle.gtimg.cn/aoi/sola/20180427113436_0gqVu4ZoCd.png";
          localstSimpleMetaGdtAdInfo.bottomButton.stMapABTest.put(Integer.valueOf(0), Integer.valueOf(1));
          localstSimpleMetaGdtAdInfo.playType = 2;
          localstSimpleMetaGdtAdInfo.videoType = 1001;
          localObject3 = paramstSimpleMetaFeed.video;
          if (localObject3 != null) {
            localstSimpleMetaGdtAdInfo.videoTime = ((stMetaUgcVideoSeg)localObject3).duration;
          }
          localObject3 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).exp_info;
          if (localObject3 != null) {
            ((qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo)localObject3).qq_game_video_ad_style.get();
          }
          localObject3 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).display_info;
          if (localObject3 != null)
          {
            localObject4 = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo)localObject3).advertiser_info;
            if (localObject4 != null)
            {
              localstSimpleMetaGdtAdInfo.user.nick = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject4).corporate_image_name.get();
              localstSimpleMetaGdtAdInfo.user.avatar = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject4).corporate_logo.get();
            }
            localObject3 = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo)localObject3).video_info;
            if (localObject3 != null)
            {
              localstSimpleMetaGdtAdInfo.video_url = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject3).video_url.get();
              localstSimpleMetaGdtAdInfo.videoId = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject3).tencent_video_id.get();
              localstSimpleMetaGdtAdInfo.videoClickType = 1;
            }
            localObject3 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).display_info.basic_info;
            if (localObject3 != null)
            {
              localstSimpleMetaGdtAdInfo.summary = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject3).txt.get();
              if (((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject3).img != null)
              {
                localstSimpleMetaGdtAdInfo.pictureUrl.img = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject3).img.get();
                localstSimpleMetaGdtAdInfo.pictureUrl.width = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject3).pic_width.get();
                localstSimpleMetaGdtAdInfo.pictureUrl.height = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject3).pic_height.get();
              }
            }
            localObject3 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).display_info.button_info.get();
            if ((localObject3 != null) && (((List)localObject3).size() > 0))
            {
              i = 0;
              if (i < ((List)localObject3).size())
              {
                localObject4 = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)((List)localObject3).get(i);
                if ((localObject4 == null) || (((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject4).pos == null) || (((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject4).pos.get() != 2)) {
                  break label902;
                }
                localstSimpleMetaGdtAdInfo.bottomButton.text = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject4).txt.get();
                break label902;
              }
            }
          }
        }
        else
        {
          localstSimpleMetaGdtAdInfo.bottomButton.text = anni.a(2131715022);
          continue;
        }
        localstSimpleMetaGdtAdInfo.customDroplist = new ArrayList();
      }
      catch (Exception paramstSimpleMetaFeed)
      {
        paramstSimpleMetaFeed.printStackTrace();
        return localstSimpleMetaGdtAdInfo;
      }
      Object localObject3 = new s_droplist_option();
      ((s_droplist_option)localObject3).actiontype = 40;
      ((s_droplist_option)localObject3).iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
      ((s_droplist_option)localObject3).optext = anni.a(2131715025);
      ((s_droplist_option)localObject3).reportattach = "option_actiontype=3&";
      ((s_droplist_option)localObject3).reporttype = 2001;
      Object localObject4 = new s_droplist_option();
      ((s_droplist_option)localObject4).actiontype = 2;
      ((s_droplist_option)localObject4).iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
      ((s_droplist_option)localObject4).jumpurl = " https://e.qq.com/mo/?from=wsgzh_mo&pid=7020009868695958&aid=763671&tid=iaedv5jxjoynq01";
      ((s_droplist_option)localObject4).optext = anni.a(2131715023);
      ((s_droplist_option)localObject4).reportattach = "option_actiontype=6&";
      localstSimpleMetaGdtAdInfo.customDroplist.add(localObject3);
      localstSimpleMetaGdtAdInfo.customDroplist.add(localObject4);
      localObject3 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).dest_info;
      if (localObject3 != null)
      {
        localstSimpleMetaGdtAdInfo.canvasData = ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject3).canvas_json.get();
        localstSimpleMetaGdtAdInfo.dest_url = ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject3).landing_page.get();
        localstSimpleMetaGdtAdInfo.dest_type = ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject3).dest_type.get();
      }
      localObject3 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).report_info;
      if (localObject3 != null)
      {
        localstSimpleMetaGdtAdInfo.reportUrl = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject3).negative_feedback_url.get();
        localstSimpleMetaGdtAdInfo.actionUrl = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject3).click_url.get();
        localstSimpleMetaGdtAdInfo.impressionUrl = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject3).exposure_url.get();
        localstSimpleMetaGdtAdInfo.isGdtAdImpressionReport = false;
      }
      localObject2 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).app_info;
      if (localObject2 != null)
      {
        localstSimpleMetaGdtAdInfo.rankCurrentWithHalfStar = ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject2).app_score_num.get();
        localstSimpleMetaGdtAdInfo.schemaPageUrl = ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject2).customized_invoke_url.get();
        localstSimpleMetaGdtAdInfo.appid = ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject2).app_package_name.get();
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((stMetaTag)((ArrayList)localObject1).get(0)).toString();
        localstSimpleMetaGdtAdInfo.left_top_button.img_url = ((String)localObject1);
      }
      localstSimpleMetaGdtAdInfo.mapPassBack = paramstSimpleMetaFeed.map_pass_back;
      continue;
      label902:
      i += 1;
    }
  }
  
  protected static String a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    String str = "";
    stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = a(paramstSimpleMetaFeed);
    paramstSimpleMetaFeed = str;
    if (localstSimpleMetaGdtAdInfo != null)
    {
      paramstSimpleMetaFeed = str;
      if (localstSimpleMetaGdtAdInfo.cookie != null) {
        paramstSimpleMetaFeed = (String)localstSimpleMetaGdtAdInfo.cookie.get(Integer.valueOf(0));
      }
    }
    if ((!TextUtils.isEmpty(paramstSimpleMetaFeed)) && ("app".equalsIgnoreCase(paramstSimpleMetaFeed))) {}
    for (int i = 1; (localstSimpleMetaGdtAdInfo != null) && (i != 0) && (a(paramContext, localstSimpleMetaGdtAdInfo.appid)); i = 0) {
      return "打开";
    }
    if ((localstSimpleMetaGdtAdInfo != null) && (localstSimpleMetaGdtAdInfo.bottomButton != null) && (!TextUtils.isEmpty(localstSimpleMetaGdtAdInfo.bottomButton.text))) {
      return localstSimpleMetaGdtAdInfo.bottomButton.text;
    }
    if (i != 0) {
      return "立即下载";
    }
    return "了解详情";
  }
  
  /* Error */
  private static String a(Context paramContext, uru paramuru)
  {
    // Byte code:
    //   0: ldc_w 417
    //   3: astore_3
    //   4: aload_1
    //   5: ifnull +260 -> 265
    //   8: aload_1
    //   9: invokevirtual 451	uru:a	()Ljava/lang/Object;
    //   12: instanceof 75
    //   15: ifeq +250 -> 265
    //   18: aload_1
    //   19: invokevirtual 451	uru:a	()Ljava/lang/Object;
    //   22: checkcast 75	UserGrowth/stSimpleMetaFeed
    //   25: astore 6
    //   27: aload 6
    //   29: invokestatic 69	urv:a	(LUserGrowth/stSimpleMetaFeed;)Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;
    //   32: astore 5
    //   34: aload 5
    //   36: getfield 128	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:app_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo;
    //   39: astore 4
    //   41: aload 5
    //   43: ifnull +222 -> 265
    //   46: aload 5
    //   48: getfield 101	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:product_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   51: ifnull +214 -> 265
    //   54: aload 4
    //   56: ifnull +209 -> 265
    //   59: aload 4
    //   61: getfield 134	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:app_package_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   64: ifnull +201 -> 265
    //   67: aload_3
    //   68: astore_1
    //   69: new 453	org/json/JSONObject
    //   72: dup
    //   73: aload 6
    //   75: getfield 79	UserGrowth/stSimpleMetaFeed:gdt_ad_info	Ljava/lang/String;
    //   78: invokespecial 456	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   81: ldc_w 458
    //   84: invokevirtual 462	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   87: iconst_0
    //   88: invokevirtual 468	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   91: ldc_w 470
    //   94: invokevirtual 462	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   97: iconst_0
    //   98: invokevirtual 468	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   101: ldc_w 471
    //   104: invokevirtual 475	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   107: ldc_w 477
    //   110: invokevirtual 481	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   113: astore_3
    //   114: aload_3
    //   115: astore_1
    //   116: aload_1
    //   117: astore_3
    //   118: aload_1
    //   119: invokestatic 430	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   122: ifne +89 -> 211
    //   125: aload 5
    //   127: getfield 101	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:product_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   130: invokevirtual 107	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   133: bipush 12
    //   135: if_icmpne +83 -> 218
    //   138: new 483	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 484	java/lang/StringBuilder:<init>	()V
    //   145: astore_3
    //   146: aload_0
    //   147: aload 4
    //   149: getfield 134	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:app_package_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   152: invokevirtual 139	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   155: invokestatic 437	urv:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   158: ifeq +55 -> 213
    //   161: iconst_2
    //   162: istore_2
    //   163: aload_1
    //   164: ldc_w 486
    //   167: aload_3
    //   168: iload_2
    //   169: invokevirtual 490	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: ldc_w 417
    //   175: invokevirtual 493	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 494	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokevirtual 498	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   184: astore_0
    //   185: aload_0
    //   186: astore_1
    //   187: aload_0
    //   188: ldc_w 500
    //   191: ldc_w 502
    //   194: invokevirtual 498	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   197: astore_0
    //   198: aload_0
    //   199: astore_1
    //   200: aload_0
    //   201: ldc_w 504
    //   204: ldc_w 506
    //   207: invokevirtual 498	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   210: astore_3
    //   211: aload_3
    //   212: areturn
    //   213: iconst_1
    //   214: istore_2
    //   215: goto -52 -> 163
    //   218: aload_1
    //   219: ldc_w 486
    //   222: ldc_w 506
    //   225: invokevirtual 498	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   228: astore_0
    //   229: goto -44 -> 185
    //   232: astore_0
    //   233: ldc_w 508
    //   236: new 483	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 484	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 510
    //   246: invokevirtual 493	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_0
    //   250: invokevirtual 513	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 494	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 519	upe:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload_1
    //   260: areturn
    //   261: astore_0
    //   262: goto -29 -> 233
    //   265: ldc_w 417
    //   268: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	paramContext	Context
    //   0	269	1	paramuru	uru
    //   162	53	2	i	int
    //   3	209	3	localObject	Object
    //   39	109	4	localAppInfo	qq_ad_get.QQAdGetRsp.AdInfo.AppInfo
    //   32	94	5	localAdInfo	qq_ad_get.QQAdGetRsp.AdInfo
    //   25	49	6	localstSimpleMetaFeed	stSimpleMetaFeed
    // Exception table:
    //   from	to	target	type
    //   69	114	232	java/lang/Throwable
    //   187	198	232	java/lang/Throwable
    //   200	211	232	java/lang/Throwable
    //   118	161	261	java/lang/Throwable
    //   163	185	261	java/lang/Throwable
    //   218	229	261	java/lang/Throwable
  }
  
  public static qq_ad_get.QQAdGetRsp.AdInfo a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed == null) || (TextUtils.isEmpty(paramstSimpleMetaFeed.gdt_ad_info))) {
      return null;
    }
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
    try
    {
      paramstSimpleMetaFeed = new JSONObject(paramstSimpleMetaFeed.gdt_ad_info).optJSONArray("pos_ads_info").getJSONObject(0).optJSONArray("ads_info").getJSONObject(0);
      paramstSimpleMetaFeed = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(acqx.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramstSimpleMetaFeed));
      return paramstSimpleMetaFeed;
    }
    catch (Throwable paramstSimpleMetaFeed)
    {
      paramstSimpleMetaFeed.printStackTrace();
    }
    return localAdInfo;
  }
  
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (a(paramstSimpleMetaFeed))) {}
    try
    {
      paramstSimpleMetaFeed = a(paramstSimpleMetaFeed);
      if (paramstSimpleMetaFeed != null)
      {
        paramstSimpleMetaFeed = new GdtAd(paramstSimpleMetaFeed);
        ackk.a().a(paramstSimpleMetaFeed);
      }
      return;
    }
    catch (Throwable paramstSimpleMetaFeed)
    {
      upe.d("GdtAdUtil", "adPreLoad error" + paramstSimpleMetaFeed);
    }
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString)))
    {
      QZLog.w("GdtAdUtil", "[forwardToBrowser] invalid parameters, context=" + paramActivity + ", url=" + paramString);
      return;
    }
    if ((paramActivity instanceof BasePluginActivity))
    {
      blsb.a(((BasePluginActivity)paramActivity).getOutActivity(), paramString, paramInt, paramBundle, null);
      return;
    }
    blsb.a(paramActivity, paramString, paramInt, paramBundle, null);
  }
  
  public static void a(Context paramContext, int paramInt1, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt2)
  {
    upe.b("GdtAdUtil", 2, "[onItemClick] action=" + paramInt1);
    if (paramstSimpleMetaFeed.gdt_ad_info == null) {
      return;
    }
    stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = new stSimpleMetaGdtAdInfo();
    localstSimpleMetaGdtAdInfo.customDroplist = new ArrayList();
    paramstSimpleMetaFeed = a(paramstSimpleMetaFeed);
    for (;;)
    {
      s_droplist_option locals_droplist_option;
      try
      {
        paramstSimpleMetaFeed = paramstSimpleMetaFeed.display_info;
        if (paramstSimpleMetaFeed != null)
        {
          paramstSimpleMetaFeed = paramstSimpleMetaFeed.video_info;
          if (paramstSimpleMetaFeed != null)
          {
            localstSimpleMetaGdtAdInfo.video_url = paramstSimpleMetaFeed.video_url.get();
            localstSimpleMetaGdtAdInfo.videoId = paramstSimpleMetaFeed.tencent_video_id.get();
            localstSimpleMetaGdtAdInfo.videoClickType = 1;
          }
        }
        paramstSimpleMetaFeed = new s_droplist_option();
        paramstSimpleMetaFeed.actiontype = 40;
        paramstSimpleMetaFeed.iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
        paramstSimpleMetaFeed.optext = anni.a(2131715025);
        paramstSimpleMetaFeed.reportattach = "option_actiontype=3&";
        paramstSimpleMetaFeed.reporttype = 2001;
        locals_droplist_option = new s_droplist_option();
        locals_droplist_option.actiontype = 2;
        locals_droplist_option.iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
        locals_droplist_option.jumpurl = " https://e.qq.com/mo/?from=wsgzh_mo&pid=7020009868695958&aid=763671&tid=iaedv5jxjoynq01";
        locals_droplist_option.optext = anni.a(2131715023);
        locals_droplist_option.reportattach = "option_actiontype=6&";
        localstSimpleMetaGdtAdInfo.customDroplist.add(paramstSimpleMetaFeed);
        localstSimpleMetaGdtAdInfo.customDroplist.add(locals_droplist_option);
        switch (paramInt1)
        {
        case 131072: 
          upe.b("GdtAdUtil", "invalid action, " + paramInt1);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      a(paramContext, locals_droplist_option);
      return;
    }
  }
  
  public static void a(Context paramContext, s_droplist_option params_droplist_option)
  {
    if (paramContext == null)
    {
      QZLog.w("GdtAdUtil", "[onOpenBrowser] no context");
      return;
    }
    if ((params_droplist_option == null) || (TextUtils.isEmpty(params_droplist_option.jumpurl)))
    {
      QZLog.w("GdtAdUtil", "[onOpenBrowser] no jumpUrl");
      return;
    }
    if ((paramContext instanceof BasePluginActivity)) {}
    for (paramContext = (BasePluginActivity)paramContext;; paramContext = (Activity)paramContext)
    {
      a(paramContext, params_droplist_option.jumpurl, null, -1);
      return;
    }
  }
  
  public static void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramContext == null) || (paramstSimpleMetaFeed == null)) {}
    do
    {
      return;
      paramContext = a(paramContext, paramstSimpleMetaFeed);
    } while (TextUtils.isEmpty(paramContext));
    paramstSimpleMetaFeed.new_icon.title = paramContext;
  }
  
  public static void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed, GdtAppReceiver paramGdtAppReceiver, ukb paramukb)
  {
    if ((paramstSimpleMetaFeed == null) && (paramstSimpleMetaFeed.gdt_ad_info == null)) {
      return;
    }
    paramstSimpleMetaFeed = a(paramstSimpleMetaFeed);
    try
    {
      paramukb = new GdtHandler.Params();
      paramukb.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)paramContext);
      paramukb.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramstSimpleMetaFeed);
      paramukb.jdField_a_of_type_Boolean = true;
      paramukb.jdField_a_of_type_Int = 8;
      paramukb.jdField_b_of_type_Int = 6;
      paramukb.jdField_b_of_type_Boolean = true;
      paramukb.jdField_c_of_type_Int = 7;
      paramukb.jdField_c_of_type_Boolean = false;
      paramukb.d = false;
      paramukb.e = false;
      paramukb.f = true;
      paramukb.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramGdtAppReceiver);
      paramukb.jdField_a_of_type_JavaLangClass = GdtVideoCeilingFragmentForJS.class;
      paramukb.jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForArk.class;
      paramukb.jdField_a_of_type_AndroidOsBundle = new Bundle();
      paramukb.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_gzh_weishi");
      GdtHandler.a(paramukb);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed, String paramString)
  {
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = a(paramstSimpleMetaFeed);
    paramstSimpleMetaFeed.poster = new stSimpleMetaPerson();
    paramstSimpleMetaFeed.imgReplacements = new ArrayList();
    paramstSimpleMetaFeed.new_icon = new stNewIconStyle();
    paramstSimpleMetaFeed.video = new stMetaUgcVideoSeg();
    for (;;)
    {
      try
      {
        stFloatingLayerCardStyle localstFloatingLayerCardStyle = paramstSimpleMetaFeed.floatingLayerCardStyle;
        if (TextUtils.equals("aio_home_page", paramString))
        {
          i = 1002;
          localstFloatingLayerCardStyle.cardType = i;
          paramstSimpleMetaFeed.video_type = 2;
          paramString = paramstSimpleMetaFeed.tags;
          a(paramContext, paramstSimpleMetaFeed);
          paramContext = localAdInfo.exp_info;
          if (paramContext != null) {
            paramContext.qq_game_video_ad_style.get();
          }
          paramContext = localAdInfo.display_info;
          if (paramContext == null) {
            break;
          }
          paramString = paramContext.advertiser_info;
          if (paramString != null)
          {
            paramstSimpleMetaFeed.poster.nick = paramString.corporate_image_name.get();
            paramstSimpleMetaFeed.poster.avatar = paramString.corporate_logo.get();
          }
          paramContext = paramContext.video_info;
          if (paramContext != null)
          {
            paramstSimpleMetaFeed.video_url = paramContext.video_url.get();
            paramstSimpleMetaFeed.video.duration = paramContext.media_duration.get();
          }
          paramContext = localAdInfo.display_info.basic_info;
          paramString = new stImgReplacement();
          if ((paramContext == null) || (paramString == null) || (paramstSimpleMetaFeed.imgReplacements == null) || (paramstSimpleMetaFeed.video == null)) {
            break;
          }
          paramstSimpleMetaFeed.feed_desc = paramContext.txt.get();
          paramString.img = paramContext.img.get();
          paramString.width = paramContext.pic_width.get();
          paramString.height = paramContext.pic_height.get();
          paramstSimpleMetaFeed.imgReplacements.add(paramString);
          paramstSimpleMetaFeed.video.width = paramContext.pic_width.get();
          paramstSimpleMetaFeed.video.height = paramContext.pic_height.get();
          return;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      int i = 1001;
    }
  }
  
  public static void a(Context paramContext, uru paramuru)
  {
    if ((paramuru != null) && ((paramuru.a() instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramuru.a();
      stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = paramuru.a();
      if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.gdt_ad_type == 1) && (localstSimpleMetaFeed.gdt_ad_info != null) && (localstSimpleMetaGdtAdInfo != null) && (!TextUtils.isEmpty(localstSimpleMetaGdtAdInfo.impressionUrl)) && (!localstSimpleMetaGdtAdInfo.isGdtAdImpressionReport))
      {
        GdtReporter.doCgiReport(localstSimpleMetaGdtAdInfo.impressionUrl);
        b(paramContext, paramuru);
        localstSimpleMetaGdtAdInfo.isGdtAdImpressionReport = true;
      }
    }
  }
  
  public static boolean a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    boolean bool2 = bool4;
    label199:
    for (;;)
    {
      try
      {
        paramstSimpleMetaFeed = a(paramstSimpleMetaFeed).ext_json;
        boolean bool3 = bool5;
        if (paramstSimpleMetaFeed != null)
        {
          bool2 = bool4;
          paramstSimpleMetaFeed = new JSONObject(paramstSimpleMetaFeed.get()).getJSONArray("exp_map");
          bool2 = bool4;
          bool3 = bool5;
          if (paramstSimpleMetaFeed.length() > 0)
          {
            int i = 0;
            bool2 = bool1;
            bool3 = bool1;
            if (i < paramstSimpleMetaFeed.length())
            {
              bool2 = bool1;
              JSONObject localJSONObject = (JSONObject)paramstSimpleMetaFeed.get(i);
              bool2 = bool1;
              if (!localJSONObject.has("key")) {
                break label199;
              }
              bool2 = bool1;
              if (localJSONObject.getInt("key") != jdField_a_of_type_Int) {
                break label199;
              }
              bool2 = bool1;
              if (!localJSONObject.has("value")) {
                break label199;
              }
              bool2 = bool1;
              int j = localJSONObject.getInt("value");
              if (j != 1) {
                break label199;
              }
              bool1 = true;
              i += 1;
              continue;
            }
          }
        }
        return bool3;
      }
      catch (Throwable paramstSimpleMetaFeed)
      {
        upe.d("GdtAdUtil", "adInfo error" + paramstSimpleMetaFeed);
        bool3 = bool2;
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
        if (paramContext == null) {
          continue;
        }
        return true;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          QZLog.w(paramContext);
          paramContext = null;
        }
      }
    }
  }
  
  private static void b(Context paramContext, uru paramuru)
  {
    paramContext = a(paramContext, paramuru);
    if (!TextUtils.isEmpty(paramContext))
    {
      GdtReporter.doCgiReport(paramContext);
      QZLog.i("GdtAdUtil", "GDT_CGI_REPORT" + paramContext);
    }
  }
  
  public static boolean b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    boolean bool2 = bool4;
    label199:
    for (;;)
    {
      try
      {
        paramstSimpleMetaFeed = a(paramstSimpleMetaFeed).ext_json;
        boolean bool3 = bool5;
        if (paramstSimpleMetaFeed != null)
        {
          bool2 = bool4;
          paramstSimpleMetaFeed = new JSONObject(paramstSimpleMetaFeed.get()).getJSONArray("exp_map");
          bool2 = bool4;
          bool3 = bool5;
          if (paramstSimpleMetaFeed.length() > 0)
          {
            int i = 0;
            bool2 = bool1;
            bool3 = bool1;
            if (i < paramstSimpleMetaFeed.length())
            {
              bool2 = bool1;
              JSONObject localJSONObject = (JSONObject)paramstSimpleMetaFeed.get(i);
              bool2 = bool1;
              if (!localJSONObject.has("key")) {
                break label199;
              }
              bool2 = bool1;
              if (localJSONObject.getInt("key") != jdField_b_of_type_Int) {
                break label199;
              }
              bool2 = bool1;
              if (!localJSONObject.has("value")) {
                break label199;
              }
              bool2 = bool1;
              int j = localJSONObject.getInt("value");
              if (j != 1) {
                break label199;
              }
              bool1 = true;
              i += 1;
              continue;
            }
          }
        }
        return bool3;
      }
      catch (Throwable paramstSimpleMetaFeed)
      {
        upe.d("GdtAdUtil", "adInfo error" + paramstSimpleMetaFeed);
        bool3 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urv
 * JD-Core Version:    0.7.0.1
 */