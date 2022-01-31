package com.tencent.mobileqq.pluginsdk;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel.Stub;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteResultCallback;
import mqq.app.MobileQQ;

public class PluginInterface
{
  private PluginCommunicationChannel mClient;
  
  public PluginInterface(IBinder paramIBinder)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramIBinder != null)
    {
      localObject1 = localObject2;
      if (paramIBinder.isBinderAlive())
      {
        localObject1 = localObject2;
        if (paramIBinder.pingBinder()) {
          localObject1 = PluginCommunicationChannel.Stub.asInterface(paramIBinder);
        }
      }
    }
    if (localObject1 == null) {
      throw new NullPointerException();
    }
    this.mClient = ((PluginCommunicationChannel)localObject1);
  }
  
  public void destory()
  {
    this.mClient = null;
  }
  
  public String getNickName()
  {
    if (this.mClient == null) {
      return null;
    }
    try
    {
      String str = this.mClient.getNickName();
      return str;
    }
    catch (RemoteException localRemoteException) {}
    return null;
  }
  
  public String getSKey()
  {
    if (this.mClient == null) {
      return null;
    }
    try
    {
      String str = this.mClient.getSKey();
      return str;
    }
    catch (RemoteException localRemoteException) {}
    return null;
  }
  
  public String getSid()
  {
    if (this.mClient == null) {
      return null;
    }
    try
    {
      String str = this.mClient.getSid();
      return str;
    }
    catch (RemoteException localRemoteException) {}
    return null;
  }
  
  public long getUin()
  {
    if (this.mClient == null) {
      return 0L;
    }
    try
    {
      long l = this.mClient.getUin();
      return l;
    }
    catch (RemoteException localRemoteException) {}
    return 0L;
  }
  
  public Bundle transfer(String paramString, Bundle paramBundle)
  {
    if (this.mClient == null) {
      return null;
    }
    if (paramBundle != null) {
      paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    }
    try
    {
      paramString = this.mClient.transfer(paramString, paramBundle);
      return paramString;
    }
    catch (RemoteException paramString) {}
    return null;
  }
  
  public void transferAsync(String paramString, Bundle paramBundle, RemoteResultCallback paramRemoteResultCallback)
  {
    if (this.mClient == null) {
      return;
    }
    if (paramBundle != null) {
      paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    }
    try
    {
      this.mClient.transferAsync(paramString, paramBundle, paramRemoteResultCallback);
      return;
    }
    catch (RemoteException paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginInterface
 * JD-Core Version:    0.7.0.1
 */