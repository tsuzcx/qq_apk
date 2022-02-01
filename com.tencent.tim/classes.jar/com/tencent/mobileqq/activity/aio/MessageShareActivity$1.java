package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import java.util.Iterator;
import java.util.List;

class MessageShareActivity$1
  implements Runnable
{
  MessageShareActivity$1(MessageShareActivity paramMessageShareActivity, List paramList, AbsStructMsg paramAbsStructMsg, String paramString, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator;
    if ((this.rC != null) && (!this.rC.isEmpty())) {
      localIterator = this.rC.iterator();
    }
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      StructMsgForImageShare.sendAndUploadImageShare(this.this$0.app, (StructMsgForImageShare)this.a, localResultRecord.uin, localResultRecord.lk(), null, 0);
      continue;
      StructMsgForImageShare.sendAndUploadImageShare(this.this$0.app, (StructMsgForImageShare)this.a, this.SO, this.alR, null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MessageShareActivity.1
 * JD-Core Version:    0.7.0.1
 */