package com.tencent.mobileqq.pluginsdk;

import android.os.Handler;
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
    PluginManageHandler.getPluginIOHandler().post(new PluginManagerClient.1(this, paramString));
  }
  
  public void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
  {
    PluginManageHandler.getPluginIOHandler().post(new PluginManagerClient.2(this, paramString, paramOnPluginInstallListener));
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
  
  public void setListener(RemotePluginManager.Stub paramStub)
  {
    try
    {
      this.mRemote.setListener(paramStub);
      return;
    }
    catch (RemoteException paramStub) {}
  }
  
  public boolean useful()
  {
    bool2 = false;
    bool1 = bool2;
    if (this.mRemote != null) {}
    try
    {
      IBinder localIBinder = this.mRemote.asBinder();
      bool1 = bool2;
      if (localIBinder != null)
      {
        bool1 = bool2;
        if (localIBinder.isBinderAlive())
        {
          boolean bool3 = localIBinder.pingBinder();
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, " useful: " + bool1);
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManagerClient
 * JD-Core Version:    0.7.0.1
 */