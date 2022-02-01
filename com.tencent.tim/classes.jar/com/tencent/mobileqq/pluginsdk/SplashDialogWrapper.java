package com.tencent.mobileqq.pluginsdk;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;

public final class SplashDialogWrapper
{
  private Dialog mBase;
  private Context mContext;
  private Handler mHandler = new InternalHandler(this);
  private boolean mOnlyCheckID;
  private String mPluginApk;
  private String mPluginName;
  private BroadcastReceiver mReceiver;
  private int mTimeOut;
  
  public SplashDialogWrapper(Context paramContext, Dialog paramDialog, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    this.mContext = paramContext;
    this.mBase = paramDialog;
    this.mPluginApk = paramString2;
    this.mPluginName = paramString1;
    this.mOnlyCheckID = paramBoolean;
    this.mTimeOut = paramInt;
  }
  
  public void dismiss()
  {
    if (this.mReceiver != null) {}
    try
    {
      this.mContext.unregisterReceiver(this.mReceiver);
      if (DebugHelper.sDebug) {
        DebugHelper.log("plugin_tag", "SplashDialogWrapper.dismiss unregisterReceiver");
      }
      this.mReceiver = null;
      this.mHandler.removeMessages(0);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        try
        {
          this.mBase.dismiss();
          return;
        }
        catch (Exception localException) {}
        localIllegalArgumentException = localIllegalArgumentException;
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
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "SplashDialogWrapper.show registerReceiver");
    }
    try
    {
      this.mContext.registerReceiver(this.mReceiver, localIntentFilter);
      this.mBase.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  static class InternalHandler
    extends Handler
  {
    public static final int MSG_DISMISS = 0;
    private SplashDialogWrapper mWrapper;
    
    public InternalHandler(SplashDialogWrapper paramSplashDialogWrapper)
    {
      this.mWrapper = paramSplashDialogWrapper;
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      this.mWrapper.dismiss();
    }
  }
  
  public static class LaunchCompletedIntent
    extends Intent
  {
    public static final String ACTION_LAUNCH_COMPLETED = "action_launch_completed";
    public static final String PARAM_PLUGIN_APK = "plugin_apk";
    public static final String PARAM_PLUGIN_NAME = "plugin_name";
  }
  
  class LaunchCompletedObserver
    extends BroadcastReceiver
  {
    private String mPluginID;
    private String mPluginName;
    
    public LaunchCompletedObserver(String paramString1, String paramString2)
    {
      this.mPluginName = paramString1;
      this.mPluginID = paramString2;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getStringExtra("plugin_apk");
      paramIntent = paramIntent.getStringExtra("plugin_name");
      if (DebugHelper.sDebug) {
        DebugHelper.log("plugin_tag", "LaunchCompletedObserver.onReceive: " + paramContext + ", " + paramIntent + ", " + SplashDialogWrapper.this.mOnlyCheckID);
      }
      if ((this.mPluginID.equalsIgnoreCase(paramContext)) && ((SplashDialogWrapper.this.mOnlyCheckID) || (paramIntent != null))) {
        SplashDialogWrapper.this.dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.SplashDialogWrapper
 * JD-Core Version:    0.7.0.1
 */