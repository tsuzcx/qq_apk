package com.tencent.map.lib.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

final class AsyncTask$2
  extends FutureTask<Result>
{
  AsyncTask$2(AsyncTask paramAsyncTask, Callable paramCallable)
  {
    super(paramCallable);
  }
  
  protected final void done()
  {
    try
    {
      AsyncTask.b(this.a, get());
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      throw new RuntimeException("An error occured while executing doInBackground()", localExecutionException.getCause());
    }
    catch (CancellationException localCancellationException)
    {
      AsyncTask.b(this.a, null);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.lib.thread.AsyncTask.2
 * JD-Core Version:    0.7.0.1
 */