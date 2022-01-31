package com.tencent.token.ui;

import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.global.e;

final class bp
  implements Runnable
{
  bp(BindUinActivity paramBindUinActivity) {}
  
  public final void run()
  {
    if (!BindUinActivity.access$000(this.a)) {
      return;
    }
    e.a("send bind seq request:" + BindUinActivity.access$100(this.a));
    ag.c().n();
    if (BindUinActivity.access$200(this.a) == 13) {
      af.a().a(0L, Long.parseLong(BindUinActivity.access$300(this.a)), 1006, this.a.mHandler);
    }
    for (;;)
    {
      BindUinActivity.access$108(this.a);
      return;
      af.a().a(0L, Long.parseLong(BindUinActivity.access$300(this.a)), 1004, this.a.mHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.bp
 * JD-Core Version:    0.7.0.1
 */