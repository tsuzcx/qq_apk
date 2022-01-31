import android.os.Process;
import com.tencent.av.thread.PriorityThreadFactory;

public class biq
  extends Thread
{
  public biq(PriorityThreadFactory paramPriorityThreadFactory, Runnable paramRunnable, String paramString)
  {
    super(paramRunnable, paramString);
  }
  
  public void run()
  {
    Process.setThreadPriority(PriorityThreadFactory.a(this.a));
    super.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     biq
 * JD-Core Version:    0.7.0.1
 */