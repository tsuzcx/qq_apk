package com.tencent.common.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.qphone.base.util.QLog;

class QFixApplicationImpl$2
  implements TeleScreenRunnable
{
  QFixApplicationImpl$2(QFixApplicationImpl paramQFixApplicationImpl, Intent paramIntent, Bundle paramBundle) {}
  
  @RequiresApi(api=16)
  public void run()
  {
    try
    {
      QFixApplicationImpl.a(this.this$0, this.val$intent, this.S);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QFixAppImpl_PatchLogTag", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.common.app.QFixApplicationImpl.2
 * JD-Core Version:    0.7.0.1
 */