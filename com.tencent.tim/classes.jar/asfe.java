import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class asfe
{
  private static Handler sSubHandler = new Handler(sSubThread.getLooper());
  private static HandlerThread sSubThread = new HandlerThread("qav_sdk_thread_sub");
  private static Handler sUIHandler;
  
  static
  {
    sSubThread.start();
    sUIHandler = new Handler(Looper.getMainLooper());
  }
  
  public static void at(Runnable paramRunnable)
  {
    sSubHandler.removeCallbacks(paramRunnable);
  }
  
  public static void au(Runnable paramRunnable)
  {
    sUIHandler.post(paramRunnable);
  }
  
  public static void executeOnSubThread(Runnable paramRunnable)
  {
    sSubHandler.post(paramRunnable);
  }
  
  public static Handler getSubThreadHandler()
  {
    return sSubHandler;
  }
  
  public static Handler getUIHandler()
  {
    return sUIHandler;
  }
  
  public static void k(Runnable paramRunnable, long paramLong)
  {
    sSubHandler.postDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asfe
 * JD-Core Version:    0.7.0.1
 */