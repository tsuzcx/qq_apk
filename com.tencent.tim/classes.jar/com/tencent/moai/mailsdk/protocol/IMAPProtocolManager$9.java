package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.callback.FolderCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.protocol.imap.IMAPHandler;
import com.tencent.moai.mailsdk.protocol.model.Flags;
import com.tencent.moai.mailsdk.protocol.model.Flags.Flag;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;
import com.tencent.moai.mailsdk.util.log.Logger;

class IMAPProtocolManager$9
  extends BaseTask
{
  IMAPProtocolManager$9(IMAPProtocolManager paramIMAPProtocolManager, String paramString, Folder paramFolder, FolderCallBack paramFolderCallBack)
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
      do
      {
        return;
        Flags localFlags = new Flags();
        localFlags.add(Flags.Flag.DELETED);
        paramHandler.storeAll(localFlags, true);
        Logger.log(4, "IMAPProtocolManager", "delete all mail path" + this.val$folder.getPath() + " name:" + this.val$folder.getName());
      } while (!paramHandler.delete(this.val$folder.getPath()));
      Logger.log(4, "IMAPProtocolManager", "remove folder success path" + this.val$folder.getPath() + " name:" + this.val$folder.getName());
    } while (this.val$folderCallBack == null);
    this.val$folderCallBack.operateFolderSuccess(this.val$folder);
  }
  
  public int getPriority()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.9
 * JD-Core Version:    0.7.0.1
 */