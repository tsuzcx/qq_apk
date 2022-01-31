package com.tencent.token.ui;

import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.utils.t;

final class vt
  implements Runnable
{
  vt(RealNameSmsContentTipActivity paramRealNameSmsContentTipActivity) {}
  
  public final void run()
  {
    this.a.mFrontData = t.a(this.a.mFrontPath);
    this.a.mBackData = t.a(this.a.mBackPath);
    if (ag.c().g())
    {
      af.a().a(this.a.mHandler);
      return;
    }
    af.a().a(0L, RealNameSmsContentTipActivity.access$100(this.a), 2, "", "", this.a.mFaceData, RealNameSmsContentTipActivity.access$300(this.a, this.a.mFrontData), RealNameSmsContentTipActivity.access$300(this.a, this.a.mBackData), this.a.frontphotoinfo, this.a.backphotoinfo, this.a.mHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vt
 * JD-Core Version:    0.7.0.1
 */