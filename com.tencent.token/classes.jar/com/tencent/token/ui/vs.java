package com.tencent.token.ui;

import com.tencent.token.af;
import com.tencent.token.global.e;

final class vs
  implements Runnable
{
  vs(RealNameSmsContentTipActivity paramRealNameSmsContentTipActivity) {}
  
  public final void run()
  {
    e.a("realname vrysms thread run, sceneid=" + RealNameSmsContentTipActivity.access$000(this.a));
    af.a().a(0L, RealNameSmsContentTipActivity.access$100(this.a), RealNameSmsContentTipActivity.access$000(this.a), this.a.mHandler);
    RealNameSmsContentTipActivity.access$208(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vs
 * JD-Core Version:    0.7.0.1
 */