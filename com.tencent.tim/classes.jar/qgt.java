import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public class qgt
{
  public static ConcurrentHashMap<String, Long> ca = new ConcurrentHashMap();
  
  public static void rH(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long l;
    Long localLong;
    do
    {
      return;
      l = System.currentTimeMillis();
      localLong = (Long)ca.get(paramString);
    } while ((localLong != null) && (Math.abs(l - localLong.longValue()) <= 120000L));
    ca.put(paramString, Long.valueOf(l));
    pxt.ei(Collections.singletonList(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qgt
 * JD-Core Version:    0.7.0.1
 */