package com.tencent.mobileqq.filemanager.core;

import agkv;
import agkv.b;
import com.tencent.qphone.base.util.QLog;

public class FileUploader$3
  implements Runnable
{
  public FileUploader$3(agkv paramagkv) {}
  
  public void run()
  {
    if (agkv.a(this.this$0)) {
      return;
    }
    QLog.i("FtnHttpUploader<FileAssistant>", 1, "Id[" + agkv.b(this.this$0) + "] resend");
    if (agkv.a(this.this$0) != null) {
      agkv.a(this.this$0).dgC();
    }
    agkv.a(this.this$0, 0L);
    agkv.a(this.this$0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileUploader.3
 * JD-Core Version:    0.7.0.1
 */