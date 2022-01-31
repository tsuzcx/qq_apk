import android.os.Bundle;
import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Set;

public class vjs
{
  public static void a(@NonNull String paramString, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      urk.b(paramString, ", logBundleDetails : null");
      return;
    }
    urk.b(paramString, "-- ----------- logBundleDetails ------------- [[[");
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      urk.a(paramString, "-- - %s : %s", str, paramBundle.get(str));
    }
    urk.b(paramString, "-- ----------- logBundleDetails ------------- ]]]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vjs
 * JD-Core Version:    0.7.0.1
 */