package com.tencent.device.file;

import akxe;
import angt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import szb;
import szd;
import szy;

public class DevShortVideoOperator$1
  implements Runnable
{
  public DevShortVideoOperator$1(szb paramszb, angt paramangt) {}
  
  public void run()
  {
    angt localangt = this.b;
    Object localObject = null;
    int i;
    if (localangt.dFp == 0)
    {
      localObject = this.this$0.a(localangt);
      i = 1;
    }
    for (;;)
    {
      if (localObject == null)
      {
        return;
        if (localangt.dFp == 1)
        {
          localObject = (MessageForShortVideo)localangt.message;
          i = 0;
        }
      }
      else
      {
        this.this$0.F = ((MessageRecord)localObject);
        if ((localObject instanceof MessageForDevShortVideo)) {
          ((MessageForDevShortVideo)localObject).videoFileStatus = 1002;
        }
        long l = System.currentTimeMillis();
        if (i != 0) {
          this.this$0.mApp.b().b((MessageRecord)localObject, this.this$0.mApp.getCurrentAccountUin());
        }
        ((szy)this.this$0.mApp.getBusinessHandler(49)).a().a(szy.aIm, this.b.localPath, Long.parseLong(this.b.peerUin), ((MessageRecord)localObject).uniseq, ((MessageRecord)localObject).istroop, 0);
        akxe.M(this.this$0.logTag, this.this$0.bUB, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
        return;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.file.DevShortVideoOperator.1
 * JD-Core Version:    0.7.0.1
 */