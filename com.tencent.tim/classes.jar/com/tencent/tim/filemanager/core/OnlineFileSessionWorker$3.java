package com.tencent.tim.filemanager.core;

import agkh;
import atul;
import atul.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class OnlineFileSessionWorker$3
  implements Runnable
{
  public OnlineFileSessionWorker$3(atul paramatul, float paramFloat) {}
  
  public void run()
  {
    if (this.this$0.c == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      localFileManagerEntity = this.this$0.c;
      if ((localFileManagerEntity.getfProgress() < this.ww) && (this.this$0.c != null))
      {
        float f = localFileManagerEntity.getfProgress() + 0.05F;
        if (f > this.ww) {
          localFileManagerEntity.setfProgress(this.ww);
        }
        for (;;)
        {
          for (;;)
          {
            this.this$0.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 16, null, 0, null);
            try
            {
              Thread.sleep(100L);
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
          break;
          localFileManagerEntity.setfProgress(f);
        }
      }
    } while ((localFileManagerEntity.getfProgress() < 1.0F) || (this.this$0.c == null));
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + localFileManagerEntity.nSessionId + "] state:" + atul.a(this.this$0).vh() + " make progress. direct pass to 1.0 and notify make done");
    this.this$0.app.a().b(true, 41, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.OnlineFileSessionWorker.3
 * JD-Core Version:    0.7.0.1
 */