import java.util.concurrent.ThreadFactory;

public final class gkb
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "RDM-Service");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gkb
 * JD-Core Version:    0.7.0.1
 */