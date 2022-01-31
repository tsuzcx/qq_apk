import com.tencent.av.app.VideoAppInterface;
import java.util.concurrent.ThreadFactory;

public class bhb
  implements ThreadFactory
{
  public bhb(VideoAppInterface paramVideoAppInterface) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable, "MSFVideo");
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    paramRunnable.setPriority(3);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhb
 * JD-Core Version:    0.7.0.1
 */