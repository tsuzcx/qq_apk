package com.tencent.moai.mailsdk;

import com.tencent.moai.mailsdk.callback.SearchMailCallback;
import com.tencent.moai.mailsdk.exception.ProtocolNotSupportError;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.model.State;
import com.tencent.moai.mailsdk.protocol.ActiveSyncProtocolManager;
import com.tencent.moai.mailsdk.protocol.ExchangeProtocolManager;
import com.tencent.moai.mailsdk.protocol.IMAPProtocolManager;
import java.util.ArrayList;
import java.util.HashMap;

class MailManager$18
  implements Runnable
{
  MailManager$18(MailManager paramMailManager, Profile paramProfile, ArrayList paramArrayList, State paramState, HashMap paramHashMap, SearchMailCallback paramSearchMailCallback) {}
  
  public void run()
  {
    int i = this.val$profile.getProtocol();
    if (i == 2)
    {
      IMAPProtocolManager.getInstance().searchMail(this.val$profile, this.val$folderIds, this.val$state, this.val$searchFields, this.val$callback);
      return;
    }
    if (i == 4)
    {
      ActiveSyncProtocolManager.getInstance().searchMail(this.val$profile, this.val$folderIds, this.val$state, this.val$searchFields, this.val$callback);
      return;
    }
    if (i == 5)
    {
      ExchangeProtocolManager.getInstance().searchMail(this.val$profile, this.val$folderIds, this.val$state, this.val$searchFields, this.val$callback);
      return;
    }
    throw new ProtocolNotSupportError("searchMail protocol error " + this.val$profile.getProtocol());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager.18
 * JD-Core Version:    0.7.0.1
 */