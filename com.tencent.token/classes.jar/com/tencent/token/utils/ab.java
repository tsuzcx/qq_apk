package com.tencent.token.utils;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class ab
  extends FutureTask
{
  ab(UserTask paramUserTask, Callable paramCallable)
  {
    super(paramCallable);
  }
  
  protected void done()
  {
    Object localObject1 = null;
    if (UserTask.d() == null)
    {
      Looper.prepare();
      UserTask.a(new ad(null));
    }
    try
    {
      Object localObject2 = get();
      localObject1 = localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Log.w("UserTask", localInterruptedException);
      }
    }
    catch (ExecutionException localExecutionException)
    {
      throw new RuntimeException("An error occured while executing doInBackground()", localExecutionException.getCause());
    }
    catch (CancellationException localCancellationException)
    {
      UserTask.d().obtainMessage(3, new ae(this.a, (Object[])null)).sendToTarget();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new RuntimeException("An error occured while executing doInBackground()", localThrowable);
    }
    UserTask.d().obtainMessage(1, new ae(this.a, new Object[] { localObject1 })).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.ab
 * JD-Core Version:    0.7.0.1
 */