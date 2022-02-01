package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.callback.AttachmentCallBack;
import com.tencent.moai.mailsdk.model.Attachment;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPBodyStructure;
import com.tencent.moai.mailsdk.protocol.mime.AttachListener;
import com.tencent.moai.mailsdk.util.log.Logger;

class IMAPProtocolManager$24$1
  implements AttachListener
{
  IMAPProtocolManager$24$1(IMAPProtocolManager.24 param24) {}
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    Logger.log(4, "IMAPProtocolManager", "download attachment error:" + paramInt1 + ":" + paramInt2 + ":" + paramString);
    if (this.this$1.val$attachmentCallBack != null) {
      this.this$1.val$attachmentCallBack.onError(paramInt1, paramInt2, paramString);
    }
  }
  
  public void onFinish()
  {
    Logger.log(4, "IMAPProtocolManager", "download attachment finish:" + this.this$1.val$mail.getRemoteId() + "." + this.this$1.val$attachment.getImapBodyStructure().getBodyId());
  }
  
  public boolean onProgress(long paramLong)
  {
    boolean bool = false;
    if (this.this$1.val$attachmentCallBack != null) {
      bool = this.this$1.val$attachmentCallBack.onProgress(paramLong);
    }
    return bool;
  }
  
  public void onSuccess(String paramString)
  {
    Logger.log(4, "IMAPProtocolManager", "download attachment success path:" + paramString);
    if (this.this$1.val$attachmentCallBack != null) {
      this.this$1.val$attachmentCallBack.onSuccess(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.24.1
 * JD-Core Version:    0.7.0.1
 */