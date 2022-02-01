import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

final class ujw
  implements akyf
{
  ujw(MessageForArkApp paramMessageForArkApp, QQAppInterface paramQQAppInterface) {}
  
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
        this.a.resIDForLongMsg = parama.uuid;
        this.val$app.b().b(this.a, null, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "upload multi msg pack failed, result.errStr=" + parama.errCode + ",result.errStr=" + parama.errStr);
      }
      ajkw.i(this.val$app, this.a);
      return;
    }
    catch (Exception parama)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "upload multi msg pack failed, catch exception", parama);
      }
      ajkw.i(this.val$app, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ujw
 * JD-Core Version:    0.7.0.1
 */