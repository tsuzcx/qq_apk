package com.tencent.token.ui;

import com.tencent.token.cw;
import com.tencent.token.global.h;

class zh
  implements Runnable
{
  zh(SmsContentTipActivity paramSmsContentTipActivity) {}
  
  public void run()
  {
    h.c("send mod set mbmobile");
    cw.a().a(0L, SmsContentTipActivity.access$500(this.a), SmsContentTipActivity.access$600(this.a), SmsContentTipActivity.access$700(this.a), SmsContentTipActivity.access$800(this.a), this.a.mHandler);
    SmsContentTipActivity.access$908(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zh
 * JD-Core Version:    0.7.0.1
 */