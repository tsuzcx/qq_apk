import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class xkh
{
  public static xkl a(Context paramContext, String paramString)
  {
    paramContext = xkl.a(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        xkl localxkl = (xkl)paramContext.next();
        if (TextUtils.equals(paramString, localxkl.a)) {
          return localxkl;
        }
      }
    }
    return null;
  }
  
  public static boolean a(Context paramContext)
  {
    return !TextUtils.isEmpty(bdea.a(paramContext, "qqstory_savedMusicList"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xkh
 * JD-Core Version:    0.7.0.1
 */