package com.tencent.mobileqq.emosm;

import affw;
import afip;
import afjy;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;

public class Client
  implements afip
{
  public static final String tag = "Q.emoji.web.Client";
  private ServiceConnection mConnection = new affw(this);
  public boolean mIsBound;
  public final Messenger mMessenger = new Messenger(new a(Looper.getMainLooper()));
  public Messenger mService = null;
  
  public void doBindService(Context paramContext)
  {
    try
    {
      paramContext.bindService(new Intent(paramContext, MessengerService.class), this.mConnection, 1);
      this.mIsBound = true;
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.Client", 2, "Binding...");
      }
      return;
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        this.mIsBound = false;
        if (QLog.isColorLevel()) {
          QLog.e("Q.emoji.web.Client", 2, paramContext.getMessage());
        }
      }
    }
  }
  
  public void doUnbindService(Context paramContext)
  {
    if ((!this.mIsBound) || (this.mService != null)) {}
    try
    {
      Message localMessage = Message.obtain(null, 2);
      localMessage.replyTo = this.mMessenger;
      this.mService.send(localMessage);
      try
      {
        label36:
        paramContext.unbindService(this.mConnection);
        label44:
        this.mService = null;
        this.mIsBound = false;
        if (QLog.isColorLevel()) {
          QLog.i("Q.emoji.web.Client", 2, "Unbinding.");
        }
        return;
      }
      catch (IllegalArgumentException paramContext)
      {
        break label44;
      }
    }
    catch (RemoteException localRemoteException)
    {
      break label36;
    }
  }
  
  public boolean isClientBinded()
  {
    return this.mService != null;
  }
  
  public void onDisconnectWithService()
  {
    afjy.a().onDisconnectWithService();
  }
  
  void onPushMsgFromServer(Bundle paramBundle)
  {
    afjy.a().onPushMsgFromServer(paramBundle);
  }
  
  public boolean onReqToServer(Bundle paramBundle)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2;
    if (this.mService != null) {
      bool2 = bool3;
    }
    try
    {
      Message localMessage = Message.obtain(null, 3, 0, 0);
      bool2 = bool3;
      localMessage.replyTo = this.mMessenger;
      bool2 = bool3;
      localMessage.setData(paramBundle);
      bool2 = bool3;
      this.mService.send(localMessage);
      boolean bool4 = true;
      bool3 = true;
      bool1 = bool3;
      bool2 = bool4;
      if (QLog.isColorLevel())
      {
        bool2 = bool4;
        QLog.i("Q.emoji.web.Client", 2, "req to server");
        bool1 = bool3;
      }
      return bool1;
    }
    catch (RemoteException paramBundle)
    {
      this.mService = null;
    }
    return bool2;
  }
  
  void onRespFromServer(Bundle paramBundle)
  {
    try
    {
      afjy.a().cs(paramBundle);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      try
      {
        QLog.e("Q.emoji.web.Client", 2, "onRespFromServer bundle error:" + paramBundle);
        return;
      }
      catch (Throwable paramBundle)
      {
        QLog.e("Q.emoji.web.Client", 2, "print error");
      }
    }
  }
  
  class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        super.handleMessage(paramMessage);
      }
      do
      {
        do
        {
          return;
          Client.this.onRespFromServer(paramMessage.getData());
        } while (!QLog.isColorLevel());
        QLog.i("Q.emoji.web.Client", 2, "resp from server MSG_CLIENT_RESP");
        return;
        Client.this.onPushMsgFromServer(paramMessage.getData());
      } while (!QLog.isColorLevel());
      QLog.i("Q.emoji.web.Client", 2, "resp from server MSG_SERVER_DOWNLOAD_STATE");
    }
  }
  
  public static abstract class b
  {
    private static int seed;
    public int key;
    
    public b()
    {
      int i = seed;
      seed = i + 1;
      this.key = i;
    }
    
    public abstract void onBindedToClient();
    
    public abstract void onDisconnectWithService();
    
    public abstract void onPushMsg(Bundle paramBundle);
    
    public abstract void onResponse(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.Client
 * JD-Core Version:    0.7.0.1
 */