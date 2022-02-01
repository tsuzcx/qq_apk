package com.tencent.mobileqq.filemanager.core;

import aglp;
import aglp.b;
import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;

public class OnlineFileSessionCenter$UploadProgressMakeEvtPump$1
  extends TimerTask
{
  public OnlineFileSessionCenter$UploadProgressMakeEvtPump$1(aglp.b paramb) {}
  
  public void run()
  {
    if (aglp.b.a(this.b) == null) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 1;
    this.b.this$0.mMainHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter.UploadProgressMakeEvtPump.1
 * JD-Core Version:    0.7.0.1
 */