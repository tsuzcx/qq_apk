package com.tencent.moai.mailsdk;

import com.tencent.moai.mailsdk.callback.MailOperationCallback;
import com.tencent.moai.mailsdk.exception.ProtocolNotSupportError;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.protocol.IMAPProtocolManager;

class MailManager$20
  implements Runnable
{
  MailManager$20(MailManager paramMailManager, Profile paramProfile, String paramString1, String paramString2, MailOperationCallback paramMailOperationCallback) {}
  
  public void run()
  {
    if (this.val$profile.getProtocol() == 2)
    {
      IMAPProtocolManager.getInstance().appendFile(this.val$profile, this.val$folderId, this.val$path, this.val$callback);
      return;
    }
    throw new ProtocolNotSupportError("appendFile protocol error " + this.val$profile.getProtocol());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager.20
 * JD-Core Version:    0.7.0.1
 */