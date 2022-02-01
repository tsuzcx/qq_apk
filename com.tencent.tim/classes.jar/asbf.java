import android.content.Context;
import android.content.SharedPreferences;

public class asbf
{
  public static SharedPreferences getGlobalPreference(Context paramContext, String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = "sdk_preference";
    }
    return paramContext.getSharedPreferences(str, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asbf
 * JD-Core Version:    0.7.0.1
 */