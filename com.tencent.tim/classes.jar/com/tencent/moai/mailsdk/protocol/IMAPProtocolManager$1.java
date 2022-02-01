package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.callback.FolderListCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.protocol.imap.IMAPHandler;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPFolder;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPMailBoxStatus;
import com.tencent.moai.mailsdk.task.BaseTask;
import com.tencent.moai.mailsdk.task.Handler;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.ArrayList;
import java.util.Iterator;

class IMAPProtocolManager$1
  extends BaseTask
{
  IMAPProtocolManager$1(IMAPProtocolManager paramIMAPProtocolManager, String paramString, Profile paramProfile, FolderListCallBack paramFolderListCallBack)
  {
    super(paramString);
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {
    paramHandler = (IMAPHandler)paramHandler;
    ArrayList localArrayList = paramHandler.list("\"\"", "*");
    Logger.log(4, "IMAPProtocolManager", "fetch folder list size:" + localArrayList.size());
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      IMAPFolder localIMAPFolder = (IMAPFolder)localIterator.next();
      Logger.log(4, "IMAPProtocolManager", "fetch folder list path:" + localIMAPFolder.getPath() + " name:" + localIMAPFolder.getName());
      if (!localIMAPFolder.isVirtual())
      {
        IMAPMailBoxStatus localIMAPMailBoxStatus = paramHandler.status(localIMAPFolder.getPath(), null);
        if (localIMAPMailBoxStatus != null)
        {
          Logger.log(4, "IMAPProtocolManager", "fetch folder status:" + localIMAPMailBoxStatus.getUnSeen() + ":" + localIMAPMailBoxStatus.getTotal());
          localIMAPFolder.setUnreadCount(localIMAPMailBoxStatus.getUnSeen());
          localIMAPFolder.setTotalCount(localIMAPMailBoxStatus.getTotal());
          localIMAPFolder.setUidValidity(localIMAPMailBoxStatus.getUidValidity());
        }
      }
    }
    Logger.log(4, "IMAPProtocolManager", "fetch folder list success name:" + this.val$profile.getImapName());
    if (this.val$folderListCallBack != null) {
      this.val$folderListCallBack.onRetrieveFoldersSuccess((Folder[])localArrayList.toArray(new Folder[localArrayList.size()]), null, null);
    }
  }
  
  public int getPriority()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.1
 * JD-Core Version:    0.7.0.1
 */