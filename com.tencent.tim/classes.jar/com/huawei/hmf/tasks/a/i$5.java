package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;

final class i$5
  implements OnCompleteListener<TResult>
{
  i$5(i parami1, i parami2, Continuation paramContinuation) {}
  
  public final void onComplete(Task<TResult> paramTask)
  {
    if (paramTask.isCanceled())
    {
      this.a.a();
      return;
    }
    try
    {
      paramTask = this.b.then(paramTask);
      this.a.a(paramTask);
      return;
    }
    catch (Exception paramTask)
    {
      this.a.a(paramTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.i.5
 * JD-Core Version:    0.7.0.1
 */