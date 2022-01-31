import java.util.concurrent.ThreadFactory;

class eyg
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    eyf.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + eyf.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eyg
 * JD-Core Version:    0.7.0.1
 */