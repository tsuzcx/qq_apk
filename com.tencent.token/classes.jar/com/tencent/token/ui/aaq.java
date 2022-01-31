package com.tencent.token.ui;

import com.tencent.token.af;
import com.tencent.token.global.e;

final class aaq
  implements Runnable
{
  aaq(SmsContentTipActivity paramSmsContentTipActivity) {}
  
  public final void run()
  {
    e.c("send mod set mbmobile");
    af.a().a(0L, SmsContentTipActivity.access$400(this.a), SmsContentTipActivity.access$500(this.a), SmsContentTipActivity.access$600(this.a), this.a.mHandler);
    SmsContentTipActivity.access$708(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aaq
 * JD-Core Version:    0.7.0.1
 */