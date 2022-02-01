package com.tencent.qqmail.utilities.translate;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.tencent.qqmail.utilities.log.QMLog;
import java.lang.ref.WeakReference;

public class TranslateService
  extends Service
{
  private static final String TAG = "TranslateService";
  private Messenger mClient;
  private Messenger mMessenger;
  private HandlerThread mThread = new HandlerThread("Translate");
  
  private void callbackResult(String paramString)
  {
    boolean bool1 = false;
    try
    {
      bool2 = TranslateManager.isFroeignLanguageSupport(paramString);
      bool1 = true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          Message localMessage;
          Bundle localBundle;
          this.mClient.send(localMessage);
          return;
        }
        catch (Throwable paramString)
        {
          boolean bool2;
          QMLog.log(5, "TranslateService", "result call back error!!", paramString);
        }
        localThrowable = localThrowable;
        QMLog.log(5, "TranslateService", "detect language fail!!", localThrowable);
        bool2 = false;
      }
    }
    QMLog.log(4, "TranslateService", "detect result in service: " + bool2);
    localMessage = Message.obtain();
    localMessage.what = 2;
    localBundle = new Bundle();
    localBundle.putString("mail", paramString);
    localBundle.putBoolean("result", bool2);
    localBundle.putBoolean("success", bool1);
    localMessage.setData(localBundle);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.mMessenger.getBinder();
  }
  
  public void onCreate()
  {
    QMLog.log(4, "TranslateService", "TranslateService onCreate");
    super.onCreate();
    this.mThread.start();
    this.mMessenger = new Messenger(new IncomingHandler(this.mThread.getLooper(), this));
  }
  
  public void onDestroy()
  {
    this.mThread.quit();
    super.onDestroy();
  }
  
  static class IncomingHandler
    extends Handler
  {
    WeakReference<TranslateService> mOut;
    
    IncomingHandler(Looper paramLooper, TranslateService paramTranslateService)
    {
      super();
      this.mOut = new WeakReference(paramTranslateService);
    }
    
    public void handleMessage(Message paramMessage)
    {
      TranslateService localTranslateService = (TranslateService)this.mOut.get();
      if ((localTranslateService == null) || (paramMessage == null)) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        TranslateService.access$002(localTranslateService, paramMessage.replyTo);
        return;
      }
      localTranslateService.callbackResult(paramMessage.getData().getString("mail"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.translate.TranslateService
 * JD-Core Version:    0.7.0.1
 */