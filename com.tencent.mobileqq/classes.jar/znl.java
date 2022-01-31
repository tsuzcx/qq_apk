import com.tencent.mobileqq.app.Job;
import com.tencent.mobileqq.app.ThreadRegulator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class znl
  extends znz
{
  public znl(BlockingQueue paramBlockingQueue, zjv paramzjv)
  {
    super(3, 9, 1L, paramBlockingQueue, paramzjv);
  }
  
  protected String a()
  {
    return "ThreadDownLoadPool";
  }
  
  protected ConcurrentLinkedQueue a()
  {
    return Job.b;
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    ThreadRegulator.a().b();
    super.beforeExecute(paramThread, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     znl
 * JD-Core Version:    0.7.0.1
 */