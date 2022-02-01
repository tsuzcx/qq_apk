package com.tencent.tim.filemanager.core;

import agkh;
import atul;
import atul.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class OnlineFileSessionWorker$1
  extends TimerTask
{
  public OnlineFileSessionWorker$1(atul paramatul) {}
  
  public void run()
  {
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.this$0.c.nSessionId + "] state:" + atul.a(this.this$0).vh() + " WaitSenderReplayOnRecvTimer time out!!!!!!!");
    this.this$0.app.a().b(true, 42, new Object[] { Long.valueOf(this.this$0.c.nSessionId) });
    this.this$0.dhR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.OnlineFileSessionWorker.1
 * JD-Core Version:    0.7.0.1
 */