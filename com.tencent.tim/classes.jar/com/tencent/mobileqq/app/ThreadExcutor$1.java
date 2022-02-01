package com.tencent.mobileqq.app;

class ThreadExcutor$1
  implements Runnable
{
  ThreadExcutor$1(ThreadExcutor paramThreadExcutor, int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean) {}
  
  public void run()
  {
    Job localJob = ThreadExcutor.buildJob(this.val$priority, this.val$job, this.val$listener, this.val$canAutoRetrieve);
    if (localJob == null)
    {
      ThreadLog.printQLog("ThreadManager", "post 3:w == null" + this.val$job);
      return;
    }
    if (this.val$priority >= 8)
    {
      localJob.poolNum = 1;
      ThreadExcutor.access$000(this.this$0).execute(localJob);
      return;
    }
    localJob.poolNum = 2;
    ThreadExcutor.access$100(this.this$0).execute(localJob);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadExcutor.1
 * JD-Core Version:    0.7.0.1
 */