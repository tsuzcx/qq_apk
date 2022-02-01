package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.callback.FolderSyncImapCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.protocol.imap.IMAPHandler;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPMailBoxStatus;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;
import com.tencent.moai.mailsdk.util.log.Logger;

class IMAPProtocolManager$3
  extends BaseTask
{
  IMAPProtocolManager$3(IMAPProtocolManager paramIMAPProtocolManager, String paramString, Folder paramFolder, FolderSyncImapCallBack paramFolderSyncImapCallBack)
  {
    super(paramString);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    paramHandler = ((IMAPHandler)paramHandler).status(this.val$folder.getPath(), null);
    if (paramHandler != null)
    {
      Logger.log(4, "IMAPProtocolManager", "fetch folder status" + paramHandler.getUnSeen() + ":" + paramHandler.getTotal());
      this.val$folder.setUnreadCount(paramHandler.getUnSeen());
      this.val$folder.setTotalCount(paramHandler.getTotal());
      this.val$folder.setUidValidity(paramHandler.getUidValidity());
    }
    Logger.log(4, "IMAPProtocolManager", "fetch folder status success path:" + this.val$folder.getPath() + " name:" + this.val$folder.getName());
    if (this.val$folderSyncImapCallBack != null) {
      this.val$folderSyncImapCallBack.onSyncStatusSuccess(this.val$folder.getTotalCount(), this.val$folder.getUnreadCount());
    }
  }
  
  public int getPriority()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.3
 * JD-Core Version:    0.7.0.1
 */