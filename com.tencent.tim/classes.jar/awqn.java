import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;
import java.util.Iterator;
import java.util.List;

class awqn
  implements ThreadPool.Job<Void>
{
  awqn(awqd paramawqd, List paramList) {}
  
  public Void run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext = this.LW.iterator();
    while (paramJobContext.hasNext())
    {
      long l = ((Long)paramJobContext.next()).longValue();
      this.b.removeJob(l);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awqn
 * JD-Core Version:    0.7.0.1
 */