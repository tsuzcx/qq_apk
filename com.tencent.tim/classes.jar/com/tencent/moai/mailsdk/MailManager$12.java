package com.tencent.moai.mailsdk;

import com.tencent.moai.mailsdk.callback.MailAbstractCallBack;
import com.tencent.moai.mailsdk.exception.ProtocolNotSupportError;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.protocol.ActiveSyncProtocolManager;
import com.tencent.moai.mailsdk.protocol.ExchangeProtocolManager;
import com.tencent.moai.mailsdk.protocol.IMAPProtocolManager;
import com.tencent.moai.mailsdk.protocol.POP3ProtocolManager;

class MailManager$12
  implements Runnable
{
  MailManager$12(MailManager paramMailManager, Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, MailAbstractCallBack paramMailAbstractCallBack) {}
  
  public void run()
  {
    int i = this.val$profile.getProtocol();
    if (i == 2)
    {
      IMAPProtocolManager.getInstance().downloadMailsAbstract(this.val$profile, this.val$folder, this.val$mails, this.val$mailAbstractCallBack);
      return;
    }
    if (i == 3)
    {
      POP3ProtocolManager.getInstance().downloadMailsAbstract(this.val$profile, this.val$folder, this.val$mails, this.val$mailAbstractCallBack);
      return;
    }
    if (i == 4)
    {
      ActiveSyncProtocolManager.getInstance().downloadMailsAbstract(this.val$profile, this.val$folder, this.val$mails, this.val$mailAbstractCallBack);
      return;
    }
    if (i == 5)
    {
      ExchangeProtocolManager.getInstance().downloadMailsAbstract(this.val$profile, this.val$folder, this.val$mails, this.val$mailAbstractCallBack);
      return;
    }
    throw new ProtocolNotSupportError("downloadMailsAbstract protocol error " + this.val$profile.getProtocol());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager.12
 * JD-Core Version:    0.7.0.1
 */