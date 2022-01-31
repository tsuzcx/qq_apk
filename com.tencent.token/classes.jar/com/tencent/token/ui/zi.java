package com.tencent.token.ui;

import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.global.h;

class zi
  implements Runnable
{
  zi(SmsContentTipActivity paramSmsContentTipActivity) {}
  
  public void run()
  {
    h.a("send unbind seq request:" + SmsContentTipActivity.access$1000(this.a));
    if (!SmsContentTipActivity.access$000(this.a)) {
      return;
    }
    cx.c().n();
    cw.a().a(SmsContentTipActivity.access$1100(this.a).mUin, SmsContentTipActivity.access$1100(this.a).mRealUin, 1005, 0, this.a.mHandler);
    SmsContentTipActivity.access$1008(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zi
 * JD-Core Version:    0.7.0.1
 */