import java.util.concurrent.ThreadFactory;

public final class eeg
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "RDM-Service");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eeg
 * JD-Core Version:    0.7.0.1
 */