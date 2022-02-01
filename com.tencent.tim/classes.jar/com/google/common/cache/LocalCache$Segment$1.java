package com.google.common.cache;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

class LocalCache$Segment$1
  implements Runnable
{
  LocalCache$Segment$1(LocalCache.Segment paramSegment, Object paramObject, int paramInt, LocalCache.LoadingValueReference paramLoadingValueReference, ListenableFuture paramListenableFuture) {}
  
  public void run()
  {
    try
    {
      this.this$0.getAndRecordStats(this.val$key, this.val$hash, this.val$loadingValueReference, this.val$loadingFuture);
      return;
    }
    catch (Throwable localThrowable)
    {
      LocalCache.logger.log(Level.WARNING, "Exception thrown during refresh", localThrowable);
      this.val$loadingValueReference.setException(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.LocalCache.Segment.1
 * JD-Core Version:    0.7.0.1
 */