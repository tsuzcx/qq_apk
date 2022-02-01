package com.tencent.moai.mailsdk;

import com.tencent.moai.mailsdk.callback.FolderCallBack;
import com.tencent.moai.mailsdk.exception.ProtocolNotSupportError;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.model.State;
import com.tencent.moai.mailsdk.protocol.ActiveSyncProtocolManager;
import com.tencent.moai.mailsdk.protocol.ExchangeProtocolManager;
import com.tencent.moai.mailsdk.protocol.IMAPProtocolManager;

class MailManager$8
  implements Runnable
{
  MailManager$8(MailManager paramMailManager, Profile paramProfile, State paramState, Folder paramFolder, FolderCallBack paramFolderCallBack) {}
  
  public void run()
  {
    int i = this.val$profile.getProtocol();
    if (i == 2)
    {
      IMAPProtocolManager.getInstance().removeFolder(this.val$profile, this.val$state, this.val$folder, this.val$folderCallBack);
      return;
    }
    if (i == 4)
    {
      ActiveSyncProtocolManager.getInstance().removeFolder(this.val$profile, this.val$state, this.val$folder, this.val$folderCallBack);
      return;
    }
    if (i == 5)
    {
      ExchangeProtocolManager.getInstance().removeFolder(this.val$profile, this.val$state, this.val$folder, this.val$folderCallBack);
      return;
    }
    throw new ProtocolNotSupportError("deleteFolder protocol error " + this.val$profile.getProtocol());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager.8
 * JD-Core Version:    0.7.0.1
 */