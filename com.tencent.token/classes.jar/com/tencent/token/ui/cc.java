package com.tencent.token.ui;

import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.global.h;

class cc
  implements Runnable
{
  cc(BindUinActivity paramBindUinActivity) {}
  
  public void run()
  {
    if (!BindUinActivity.access$000(this.a)) {
      return;
    }
    h.a("send bind seq request:" + BindUinActivity.access$100(this.a));
    cx.c().n();
    if (BindUinActivity.access$200(this.a) == 13) {
      cw.a().a(0L, Long.parseLong(BindUinActivity.access$300(this.a)), 1006, 0, this.a.mHandler);
    }
    for (;;)
    {
      BindUinActivity.access$108(this.a);
      return;
      cw.a().a(0L, Long.parseLong(BindUinActivity.access$300(this.a)), 1004, 0, this.a.mHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cc
 * JD-Core Version:    0.7.0.1
 */