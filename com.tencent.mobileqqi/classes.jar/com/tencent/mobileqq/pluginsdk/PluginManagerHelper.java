package com.tencent.mobileqq.pluginsdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PluginManagerHelper
{
  private static PluginManagerClient sClient;
  private static WeakReference<OnPluginManagerLoadedListener> sListener;
  private static ServiceConnection sSc = new ServiceConnection()
  {
    private void clear()
    {
      if (PluginManagerHelper.sListener != null)
      {
        PluginManagerHelper.sListener.clear();
        PluginManagerHelper.access$002(null);
      }
    }
    
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "onServiceConnected");
      }
      if (PluginManagerHelper.sListener == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("plugin_tag", 2, "return WeakReference<OnPluginInterfaceReadyListener> is null");
        }
        clear();
        return;
      }
      paramAnonymousComponentName = (PluginManagerHelper.OnPluginManagerLoadedListener)PluginManagerHelper.sListener.get();
      if (paramAnonymousComponentName == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("plugin_tag", 2, "return OnPluginManagerLoadedListener is null");
        }
        clear();
        return;
      }
      if ((paramAnonymousIBinder != null) && (paramAnonymousIBinder.isBinderAlive()) && (paramAnonymousIBinder.pingBinder()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("plugin_tag", 2, "binder alive");
        }
        PluginManagerHelper.access$102(new PluginManagerClient(RemotePluginManager.Stub.asInterface(paramAnonymousIBinder)));
        paramAnonymousComponentName.onPluginManagerLoaded(PluginManagerHelper.sClient);
      }
      for (;;)
      {
        clear();
        return;
        if (QLog.isColorLevel()) {
          QLog.i("plugin_tag", 2, "binder not alive");
        }
        paramAnonymousComponentName.onPluginManagerLoaded(null);
      }
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "onServiceDisconnected");
      }
      if (PluginManagerHelper.sClient != null)
      {
        PluginManagerHelper.sClient.destory();
        PluginManagerHelper.access$102(null);
      }
    }
  };
  
  public static void destory(Context paramContext)
  {
    PluginRemoteProcessor.get().cancel(sSc);
  }
  
  public static void getPluginInterface(Context paramContext, OnPluginManagerLoadedListener paramOnPluginManagerLoadedListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "PluginManagerHelper.getPluginInterface");
    }
    if (sClient == null)
    {
      sListener = new WeakReference(paramOnPluginManagerLoadedListener);
      PluginRemoteProcessor.get().process(paramContext, sSc, 1);
      return;
    }
    paramOnPluginManagerLoadedListener.onPluginManagerLoaded(sClient);
  }
  
  public static abstract interface OnPluginManagerLoadedListener
  {
    public abstract void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManagerHelper
 * JD-Core Version:    0.7.0.1
 */