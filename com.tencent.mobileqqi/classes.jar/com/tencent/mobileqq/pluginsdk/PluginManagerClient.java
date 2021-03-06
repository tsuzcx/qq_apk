package com.tencent.mobileqq.pluginsdk;

import android.os.RemoteException;

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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManagerClient
 * JD-Core Version:    0.7.0.1
 */