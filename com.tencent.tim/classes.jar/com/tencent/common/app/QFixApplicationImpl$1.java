package com.tencent.common.app;

import android.content.Intent;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.qphone.base.util.QLog;

class QFixApplicationImpl$1
  implements TeleScreenRunnable
{
  QFixApplicationImpl$1(QFixApplicationImpl paramQFixApplicationImpl, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      QFixApplicationImpl.a(this.this$0, this.val$intent);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QFixAppImpl_PatchLogTag", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.common.app.QFixApplicationImpl.1
 * JD-Core Version:    0.7.0.1
 */