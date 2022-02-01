package com.tencent.qqmail.utilities.qmnetwork.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.qqmail.protocol.CloudProtocolInfo;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.CloudProtocolService;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class PushLogin<T>
{
  private static final String PREFIX_PUSH_ENABLE_REQUEST_SESSION_KEY = "pushenablerequestsessionkey_";
  public static final String PREFIX_PUSH_LAST_REQUEST_SESSION_KEY_TIME = "pushrequestsessionkeytime_";
  private static final long[] REQUEST_SESSIONKEY_INTERVAL_ARRAY = (long[])new long[] { 10L, 30L, 90L, 270L, 600L };
  private static final int RETRY_TIMES_PER_INTERVAL = 3;
  protected static final String TAG = "PushLogin";
  protected final SharedPreferences.Editor mEditor;
  private final Object mPostWaiter = new Object();
  private final AtomicBoolean mRequestingSessionKey = new AtomicBoolean();
  private final Object mResultWaiter = new Object();
  protected final SharedPreferences mSharedPreferences;
  private final AtomicInteger mTryTimes = new AtomicInteger();
  protected long mVid;
  
  public PushLogin(SharedPreferences paramSharedPreferences)
  {
    this.mSharedPreferences = paramSharedPreferences;
    this.mEditor = this.mSharedPreferences.edit();
  }
  
  private void waitSessionKeyResult()
  {
    synchronized (this.mResultWaiter)
    {
      if (!hasSessionKey())
      {
        QMLog.log(3, "PushLogin", "requestSessionKey, start to wait sessionkey result");
        Threads.waitNoException(this.mResultWaiter);
        QMLog.log(3, "PushLogin", "requestSessionKey, wake up, hasSessionKey: " + hasSessionKey());
      }
      return;
    }
  }
  
  public abstract SendPacket getLoginPacket(long paramLong, String paramString, int paramInt);
  
  public abstract T getOldSessionKey();
  
  public abstract T getSessionKey();
  
  public abstract String getVersion();
  
  public abstract boolean hasSessionKey();
  
  public abstract boolean isResultValid(CloudProtocolResult paramCloudProtocolResult);
  
  public abstract boolean isSessiontKeyValid(T paramT);
  
  public void requestSessionKey(long paramLong, String arg3, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    QMLog.log(4, "PushLogin", "requestSessionKey, hasSessionKey: " + hasSessionKey() + ", force: " + paramBoolean1);
    synchronized (this.mResultWaiter)
    {
      if ((hasSessionKey()) && (!paramBoolean1)) {
        return;
      }
      setSessionKey(null);
      if (paramLong == 0L)
      {
        QMLog.log(5, "PushLogin", "requestSessionKey vid is 0!!");
        return;
      }
    }
    this.mVid = paramLong;
    ??? = "pushrequestsessionkeytime_" + paramLong;
    String str = "pushenablerequestsessionkey_" + paramLong;
    ??? = getOldSessionKey();
    long l1 = this.mSharedPreferences.getLong((String)???, 0L);
    long l2 = System.currentTimeMillis() - l1;
    int i = Math.min(this.mTryTimes.get() / 3, REQUEST_SESSIONKEY_INTERVAL_ARRAY.length - 1);
    long l3 = REQUEST_SESSIONKEY_INTERVAL_ARRAY[i] * 1000L;
    boolean bool = this.mSharedPreferences.getBoolean(str, true);
    QMLog.log(3, "PushLogin", "requestSessionKey, version: " + getVersion() + ", vid:" + paramLong + ", enableRequest: " + bool + ", curSessionKey: " + getSessionKey() + ", cachedSessionKey: " + ??? + ", isRequesting: " + this.mRequestingSessionKey.get() + ", interval: " + l2 + ", requestInterval: " + l3 + ", force: " + paramBoolean1 + ", blocking: " + paramBoolean2);
    if (!bool)
    {
      if (paramBoolean2)
      {
        SystemClock.sleep(600000L);
        this.mEditor.putBoolean(str, true).apply();
      }
    }
    else
    {
      if (paramBoolean1)
      {
        if (this.mRequestingSessionKey.get())
        {
          if (!paramBoolean2) {
            return;
          }
          waitSessionKeyResult();
        }
      }
      else
      {
        if (isSessiontKeyValid(???)) {
          synchronized (this.mResultWaiter)
          {
            if (!hasSessionKey()) {
              setSessionKey(???);
            }
            return;
          }
        }
        if (this.mRequestingSessionKey.get())
        {
          if (!paramBoolean2) {
            return;
          }
          waitSessionKeyResult();
          return;
        }
        l2 = l3 - l2;
        if ((l2 > 0L) && (!paramBoolean2)) {
          return;
        }
      }
      synchronized (this.mPostWaiter)
      {
        QMLog.log(3, "PushLogin", "requestSessionKey, wait to request, waitTime: " + l2);
        Threads.waitNoException(this.mPostWaiter, l2);
        QMLog.log(3, "PushLogin", "requestSessionKey, wake up to request");
        i = this.mTryTimes.getAndIncrement();
        if ((i == 2147483647) || (i < 0)) {
          this.mTryTimes.getAndSet(0);
        }
        if (this.mRequestingSessionKey.getAndSet(true))
        {
          waitSessionKeyResult();
          return;
        }
      }
      if (paramBoolean1) {}
      for (;;)
      {
        synchronized (this.mPostWaiter)
        {
          this.mPostWaiter.notifyAll();
          ??? = new CloudProtocolInfo();
          ((CloudProtocolInfo)???).device_id_ = paramString2;
          ((CloudProtocolInfo)???).uma_id_ = paramLong;
          ((CloudProtocolInfo)???).uma_psw_md5_sum_ = ???;
          l2 = System.currentTimeMillis();
          if (l1 == 0L)
          {
            l1 = -1L;
            this.mEditor.putLong((String)???, l2).apply();
            CloudProtocolService.Login((CloudProtocolInfo)???, new PushLogin.1(this, l2, l1, paramLong, str));
            if (!paramBoolean2) {
              break;
            }
            waitSessionKeyResult();
            return;
          }
        }
        l1 = l2 - l1;
      }
    }
  }
  
  public abstract void saveResult(CloudProtocolResult paramCloudProtocolResult);
  
  public abstract void setSessionKey(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.PushLogin
 * JD-Core Version:    0.7.0.1
 */