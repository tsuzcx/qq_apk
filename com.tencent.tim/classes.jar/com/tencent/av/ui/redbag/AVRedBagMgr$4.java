package com.tencent.av.ui.redbag;

import jht;
import jij;
import jil;

public class AVRedBagMgr$4
  implements Runnable
{
  public AVRedBagMgr$4(jht paramjht, jil paramjil) {}
  
  public void run()
  {
    if (this.a.xw()) {
      this.this$0.a(this.this$0.getAVActivity(), this.a);
    }
    do
    {
      return;
      jht.a(jht.c(this.this$0), this.a);
    } while (!this.a.xv());
    jij.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBagMgr.4
 * JD-Core Version:    0.7.0.1
 */