import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class yin
{
  public static yir a(Context paramContext, String paramString)
  {
    paramContext = yir.a(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        yir localyir = (yir)paramContext.next();
        if (TextUtils.equals(paramString, localyir.a)) {
          return localyir;
        }
      }
    }
    return null;
  }
  
  public static boolean a(Context paramContext)
  {
    return !TextUtils.isEmpty(SharePreferenceUtils.get(paramContext, "qqstory_savedMusicList"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yin
 * JD-Core Version:    0.7.0.1
 */