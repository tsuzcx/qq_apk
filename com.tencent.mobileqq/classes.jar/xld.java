import android.os.Bundle;
import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Set;

public class xld
{
  public static void a(@NonNull String paramString, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      wsv.b(paramString, ", logBundleDetails : null");
      return;
    }
    wsv.b(paramString, "-- ----------- logBundleDetails ------------- [[[");
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      wsv.a(paramString, "-- - %s : %s", str, paramBundle.get(str));
    }
    wsv.b(paramString, "-- ----------- logBundleDetails ------------- ]]]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xld
 * JD-Core Version:    0.7.0.1
 */