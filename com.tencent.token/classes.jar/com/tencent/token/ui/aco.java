package com.tencent.token.ui;

import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.global.e;

final class aco
  implements Runnable
{
  aco(UnbindUinActivity paramUnbindUinActivity) {}
  
  public final void run()
  {
    e.a("send unbind seq request:" + this.a.mUnBindRetryTimes);
    if (!UnbindUinActivity.access$000(this.a)) {
      return;
    }
    ag.c().n();
    af.a().a(UnbindUinActivity.access$100(this.a), UnbindUinActivity.access$200(this.a), 1005, this.a.handler);
    UnbindUinActivity localUnbindUinActivity = this.a;
    localUnbindUinActivity.mUnBindRetryTimes += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aco
 * JD-Core Version:    0.7.0.1
 */