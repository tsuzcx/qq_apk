package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class PluginCommunicationHandler
{
  private static volatile PluginCommunicationHandler sInstance;
  private PluginCommunicationChannelImpl mChannel;
  private Handler mChannelHandler;
  private HashMap<String, RemoteCommand> mCmdMap = new HashMap();
  private AbstractPluginCommunicationChannel mCustomChannel;
  
  private PluginCommunicationHandler()
  {
    HandlerThread localHandlerThread = new HandlerThread("ipc_async_cmd_invoker", 10);
    localHandlerThread.start();
    this.mChannelHandler = new Handler(localHandlerThread.getLooper());
  }
  
  public static final PluginCommunicationHandler getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null)
      {
        Log.d("plugin_tag", "PluginCommunicationHandler.init");
        sInstance = new PluginCommunicationHandler();
      }
      return sInstance;
    }
    finally {}
  }
  
  public boolean containsCmd(String paramString)
  {
    return this.mCmdMap.containsKey(paramString);
  }
  
  public PluginCommunicationChannelImpl getBinder()
  {
    if (this.mChannel == null) {
      this.mChannel = new PluginCommunicationChannelImpl();
    }
    return this.mChannel;
  }
  
  public void register(RemoteCommand paramRemoteCommand)
  {
    if (paramRemoteCommand == null) {
      return;
    }
    synchronized (this.mCmdMap)
    {
      this.mCmdMap.put(paramRemoteCommand.getCmd(), paramRemoteCommand);
      return;
    }
  }
  
  public void setCommunicationChannel(AbstractPluginCommunicationChannel paramAbstractPluginCommunicationChannel)
  {
    this.mCustomChannel = paramAbstractPluginCommunicationChannel;
  }
  
  public void unregister(RemoteCommand paramRemoteCommand)
  {
    if (paramRemoteCommand == null) {
      return;
    }
    unregister(paramRemoteCommand.getCmd());
  }
  
  public void unregister(String paramString)
  {
    if (paramString == null) {
      return;
    }
    synchronized (this.mCmdMap)
    {
      this.mCmdMap.remove(paramString);
      return;
    }
  }
  
  public class PluginCommunicationChannelImpl
    extends PluginCommunicationChannel.Stub
  {
    public PluginCommunicationChannelImpl() {}
    
    private Bundle transferInner(String paramString, Bundle paramBundle)
    {
      do
      {
        synchronized (PluginCommunicationHandler.this.mCmdMap)
        {
          RemoteCommand localRemoteCommand = (RemoteCommand)PluginCommunicationHandler.this.mCmdMap.get(paramString);
          paramString = null;
          if (localRemoteCommand != null)
          {
            paramString = localRemoteCommand.invoke(paramBundle, null);
            return paramString;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.i("plugin_tag", 2, "no cmd found to invoke, have you already register?");
      return null;
    }
    
    public String getNickName()
      throws RemoteException
    {
      if (PluginCommunicationHandler.this.mCustomChannel == null) {
        return null;
      }
      return PluginCommunicationHandler.this.mCustomChannel.getNickName();
    }
    
    public String getSKey()
      throws RemoteException
    {
      if (PluginCommunicationHandler.this.mCustomChannel == null) {
        return null;
      }
      return "getSKey";
    }
    
    public String getSid()
      throws RemoteException
    {
      if (PluginCommunicationHandler.this.mCustomChannel == null) {
        return null;
      }
      return PluginCommunicationHandler.this.mCustomChannel.getSid();
    }
    
    public long getUin()
      throws RemoteException
    {
      if (PluginCommunicationHandler.this.mCustomChannel == null) {
        return 0L;
      }
      return PluginCommunicationHandler.this.mCustomChannel.getUin();
    }
    
    public Bundle transfer(String paramString, Bundle paramBundle)
      throws RemoteException
    {
      return transferInner(paramString, paramBundle);
    }
    
    public void transferAsync(String paramString, Bundle paramBundle, RemotesCallback paramRemotesCallback)
      throws RemoteException
    {
      PluginCommunicationHandler.this.mChannelHandler.post(new TransferRunnable(paramString, paramBundle, paramRemotesCallback));
    }
    
    private class TransferRunnable
      implements Runnable
    {
      private RemotesCallback mCb;
      private String mCmd;
      private RemoteCommand.OnInvokeFinishLinstener mListener;
      private Bundle mParams;
      
      TransferRunnable(String paramString, Bundle paramBundle, RemotesCallback paramRemotesCallback)
      {
        this.mCmd = paramString;
        this.mCb = paramRemotesCallback;
        this.mParams = paramBundle;
        if (this.mCb != null) {
          this.mListener = new RemoteCommand.OnInvokeFinishLinstener()
          {
            public void onInvokeFinish(Bundle paramAnonymousBundle)
            {
              try
              {
                PluginCommunicationHandler.PluginCommunicationChannelImpl.TransferRunnable.this.mCb.onCallback(paramAnonymousBundle);
                return;
              }
              catch (RemoteException paramAnonymousBundle) {}
            }
          };
        }
      }
      
      public void run()
      {
        synchronized (PluginCommunicationHandler.this.mCmdMap)
        {
          RemoteCommand localRemoteCommand = (RemoteCommand)PluginCommunicationHandler.this.mCmdMap.get(this.mCmd);
          if (localRemoteCommand == null) {
            return;
          }
        }
        if (localObject2.isSynchronized())
        {
          ??? = PluginCommunicationHandler.PluginCommunicationChannelImpl.this.transferInner(this.mCmd, this.mParams);
          try
          {
            this.mCb.onCallback((Bundle)???);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            return;
          }
        }
        localObject2.invoke(this.mParams, this.mListener);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler
 * JD-Core Version:    0.7.0.1
 */