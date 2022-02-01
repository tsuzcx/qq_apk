import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;
import java.util.Iterator;
import java.util.List;

class awqm
  implements ThreadPool.Job<Void>
{
  awqm(awqd paramawqd, List paramList) {}
  
  public Void run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext = this.val$suspendJobs.iterator();
    while (paramJobContext.hasNext())
    {
      long l = ((Long)paramJobContext.next()).longValue();
      this.b.suspendJob(l);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awqm
 * JD-Core Version:    0.7.0.1
 */