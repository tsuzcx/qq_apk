package com.tencent.biz.qrcode.activity;

import android.view.View;
import ruq;

public class QRDisplayActivity$23
  implements Runnable
{
  QRDisplayActivity$23(QRDisplayActivity paramQRDisplayActivity, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.aJQ)
    {
      this.this$0.pn.setOnClickListener(null);
      this.this$0.pn.setClickable(false);
      this.this$0.pn.setOnTouchListener(new ruq(this));
      return;
    }
    this.this$0.pn.setClickable(true);
    this.this$0.pn.setOnClickListener(this.this$0);
    this.this$0.pn.setTouchDelegate(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.23
 * JD-Core Version:    0.7.0.1
 */