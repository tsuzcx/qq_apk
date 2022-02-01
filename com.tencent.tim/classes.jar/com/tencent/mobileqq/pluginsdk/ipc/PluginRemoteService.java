package com.tencent.mobileqq.pluginsdk.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class PluginRemoteService
{
  public static class Sub1
    extends Service
  {
    public IBinder onBind(Intent paramIntent)
    {
      int i = paramIntent.getIntExtra("key_binder_type", -1);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "PluginRemoteService$Sub1.onBind. " + i + ", " + Binder.getCallingPid() + ", " + this);
      }
      return PluginCommunicationHandler.getInstance().getBinder();
    }
    
    public void onCreate()
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "PluginRemoteService$Sub1.onCreate " + this);
      }
      super.onCreate();
      MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "PluginRemoteService$Sub1.onDestroy. " + this);
      }
    }
    
    public boolean onUnbind(Intent paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "PluginRemoteService$Sub1.onUnbind. " + Binder.getCallingPid() + ", " + this);
      }
      return super.onUnbind(paramIntent);
    }
  }
  
  public static class Sub2
    extends Service
  {
    public IBinder onBind(Intent paramIntent)
    {
      int i = paramIntent.getIntExtra("key_binder_type", -1);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "PluginRemoteService$Sub2.onBind. " + i + ", " + Binder.getCallingPid() + ", " + this);
      }
      return PluginManageHandler.getInstance().getBinder();
    }
    
    public void onCreate()
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "PluginRemoteService$Sub2.onCreate " + this);
      }
      super.onCreate();
      MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "PluginRemoteService$Sub2.onDestroy. " + this);
      }
    }
    
    public boolean onUnbind(Intent paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "PluginRemoteService$Sub2.onUnbind. " + Binder.getCallingPid() + ", " + this);
      }
      return super.onUnbind(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.PluginRemoteService
 * JD-Core Version:    0.7.0.1
 */