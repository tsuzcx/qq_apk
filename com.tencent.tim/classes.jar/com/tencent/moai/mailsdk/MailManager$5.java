package com.tencent.moai.mailsdk;

import com.tencent.moai.mailsdk.callback.FolderSyncActiveSyncCallBack;
import com.tencent.moai.mailsdk.exception.ProtocolNotSupportError;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.model.State;
import com.tencent.moai.mailsdk.protocol.ActiveSyncProtocolManager;

class MailManager$5
  implements Runnable
{
  MailManager$5(MailManager paramMailManager, Profile paramProfile, State paramState, Folder paramFolder, FolderSyncActiveSyncCallBack paramFolderSyncActiveSyncCallBack) {}
  
  public void run()
  {
    if (this.val$profile.getProtocol() == 4)
    {
      ActiveSyncProtocolManager.getInstance().syncFolderStatus(this.val$profile, this.val$state, this.val$folder, this.val$folderSyncActiveSyncCallBack);
      return;
    }
    throw new ProtocolNotSupportError("syncActiveSyncFolderStatus protocol error " + this.val$profile.getProtocol());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager.5
 * JD-Core Version:    0.7.0.1
 */