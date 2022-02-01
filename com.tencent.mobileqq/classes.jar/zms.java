import android.os.Bundle;
import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Set;

public class zms
{
  public static void a(@NonNull String paramString, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      yuk.b(paramString, ", logBundleDetails : null");
      return;
    }
    yuk.b(paramString, "-- ----------- logBundleDetails ------------- [[[");
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      yuk.a(paramString, "-- - %s : %s", str, paramBundle.get(str));
    }
    yuk.b(paramString, "-- ----------- logBundleDetails ------------- ]]]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zms
 * JD-Core Version:    0.7.0.1
 */