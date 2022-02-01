package com.tencent.moai.mailsdk;

import com.tencent.moai.mailsdk.callback.FolderListCallBack;
import com.tencent.moai.mailsdk.exception.ProtocolNotSupportError;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.model.State;
import com.tencent.moai.mailsdk.protocol.ActiveSyncProtocolManager;
import com.tencent.moai.mailsdk.protocol.ExchangeProtocolManager;
import com.tencent.moai.mailsdk.protocol.IMAPProtocolManager;

class MailManager$4
  implements Runnable
{
  MailManager$4(MailManager paramMailManager, Profile paramProfile, State paramState, FolderListCallBack paramFolderListCallBack) {}
  
  public void run()
  {
    int i = this.val$profile.getProtocol();
    if (i == 2)
    {
      IMAPProtocolManager.getInstance().fetchFolderList(this.val$profile, this.val$state, this.val$folderListCallBack);
      return;
    }
    if (i == 4)
    {
      ActiveSyncProtocolManager.getInstance().fetchFolderList(this.val$profile, this.val$state, this.val$folderListCallBack);
      return;
    }
    if (i == 5)
    {
      ExchangeProtocolManager.getInstance().fetchFolderList(this.val$profile, this.val$state, this.val$folderListCallBack);
      return;
    }
    throw new ProtocolNotSupportError("fetchFolderList protocol error " + this.val$profile.getProtocol());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager.4
 * JD-Core Version:    0.7.0.1
 */