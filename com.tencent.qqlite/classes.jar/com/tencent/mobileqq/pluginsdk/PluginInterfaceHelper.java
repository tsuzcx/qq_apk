package com.tencent.mobileqq.pluginsdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PluginInterfaceHelper
{
  private static PluginInterface sInterface;
  private static WeakReference<OnPluginInterfaceLoadedListener> sListener;
  private static ServiceConnection sSc = new ServiceConnection()
  {
    private void clear()
    {
      if (PluginInterfaceHelper.sListener != null)
      {
        PluginInterfaceHelper.sListener.clear();
        PluginInterfaceHelper.access$002(null);
      }
    }
    
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "onServiceConnected");
      }
      if (PluginInterfaceHelper.sListener == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("plugin_tag", 2, "return WeakReference<OnPluginInterfaceReadyListener> is null");
        }
        clear();
        return;
      }
      paramAnonymousComponentName = (PluginInterfaceHelper.OnPluginInterfaceLoadedListener)PluginInterfaceHelper.sListener.get();
      if (paramAnonymousComponentName == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("plugin_tag", 2, "return OnPluginInterfaceReadyListener is null");
        }
        clear();
        return;
      }
      if ((paramAnonymousIBinder != null) && (paramAnonymousIBinder.isBinderAlive()) && (paramAnonymousIBinder.pingBinder()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("plugin_tag", 2, "binder alive");
        }
        PluginInterfaceHelper.access$102(new PluginInterface(paramAnonymousIBinder));
        paramAnonymousComponentName.onPluginInterfaceLoaded(PluginInterfaceHelper.sInterface);
      }
      for (;;)
      {
        clear();
        return;
        if (QLog.isColorLevel()) {
          QLog.i("plugin_tag", 2, "binder not alive");
        }
        paramAnonymousComponentName.onPluginInterfaceLoaded(null);
      }
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "onServiceDisconnected");
      }
      paramAnonymousComponentName = PluginInterfaceHelper.sInterface;
      if (paramAnonymousComponentName != null) {
        paramAnonymousComponentName.destory();
      }
      PluginInterfaceHelper.access$102(null);
    }
  };
  
  public static void destory(Context paramContext)
  {
    PluginRemoteProcessor.get().cancel(sSc);
  }
  
  public static void getPluginInterface(Context paramContext, OnPluginInterfaceLoadedListener paramOnPluginInterfaceLoadedListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "PluginInterfaceHelper.getPluginInterface");
    }
    if (sInterface == null)
    {
      sListener = new WeakReference(paramOnPluginInterfaceLoadedListener);
      PluginRemoteProcessor.get().process(paramContext, sSc, 0);
      return;
    }
    paramOnPluginInterfaceLoadedListener.onPluginInterfaceLoaded(sInterface);
  }
  
  public static abstract interface OnPluginInterfaceLoadedListener
  {
    public abstract void onPluginInterfaceLoaded(PluginInterface paramPluginInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper
 * JD-Core Version:    0.7.0.1
 */