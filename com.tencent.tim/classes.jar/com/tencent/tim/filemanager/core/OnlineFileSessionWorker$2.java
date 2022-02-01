package com.tencent.tim.filemanager.core;

import agkh;
import atul;
import atul.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class OnlineFileSessionWorker$2
  extends TimerTask
{
  public OnlineFileSessionWorker$2(atul paramatul) {}
  
  public void run()
  {
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.this$0.c.nSessionId + "] state:" + atul.a(this.this$0).vh() + " WaitAskUpProgressResultTimer time out!!!!!!!");
    this.this$0.app.a().b(true, 43, new Object[] { Long.valueOf(this.this$0.c.nSessionId) });
    this.this$0.dhS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.OnlineFileSessionWorker.2
 * JD-Core Version:    0.7.0.1
 */