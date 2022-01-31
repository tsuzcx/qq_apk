package com.tencent.mobileqq.pluginsdk.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler;
import com.tencent.qphone.base.util.QLog;

public class PluginRemoteService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("key_binder_type", -1);
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "PluginRemoteService.onBind. " + i);
    }
    switch (i)
    {
    default: 
      return null;
    case 0: 
      return PluginCommunicationHandler.getInstance().getBinder();
    }
    return PluginManageHandler.getInstance().getBinder();
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "PluginRemoteService.onCreate");
    }
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "PluginRemoteService.onUnbind. ");
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.PluginRemoteService
 * JD-Core Version:    0.7.0.1
 */