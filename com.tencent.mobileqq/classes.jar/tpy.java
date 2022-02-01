import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class tpy
{
  public static String a(String paramString1, Context paramContext, String paramString2)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, "");
    }
    return "";
  }
  
  public static void a(String paramString1, Context paramContext, String paramString2)
  {
    if (paramContext != null)
    {
      paramString1 = paramContext.getSharedPreferences(paramString1, 0).edit();
      paramString1.remove(paramString2);
      paramString1.apply();
    }
  }
  
  public static void a(String paramString1, Context paramContext, String paramString2, String paramString3)
  {
    b(paramString1, paramContext, paramString2, paramString3);
  }
  
  private static void b(String paramString1, Context paramContext, String paramString2, String paramString3)
  {
    paramString1 = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramString1.putString(paramString2, paramString3);
    paramString1.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpy
 * JD-Core Version:    0.7.0.1
 */