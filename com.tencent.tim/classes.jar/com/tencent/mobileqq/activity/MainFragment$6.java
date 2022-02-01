package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import anot;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;

class MainFragment$6
  implements Runnable
{
  MainFragment$6(MainFragment paramMainFragment, int paramInt) {}
  
  public void run()
  {
    String str2 = MainFragment.a(this.this$0);
    if ((MainFragment.aOe.equals(str2)) || (MainFragment.aOf.equals(str2))) {
      if (!MainFragment.aOe.equals(str2)) {
        break label193;
      }
    }
    label193:
    for (String str1 = "Msg_tab";; str1 = "Contacts_tab")
    {
      anot.a(MainFragment.a(this.this$0), "CliOper", "", "", str1, str1, 0, 0, "", "", "", "");
      if ((MainFragment.a(this.this$0) != null) && (MainFragment.a(this.this$0).getBoolean("theme_voice_setting_" + MainFragment.a(this.this$0).getCurrentAccountUin(), true))) {
        MainFragment.a(this.this$0).Jy(this.val$index + 1);
      }
      if ((str2 != null) && (AppSetting.enableTalkBack))
      {
        MainFragment.a(this.this$0, MainFragment.aOe, str2);
        MainFragment.a(this.this$0, MainFragment.aOf, str2);
        MainFragment.a(this.this$0, MainFragment.aOg, str2);
        MainFragment.a(this.this$0, "NOW", str2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MainFragment.6
 * JD-Core Version:    0.7.0.1
 */