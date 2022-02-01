package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.callback.MailOperationCallback;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.protocol.imap.IMAPHandler;
import com.tencent.moai.mailsdk.protocol.model.Flags;
import com.tencent.moai.mailsdk.protocol.model.Flags.Flag;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.ArrayList;

class IMAPProtocolManager$27
  extends BaseTask
{
  IMAPProtocolManager$27(IMAPProtocolManager paramIMAPProtocolManager, String paramString, Folder paramFolder, Mail[] paramArrayOfMail, MailOperationCallback paramMailOperationCallback)
  {
    super(paramString);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    paramHandler = (IMAPHandler)paramHandler;
    if (paramHandler.select(this.val$folder.getPath()) == null) {}
    do
    {
      ArrayList localArrayList;
      do
      {
        do
        {
          return;
          localArrayList = new ArrayList();
          int i = 0;
          while (i < this.val$mails.length)
          {
            localArrayList.add(this.val$mails[i].getRemoteId());
            i += 1;
          }
          Flags localFlags = new Flags();
          localFlags.add(Flags.Flag.DELETED);
          if (paramHandler.storeUidList(localArrayList, localFlags, true)) {
            break;
          }
          Logger.log(6, "IMAPProtocolManager", "store delete fail");
        } while (this.val$mailOperationCallback == null);
        this.val$mailOperationCallback.onMailOperationError(1, 200001, "store delete fail, size:" + localArrayList.size());
        return;
        if (paramHandler.expunge()) {
          break;
        }
        Logger.log(6, "IMAPProtocolManager", "expunge fail");
      } while (this.val$mailOperationCallback == null);
      this.val$mailOperationCallback.onMailOperationError(1, 200001, "expunge fail, size:" + localArrayList.size());
      return;
      Logger.log(4, "IMAPProtocolManager", "delete mail success size:" + this.val$mails.length);
    } while (this.val$mailOperationCallback == null);
    this.val$mailOperationCallback.onMailOperationSuccess(this.val$mails);
  }
  
  public int getPriority()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.27
 * JD-Core Version:    0.7.0.1
 */