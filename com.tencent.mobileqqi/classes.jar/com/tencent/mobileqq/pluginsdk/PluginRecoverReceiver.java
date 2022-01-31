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
  OnRecoverPluginListener mOnRecoverPluginListener;
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
  
  public static PluginRecoverReceiver register(Application paramApplication)
  {
    String str = MobileQQ.processName;
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.ACTION_PLUGIN_STARUP_FAILED");
    boolean bool = TextUtils.equals(paramApplication.getPackageName(), str);
    if (bool) {
      localIntentFilter.setPriority(50);
    }
    for (;;)
    {
      PluginRecoverReceiver localPluginRecoverReceiver = new PluginRecoverReceiver();
      localPluginRecoverReceiver.isMobileQQProcess = bool;
      localPluginRecoverReceiver.processName = str;
      try
      {
        paramApplication.registerReceiver(localPluginRecoverReceiver, localIntentFilter);
        return localPluginRecoverReceiver;
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
      paramIntent = paramIntent.getStringExtra("pluginId");
      if (QLog.isColorLevel()) {
        QLog.d("PluginRecoverReceiver", 2, "onReceive =  pluginID = " + paramIntent + ", isQQMobileProcess = " + this.isMobileQQProcess + ", processName = " + this.processName);
      }
      if (!this.isMobileQQProcess) {
        break label222;
      }
      if (!sCarePluginIds.contains(paramIntent))
      {
        if (PluginUtils.verifyCrcCode(paramContext, paramIntent, "0")) {
          break label178;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PluginRecoverReceiver", 2, "onReceive crcVerify failed then uninstall. kill Process =  pluginID = " + paramIntent + ", processName = " + this.processName);
        }
        if (this.mOnRecoverPluginListener != null) {
          this.mOnRecoverPluginListener.onRecver(paramIntent);
        }
      }
    }
    label178:
    label222:
    while (!sCarePluginIds.contains(paramIntent))
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("PluginRecoverReceiver", 2, "onReceive crcVerify success,  pluginID = " + paramIntent + ", processName = " + this.processName);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginRecoverReceiver", 2, "kill Process =  pluginID = " + paramIntent + ", ");
    }
    Process.killProcess(Process.myPid());
  }
  
  public void setOnRecoverPluginListener(OnRecoverPluginListener paramOnRecoverPluginListener)
  {
    this.mOnRecoverPluginListener = paramOnRecoverPluginListener;
  }
  
  public static abstract interface OnRecoverPluginListener
  {
    public abstract void onRecver(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginRecoverReceiver
 * JD-Core Version:    0.7.0.1
 */