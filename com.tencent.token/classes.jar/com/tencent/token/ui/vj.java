package com.tencent.token.ui;

import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.utils.t;

final class vj
  implements Runnable
{
  vj(RealNameFindActivity paramRealNameFindActivity) {}
  
  public final void run()
  {
    RealNameFindActivity.access$1502(this.a, t.a(RealNameFindActivity.access$600(this.a)));
    RealNameFindActivity.access$1702(this.a, t.a(RealNameFindActivity.access$700(this.a)));
    if (ag.c().g())
    {
      af.a().a(RealNameFindActivity.access$400(this.a));
      return;
    }
    af.a().a(0L, RealNameFindActivity.access$300(this.a), RealNameFindActivity.access$000(this.a), "", "", RealNameFindActivity.access$1000(this.a), RealNameFindActivity.access$1600(this.a, RealNameFindActivity.access$1500(this.a)), RealNameFindActivity.access$1600(this.a, RealNameFindActivity.access$1700(this.a)), RealNameFindActivity.access$800(this.a), RealNameFindActivity.access$900(this.a), RealNameFindActivity.access$400(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vj
 * JD-Core Version:    0.7.0.1
 */