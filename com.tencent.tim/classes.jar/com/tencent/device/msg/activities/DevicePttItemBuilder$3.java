package com.tencent.device.msg.activities;

import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.QLog;
import szd;
import szq;
import szy;

public class DevicePttItemBuilder$3
  implements Runnable
{
  public DevicePttItemBuilder$3(szq paramszq, MessageForPtt paramMessageForPtt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTrans", 2, "downloadPtt istroop" + this.a.istroop + " itemType " + this.a.itemType + " uniseq:" + this.a.uniseq);
    }
    szd localszd = ((szy)this.this$0.app.getBusinessHandler(49)).a();
    if ((this.a instanceof MessageForDevPtt)) {
      localszd.a((MessageForDevPtt)this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevicePttItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */