package com.tencent.mobileqq.activity.aio.tips;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import yiq;

public class HongbaoKeywordGrayTips$1
  implements Runnable
{
  public HongbaoKeywordGrayTips$1(yiq paramyiq) {}
  
  public void run()
  {
    Object localObject = yiq.a(this.this$0).b().f(yiq.a(this.this$0).aTl, yiq.a(this.this$0).cZ);
    int i = ((List)localObject).size();
    if (i > 0)
    {
      localObject = (ChatMessage)((List)localObject).get(i - 1);
      if (yiq.a(this.this$0).cZ != 0) {
        break label130;
      }
      yiq.a(this.this$0, ((ChatMessage)localObject).time);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "size : " + i + ", mLastMsgIdOrTime:" + yiq.a(this.this$0));
      }
      return;
      label130:
      if ((yiq.a(this.this$0).cZ == 3000) || (yiq.a(this.this$0).cZ == 1)) {
        yiq.a(this.this$0, ((ChatMessage)localObject).shmsgseq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips.1
 * JD-Core Version:    0.7.0.1
 */