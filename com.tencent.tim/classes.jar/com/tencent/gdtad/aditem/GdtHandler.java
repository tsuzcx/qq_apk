package com.tencent.gdtad.aditem;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.ad.tangram.util.AdClickUtil.Params;
import com.tencent.ad.tangram.util.AdClickUtil.Result;
import com.tencent.gdtad.views.canvas.GdtCanvasBaseFragment;
import com.tencent.gdtad.views.videoceiling.GdtBaseVideoCeilingFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tgf;
import tkv;
import tkw;
import tlf;
import tlo;
import tlo.a;

public class GdtHandler
{
  private static AdClickUtil.Params a(Params paramParams)
  {
    WeakReference localWeakReference = null;
    if (paramParams == null) {
      return null;
    }
    AdClickUtil.Params localParams = new AdClickUtil.Params();
    localParams.activity = paramParams.activity;
    localParams.ad = paramParams.ad;
    localParams.reportForClick = paramParams.reportForClick;
    localParams.sceneID = paramParams.sceneID;
    localParams.componentID = paramParams.componentID;
    localParams.enableAutoDownload = paramParams.aOV;
    if (paramParams.appReceiver != null) {
      localWeakReference = new WeakReference(paramParams.appReceiver.get());
    }
    localParams.appReceiver = localWeakReference;
    localParams.videoCeilingSupportedIfNotInstalled = paramParams.videoCeilingSupportedIfNotInstalled;
    localParams.videoCeilingSupportedIfInstalled = paramParams.videoCeilingSupportedIfInstalled;
    localParams.videoSpliceSupported = paramParams.videoSpliceSupported;
    localParams.mediaViewLocationRect = paramParams.mediaViewLocationRect;
    localParams.videoStartPositionMillis = paramParams.videoStartPositionMillis;
    localParams.extrasForIntent = new Bundle();
    localParams.extrasForIntent.putString("big_brother_source_key", "biz_src_ads");
    if (paramParams.extra != null)
    {
      tkw.i("GdtHandler", "toParams pass refId " + paramParams.extra);
      localParams.extrasForIntent.putAll(paramParams.extra);
    }
    for (;;)
    {
      localParams.videoPlayForced = paramParams.directPlay;
      localParams.antiSpamParams = paramParams.antiSpamParams;
      return localParams;
      tkw.i("GdtHandler", "toParams not pass refId \n" + QLog.getStackTraceString(new IllegalArgumentException()));
    }
  }
  
  public static void a(Params paramParams)
    throws IllegalArgumentException
  {
    tkw.i("GdtHandler", "handle");
    ThreadManager.getSubThreadHandler().post(new GdtHandler.1(paramParams));
    tlo localtlo = tlo.a();
    if ((paramParams != null) && (paramParams.isValid())) {}
    for (Activity localActivity = (Activity)paramParams.activity.get();; localActivity = null)
    {
      localtlo.a(localActivity, new tlo.a());
      b(paramParams);
      tlf.as(paramParams.aO);
      return;
    }
  }
  
