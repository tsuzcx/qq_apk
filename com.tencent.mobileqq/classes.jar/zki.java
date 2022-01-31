import com.tencent.mobileqq.app.Job;
import com.tencent.mobileqq.app.ThreadRegulator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class zki
  extends zkt
{
  public zki(BlockingQueue paramBlockingQueue, zgp paramzgp)
  {
    super(5, 64, 2L, paramBlockingQueue, paramzgp);
  }
  
  protected String a()
  {
    return "ThreadHeavyPool";
  }
  
  protected ConcurrentLinkedQueue a()
  {
    return Job.a;
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    ThreadRegulator.a().b();
    super.beforeExecute(paramThread, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zki
 * JD-Core Version:    0.7.0.1
 */