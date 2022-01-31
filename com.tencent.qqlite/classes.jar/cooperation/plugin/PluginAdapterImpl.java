package cooperation.plugin;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.IPluginAdapter;
import mqq.app.AppRuntime;

public class PluginAdapterImpl
  implements IPluginAdapter
{
  public Object invoke(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    paramBundle = BaseApplicationImpl.a();
    if ((paramBundle.a() != null) && ("1103".equals(paramBundle.getSharedPreferences(paramBundle.a().getAccount(), 0).getString("currentThemeId_20140616", "1000")))) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cooperation.plugin.PluginAdapterImpl
 * JD-Core Version:    0.7.0.1
 */