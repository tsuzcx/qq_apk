package com.tencent.mobileqq.activity.recent;

import anot;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import jxc;
import jxe;
import jxp;

public final class RecentUtil$7
  implements Runnable
{
  public RecentUtil$7(QQAppInterface paramQQAppInterface, String paramString, int paramInt, jxc paramjxc) {}
  
  public void run()
  {
    QQMessageFacade.Message localMessage = null;
    QQMessageFacade localQQMessageFacade = this.val$app.b();
    if (localQQMessageFacade != null) {
      localMessage = localQQMessageFacade.a(this.val$uin, this.val$type);
    }
    if (localMessage != null)
    {
      if ("false".equals(localMessage.getExtInfoFromExtStr("recent_list_advertisement_message_first_click")))
      {
        localMessage.saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "true");
        this.val$app.b().a(localMessage.frienduin, localMessage.msgtype, localMessage.uniseq, "extStr", localMessage.extStr);
        if (this.b.a != null) {
          anot.c(this.val$app, "dc00898", "", this.b.a.UD, "0X8008F5E", "0X8008F5E", 0, 0, this.b.a.hT, "", jxp.gP(), this.b.a.mNickName);
        }
      }
      if (this.b.a != null) {
        anot.c(this.val$app, "dc00898", "", this.b.a.UD, "0X8008F60", "0X8008F60", 0, 0, this.b.a.hT, "", "", this.b.a.mNickName);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentUtil.7
 * JD-Core Version:    0.7.0.1
 */