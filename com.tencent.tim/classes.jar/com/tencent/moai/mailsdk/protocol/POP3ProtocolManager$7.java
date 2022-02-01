package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.callback.MailOperationCallback;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.protocol.pop3.POP3Handler;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.ArrayList;

class POP3ProtocolManager$7
  extends BaseTask
{
  POP3ProtocolManager$7(POP3ProtocolManager paramPOP3ProtocolManager, String paramString, Profile paramProfile, Mail[] paramArrayOfMail, MailOperationCallback paramMailOperationCallback)
  {
    super(paramString);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    paramHandler = (POP3Handler)paramHandler;
    ArrayList localArrayList1 = POP3ProtocolManager.access$1400(this.this$0, this.val$profile);
    Logger.log(4, "POP3ProtocolManager", "delete mail delete uid size:" + localArrayList1.size());
    ArrayList localArrayList2 = paramHandler.uidl();
    Logger.log(4, "POP3ProtocolManager", "delete mail uid size:" + localArrayList2.size());
    Mail[] arrayOfMail = this.val$mails;
    int j = arrayOfMail.length;
    int i = 0;
    if (i < j)
    {
      Mail localMail = arrayOfMail[i];
      int k = POP3ProtocolManager.access$300(this.this$0, localArrayList2, localMail.getRemoteId());
      if (k == -1) {}
      for (;;)
      {
        i += 1;
        break;
        if (paramHandler.dele(k))
        {
          Logger.log(4, "POP3ProtocolManager", "delete mail msg number:" + k);
          localArrayList1.add(localMail.getRemoteId());
        }
      }
    }
    POP3ProtocolManager.access$1500(this.this$0, this.val$profile, localArrayList1);
    Logger.log(4, "POP3ProtocolManager", "delete mail success size:" + localArrayList1.size());
    if (this.val$mailOperationCallback != null) {
      this.val$mailOperationCallback.onMailOperationSuccess(this.val$mails);
    }
  }
  
  public int getPriority()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.POP3ProtocolManager.7
 * JD-Core Version:    0.7.0.1
 */