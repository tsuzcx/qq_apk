import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class xfy
{
  public static xgc a(Context paramContext, String paramString)
  {
    paramContext = xgc.a(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        xgc localxgc = (xgc)paramContext.next();
        if (TextUtils.equals(paramString, localxgc.a)) {
          return localxgc;
        }
      }
    }
    return null;
  }
  
  public static boolean a(Context paramContext)
  {
    return !TextUtils.isEmpty(bczr.a(paramContext, "qqstory_savedMusicList"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xfy
 * JD-Core Version:    0.7.0.1
 */