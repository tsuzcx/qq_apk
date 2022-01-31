import java.util.concurrent.ThreadFactory;

public final class fpj
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread("Bubble_Animation");
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fpj
 * JD-Core Version:    0.7.0.1
 */