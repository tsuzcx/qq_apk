package com.tencent.mobileqq.pluginsdk;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;

public class PluginSplashDialog
  extends Dialog
{
  private Handler mHandler = new InternalHandler(this);
  private String mPluginApk;
  private String mPluginName;
  private BroadcastReceiver mReceiver = null;
  private int mTimeOut;
  
  public PluginSplashDialog(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    super(paramContext, paramInt1);
    this.mTimeOut = paramInt2;
    this.mPluginName = paramString1;
    this.mPluginApk = paramString2;
  }
  
  public void dismiss()
  {
    if (this.mReceiver != null) {}
    try
    {
      getContext().unregisterReceiver(this.mReceiver);
      this.mReceiver = null;
      this.mHandler.removeMessages(0);
      super.dismiss();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
  }
  
  public void show()
  {
    this.mHandler.sendEmptyMessageDelayed(0, this.mTimeOut);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_launch_completed");
    this.mReceiver = new LaunchCompletedObserver(this.mPluginName, this.mPluginApk);
    try
    {
      getContext().registerReceiver(this.mReceiver, localIntentFilter);
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginDebug", "PluginSplashDialog RegisterReceiver");
      }
      label74:
      super.show();
      return;
    }
    catch (Exception localException)
    {
      break label74;
    }
  }
  
  private static class InternalHandler
    extends Handler
  {
    public static final int MSG_DISMISS = 0;
    private Dialog mDlg = null;
    
    public InternalHandler(Dialog paramDialog)
    {
      this.mDlg = paramDialog;
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      try
      {
        this.mDlg.dismiss();
        return;
      }
      catch (Exception paramMessage) {}
    }
  }
  
  public static class LaunchCompletedIntent
    extends Intent
  {
    public static final String ACTION_LAUNCH_COMPLETED = "action_launch_completed";
    public static final String PARAM_PLUGIN_APK = "plugin_apk";
    public static final String PARAM_PLUGIN_NAME = "plugin_name";
  }
  
  private class LaunchCompletedObserver
    extends BroadcastReceiver
  {
    private String mPluginApk;
    private String mPluginName;
    
    public LaunchCompletedObserver(String paramString1, String paramString2)
    {
      this.mPluginName = paramString1;
      this.mPluginApk = paramString2;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getStringExtra("plugin_apk");
      paramIntent = paramIntent.getStringExtra("plugin_name");
      if ((this.mPluginApk.equalsIgnoreCase(paramContext)) && (this.mPluginName.equalsIgnoreCase(paramIntent))) {}
      try
      {
        PluginSplashDialog.this.dismiss();
        return;
      }
      catch (Exception paramContext) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginSplashDialog
 * JD-Core Version:    0.7.0.1
 */