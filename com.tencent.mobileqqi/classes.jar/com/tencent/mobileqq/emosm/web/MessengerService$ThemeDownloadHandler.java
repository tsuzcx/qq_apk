package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

class MessengerService$ThemeDownloadHandler
  extends TransProcessorHandler
{
  private Bundle reqbundle;
  
  public MessengerService$ThemeDownloadHandler(MessengerService paramMessengerService, Bundle paramBundle)
  {
    this.reqbundle = paramBundle;
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if (localFileMsg != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("transferedSize", localFileMsg.d);
      localBundle.putString("filePath", localFileMsg.e);
      localBundle.putInt("what", paramMessage.what);
      this.reqbundle.putBundle("response", localBundle);
      MessengerService.access$200(this.this$0, this.reqbundle);
    }
  }
  
  public void setBundle(Bundle paramBundle)
  {
    this.reqbundle = paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.ThemeDownloadHandler
 * JD-Core Version:    0.7.0.1
 */