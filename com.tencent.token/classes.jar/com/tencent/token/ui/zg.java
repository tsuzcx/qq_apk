package com.tencent.token.ui;

import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.global.h;

class zg
  implements Runnable
{
  zg(SmsContentTipActivity paramSmsContentTipActivity) {}
  
  public void run()
  {
    if (!SmsContentTipActivity.access$000(this.a)) {
      return;
    }
    h.a("send bind seq request:" + SmsContentTipActivity.access$100(this.a));
    cx.c().n();
    int i = 0;
    if (SmsContentTipActivity.access$200(this.a) != null) {
      i = SmsContentTipActivity.access$200(this.a).a();
    }
    cw.a().a(0L, Long.parseLong(SmsContentTipActivity.access$300(this.a)), SmsContentTipActivity.access$400(this.a), i, this.a.mHandler);
    SmsContentTipActivity.access$108(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zg
 * JD-Core Version:    0.7.0.1
 */