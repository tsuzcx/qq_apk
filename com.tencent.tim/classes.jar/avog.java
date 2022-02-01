import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public final class avog
{
  public static void A(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext.getSharedPreferences("QR_SETTING", 0).edit().putInt("GIFT_REDTOUCH" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + paramInt1 + "type", paramInt2).apply();
  }
  
  public static void O(Context paramContext, int paramInt, String paramString)
  {
    paramContext.getSharedPreferences("QR_SETTING", 0).edit().putString("GIFT_REDTOUCH" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + paramInt + "content", paramString).apply();
  }
  
  public static void Z(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("QR_SETTING", 0).edit().putBoolean("USE_ENTRY_CONTROL", paramBoolean).apply();
  }
  
  public static String bM(Context paramContext)
  {
    return paramContext.getSharedPreferences("QR_SETTING", 0).getString("QR_LOCAL_BOOK_CONFIG" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), "");
  }
  
  public static boolean cT(Context paramContext)
  {
    return paramContext.getSharedPreferences("QR_SETTING", 0).getBoolean("USE_ENTRY_CONTROL", false);
  }
  
  public static void dl(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("QR_SETTING", 0).edit().putString("QR_LOCAL_BOOK_CONFIG" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), "").apply();
  }
  
  public static void gs(Context paramContext)
  {
    paramContext.getSharedPreferences("QR_SETTING", 0).edit().putLong("LAST_LOGIN_TIME" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), System.currentTimeMillis()).apply();
  }
  
  public static void h(Context paramContext, int paramInt, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("QR_SETTING", 0).edit().putBoolean("GIFT_REDTOUCH" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + paramInt + "show", paramBoolean).apply();
  }
  
  public static boolean m(Context paramContext, int paramInt)
  {
    return paramContext.getSharedPreferences("QR_SETTING", 0).getBoolean("GIFT_REDTOUCH" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + paramInt + "show", false);
  }
  
  public static String o(Context paramContext, int paramInt)
  {
    return paramContext.getSharedPreferences("QR_SETTING", 0).getString("GIFT_REDTOUCH" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + paramInt + "content", "");
  }
  
  public static long w(Context paramContext)
  {
    return paramContext.getSharedPreferences("QR_SETTING", 0).getLong("LAST_LOGIN_TIME" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), -1L);
  }
  
  public static int z(Context paramContext, int paramInt)
  {
    return paramContext.getSharedPreferences("QR_SETTING", 0).getInt("GIFT_REDTOUCH" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + paramInt + "type", -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avog
 * JD-Core Version:    0.7.0.1
 */