package com.tencent.mobileqq.filemanager.app;

import agib;
import aglp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FileTransferHandler$9
  implements Runnable
{
  public FileTransferHandler$9(agib paramagib, long paramLong, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + this.Yq + "] Handle upload failed notify. retCode =" + this.cXc + "(1:cancel upload) reason=" + this.bHc);
    if (1 == this.cXc)
    {
      this.this$0.app.a().ak(this.bHa, this.Yq);
      return;
    }
    if (2 == this.cXc)
    {
      this.this$0.app.a().ak(this.bHa, this.Yq);
      return;
    }
    if (3 == this.cXc)
    {
      this.this$0.app.a().am(this.bHa, this.Yq);
      return;
    }
    this.this$0.app.a().ak(this.bHa, this.Yq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.9
 * JD-Core Version:    0.7.0.1
 */