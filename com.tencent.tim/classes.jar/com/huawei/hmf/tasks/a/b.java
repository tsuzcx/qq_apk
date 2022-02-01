package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

public final class b<TResult>
  implements ExecuteResult<TResult>
{
  private OnCanceledListener a;
  private Executor b;
  private final Object c = new Object();
  
  b(Executor paramExecutor, OnCanceledListener paramOnCanceledListener)
  {
    this.a = paramOnCanceledListener;
    this.b = paramExecutor;
  }
  
  public final void cancel()
  {
    synchronized (this.c)
    {
      this.a = null;
      return;
    }
  }
  
  public final void onComplete(Task<TResult> paramTask)
  {
    if (paramTask.isCanceled()) {
      this.b.execute(new b.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.b
 * JD-Core Version:    0.7.0.1
 */