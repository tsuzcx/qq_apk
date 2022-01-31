import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ttpic.baseutils.log.LogUtils;

public final class ytg
{
  private static Pair<String, Long> a;
  
  public static boolean a(@NonNull String paramString)
  {
    if ((a != null) && (TextUtils.equals(paramString, (CharSequence)a.first))) {}
    long l;
    for (Long localLong = (Long)a.second;; localLong = null)
    {
      l = SystemClock.elapsedRealtime();
      if ((localLong == null) || (l - localLong.longValue() >= 1000L)) {
        break;
      }
      LogUtils.w("FastClickUtils", "fast click ,tag  = " + paramString + ", intervalTime = " + (l - localLong.longValue()));
      return true;
    }
    a = new Pair(paramString, Long.valueOf(l));
    return false;
  }
  
  public static boolean a(@NonNull String paramString, long paramLong)
  {
    if ((a != null) && (TextUtils.equals(paramString, (CharSequence)a.first))) {}
    long l;
    for (Long localLong = (Long)a.second;; localLong = null)
    {
      l = SystemClock.elapsedRealtime();
      if ((localLong == null) || (l - localLong.longValue() >= paramLong)) {
        break;
      }
      LogUtils.w("FastClickUtils", "fast click ,tag  = " + paramString + ", intervalTime = " + (l - localLong.longValue()));
      return true;
    }
    a = new Pair(paramString, Long.valueOf(l));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ytg
 * JD-Core Version:    0.7.0.1
 */