package com.tencent.mobileqq.filemanager.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadPkgInstallReceiver
  extends BroadcastReceiver
{
  private static UniformDownloadPkgInstallReceiver a = new UniformDownloadPkgInstallReceiver();
  private static IntentFilter e;
  
  public static void cx(Context paramContext)
  {
    e = new IntentFilter();
    e.addDataScheme("package");
    e.addAction("android.intent.action.PACKAGE_ADDED");
    e.addAction("android.intent.action.PACKAGE_REPLACED");
    if (paramContext != null) {}
    try
    {
      paramContext.registerReceiver(a, e);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    paramIntent = paramIntent.getDataString();
    if (QLog.isColorLevel()) {
      QLog.i("UniformDownloadPkgInstallReceiver<FileAssistant>", 1, "[UniformDL] package operate broadcast. action:" + str + " pkgName:" + paramIntent);
    }
    ThreadManager.executeOnSubThread(new UniformDownloadPkgInstallReceiver.1(this, str, paramIntent, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadPkgInstallReceiver
 * JD-Core Version:    0.7.0.1
 */