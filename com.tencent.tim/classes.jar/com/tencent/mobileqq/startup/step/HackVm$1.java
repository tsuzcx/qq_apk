package com.tencent.mobileqq.startup.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

class HackVm$1
  implements Runnable
{
  HackVm$1(HackVm paramHackVm) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_hack_dvm", 4);
    if (HackVm.sVerifyResult == 21) {
      localSharedPreferences.edit().putInt("key_continuous_crash_count", 0);
    }
    localSharedPreferences.edit().putLong("key_last_hack_time", 0L).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.HackVm.1
 * JD-Core Version:    0.7.0.1
 */