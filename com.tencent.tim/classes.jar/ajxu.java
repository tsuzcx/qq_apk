import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;

public class ajxu
{
  private static ajxu a = new ajxu();
  static boolean isInit;
  private SharedPreferences sp;
  
  public static boolean getBoolean(String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = a.sp.getBoolean(paramString, paramBoolean);
      return bool;
    }
    catch (ClassCastException paramString) {}
    return paramBoolean;
  }
  
  public static void init(Context paramContext, String paramString)
  {
    a.sp = SharedPreferencesProxyManager.getInstance().getProxy(paramString, 0);
    isInit = true;
  }
  
  public static void putBoolean(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = a.sp.edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajxu
 * JD-Core Version:    0.7.0.1
 */