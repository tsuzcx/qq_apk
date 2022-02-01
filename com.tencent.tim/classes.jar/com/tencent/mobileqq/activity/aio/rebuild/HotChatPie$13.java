package com.tencent.mobileqq.activity.aio.rebuild;

import acms;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import yam;

public class HotChatPie$13
  implements Runnable
{
  public HotChatPie$13(yam paramyam) {}
  
  public void run()
  {
    acms localacms = (acms)this.this$0.app.getBusinessHandler(20);
    if (localacms != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG + "Q.hotchat.aio_post_red_point", 2, "send_oidb_0x8c9_2");
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(1105933138L));
      localacms.d(this.this$0.sessionInfo.aTl, localArrayList, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.13
 * JD-Core Version:    0.7.0.1
 */