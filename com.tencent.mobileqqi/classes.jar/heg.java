import java.util.concurrent.ThreadFactory;

class heg
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    hef.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + hef.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     heg
 * JD-Core Version:    0.7.0.1
 */