package com.tencent.qqmini.sdk.launcher.shell;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract interface IAppBrandProxy
{
  public abstract void init(Context paramContext);
  
  public abstract void notifyShareResult(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver);
  
  public abstract void onAppBackground(MiniAppInfo paramMiniAppInfo, Bundle paramBundle);
  
  public abstract void onAppDestroy(Bundle paramBundle);
  
  public abstract void onAppForeground(MiniAppInfo paramMiniAppInfo, Bundle paramBundle);
  
  public abstract void onAppStart(MiniAppInfo paramMiniAppInfo, Bundle paramBundle);
  
  public abstract void preloadDownloadPackage(MiniAppInfo paramMiniAppInfo);
  
  public abstract void preloadMiniApp();
  
  public abstract void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver);
  
  public abstract void stopAllMiniApp();
  
  public abstract void stopMiniApp(MiniAppInfo paramMiniAppInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy
 * JD-Core Version:    0.7.0.1
 */