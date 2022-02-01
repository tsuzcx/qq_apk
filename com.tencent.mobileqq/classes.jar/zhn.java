import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class zhn
{
  public static zhr a(Context paramContext, String paramString)
  {
    paramContext = zhr.a(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        zhr localzhr = (zhr)paramContext.next();
        if (TextUtils.equals(paramString, localzhr.a)) {
          return localzhr;
        }
      }
    }
    return null;
  }
  
  public static boolean a(Context paramContext)
  {
    return !TextUtils.isEmpty(bhjc.a(paramContext, "qqstory_savedMusicList"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhn
 * JD-Core Version:    0.7.0.1
 */