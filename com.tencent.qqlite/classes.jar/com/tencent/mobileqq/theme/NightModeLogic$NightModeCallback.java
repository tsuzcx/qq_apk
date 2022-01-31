package com.tencent.mobileqq.theme;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public abstract class NightModeLogic$NightModeCallback
  implements ThemeSwitchManager.ThemeSwitchCallback
{
  public abstract void a(Bundle paramBundle);
  
  public abstract void b(Bundle paramBundle);
  
  public final void c(Bundle paramBundle)
  {
    int i = paramBundle.getInt("result", -1);
    if (i == 2) {
      paramBundle.putInt("start_status", 2);
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ThemeSwitch", 4, "NightModeCallback start_status: " + paramBundle.getInt("start_status", -1));
      }
      b(paramBundle);
      return;
      if (i == 1)
      {
        paramBundle.putInt("start_status", 4);
      }
      else if (i == 3)
      {
        long l1 = paramBundle.getLong("transferedSize", 0L);
        long l2 = paramBundle.getLong("filesize", 0L);
        int j = 100;
        i = j;
        if (l2 != 0L)
        {
          i = j;
          if (l1 < l2) {
            i = (int)(Math.round(l1 * 1.0D / l2 * 100.0D) / 100.0D * 100.0D);
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("ThemeSwitch", 4, "NightModeCallback transferedSize: " + l1 + ",filesize=" + l2 + ",percent=" + i);
        }
        paramBundle.putInt("percent", i);
        paramBundle.putInt("start_status", 3);
      }
    }
  }
  
  public final void d(Bundle paramBundle)
  {
    a(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.NightModeLogic.NightModeCallback
 * JD-Core Version:    0.7.0.1
 */