package com.tencent.tim.filemanager.core;

import android.os.Handler;
import android.os.Message;
import atuh;
import atuh.b;
import java.util.TimerTask;

public class OnlineFileSessionCenter$UploadProgressMakeEvtPump$1
  extends TimerTask
{
  public OnlineFileSessionCenter$UploadProgressMakeEvtPump$1(atuh.b paramb) {}
  
  public void run()
  {
    if (atuh.b.a(this.b) == null) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 1;
    this.b.this$0.mMainHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.OnlineFileSessionCenter.UploadProgressMakeEvtPump.1
 * JD-Core Version:    0.7.0.1
 */