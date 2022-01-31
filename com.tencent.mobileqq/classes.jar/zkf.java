import com.tencent.mobileqq.app.Job;
import com.tencent.mobileqq.app.ThreadRegulator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class zkf
  extends zkt
{
  public zkf(BlockingQueue paramBlockingQueue, zgp paramzgp)
  {
    super(3, 9, 1L, paramBlockingQueue, paramzgp);
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
 * Qualified Name:     zkf
 * JD-Core Version:    0.7.0.1
 */