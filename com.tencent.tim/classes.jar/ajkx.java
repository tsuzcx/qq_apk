import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class ajkx
  implements akyf
{
  ajkx(ajkw paramajkw, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(akyf.a parama) {}
  
  public void b(akyf.a parama)
  {
    try
    {
      if (parama.result == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "step3: sendLongTextMsg pack upload cost: " + (System.currentTimeMillis() - ajkw.a(this.b)) + ",mResid:" + parama.uuid);
        }
        AbsShareMsg localAbsShareMsg = ujt.a(this.val$app.getApp().getApplicationContext(), this.a, this.val$app.getCurrentNickname());
        localAbsShareMsg.mResid = parama.uuid;
        localAbsShareMsg.mFileName = String.valueOf(this.a.uniseq);
        localAbsShareMsg.multiMsgFlag = 1;
        MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)anbi.d(-1051);
        localMessageForLongTextMsg.structingMsg = localAbsShareMsg;
        localMessageForLongTextMsg.frienduin = this.a.frienduin;
        localMessageForLongTextMsg.istroop = this.a.istroop;
        localMessageForLongTextMsg.selfuin = this.a.selfuin;
        localMessageForLongTextMsg.senderuin = this.a.senderuin;
        localMessageForLongTextMsg.isread = this.a.isread;
        localMessageForLongTextMsg.time = this.a.time;
        localMessageForLongTextMsg.msgseq = this.a.msgseq;
        localMessageForLongTextMsg.msgUid = this.a.msgUid;
        localMessageForLongTextMsg.shmsgseq = this.a.shmsgseq;
        localMessageForLongTextMsg.issend = this.a.issend;
        localMessageForLongTextMsg.uniseq = this.a.uniseq;
        localMessageForLongTextMsg.mAnimFlag = true;
        localMessageForLongTextMsg.longMsgCount = 1;
        localMessageForLongTextMsg.longMsgIndex = 0;
        localMessageForLongTextMsg.longMsgId = ((short)(int)this.a.shmsgseq);
        localMessageForLongTextMsg.saveExtInfoToExtStr("long_text_msg_resid", parama.uuid);
        if (jof.a(this.a)) {
          jof.a().a(localMessageForLongTextMsg);
        }
        this.val$app.b().b(localMessageForLongTextMsg, null, this.awD);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "MessageForReplyText upload multi msg pack failed, result.errStr=" + parama.errCode + ",result.errStr=" + parama.errStr);
      }
      ajkw.i(this.val$app, this.a);
      return;
    }
    catch (Exception parama)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "MessageForReplyText upload multi msg pack failed, catch exception", parama);
      }
      ajkw.i(this.val$app, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajkx
 * JD-Core Version:    0.7.0.1
 */