package com.tencent.qqmail.qmimagecache;

class AsyncTask$SerialExecutor$1
  implements Runnable
{
  AsyncTask$SerialExecutor$1(AsyncTask.SerialExecutor paramSerialExecutor, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      this.val$r.run();
      return;
    }
    finally
    {
      this.this$0.scheduleNext();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmimagecache.AsyncTask.SerialExecutor.1
 * JD-Core Version:    0.7.0.1
 */