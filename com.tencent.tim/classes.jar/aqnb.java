import java.util.concurrent.ThreadFactory;

class aqnb
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    aqna.a.access$008();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + aqna.a.access$000());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqnb
 * JD-Core Version:    0.7.0.1
 */