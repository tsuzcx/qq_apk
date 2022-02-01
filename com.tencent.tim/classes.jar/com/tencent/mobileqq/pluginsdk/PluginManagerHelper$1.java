package com.tencent.mobileqq.pluginsdk;

import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

final class PluginManagerHelper$1
  extends RemotePluginManager.Stub
{
  public void cancelInstall(String paramString)
    throws RemoteException
  {}
  
  public void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
    throws RemoteException
  {}
  
  public boolean isPlugininstalled(String paramString)
    throws RemoteException
  {
    return false;
  }
  
  public boolean isReady()
    throws RemoteException
  {
    return false;
  }
  
  public PluginBaseInfo queryPlugin(String paramString)
    throws RemoteException
  {
    return null;
  }
  
  public void setListener(RemotePluginManager paramRemotePluginManager)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "PluginManageHelper setListener");
    }
    if (paramRemotePluginManager != null)
    {
      paramRemotePluginManager = new ArrayList(PluginManagerHelper.access$000()).iterator();
      while (paramRemotePluginManager.hasNext())
      {
        Object localObject = (WeakReference)paramRemotePluginManager.next();
        if (localObject != null)
        {
          localObject = (PluginManagerHelper.OnPluginManagerLoadedListener)((WeakReference)localObject).get();
          if (localObject != null) {
            ((PluginManagerHelper.OnPluginManagerLoadedListener)localObject).onPluginManagerLoaded(PluginManagerHelper.access$100());
          }
        }
      }
    }
    PluginManagerHelper.access$200();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManagerHelper.1
 * JD-Core Version:    0.7.0.1
 */