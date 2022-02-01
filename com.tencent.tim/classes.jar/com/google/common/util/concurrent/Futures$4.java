package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;

final class Futures$4
  implements Runnable
{
  Futures$4(ListenableFuture paramListenableFuture, FutureCallback paramFutureCallback) {}
  
  public void run()
  {
    try
    {
      Object localObject = Futures.getDone(this.val$future);
      this.val$callback.onSuccess(localObject);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      this.val$callback.onFailure(localExecutionException.getCause());
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      this.val$callback.onFailure(localRuntimeException);
      return;
    }
    catch (Error localError)
    {
      this.val$callback.onFailure(localError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Futures.4
 * JD-Core Version:    0.7.0.1
 */