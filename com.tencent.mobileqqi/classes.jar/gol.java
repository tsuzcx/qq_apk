import java.util.concurrent.ThreadFactory;

public final class gol
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "RDM-Service");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gol
 * JD-Core Version:    0.7.0.1
 */