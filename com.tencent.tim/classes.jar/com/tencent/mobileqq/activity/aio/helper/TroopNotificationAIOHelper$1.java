package com.tencent.mobileqq.activity.aio.helper;

import aptq;
import aptr;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import wxj;

public class TroopNotificationAIOHelper$1
  implements Runnable
{
  public TroopNotificationAIOHelper$1(wxj paramwxj) {}
  
  public void run()
  {
    if (wxj.a(this.this$0) == null) {}
    aptq localaptq;
    do
    {
      do
      {
        return;
      } while (wxj.a(this.this$0).app == null);
      localaptq = aptr.a(wxj.a(this.this$0).app, wxj.a(this.this$0).oL());
    } while ((localaptq == null) || (localaptq.dVP != 0));
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationAIOHelper", 2, "handleTroopNotificationOnResume, readTroopNotification.");
    }
    aptr.aZ(wxj.a(this.this$0).app, wxj.a(this.this$0).oL());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.1
 * JD-Core Version:    0.7.0.1
 */