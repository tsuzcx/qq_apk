import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class vrj
{
  public static vrn a(Context paramContext, String paramString)
  {
    paramContext = vrn.a(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        vrn localvrn = (vrn)paramContext.next();
        if (TextUtils.equals(paramString, localvrn.a)) {
          return localvrn;
        }
      }
    }
    return null;
  }
  
  public static boolean a(Context paramContext)
  {
    return !TextUtils.isEmpty(bbaj.a(paramContext, "qqstory_savedMusicList"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vrj
 * JD-Core Version:    0.7.0.1
 */