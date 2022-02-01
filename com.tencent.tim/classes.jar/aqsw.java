import android.content.Context;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class aqsw
{
  private static aqsm defaultCallback = new aqsn();
  private static final HashMap<Long, aqsm> pi = new UpdateCallbackSelector.1();
  
  public static aqsm a(long paramLong)
  {
    aqsm localaqsm2 = (aqsm)pi.get(Long.valueOf(paramLong));
    aqsm localaqsm1 = localaqsm2;
    if (localaqsm2 == null) {
      localaqsm1 = defaultCallback;
    }
    return localaqsm1;
  }
  
  public static void a(aqsm paramaqsm)
  {
    try
    {
      defaultCallback = paramaqsm;
      return;
    }
    finally
    {
      paramaqsm = finally;
      throw paramaqsm;
    }
  }
  
  public static void b(aqsm paramaqsm)
  {
    try
    {
      if (defaultCallback == paramaqsm) {
        defaultCallback = new aqsn();
      }
      return;
    }
    finally
    {
      paramaqsm = finally;
      throw paramaqsm;
    }
  }
  
  public static void cleanCache(Context paramContext)
  {
    Iterator localIterator = pi.values().iterator();
    while (localIterator.hasNext()) {
      ((aqsm)localIterator.next()).cleanCache(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqsw
 * JD-Core Version:    0.7.0.1
 */