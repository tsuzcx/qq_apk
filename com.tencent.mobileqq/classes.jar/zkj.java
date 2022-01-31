import com.tencent.mobileqq.app.Job;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class zkj
  extends zkt
{
  public zkj(BlockingQueue paramBlockingQueue, zgp paramzgp)
  {
    super(2, 128, 2L, paramBlockingQueue, paramzgp);
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
 * Qualified Name:     zkj
 * JD-Core Version:    0.7.0.1
 */