package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

class AbstractExecutionThreadService$2
  implements Executor
{
  AbstractExecutionThreadService$2(AbstractExecutionThreadService paramAbstractExecutionThreadService) {}
  
  public void execute(Runnable paramRunnable)
  {
    MoreExecutors.newThread(this.this$0.serviceName(), paramRunnable).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractExecutionThreadService.2
 * JD-Core Version:    0.7.0.1
 */