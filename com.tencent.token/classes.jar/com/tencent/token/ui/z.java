package com.tencent.token.ui;

import com.tencent.token.cw;
import com.tencent.token.cx;

class z
  implements Runnable
{
  z(AccountPageActivity paramAccountPageActivity) {}
  
  public void run()
  {
    if (cx.c().g()) {
      return;
    }
    cw.a().e(this.a.mHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.z
 * JD-Core Version:    0.7.0.1
 */