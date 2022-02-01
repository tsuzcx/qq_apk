package com.tencent.moai.mailsdk.protocol;

import android.util.Log;
import com.tencent.moai.mailsdk.MailParser;
import com.tencent.moai.mailsdk.callback.MailAbstractCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.protocol.pop3.POP3Handler;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.ArrayList;

class POP3ProtocolManager$5
  extends BaseTask
{
  POP3ProtocolManager$5(POP3ProtocolManager paramPOP3ProtocolManager, String paramString, Mail[] paramArrayOfMail, MailAbstractCallBack paramMailAbstractCallBack)
  {
    super(paramString);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    POP3Handler localPOP3Handler = (POP3Handler)paramHandler;
    ArrayList localArrayList1 = localPOP3Handler.list();
    ArrayList localArrayList2 = localPOP3Handler.uidl();
    Logger.log(4, "POP3ProtocolManager", "download mail abstract all uid size:" + localArrayList2.size());
    Mail[] arrayOfMail = this.val$mails;
    int j = arrayOfMail.length;
    int i = 0;
    if (i < j)
    {
      Mail localMail = arrayOfMail[i];
      if (localMail == null) {}
      for (;;)
      {
        i += 1;
        break;
        int k = POP3ProtocolManager.access$300(this.this$0, localArrayList2, localMail.getRemoteId());
        if (k == -1)
        {
          Logger.log(5, "POP3ProtocolManager", "msg -1 mailId:" + localMail.getRemoteId());
          if (this.val$mailAbstractCallBack != null) {
            this.val$mailAbstractCallBack.onRetrieveMailAbstractError(localMail.getId(), 11, 200001, "get msgNum -1 remoteId:" + localMail.getRemoteId());
          }
        }
        else
        {
          Logger.log(4, "POP3ProtocolManager", "download mail abstract msg number:" + k);
          if (POP3ProtocolManager.access$1100(this.this$0, localArrayList1, k) < 20480L) {}
          for (paramHandler = localPOP3Handler.retr(k); paramHandler == null; paramHandler = localPOP3Handler.top(k, Math.min(POP3ProtocolManager.access$1200(this.this$0, localArrayList1, k), 100))) {
            throw new MessageException(1, 200001, "top message null id:" + localMail.getId() + " remoteId:" + localMail.getRemoteId());
          }
          try
          {
            paramHandler = MailParser.createMail(paramHandler);
            paramHandler.setId(localMail.getId());
            paramHandler.setRemoteId(localMail.getRemoteId());
            Logger.log(4, "POP3ProtocolManager", "download mail abstract success id:" + paramHandler.getId() + " remoteId:" + paramHandler.getRemoteId());
            if (this.val$mailAbstractCallBack == null) {
              continue;
            }
            this.val$mailAbstractCallBack.onRetrieveMailAbstractSuccess(paramHandler);
          }
          catch (Exception paramHandler)
          {
            Logger.osslog(new Object[] { "pop_downloadtextabs", paramHandler.getMessage() });
            Logger.log(6, "POP3ProtocolManager", "download mail abstracttext error " + Log.getStackTraceString(paramHandler));
          }
          if (this.val$mailAbstractCallBack != null) {
            this.val$mailAbstractCallBack.onRetrieveMailAbstractError(localMail.getId(), 1, 200001, paramHandler.getMessage());
          }
        }
      }
    }
  }
  
  public int getPriority()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.POP3ProtocolManager.5
 * JD-Core Version:    0.7.0.1
 */