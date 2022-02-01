import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class abyy
{
  private static HashMap<String, Long> iC = new HashMap();
  private static HashMap<String, Long> iD = new HashMap();
  
  public static void Df(String paramString)
  {
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString))) {
      iC.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
  
  public static void Dg(String paramString)
  {
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString)) && (iC.containsKey(paramString)))
    {
      Long localLong = (Long)iC.get(paramString);
      if (localLong != null)
      {
        long l1 = localLong.longValue();
        long l2 = SystemClock.uptimeMillis();
        iD.put(paramString, Long.valueOf(l2));
        QLog.d("TraceReport_CmShowStatUtil", 1, new Object[] { "eventName=", paramString, ", cost=", Long.valueOf(l2 - l1) });
      }
    }
  }
  
  public static void clear()
  {
    iC.clear();
    iD.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abyy
 * JD-Core Version:    0.7.0.1
 */