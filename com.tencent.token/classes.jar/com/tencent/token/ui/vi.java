package com.tencent.token.ui;

import com.tencent.token.cw;
import com.tencent.token.global.h;

class vi
  implements Runnable
{
  vi(RealNameSmsContentTipActivity paramRealNameSmsContentTipActivity) {}
  
  public void run()
  {
    h.a("realname vrysms thread run, sceneid=" + RealNameSmsContentTipActivity.access$000(this.a));
    cw.a().a(0L, RealNameSmsContentTipActivity.access$100(this.a), RealNameSmsContentTipActivity.access$000(this.a), 0, this.a.mHandler);
    RealNameSmsContentTipActivity.access$208(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vi
 * JD-Core Version:    0.7.0.1
 */