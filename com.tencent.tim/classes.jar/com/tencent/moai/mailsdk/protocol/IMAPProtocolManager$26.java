package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.callback.AttachmentCallBack;
import com.tencent.moai.mailsdk.protocol.mime.AttachListener;

class IMAPProtocolManager$26
  implements AttachListener
{
  IMAPProtocolManager$26(IMAPProtocolManager paramIMAPProtocolManager, AttachmentCallBack paramAttachmentCallBack, String paramString) {}
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    if (this.val$attachmentCallBack != null) {
      this.val$attachmentCallBack.onError(paramInt1, paramInt2, paramString);
    }
  }
  
  public void onFinish() {}
  
  public boolean onProgress(long paramLong)
  {
    boolean bool = false;
    if (this.val$attachmentCallBack != null) {
      bool = this.val$attachmentCallBack.onProgress(paramLong);
    }
    return bool;
  }
  
  public void onSuccess(String paramString)
  {
    if (this.val$attachmentCallBack != null) {
      this.val$attachmentCallBack.onSuccess(this.val$destFilePath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.26
 * JD-Core Version:    0.7.0.1
 */