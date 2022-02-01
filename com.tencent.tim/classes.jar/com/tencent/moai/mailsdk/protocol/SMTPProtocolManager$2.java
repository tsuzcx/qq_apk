package com.tencent.moai.mailsdk.protocol;

import android.util.Log;
import com.tencent.moai.mailsdk.callback.SendMailCallBack;
import com.tencent.moai.mailsdk.callback.TaskCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.util.log.Logger;

class SMTPProtocolManager$2
  implements TaskCallBack
{
  SMTPProtocolManager$2(SMTPProtocolManager paramSMTPProtocolManager, Profile paramProfile, SendMailCallBack paramSendMailCallBack) {}
  
  public void onError(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof MessageException))
    {
      paramThrowable = (MessageException)paramThrowable;
      Logger.log(6, "SMTPProtocolManager", "send mail error:" + paramThrowable.getResultCode() + ":" + paramThrowable.getDetailCode() + ":" + paramThrowable.getDetailMessage());
      Logger.log(6, "SMTPProtocolManager", Log.getStackTraceString(paramThrowable));
      if (SMTPProtocolManager.access$000(this.this$0, paramThrowable)) {
        SMTPProtocolManager.access$100(this.this$0, this.val$profile, paramThrowable);
      }
      if (this.val$sendMailCallBack != null) {
        this.val$sendMailCallBack.onError(paramThrowable.getResultCode(), paramThrowable.getDetailCode(), paramThrowable.getDetailMessage());
      }
    }
    do
    {
      return;
      Logger.log(6, "SMTPProtocolManager", Log.getStackTraceString(paramThrowable));
    } while (this.val$sendMailCallBack == null);
    this.val$sendMailCallBack.onError(1, 200001, paramThrowable.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.SMTPProtocolManager.2
 * JD-Core Version:    0.7.0.1
 */