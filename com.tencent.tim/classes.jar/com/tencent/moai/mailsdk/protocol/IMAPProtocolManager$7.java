package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.callback.FolderCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.protocol.imap.IMAPHandler;
import com.tencent.moai.mailsdk.protocol.imap.util.BASE64MailboxEncoder;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;
import com.tencent.moai.mailsdk.util.log.Logger;

class IMAPProtocolManager$7
  extends BaseTask
{
  IMAPProtocolManager$7(IMAPProtocolManager paramIMAPProtocolManager, String paramString1, Folder paramFolder, String paramString2, FolderCallBack paramFolderCallBack)
  {
    super(paramString1);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    String str1 = this.val$folder.getPath();
    String str2 = BASE64MailboxEncoder.encode(this.val$folderNewName);
    this.val$folder.setName(this.val$folderNewName);
    this.val$folder.setPath(str2);
    this.val$folder.setRemoteId(str2);
    Logger.log(4, "IMAPProtocolManager", "rename folder path:" + str1 + " newPath:" + str2);
    if (!((IMAPHandler)paramHandler).rename(str1, str2)) {}
    do
    {
      return;
      Logger.log(4, "IMAPProtocolManager", "rename folder success:" + this.val$folder.getName() + ":" + this.val$folderNewName);
    } while (this.val$folderCallBack == null);
    this.val$folderCallBack.operateFolderSuccess(this.val$folder);
  }
  
  public int getPriority()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.7
 * JD-Core Version:    0.7.0.1
 */