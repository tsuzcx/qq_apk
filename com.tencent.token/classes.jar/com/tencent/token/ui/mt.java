package com.tencent.token.ui;

import com.tencent.token.af;
import com.tencent.token.ag;

final class mt
  implements Runnable
{
  mt(IndexActivity paramIndexActivity) {}
  
  public final void run()
  {
    if (ag.c().g()) {
      return;
    }
    af.a().e(IndexActivity.access$300(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.mt
 * JD-Core Version:    0.7.0.1
 */