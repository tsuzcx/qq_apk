package com.tencent.moai.mailsdk;

import com.tencent.moai.mailsdk.callback.MailListCallBack;
import com.tencent.moai.mailsdk.exception.ProtocolNotSupportError;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.model.State;
import com.tencent.moai.mailsdk.protocol.ActiveSyncProtocolManager;
import com.tencent.moai.mailsdk.protocol.ExchangeProtocolManager;
import com.tencent.moai.mailsdk.protocol.IMAPProtocolManager;
import com.tencent.moai.mailsdk.protocol.POP3ProtocolManager;

class MailManager$10
  implements Runnable
{
  MailManager$10(MailManager paramMailManager, Profile paramProfile, State paramState, Folder paramFolder, MailListCallBack paramMailListCallBack) {}
  
  public void run()
  {
    int i = this.val$profile.getProtocol();
    if (i == 2)
    {
      IMAPProtocolManager.getInstance().fetchMailList(this.val$profile, this.val$state, this.val$folder, this.val$mailListCallBack);
      return;
    }
    if (i == 3)
    {
      POP3ProtocolManager.getInstance().fetchMailList(this.val$profile, this.val$state, this.val$folder, this.val$mailListCallBack);
      return;
    }
    if (i == 4)
    {
      ActiveSyncProtocolManager.getInstance().fetchMailList(this.val$profile, this.val$state, this.val$folder, this.val$mailListCallBack);
      return;
    }
    if (i == 5)
    {
      ExchangeProtocolManager.getInstance().fetchMailList(this.val$profile, this.val$state, this.val$folder, this.val$mailListCallBack);
      return;
    }
    throw new ProtocolNotSupportError("fetchMailList protocol error " + this.val$profile.getProtocol());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager.10
 * JD-Core Version:    0.7.0.1
 */