package com.tencent.weiyun.callback;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public final class WeiyunCallbackCenter
{
  public static final long INVALID_SERIAL_NUM = 0L;
  private static final String TAG = "CallbackCenter";
  private final HashMap<Long, WeiyunCallback> mCallbackMap = new HashMap();
  private final Object mLock = new Object();
  private final Random mRandom = new Random();
  
  public long addCallback(WeiyunCallback paramWeiyunCallback)
  {
    if (paramWeiyunCallback == null) {
      return 0L;
    }
    long l = this.mRandom.nextLong();
    synchronized (this.mLock)
    {
      this.mCallbackMap.put(Long.valueOf(l), paramWeiyunCallback);
      return l;
    }
  }
  
  public int deleteCallback(WeiyunCallback paramWeiyunCallback)
  {
    int i = 0;
    if (paramWeiyunCallback != null) {
      for (;;)
      {
        synchronized (this.mLock)
        {
          Iterator localIterator = this.mCallbackMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            if (paramWeiyunCallback.equals(((Map.Entry)localIterator.next()).getValue()))
            {
              localIterator.remove();
              i += 1;
            }
          }
          else {
            return i;
          }
        }
      }
    }
    return 0;
  }
  
  public void deleteCallback(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    synchronized (this.mLock)
    {
      this.mCallbackMap.remove(Long.valueOf(paramLong));
      return;
    }
  }
  
  public WeiyunCallback getCallback(long paramLong)
  {
    if (paramLong == 0L) {
      return null;
    }
    synchronized (this.mLock)
    {
      WeiyunCallback localWeiyunCallback = (WeiyunCallback)this.mCallbackMap.get(Long.valueOf(paramLong));
      return localWeiyunCallback;
    }
  }
  
  public void onCallback(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean1, int paramInt2, String paramString, boolean paramBoolean2)
  {
    WeiyunCallback localWeiyunCallback = getCallback(paramLong1);
    if (localWeiyunCallback == null) {}
    do
    {
      return;
      localWeiyunCallback.onNativeCallback(paramLong2, paramInt1, paramInt2, paramString, paramBoolean1);
    } while (!paramBoolean2);
    deleteCallback(paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.callback.WeiyunCallbackCenter
 * JD-Core Version:    0.7.0.1
 */