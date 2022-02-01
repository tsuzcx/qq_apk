package com.tencent.mobileqq.forward;

import ahkr;
import ahkw;
import ahlw;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;

public class ForwardSdkShareOption$2
  implements Runnable
{
  public ForwardSdkShareOption$2(ahkr paramahkr, AbsStructMsg paramAbsStructMsg, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    ahlw.Kj("KEY_STAGE_2_UPLOAD_IMAGE");
    StructMsgForImageShare.sendAndUploadImageShare(this.this$0.app, (StructMsgForImageShare)this.a, this.SO, this.alR, null, 0, new ahkw(this), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.2
 * JD-Core Version:    0.7.0.1
 */