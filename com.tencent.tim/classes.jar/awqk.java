import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;
import java.util.HashMap;

class awqk
  implements ThreadPool.Job<Void>
{
  awqk(awqd paramawqd, Long paramLong, aomg paramaomg) {}
  
  public Void run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext = (awqb)awqd.a(this.b).get(this.an);
    if ((paramJobContext == null) || (paramJobContext.isCanceled())) {
      awqd.a(this.b, this.an.longValue());
    }
    for (;;)
    {
      return null;
      awqd.b(this.b).a(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awqk
 * JD-Core Version:    0.7.0.1
 */