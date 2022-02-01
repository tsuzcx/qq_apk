import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class alyt
{
  private static HandlerThread U;
  static String aeM = "DataCollector";
  public boolean mEnable = true;
  Handler mHandler = new alyu(this, U.getLooper());
  
  static
  {
    U = new HandlerThread("Colloector-Tasker");
    U.start();
  }
  
  public alyt(Context paramContext)
  {
    aeM = getClass().getSimpleName();
  }
  
  static Looper g()
  {
    return U.getLooper();
  }
  
  protected void handleMessage(Message paramMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyt
 * JD-Core Version:    0.7.0.1
 */