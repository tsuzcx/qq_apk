package com.tencent.gdtad.aditem;

import alld;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import anot;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdClickUtil.Result;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req;
import com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram.Req;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MutiPicTextInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpParam;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.OfflinePageInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo;
import tgb;
import tgg;
import tkv;
import tkw;

public class GdtAd
  implements Parcelable, Ad, Externalizable
{
  public static final Parcelable.Creator<GdtAd> CREATOR = new tgb();
  public static final int REPORT_STATE_FINISHED = 2;
  public static final int REPORT_STATE_INIT = -1;
  public static final int REPORT_STATE_PENDING = 1;
  public long actionSetId = -2147483648L;
  private String canvasForXiJingOffline = "";
  public qq_ad_get.QQAdGetRsp.AdInfo info;
  public int reportState = -1;
  
  public GdtAd() {}
  
  public GdtAd(Parcel paramParcel)
  {
    try
    {
      this.actionSetId = paramParcel.readLong();
      this.canvasForXiJingOffline = paramParcel.readString();
      int i = paramParcel.readInt();
      if (i <= 0)
      {
        tkw.e("GdtAd", "GdtAd(Parcel in) error");
        return;
      }
      byte[] arrayOfByte = new byte[i];
      paramParcel.readByteArray(arrayOfByte);
      paramParcel = new qq_ad_get.QQAdGetRsp.AdInfo();
      paramParcel.mergeFrom(arrayOfByte);
      this.info = paramParcel;
      return;
    }
    catch (Throwable paramParcel)
    {
      tkw.e("GdtAd", "GdtAd(Parcel in)", paramParcel);
    }
  }
  
  public GdtAd(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    this.info = paramAdInfo;
  }
  
  private void d(Handler paramHandler, int paramInt)
  {
    paramHandler.post(new GdtAd.2(this, paramInt));
  }
  
  private List getExpMap()
  {
    ArrayList localArrayList = new ArrayList();
    if (!isValid()) {
      return localArrayList;
    }
    if (this.info.ext.exp_map.get().size() > 0) {
      return this.info.ext.exp_map.get();
    }
    if (TextUtils.isEmpty(this.info.ext_json.get())) {
      return localArrayList;
    }
    try
    {
      Object localObject = new JSONObject(this.info.ext_json.get());
      localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
      if (localObject == null) {
        return localArrayList;
      }
      localObject = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).exp_map.get();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      tkw.e("GdtAd", "getExpMap", localThrowable);
    }
    return localArrayList;
  }
  
  private boolean isXiJingOffline()
  {
    if (TextUtils.isEmpty(getBusinessIdForXiJingOffline())) {}
    while ((TextUtils.isEmpty(getJSONKeyForXiJingOffline())) || (TextUtils.isEmpty(getJSONUrlForXiJingOffline())) || (TextUtils.isEmpty(getUrlForXiJingOffline()))) {
      return false;
    }
    return true;
  }
  
  public boolean canPreloadForQQMINIProgram()
  {
    boolean bool = true;
    if (!isValid()) {}
    for (;;)
    {
      bool = false;
      do
      {
        return bool;
        if (!isQQMINIProgram()) {
          break;
        }
      } while (this.info.ext.mini_program_preload.get() == 1);
      if (TextUtils.isEmpty(this.info.ext_json.get())) {
        continue;
      }
      try
      {
        Object localObject = new JSONObject(this.info.ext_json.get());
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
        if (localObject == null) {
          continue;
        }
        int i = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).mini_program_preload.get();
        if (i == 1) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        tkw.i("GdtAd", "canPreloadForQQMINIProgram", localThrowable);
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean disableAutoDownload()
  {
    boolean bool = true;
    if (!isValid()) {}
    for (;;)
    {
      bool = false;
      do
      {
        return bool;
        if (!isAppProductType()) {
          break;
        }
      } while (this.info.ext.disable_auto_download.get() == true);
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            bool = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).disable_auto_download.get();
            return bool;
          }
        }
        catch (Throwable localThrowable)
        {
          tkw.i("GdtAd", "disableAutoDownload", localThrowable);
        }
      }
    }
  }
  
  public long getAId()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.aid.get();
    }
    return -2147483648L;
  }
  
  public long getActionSetId()
  {
    return this.actionSetId;
  }
  
  public long getAdvertiserId()
  {
    if (isValid()) {
      return this.info.display_info.advertiser_info.advertiser_id.get();
    }
    return -2147483648L;
  }
  
  public String getAdvertiser_corporate_image_name()
  {
    if (isValid()) {
      return this.info.display_info.advertiser_info.corporate_image_name.get();
    }
    return "";
  }
  
  public String getAdvertiser_corporate_logo()
  {
    if (isValid()) {
      return this.info.display_info.advertiser_info.corporate_logo.get();
    }
    return "";
  }
  
  public String getAppChannelId()
  {
    if (isAppProductType()) {
      return this.info.app_info.channel_id.get();
    }
    return null;
  }
  
  public String getAppDeeplink()
  {
    if (isValid()) {
      return this.info.app_info.customized_invoke_url.get();
    }
    return null;
  }
  
  public long getAppDownloadNum()
  {
    if (isValid()) {
      return this.info.app_info.download_num.get();
    }
    return 0L;
  }
  
  public String getAppId()
  {
    if (isAppProductType()) {
      return this.info.app_info.android_app_id.get();
    }
    return null;
  }
  
  public String getAppMarketDeeplink()
  {
    if (!isValid()) {}
    for (;;)
    {
      return null;
      if (isAppProductType())
      {
        if (!TextUtils.isEmpty(this.info.ext.market_deep_link.get())) {
          return this.info.ext.market_deep_link.get();
        }
        if (!TextUtils.isEmpty(this.info.ext_json.get())) {
          try
          {
            Object localObject = new JSONObject(this.info.ext_json.get());
            localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
            if (localObject != null)
            {
              localObject = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).market_deep_link.get();
              return localObject;
            }
          }
          catch (Throwable localThrowable)
          {
            tkw.i("GdtAd", "getAppMarketDeeplink", localThrowable);
          }
        }
      }
    }
  }
  
  public String getAppMarketPackageName()
  {
    if (!isValid()) {}
    for (;;)
    {
      return null;
      if (isAppProductType())
      {
        if (!TextUtils.isEmpty(this.info.ext.market_package_name.get())) {
          return this.info.ext.market_package_name.get();
        }
        if (!TextUtils.isEmpty(this.info.ext_json.get())) {
          try
          {
            Object localObject = new JSONObject(this.info.ext_json.get());
            localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
            if (localObject != null)
            {
              localObject = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).market_package_name.get();
              return localObject;
            }
          }
          catch (Throwable localThrowable)
          {
            tkw.i("GdtAd", "getAppMarketPackageName", localThrowable);
          }
        }
      }
    }
  }
  
  public String getAppName()
  {
    if (isAppProductType()) {
      return this.info.app_info.app_name.get();
    }
    return null;
  }
  
  public String getAppPackageName()
  {
    if ((isAppProductType()) || (isJDProductType())) {
      return this.info.app_info.app_package_name.get();
    }
    return null;
  }
  
  public long getAppPackageSize()
  {
    if (isAppProductType()) {}
    for (Long localLong = Long.valueOf(this.info.app_info.app_package_size.get());; localLong = null) {
      return localLong.longValue();
    }
  }
  
  public String getAppPackageUrl()
  {
    if (isAppProductType()) {
      return this.info.app_info.pkg_url.get();
    }
    return null;
  }
  
  public int getAppScore()
  {
    if (isValid()) {
      return this.info.app_info.app_score_num.get();
    }
    return 0;
  }
  
  public String getAppVersion()
  {
    if (isAppProductType()) {
      return this.info.app_info.app_package_version.get();
    }
    return null;
  }
  
  public String getBusinessIdForXiJingOffline()
  {
    if (!isValid()) {}
    for (;;)
    {
      return null;
      if ((this.info.ext.xj_offline.offline_id.has()) && (this.info.ext.xj_offline.offline_id.get() != 0)) {
        return String.valueOf(this.info.ext.xj_offline.offline_id.get());
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            int i = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).xj_offline.offline_id.get();
            return String.valueOf(i);
          }
        }
        catch (Throwable localThrowable)
        {
          tkw.i("GdtAd", "getJSONKeyForXiJingOffline", localThrowable);
        }
      }
    }
  }
  
  public String getCanvas()
  {
    if (isCanvas()) {
      return this.info.dest_info.canvas_json.get();
    }
    return null;
  }
  
  public String getCanvasForXiJingOffline()
  {
    if (!TextUtils.isEmpty(this.canvasForXiJingOffline)) {
      return this.canvasForXiJingOffline;
    }
    return null;
  }
  
  public int getCreativeSize()
  {
    if (isValid()) {
      return this.info.display_info.creative_size.get();
    }
    return -2147483648;
  }
  
  public String getDescription()
  {
    if (isValid()) {
      return this.info.display_info.basic_info.desc.get();
    }
    return null;
  }
  
  public int getDestType()
  {
    if (isValid()) {
      return this.info.dest_info.dest_type.get();
    }
    return -2147483648;
  }
  
  public tgg getImageData()
  {
    if (!isValid()) {
      return null;
    }
    tgg localtgg = new tgg();
    localtgg.url = this.info.display_info.basic_info.img.get();
    localtgg.width = this.info.display_info.basic_info.pic_width.get();
    localtgg.height = this.info.display_info.basic_info.pic_height.get();
    if (localtgg.isValid()) {}
    for (;;)
    {
      return localtgg;
      localtgg = null;
    }
  }
  
  public tgg getImageData(int paramInt)
  {
    if ((!isValid()) || (paramInt < 0) || (paramInt >= this.info.display_info.muti_pic_text_info.image.size())) {
      return null;
    }
    tgg localtgg = new tgg();
    localtgg.url = ((String)this.info.display_info.muti_pic_text_info.image.get(paramInt));
    localtgg.width = this.info.display_info.basic_info.pic_width.get();
    localtgg.height = this.info.display_info.basic_info.pic_height.get();
    return localtgg;
  }
  
  public String getJSONKeyForXiJingOffline()
  {
    if (!isValid()) {}
    for (;;)
    {
      return null;
      if (!TextUtils.isEmpty(this.info.ext.xj_offline.offline_json_key.get())) {
        return this.info.ext.xj_offline.offline_json_key.get();
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            localObject = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).xj_offline.offline_json_key.get();
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          tkw.i("GdtAd", "getJSONKeyForXiJingOffline", localThrowable);
        }
      }
    }
  }
  
  public String getJSONUrlForXiJingOffline()
  {
    if (!isValid()) {}
    for (;;)
    {
      return null;
      if (!TextUtils.isEmpty(this.info.ext.xj_offline.offline_json_url.get())) {
        return this.info.ext.xj_offline.offline_json_url.get();
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            localObject = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).xj_offline.offline_json_url.get();
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          tkw.i("GdtAd", "getJSONUrlForXiJingOffline", localThrowable);
        }
      }
    }
  }
  
  public String getNetLogId()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.net_log_req_id.get();
    }
    return null;
  }
  
  public long getNocoId()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.noco_id.get();
    }
    return -2147483648L;
  }
  
  public String getPosId()
  {
    Object localObject = getUrlForClick();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      AdLog.e("GdtAd", "getPosId error");
      return null;
    }
    localObject = AdUriUtil.parse((String)localObject);
    if (localObject != null)
    {
      localObject = AdUriUtil.getQueryParameter((Uri)localObject, "pid");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label53;
      }
    }
    for (;;)
    {
      return localObject;
      localObject = null;
      break;
      label53:
      localObject = null;
    }
  }
  
  public String getProductId()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.product_id.get();
    }
    return null;
  }
  
  public int getProductType()
  {
    if (isValid()) {
      return this.info.product_type.get();
    }
    return -2147483648;
  }
  
  public int getRelationTarget()
  {
    if (!isValid()) {}
    for (;;)
    {
      return -2147483648;
      if (this.info.ext.relation_target.get() >= 0) {
        return this.info.ext.relation_target.get();
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            int i = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).relation_target.get();
            return i;
          }
        }
        catch (Throwable localThrowable)
        {
          AdLog.e("GdtAd", "getRelationTarget", localThrowable);
        }
      }
    }
  }
  
  public int getStyle()
  {
    if (isValid()) {
      return this.info.exp_info.qq_game_video_ad_style.get();
    }
    return 0;
  }
  
  public String getTencent_video_id()
  {
    if (isValid()) {
      return this.info.display_info.video_info.tencent_video_id.get();
    }
    return null;
  }
  
  public String getText()
  {
    if (isValid()) {
      return this.info.display_info.basic_info.txt.get();
    }
    return null;
  }
  
  public String getTraceId()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.traceid.get();
    }
    return null;
  }
  
  public String getUrlForAction()
  {
    if (isValid()) {
      return this.info.report_info.landing_page_report_url.get();
    }
    return null;
  }
  
  public String getUrlForClick()
  {
    if (isValid()) {
      return this.info.report_info.click_url.get();
    }
    return null;
  }
  
  public String getUrlForEffect()
  {
    if (isValid()) {
      return this.info.report_info.effect_url.get();
    }
    return null;
  }
  
  public String getUrlForImpression()
  {
    if (isValid()) {
      return this.info.report_info.exposure_url.get();
    }
    return null;
  }
  
  public String getUrlForLandingPage()
  {
    if (isValid()) {
      return this.info.dest_info.landing_page.get();
    }
    return null;
  }
  
  public String getUrlForXiJingOffline()
  {
    if (!isValid()) {}
    for (;;)
    {
      return null;
      if (!TextUtils.isEmpty(this.info.ext.xj_offline.offline_landing_page.get())) {
        return this.info.ext.xj_offline.offline_landing_page.get();
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            localObject = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).xj_offline.offline_landing_page.get();
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          tkw.i("GdtAd", "getJSONUrlForXiJingOffline", localThrowable);
        }
      }
    }
  }
  
  public String getVia()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.via.get();
    }
    return null;
  }
  
  public String getVideoUrl()
  {
    if (isValid()) {
      return this.info.display_info.video_info.video_url.get();
    }
    return null;
  }
  
  public String getVideoUrl2()
  {
    if (isValid()) {
      return this.info.display_info.video_info2.video_url.get();
    }
    return null;
  }
  
  public String getViewId()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.view_id.get();
    }
    return null;
  }
  
  public boolean isAppProductType()
  {
    return getProductType() == 12;
  }
  
  public boolean isAppXiJing()
  {
    return (isAppProductType()) && (getDestType() == 1);
  }
  
  public boolean isAppXiJingDefault()
  {
    return (isAppProductType()) && (getDestType() == 0);
  }
  
  public boolean isAppXiJingOffline()
  {
    return (isAppXiJing()) && (isXiJingOffline());
  }
  
  public boolean isCanvas()
  {
    return ((!isAppXiJingDefault()) && (!isAppXiJing())) || ((!TextUtils.isEmpty(this.info.dest_info.canvas_json.get())) || ((getProductType() == 1000) && (getDestType() == 4) && (!TextUtils.isEmpty(this.info.dest_info.canvas_json.get()))));
  }
  
  public boolean isHitCanvasVideoCeilingExp()
  {
    boolean bool = true;
    if (!isValid()) {}
    for (;;)
    {
      bool = false;
      do
      {
        return bool;
      } while (this.info.ext.landing_page_style.get() == 1);
      if (TextUtils.isEmpty(this.info.ext_json.get())) {
        continue;
      }
      try
      {
        Object localObject = new JSONObject(this.info.ext_json.get());
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
        if (localObject == null) {
          continue;
        }
        int i = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).landing_page_style.get();
        if (i == 1) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        tkw.i("GdtAd", "isHitCanvasVideoCeilingExp", localThrowable);
      }
    }
  }
  
  public boolean isHitRelationTargetInstallExp()
  {
    if (!isValid()) {}
    for (;;)
    {
      return false;
      List localList = getExpMap();
      int i = 0;
      while (i < localList.size())
      {
        if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 94735) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get().equals("1"))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean isInterstitial()
  {
    boolean bool = true;
    if (!isValid()) {}
    for (;;)
    {
      bool = false;
      do
      {
        return bool;
      } while (this.info.ext.render_pos_type.get() == 2);
      if (TextUtils.isEmpty(this.info.ext_json.get())) {
        continue;
      }
      try
      {
        Object localObject = new JSONObject(this.info.ext_json.get());
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
        if (localObject == null) {
          continue;
        }
        int i = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).render_pos_type.get();
        if (i == 2) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        tkw.i("GdtAd", "isInterstitial", localThrowable);
      }
    }
  }
  
  public boolean isJDProductType()
  {
    return getProductType() == 25;
  }
  
  public boolean isQQMINIProgram()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (isValid())
    {
      bool1 = bool2;
      if (this.info.display_info.mini_program_type.get() == 11) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isValid()
  {
    return this.info != null;
  }
  
  public boolean isVideoSplice()
  {
    return ((getProductType() == 1000) || (getProductType() == 12) || (getProductType() == 25) || (getProductType() == 30)) && ((getDestType() == 0) || (getDestType() == 4) || (getDestType() == 1)) && ((getCreativeSize() == 585) || (getCreativeSize() == 930));
  }
  
  public boolean isWeChatMiniApp()
  {
    boolean bool2 = isValid();
    boolean bool1 = bool2;
    if (bool2) {
      if ((this.info.product_type.get() != 46) && ((this.info.display_info == null) || (this.info.display_info.mini_program_type.get() != 3))) {
        break label61;
      }
    }
    label61:
    for (bool1 = true;; bool1 = false)
    {
      if (bool1) {}
      return bool1;
    }
  }
  
  public boolean isWebXiJing()
  {
    return (getProductType() == 1000) && (getDestType() == 4);
  }
  
  public boolean isWebXiJingOffline()
  {
    return (isWebXiJing()) && (isXiJingOffline());
  }
  
  public AdClickUtil.Result jumpToWechatMiniApp(Handler paramHandler)
  {
    localObject2 = "wx4c9797ab3fd1e003";
    localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (this.info.wechat_app_info.app_id.has())
        {
          localObject1 = localObject2;
          if (this.info.wechat_app_info.app_id.get().length() > 0) {
            localObject1 = this.info.wechat_app_info.app_id.get();
          }
        }
        localObject1 = WXAPIFactory.createWXAPI(BaseApplicationImpl.sApplication, (String)localObject1);
        if (((IWXAPI)localObject1).isWXAppInstalled()) {
          continue;
        }
        d(paramHandler, 2131694272);
        paramHandler = null;
      }
      catch (Exception paramHandler)
      {
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("pathType", 2);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("ad_trace_data", this.info.wechat_app_info.ad_trace_data.get());
          localJSONObject.put("token", this.info.wechat_app_info.app_token.get());
          ((JSONObject)localObject2).put("invokeData", localJSONObject);
          paramHandler.extData = ((JSONObject)localObject2).toString();
          AdLog.d("navigateToMiniProgram", "openMiniGame, make extData json success: " + paramHandler.extData);
          paramHandler.miniprogramType = 0;
          ((IWXAPI)localObject1).sendReq(paramHandler);
          paramHandler = new AdClickUtil.Result(0, 9);
          continue;
          paramHandler = paramHandler;
          paramHandler = new AdClickUtil.Result(4, 9);
        }
        catch (Exception localException)
        {
          AdLog.e("navigateToMiniProgram", "openMiniGame, make extData json failed!");
          continue;
        }
      }
      anot.a(null, "dc00898", "", "", "0X800AA79", "0X800AA79", 0, 0, "", "", String.valueOf(this.info.wechat_app_info.pos_id.get()), "");
      return paramHandler;
      if (((IWXAPI)localObject1).getWXAppSupportAPI() >= 621086464) {
        continue;
      }
      d(paramHandler, 2131694273);
      paramHandler = null;
    }
    paramHandler = new WXLaunchMiniProgram.Req();
    paramHandler.userName = this.info.wechat_app_info.app_username.get();
    paramHandler.path = this.info.wechat_app_info.app_path.get();
  }
  
  public void preloadMiniApp()
  {
    WXPreloadMiniProgram.Req localReq;
    if (isWeChatMiniApp())
    {
      localReq = new WXPreloadMiniProgram.Req();
      localReq.userName = this.info.wechat_app_info.app_username.get();
      localReq.path = this.info.wechat_app_info.app_path.get();
    }
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("pathType", 2);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("ad_trace_data", this.info.wechat_app_info.ad_trace_data.get());
      ((JSONObject)localObject1).put("token", this.info.wechat_app_info.app_token.get());
      ((JSONObject)localObject2).put("invokeData", localObject1);
      localReq.extData = ((JSONObject)localObject2).toString();
      AdLog.d("navigateToMiniProgram", "openMiniGame, make extData json success: " + localReq.extData);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = BaseApplicationImpl.sApplication.getContentResolver();
          Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/preloadWXMiniprogram");
          if (!this.info.wechat_app_info.app_id.has()) {
            continue;
          }
          Object localObject1 = this.info.wechat_app_info.app_id.get();
          alld.query((ContentResolver)localObject2, localUri, null, null, new String[] { localObject1, localReq.userName, localReq.path, localReq.miniprogramType + "", localReq.extData }, null);
          return;
        }
        catch (Throwable localThrowable)
        {
          String str;
          if (0 == 0) {
            continue;
          }
          try
          {
            throw new NullPointerException();
          }
          catch (Exception localException2) {}
        }
        localException1 = localException1;
        AdLog.e("navigateToMiniProgram", "openMiniGame, make extData json failed!");
        continue;
        str = "wx4c9797ab3fd1e003";
      }
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    int i = 0;
    if (paramObjectInput == null)
    {
      tkw.e("GdtAd", "readExternal error");
      return;
    }
    int j;
    try
    {
      this.actionSetId = paramObjectInput.readLong();
      this.canvasForXiJingOffline = paramObjectInput.readUTF();
      j = paramObjectInput.readInt();
      if (j <= 0)
      {
        tkw.e("GdtAd", "readExternal error");
        return;
      }
    }
    catch (Throwable paramObjectInput)
    {
      tkw.e("GdtAd", "readExternal", paramObjectInput);
      return;
    }
    Object localObject = new ByteArrayOutputStream();
    for (;;)
    {
      byte[] arrayOfByte;
      int k;
      if (i < j)
      {
        arrayOfByte = new byte[j - i];
        k = paramObjectInput.read(arrayOfByte);
        if (k < 0) {
          tkw.e("GdtAd", "readExternal error");
        }
      }
      else
      {
        ((ByteArrayOutputStream)localObject).close();
        paramObjectInput = ((ByteArrayOutputStream)localObject).toByteArray();
        if ((i == j) && (paramObjectInput.length == j)) {
          break;
        }
        tkw.e("GdtAd", "readExternal error");
        return;
      }
      i += k;
      ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, k);
    }
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
    try
    {
      ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).mergeFrom(paramObjectInput);
      this.info = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramObjectInput)
    {
      tkw.e("GdtAd", "readExternal", paramObjectInput);
    }
  }
  
  public void setActionSetId(long paramLong)
  {
    this.actionSetId = paramLong;
  }
  
  public void setCanvasForXiJingOffline(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      this.canvasForXiJingOffline = paramString;
      return;
      paramString = "";
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    if ((paramObjectOutput == null) || (this.info == null))
    {
      tkw.e("GdtAd", "writeExternal error");
      return;
    }
    byte[] arrayOfByte;
    try
    {
      paramObjectOutput.writeLong(this.actionSetId);
      paramObjectOutput.writeUTF(this.canvasForXiJingOffline);
      arrayOfByte = this.info.toByteArray();
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        tkw.e("GdtAd", "writeExternal error");
        return;
      }
    }
    catch (Throwable paramObjectOutput)
    {
      tkw.e("GdtAd", "writeExternal", paramObjectOutput);
      return;
    }
    paramObjectOutput.writeInt(arrayOfByte.length);
    paramObjectOutput.write(arrayOfByte);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if ((paramParcel == null) || (this.info == null))
    {
      tkw.e("GdtAd", "writeToParcel error");
      return;
    }
    byte[] arrayOfByte;
    for (;;)
    {
      try
      {
        paramParcel.writeLong(this.actionSetId);
        paramParcel.writeString(this.canvasForXiJingOffline);
        arrayOfByte = this.info.toByteArray();
        if (arrayOfByte != null)
        {
          paramInt = arrayOfByte.length;
          paramParcel.writeInt(paramInt);
          if (paramInt > 0) {
            break;
          }
          tkw.e("GdtAd", "writeToParcel error");
          return;
        }
      }
      catch (Throwable paramParcel)
      {
        tkw.e("GdtAd", "writeToParcel", paramParcel);
        return;
      }
      paramInt = 0;
    }
    paramParcel.writeByteArray(arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAd
 * JD-Core Version:    0.7.0.1
 */