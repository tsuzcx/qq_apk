package com.tencent.tim.call.recent;

import android.os.Message;
import atda;
import atdh;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class RecentCallHelper$12
  implements Runnable
{
  public RecentCallHelper$12(atdh paramatdh, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    Message localMessage = new Message();
    if (atda.a() != null)
    {
      localMessage.what = 2;
      localMessage.obj = Integer.valueOf(this.epn);
    }
    for (;;)
    {
      this.this$0.m.sendMessage(localMessage);
      if (QLog.isColorLevel()) {
        QLog.d("RecentCallHelper", 2, "showLightalkTipsIfNeed show : " + atdh.a(this.this$0) + " num + " + this.epn + " fromResume " + this.dho);
      }
      return;
      if (atdh.a(this.this$0)) {
        localMessage.what = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.call.recent.RecentCallHelper.12
 * JD-Core Version:    0.7.0.1
 */