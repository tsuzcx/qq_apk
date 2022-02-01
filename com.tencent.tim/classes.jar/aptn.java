import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadManager;

public class aptn
{
  private static Handler E;
  
  public static void e(Runnable paramRunnable)
  {
    if (E == null)
    {
      HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("TroopMemberDBThread", 0);
      localHandlerThread.start();
      E = new Handler(localHandlerThread.getLooper());
    }
    E.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aptn
 * JD-Core Version:    0.7.0.1
 */