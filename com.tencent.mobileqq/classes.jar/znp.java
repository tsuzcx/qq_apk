import com.tencent.mobileqq.app.Job;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class znp
  extends znz
{
  public znp(BlockingQueue paramBlockingQueue, zjv paramzjv)
  {
    super(2, 128, 2L, paramBlockingQueue, paramzjv);
  }
  
  protected String a()
  {
    return "ThreadLightPool";
  }
  
  protected ConcurrentLinkedQueue a()
  {
    return Job.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     znp
 * JD-Core Version:    0.7.0.1
 */