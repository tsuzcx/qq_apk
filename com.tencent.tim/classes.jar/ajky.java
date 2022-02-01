import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class ajky
  implements akyf
{
  ajky(ajkw paramajkw, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean) {}
  
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
        MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)this.a;
        localMessageForLongTextMsg.structingMsg = localAbsShareMsg;
        localMessageForLongTextMsg.saveExtInfoToExtStr("long_text_msg_resid", parama.uuid);
        this.val$app.b().b(this.a, null, this.awD);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, result.errStr=" + parama.errCode + ",result.errStr=" + parama.errStr);
      }
      ajkw.i(this.val$app, this.a);
      return;
    }
    catch (Exception parama)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, catch exception", parama);
      }
      ajkw.i(this.val$app, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajky
 * JD-Core Version:    0.7.0.1
 */