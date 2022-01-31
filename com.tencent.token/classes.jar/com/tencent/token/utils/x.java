package com.tencent.token.utils;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

final class x
  extends FutureTask
{
  x(UserTask paramUserTask, Callable paramCallable)
  {
    super(paramCallable);
  }
  
  protected final void done()
  {
    Object localObject1 = null;
    if (UserTask.e() == null)
    {
      Looper.prepare();
      UserTask.a(new z());
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
      UserTask.e().obtainMessage(3, new aa(this.a, null)).sendToTarget();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new RuntimeException("An error occured while executing doInBackground()", localThrowable);
    }
    UserTask.e().obtainMessage(1, new aa(this.a, new Object[] { localObject1 })).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.x
 * JD-Core Version:    0.7.0.1
 */