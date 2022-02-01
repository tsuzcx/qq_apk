package com.tencent.qqmail.utilities.qmnetwork.service;

import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import com.tencent.qqmail.utilities.report.QMPushReportManager;
import java.util.concurrent.atomic.AtomicBoolean;

class PushLogin$1
  extends SimpleOnProtocolListener
{
  PushLogin$1(PushLogin paramPushLogin, long paramLong1, long paramLong2, long paramLong3, String paramString) {}
  
  public void onCloudResult(CloudProtocolResult arg1)
  {
    int i = -2147483648;
    long l = System.currentTimeMillis() - this.val$sTime;
    int j;
    if (??? != null)
    {
      j = ???.error_code_;
      i = j;
      if (j == 0)
      {
        i = j;
        if (!this.this$0.isResultValid(???)) {}
      }
    }
    for (;;)
    {
      synchronized (PushLogin.access$000(this.this$0))
      {
        this.this$0.saveResult(???);
        PushLogin.access$000(this.this$0).notifyAll();
        QMPushReportManager.sessionKey(this.val$realInterval, l, true, j);
        i = j;
        if (i != 0) {
          new QMUMAError(i, "CloudProtocolService.Login");
        }
        PushLogin.access$100(this.this$0).getAndSet(false);
        return;
      }
      QMLog.log(6, "PushLogin", "sessionkey error: " + i + ", vid: " + this.val$vid);
      if ((i == -10003) || (i == -10006)) {
        this.this$0.mEditor.putBoolean(this.val$keyEnable, false).apply();
      }
      synchronized (PushLogin.access$000(this.this$0))
      {
        PushLogin.access$000(this.this$0).notifyAll();
        QMPushReportManager.sessionKey(this.val$realInterval, l, false, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.PushLogin.1
 * JD-Core Version:    0.7.0.1
 */