package com.tencent.moai.mailsdk.task;

import com.tencent.moai.mailsdk.callback.TaskCallBack;
import com.tencent.moai.mailsdk.util.log.Logger;
import rx.functions.Action1;

class TaskPool$TaskRunnable$2
  implements Action1<Throwable>
{
  TaskPool$TaskRunnable$2(TaskPool.TaskRunnable paramTaskRunnable) {}
  
  public void call(Throwable paramThrowable)
  {
    Logger.log(6, "TaskPool", "post onError:" + this.this$1.task.getTag() + "," + paramThrowable.getMessage());
    if (this.this$1.callback != null) {
      this.this$1.callback.onError(paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.task.TaskPool.TaskRunnable.2
 * JD-Core Version:    0.7.0.1
 */