package com.tencent.mobileqq.activity;

import anbi;
import anre;
import aooi;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;

public final class ChatActivityFacade$22
  implements Runnable
{
  public ChatActivityFacade$22(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong) {}
  
  public void run()
  {
    try
    {
      if (this.a.isSendFromLocal()) {
        this.val$app.a().oy(this.val$app.a().y(this.a.frienduin, this.a.uniseq));
      }
      AbsStructMsg localAbsStructMsg = anre.a(this.a.msgData);
      this.val$app.b().t(this.SO, this.bET, this.rJ);
      if ((localAbsStructMsg instanceof StructMsgForImageShare))
      {
        StructMsgForImageShare.resendAndUploadImageShare(this.val$app, this.a, (StructMsgForImageShare)localAbsStructMsg);
        return;
      }
      if (((localAbsStructMsg instanceof AbsShareMsg)) && (ForwardUtils.au(((AbsShareMsg)localAbsStructMsg).forwardType, localAbsStructMsg.mMsgServiceID)))
      {
        AbsShareMsg.resendSdkShareMessage(this.val$app, this.a, (AbsShareMsg)localAbsStructMsg);
        return;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("ChatActivityFacade", 1, "resendStructMessage error :", localRuntimeException);
      throw localRuntimeException;
    }
    MessageRecord localMessageRecord = anbi.e(this.a);
    this.val$app.b().a(localMessageRecord, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.22
 * JD-Core Version:    0.7.0.1
 */