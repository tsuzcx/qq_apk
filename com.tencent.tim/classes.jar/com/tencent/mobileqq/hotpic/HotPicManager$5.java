package com.tencent.mobileqq.hotpic;

import ahzd;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

public class HotPicManager$5
  implements Runnable
{
  public HotPicManager$5(ahzd paramahzd, int paramInt) {}
  
  public void run()
  {
    this.this$0.mApp.getApplication().getSharedPreferences("sp_hotpic_" + this.this$0.mApp.getCurrentUin(), 0).edit().putInt("hot_pic_last_click", this.dcA).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicManager.5
 * JD-Core Version:    0.7.0.1
 */