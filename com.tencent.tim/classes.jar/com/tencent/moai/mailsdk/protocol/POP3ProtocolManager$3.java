package com.tencent.moai.mailsdk.protocol;

import android.util.Log;
import com.tencent.moai.mailsdk.MailParser;
import com.tencent.moai.mailsdk.callback.MailCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeMessage;
import com.tencent.moai.mailsdk.protocol.pop3.POP3Handler;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.ArrayList;

class POP3ProtocolManager$3
  extends BaseTask
{
  POP3ProtocolManager$3(POP3ProtocolManager paramPOP3ProtocolManager, String paramString, Mail[] paramArrayOfMail, MailCallBack paramMailCallBack, boolean paramBoolean)
  {
    super(paramString);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    POP3Handler localPOP3Handler = (POP3Handler)paramHandler;
    ArrayList localArrayList1 = localPOP3Handler.list();
    ArrayList localArrayList2 = localPOP3Handler.uidl();
    Logger.log(4, "POP3ProtocolManager", "download mail text uid size:" + localArrayList2.size());
    Mail[] arrayOfMail = this.val$mails;
    int j = arrayOfMail.length;
    int i = 0;
    if (i < j)
    {
      Mail localMail = arrayOfMail[i];
      if (localMail == null) {}
      int k;
      for (;;)
      {
        i += 1;
        break;
        k = POP3ProtocolManager.access$300(this.this$0, localArrayList2, localMail.getRemoteId());
        if (k != -1) {
          break label181;
        }
        Logger.log(5, "POP3ProtocolManager", "msg -1 mailId:" + localMail.getRemoteId());
        if (this.val$mailCallBack != null) {
          this.val$mailCallBack.onRetrieveMailError(11, 200001, "get msgNum -1 remoteId:" + localMail.getRemoteId());
        }
      }
      label181:
      long l = POP3ProtocolManager.access$1100(this.this$0, localArrayList1, k);
      Logger.log(4, "POP3ProtocolManager", "download mail text msg number:" + k + " msg size: " + l + " forceLoadAll " + this.val$forceLoadAll);
      if ((this.val$forceLoadAll) || (l < 20480L)) {}
      for (paramHandler = localPOP3Handler.retr(k); paramHandler == null; paramHandler = localPOP3Handler.top(k, Math.min(POP3ProtocolManager.access$1200(this.this$0, localArrayList1, k), 100))) {
        throw new MessageException(1, 200001, "top message null");
      }
      l = POP3ProtocolManager.access$400(this.this$0, localArrayList1, k);
      if ((this.val$forceLoadAll) || (Math.abs(paramHandler.getAvailableSize() - l) < 3L)) {}
      for (boolean bool = true;; bool = false)
      {
        try
        {
          paramHandler = MailParser.createMail(paramHandler);
          paramHandler.setId(localMail.getId());
          paramHandler.setRemoteId(localMail.getRemoteId());
          paramHandler.setSize(l);
          paramHandler.setIsNew(true);
          paramHandler.setIsContentComplete(bool);
          POP3ProtocolManager.access$1300(this.this$0, paramHandler, bool);
          Logger.log(4, "POP3ProtocolManager", "download mail text success id:" + paramHandler.getId() + " remoteId:" + paramHandler.getRemoteId());
          if (this.val$mailCallBack == null) {
            break;
          }
          this.val$mailCallBack.onRetrieveMailSuccess(paramHandler);
        }
        catch (Exception paramHandler)
        {
          Logger.log(6, "POP3ProtocolManager", "download mail text error " + Log.getStackTraceString(paramHandler));
          Logger.osslog(new Object[] { "pop_downloadtext", paramHandler.getMessage() });
        }
        if (this.val$mailCallBack == null) {
          break;
        }
        this.val$mailCallBack.onRetrieveMailError(1, 200001, paramHandler.getMessage());
        break;
      }
    }
  }
  
  public int getPriority()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.POP3ProtocolManager.3
 * JD-Core Version:    0.7.0.1
 */