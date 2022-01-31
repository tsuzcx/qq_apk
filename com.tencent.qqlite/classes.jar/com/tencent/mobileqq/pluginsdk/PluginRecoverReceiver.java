package com.tencent.mobileqq.pluginsdk;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MobileQQ;

public class PluginRecoverReceiver
  extends BroadcastReceiver
{
  private static final String INTENT_ACTION_EXCEPTION_STARTUP_FAILED = "com.tencent.mobileqq.ACTION_PLUGIN_STARUP_FAILED";
  private static final String INTENT_KEY_PLUGIN_ID = "pluginId";
  private static final int PRIORITY_PROCESS_PLUGIN = 100;
  private static final int PRIORITY_PROCESS_QQ = 50;
  private static final String TAG = "PluginRecoverReceiver";
  private static final Set<String> sCarePluginIds = new HashSet();
  boolean isMobileQQProcess;
  String processName;
  
  static void addCarePluginId(String paramString)
  {
    if (!sCarePluginIds.contains(paramString)) {
      sCarePluginIds.add(paramString);
    }
  }
  
  static void broadcast(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.ACTION_PLUGIN_STARUP_FAILED");
    localIntent.putExtra("pluginId", paramString);
    localIntent.setPackage(paramContext.getPackageName());
    paramContext.sendOrderedBroadcast(localIntent, null);
  }
  
  public static PluginRecoverReceiver register(Application paramApplication, PluginRecoverReceiver paramPluginRecoverReceiver)
  {
    String str = MobileQQ.processName;
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.ACTION_PLUGIN_STARUP_FAILED");
    boolean bool = TextUtils.equals(paramApplication.getPackageName(), str);
    if (bool) {
      localIntentFilter.setPriority(50);
    }
    for (;;)
    {
      paramPluginRecoverReceiver.isMobileQQProcess = bool;
      paramPluginRecoverReceiver.processName = str;
      try
      {
        paramApplication.registerReceiver(paramPluginRecoverReceiver, localIntentFilter);
        return paramPluginRecoverReceiver;
      }
      catch (Exception paramApplication) {}
      localIntentFilter.setPriority(100);
    }
    return null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.mobileqq.ACTION_PLUGIN_STARUP_FAILED".equals(paramIntent.getAction())) && (TextUtils.equals(paramContext.getPackageName(), paramIntent.getPackage())))
    {
      paramContext = paramIntent.getStringExtra("pluginId");
      if (QLog.isColorLevel()) {
        QLog.d("PluginRecoverReceiver", 2, "onReceive =  pluginID = " + paramContext + ", isQQMobileProcess = " + this.isMobileQQProcess + ", processName = " + this.processName);
      }
      if (!this.isMobileQQProcess) {
        break label113;
      }
      if (!sCarePluginIds.contains(paramContext)) {
        onRecver(paramContext);
      }
    }
    label113:
    while (!sCarePluginIds.contains(paramContext)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginRecoverReceiver", 2, "kill Process =  pluginID = " + paramContext + ", ");
    }
    Process.killProcess(Process.myPid());
  }
  
  protected void onRecver(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginRecoverReceiver
 * JD-Core Version:    0.7.0.1
 */