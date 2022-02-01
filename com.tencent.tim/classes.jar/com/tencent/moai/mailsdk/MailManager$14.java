package com.tencent.moai.mailsdk;

import com.tencent.moai.mailsdk.callback.AttachmentCallBack;
import com.tencent.moai.mailsdk.protocol.IMAPProtocolManager;

class MailManager$14
  implements Runnable
{
  MailManager$14(MailManager paramMailManager, String paramString1, String paramString2, String paramString3, AttachmentCallBack paramAttachmentCallBack) {}
  
  public void run()
  {
    IMAPProtocolManager.getInstance().transformTmpAttach(this.val$tmpFilePath, this.val$destFilePath, this.val$encoding, this.val$attachmentCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager.14
 * JD-Core Version:    0.7.0.1
 */