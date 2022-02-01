import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class axvu
{
  public static String TAG = "AutoMonitor_Camera";
  public static axvv a = new axvv();
  public static axvv b = new axvv();
  public static axvv c = new axvv();
  public static String cWp;
  public static axvv d = new axvv();
  public static boolean dwM = aPS();
  public static boolean dwN;
  public static boolean dwO = true;
  public static axvv e = new axvv();
  public static axvv f = new axvv(3);
  public static axvv g = new axvv(5);
  public static axvv h = new axvv();
  
  static
  {
    cWp = "FreqMonitorSwitch";
  }
  
  public static String a(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramInt == 0) || (paramArrayOfInt == null) || (paramInt > paramArrayOfInt.length)) {
      return "";
    }
    int i = paramInt - 1;
    if (i == -1) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    paramInt = 0;
    for (;;)
    {
      localStringBuilder.append(paramArrayOfInt[paramInt]);
      if (paramInt == i) {
        return ']';
      }
      localStringBuilder.append(", ");
      paramInt += 1;
    }
  }
  
  public static boolean aPS()
  {
    if (!PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).getBoolean(cWp, false)) {
      return aqhq.fileExists(aasa.SDCARD_ROOT + "/Tencent/AutoTestFlag_03");
    }
    return true;
  }
  
  public static int b(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 0) || (paramArrayOfInt == null) || (paramInt2 > paramArrayOfInt.length)) {}
    long l;
    do
    {
      return 0;
      l = 0L;
      int i = paramInt1;
      while (i < paramInt2)
      {
        l += paramArrayOfInt[i];
        i += 1;
      }
    } while (paramInt2 - paramInt1 == 0);
    return (int)(l / (paramInt2 - paramInt1));
  }
  
  public static void eOW()
  {
    if (a.isEnabled())
    {
      QLog.d(TAG, 1, String.format("CameraStartCost, activityCost=%d, refreshCost=%d, cameraCost=%d, cost=%d", new Object[] { Long.valueOf(a.t[1] - a.t[0]), Long.valueOf(a.t[2] - a.t[1]), Long.valueOf(a.t[3] - a.t[2]), Long.valueOf(a.t[3] - a.t[0]) }));
      a.stopMonitor();
    }
  }
  
  public static void eOX()
  {
    if (d.isEnabled())
    {
      d.endTime = System.currentTimeMillis();
      long l = d.endTime - d.startTime;
      QLog.d(TAG, 1, String.format("CameraEditStatistic, avgRenderCost=%d, cost=%d, frameCount=%d, frameFreq=%d", new Object[] { Integer.valueOf(b(d.tX, 0, d.frameCount)), Long.valueOf(l), Integer.valueOf(d.frameCount), Long.valueOf(d.frameCount * 1000 / l) }));
      QLog.d(TAG, 1, String.format("CameraEditStatistic, render cost: %s", new Object[] { a(d.tX, d.frameCount) }));
      d.stopMonitor();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvu
 * JD-Core Version:    0.7.0.1
 */