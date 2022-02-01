package com.tencent.qqmail.utilities.screenshot;

import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import java.lang.ref.WeakReference;

public class ScreenshotService
  extends Service
{
  public static final String TAG = ScreenshotService.class.getSimpleName();
  private Messenger clientMsger;
  private ScreenshotWatcher.ScreenshotCallback mCallback = new ScreenshotService.1(this);
  private ScreenshotWatcher screenshotWatcher;
  private Messenger serviceMsger;
  private HandlerThread thread = new HandlerThread("ScreenshotService");
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.serviceMsger.getBinder();
  }
  
  public void onCreate()
  {
    Log.i(TAG, "ScreenshotService onCreate");
    super.onCreate();
    this.thread.start();
    this.serviceMsger = new Messenger(new IncomingHandler(this.thread.getLooper(), this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i(TAG, "ScreenshotService onDestroy");
    stopWatching();
    this.thread.quit();
  }
  
  public void startWatching()
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    for (this.screenshotWatcher = new ScreenshotMediaWatcher(QMApplicationContext.sharedInstance(), this.mCallback);; this.screenshotWatcher = new ScreenshotFileWatcher(this.mCallback))
    {
      this.screenshotWatcher.startWatching();
      return;
    }
  }
  
  public void stopWatching()
  {
    if (this.screenshotWatcher != null)
    {
      this.screenshotWatcher.stopWatching();
      this.screenshotWatcher.release();
      this.screenshotWatcher = null;
    }
    this.thread.quit();
  }
  
  static class IncomingHandler
    extends Handler
  {
    WeakReference<ScreenshotService> mOut;
    
    IncomingHandler(Looper paramLooper, ScreenshotService paramScreenshotService)
    {
      super();
      this.mOut = new WeakReference(paramScreenshotService);
    }
    
    public void handleMessage(Message paramMessage)
    {
      ScreenshotService localScreenshotService = (ScreenshotService)this.mOut.get();
      if ((localScreenshotService == null) || (paramMessage == null)) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      ScreenshotService.access$002(localScreenshotService, paramMessage.replyTo);
      localScreenshotService.startWatching();
    }
  }
  
  public static abstract interface MessageName
  {
    public static final int REGIST_LISTEN = 1;
    public static final int SCREENSHOT_HAPPEN = 3;
    public static final int STOP_LISTEN = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.screenshot.ScreenshotService
 * JD-Core Version:    0.7.0.1
 */