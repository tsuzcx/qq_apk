package com.tencent.mobileqq.emosm.web;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletOpenObserver;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.AppService;

public class MessengerService
  extends AppService
  implements IPCConstants
{
  public static final String tag = "Q.emoji.web.MessengerService";
  private CardObserver cardObserver = new MessengerService.3(this);
  Messenger mClient = null;
  public EmoticonPackageDownloadListener mListener = new MessengerService.1(this);
  final Messenger mMessenger = new Messenger(new MessengerService.IncomingHandler(this));
  private MessengerService.QWalletOpenMsgHandler mOpenMsgHandler = new MessengerService.QWalletOpenMsgHandler(this, null);
  private QWalletOpenObserver mOpenObserver = new QWalletOpenObserver(this.mOpenMsgHandler);
  DownloadListener mThemeDownloadListener = new MessengerService.4(this, "param_WIFIThemeDownloadFlow", "param_XGThemeDownloadFlow");
  IPCDownloadListener mVipIPCDownloadListener = new MessengerService.2(this);
  private Bundle rsqBundle = null;
  
  private void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.web.MessengerService", 2, paramString);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService onBind");
    }
    return this.mMessenger.getBinder();
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService oncreate");
    }
    super.onCreate();
  }
  
  public void onDestroy()
  {
    this.mClient = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService destroied");
    }
    if ((this.app != null) && ((this.app instanceof QQAppInterface)))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.app;
      EmojiManager localEmojiManager = (EmojiManager)this.app.getManager(39);
      if (localEmojiManager != null) {
        localEmojiManager.a.b(this.mListener);
      }
      if (this.mOpenObserver != null)
      {
        this.mOpenObserver.a();
        localQQAppInterface.c(this.mOpenObserver);
        this.mOpenObserver = null;
      }
      this.mOpenMsgHandler = null;
      if (this.cardObserver != null)
      {
        localQQAppInterface.c(this.cardObserver);
        this.cardObserver = null;
      }
    }
    this.app = null;
  }
  
  void onRespToClient(Bundle paramBundle)
  {
    if (this.mClient != null) {}
    try
    {
      Message localMessage = Message.obtain(null, 4);
      localMessage.setData(paramBundle);
      this.mClient.send(localMessage);
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.MessengerService", 2, "resp to sever: ");
      }
      return;
    }
    catch (RemoteException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService
 * JD-Core Version:    0.7.0.1
 */