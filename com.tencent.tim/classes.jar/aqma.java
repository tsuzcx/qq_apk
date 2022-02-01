import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

public class aqma
{
  public static int Mb()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).getInt("key_dialog_versioncode", 0);
  }
  
  public static void SJ(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putBoolean("key_predownload_success_key", paramBoolean);
    localEditor.apply();
  }
  
  public static void SK(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putBoolean("key_has_show_upgrade_dialog", paramBoolean);
    localEditor.apply();
  }
  
  public static void SL(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putBoolean("key_normal_upgrade", paramBoolean);
    localEditor.apply();
  }
  
  public static void XA(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putInt("key_versioncode", paramInt);
    localEditor.apply();
  }
  
  public static void XB(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putInt("key_dialog_versioncode", paramInt);
    localEditor.apply();
  }
  
  public static void XC(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putInt("key_normal_upgrade_version", paramInt);
    localEditor.apply();
  }
  
  public static boolean aEV()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).getBoolean("key_predownload_success_key", false);
  }
  
  public static boolean aEW()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).getBoolean("key_has_show_upgrade_dialog", false);
  }
  
  public static int getVersionCode()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).getInt("key_versioncode", 0);
  }
  
  public static boolean mx(int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0);
    if (localSharedPreferences.getInt("key_normal_upgrade_version", 0) != paramInt) {}
    while (!localSharedPreferences.getBoolean("key_normal_upgrade", false)) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqma
 * JD-Core Version:    0.7.0.1
 */