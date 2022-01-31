package com.tencent.token.ui;

import com.tencent.token.cw;
import com.tencent.token.global.h;

class wh
  implements Runnable
{
  wh(RealNameStep0VerifyMobileUpActivity paramRealNameStep0VerifyMobileUpActivity) {}
  
  public void run()
  {
    h.a("realname vrysms thread run, sceneid=" + RealNameStep0VerifyMobileUpActivity.access$000(this.a));
    cw.a().a(0L, RealNameStep0VerifyMobileUpActivity.access$100(this.a), RealNameStep0VerifyMobileUpActivity.access$000(this.a), 0, RealNameStep0VerifyMobileUpActivity.access$200(this.a));
    RealNameStep0VerifyMobileUpActivity.access$308(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wh
 * JD-Core Version:    0.7.0.1
 */