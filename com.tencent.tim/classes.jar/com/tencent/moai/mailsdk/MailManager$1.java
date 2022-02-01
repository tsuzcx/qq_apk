package com.tencent.moai.mailsdk;

import com.tencent.moai.mailsdk.callback.LoginCallBack;
import com.tencent.moai.mailsdk.exception.ProtocolNotSupportError;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.protocol.ActiveSyncProtocolManager;
import com.tencent.moai.mailsdk.protocol.ExchangeProtocolManager;
import com.tencent.moai.mailsdk.protocol.IMAPProtocolManager;
import com.tencent.moai.mailsdk.protocol.POP3ProtocolManager;

class MailManager$1
  implements Runnable
{
  MailManager$1(MailManager paramMailManager, Profile paramProfile, LoginCallBack paramLoginCallBack, boolean paramBoolean) {}
  
  public void run()
  {
    int i = this.val$profile.getProtocol();
    if ((i == 2) || (i == 3))
    {
      MailManager.1.2 local2 = new MailManager.1.2(this, new MailManager.1.1(this));
      if (i == 2)
      {
        IMAPProtocolManager.getInstance().login(this.val$profile, local2);
        return;
      }
      POP3ProtocolManager.getInstance().login(this.val$profile, local2);
      return;
    }
    if (i == 4)
    {
      ActiveSyncProtocolManager.getInstance().login(this.val$profile, this.val$loginCallBack);
      return;
    }
    if (i == 5)
    {
      this.val$profile.setExchangeVersion("Exchange2010_SP1");
      ExchangeProtocolManager.getInstance().login(this.val$profile, this.val$loginCallBack);
      return;
    }
    throw new ProtocolNotSupportError("login protocol error " + this.val$profile.getProtocol());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager.1
 * JD-Core Version:    0.7.0.1
 */