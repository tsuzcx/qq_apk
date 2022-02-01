package com.tencent.qqmini.sdk.ipc;

import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.ILaunchManager;

public class ProcessManager
{
  private static final String TAG = "minisdk-start_ProcessManager";
  private static volatile ProcessManager instance;
  private static byte[] lock = new byte[0];
  
  public static ProcessManager g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new ProcessManager();
      }
      return instance;
    }
  }
  
  public void handleAppLifecycle(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("mini_cmd", -1);
    String str = paramIntent.getStringExtra("mini_process_name");
    MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramIntent.getParcelableExtra("mini_appinfo");
    paramIntent = paramIntent.getBundleExtra("mini_process_extra");
    QMLog.i("minisdk-start_ProcessManager", "handleAppLifecycle cmd:" + i + " process:" + str + " miniAppInfo:" + localMiniAppInfo);
    switch (i)
    {
    default: 
      return;
    case 1: 
      AppLoaderFactory.g().getLaunchManager().onAppStart(str, localMiniAppInfo, paramIntent);
      return;
    case 2: 
      AppLoaderFactory.g().getLaunchManager().onAppStop(str, localMiniAppInfo, paramIntent);
      return;
    case 3: 
      AppLoaderFactory.g().getLaunchManager().onAppForeground(str, localMiniAppInfo, paramIntent);
      return;
    }
    AppLoaderFactory.g().getLaunchManager().onAppBackground(str, localMiniAppInfo, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.ProcessManager
 * JD-Core Version:    0.7.0.1
 */