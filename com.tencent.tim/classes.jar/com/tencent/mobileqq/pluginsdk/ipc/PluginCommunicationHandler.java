package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCModuleManager;
import java.util.HashMap;
import mqq.app.MobileQQ;

public final class PluginCommunicationHandler
{
  private static volatile PluginCommunicationHandler sInstance;
  private PluginCommunicationChannelImpl mChannel;
  private HashMap<String, RemoteCommand> mCmdMap = new HashMap();
  private AbstractPluginCommunicationChannel mCustomChannel;
  
  public static final PluginCommunicationHandler getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "PluginCommunicationHandler.init");
        }
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
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "register cmd, " + paramRemoteCommand);
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "unregister cmd, " + paramRemoteCommand);
    }
    if (paramRemoteCommand == null) {
      return;
    }
    unregister(paramRemoteCommand.getCmd());
  }
  
  public void unregister(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "unregister cmd, " + paramString);
    }
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
      synchronized (PluginCommunicationHandler.this.mCmdMap)
      {
        paramString = (RemoteCommand)PluginCommunicationHandler.this.mCmdMap.get(paramString);
        if (paramBundle != null) {
          paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
        }
        if (paramString != null)
        {
          paramString = paramString.invoke(paramBundle, null);
          if (paramString != null) {
            paramString.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
          }
          return paramString;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "no cmd found to invoke, have you already register?");
      }
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
    
    public void transferAsync(String paramString, Bundle paramBundle, RemoteCallback paramRemoteCallback)
      throws RemoteException
    {
      EIPCModuleManager.getAsyncHandler().post(new TransferRunnable(paramString, paramBundle, paramRemoteCallback));
    }
    
    class TransferRunnable
      implements Runnable
    {
      private RemoteCallback mCb;
      private String mCmd;
      private RemoteCommand.OnInvokeFinishLinstener mListener;
      private Bundle mParams;
      
      TransferRunnable(String paramString, Bundle paramBundle, RemoteCallback paramRemoteCallback)
      {
        this.mCmd = paramString;
        this.mCb = paramRemoteCallback;
        this.mParams = paramBundle;
        if (this.mParams != null) {
          this.mParams.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
        }
        if (this.mCb != null) {
          this.mListener = new PluginCommunicationHandler.PluginCommunicationChannelImpl.TransferRunnable.1(this, PluginCommunicationHandler.PluginCommunicationChannelImpl.this);
        }
      }
      
      public void run()
      {
        do
        {
          synchronized (PluginCommunicationHandler.this.mCmdMap)
          {
            RemoteCommand localRemoteCommand = (RemoteCommand)PluginCommunicationHandler.this.mCmdMap.get(this.mCmd);
            if (QLog.isColorLevel()) {
              QLog.d("plugin_tag", 2, "tranferAsync," + localRemoteCommand);
            }
            if (localRemoteCommand == null)
            {
              if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, "no cmd found to invoke, have you already register?");
              }
              return;
            }
          }
          if (!localObject2.isSynchronized()) {
            break;
          }
          ??? = PluginCommunicationHandler.PluginCommunicationChannelImpl.this.transferInner(this.mCmd, this.mParams);
          if (??? != null) {}
          try
          {
            ((Bundle)???).setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
            this.mCb.onRemoteCallback((Bundle)???);
            return;
          }
          catch (RemoteException localRemoteException) {}
        } while (!QLog.isColorLevel());
        QLog.w("plugin_tag", 2, "tranferAsync ", localRemoteException);
        return;
        localObject2.invoke(this.mParams, this.mListener);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler
 * JD-Core Version:    0.7.0.1
 */