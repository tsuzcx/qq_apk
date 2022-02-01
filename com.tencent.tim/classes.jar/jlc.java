import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;

public abstract class jlc
{
  public static long a(Intent paramIntent)
  {
    return paramIntent.getLongExtra("log_seq", 0L);
  }
  
  public static long a(ToServiceMsg paramToServiceMsg)
  {
    return a(paramToServiceMsg.getAttribute("log_seq"));
  }
  
  public static long a(Object paramObject)
  {
    long l = 0L;
    if ((paramObject instanceof Long)) {
      l = ((Long)paramObject).longValue();
    }
    return l;
  }
  
  public static long a(HashMap<String, Object> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.containsKey("log_seq"))) {
      return a(paramHashMap.get("log_seq"));
    }
    return 0L;
  }
  
  public static long a(Object[] paramArrayOfObject, int paramInt)
  {
    long l = 0L;
    if (paramArrayOfObject.length > paramInt) {
      l = a(paramArrayOfObject[paramInt]);
    }
    return l;
  }
  
  public static void a(Intent paramIntent, long paramLong)
  {
    paramIntent.putExtra("log_seq", paramLong);
  }
  
  public static void a(Bundle paramBundle, long paramLong)
  {
    paramBundle.putLong("log_seq", paramLong);
  }
  
  public static void a(HashMap<String, Object> paramHashMap, long paramLong)
  {
    paramHashMap.put("log_seq", Long.valueOf(paramLong));
  }
  
  public static long b(Bundle paramBundle)
  {
    long l = 0L;
    if (paramBundle != null) {
      l = paramBundle.getLong("log_seq");
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jlc
 * JD-Core Version:    0.7.0.1
 */