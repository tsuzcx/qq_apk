import android.util.Log;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class nnw
{
  private static String TAG = "TimeUtil";
  private static ConcurrentHashMap<String, Long> bw = new ConcurrentHashMap(new HashMap(8));
  
  public static long J(String paramString)
  {
    if (bw.containsKey(paramString))
    {
      long l1 = System.currentTimeMillis();
      long l2 = l1 - ((Long)bw.get(paramString)).longValue();
      Log.d(TAG, paramString + " end spent time : " + l2 + "      end time " + l1);
      bw.remove(paramString);
      return l2;
    }
    bw.put(paramString, Long.valueOf(System.currentTimeMillis()));
    Log.d(TAG, paramString + " start time : " + System.currentTimeMillis());
    return -1L;
  }
  
  public static long K(String paramString)
  {
    paramString = (Long)bw.put(paramString, Long.valueOf(System.currentTimeMillis()));
    if (paramString == null) {
      return -1L;
    }
    return paramString.longValue();
  }
  
  public static long L(String paramString)
  {
    long l = -1L;
    if (bw.containsKey(paramString)) {
      l = ((Long)bw.remove(paramString)).longValue();
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nnw
 * JD-Core Version:    0.7.0.1
 */