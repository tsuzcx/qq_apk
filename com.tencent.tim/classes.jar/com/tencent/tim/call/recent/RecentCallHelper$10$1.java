package com.tencent.tim.call.recent;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqmj;
import atdh;
import atdj;
import com.tencent.mobileqq.app.QQAppInterface;

public class RecentCallHelper$10$1
  implements Runnable
{
  public RecentCallHelper$10$1(atdj paramatdj) {}
  
  public void run()
  {
    if (this.a.this$0.x != null) {
      aqmj.l(this.a.this$0.x.getCurrentAccountUin()).edit().putInt("show_tab_lightalk_tips", 4).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.call.recent.RecentCallHelper.10.1
 * JD-Core Version:    0.7.0.1
 */