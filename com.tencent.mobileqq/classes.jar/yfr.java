import java.util.concurrent.ThreadFactory;

public final class yfr
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable);
    paramRunnable.setName("pre-loader-pool-" + paramRunnable.getId());
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yfr
 * JD-Core Version:    0.7.0.1
 */