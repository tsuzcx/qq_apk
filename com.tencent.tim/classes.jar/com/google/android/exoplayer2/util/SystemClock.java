package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.support.annotation.Nullable;

final class SystemClock
  implements Clock
{
  public HandlerWrapper createHandler(Looper paramLooper, @Nullable Handler.Callback paramCallback)
  {
    return new SystemHandlerWrapper(new Handler(paramLooper, paramCallback));
  }
  
  public long elapsedRealtime()
  {
    return android.os.SystemClock.elapsedRealtime();
  }
  
  public void sleep(long paramLong)
  {
    android.os.SystemClock.sleep(paramLong);
  }
  
  public long uptimeMillis()
  {
    return android.os.SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.util.SystemClock
 * JD-Core Version:    0.7.0.1
 */