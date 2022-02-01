package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.MailParser;
import com.tencent.moai.mailsdk.callback.SendMailCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeMessage;
import com.tencent.moai.mailsdk.protocol.smtp.SMTPHandler;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;
import com.tencent.moai.mailsdk.util.log.Logger;

class SMTPProtocolManager$1
  extends BaseTask
{
  SMTPProtocolManager$1(SMTPProtocolManager paramSMTPProtocolManager, String paramString, Mail paramMail, SendMailCallBack paramSendMailCallBack)
  {
    super(paramString);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    MimeMessage localMimeMessage = MailParser.createMessage(this.val$mail);
    Logger.log(4, "SMTPProtocolManager", "send mail before:" + this.val$mail.getSubject());
    if (this.val$sendMailCallBack != null) {
      this.val$sendMailCallBack.onSendBefore(this.val$mail);
    }
    ((SMTPHandler)paramHandler).sendMessage(localMimeMessage, new SMTPProtocolManager.1.1(this, localMimeMessage));
    Logger.log(4, "SMTPProtocolManager", "send mail success:" + this.val$mail.getSubject());
    if (this.val$sendMailCallBack != null) {
      this.val$sendMailCallBack.onSendSuccess(this.val$mail);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.SMTPProtocolManager.1
 * JD-Core Version:    0.7.0.1
 */