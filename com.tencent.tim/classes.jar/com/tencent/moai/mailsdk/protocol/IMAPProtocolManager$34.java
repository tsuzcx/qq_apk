package com.tencent.moai.mailsdk.protocol;

import android.util.Log;
import com.tencent.moai.mailsdk.callback.MailOperationCallback;
import com.tencent.moai.mailsdk.callback.TaskCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.util.log.Logger;

class IMAPProtocolManager$34
  implements TaskCallBack
{
  IMAPProtocolManager$34(IMAPProtocolManager paramIMAPProtocolManager, Mail paramMail, Profile paramProfile, MailOperationCallback paramMailOperationCallback) {}
  
  public void onError(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof MessageException))
    {
      paramThrowable = (MessageException)paramThrowable;
      Logger.log(4, "IMAPProtocolManager", "append fail:" + this.val$mail.getId() + "\n" + Log.getStackTraceString(paramThrowable));
      Logger.log(6, "IMAPProtocolManager", Log.getStackTraceString(paramThrowable));
      if (IMAPProtocolManager.access$000(this.this$0, paramThrowable)) {
        IMAPProtocolManager.access$100(this.this$0, this.val$profile, paramThrowable);
      }
      if (this.val$callback != null) {
        this.val$callback.onMailOperationError(paramThrowable.getResultCode(), paramThrowable.getDetailCode(), paramThrowable.getDetailMessage());
      }
    }
    do
    {
      return;
      Logger.log(6, "IMAPProtocolManager", Log.getStackTraceString(paramThrowable));
    } while (this.val$callback == null);
    this.val$callback.onMailOperationError(1, 200001, paramThrowable.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.34
 * JD-Core Version:    0.7.0.1
 */