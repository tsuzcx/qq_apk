package com.tencent.qqmail.utilities.screenshot;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.lang.ref.WeakReference;

public class ScreenShotServiceClient
  implements ScreenshotWatcher
{
  public static final String TAG = ScreenShotServiceClient.class.getSimpleName();
  private ServiceConnection mServiceConnection = new ScreenShotServiceClient.1(this);
  private HandlerThread mThread = new HandlerThread("ScreenShotServiceClient");
  private ScreenshotWatcher.ScreenshotCallback screenshotCallback;
  private Messenger serviceMsger;
  
  public ScreenShotServiceClient(ScreenshotWatcher.ScreenshotCallback paramScreenshotCallback)
  {
    this.screenshotCallback = paramScreenshotCallback;
  }
  
  public boolean isWatching()
  {
    return false;
  }
  
  public void registToService()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.replyTo = new Messenger(new ClientHandler(this.mThread.getLooper(), this));
    try
    {
      this.serviceMsger.send(localMessage);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.log(5, TAG, "register client error!!", localThrowable);
      Log.i(TAG, "register client error!!", localThrowable);
    }
  }
  
  public void release() {}
  
  public void startWatching()
  {
    this.mThread.start();
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ScreenshotService.class);
    QMApplicationContext.sharedInstance().bindService(localIntent, this.mServiceConnection, 1);
  }
  
  public void stopWatching()
  {
    Log.i(TAG, "Try to unbind service");
    QMApplicationContext.sharedInstance().unbindService(this.mServiceConnection);
    this.mThread.quit();
  }
  
  static class ClientHandler
    extends Handler
  {
    WeakReference<ScreenShotServiceClient> mOut;
    
    public ClientHandler(Looper paramLooper, ScreenShotServiceClient paramScreenShotServiceClient)
    {
      super();
      this.mOut = new WeakReference(paramScreenShotServiceClient);
    }
    
    public void handleMessage(Message paramMessage)
    {
      ScreenShotServiceClient localScreenShotServiceClient = (ScreenShotServiceClient)this.mOut.get();
      if ((localScreenShotServiceClient == null) || (paramMessage == null)) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      Log.i(ScreenShotServiceClient.TAG, "ScreenShotServiceClient receives SCREENSHOT_HAPPEN = ");
      Threads.runOnMainThread(new ScreenShotServiceClient.ClientHandler.1(this, localScreenShotServiceClient));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.screenshot.ScreenShotServiceClient
 * JD-Core Version:    0.7.0.1
 */