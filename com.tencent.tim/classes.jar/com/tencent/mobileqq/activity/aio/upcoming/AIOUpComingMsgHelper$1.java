package com.tencent.mobileqq.activity.aio.upcoming;

import android.os.Message;
import anot;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.os.MqqHandler;
import yju;
import ykf;

public class AIOUpComingMsgHelper$1
  implements Runnable
{
  public AIOUpComingMsgHelper$1(yju paramyju, long paramLong) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = yju.a(this.this$0).b().b(yju.a(this.this$0).aTl, yju.a(this.this$0).cZ, this.kQ);
    if (!ykf.O(localMessageRecord)) {
      localMessageRecord = null;
    }
    for (;;)
    {
      if (localMessageRecord == null) {
        anot.a(null, "dc00898", "", "", "0X800AE94", "0X800AE94", 0, 0, "", "", "", "");
      }
      Message localMessage = yju.a(this.this$0).obtainMessage();
      localMessage.what = 1;
      localMessage.obj = localMessageRecord;
      yju.a(this.this$0).sendMessage(localMessage);
      yju.a(this.this$0, yju.a(this.this$0).aTl);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper.1
 * JD-Core Version:    0.7.0.1
 */