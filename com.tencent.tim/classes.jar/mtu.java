import android.content.BroadcastReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class mtu
{
  private static int MAX_COUNT = 5;
  private static final String TAG = mtu.class.getSimpleName();
  private static AtomicInteger X = new AtomicInteger(0);
  private static AtomicInteger Z;
  private static AtomicBoolean ax = new AtomicBoolean(false);
  private static BroadcastReceiver mScreenReceiver = new mtv();
  private static Thread mThread;
  
  static
  {
    Z = new AtomicInteger(0);
  }
  
  private static long cT()
  {
    for (long l = 0L; X.get() == 1; l += 1L) {}
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mtu
 * JD-Core Version:    0.7.0.1
 */