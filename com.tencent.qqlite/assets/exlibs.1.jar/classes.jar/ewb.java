import java.util.concurrent.ThreadFactory;

class ewb
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    ewa.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + ewa.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ewb
 * JD-Core Version:    0.7.0.1
 */