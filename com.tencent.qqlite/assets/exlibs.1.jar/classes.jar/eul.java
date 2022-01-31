import com.tencent.mobileqq.util.InfiniteTaskThreadPool;
import java.util.concurrent.ThreadFactory;

public class eul
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eul
 * JD-Core Version:    0.7.0.1
 */