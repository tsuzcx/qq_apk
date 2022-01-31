package com.tencent.mobileqq.pluginsdk;

import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

public class PluginManagerClient
{
  RemotePluginManager mRemote;
  
  public PluginManagerClient(RemotePluginManager paramRemotePluginManager)
  {
    this.mRemote = paramRemotePluginManager;
  }
  
  public void cancelInstall(String paramString)
  {
    try
    {
      this.mRemote.cancelInstall(paramString);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void destory()
  {
    this.mRemote = null;
  }
  
  public void installPlugin(String paramString)
  {
    try
    {
      this.mRemote.installPlugin(paramString, null);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
  {
    try
    {
      this.mRemote.installPlugin(paramString, paramOnPluginInstallListener);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public boolean isPluginInstalled(String paramString)
  {
    try
    {
      boolean bool = this.mRemote.isPlugininstalled(paramString);
      return bool;
    }
    catch (RemoteException paramString) {}
    return false;
  }
  
  public boolean isReady()
  {
    try
    {
      boolean bool = this.mRemote.isReady();
      return bool;
    }
    catch (RemoteException localRemoteException) {}
    return false;
  }
  
  public PluginBaseInfo queryPlugin(String paramString)
  {
    try
    {
      paramString = this.mRemote.queryPlugin(paramString);
      return paramString;
    }
    catch (RemoteException paramString) {}
    return null;
  }
  
  public boolean useful()
  {
    bool2 = false;
    bool1 = bool2;
    if (this.mRemote != null) {}
    for (;;)
    {
      try
      {
        IBinder localIBinder = this.mRemote.asBinder();
        if ((localIBinder == null) || (!localIBinder.isBinderAlive())) {
          continue;
        }
        bool1 = localIBinder.pingBinder();
        if (!bool1) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception localException)
      {
        bool1 = bool2;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, " useful: " + bool1);
      }
      return bool1;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManagerClient
 * JD-Core Version:    0.7.0.1
 */