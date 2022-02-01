import android.os.Handler;
import android.os.Looper;

public class aurs
{
  private static Handler sMainHandler;
  
  public static boolean aJC()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    try
    {
      if (sMainHandler == null) {
        sMainHandler = new Handler(Looper.getMainLooper());
      }
      sMainHandler.post(paramRunnable);
      return;
    }
    finally {}
  }
  
  public static void runOnUiThread(Runnable paramRunnable, long paramLong)
  {
    try
    {
      if (sMainHandler == null) {
        sMainHandler = new Handler(Looper.getMainLooper());
      }
      sMainHandler.postDelayed(paramRunnable, paramLong);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aurs
 * JD-Core Version:    0.7.0.1
 */