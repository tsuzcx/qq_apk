package com.tencent.moai.mailsdk;

import com.tencent.moai.mailsdk.callback.FolderSyncExchangeCallBack;
import com.tencent.moai.mailsdk.exception.ProtocolNotSupportError;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.model.State;
import com.tencent.moai.mailsdk.protocol.ExchangeProtocolManager;

class MailManager$6
  implements Runnable
{
  MailManager$6(MailManager paramMailManager, Profile paramProfile, State paramState, Folder paramFolder, FolderSyncExchangeCallBack paramFolderSyncExchangeCallBack) {}
  
  public void run()
  {
    if (this.val$profile.getProtocol() == 5)
    {
      ExchangeProtocolManager.getInstance().syncFolderStatus(this.val$profile, this.val$state, this.val$folder, this.val$folderSyncExchangeCallBack);
      return;
    }
    throw new ProtocolNotSupportError("syncExchangeFolderStatus protocol error " + this.val$profile.getProtocol());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager.6
 * JD-Core Version:    0.7.0.1
 */