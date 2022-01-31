package com.tencent.token.ui;

import android.widget.EditText;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.utils.x;

class uu
  implements Runnable
{
  uu(RealNameFindActivity paramRealNameFindActivity) {}
  
  public void run()
  {
    RealNameFindActivity.access$2602(this.a, x.a(RealNameFindActivity.access$1200(this.a), 960, 960, 153600));
    RealNameFindActivity.access$2802(this.a, x.a(RealNameFindActivity.access$1300(this.a), 960, 960, 153600));
    if (cx.c().g())
    {
      cw.a().a(RealNameFindActivity.access$1000(this.a));
      return;
    }
    cw.a().a(0L, RealNameFindActivity.access$900(this.a), RealNameFindActivity.access$000(this.a), RealNameFindActivity.access$2400(this.a).getText().toString(), RealNameFindActivity.access$2500(this.a).getText().toString(), RealNameFindActivity.access$1600(this.a), RealNameFindActivity.access$2700(this.a, RealNameFindActivity.access$2600(this.a)), RealNameFindActivity.access$2700(this.a, RealNameFindActivity.access$2800(this.a)), RealNameFindActivity.access$1400(this.a), RealNameFindActivity.access$1500(this.a), RealNameFindActivity.access$1000(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.uu
 * JD-Core Version:    0.7.0.1
 */