package com.tencent.moai.mailsdk;

import com.tencent.moai.mailsdk.callback.LogoutCallBack;
import com.tencent.moai.mailsdk.exception.ProtocolNotSupportError;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.protocol.ActiveSyncProtocolManager;
import com.tencent.moai.mailsdk.protocol.ExchangeProtocolManager;
import com.tencent.moai.mailsdk.protocol.IMAPProtocolManager;
import com.tencent.moai.mailsdk.protocol.POP3ProtocolManager;
import com.tencent.moai.mailsdk.protocol.SMTPProtocolManager;

class MailManager$2
  implements Runnable
{
  MailManager$2(MailManager paramMailManager, Profile paramProfile, LogoutCallBack paramLogoutCallBack) {}
  
  public void run()
  {
    int i = this.val$profile.getProtocol();
    if (i == 1)
    {
      SMTPProtocolManager.getInstance().logout(this.val$profile, this.val$logoutCallBack);
      return;
    }
    if (i == 2)
    {
      IMAPProtocolManager.getInstance().logout(this.val$profile, this.val$logoutCallBack);
      return;
    }
    if (i == 3)
    {
      POP3ProtocolManager.getInstance().logout(this.val$profile, this.val$logoutCallBack);
      return;
    }
    if (i == 4)
    {
      ActiveSyncProtocolManager.getInstance().logout(this.val$profile, this.val$logoutCallBack);
      return;
    }
    if (i == 5)
    {
      ExchangeProtocolManager.getInstance().logout(this.val$profile, this.val$logoutCallBack);
      return;
    }
    throw new ProtocolNotSupportError("logout protocol error " + this.val$profile.getProtocol());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager.2
 * JD-Core Version:    0.7.0.1
 */