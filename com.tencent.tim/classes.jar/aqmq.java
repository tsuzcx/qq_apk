import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class aqmq
{
  public static long atn;
  private static ConcurrentHashMap<String, Long> sLogs = new ConcurrentHashMap(new HashMap(8));
  
  public static boolean aFf()
  {
    return sLogs.containsKey("AIO_Start_cost");
  }
  
  public static final void bU(String paramString1, String paramString2)
  {
    long l = SystemClock.uptimeMillis();
    if (paramString1 != null)
    {
      paramString2 = (Long)sLogs.remove(paramString1);
      if (paramString2 != null)
      {
        atn = l - paramString2.longValue();
        paramString1 = paramString1 + ", cost=" + atn + "|" + QQAppInterface.bIQ + "|" + wit.bND;
        if (!QLog.isColorLevel()) {
          break label90;
        }
        QLog.i("AutoMonitor", 2, paramString1);
      }
    }
    label90:
    while (paramString2 == null)
    {
      return;
      Log.i("AutoMonitor", paramString1);
      return;
    }
    atn = 0L;
    sLogs.put(paramString2, Long.valueOf(l));
  }
  
  public static void br(String paramString, long paramLong) {}
  
  public static void track(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqmq
 * JD-Core Version:    0.7.0.1
 */