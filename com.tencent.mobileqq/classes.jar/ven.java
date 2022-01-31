import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class ven
{
  public static ver a(Context paramContext, String paramString)
  {
    paramContext = ver.a(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ver localver = (ver)paramContext.next();
        if (TextUtils.equals(paramString, localver.a)) {
          return localver;
        }
      }
    }
    return null;
  }
  
  public static boolean a(Context paramContext)
  {
    return !TextUtils.isEmpty(azzf.a(paramContext, "qqstory_savedMusicList"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ven
 * JD-Core Version:    0.7.0.1
 */