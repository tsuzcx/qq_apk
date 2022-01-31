import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

@Deprecated
class yxn
  implements yxe
{
  public boolean a(ywk paramywk, String paramString, String... paramVarArgs)
  {
    if (paramywk != null) {}
    for (paramString = paramywk.a(); (paramywk == null) || (paramString == null); paramString = null)
    {
      yxp.d("GdtVideoCeilingJsCall", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = new JSONObject(paramVarArgs[0]);
        yxp.b("GdtVideoCeilingJsCall", ((JSONObject)localObject3).toString());
        Object localObject1 = ((JSONObject)localObject3).optString("videoUrl");
        paramVarArgs = ((JSONObject)localObject3).optString("webUrl");
        Object localObject7 = ((JSONObject)localObject3).optString("urlForImpression");
        String str6 = ((JSONObject)localObject3).optString("urlForClick");
        boolean bool1 = ((JSONObject)localObject3).optBoolean("videoLoop", true);
        boolean bool2 = ((JSONObject)localObject3).optBoolean("videoPlayForced");
        Object localObject5 = ((JSONObject)localObject3).optString("traceId");
        Object localObject4 = ((JSONObject)localObject3).optString("channel_id");
        String str1 = ((JSONObject)localObject3).optString("android_app_id");
        int i = ((JSONObject)localObject3).optInt("product_type");
        String str2 = ((JSONObject)localObject3).optString("pkg_url");
        String str3 = ((JSONObject)localObject3).optString("app_package_name");
        long l = ((JSONObject)localObject3).optLong("advertiser_id");
        String str4 = ((JSONObject)localObject3).optString("app_name");
        String str5 = ((JSONObject)localObject3).optString("logo_url");
        String str7 = ((JSONObject)localObject3).optString("effect_url");
        String str8 = ((JSONObject)localObject3).optString("landing_page_report_url");
        Object localObject6 = ((JSONObject)localObject3).optString("via");
        Object localObject2 = ((JSONObject)localObject3).optString("landing_page");
        String str9 = ((JSONObject)localObject3).optString("product_id");
        localObject3 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject3).exposure_url.set((String)localObject7);
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject3).click_url.set(str6);
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject3).effect_url.set(str7);
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject3).landing_page_report_url.set(str8);
        localObject7 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject7).traceid.set((String)localObject5);
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject7).via.set((String)localObject6);
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject7).product_id.set(str9);
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject3).trace_info.set((MessageMicro)localObject7);
        localObject5 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo();
        localObject6 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo();
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject6).advertiser_id.set(l);
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject6).corporate_image_name.set(str4);
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject6).corporate_logo.set(str5);
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo)localObject5).advertiser_info.set((MessageMicro)localObject6);
        localObject6 = new qq_ad_get.QQAdGetRsp.AdInfo.AppInfo();
        ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject6).app_logo_url.set(str5);
        ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject6).android_app_id.set(str1);
        ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject6).channel_id.set((String)localObject4);
        ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject6).app_name.set(str4);
        ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject6).app_package_name.set(str3);
        ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject6).pkg_url.set(str2);
        localObject4 = new qq_ad_get.QQAdGetRsp.AdInfo.DestInfo();
        ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject4).dest_type.set(1);
        ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject4).landing_page.set((String)localObject2);
        localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo();
        ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).report_info.set((MessageMicro)localObject3);
        ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).app_info.set((MessageMicro)localObject6);
        ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).product_type.set(i);
        ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).display_info.set((MessageMicro)localObject5);
        ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).dest_info.set((MessageMicro)localObject4);
        localObject2 = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject2);
        localObject3 = new GdtVideoData();
        ((GdtVideoData)localObject3).setUrl((String)localObject1);
        ((GdtVideoData)localObject3).setStartPositionMillis(0L);
        ((GdtVideoData)localObject3).setLoop(bool1);
        ((GdtVideoData)localObject3).setDirectPlay(bool2);
        localObject1 = new GdtVideoCeilingData();
        ((GdtVideoCeilingData)localObject1).setAd((GdtAd)localObject2);
        ((GdtVideoCeilingData)localObject1).setWebUrl(paramVarArgs);
        ((GdtVideoCeilingData)localObject1).setVideoData((GdtVideoData)localObject3);
        GdtVideoCeilingFragmentForJS.a(paramString, GdtVideoCeilingFragmentForJS.class, (GdtVideoCeilingData)localObject1);
        if (paramywk != null)
        {
          paramywk = paramywk.a();
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "showVideoCeiling", paramywk, (Ad)localObject2);
          return true;
        }
      }
      catch (JSONException paramywk)
      {
        yxp.d("GdtVideoCeilingJsCall", "handleJsCallRequest error", paramywk);
        return true;
      }
      paramywk = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yxn
 * JD-Core Version:    0.7.0.1
 */