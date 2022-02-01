package com.tencent.moai.mailsdk;

import com.tencent.moai.mailsdk.callback.MailCallBack;
import com.tencent.moai.mailsdk.exception.ProtocolNotSupportError;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.protocol.ActiveSyncProtocolManager;
import com.tencent.moai.mailsdk.protocol.ExchangeProtocolManager;
import com.tencent.moai.mailsdk.protocol.IMAPProtocolManager;
import com.tencent.moai.mailsdk.protocol.POP3ProtocolManager;

class MailManager$11
  implements Runnable
{
  MailManager$11(MailManager paramMailManager, Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, boolean paramBoolean1, MailCallBack paramMailCallBack, boolean paramBoolean2) {}
  
  public void run()
  {
    int i = this.val$profile.getProtocol();
    if (i == 2)
    {
      IMAPProtocolManager.getInstance().downloadMailsText(this.val$profile, this.val$folder, this.val$mails, this.val$forceLoadAll, this.val$mailCallBack);
      return;
    }
    if (i == 3)
    {
      POP3ProtocolManager.getInstance().downloadMailsText(this.val$profile, this.val$folder, this.val$mails, this.val$forceLoadAll, this.val$mailCallBack);
      return;
    }
    if (i == 4)
    {
      ActiveSyncProtocolManager.getInstance().downloadMailsText(this.val$profile, this.val$folder, this.val$mails, this.val$forceLoadAll, this.val$isSearchMail, this.val$mailCallBack);
      return;
    }
    if (i == 5)
    {
      ExchangeProtocolManager.getInstance().downloadMailsText(this.val$profile, this.val$folder, this.val$mails, this.val$forceLoadAll, this.val$mailCallBack);
      return;
    }
    throw new ProtocolNotSupportError("downloadMailsText protocol error " + this.val$profile.getProtocol());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager.11
 * JD-Core Version:    0.7.0.1
 */