import android.os.Bundle;
import android.text.TextUtils;

public class aiff
{
  public static long c(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return 0L;
      paramBundle = paramBundle.getString("roomid", "");
    } while (TextUtils.isEmpty(paramBundle));
    return Long.parseLong(paramBundle);
  }
  
  public static String f(Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = "";
    }
    String str;
    do
    {
      return paramBundle;
      str = paramBundle.getString("roomtype");
      paramBundle = str;
    } while (!TextUtils.isEmpty(str));
    return "0";
  }
  
  public static String g(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return paramBundle.getString("fromid", "");
  }
  
  public static String h(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return paramBundle.getString("shakespearetime", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiff
 * JD-Core Version:    0.7.0.1
 */