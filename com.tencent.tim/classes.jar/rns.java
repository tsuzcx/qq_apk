import android.os.Bundle;
import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Set;

public class rns
{
  public static void g(@NonNull String paramString, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      ram.d(paramString, ", logBundleDetails : null");
      return;
    }
    ram.d(paramString, "-- ----------- logBundleDetails ------------- [[[");
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ram.b(paramString, "-- - %s : %s", str, paramBundle.get(str));
    }
    ram.d(paramString, "-- ----------- logBundleDetails ------------- ]]]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rns
 * JD-Core Version:    0.7.0.1
 */