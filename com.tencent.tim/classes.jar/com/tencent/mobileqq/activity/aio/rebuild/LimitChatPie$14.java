package com.tencent.mobileqq.activity.aio.rebuild;

import afsi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import ybb;

public class LimitChatPie$14
  implements Runnable
{
  public LimitChatPie$14(ybb paramybb) {}
  
  public void run()
  {
    afsi localafsi;
    if (this.this$0.app != null)
    {
      localafsi = (afsi)this.this$0.app.getManager(264);
      if (localafsi != null) {
        break label45;
      }
      QLog.e(this.this$0.TAG, 2, "saveExtendFriendInfoInSubThread  extendFriendManager Is null");
    }
    label45:
    while (ybb.a(this.this$0) == null) {
      return;
    }
    localafsi.a(ybb.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.14
 * JD-Core Version:    0.7.0.1
 */