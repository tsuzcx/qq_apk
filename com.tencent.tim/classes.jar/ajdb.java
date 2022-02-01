import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class ajdb
  implements akyf
{
  MessageForLongTextMsg a;
  
  ajdb(ajcy paramajcy, QQAppInterface paramQQAppInterface, MessageForMixedMsg paramMessageForMixedMsg, achq paramachq) {}
  
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
          QLog.d("MixedMsgManager", 2, "step3: sendLongTextMsg pack upload cost: " + (System.currentTimeMillis() - ajcy.a(this.this$0)) + ",mResid:" + parama.uuid);
        }
        AbsShareMsg localAbsShareMsg = ujt.a(this.val$app.getApp().getApplicationContext(), this.d, this.val$app.getCurrentNickname());
        localAbsShareMsg.mResid = parama.uuid;
        localAbsShareMsg.mFileName = String.valueOf(this.d.uniseq);
        localAbsShareMsg.multiMsgFlag = 1;
        this.a = ((MessageForLongTextMsg)anbi.d(-1051));
        this.a.structingMsg = localAbsShareMsg;
        this.a.frienduin = this.d.frienduin;
        this.a.istroop = this.d.istroop;
        this.a.selfuin = this.d.selfuin;
        this.a.senderuin = this.d.senderuin;
        this.a.isread = this.d.isread;
        this.a.time = this.d.time;
        this.a.msgseq = this.d.msgseq;
        this.a.msgUid = this.d.msgUid;
        this.a.shmsgseq = this.d.shmsgseq;
        this.a.issend = this.d.issend;
        this.a.uniseq = this.d.uniseq;
        this.a.mAnimFlag = true;
        this.a.longMsgCount = 1;
        this.a.longMsgIndex = 0;
        this.a.longMsgId = ((short)(int)this.d.shmsgseq);
        this.a.saveExtInfoToExtStr("long_text_msg_resid", parama.uuid);
        jof.a().a(this.a);
        ((ambj)this.val$app.getManager(326)).d(this.a, this.i);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "upload multi msg pack failed, result.errStr=" + parama.errCode + ",result.errStr=" + parama.errStr);
      }
      ajcy.a(this.this$0, this.d, true, "upload longMsg pack fail: errCode = " + parama.errCode);
      return;
    }
    catch (Exception parama)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "upload multi msg pack failed, catch exception", parama);
      }
      ajcy.a(this.this$0, this.d, true, "sendStructLongMsg fail: exception" + parama.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajdb
 * JD-Core Version:    0.7.0.1
 */