import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class aqgu
{
  public static void B(Context paramContext, String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    long l2 = paramInt * 60 * 1000;
    paramContext = paramContext.getSharedPreferences(paramString, 0).edit();
    paramContext.putLong("fl_pre_get_last_login_info", l1);
    paramContext.putLong("fl_get_last_login_info_time_period", l2);
    paramContext.commit();
  }
  
  public static void C(Context paramContext, String paramString, int paramInt)
  {
    paramContext.getSharedPreferences(String.valueOf(acbn.bkD), 0).edit().putInt(paramString, paramInt).commit();
  }
  
  public static void H(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("mobileQQ", 0).edit().putBoolean("save_qqhead_to_app_storage", paramBoolean).commit();
  }
  
  public static boolean ak(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(paramString, 0).getBoolean("fl_show_pc_icon", false);
  }
  
  public static boolean al(Context paramContext, String paramString)
  {
    boolean bool = false;
    paramContext = paramContext.getSharedPreferences(paramString, 0);
    long l1 = paramContext.getLong("fl_pre_get_last_login_info", 0L);
    long l2 = paramContext.getLong("fl_get_last_login_info_time_period", 0L);
    long l3 = System.currentTimeMillis();
    if ((l1 >= l3) || (l3 >= l1 + l2)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean bO(Context paramContext)
  {
    return paramContext.getSharedPreferences("mobileQQ", 0).getBoolean("save_qqhead_to_app_storage", false);
  }
  
  public static long g(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mobileQQ", 0).getLong("pref_req_self_level_time" + paramString, 0L);
  }
  
  public static void g(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences(paramString, 0).edit();
    paramContext.putBoolean("fl_show_pc_icon", paramBoolean);
    paramContext.commit();
  }
  
  public static long h(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mobileQQ", 0).getLong("pref_req_x_man_prefix" + paramString, 0L);
  }
  
  public static long i(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mobileQQ", 0).getLong("pref_last_req_x_man_scene_2_time_prefix_" + paramString, 0L);
  }
  
  public static void m(Context paramContext, String paramString, long paramLong)
  {
    paramContext.getSharedPreferences("mobileQQ", 0).edit().putLong("pref_req_self_level_time" + paramString, System.currentTimeMillis()).commit();
  }
  
  public static void n(Context paramContext, String paramString, long paramLong)
  {
    paramContext.getSharedPreferences("mobileQQ", 0).edit().putLong("pref_req_x_man_prefix" + paramString, paramLong).commit();
  }
  
  public static void o(Context paramContext, String paramString, long paramLong)
  {
    paramContext.getSharedPreferences("mobileQQ", 0).edit().putLong("pref_last_req_x_man_scene_2_time_prefix_" + paramString, paramLong).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqgu
 * JD-Core Version:    0.7.0.1
 */