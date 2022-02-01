package cooperation.qqreader.host.advertisement;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import avoc;
import avod;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForJS;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import com.tencent.mobileqq.fragment.ReaderAdVideoCeilingFragment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.ExternalExpInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MutiPicTextInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;
import tgc;
import tgc.a;
import tgc.b;
import tgg;
import tkv;
import tkw;
import tld;
import tld.a;

public class ReaderGdtSdk
{
  public static void bindViewForReport(View paramView, ReportListener paramReportListener)
  {
    if (paramReportListener != null)
    {
      paramView.setTag(2131381958, ReportListener.a(paramReportListener).a());
      paramView.setTag(2131381957, paramReportListener);
      return;
    }
    paramView.setTag(2131381958, null);
    paramView.setTag(2131381957, null);
  }
  
  public static void cleanImpressionCountingMap()
  {
    tld.a().bDG();
  }
  
  public static void handleClick(@Nullable ContextWrapper paramContextWrapper, @NonNull ReaderAdWrapper paramReaderAdWrapper, GdtAppReceiverWrapper paramGdtAppReceiverWrapper)
  {
    handleClick(paramContextWrapper, paramReaderAdWrapper, paramGdtAppReceiverWrapper, 0);
  }
  
  public static void handleClick(@Nullable ContextWrapper paramContextWrapper, @NonNull ReaderAdWrapper paramReaderAdWrapper, GdtAppReceiverWrapper paramGdtAppReceiverWrapper, int paramInt)
  {
    paramContextWrapper = avod.getActivity(paramContextWrapper);
    if (paramContextWrapper == null)
    {
      avoc.e("ReaderGdtSdkProvider", "handleClick: act == null");
      return;
    }
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.processId = 7;
    localParams.activity = new WeakReference(paramContextWrapper);
    localParams.ad = paramReaderAdWrapper.a();
    localParams.reportForClick = true;
    localParams.aOV = true;
    if (paramGdtAppReceiverWrapper != null) {}
    for (paramContextWrapper = GdtAppReceiverWrapper.a(paramGdtAppReceiverWrapper);; paramContextWrapper = null)
    {
      localParams.appReceiver = new WeakReference(paramContextWrapper);
      localParams.p = GdtCanvasFragmentForJS.class;
      if (paramReaderAdWrapper.isVideoAd())
      {
        localParams.n = ReaderAdVideoCeilingFragment.class;
        localParams.videoCeilingSupportedIfNotInstalled = true;
        localParams.videoCeilingSupportedIfInstalled = false;
      }
      if (localParams.extra == null) {
        localParams.extra = new Bundle();
      }
      localParams.extra.putString("big_brother_ref_source_key", "biz_src_jc_neirong");
      localParams.videoStartPositionMillis = paramInt;
      GdtHandler.a(localParams);
      return;
    }
  }
  
  public static boolean isBackFromMotiveVideoPage(int paramInt)
  {
    return paramInt == 101;
  }
  
