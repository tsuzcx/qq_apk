package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Executor;

class AbstractIdleService$1
  implements Executor
{
  AbstractIdleService$1(AbstractIdleService paramAbstractIdleService) {}
  
  public void execute(Runnable paramRunnable)
  {
    MoreExecutors.newThread((String)AbstractIdleService.access$200(this.this$0).get(), paramRunnable).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractIdleService.1
 * JD-Core Version:    0.7.0.1
 */