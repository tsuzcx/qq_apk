package com.tencent.qqmini.sdk.launcher.shell;

import android.content.Context;
import android.text.TextUtils;

public abstract class BaselibLoader
{
  public static final String TAG = "BaselibLoader";
  protected BaselibContent mBaselibContent;
  
  public BaselibContent getBaselib()
  {
    return this.mBaselibContent;
  }
  
  public boolean isBaseLibInit()
  {
    return (this.mBaselibContent != null) && (this.mBaselibContent.isBaseLibInited());
  }
  
  public abstract void loadBaselib(Context paramContext, OnLoadBaselibListener paramOnLoadBaselibListener);
  
  public void setBaselib(BaselibContent paramBaselibContent)
  {
    if ((paramBaselibContent != null) && (paramBaselibContent.isBaseLibInited())) {
      this.mBaselibContent = paramBaselibContent;
    }
  }
  
  public static class BaselibContent
  {
    public String miniappWebviewStr;
    public String pageFrameStr;
    public String version;
    public String waConsoleJsStr;
    public String waRemoteDebugStr;
    public String waServiceJsStr;
    public String waServicePath;
    public String waWebviewJsStr;
    public String waWorkerStr;
    
    public BaselibContent clone()
    {
      BaselibContent localBaselibContent = new BaselibContent();
      localBaselibContent.waWebviewJsStr = this.waWebviewJsStr;
      localBaselibContent.waServiceJsStr = this.waServiceJsStr;
      localBaselibContent.waConsoleJsStr = this.waConsoleJsStr;
      localBaselibContent.waRemoteDebugStr = this.waRemoteDebugStr;
      localBaselibContent.miniappWebviewStr = this.miniappWebviewStr;
      localBaselibContent.waWorkerStr = this.waWorkerStr;
      localBaselibContent.pageFrameStr = this.pageFrameStr;
      localBaselibContent.waServicePath = this.waServicePath;
      return localBaselibContent;
    }
    
    public boolean isBaseLibInited()
    {
      return (!TextUtils.isEmpty(this.waServiceJsStr)) && (!TextUtils.isEmpty(this.waWebviewJsStr)) && (!TextUtils.isEmpty(this.waConsoleJsStr)) && (!TextUtils.isEmpty(this.waRemoteDebugStr)) && (!TextUtils.isEmpty(this.miniappWebviewStr));
    }
  }
  
  public static abstract interface OnLoadBaselibListener
  {
    public abstract void onResult(int paramInt, String paramString, BaselibLoader.BaselibContent paramBaselibContent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.shell.BaselibLoader
 * JD-Core Version:    0.7.0.1
 */