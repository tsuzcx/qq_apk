package com.tencent.mobileqq.imaxad;

import aibd;
import aibe;
import anot;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import jxc;
import jxe;
import jxp;

public class ImaxAdRecentUserManager$2
  implements Runnable
{
  public ImaxAdRecentUserManager$2(aibe paramaibe, QQAppInterface paramQQAppInterface, String paramString, int paramInt, jxc paramjxc) {}
  
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
      if (this.b.a != null)
      {
        anot.c(this.val$app, "dc00898", "", this.b.a.UD, "0X8008F60", "0X8008F60", 0, 0, this.b.a.hT, "", "", this.b.a.mNickName);
        if (this.b.a.aEd == 2) {
          aibd.a().e(this.b);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager.2
 * JD-Core Version:    0.7.0.1
 */