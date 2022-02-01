import android.util.Log;
import java.util.ArrayList;

public class aiwv
{
  public static aiwn a(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (paramString.length() >= 0))
    {
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          paramString = new aiwy(paramString).b();
          if ((paramString == null) || (paramString.xs.size() <= 0)) {
            break;
          }
          return paramString;
        }
        catch (Exception paramString)
        {
          Log.e("LyricParseHelper", "parse exception:", paramString);
        }
        paramString = new aiww(paramString).a();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiwv
 * JD-Core Version:    0.7.0.1
 */