package com.tencent.token.ui;

import com.tencent.token.cw;
import com.tencent.token.cx;

class li
  implements Runnable
{
  li(IndexActivity paramIndexActivity) {}
  
  public void run()
  {
    if (cx.c().g()) {
      return;
    }
    cw.a().e(IndexActivity.access$100(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.li
 * JD-Core Version:    0.7.0.1
 */