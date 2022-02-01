package com.tencent.mobileqq.forward;

import ahgf;
import ahhh;
import ahhi;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import tencent.im.oidb.oidb_0xd55.RspBody;

public class ForwardD55Manager$1$1
  implements Runnable
{
  public ForwardD55Manager$1$1(ahhi paramahhi, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    ahgf localahgf = new ahgf();
    oidb_0xd55.RspBody localRspBody = ForwardUtils.a(this.val$data);
    if (localRspBody != null) {
      ahgf.a(localRspBody, this.a.abn, localahgf);
    }
    ahhh.a(this.a.a, this.val$errorCode);
    ahhh.a(this.a.a, localahgf);
    this.a.a.a(this.a.Y, localahgf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardD55Manager.1.1
 * JD-Core Version:    0.7.0.1
 */