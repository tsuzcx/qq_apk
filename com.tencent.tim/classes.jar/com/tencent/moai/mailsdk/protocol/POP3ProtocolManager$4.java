package com.tencent.moai.mailsdk.protocol;

import android.util.Log;
import com.tencent.moai.mailsdk.callback.MailCallBack;
import com.tencent.moai.mailsdk.callback.TaskCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.task.TaskPool;
import com.tencent.moai.mailsdk.util.StringUtility;
import com.tencent.moai.mailsdk.util.log.Logger;

class POP3ProtocolManager$4
  implements TaskCallBack
{
  POP3ProtocolManager$4(POP3ProtocolManager paramPOP3ProtocolManager, Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, boolean paramBoolean, MailCallBack paramMailCallBack) {}
  
  public void onError(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof MessageException))
    {
      paramThrowable = (MessageException)paramThrowable;
      Logger.log(6, "POP3ProtocolManager", "download mail text error:" + paramThrowable.getResultCode() + ":" + paramThrowable.getDetailCode() + ":" + paramThrowable.getDetailMessage());
      Logger.log(6, "POP3ProtocolManager", Log.getStackTraceString(paramThrowable));
      if ((paramThrowable.getResultCode() == 10) && (POP3ProtocolManager.access$700(this.this$0, this.val$profile)))
      {
        Logger.log(6, "POP3ProtocolManager", "lock account to limit thread and downloadMailsText");
        Logger.osslog(new Object[] { "account_lock", StringUtility.getDomain(this.val$profile.getPopName()) });
        paramThrowable = POP3ProtocolManager.access$800(this.this$0, this.val$profile);
        this.this$0.downloadMailsText(this.val$profile, this.val$folder, this.val$mails, this.val$forceLoadAll, this.val$mailCallBack);
        POP3ProtocolManager.access$900(this.this$0, this.val$profile).postRunnableList(paramThrowable);
      }
    }
    do
    {
      do
      {
        return;
        if (paramThrowable.getResultCode() == 4) {
          POP3ProtocolManager.access$1000(this.this$0, this.val$profile, paramThrowable);
        }
      } while (this.val$mailCallBack == null);
      this.val$mailCallBack.onRetrieveMailError(paramThrowable.getResultCode(), paramThrowable.getDetailCode(), paramThrowable.getDetailMessage());
      return;
      Logger.log(6, "POP3ProtocolManager", Log.getStackTraceString(paramThrowable));
    } while (this.val$mailCallBack == null);
    this.val$mailCallBack.onRetrieveMailError(1, 200001, paramThrowable.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.POP3ProtocolManager.4
 * JD-Core Version:    0.7.0.1
 */