  public static boolean a(Options paramOptions, String paramString)
  {
    if (paramOptions == null) {
      return false;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      tkw.i("GdtHandler", String.format("fromJSON %s", new Object[] { paramString }));
      paramString = localJSONObject1.getJSONObject("options");
      boolean bool1 = paramString.getBoolean("reportForClick");
      boolean bool2 = paramString.getBoolean("appAutoDownload");
      boolean bool3 = paramString.optBoolean("videoCeilingSupported", false);
      boolean bool4 = paramString.optBoolean("videoCeilingSupportedIfInstalled", false);
      boolean bool5 = paramString.optBoolean("videoSpliceSupported", false);
      JSONObject localJSONObject2 = paramString.optJSONObject("mediaViewLocationRect");
      Rect localRect = new Rect();
      if (localJSONObject2 != null)
      {
        int i = localJSONObject2.optInt("left", 0);
        int j = localJSONObject2.optInt("top", 0);
        int k = localJSONObject2.optInt("right", 0);
        int m = localJSONObject2.optInt("bottom", 0);
        localRect.left = i;
        localRect.top = j;
        localRect.right = k;
        localRect.bottom = m;
      }
      paramOptions.reportForClick = bool1;
      paramOptions.aOV = bool2;
      paramOptions.videoCeilingSupportedIfNotInstalled = bool3;
      paramOptions.videoCeilingSupportedIfInstalled = bool4;
      paramOptions.videoSpliceSupported = bool5;
      paramOptions.mediaViewLocationRect = localRect;
      paramOptions.directPlay = paramString.optBoolean("videoPlayForced");
      if (localJSONObject1.has("adInfo")) {
        paramOptions.ad = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), localJSONObject1.getJSONObject("adInfo"))));
      }
      return true;
    }
    catch (Throwable paramOptions)
    {
      tkw.e("GdtHandler", "handleJsCallRequest error", paramOptions);
    }
    return false;
  }
  
  private static void b(Params paramParams)
  {
    int i = 1;
    if (paramParams == null) {}
    while (paramParams.ad == null) {
      return;
    }
    paramParams = AdClickUtil.handle(a(paramParams));
    if (paramParams != null) {
      i = paramParams.getErrorCode();
    }
    tkw.i("GdtHandler", String.format("handle errorCode:%d", new Object[] { Integer.valueOf(i) }));
  }
  
  public static class Options
    implements Parcelable
  {
    public static final Parcelable.Creator<Options> CREATOR = new tgf();
    public JSONObject aO;
    public boolean aOV;
    public GdtAd ad;
    public String antiSpamParams;
    public int componentID = -2147483648;
    public boolean directPlay;
    public Bundle extra;
    public Rect mediaViewLocationRect;
    public boolean reportForClick = true;
    public int sceneID = -2147483648;
    public boolean videoCeilingSupportedIfInstalled;
    public boolean videoCeilingSupportedIfNotInstalled;
    private boolean videoLoop;
    public boolean videoSpliceSupported;
    public long videoStartPositionMillis;
    
    public Options() {}
    
    public Options(Parcel paramParcel)
    {
      if (paramParcel == null)
      {
        tkw.e("GdtHandler", "Options(Parcel in) error");
        return;
      }
      this.ad = ((GdtAd)paramParcel.readParcelable(GdtAd.class.getClassLoader()));
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.reportForClick = bool1;
        this.sceneID = paramParcel.readInt();
        this.componentID = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label236;
        }
        bool1 = true;
        label90:
        this.aOV = bool1;
        if (paramParcel.readByte() == 0) {
          break label241;
        }
        bool1 = true;
        label104:
        this.videoCeilingSupportedIfNotInstalled = bool1;
        if (paramParcel.readByte() == 0) {
          break label246;
        }
        bool1 = true;
        label118:
        this.videoCeilingSupportedIfInstalled = bool1;
        if (paramParcel.readByte() == 0) {
          break label251;
        }
        bool1 = true;
        label132:
        this.videoSpliceSupported = bool1;
        this.mediaViewLocationRect = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
        if (paramParcel.readByte() == 0) {
          break label256;
        }
        bool1 = true;
        label162:
        this.videoLoop = bool1;
        this.videoStartPositionMillis = paramParcel.readLong();
        if (paramParcel.readByte() == 0) {
          break label261;
        }
      }
      label256:
      label261:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.directPlay = bool1;
        this.antiSpamParams = paramParcel.readString();
        this.extra = paramParcel.readBundle();
        try
        {
          this.aO = new JSONObject(paramParcel.readString());
          return;
        }
        catch (Throwable paramParcel)
        {
          tkw.e("GdtHandler", "Options(Parcel in)", paramParcel);
          return;
        }
        bool1 = false;
        break;
        label236:
        bool1 = false;
        break label90;
        label241:
        bool1 = false;
        break label104;
        label246:
        bool1 = false;
        break label118;
        label251:
        bool1 = false;
        break label132;
        bool1 = false;
        break label162;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean isValid()
    {
      return (this.ad != null) && (this.ad.isValid()) && (!TextUtils.isEmpty(this.ad.getTraceId())) && (!TextUtils.isEmpty(this.ad.getUrlForImpression())) && (!TextUtils.isEmpty(this.ad.getUrlForClick())) && (!TextUtils.isEmpty(this.ad.getUrlForEffect())) && (!TextUtils.isEmpty(this.ad.getUrlForAction())) && (!TextUtils.isEmpty(this.ad.getUrlForLandingPage()));
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int j = 1;
      if (paramParcel == null)
      {
        tkw.e("GdtHandler", "writeToParcel error");
        return;
      }
      paramParcel.writeParcelable(this.ad, paramInt);
      int i;
      if (this.reportForClick)
      {
        i = 1;
        paramParcel.writeByte((byte)i);
        paramParcel.writeInt(this.sceneID);
        paramParcel.writeInt(this.componentID);
        if (!this.aOV) {
          break label217;
        }
        i = 1;
        label64:
        paramParcel.writeByte((byte)i);
        if (!this.videoCeilingSupportedIfNotInstalled) {
          break label222;
        }
        i = 1;
        label79:
        paramParcel.writeByte((byte)i);
        if (!this.videoCeilingSupportedIfInstalled) {
          break label227;
        }
        i = 1;
        label94:
        paramParcel.writeByte((byte)i);
        if (!this.videoSpliceSupported) {
          break label232;
        }
        i = 1;
        label109:
        paramParcel.writeByte((byte)i);
        paramParcel.writeParcelable(this.mediaViewLocationRect, paramInt);
        if (!this.videoLoop) {
          break label237;
        }
        paramInt = 1;
        label133:
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeLong(this.videoStartPositionMillis);
        if (!this.directPlay) {
          break label242;
        }
        paramInt = j;
        label157:
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.antiSpamParams);
        paramParcel.writeBundle(this.extra);
        if ((this.aO == null) || (this.aO == JSONObject.NULL)) {
          break label247;
        }
      }
      label217:
      label222:
      label227:
      label232:
      label237:
      label242:
      label247:
      for (String str = this.aO.toString();; str = null)
      {
        paramParcel.writeString(str);
        return;
        i = 0;
        break;
        i = 0;
        break label64;
        i = 0;
        break label79;
        i = 0;
        break label94;
        i = 0;
        break label109;
        paramInt = 0;
        break label133;
        paramInt = 0;
        break label157;
      }
    }
  }
  
  public static final class Params
    extends GdtHandler.Options
  {
    public WeakReference<Activity> activity;
    public WeakReference<GdtAppReceiver> appReceiver;
    public Class<? extends GdtBaseVideoCeilingFragment> n;
    public Class<? extends GdtCanvasBaseFragment> p;
    public int processId = -2147483648;
    
    public boolean isInitialized()
    {
      return (this.activity != null) && (this.activity.get() != null) && (this.p != null);
    }
    
    public boolean isValid()
    {
      return (super.isValid()) && (isInitialized());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtHandler
 * JD-Core Version:    0.7.0.1
 */