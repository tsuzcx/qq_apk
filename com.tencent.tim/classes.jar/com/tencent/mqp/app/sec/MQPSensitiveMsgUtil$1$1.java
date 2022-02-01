package com.tencent.mqp.app.sec;

import arnn;
import arno;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;

public class MQPSensitiveMsgUtil$1$1
  implements Runnable
{
  public MQPSensitiveMsgUtil$1$1(arno paramarno) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.this$0.d.a(this.this$0.Mu, this.this$0.val$type, this.this$0.rJ);
    if (localMessageRecord == null) {
      return;
    }
    arnn.aJ(localMessageRecord);
    try
    {
      localMessageRecord.saveExtInfoToExtStr("sens_msg_confirmed", "1");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_original_text");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_need_parse");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_need_mask");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_attr");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_has_not_confirmed_msg");
      this.this$0.d.a(this.this$0.Mu, this.this$0.val$type, this.this$0.rJ, "extStr", localMessageRecord.extStr);
      this.this$0.d.as(localMessageRecord);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.1.1
 * JD-Core Version:    0.7.0.1
 */