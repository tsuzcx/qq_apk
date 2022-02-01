import com.tencent.mobileqq.util.InfiniteTaskThreadPool;
import java.util.concurrent.ThreadFactory;

public class hat
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    InfiniteTaskThreadPool.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + InfiniteTaskThreadPool.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hat
 * JD-Core Version:    0.7.0.1
 */