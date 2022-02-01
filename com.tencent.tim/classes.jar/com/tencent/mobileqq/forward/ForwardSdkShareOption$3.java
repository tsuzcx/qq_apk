package com.tencent.mobileqq.forward;

import ahkr;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;

public class ForwardSdkShareOption$3
  implements Runnable
{
  public ForwardSdkShareOption$3(ahkr paramahkr, AbsStructMsg paramAbsStructMsg, String paramString, int paramInt) {}
  
  public void run()
  {
    StructMsgForImageShare.sendAndUploadImageShare(this.this$0.app, (StructMsgForImageShare)this.a, this.SO, this.alR, null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.3
 * JD-Core Version:    0.7.0.1
 */