import java.util.concurrent.ThreadFactory;

class hef
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    hee.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + hee.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hef
 * JD-Core Version:    0.7.0.1
 */