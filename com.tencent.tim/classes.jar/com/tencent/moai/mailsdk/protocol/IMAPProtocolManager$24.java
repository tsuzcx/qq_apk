package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.callback.AttachmentCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Attachment;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.protocol.imap.IMAPHandler;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;

class IMAPProtocolManager$24
  extends BaseTask
{
  IMAPProtocolManager$24(IMAPProtocolManager paramIMAPProtocolManager, String paramString, Folder paramFolder, AttachmentCallBack paramAttachmentCallBack, Mail paramMail, Attachment paramAttachment)
  {
    super(paramString);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    paramHandler = (IMAPHandler)paramHandler;
    if (paramHandler.select(this.val$folder.getPath()) == null)
    {
      if (this.val$attachmentCallBack != null) {
        this.val$attachmentCallBack.onError(1, 200001, "select error");
      }
      return;
    }
    paramHandler.fetchMailAttach(this.val$mail.getRemoteId(), this.val$attachment.getImapBodyStructure(), this.val$attachment.getPath(), new IMAPProtocolManager.24.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.24
 * JD-Core Version:    0.7.0.1
 */