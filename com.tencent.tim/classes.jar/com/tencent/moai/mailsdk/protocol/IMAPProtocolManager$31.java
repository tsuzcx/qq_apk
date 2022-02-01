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

class IMAPProtocolManager$31
  extends BaseTask
{
  IMAPProtocolManager$31(IMAPProtocolManager paramIMAPProtocolManager, String paramString, Folder paramFolder, Mail[] paramArrayOfMail, int paramInt1, int paramInt2, MailOperationCallback paramMailOperationCallback)
  {
    super(paramString);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    boolean bool = false;
    paramHandler = (IMAPHandler)paramHandler;
    if (paramHandler.select(this.val$folder.getPath()) == null) {}
    label182:
    label213:
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < this.val$mails.length)
      {
        localArrayList.add(this.val$mails[i].getRemoteId());
        i += 1;
      }
      Flags localFlags = new Flags();
      if (this.val$flagType == 1) {
        localFlags.add(Flags.Flag.FLAGGED);
      }
      for (;;)
      {
        if (this.val$flagValue == 1) {
          bool = true;
        }
        if (paramHandler.storeUidList(localArrayList, localFlags, bool)) {
          break label213;
        }
        Logger.log(6, "IMAPProtocolManager", "store flags fail");
        if (this.val$mailOperationCallback == null) {
          break;
        }
        this.val$mailOperationCallback.onMailOperationError(1, 200001, "store flags fail, size:" + localArrayList.size());
        return;
        if (this.val$flagType != 2) {
          break label182;
        }
        localFlags.add(Flags.Flag.SEEN);
      }
      throw new MessageException(2, "flag not support:" + this.val$flagType);
      Logger.log(4, "IMAPProtocolManager", "modify mail flag success size:" + this.val$mails.length + " flag:" + this.val$flagType + " value:" + this.val$flagValue);
    } while (this.val$mailOperationCallback == null);
    this.val$mailOperationCallback.onMailOperationSuccess(this.val$mails);
  }
  
  public int getPriority()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.31
 * JD-Core Version:    0.7.0.1
 */