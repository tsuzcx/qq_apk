import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class rjz
{
  public static rkc a(Context paramContext, String paramString)
  {
    paramContext = rkc.d(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        rkc localrkc = (rkc)paramContext.next();
        if (TextUtils.equals(paramString, localrkc.id)) {
          return localrkc;
        }
      }
    }
    return null;
  }
  
  public static boolean aC(Context paramContext)
  {
    return !TextUtils.isEmpty(aqfe.get(paramContext, "qqstory_savedMusicList"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rjz
 * JD-Core Version:    0.7.0.1
 */