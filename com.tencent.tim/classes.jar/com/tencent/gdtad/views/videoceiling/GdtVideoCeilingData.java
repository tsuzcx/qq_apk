package com.tencent.gdtad.views.videoceiling;

import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.video.GdtVideoData;
import java.io.Serializable;

public class GdtVideoCeilingData
  implements Serializable
{
  public static final int STYLE_APP_DEEP_LINK = 3;
  public static final int STYLE_APP_MAIN = 2;
  public static final int STYLE_CANVAS = 4;
  public static final int STYLE_WEB = 1;
  private GdtAd ad;
  private AdCanvasData canvasData;
  private int mStyle = -2147483648;
  private GdtVideoData videoData;
  private String webUrl;
  
  private boolean Oi()
  {
    if (this.mStyle == -2147483648) {}
    while (((this.mStyle == 2) && (TextUtils.isEmpty(this.ad.getAppPackageName()))) || ((this.mStyle == 3) && (TextUtils.isEmpty(this.ad.getAppDeeplink()))) || ((this.mStyle == 4) && ((this.canvasData == null) || (!this.canvasData.isValid())))) {
      return false;
    }
    return true;
  }
  
  public GdtAd getAd()
  {
    return this.ad;
  }
  
  public AdCanvasData getCanvasData()
  {
    return this.canvasData;
  }
  
  public int getStyle()
  {
    return this.mStyle;
  }
  
  public GdtVideoData getVideoData()
  {
    return this.videoData;
  }
  
  public String getWebUrl()
  {
    return this.webUrl;
  }
  
  public boolean isValid()
  {
    return (this.videoData != null) && (this.videoData.isValid()) && (!TextUtils.isEmpty(this.webUrl)) && (Oi());
  }
  
  public void setAd(GdtAd paramGdtAd)
  {
    if (paramGdtAd == null) {}
    do
    {
      return;
      this.ad = paramGdtAd;
    } while (this.videoData == null);
    this.videoData.setAd(paramGdtAd);
  }
  
  public void setCanvasData(AdCanvasData paramAdCanvasData)
  {
    this.canvasData = paramAdCanvasData;
  }
  
  public void setStyle(int paramInt)
  {
    this.mStyle = paramInt;
  }
  
  public void setVideoData(GdtVideoData paramGdtVideoData)
  {
    this.videoData = paramGdtVideoData;
    this.videoData.setAd(this.ad);
    this.videoData.setLoop(paramGdtVideoData.isLoop());
    this.videoData.setPlayScene(7);
  }
  
  public void setWebUrl(String paramString)
  {
    this.webUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData
 * JD-Core Version:    0.7.0.1
 */