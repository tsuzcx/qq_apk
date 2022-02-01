package com.tencent.moai.mailsdk.protocol;

import android.util.Log;
import com.tencent.moai.mailsdk.callback.MailCallBack;
import com.tencent.moai.mailsdk.callback.TaskCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.util.log.Logger;

class IMAPProtocolManager$21
  implements TaskCallBack
{
  IMAPProtocolManager$21(IMAPProtocolManager paramIMAPProtocolManager, Profile paramProfile, MailCallBack paramMailCallBack) {}
  
  public void onError(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof MessageException))
    {
      paramThrowable = (MessageException)paramThrowable;
      Logger.log(6, "IMAPProtocolManager", "download mail text error:" + paramThrowable.getResultCode() + ":" + paramThrowable.getDetailCode() + ":" + paramThrowable.getDetailMessage());
      Logger.log(6, "IMAPProtocolManager", Log.getStackTraceString(paramThrowable));
      if (IMAPProtocolManager.access$000(this.this$0, paramThrowable)) {
        IMAPProtocolManager.access$100(this.this$0, this.val$profile, paramThrowable);
      }
      if (this.val$mailCallBack != null) {
        this.val$mailCallBack.onRetrieveMailError(paramThrowable.getResultCode(), paramThrowable.getDetailCode(), paramThrowable.getDetailMessage());
      }
    }
    do
    {
      return;
      Logger.log(6, "IMAPProtocolManager", Log.getStackTraceString(paramThrowable));
    } while (this.val$mailCallBack == null);
    this.val$mailCallBack.onRetrieveMailError(1, 200001, paramThrowable.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.21
 * JD-Core Version:    0.7.0.1
 */