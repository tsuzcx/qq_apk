import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public final class avob
{
  private static SharedPreferences c(Context paramContext)
  {
    return paramContext.getSharedPreferences("reader_user" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
  }
  
  public static final class a
  {
    public static int A(Context paramContext)
    {
      return avob.i(paramContext).getInt("GRAY_UPDATE_UPDATE_STATUS", 0);
    }
    
    public static boolean D(Context paramContext)
    {
      return avob.i(paramContext).getBoolean("GRAY_UPDATE_IS_UPDATE_TO_QQ_BOOKSTORE", false);
    }
    
    public static void T(Context paramContext, boolean paramBoolean)
    {
      avob.i(paramContext).edit().putBoolean("is_frist_enter_home_page_from_leba", paramBoolean).apply();
    }
    
    public static void U(Context paramContext, boolean paramBoolean)
    {
      avob.i(paramContext).edit().putBoolean("GRAY_UPDATE_IS_UPDATE_TO_QQ_BOOKSTORE", paramBoolean).apply();
    }
    
    public static void V(Context paramContext, boolean paramBoolean)
    {
      avob.i(paramContext).edit().putBoolean("HOME_PAGE_NEXT_BOTTOM_ITEM_IS_SHELF", paramBoolean).apply();
    }
    
    public static void W(Context paramContext, boolean paramBoolean)
    {
      avob.i(paramContext).edit().putBoolean("GRAY_UPDATE_IS_HAS_TAB_CONFIG_DATA", paramBoolean).apply();
    }
    
    public static void X(Context paramContext, boolean paramBoolean)
    {
      avob.i(paramContext).edit().putBoolean("new_user_in_act", paramBoolean).apply();
    }
    
    public static void Y(Context paramContext, boolean paramBoolean)
    {
      paramContext.getSharedPreferences("SETTING", 0).edit().putBoolean("is_new_user", paramBoolean).apply();
    }
    
    public static int bC(Context paramContext)
    {
      return paramContext.getSharedPreferences("SETTING", 0).getInt("NUM_OF_RED_POINT", 0);
    }
    
    public static void bb(Context paramContext, int paramInt)
    {
      avob.i(paramContext).edit().putInt("GRAY_UPDATE_GRAY_LEVEL", paramInt).apply();
    }
    
    public static void bc(Context paramContext, int paramInt)
    {
      avob.i(paramContext).edit().putInt("GRAY_UPDATE_UPDATE_STATUS", paramInt).apply();
    }
    
    public static void bd(Context paramContext, int paramInt)
    {
      avob.i(paramContext).edit().putInt("GRAY_UPDATING_NEXT_REQ_TIME_INTERVAL", paramInt).apply();
    }
    
    public static void be(Context paramContext, int paramInt)
    {
      avob.i(paramContext).edit().putInt("GRAY_UPDATING_REMAIN_MAX_TIME", paramInt).apply();
    }
    
    public static boolean cN(Context paramContext)
    {
      return avob.i(paramContext).getBoolean("is_frist_enter_home_page_from_leba", true);
    }
    
    public static boolean cO(Context paramContext)
    {
      return avob.i(paramContext).getBoolean("HOME_PAGE_NEXT_BOTTOM_ITEM_IS_SHELF", false);
    }
    
    public static boolean cP(Context paramContext)
    {
      return avob.i(paramContext).getBoolean("GRAY_UPDATE_IS_HAS_TAB_CONFIG_DATA", false);
    }
    
    public static boolean cQ(Context paramContext)
    {
      return avob.i(paramContext).getBoolean("new_user_in_act", false);
    }
    
    public static boolean cR(Context paramContext)
    {
      return paramContext.getSharedPreferences("SETTING", 0).getBoolean("is_new_user", true);
    }
    
    public static void u(Context paramContext, long paramLong)
    {
      avob.i(paramContext).edit().putLong("LAST_EXIT_BOOKSTORE_POP_WINDOW_TIME_", paramLong).apply();
    }
    
    public static long v(Context paramContext)
    {
      return avob.i(paramContext).getLong("LAST_EXIT_BOOKSTORE_POP_WINDOW_TIME_", 0L);
    }
    
    public static int y(Context paramContext)
    {
      return avob.i(paramContext).getInt("GRAY_UPDATE_GRAY_LEVEL", 0);
    }
  }
  
  public static final class b
  {
    public static String bK(Context paramContext)
    {
      return paramContext.getSharedPreferences("SETTING", 0).getString("debug_h5_test_env", null);
    }
    
    public static boolean cS(Context paramContext)
    {
      return paramContext.getSharedPreferences("SETTING", 0).getBoolean("debug_h5_test_mode", false);
    }
    
    public static void g(Context paramContext, boolean paramBoolean, String paramString)
    {
      paramContext.getSharedPreferences("SETTING", 0).edit().putBoolean("debug_h5_test_mode", paramBoolean).putString("debug_h5_test_env", paramString).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avob
 * JD-Core Version:    0.7.0.1
 */