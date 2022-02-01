package com.tencent.mobileqq.activity.aio.navigate;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import xrm;

public final class TroopAppShortcutNavBar$3
  implements Runnable
{
  public void run()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication());
    if ((localObject == null) || (((SharedPreferences)localObject).getInt(xrm.j(null), 0) >= 3)) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(xrm.j(null), 3).commit();
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutNavBar.3
 * JD-Core Version:    0.7.0.1
 */