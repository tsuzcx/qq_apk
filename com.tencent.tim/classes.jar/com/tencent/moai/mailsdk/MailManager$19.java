package com.tencent.moai.mailsdk;

import com.tencent.moai.mailsdk.callback.MailOperationCallback;
import com.tencent.moai.mailsdk.exception.ProtocolNotSupportError;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.protocol.IMAPProtocolManager;

class MailManager$19
  implements Runnable
{
  MailManager$19(MailManager paramMailManager, Profile paramProfile, String paramString, Mail paramMail, MailOperationCallback paramMailOperationCallback) {}
  
  public void run()
  {
    if (this.val$profile.getProtocol() == 2)
    {
      IMAPProtocolManager.getInstance().append(this.val$profile, this.val$folderId, this.val$mail, this.val$mailOperationCallback);
      return;
    }
    throw new ProtocolNotSupportError("appendMailToServer protocol error " + this.val$profile.getProtocol());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager.19
 * JD-Core Version:    0.7.0.1
 */