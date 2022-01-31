package com.tencent.token.ui;

import com.tencent.token.af;
import com.tencent.token.global.e;

final class afo
  implements Runnable
{
  afo(UtilsModSetMobileStep2SmsActivity paramUtilsModSetMobileStep2SmsActivity) {}
  
  public final void run()
  {
    e.c("send mod set mbmobile");
    af.a().a(0L, UtilsModSetMobileStep2SmsActivity.access$000(this.a), UtilsModSetMobileStep2SmsActivity.access$100(this.a), UtilsModSetMobileStep2SmsActivity.access$200(this.a), UtilsModSetMobileStep2SmsActivity.access$300(this.a));
    UtilsModSetMobileStep2SmsActivity.access$408(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afo
 * JD-Core Version:    0.7.0.1
 */