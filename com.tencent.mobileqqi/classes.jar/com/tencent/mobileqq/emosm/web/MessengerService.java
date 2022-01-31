package com.tencent.mobileqq.emosm.web;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class MessengerService
  extends AppService
  implements IPCConstants
{
  public static final String tag = "Q.emoji.web.MessengerService";
  Messenger mClient = null;
  public EmoticonPackageDownloadListener mListener = new MessengerService.1(this);
  final Messenger mMessenger = new Messenger(new MessengerService.IncomingHandler(this));
  IPCDownloadListener mVipIPCDownloadListener = new MessengerService.2(this);
  MessengerService.ThemeDownloadHandler themeDownloadHandler;
  
  private void onRespToClient(Bundle paramBundle)
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
      EmoticonController localEmoticonController = EmoticonController.a(localQQAppInterface);
      if (localEmoticonController != null) {
        localEmoticonController.b(this.mListener);
      }
      if (this.themeDownloadHandler != null)
      {
        localQQAppInterface.a().b(this.themeDownloadHandler);
        this.themeDownloadHandler = null;
      }
    }
    this.app = null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService
 * JD-Core Version:    0.7.0.1
 */