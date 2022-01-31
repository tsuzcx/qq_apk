package com.tencent.token.ui;

import com.tencent.token.af;
import com.tencent.token.ag;

final class v
  implements Runnable
{
  v(AccountPageActivity paramAccountPageActivity) {}
  
  public final void run()
  {
    if (ag.c().g()) {
      return;
    }
    af.a().e(this.a.mHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.v
 * JD-Core Version:    0.7.0.1
 */