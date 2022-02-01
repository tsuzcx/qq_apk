import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class aqfe
{
  public static void J(Context paramContext, String paramString1, String paramString2)
  {
    save(paramContext, paramString1, paramString2);
  }
  
  public static String get(Context paramContext, String paramString)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("c_profile_sharepreference", 0).getString(paramString, "");
    }
    return "";
  }
  
  public static void remove(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("c_profile_sharepreference", 0).edit();
      paramContext.remove(paramString);
      paramContext.commit();
    }
  }
  
  private static void save(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("c_profile_sharepreference", 0).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqfe
 * JD-Core Version:    0.7.0.1
 */