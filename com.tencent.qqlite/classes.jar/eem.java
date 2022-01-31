import java.util.concurrent.ThreadFactory;

public final class eem
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "RDM-Service");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eem
 * JD-Core Version:    0.7.0.1
 */