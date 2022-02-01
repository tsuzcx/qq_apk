package com.tencent.tim.filemanager.core;

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
    paramContext.registerReceiver(a, e);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getDataString();
    if (QLog.isColorLevel()) {
      QLog.i("UniformDownloadPkgInstallReceiver<FileAssistant>", 1, "[UniformDL] package operate broadcast. action:" + paramContext + " pkgName:" + paramIntent);
    }
    ThreadManager.executeOnSubThread(new UniformDownloadPkgInstallReceiver.1(this, paramContext, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.UniformDownloadPkgInstallReceiver
 * JD-Core Version:    0.7.0.1
 */