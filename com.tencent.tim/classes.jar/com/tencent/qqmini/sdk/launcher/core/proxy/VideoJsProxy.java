package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import org.json.JSONObject;

public abstract class VideoJsProxy
{
  public Bridge mBridge;
  
  public abstract void chooseVideo(Activity paramActivity, String paramString1, String paramString2, int paramInt);
  
  public abstract void create(IMiniAppContext paramIMiniAppContext);
  
  public void destroy()
  {
    this.mBridge = null;
  }
  
  public abstract void saveVideoToPhotosAlbum(Activity paramActivity, String paramString1, String paramString2, int paramInt);
  
  public void setResponseListener(Bridge paramBridge)
  {
    this.mBridge = paramBridge;
  }
  
  public static abstract interface Bridge
  {
    public abstract void hideLoading();
    
    public abstract void responseCancel(int paramInt, String paramString, JSONObject paramJSONObject);
    
    public abstract void responseFail(int paramInt, String paramString1, JSONObject paramJSONObject, String paramString2);
    
    public abstract void responseOk(int paramInt, String paramString, JSONObject paramJSONObject);
    
    public abstract void showLoading(String paramString);
    
    public abstract void updateLoading(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy
 * JD-Core Version:    0.7.0.1
 */