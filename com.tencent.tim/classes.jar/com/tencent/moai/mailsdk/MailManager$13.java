package com.tencent.moai.mailsdk;

import com.tencent.moai.mailsdk.callback.AttachmentCallBack;
import com.tencent.moai.mailsdk.exception.ProtocolNotSupportError;
import com.tencent.moai.mailsdk.model.Attachment;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.protocol.ActiveSyncProtocolManager;
import com.tencent.moai.mailsdk.protocol.ExchangeProtocolManager;
import com.tencent.moai.mailsdk.protocol.IMAPProtocolManager;

class MailManager$13
  implements Runnable
{
  MailManager$13(MailManager paramMailManager, Profile paramProfile, Folder paramFolder, Mail paramMail, Attachment paramAttachment, AttachmentCallBack paramAttachmentCallBack) {}
  
  public void run()
  {
    int i = this.val$profile.getProtocol();
    if (i == 2)
    {
      IMAPProtocolManager.getInstance().downloadAttachment(this.val$profile, this.val$folder, this.val$mail, this.val$attachment, this.val$attachmentCallBack);
      return;
    }
    if (i == 4)
    {
      ActiveSyncProtocolManager.getInstance().downloadAttachment(this.val$profile, this.val$folder, this.val$mail, this.val$attachment, this.val$attachmentCallBack);
      return;
    }
    if (i == 5)
    {
      ExchangeProtocolManager.getInstance().downloadAttachment(this.val$profile, this.val$folder, this.val$mail, this.val$attachment, this.val$attachmentCallBack);
      return;
    }
    throw new ProtocolNotSupportError("downloadAttachment protocol error " + this.val$profile.getProtocol());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager.13
 * JD-Core Version:    0.7.0.1
 */