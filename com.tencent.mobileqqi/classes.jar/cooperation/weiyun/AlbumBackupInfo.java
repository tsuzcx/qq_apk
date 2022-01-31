package cooperation.weiyun;

import android.content.Context;
import android.content.SharedPreferences;

public class AlbumBackupInfo
{
  public static final String a = "plugin_enable_state";
  private static final String b = "weiyun.pref.plugin.albumbackup.options";
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + paramString2;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", 0).getBoolean(a(paramString, "plugin_enable_state"), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.weiyun.AlbumBackupInfo
 * JD-Core Version:    0.7.0.1
 */