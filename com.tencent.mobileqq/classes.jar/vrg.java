import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class vrg
{
  public static vrk a(Context paramContext, String paramString)
  {
    paramContext = vrk.a(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        vrk localvrk = (vrk)paramContext.next();
        if (TextUtils.equals(paramString, localvrk.a)) {
          return localvrk;
        }
      }
    }
    return null;
  }
  
  public static boolean a(Context paramContext)
  {
    return !TextUtils.isEmpty(bbax.a(paramContext, "qqstory_savedMusicList"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vrg
 * JD-Core Version:    0.7.0.1
 */