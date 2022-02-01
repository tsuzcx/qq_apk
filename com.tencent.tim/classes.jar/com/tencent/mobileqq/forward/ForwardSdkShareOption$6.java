package com.tencent.mobileqq.forward;

import ahgg.a;
import ahkr;
import android.app.Activity;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class ForwardSdkShareOption$6
  implements Runnable
{
  public ForwardSdkShareOption$6(ahkr paramahkr) {}
  
  public void run()
  {
    if (this.this$0.mActivity.isFinishing()) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->preForward--fetch openid timeout");
      }
      this.this$0.aRg = true;
      this.this$0.hideProgressDialog();
    } while (!ahkr.a(this.this$0));
    this.this$0.bf.putString("uin", String.valueOf("-1010"));
    this.this$0.bf.putInt("uintype", -1);
    this.this$0.bf.putInt("key_forward_ability_type", ahgg.a.V.intValue());
    this.this$0.dnB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.6
 * JD-Core Version:    0.7.0.1
 */