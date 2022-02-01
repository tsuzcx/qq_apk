import android.os.Bundle;
import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Set;

public class zch
{
  public static void a(@NonNull String paramString, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      ykq.b(paramString, ", logBundleDetails : null");
      return;
    }
    ykq.b(paramString, "-- ----------- logBundleDetails ------------- [[[");
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ykq.a(paramString, "-- - %s : %s", str, paramBundle.get(str));
    }
    ykq.b(paramString, "-- ----------- logBundleDetails ------------- ]]]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zch
 * JD-Core Version:    0.7.0.1
 */