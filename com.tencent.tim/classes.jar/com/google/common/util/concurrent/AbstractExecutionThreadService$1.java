package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

class AbstractExecutionThreadService$1
  extends AbstractService
{
  AbstractExecutionThreadService$1(AbstractExecutionThreadService paramAbstractExecutionThreadService) {}
  
  protected final void doStart()
  {
    MoreExecutors.renamingDecorator(this.this$0.executor(), new AbstractExecutionThreadService.1.1(this)).execute(new AbstractExecutionThreadService.1.2(this));
  }
  
  protected void doStop()
  {
    this.this$0.triggerShutdown();
  }
  
  public String toString()
  {
    return this.this$0.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractExecutionThreadService.1
 * JD-Core Version:    0.7.0.1
 */