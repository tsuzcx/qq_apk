package com.tencent.moai.mailsdk;

import com.tencent.moai.mailsdk.callback.MailOperationCallback;
import com.tencent.moai.mailsdk.exception.ProtocolNotSupportError;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.protocol.ActiveSyncProtocolManager;
import com.tencent.moai.mailsdk.protocol.ExchangeProtocolManager;
import com.tencent.moai.mailsdk.protocol.IMAPProtocolManager;

class MailManager$16
  implements Runnable
{
  MailManager$16(MailManager paramMailManager, Profile paramProfile, Folder paramFolder1, Folder paramFolder2, Mail[] paramArrayOfMail, MailOperationCallback paramMailOperationCallback) {}
  
  public void run()
  {
    int i = this.val$profile.getProtocol();
    if (i == 2)
    {
      IMAPProtocolManager.getInstance().moveMail(this.val$profile, this.val$sourceFolder, this.val$destFolder, this.val$mails, this.val$mailOperationCallback);
      return;
    }
    if (i == 4)
    {
      ActiveSyncProtocolManager.getInstance().moveMail(this.val$profile, this.val$sourceFolder, this.val$destFolder, this.val$mails, this.val$mailOperationCallback);
      return;
    }
    if (i == 5)
    {
      ExchangeProtocolManager.getInstance().moveMail(this.val$profile, this.val$sourceFolder, this.val$destFolder, this.val$mails, this.val$mailOperationCallback);
      return;
    }
    throw new ProtocolNotSupportError("moveMail protocol error " + this.val$profile.getProtocol());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager.16
 * JD-Core Version:    0.7.0.1
 */