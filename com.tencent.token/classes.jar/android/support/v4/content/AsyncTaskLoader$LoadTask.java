package android.support.v4.content;

import android.support.v4.os.OperationCanceledException;
import java.util.concurrent.CountDownLatch;

final class AsyncTaskLoader$LoadTask
  extends ModernAsyncTask
  implements Runnable
{
  private final CountDownLatch mDone = new CountDownLatch(1);
  boolean waiting;
  
  AsyncTaskLoader$LoadTask(AsyncTaskLoader paramAsyncTaskLoader) {}
  
  protected Object doInBackground(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.this$0.onLoadInBackground();
      return paramVarArgs;
    }
    catch (OperationCanceledException paramVarArgs)
    {
      if (!isCancelled()) {
        throw paramVarArgs;
      }
    }
    return null;
  }
  
  protected void onCancelled(Object paramObject)
  {
    try
    {
      this.this$0.dispatchOnCancelled(this, paramObject);
      return;
    }
    finally
    {
      this.mDone.countDown();
    }
  }
  
  protected void onPostExecute(Object paramObject)
  {
    try
    {
      this.this$0.dispatchOnLoadComplete(this, paramObject);
      return;
    }
    finally
    {
      this.mDone.countDown();
    }
  }
  
  public void run()
  {
    this.waiting = false;
    this.this$0.executePendingTask();
  }
  
  public void waitForLoader()
  {
    try
    {
      this.mDone.await();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.content.AsyncTaskLoader.LoadTask
 * JD-Core Version:    0.7.0.1
 */