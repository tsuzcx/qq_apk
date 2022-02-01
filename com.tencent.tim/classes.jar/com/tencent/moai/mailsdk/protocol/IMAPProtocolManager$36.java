package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.callback.MailOperationCallback;
import com.tencent.moai.mailsdk.callback.TaskCallBack;

class IMAPProtocolManager$36
  implements TaskCallBack
{
  IMAPProtocolManager$36(IMAPProtocolManager paramIMAPProtocolManager, MailOperationCallback paramMailOperationCallback) {}
  
  public void onError(Throwable paramThrowable)
  {
    if (this.val$callback != null) {
      this.val$callback.onMailOperationError(1, 200001, paramThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.36
 * JD-Core Version:    0.7.0.1
 */