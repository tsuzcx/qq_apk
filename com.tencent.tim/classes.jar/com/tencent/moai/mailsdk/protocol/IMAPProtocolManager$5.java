package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.callback.FolderCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.protocol.imap.IMAPHandler;
import com.tencent.moai.mailsdk.protocol.imap.util.BASE64MailboxEncoder;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;
import com.tencent.moai.mailsdk.util.log.Logger;

class IMAPProtocolManager$5
  extends BaseTask
{
  IMAPProtocolManager$5(IMAPProtocolManager paramIMAPProtocolManager, String paramString, Folder paramFolder, FolderCallBack paramFolderCallBack)
  {
    super(paramString);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    String str = BASE64MailboxEncoder.encode(this.val$folder.getName());
    this.val$folder.setPath(str);
    this.val$folder.setRemoteId(str);
    Logger.log(4, "IMAPProtocolManager", "add folder newPath:" + str);
    if (!((IMAPHandler)paramHandler).create(str)) {}
    do
    {
      return;
      Logger.log(4, "IMAPProtocolManager", "add folder success:" + this.val$folder.getName());
    } while (this.val$folderCallBack == null);
    this.val$folderCallBack.operateFolderSuccess(this.val$folder);
  }
  
  public int getPriority()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.5
 * JD-Core Version:    0.7.0.1
 */