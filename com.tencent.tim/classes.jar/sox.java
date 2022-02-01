import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.HashMap;

public final class sox
{
  public static HashMap<String, Long> fQ = new HashMap();
  private static Pair<String, Long> i;
  
  public static boolean fY(@NonNull String paramString)
  {
    if ((i != null) && (TextUtils.equals(paramString, (CharSequence)i.first))) {}
    long l;
    for (Long localLong = (Long)i.second;; localLong = null)
    {
      l = SystemClock.elapsedRealtime();
      if ((localLong == null) || (l - localLong.longValue() >= 1000L)) {
        break;
      }
      LogUtils.w("FastClickUtils", "fast click ,tag  = " + paramString + ", intervalTime = " + (l - localLong.longValue()));
      return true;
    }
    i = new Pair(paramString, Long.valueOf(l));
    return false;
  }
  
  public static boolean i(@NonNull String paramString, long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    if (fQ == null) {
      fQ = new HashMap();
    }
    Long localLong = (Long)fQ.get(paramString);
    if (localLong != null)
    {
      if (fQ.size() > 10) {
        fQ.clear();
      }
      fQ.put(paramString, Long.valueOf(l));
      QLog.d("FastClickUtils", 4, "fast click ,tag  = " + paramString + ", currentTime = " + l + " lastTime" + localLong + " intervalTime = " + (l - localLong.longValue()));
      return l - localLong.longValue() < paramLong;
    }
    fQ.put(paramString, Long.valueOf(l));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sox
 * JD-Core Version:    0.7.0.1
 */