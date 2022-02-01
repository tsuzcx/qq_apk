import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import com.tencent.biz.videostory.EventControlUtils.1;
import com.tencent.biz.videostory.EventControlUtils.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.Timer;

public class sow
{
  private static SimpleArrayMap<String, Long> a = new SimpleArrayMap();
  private static SimpleArrayMap<String, Timer> b = new SimpleArrayMap();
  
  public static void a(String paramString, long paramLong, sow.a parama)
  {
    try
    {
      Object localObject = (Long)a.get(paramString);
      long l = SystemClock.elapsedRealtime();
      QLog.i("EventControlUtils", 2, "currentTime" + l);
      if ((localObject != null) && (l - ((Long)localObject).longValue() < paramLong))
      {
        LogUtils.w("EventControlUtils", "throttling in timeInterval" + paramLong);
        return;
      }
      a.put(paramString, Long.valueOf(l));
      localObject = (Timer)b.get(paramString);
      if (localObject != null) {
        ((Timer)localObject).cancel();
      }
      localObject = new Timer();
      ((Timer)localObject).schedule(new EventControlUtils.1(parama), paramLong);
      b.put(paramString, localObject);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void b(String paramString, long paramLong, sow.a parama)
  {
    if (b == null) {
      b = new SimpleArrayMap();
    }
    try
    {
      Timer localTimer = (Timer)b.get(paramString);
      if (localTimer != null) {
        localTimer.cancel();
      }
      localTimer = new Timer();
      localTimer.schedule(new EventControlUtils.2(parama), paramLong);
      b.put(paramString, localTimer);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static abstract interface a
  {
    public abstract void bkR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sow
 * JD-Core Version:    0.7.0.1
 */