  public static boolean isProfitableForMotiveVideo(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getBooleanExtra("profitable_flag", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void jumpToMotiveVideoPage(ContextWrapper paramContextWrapper, ReaderAdWrapper paramReaderAdWrapper)
  {
    Activity localActivity = avod.getActivity(paramContextWrapper);
    GdtAd localGdtAd;
    if ((localActivity != null) && (paramReaderAdWrapper.a() != null))
    {
      localGdtAd = paramReaderAdWrapper.a();
      paramReaderAdWrapper = new GdtMotiveVideoPageData();
      paramReaderAdWrapper.productType = localGdtAd.getProductType();
      paramReaderAdWrapper.vSize = localGdtAd.getCreativeSize();
      paramReaderAdWrapper.screenOrientation = 1;
      paramReaderAdWrapper.adId = localGdtAd.getAdvertiserId();
      paramReaderAdWrapper.vid = localGdtAd.getTencent_video_id();
      paramReaderAdWrapper.url = localGdtAd.getVideoUrl();
      tkw.e("ReaderGdtSdkProvider", "VideoUrl " + paramReaderAdWrapper.url);
      if ((!TextUtils.isEmpty(paramReaderAdWrapper.url)) && (paramReaderAdWrapper.url.startsWith("https://"))) {
        paramReaderAdWrapper.url = paramReaderAdWrapper.url.replaceFirst("https://", "http://");
      }
      if (localGdtAd.getImageData() != null) {
        break label258;
      }
      paramContextWrapper = "";
      paramReaderAdWrapper.previewImgUrl = paramContextWrapper;
      paramReaderAdWrapper.bannerImgName = localGdtAd.getAdvertiser_corporate_image_name();
      paramReaderAdWrapper.bannerBaseInfoText = localGdtAd.getText();
      paramReaderAdWrapper.bannerLogo = localGdtAd.getAdvertiser_corporate_logo();
      paramReaderAdWrapper.exposureUrl = localGdtAd.getUrlForImpression();
      paramReaderAdWrapper.appScore = Double.valueOf(localGdtAd.getAppScore()).doubleValue();
      paramReaderAdWrapper.downloadNum = localGdtAd.getAppDownloadNum();
      paramReaderAdWrapper.style = localGdtAd.getStyle();
      paramContextWrapper = tkv.pbToJson(localGdtAd.info);
      if (paramContextWrapper != null) {
        break label269;
      }
    }
    label258:
    label269:
    for (paramContextWrapper = "";; paramContextWrapper = paramContextWrapper.toString())
    {
      paramReaderAdWrapper.adsContent = paramContextWrapper;
      paramReaderAdWrapper.processId = BaseApplicationImpl.sProcessId;
      paramReaderAdWrapper.refId = "biz_src_jc_neirong";
      GdtMotiveVideoFragment.b(localActivity, GdtMotiveVideoFragment.class, paramReaderAdWrapper);
      return;
      paramContextWrapper = localGdtAd.getImageData().url;
      break;
    }
  }
  
  public static void reportImpression(View paramView)
  {
    tld.a().g(paramView);
  }
  
  public static void requestAdData(Context paramContext, Map<String, Integer> paramMap, String paramString1, String paramString2, RequestListener paramRequestListener)
  {
    qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
    Object localObject = new qq_ad_get.QQAdGet.UserInfo();
    ((qq_ad_get.QQAdGet.UserInfo)localObject).qq.set(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    localQQAdGet.user_info.set((MessageMicro)localObject, true);
    localObject = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject).deep_link_version.set(1, true);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (((Integer)localEntry.getValue()).intValue() > 0)
      {
        qq_ad_get.QQAdGet.PositionInfo localPositionInfo = new qq_ad_get.QQAdGet.PositionInfo();
        localPositionInfo.pos_id.set((String)localEntry.getKey(), true);
        localPositionInfo.ad_count.set(((Integer)localEntry.getValue()).intValue(), true);
        localPositionInfo.pos_ext.set((MessageMicro)localObject, true);
        localQQAdGet.position_info.add(localPositionInfo);
      }
    }
    localQQAdGet.gdt_cookie.set(paramString1, true);
    localQQAdGet.support_https.set(true, true);
    localQQAdGet.external_exp_info.exp_id.add(paramString2);
    localQQAdGet.external_exp_info.traffic_type.set(8);
    paramMap = new tgc.b();
    paramMap.a = localQQAdGet;
    new tgc(paramMap, new WeakReference(paramRequestListener)).c(new WeakReference(paramContext));
  }
  
  public static class GdtAppReceiverWrapper
  {
    private GdtAppReceiver mGdtAppReceiver = new GdtAppReceiver();
    
    public void register(Context paramContext)
    {
      this.mGdtAppReceiver.register(paramContext);
    }
    
    public void unregister(Context paramContext)
    {
      this.mGdtAppReceiver.unregister(paramContext);
    }
  }
  
  public static class GdtTimeStatisticsWrapper
  {
    private GdtDwellTimeStatisticsAfterClick b;
    
    public GdtTimeStatisticsWrapper(ReaderAdWrapper paramReaderAdWrapper, WeakReference<View> paramWeakReference)
    {
      this.b = new GdtDwellTimeStatisticsAfterClick(paramReaderAdWrapper.a(), paramWeakReference);
    }
    
    public void click()
    {
      this.b.click();
    }
  }
  
  public static class ImageData
  {
    public int height;
    public String url;
    public int width;
    
    public ImageData(@NonNull tgg paramtgg)
    {
      this.url = paramtgg.url;
      this.width = paramtgg.width;
      this.height = paramtgg.height;
    }
    
    public boolean isValid()
    {
      return (!TextUtils.isEmpty(this.url)) && (this.width >= 0) && (this.height >= 0);
    }
  }
  
  public static abstract class ReportListener
    implements tld.a
  {
    private ReaderAdWrapper b;
    
    public ReportListener(@NonNull ReaderAdWrapper paramReaderAdWrapper)
    {
      this.b = paramReaderAdWrapper;
    }
    
    public final void reportImpression(View paramView)
    {
      if (paramView.getTag(2131381958) == this.b.a()) {
        reportImpression(paramView, this.b);
      }
    }
    
    public abstract void reportImpression(View paramView, ReaderAdWrapper paramReaderAdWrapper);
  }
  
  public static abstract class RequestListener
    implements tgc.a
  {
    public void onResponse(tgc paramtgc)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = null;
      paramtgc = paramtgc.a().a;
      if (paramtgc == null) {
        paramtgc = (tgc)localObject;
      }
      for (;;)
      {
        onResult(localArrayList, paramtgc);
        return;
        localObject = paramtgc.pos_ads_info.get();
        paramtgc = paramtgc.gdt_cookie.get();
        if (localObject != null) {
          if (!((List)localObject).isEmpty())
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              qq_ad_get.QQAdGetRsp.PosAdInfo localPosAdInfo = (qq_ad_get.QQAdGetRsp.PosAdInfo)((Iterator)localObject).next();
              Iterator localIterator = localPosAdInfo.ads_info.get().iterator();
              while (localIterator.hasNext())
              {
                qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)localIterator.next();
                if ((!localAdInfo.display_info.basic_info.img.get().isEmpty()) || (localAdInfo.display_info.muti_pic_text_info.image.size() >= 3)) {
                  localArrayList.add(new ReaderAdWrapper(new GdtAd(localAdInfo), localPosAdInfo.pos_id.get()));
                }
              }
            }
          }
        }
      }
    }
    
    public abstract void onResult(@NonNull List<ReaderAdWrapper> paramList, @Nullable String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderGdtSdk
 * JD-Core Version:    0.7.0.1
 */