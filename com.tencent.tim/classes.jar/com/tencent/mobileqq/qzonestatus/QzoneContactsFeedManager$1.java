package com.tencent.mobileqq.qzonestatus;

import alsb;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QzoneContactsFeedManager$1
  implements Runnable
{
  public QzoneContactsFeedManager$1(alsb paramalsb) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "updateQzoneFeeds:" + alsb.a(this.this$0).getCurrentAccountUin());
    }
    Object localObject = alsb.a(this.this$0);
    long l2 = ((SharedPreferences)localObject).getLong("last_click_time", 0L);
    long l1 = System.currentTimeMillis();
    l2 = l1 - l2;
    if (l2 < alsb.access$200()) {
      return;
    }
    long l3 = this.this$0.gF();
    if ((l3 <= 0L) || (l2 >= alsb.access$300())) {
      this.this$0.acz();
    }
    for (;;)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("last_click_time", l1);
      if (Build.VERSION.SDK_INT >= 9) {
        break;
      }
      ((SharedPreferences.Editor)localObject).commit();
      return;
      this.this$0.aD(l3, this.this$0.yv());
    }
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager.1
 * JD-Core Version:    0.7.0.1
 */