import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class zds
{
  public static zdw a(Context paramContext, String paramString)
  {
    paramContext = zdw.a(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        zdw localzdw = (zdw)paramContext.next();
        if (TextUtils.equals(paramString, localzdw.a)) {
          return localzdw;
        }
      }
    }
    return null;
  }
  
  public static boolean a(Context paramContext)
  {
    return !TextUtils.isEmpty(bgjb.a(paramContext, "qqstory_savedMusicList"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zds
 * JD-Core Version:    0.7.0.1
 */