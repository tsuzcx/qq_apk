package eipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import mqq.app.MobileQQ;

public class EIPCConnection
{
  boolean active = true;
  EIPCModuleManager callbackManager;
  EIPCChannel channel;
  public int clientId;
  String logMark = "";
  public String procName;
  int remoteIndex;
  
  public EIPCConnection(EIPCChannel paramEIPCChannel, String paramString)
  {
    this.channel = paramEIPCChannel;
    this.procName = paramString;
  }
  
  public EIPCResult callModule(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    }
    return this.channel.sync(paramString1, paramString2, paramBundle, -99999);
  }
  
  public EIPCResult callModule(String paramString1, String paramString2, Bundle paramBundle, int paramInt)
    throws RemoteException
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    }
    return this.channel.sync(paramString1, paramString2, paramBundle, paramInt);
  }
  
  public EIPCResult callModuleAsync(String paramString1, String paramString2, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
    throws RemoteException
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    }
    int i = this.callbackManager.registerCallback(paramEIPCResultCallback);
    return this.channel.async(paramString1, paramString2, paramBundle, i, this.remoteIndex);
  }
  
  public boolean isAvailable()
  {
    IBinder localIBinder = this.channel.asBinder();
    return (this.active) && (localIBinder.isBinderAlive()) && (localIBinder.pingBinder());
  }
  
  public IBinder setStubBinder(int paramInt, IBinder paramIBinder)
    throws RemoteException
  {
    return this.channel.setStubBinder(paramInt, paramIBinder);
  }
  
  public String toString()
  {
    return this.logMark + ", EIPCConnection[procName=" + this.procName + ", clientId=" + this.clientId + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     eipc.EIPCConnection
 * JD-Core Version:    0.7.0.1
 */