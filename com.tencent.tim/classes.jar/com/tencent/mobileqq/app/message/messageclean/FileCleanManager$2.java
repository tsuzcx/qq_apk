package com.tencent.mobileqq.app.message.messageclean;

import acsg;
import com.tencent.qphone.base.util.QLog;

public class FileCleanManager$2
  implements Runnable
{
  public FileCleanManager$2(acsg paramacsg) {}
  
  public void run()
  {
    acsg.d(this.this$0);
    acsg.b(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.e("FileCleanManager", 2, "load qq files finish");
    }
    acsg.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.FileCleanManager.2
 * JD-Core Version:    0.7.0.1
 */