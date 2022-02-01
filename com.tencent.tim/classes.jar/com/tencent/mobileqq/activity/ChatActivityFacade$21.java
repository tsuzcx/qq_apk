package com.tencent.mobileqq.activity;

import ajkw;
import anbi;
import aooi;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public final class ChatActivityFacade$21
  implements Runnable
{
  public ChatActivityFacade$21(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, long paramLong) {}
  
  public void run()
  {
    try
    {
      MessageRecord localMessageRecord = this.val$app.b().a(this.a.aTl, this.a.cZ, this.rJ);
      if ((localMessageRecord != null) && (localMessageRecord.isSendFromLocal())) {
        this.val$app.a().oy(this.val$app.a().y(localMessageRecord.frienduin, localMessageRecord.uniseq));
      }
      this.val$app.b().t(this.a.aTl, this.a.cZ, this.rJ);
      localMessageRecord = anbi.e(localMessageRecord);
      if ((localMessageRecord != null) && (localMessageRecord.msgtype == -1051))
      {
        ajkw localajkw = (ajkw)this.val$app.getManager(166);
        localMessageRecord.extStr = null;
        localajkw.b(this.val$app, localMessageRecord, true);
        return;
      }
      this.val$app.b().a(localMessageRecord, null, true);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("ChatActivityFacade", 1, "resendTextMessage error :", localRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.21
 * JD-Core Version:    0.7.0.1
 */