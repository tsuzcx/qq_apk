package com.tencent.qplus.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class Task$2
  implements ThreadFactory
{
  final ThreadFactory defaultFactory = Executors.defaultThreadFactory();
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = this.defaultFactory.newThread(paramRunnable);
    paramRunnable.setName("Task-" + paramRunnable.getName());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qplus.task.Task.2
 * JD-Core Version:    0.7.0.1
 */