import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class avlp
{
  public static long B(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("QQPIM_SETTING", 0).getLong(paramString, 0L);
  }
  
  public static void G(Context paramContext, String paramString, long paramLong)
  {
    paramContext.getSharedPreferences("QQPIM_SETTING", 0).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void aq(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return;
    }
    paramContext.getSharedPreferences("QQPIM_SETTING", 0).edit().putString(paramString1, paramString2).commit();
  }
  
  public static String au(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("QQPIM_SETTING", 0).getString(paramString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avlp
 * JD-Core Version:    0.7.0.1
 */