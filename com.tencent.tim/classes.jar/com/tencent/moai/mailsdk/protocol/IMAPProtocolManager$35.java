package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.callback.MailOperationCallback;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.imap.IMAPHandler;
import com.tencent.moai.mailsdk.protocol.model.Flags;
import com.tencent.moai.mailsdk.protocol.model.Flags.Flag;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;

class IMAPProtocolManager$35
  extends BaseTask
{
  IMAPProtocolManager$35(IMAPProtocolManager paramIMAPProtocolManager, String paramString1, String paramString2, String paramString3, MailOperationCallback paramMailOperationCallback)
  {
    super(paramString1);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    paramHandler = (IMAPHandler)paramHandler;
    Flags localFlags = new Flags();
    localFlags.add(Flags.Flag.SEEN);
    if (paramHandler.append(this.val$path, this.val$folderId, localFlags)) {
      if (this.val$callback != null) {
        this.val$callback.onMailOperationSuccess(null);
      }
    }
    while (this.val$callback == null) {
      return;
    }
    this.val$callback.onMailOperationError(1, 200001, "append fail");
  }
  
  public int getPriority()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.35
 * JD-Core Version:    0.7.0.1
 */