package com.tencent.token.ui;

import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.global.h;

class aay
  implements Runnable
{
  aay(UnbindUinActivity paramUnbindUinActivity) {}
  
  public void run()
  {
    h.a("send unbind seq request:" + this.a.mUnBindRetryTimes);
    if (!UnbindUinActivity.access$000(this.a)) {
      return;
    }
    cx.c().n();
    cw.a().a(UnbindUinActivity.access$100(this.a), UnbindUinActivity.access$200(this.a), 1005, 0, this.a.handler);
    UnbindUinActivity localUnbindUinActivity = this.a;
    localUnbindUinActivity.mUnBindRetryTimes += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aay
 * JD-Core Version:    0.7.0.1
 */