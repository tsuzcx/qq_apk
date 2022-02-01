package com.tencent.qqmail.utilities.translate;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClientTranslateHandler
  implements ITranslateHandler
{
  private static final String TAG = "ClientTranslateHandler";
  private long mBindTime;
  private AtomicBoolean mBinding = new AtomicBoolean();
  private volatile boolean mBound;
  private Map<Integer, Boolean> mFailMap = new ConcurrentHashMap();
  private Object mResultLock = new Object();
  private Map<Integer, Boolean> mResultMap = new ConcurrentHashMap();
  private ServiceConnection mServiceConnection = new ClientTranslateHandler.1(this);
  private LinkedBlockingQueue<Runnable> mTaskQueue = new LinkedBlockingQueue();
  private HandlerThread mThread = new HandlerThread("translate_result");
  private Messenger mTranslateService;
  
  private ClientTranslateHandler()
  {
    this.mThread.start();
    bindService();
  }
  
  private void bindService()
  {
    boolean bool = this.mBinding.getAndSet(true);
    QMLog.log(4, "ClientTranslateHandler", "bind TranslateService, bound: " + this.mBound + ", binding: " + bool);
    if ((!this.mBound) && (!bool))
    {
      this.mBindTime = SystemClock.elapsedRealtime();
      Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), TranslateService.class);
      QMApplicationContext.sharedInstance().bindService(localIntent, this.mServiceConnection, 1);
    }
  }
  
  private void enqueueTask(String paramString)
  {
    this.mTaskQueue.offer(new ClientTranslateHandler.2(this, paramString));
  }
  
  public static ClientTranslateHandler getInstance()
  {
    return Singleton.sInstance;
  }
  
  private void handleResult(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    QMLog.log(4, "ClientTranslateHandler", "handle result in client, result: " + paramBoolean1 + ", isMailContentEmpty: " + TextUtils.isEmpty(paramString));
    if (TextUtils.isEmpty(paramString))
    {
      notifyAll();
      return;
    }
    if (paramBoolean2) {
      this.mResultMap.put(Integer.valueOf(paramString.hashCode()), Boolean.valueOf(paramBoolean1));
    }
    for (;;)
    {
      notifyResult();
      return;
      this.mFailMap.put(Integer.valueOf(paramString.hashCode()), Boolean.TRUE);
    }
  }
  
  private void handleTasks()
  {
    try
    {
      while (!this.mTaskQueue.isEmpty())
      {
        Runnable localRunnable = (Runnable)this.mTaskQueue.poll();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
    }
    finally {}
  }
  
  private void notifyResult()
  {
    synchronized (this.mResultLock)
    {
      this.mResultLock.notifyAll();
      return;
    }
  }
  
  private void registerClient()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.replyTo = new Messenger(new IncomingHandler(this.mThread.getLooper(), this));
    try
    {
      this.mTranslateService.send(localMessage);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.log(5, "ClientTranslateHandler", "register client error!!", localThrowable);
    }
  }
  
  private void submitDetectTask(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("mail", paramString);
    localMessage.setData(localBundle);
    try
    {
      this.mTranslateService.send(localMessage);
      return;
    }
    catch (Throwable paramString)
    {
      QMLog.log(5, "ClientTranslateHandler", "submitDetectTask error!!", paramString);
    }
  }
  
  private void waitResult(long paramLong)
  {
    try
    {
      synchronized (this.mResultLock)
      {
        this.mResultLock.wait(paramLong);
        label15:
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label15;
    }
  }
  
  public boolean isFroeignLanguageSupport(String paramString)
    throws Throwable
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("mailContent is null!!");
    }
    int i = paramString.hashCode();
    Boolean localBoolean = (Boolean)this.mResultMap.get(Integer.valueOf(i));
    if (localBoolean != null)
    {
      QMLog.log(4, "ClientTranslateHandler", "result cached in client, result: " + localBoolean);
      return localBoolean.booleanValue();
    }
    enqueueTask(paramString);
    if ((this.mBound) && (this.mTranslateService != null)) {
      handleTasks();
    }
    for (;;)
    {
      long l1 = SystemClock.elapsedRealtime() + 1000L;
      do
      {
        if (SystemClock.elapsedRealtime() >= l1) {
          break;
        }
        long l2 = l1 - SystemClock.elapsedRealtime();
        if (l2 <= 0L) {
          break;
        }
        waitResult(l2);
      } while ((!this.mResultMap.containsKey(Integer.valueOf(i))) && (!this.mFailMap.containsKey(Integer.valueOf(i))));
      paramString = (Boolean)this.mResultMap.get(Integer.valueOf(i));
      this.mFailMap.remove(Integer.valueOf(i));
      if (paramString != null) {
        break;
      }
      throw new RuntimeException("result is null!! may be timeout or detect error");
      bindService();
    }
    return paramString.booleanValue();
  }
  
  static class IncomingHandler
    extends Handler
  {
    WeakReference<ClientTranslateHandler> mOut;
    
    public IncomingHandler(Looper paramLooper, ClientTranslateHandler paramClientTranslateHandler)
    {
      super();
      this.mOut = new WeakReference(paramClientTranslateHandler);
    }
    
    public void handleMessage(Message paramMessage)
    {
      ClientTranslateHandler localClientTranslateHandler = (ClientTranslateHandler)this.mOut.get();
      if ((localClientTranslateHandler == null) || (paramMessage == null)) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      paramMessage = paramMessage.getData();
      boolean bool = paramMessage.getBoolean("result");
      localClientTranslateHandler.handleResult(paramMessage.getString("mail"), bool, paramMessage.getBoolean("success"));
    }
  }
  
  static class Singleton
  {
    static ClientTranslateHandler sInstance = new ClientTranslateHandler(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.translate.ClientTranslateHandler
 * JD-Core Version:    0.7.0.1
 */