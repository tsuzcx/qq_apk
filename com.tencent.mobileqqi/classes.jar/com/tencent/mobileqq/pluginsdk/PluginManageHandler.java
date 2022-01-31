package com.tencent.mobileqq.pluginsdk;

import android.os.IBinder;
import android.os.RemoteException;

public class PluginManageHandler
{
  private static volatile PluginManageHandler sInstance;
  private RemotePluginManager.Stub mPluginManager;
  private PluginManageWrapper mWrapper;
  
  public static final PluginManageHandler getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new PluginManageHandler();
      }
      return sInstance;
    }
    finally {}
  }
  
  public IBinder getBinder()
  {
    if (this.mWrapper == null) {
      this.mWrapper = new PluginManageWrapper();
    }
    return this.mWrapper;
  }
  
  public void setPluginManager(RemotePluginManager.Stub paramStub)
  {
    this.mPluginManager = paramStub;
  }
  
  public class PluginManageWrapper
    extends RemotePluginManager.Stub
  {
    public PluginManageWrapper() {}
    
    public void cancelInstall(String paramString)
    {
      if (PluginManageHandler.this.mPluginManager == null) {
        return;
      }
      try
      {
        PluginManageHandler.this.mPluginManager.cancelInstall(paramString);
        return;
      }
      catch (RemoteException paramString) {}
    }
    
    public void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
    {
      if (PluginManageHandler.this.mPluginManager == null) {
        return;
      }
      try
      {
        PluginManageHandler.this.mPluginManager.installPlugin(paramString, paramOnPluginInstallListener);
        return;
      }
      catch (RemoteException paramString) {}
    }
    
    public boolean isPlugininstalled(String paramString)
      throws RemoteException
    {
      if (PluginManageHandler.this.mPluginManager == null) {
        return false;
      }
      return PluginManageHandler.this.mPluginManager.isPlugininstalled(paramString);
    }
    
    public boolean isReady()
    {
      if (PluginManageHandler.this.mPluginManager == null) {
        return false;
      }
      try
      {
        boolean bool = PluginManageHandler.this.mPluginManager.isReady();
        return bool;
      }
      catch (RemoteException localRemoteException) {}
      return false;
    }
    
    public PluginBaseInfo queryPlugin(String paramString)
    {
      if (PluginManageHandler.this.mPluginManager == null) {
        return null;
      }
      try
      {
        paramString = PluginManageHandler.this.mPluginManager.queryPlugin(paramString);
        return paramString;
      }
      catch (RemoteException paramString) {}
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManageHandler
 * JD-Core Version:    0.7.0.1
 */