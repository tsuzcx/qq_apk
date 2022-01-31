package com.tencent.token.ui;

import com.tencent.token.af;
import com.tencent.token.global.e;

final class wx
  implements Runnable
{
  wx(RealNameStep0VerifyMobileUpActivity paramRealNameStep0VerifyMobileUpActivity) {}
  
  public final void run()
  {
    e.a("realname vrysms thread run, sceneid=" + RealNameStep0VerifyMobileUpActivity.access$000(this.a));
    af.a().a(0L, RealNameStep0VerifyMobileUpActivity.access$100(this.a), RealNameStep0VerifyMobileUpActivity.access$000(this.a), RealNameStep0VerifyMobileUpActivity.access$200(this.a));
    RealNameStep0VerifyMobileUpActivity.access$308(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wx
 * JD-Core Version:    0.7.0.1
 */