import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class anpg
{
  public static int D(Context paramContext, String paramString)
  {
    return g(paramContext, paramString, "Click_grp_asst");
  }
  
  public static int E(Context paramContext, String paramString)
  {
    return g(paramContext, paramString, "grp_setting_asst");
  }
  
  public static int F(Context paramContext, String paramString)
  {
    return g(paramContext, paramString, "grp_setting_msg");
  }
  
  public static void F(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0);
    int i = paramContext.getInt(paramString1, 0);
    paramContext.edit().putInt(paramString1, i + 1).commit();
  }
  
  public static int G(Context paramContext, String paramString)
  {
    return g(paramContext, paramString, "grp_msg_equ");
  }
  
  public static int H(Context paramContext, String paramString)
  {
    return g(paramContext, paramString, "grp_msg_dec");
  }
  
  public static int I(Context paramContext, String paramString)
  {
    return g(paramContext, paramString, "grp_msg_inc");
  }
  
  public static void bT(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0).edit();
    paramContext.putInt(paramString + "Click_grp_asst", 0);
    paramContext.putInt(paramString + "grp_setting_asst", 0);
    paramContext.putInt(paramString + "grp_setting_msg", 0);
    paramContext.putInt(paramString + "grp_msg_equ", 0);
    paramContext.putInt(paramString + "grp_msg_dec", 0);
    paramContext.putInt(paramString + "grp_msg_inc", 0);
    paramContext.commit();
  }
  
  public static void bU(Context paramContext, String paramString)
  {
    F(paramContext, paramString, "grp_setting_asst");
  }
  
  public static void bV(Context paramContext, String paramString)
  {
    F(paramContext, paramString, "grp_msg_equ");
  }
  
  public static void bW(Context paramContext, String paramString)
  {
    F(paramContext, paramString, "grp_msg_dec");
  }
  
  public static void bX(Context paramContext, String paramString)
  {
    F(paramContext, paramString, "grp_msg_inc");
  }
  
  public static int g(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anpg
 * JD-Core Version:    0.7.0.1
 */