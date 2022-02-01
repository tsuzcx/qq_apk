package com.tencent.mobileqq.activity.aio.drawer;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import wsv;

public class IntimateInfoChatDrawer$2
  implements Runnable
{
  public IntimateInfoChatDrawer$2(wsv paramwsv) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.this$0.mApp.getApp().getSharedPreferences("IntimateInfo" + this.this$0.mApp.getCurrentAccountUin(), 0);
    if (localSharedPreferences.getInt("key_aio_score_guide_count", 0) < 3) {
      localSharedPreferences.edit().putInt("key_aio_score_guide_count", 3).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.IntimateInfoChatDrawer.2
 * JD-Core Version:    0.7.0.1
 */