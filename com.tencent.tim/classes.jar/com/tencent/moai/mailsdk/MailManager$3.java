package com.tencent.moai.mailsdk;

import com.tencent.moai.mailsdk.callback.SendMailCallBack;
import com.tencent.moai.mailsdk.exception.ProtocolNotSupportError;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.protocol.ActiveSyncProtocolManager;
import com.tencent.moai.mailsdk.protocol.ExchangeProtocolManager;
import com.tencent.moai.mailsdk.protocol.SMTPProtocolManager;

class MailManager$3
  implements Runnable
{
  MailManager$3(MailManager paramMailManager, Profile paramProfile, Mail paramMail, SendMailCallBack paramSendMailCallBack) {}
  
  public void run()
  {
    int i = this.val$profile.getProtocol();
    if (i == 2)
    {
      SMTPProtocolManager.getInstance().sendMail(this.val$profile, this.val$mail, this.val$sendMailCallBack);
      return;
    }
    if (i == 3)
    {
      SMTPProtocolManager.getInstance().sendMail(this.val$profile, this.val$mail, this.val$sendMailCallBack);
      return;
    }
    if (i == 4)
    {
      ActiveSyncProtocolManager.getInstance().sendMail(this.val$profile, this.val$mail, this.val$sendMailCallBack);
      return;
    }
    if (i == 5)
    {
      ExchangeProtocolManager.getInstance().sendMail(this.val$profile, this.val$mail, this.val$sendMailCallBack);
      return;
    }
    throw new ProtocolNotSupportError("sendMail protocol error " + this.val$profile.getProtocol());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager.3
 * JD-Core Version:    0.7.0.1
 */