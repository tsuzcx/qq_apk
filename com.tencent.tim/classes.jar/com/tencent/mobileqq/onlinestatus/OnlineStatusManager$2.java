package com.tencent.mobileqq.onlinestatus;

import akti;
import aktp;
import akun;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class OnlineStatusManager$2
  implements Runnable
{
  public OnlineStatusManager$2(aktp paramaktp) {}
  
  public void run()
  {
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      if (aktp.a(this.this$0) == null)
      {
        localObject = "null";
        QLog.d("OnlineStatusManager", 2, new Object[] { "SyncBusinessInfoRunnable app.isRunning=", localObject, " mSyncPause:", Boolean.valueOf(aktp.a(this.this$0)) });
      }
    }
    else if ((aktp.a(this.this$0) != null) && (aktp.a(this.this$0).isRunning()))
    {
      i = akti.a().S(aktp.a(this.this$0));
      if (i != 1) {
        break label158;
      }
      localObject = akti.a().b(aktp.a(this.this$0));
      ((akun)aktp.a(this.this$0).getBusinessHandler(174)).J(i, (Bundle)localObject);
    }
    for (;;)
    {
      this.this$0.dDr();
      return;
      localObject = Boolean.valueOf(aktp.a(this.this$0).isRunning());
      break;
      label158:
      if ((i == 2) && (!aktp.a(this.this$0))) {
        this.this$0.Sm(3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusManager.2
 * JD-Core Version:    0.7.0.1
 */