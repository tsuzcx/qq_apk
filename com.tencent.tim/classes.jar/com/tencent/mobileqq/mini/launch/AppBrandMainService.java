package com.tencent.mobileqq.mini.launch;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;

public class AppBrandMainService
  extends Service
{
  public static final String BUNDLE_KEY_PROCESS_NAME = "mini_process_name";
  private static final String TAG = "miniapp-process_AppBrandMainService";
  
  public IBinder onBind(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("mini_process_name");
    QLog.w("miniapp-process_AppBrandMainService", 1, "AppBrandMainService Service Binded. pName=" + paramIntent);
    return new AppBrandMainServiceBinder(this, paramIntent);
  }
  
  public void onCreate()
  {
    QLog.w("miniapp-process_AppBrandMainService", 1, "AppBrandMainService Service onCreate~~~");
    super.onCreate();
  }
  
  public void onDestroy()
  {
    QLog.w("miniapp-process_AppBrandMainService", 1, "AppBrandMainService Service onDestroy~~~");
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    QLog.w("miniapp-process_AppBrandMainService", 1, "AppBrandMainService Service onStart~~~");
    super.onStart(paramIntent, paramInt);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    QLog.w("miniapp-process_AppBrandMainService", 1, "AppBrandMainService Service onUnbind~~~");
    return super.onUnbind(paramIntent);
  }
  
  public static class AppBrandMainServiceBinder
    extends IAppBrandService.Stub
  {
    private static final byte[] INSTANCE_LOCK = new byte[0];
    private static volatile AppBrandMainServiceBinder mInstance;
    private Context mContext;
    public String mProcessName;
    
    public AppBrandMainServiceBinder(Context paramContext, String paramString)
    {
      this.mContext = paramContext;
      this.mProcessName = paramString;
    }
    
    public void onAppBackground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
      throws RemoteException
    {
      QLog.w("miniapp-process_AppBrandMainService", 1, "AppBrandMainService onAppBackground. pOrigName=" + this.mProcessName + " Name=" + paramString);
      AppBrandLaunchManager.g().getHandler().post(new AppBrandMainService.AppBrandMainServiceBinder.3(this, paramString, paramMiniAppConfig, paramBundle));
    }
    
    public void onAppForeground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
      throws RemoteException
    {
      QLog.w("miniapp-process_AppBrandMainService", 1, "AppBrandMainService onAppForeground. pOrigName=" + this.mProcessName + " Name=" + paramString);
      AppBrandLaunchManager.g().getHandler().post(new AppBrandMainService.AppBrandMainServiceBinder.4(this, paramString, paramMiniAppConfig, paramBundle));
    }
    
    public void onAppStart(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
      throws RemoteException
    {
      QLog.w("miniapp-process_AppBrandMainService", 1, "AppBrandMainService onAppStart. pOrigName=" + this.mProcessName + " Name=" + paramString);
      AppBrandLaunchManager.g().getHandler().post(new AppBrandMainService.AppBrandMainServiceBinder.2(this, paramString, paramMiniAppConfig, paramBundle));
    }
    
    public void onAppStop(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
      throws RemoteException
    {
      QLog.w("miniapp-process_AppBrandMainService", 1, "AppBrandMainService onAppStop. pOrigName=" + this.mProcessName + " Name=" + paramString);
      AppBrandLaunchManager.g().getHandler().post(new AppBrandMainService.AppBrandMainServiceBinder.5(this, paramString, paramMiniAppConfig, paramBundle));
    }
    
    public void preloadMiniApp()
      throws RemoteException
    {
      QLog.w("miniapp-process_AppBrandMainService", 1, "AppBrandMainService call preloadMiniApp not from Main Processor . pName=" + this.mProcessName);
    }
    
    public void preloadPackage(MiniAppInfo paramMiniAppInfo)
      throws RemoteException
    {
      QLog.w("miniapp-process_AppBrandMainService", 1, "AppBrandMainService call preloadPackage not from Main Processor. pName=" + this.mProcessName);
      if (paramMiniAppInfo != null) {
        AppBrandLaunchManager.g().preloadPackage(paramMiniAppInfo);
      }
    }
    
    public void sendCmd(String paramString, Bundle paramBundle, CmdCallback paramCmdCallback)
      throws RemoteException
    {
      AppBrandLaunchManager.g().sendCmd(paramString, paramBundle, paramCmdCallback);
    }
    
    public void startMiniApp(MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver)
      throws RemoteException
    {
      QLog.w("miniapp-process_AppBrandMainService", 1, "AppBrandMainService call startMiniApp not from Main Processor. pName=" + this.mProcessName);
      AppBrandLaunchManager.g().getHandler().post(new AppBrandMainService.AppBrandMainServiceBinder.1(this, paramMiniAppConfig, paramResultReceiver));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandMainService
 * JD-Core Version:    0.7.0.1
 */