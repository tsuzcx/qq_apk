package com.tencent.token.ui;

import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.e;

final class aar
  implements Runnable
{
  aar(SmsContentTipActivity paramSmsContentTipActivity) {}
  
  public final void run()
  {
    e.a("send unbind seq request:" + SmsContentTipActivity.access$800(this.a));
    if (!SmsContentTipActivity.access$000(this.a)) {
      return;
    }
    ag.c().n();
    af.a().a(SmsContentTipActivity.access$900(this.a).mUin, SmsContentTipActivity.access$900(this.a).mRealUin, 1005, this.a.mHandler);
    SmsContentTipActivity.access$808(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aar
 * JD-Core Version:    0.7.0.1
 */