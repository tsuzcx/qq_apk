package com.tencent.viola.vinstance;

import android.os.Looper;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

public class BlockVInstanceAction
  extends VInstanceAction
{
  private static final int ACQUIRE_LOCK_MAX_WAIT_TIME = 300;
  private static final String TAG = "BlockVInstanceAction";
  private static final int UPDATE_MAX_WAIT_TIME = 200;
  private int acquireLockMaxWaitTime = 300;
  private final Lock updateLock = new ReentrantLock(true);
  private int updateMaxWaitTime = 200;
  private final Condition updateReady = this.updateLock.newCondition();
  
  public BlockVInstanceAction(Preconditor paramPreconditor, ViolaInstance paramViolaInstance, JSONObject paramJSONObject)
  {
    super(paramPreconditor, paramViolaInstance, paramJSONObject);
  }
  
  private void tryWaitingJSOrSdkInit(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.violaInstance.updateInstance(paramString);
    }
    try
    {
      paramBoolean = this.updateLock.tryLock(this.acquireLockMaxWaitTime, TimeUnit.MILLISECONDS);
      if (!paramBoolean) {}
    }
    catch (InterruptedException paramString)
    {
      for (;;)
      {
        try
        {
          this.updateReady.await(this.updateMaxWaitTime, TimeUnit.MILLISECONDS);
          return;
        }
        catch (InterruptedException paramString)
        {
          ViolaLogUtils.e("BlockVInstanceAction", "tryWaitingJSOrSdkInit await timeout: " + paramString.getMessage());
          return;
        }
        finally
        {
          this.updateLock.unlock();
        }
        paramString = paramString;
        ViolaLogUtils.e("BlockVInstanceAction", "tryWaitingJSOrSdkInit getLock timeout: " + paramString.getMessage());
        paramBoolean = false;
      }
    }
  }
  
  public void addVInstance(String paramString1, String paramString2)
  {
    super.addVInstance(paramString1, paramString2);
    this.updateLock.lock();
    this.updateReady.signal();
    this.updateLock.unlock();
  }
  
  public void createVInstance(String paramString1, String paramString2)
  {
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
      throw new AssertionError();
    }
    updateInstance(paramString1, paramString2);
  }
  
  public void doInit(boolean paramBoolean)
  {
    this.preconditor.process(paramBoolean);
  }
  
  public void setAcquireLockMaxWaitTime(int paramInt)
  {
    this.acquireLockMaxWaitTime = paramInt;
  }
  
  public void setUpdateMaxWaitTime(int paramInt)
  {
    this.updateMaxWaitTime = paramInt;
  }
  
  public void updateInstance(String paramString1, String paramString2)
  {
    int i = this.state.get();
    if (i == 3)
    {
      tryWaitingJSOrSdkInit(paramString2, true);
      return;
    }
    if (i == 1)
    {
      addFailQueue(paramString1, paramString2);
      tryWaitingJSOrSdkInit(paramString2, false);
      return;
    }
    retryInit();
    addFailQueue(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.vinstance.BlockVInstanceAction
 * JD-Core Version:    0.7.0.1
 */