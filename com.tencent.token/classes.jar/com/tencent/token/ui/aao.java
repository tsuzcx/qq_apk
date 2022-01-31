package com.tencent.token.ui;

import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.global.e;

final class aao
  implements Runnable
{
  aao(SmsContentTipActivity paramSmsContentTipActivity) {}
  
  public final void run()
  {
    if (!SmsContentTipActivity.access$000(this.a)) {
      return;
    }
    e.a("send bind seq request:" + SmsContentTipActivity.access$100(this.a));
    ag.c().n();
    af.a().a(0L, Long.parseLong(SmsContentTipActivity.access$200(this.a)), SmsContentTipActivity.access$300(this.a), this.a.mHandler);
    SmsContentTipActivity.access$108(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aao
 * JD-Core Version:    0.7.0.1
 */