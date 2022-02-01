package com.tencent.qqmail.utilities.qmnetwork.service;

import android.widget.Toast;

class QMPushService$7
  implements Runnable
{
  QMPushService$7(QMPushService paramQMPushService, long paramLong, QMPushService.AckInfo paramAckInfo) {}
  
  public void run()
  {
    Toast.makeText(this.this$0.getApplicationContext(), "收到104心跳回复，耗时：" + this.val$elapse + "ms, msgId: " + this.val$info.msgId + ", cmd: " + this.val$info.cmd, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.7
 * JD-Core Version:    0.7.0.1
 */