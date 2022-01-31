package com.tencent.mobileqq.pluginsdk;

import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

public class PluginManageHandler
{
  private static volatile PluginManageHandler sInstance;
  private IPluginManagerProvider mManagerProvider;
  private RemotePluginManager.Stub mPluginManager;
  private PluginManageWrapper mWrapper;
  
  private boolean ensureManagerReady()
  {
    if (this.mPluginManager == null) {}
    try
    {
      if ((this.mPluginManager == null) && (this.mManagerProvider != null)) {
        this.mPluginManager = this.mManagerProvider.onGetPluginManager();
      }
      if (this.mPluginManager != null) {
        return true;
      }
    }
    finally {}
    return false;
  }
  
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
    if (this.mWrapper == null)
    {
      this.mWrapper = new PluginManageWrapper();
      ensureManagerReady();
    }
    return this.mWrapper;
  }
  
  public void setPluginManagerProvider(IPluginManagerProvider paramIPluginManagerProvider, boolean paramBoolean)
  {
    this.mManagerProvider = paramIPluginManagerProvider;
    if (this.mManagerProvider == null)
    {
      this.mWrapper = null;
      this.mPluginManager = null;
    }
    while (!paramBoolean) {
      return;
    }
    ensureManagerReady();
  }
  
  public static abstract interface IPluginManagerProvider
  {
    public abstract RemotePluginManager.Stub onGetPluginManager();
  }
  
  public class PluginManageWrapper
    extends RemotePluginManager.Stub
  {
    public PluginManageWrapper() {}
    
    public void cancelInstall(String paramString)
    {
      if (PluginManageHandler.this.mPluginManager == null)
      {
        PluginManageHandler.this.ensureManagerReady();
        if (PluginManageHandler.this.mPluginManager == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
          }
          return;
        }
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
      if (QLog.isDevelopLevel()) {
        QLog.i("plugin_tag", 4, "installPlugin " + PluginManageHandler.this.mPluginManager);
      }
      if (PluginManageHandler.this.mPluginManager == null)
      {
        PluginManageHandler.this.ensureManagerReady();
        if (PluginManageHandler.this.mPluginManager == null) {
          if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
          }
        }
      }
      do
      {
        for (;;)
        {
          return;
          try
          {
            PluginManageHandler.this.mPluginManager.installPlugin(paramString, paramOnPluginInstallListener);
            if (QLog.isDevelopLevel())
            {
              QLog.i("plugin_tag", 4, "installPlugin done");
              return;
            }
          }
          catch (RemoteException paramString) {}
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("plugin_tag", 4, "installPlugin", paramString);
    }
    
    public boolean isPlugininstalled(String paramString)
      throws RemoteException
    {
      if (PluginManageHandler.this.mPluginManager == null)
      {
        PluginManageHandler.this.ensureManagerReady();
        if (PluginManageHandler.this.mPluginManager == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
          }
          return false;
        }
      }
      return PluginManageHandler.this.mPluginManager.isPlugininstalled(paramString);
    }
    
    public boolean isReady()
    {
      if (PluginManageHandler.this.mPluginManager == null)
      {
        PluginManageHandler.this.ensureManagerReady();
        if (PluginManageHandler.this.mPluginManager == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
          }
          return false;
        }
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
      if (PluginManageHandler.this.mPluginManager == null)
      {
        PluginManageHandler.this.ensureManagerReady();
        if (PluginManageHandler.this.mPluginManager == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
          }
          return null;
        }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManageHandler
 * JD-Core Version:    0.7.0.1
 */