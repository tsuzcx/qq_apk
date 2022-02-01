package com.tencent.moai.mailsdk.task;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

class TaskPool$2
  implements Observable.OnSubscribe<Void>
{
  TaskPool$2(TaskPool paramTaskPool, Task paramTask, Handler paramHandler) {}
  
  public void call(Subscriber<? super Void> paramSubscriber)
  {
    TaskPool.access$600(this.this$0, this.val$task, this.val$handler, paramSubscriber);
    paramSubscriber.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.task.TaskPool.2
 * JD-Core Version:    0.7.0.1
 */