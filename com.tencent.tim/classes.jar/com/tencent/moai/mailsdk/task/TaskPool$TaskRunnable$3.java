package com.tencent.moai.mailsdk.task;

import rx.functions.Action0;

class TaskPool$TaskRunnable$3
  implements Action0
{
  TaskPool$TaskRunnable$3(TaskPool.TaskRunnable paramTaskRunnable, Handler paramHandler) {}
  
  public void call()
  {
    if (TaskPool.access$000(this.this$1.this$0) == 3) {
      this.val$handler.closeConnection();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.task.TaskPool.TaskRunnable.3
 * JD-Core Version:    0.7.0.1
 */