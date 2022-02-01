package com.tencent.mobileqq.startup.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class SetSplash$11
  implements Runnable
{
  public void run()
  {
    try
    {
      Object localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication);
      int i = ((SharedPreferences)localObject).getInt("dynamic_splash_config_show_times", -1);
      if (i <= 0) {
        return;
      }
      i -= 1;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("dynamic_splash_config_show_times", i);
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel())
      {
        QLog.d("SetSplash", 2, "saveDynamicSplashShowTime() rest totalShowTimes=" + i);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("SetSplash", 1, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash.11
 * JD-Core Version:    0.7.0.1
 */