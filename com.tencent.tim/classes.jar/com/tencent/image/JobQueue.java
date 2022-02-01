package com.tencent.image;

import com.tencent.mobileqq.app.Job;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.LinkedList;

public class JobQueue
  implements ThreadExcutor.IThreadListener
{
  protected final int maxRunning;
  protected LinkedList<Job> queue = new LinkedList();
  protected int running;
  
  public JobQueue(int paramInt)
  {
    this.maxRunning = paramInt;
  }
  
  /* Error */
  public void execute(java.lang.Runnable paramRunnable, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: aload_1
    //   4: aconst_null
    //   5: iload_3
    //   6: invokestatic 33	com/tencent/mobileqq/app/ThreadExcutor:buildJob	(ILjava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)Lcom/tencent/mobileqq/app/Job;
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 35	com/tencent/image/JobQueue:running	I
    //   14: aload_0
    //   15: getfield 24	com/tencent/image/JobQueue:maxRunning	I
    //   18: if_icmpge +26 -> 44
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 35	com/tencent/image/JobQueue:running	I
    //   26: iconst_1
    //   27: iadd
    //   28: putfield 35	com/tencent/image/JobQueue:running	I
    //   31: aload_1
    //   32: aload_1
    //   33: getfield 40	com/tencent/mobileqq/app/Job:mType	I
    //   36: aload_0
    //   37: iconst_0
    //   38: invokestatic 46	com/tencent/mobileqq/app/ThreadManagerV2:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: aload_0
    //   45: getfield 22	com/tencent/image/JobQueue:queue	Ljava/util/LinkedList;
    //   48: aload_1
    //   49: invokevirtual 50	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   52: pop
    //   53: goto -12 -> 41
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	JobQueue
    //   0	61	1	paramRunnable	java.lang.Runnable
    //   0	61	2	paramInt	int
    //   0	61	3	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	41	56	finally
    //   44	53	56	finally
  }
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    try
    {
      this.running -= 1;
      while (this.running < this.maxRunning)
      {
        Job localJob = (Job)this.queue.poll();
        if (localJob == null) {
          break;
        }
        this.running += 1;
        ThreadManagerV2.excute(localJob, localJob.mType, this, false);
      }
    }
    finally {}
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.JobQueue
 * JD-Core Version:    0.7.0.1
 */