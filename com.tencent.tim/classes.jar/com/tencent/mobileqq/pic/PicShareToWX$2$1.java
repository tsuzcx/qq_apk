package com.tencent.mobileqq.pic;

import akxu;
import eipc.EIPCResult;

public class PicShareToWX$2$1
  implements Runnable
{
  public PicShareToWX$2$1(akxu paramakxu, EIPCResult paramEIPCResult) {}
  
  public void run()
  {
    PicShareToWX.a().stopLoading();
    if (this.b.code != 0) {
      PicShareToWX.a().dDW();
    }
    PicShareToWX.a().reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicShareToWX.2.1
 * JD-Core Version:    0.7.0.1
 */