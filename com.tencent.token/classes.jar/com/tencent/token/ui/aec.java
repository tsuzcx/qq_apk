package com.tencent.token.ui;

import com.tencent.token.cw;
import com.tencent.token.global.h;

class aec
  implements Runnable
{
  aec(UtilsModSetMobileStep2SmsActivity paramUtilsModSetMobileStep2SmsActivity) {}
  
  public void run()
  {
    h.c("send mod set mbmobile");
    cw.a().a(0L, UtilsModSetMobileStep2SmsActivity.access$000(this.a), UtilsModSetMobileStep2SmsActivity.access$100(this.a), UtilsModSetMobileStep2SmsActivity.access$200(this.a), UtilsModSetMobileStep2SmsActivity.access$300(this.a), UtilsModSetMobileStep2SmsActivity.access$400(this.a));
    UtilsModSetMobileStep2SmsActivity.access$508(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aec
 * JD-Core Version:    0.7.0.1
 */