package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aptl;
import aqhq;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class TroopLinkManager$2
  implements Runnable
{
  public TroopLinkManager$2(aptl paramaptl, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (!aqhq.writeFile(this.val$path, this.val$json)) {
      BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt("troop_link_config_version", 0).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopLinkManager.2
 * JD-Core Version:    0.7.0.1
 */