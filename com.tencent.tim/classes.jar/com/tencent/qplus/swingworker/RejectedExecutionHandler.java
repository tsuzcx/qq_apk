package com.tencent.qplus.swingworker;

public abstract interface RejectedExecutionHandler
{
  public abstract void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qplus.swingworker.RejectedExecutionHandler
 * JD-Core Version:    0.7.0.1
 */