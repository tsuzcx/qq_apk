package com.tencent.qqmail.utilities;

import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import com.tencent.qqmail.utilities.log.QMLog;

public class WakerLock
{
  private static final String TAG = "QQMail.WakerLock";
  private static final ConcurrentHashSet<PowerManager.WakeLock> WAKE_LOCK_SET = new ConcurrentHashSet();
  private long mAcquireTime;
  private Runnable mChecker = new WakerLock.2(this);
  private Handler mHandler = null;
  private Runnable mReleaser = new WakerLock.1(this);
  private PowerManager.WakeLock wakeLock = null;
  
  public WakerLock(Context paramContext)
  {
    this.wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "QQMail.WakerLock");
    this.wakeLock.setReferenceCounted(false);
    this.mHandler = new Handler(paramContext.getMainLooper());
  }
  
  private void lock()
  {
    this.mHandler.removeCallbacks(this.mReleaser);
    try
    {
      this.mAcquireTime = SystemClock.elapsedRealtime();
      this.wakeLock.acquire();
      if (!WAKE_LOCK_SET.add(this.wakeLock)) {
        QMLog.log(5, "QQMail.WakerLock", "consider carefully as others can release this wakelock when mRefCounted is set false");
      }
      label46:
      QMLog.log(4, "QQMail.WakerLock", "acquire " + this + ", elapse: " + (SystemClock.elapsedRealtime() - this.mAcquireTime));
      return;
    }
    catch (SecurityException localSecurityException)
    {
      break label46;
    }
  }
  
  public boolean isLocking()
  {
    try
    {
      boolean bool = this.wakeLock.isHeld();
      return bool;
    }
    catch (SecurityException localSecurityException) {}
    return false;
  }
  
  public void lock(long paramLong)
  {
    lock();
    this.mHandler.postDelayed(this.mReleaser, paramLong);
  }
  
  public void unLock()
  {
    this.mHandler.removeCallbacks(this.mReleaser);
    WAKE_LOCK_SET.remove(this.wakeLock);
    try
    {
      if (this.wakeLock.isHeld()) {
        this.wakeLock.release();
      }
      label39:
      QMLog.log(4, "QQMail.WakerLock", "release " + this + ", holding time: " + (SystemClock.elapsedRealtime() - this.mAcquireTime));
      return;
    }
    catch (SecurityException localSecurityException)
    {
      break label39;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.WakerLock
 * JD-Core Version:    0.7.0.1
 */