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
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForArk;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class oqs
{
  public static int bfK = 94691;
  
  public static stSimpleMetaGdtAdInfo a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {}
    do
    {
      return null;
      localstSimpleMetaGdtAdInfo = new stSimpleMetaGdtAdInfo();
      localstSimpleMetaGdtAdInfo.floatingLayerCardStyle = new stFloatingLayerCardStyle();
      localstSimpleMetaGdtAdInfo.bottomButton = new s_button();
      localstSimpleMetaGdtAdInfo.bottomButton.stMapABTest = new HashMap();
      localstSimpleMetaGdtAdInfo.user = new stSimpleMetaPerson();
      localstSimpleMetaGdtAdInfo.pictureUrl = new stImgReplacement();
      localstSimpleMetaGdtAdInfo.left_top_button = new stNewIconStyle();
    } while (TextUtils.isEmpty(paramstSimpleMetaFeed.gdt_ad_info));
    try
    {
      Object localObject1 = new JSONObject(paramstSimpleMetaFeed.gdt_ad_info).optJSONArray("pos_ads_info").getJSONObject(0).optJSONArray("ads_info").getJSONObject(0);
      Object localObject2 = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject1));
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
      }
      for (localstSimpleMetaGdtAdInfo.bottomButton.text = acfp.aE(2130969802);; localstSimpleMetaGdtAdInfo.bottomButton.text = acfp.aE(2130969804))
      {
        localstSimpleMetaGdtAdInfo.bottomButton.button_background_img = "https://qzonestyle.gtimg.cn/aoi/sola/20180427113436_0gqVu4ZoCd.png";
        localstSimpleMetaGdtAdInfo.bottomButton.stMapABTest.put(Integer.valueOf(0), Integer.valueOf(1));
        localstSimpleMetaGdtAdInfo.playType = 2;
        localstSimpleMetaGdtAdInfo.videoType = 1001;
        Object localObject3 = paramstSimpleMetaFeed.video;
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
        }
        localstSimpleMetaGdtAdInfo.customDroplist = new ArrayList();
        localObject3 = new s_droplist_option();
        ((s_droplist_option)localObject3).actiontype = 40;
        ((s_droplist_option)localObject3).iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
        ((s_droplist_option)localObject3).optext = acfp.aE(2130969807);
        ((s_droplist_option)localObject3).reportattach = "option_actiontype=3&";
        ((s_droplist_option)localObject3).reporttype = 2001;
        Object localObject4 = new s_droplist_option();
        ((s_droplist_option)localObject4).actiontype = 2;
        ((s_droplist_option)localObject4).iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
        ((s_droplist_option)localObject4).jumpurl = " http://e.qq.com/mo/?from=wsgzh_mo&pid=7020009868695958&aid=763671&tid=iaedv5jxjoynq01";
        ((s_droplist_option)localObject4).optext = acfp.aE(2130969805);
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
        }
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          localObject1 = ((stMetaTag)((ArrayList)localObject1).get(0)).toString();
          localstSimpleMetaGdtAdInfo.left_top_button.img_url = ((String)localObject1);
        }
        localstSimpleMetaGdtAdInfo.mapPassBack = paramstSimpleMetaFeed.map_pass_back;
        break;
      }
      return localstSimpleMetaGdtAdInfo;
    }
    catch (Exception paramstSimpleMetaFeed)
    {
      paramstSimpleMetaFeed.printStackTrace();
    }
  }
  
  public static void a(Context paramContext, int paramInt1, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt2)
  {
    ooz.d("GdtAdUtil", 2, "[onItemClick] action=" + paramInt1);
    if (paramstSimpleMetaFeed.gdt_ad_info == null) {
      return;
    }
    stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = new stSimpleMetaGdtAdInfo();
    localstSimpleMetaGdtAdInfo.customDroplist = new ArrayList();
    try
    {
      paramstSimpleMetaFeed = new JSONObject(paramstSimpleMetaFeed.gdt_ad_info).optJSONArray("pos_ads_info").getJSONObject(0).optJSONArray("ads_info").getJSONObject(0);
      paramstSimpleMetaFeed = ((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), paramstSimpleMetaFeed))).display_info;
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
      paramstSimpleMetaFeed.optext = acfp.aE(2130969807);
      paramstSimpleMetaFeed.reportattach = "option_actiontype=3&";
      paramstSimpleMetaFeed.reporttype = 2001;
      s_droplist_option locals_droplist_option = new s_droplist_option();
      locals_droplist_option.actiontype = 2;
      locals_droplist_option.iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
      locals_droplist_option.jumpurl = " https://e.qq.com/mo/?from=wsgzh_mo&pid=7020009868695958&aid=763671&tid=iaedv5jxjoynq01";
      locals_droplist_option.optext = acfp.aE(2130969805);
      locals_droplist_option.reportattach = "option_actiontype=6&";
      localstSimpleMetaGdtAdInfo.customDroplist.add(paramstSimpleMetaFeed);
      localstSimpleMetaGdtAdInfo.customDroplist.add(locals_droplist_option);
      switch (paramInt1)
      {
      }
      for (;;)
      {
        ooz.d("GdtAdUtil", "invalid action, " + paramInt1);
        return;
        a(paramContext, locals_droplist_option);
        return;
      }
      return;
    }
    catch (Exception paramContext) {}
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
      forwardToBrowser(paramContext, params_droplist_option.jumpurl, null, -1);
      return;
    }
  }
  
  public static void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed, GdtAppReceiver paramGdtAppReceiver)
  {
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.gdt_ad_info != null)) {}
    try
    {
      GdtHandler.Params localParams = new GdtHandler.Params();
      paramstSimpleMetaFeed = new JSONObject(paramstSimpleMetaFeed.gdt_ad_info).optJSONArray("pos_ads_info").getJSONObject(0).optJSONArray("ads_info").getJSONObject(0);
      paramstSimpleMetaFeed = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), paramstSimpleMetaFeed));
      localParams.activity = new WeakReference((Activity)paramContext);
      localParams.ad = new GdtAd(paramstSimpleMetaFeed);
      localParams.reportForClick = true;
      localParams.sceneID = 8;
      localParams.componentID = 6;
      localParams.aOV = true;
      localParams.processId = 7;
      localParams.videoCeilingSupportedIfNotInstalled = false;
      localParams.videoCeilingSupportedIfInstalled = false;
      localParams.videoSpliceSupported = false;
      localParams.directPlay = true;
      localParams.appReceiver = new WeakReference(paramGdtAppReceiver);
      localParams.n = GdtVideoCeilingFragmentForJS.class;
      localParams.p = GdtCanvasFragmentForArk.class;
      localParams.extra = new Bundle();
      localParams.extra.putString("big_brother_ref_source_key", "biz_src_gzh_weishi");
      GdtHandler.a(localParams);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(oqr paramoqr)
  {
    if ((paramoqr != null) && ((paramoqr.B() instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramoqr.B();
      paramoqr = paramoqr.a();
      if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.gdt_ad_type == 1) && (localstSimpleMetaFeed.gdt_ad_info != null) && (paramoqr != null) && (!TextUtils.isEmpty(paramoqr.impressionUrl)) && (!paramoqr.isGdtAdImpressionReport))
      {
        GdtReporter.doCgiReport(paramoqr.impressionUrl);
        paramoqr.isGdtAdImpressionReport = true;
      }
    }
  }
  
  public static boolean a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    boolean bool2 = bool4;
    label248:
    for (;;)
    {
      try
      {
        paramstSimpleMetaFeed = new JSONObject(paramstSimpleMetaFeed.gdt_ad_info).optJSONArray("pos_ads_info").getJSONObject(0).optJSONArray("ads_info").getJSONObject(0);
        bool2 = bool4;
        paramstSimpleMetaFeed = ((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), paramstSimpleMetaFeed))).ext_json;
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
                break label248;
              }
              bool2 = bool1;
              if (localJSONObject.getInt("key") != bfK) {
                break label248;
              }
              bool2 = bool1;
              if (!localJSONObject.has("value")) {
                break label248;
              }
              bool2 = bool1;
              int j = localJSONObject.getInt("value");
              if (j != 1) {
                break label248;
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
        ooz.e("GdtAdUtil", "adInfo error" + paramstSimpleMetaFeed);
        bool3 = bool2;
      }
    }
  }
  
  public static void e(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {}
    do
    {
      return;
      paramstSimpleMetaFeed.poster = new stSimpleMetaPerson();
      paramstSimpleMetaFeed.imgReplacements = new ArrayList();
      paramstSimpleMetaFeed.new_icon = new stNewIconStyle();
      paramstSimpleMetaFeed.video = new stMetaUgcVideoSeg();
    } while (TextUtils.isEmpty(paramstSimpleMetaFeed.gdt_ad_info));
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramstSimpleMetaFeed.gdt_ad_info).optJSONArray("pos_ads_info").getJSONObject(0).optJSONArray("ads_info").getJSONObject(0);
        localObject1 = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject1));
        paramstSimpleMetaFeed.floatingLayerCardStyle.cardType = 1001;
        paramstSimpleMetaFeed.video_type = 2;
        Object localObject2 = paramstSimpleMetaFeed.tags;
        if (((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).product_type.get() == 12)
        {
          paramstSimpleMetaFeed.new_icon.title = acfp.aE(2130969802);
          localObject2 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).exp_info;
          if (localObject2 != null) {
            ((qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo)localObject2).qq_game_video_ad_style.get();
          }
          localObject2 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info;
          if (localObject2 == null) {
            break;
          }
          qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo localAdvertiserInfo = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo)localObject2).advertiser_info;
          if (localAdvertiserInfo != null)
          {
            paramstSimpleMetaFeed.poster.nick = localAdvertiserInfo.corporate_image_name.get();
            paramstSimpleMetaFeed.poster.avatar = localAdvertiserInfo.corporate_logo.get();
          }
          localObject2 = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo)localObject2).video_info;
          if (localObject2 != null) {
            paramstSimpleMetaFeed.video_url = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject2).video_url.get();
          }
          localObject1 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.basic_info;
          localObject2 = new stImgReplacement();
          if ((localObject1 == null) || (localObject2 == null) || (paramstSimpleMetaFeed.imgReplacements == null) || (paramstSimpleMetaFeed.video == null)) {
            break;
          }
          paramstSimpleMetaFeed.feed_desc = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject1).txt.get();
          ((stImgReplacement)localObject2).img = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject1).img.get();
          ((stImgReplacement)localObject2).width = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject1).pic_width.get();
          ((stImgReplacement)localObject2).height = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject1).pic_height.get();
          paramstSimpleMetaFeed.imgReplacements.add(localObject2);
          paramstSimpleMetaFeed.video.width = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject1).pic_width.get();
          paramstSimpleMetaFeed.video.height = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject1).pic_height.get();
          return;
        }
      }
      catch (Exception paramstSimpleMetaFeed)
      {
        paramstSimpleMetaFeed.printStackTrace();
        return;
      }
      paramstSimpleMetaFeed.new_icon.title = acfp.aE(2130969804);
    }
  }
  
  public static void f(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (a(paramstSimpleMetaFeed))) {}
    try
    {
      paramstSimpleMetaFeed = new JSONObject(paramstSimpleMetaFeed.gdt_ad_info).optJSONArray("pos_ads_info").getJSONObject(0).optJSONArray("ads_info").getJSONObject(0);
      paramstSimpleMetaFeed = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), paramstSimpleMetaFeed)));
      tgh.a().a(paramstSimpleMetaFeed);
      return;
    }
    catch (Throwable paramstSimpleMetaFeed)
    {
      ooz.e("GdtAdUtil", "adPreLoad error" + paramstSimpleMetaFeed);
    }
  }
  
  public static void forwardToBrowser(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString)))
    {
      QZLog.w("GdtAdUtil", "[forwardToBrowser] invalid parameters, context=" + paramActivity + ", url=" + paramString);
      return;
    }
    if ((paramActivity instanceof BasePluginActivity))
    {
      avpw.forwardToBrowser(((BasePluginActivity)paramActivity).getOutActivity(), paramString, paramInt, paramBundle, null);
      return;
    }
    avpw.forwardToBrowser(paramActivity, paramString, paramInt, paramBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oqs
 * JD-Core Version:    0.7.0.1
 */