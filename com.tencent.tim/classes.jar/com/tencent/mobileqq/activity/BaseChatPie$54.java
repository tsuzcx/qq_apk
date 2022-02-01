package com.tencent.mobileqq.activity;

import anfe;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$54
  implements Runnable
{
  BaseChatPie$54(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (!BaseChatPie.aTb)
    {
      anfe.akI = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_CLICK_CAMERA ", Long.valueOf(anfe.akI) });
      this.this$0.bID();
      BaseChatPie.aTb = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.54
 * JD-Core Version:    0.7.0.1
 */