import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import com.tencent.biz.videostory.EventControlUtils.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.Timer;

public class xeo
{
  private static SimpleArrayMap<String, Long> a = new SimpleArrayMap();
  private static SimpleArrayMap<String, Timer> b = new SimpleArrayMap();
  
  public static void a(String paramString, long paramLong, xep paramxep)
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
      ((Timer)localObject).schedule(new EventControlUtils.1(paramxep), paramLong);
      b.put(paramString, localObject);
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xeo
 * JD-Core Version:    0.7.0.1
 */