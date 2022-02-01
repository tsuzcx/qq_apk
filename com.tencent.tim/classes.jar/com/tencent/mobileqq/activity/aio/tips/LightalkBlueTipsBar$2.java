package com.tencent.mobileqq.activity.aio.tips;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import yir;

public class LightalkBlueTipsBar$2
  implements Runnable
{
  public LightalkBlueTipsBar$2(yir paramyir) {}
  
  public void run()
  {
    Object localObject = yir.a(this.this$0).getPreferences();
    int i = ((SharedPreferences)localObject).getInt("LT_tip_show_times" + yir.a(this.this$0).getCurrentAccountUin(), 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("LT_tip_show_times" + yir.a(this.this$0).getCurrentAccountUin(), i + 1);
    ((SharedPreferences.Editor)localObject).commit();
    if (QLog.isColorLevel()) {
      QLog.d("LightalkBlueTipsBar", 2, "onAIOEvent() : commit =====> tipsum = " + (i + 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar.2
 * JD-Core Version:    0.7.0.1
 */