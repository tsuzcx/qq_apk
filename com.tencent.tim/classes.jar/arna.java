import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class arna
{
  public static long A(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("kwsrgrt_" + paramString, -1L);
  }
  
  public static void C(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("kwslcdt_" + paramString, paramLong);
    paramContext.apply();
  }
  
  public static void D(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("kwslftjt_" + paramString, paramLong);
    paramContext.apply();
  }
  
  public static void E(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("kwsrgrt_" + paramString, paramLong);
    paramContext.apply();
  }
  
  public static void aQ(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("kwscdf_" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static void al(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("kwsg_" + paramString1, paramString2);
    paramContext.apply();
  }
  
  public static String ao(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("kwsg_" + paramString, "");
  }
  
  public static String ap(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("kwsjhu_" + paramString, null);
  }
  
  public static String bC(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("kwsbddbw", null);
  }
  
  public static int bJ(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("kwsjt_" + paramString, -1);
  }
  
  public static int bK(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("kwscdf_" + paramString, 24);
  }
  
  public static void cY(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("kwsbddbw", paramString);
    paramContext.apply();
  }
  
  public static void j(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("kwsjt_" + paramString1, paramInt);
    paramContext.putString("kwsjhu_" + paramString1, paramString2);
    paramContext.apply();
  }
  
  public static long y(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("kwslcdt_" + paramString, -1L);
  }
  
  public static long z(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("kwslftjt_" + paramString, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arna
 * JD-Core Version:    0.7.0.1
 */