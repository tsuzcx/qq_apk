import android.os.Bundle;
import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Set;

public class vwl
{
  public static void a(@NonNull String paramString, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      ved.b(paramString, ", logBundleDetails : null");
      return;
    }
    ved.b(paramString, "-- ----------- logBundleDetails ------------- [[[");
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ved.a(paramString, "-- - %s : %s", str, paramBundle.get(str));
    }
    ved.b(paramString, "-- ----------- logBundleDetails ------------- ]]]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vwl
 * JD-Core Version:    0.7.0.1
 */