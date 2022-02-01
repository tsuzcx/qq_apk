package com.tencent.qqmini.sdk.launcher.shell;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Messenger;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;

public abstract interface ILaunchManager
{
  public abstract void init(Context paramContext);
  
  public abstract boolean isMiniProcess(String paramString);
  
  public abstract void onAppBackground(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle);
  
  public abstract void onAppForeground(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle);
  
  public abstract void onAppStart(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle);
  
  public abstract void onAppStop(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle);
  
  public abstract void onHostAppBackground();
  
  public abstract void onPreloadBaseLib(String paramString1, String paramString2);
  
  public abstract void onRecvCommand(String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract void preloadDownloadPackage(MiniAppInfo paramMiniAppInfo);
  
  public abstract void preloadMiniApp(Bundle paramBundle);
  
  public abstract void registerClientMessenger(String paramString, Messenger paramMessenger);
  
  public abstract void registerProcessInfo(List<MiniProcessorConfig> paramList);
  
  public abstract boolean sendCmdToMiniProcess(int paramInt, Bundle paramBundle, MiniAppInfo paramMiniAppInfo, ResultReceiver paramResultReceiver);
  
  public abstract void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver);
  
  public abstract void stopAllMiniApp();
  
  public abstract void stopMiniApp(MiniAppInfo paramMiniAppInfo);
  
  public abstract void stopMiniApp(String paramString);
  
  public static class MiniProcessorConfig
  {
    public Class<?> appPreLoadClass;
    public Class<?> appUIClass;
    public Class<?> internalUIClass;
    public String processName;
    public ProcessType processType;
    public int supportRuntimeType;
    
    public MiniProcessorConfig(ProcessType paramProcessType, String paramString, Class paramClass1, Class paramClass2, Class paramClass3, int paramInt)
    {
      this.processType = paramProcessType;
      this.processName = paramString;
      this.appUIClass = paramClass1;
      this.internalUIClass = paramClass2;
      this.appPreLoadClass = paramClass3;
      this.supportRuntimeType = paramInt;
    }
    
    public String toString()
    {
      return "pName:" + this.processName + " pType:" + this.processType + " UI:" + this.appUIClass + " Internal:" + this.internalUIClass + " receiver:" + this.appPreLoadClass + " supportRuntimeType:" + this.supportRuntimeType;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.shell.ILaunchManager
 * JD-Core Version:    0.7.0.1
 */