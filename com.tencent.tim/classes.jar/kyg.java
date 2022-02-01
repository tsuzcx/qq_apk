import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.aladdin.config.utils.Log;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class kyg
{
  private static SharedPreferences a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null)
    {
      Log.e("AladdinPrefUtils", "getSharedPreferences: null for runtime is null");
      return null;
    }
    paramAppRuntime = "readinjoy_sp_aladdin_" + paramAppRuntime.getAccount();
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramAppRuntime, 0);
  }
  
  public static void aIf()
  {
    Log.d("AladdinPrefUtils", "clearAladdinCommonConfigs");
    SharedPreferences localSharedPreferences = a(kxm.getAppRuntime());
    if (localSharedPreferences == null)
    {
      Log.d("AladdinPrefUtils", "clearAladdinCommonConfigs: sp is null");
      return;
    }
    localSharedPreferences.edit().clear().commit();
  }
  
  public static int getConfigVersionById(int paramInt)
  {
    SharedPreferences localSharedPreferences = a(kxm.getAppRuntime());
    if (localSharedPreferences == null)
    {
      Log.e("AladdinPrefUtils", "getConfigVersionById: return 0 for sp is null");
      return 0;
    }
    return localSharedPreferences.getInt("config_version_" + paramInt, 0);
  }
  
  public static void setConfigVersionById(int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = a(kxm.getAppRuntime());
    if (localSharedPreferences == null)
    {
      Log.e("AladdinPrefUtils", "setConfigVersionById: sp is null");
      return;
    }
    localSharedPreferences.edit().putInt("config_version_" + paramInt1, paramInt2).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kyg
 * JD-Core Version:    0.7.0.1
 */