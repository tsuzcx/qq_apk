package com.tencent.mobileqq.app;

class ThreadExcutor$2
  implements Runnable
{
  ThreadExcutor$2(ThreadExcutor paramThreadExcutor, int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean) {}
  
  public void run()
  {
    Job localJob = ThreadExcutor.buildJob(this.val$type, this.val$job, this.val$listener, this.val$canAutoRetrieve);
    if (localJob == null)
    {
      ThreadExcutor.doRdmReport("ThreadManagerV2_excute_Job_NULL", "w_NONE_job" + this.val$job.getClass().getName());
      return;
    }
    ThreadSmartPool localThreadSmartPool;
    if ((this.val$type & 0x80) != 0)
    {
      localJob.poolNum = 9;
      localThreadSmartPool = ThreadExcutor.access$200(this.this$0);
    }
    for (;;)
    {
      localThreadSmartPool.execute(localJob);
      return;
      if ((this.val$type & 0x40) != 0)
      {
        localJob.poolNum = 8;
        localThreadSmartPool = ThreadExcutor.access$300(this.this$0);
      }
      else if ((this.val$type & 0x20) != 0)
      {
        localJob.poolNum = 7;
        localThreadSmartPool = ThreadExcutor.access$400(this.this$0);
      }
      else
      {
        if ((this.val$type & 0x10) == 0) {
          break;
        }
        localJob.poolNum = 6;
        localThreadSmartPool = ThreadExcutor.access$500(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadExcutor.2
 * JD-Core Version:    0.7.0.1
 */