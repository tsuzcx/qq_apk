package com.tencent.mobileqq.forward;

import ahij;
import ahil;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import java.util.Map;

public class ForwardMultServerShare$2
  implements Runnable
{
  public ForwardMultServerShare$2(ahij paramahij, ResultRecord paramResultRecord, Map paramMap) {}
  
  public void run()
  {
    StructMsgForImageShare.sendAndUploadImageShare(ahij.a(this.this$0), (StructMsgForImageShare)ahij.a(this.this$0), this.c.uin, this.c.uinType, null, 0, new ahil(this), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMultServerShare.2
 * JD-Core Version:    0.7.0.1
 */