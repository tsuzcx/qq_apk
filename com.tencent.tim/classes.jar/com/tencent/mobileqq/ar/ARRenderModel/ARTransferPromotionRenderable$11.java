package com.tencent.mobileqq.ar.ARRenderModel;

import adbl;
import adbn;
import adda;
import addg;
import addi;

public class ARTransferPromotionRenderable$11
  implements Runnable
{
  public ARTransferPromotionRenderable$11(addg paramaddg) {}
  
  public void run()
  {
    if (addg.a(this.this$0) == 6)
    {
      if ((addg.a(this.this$0) != null) && (!addg.a(this.this$0).ao.booleanValue())) {
        addg.a(this.this$0).hg(0, 1);
      }
      if (((addg.a(this.this$0).Bu() != 0) && (addg.c(this.this$0))) || (addg.a(this.this$0).ao.booleanValue())) {
        break label124;
      }
      this.this$0.cPQ();
    }
    for (;;)
    {
      if (addg.a(this.this$0) == null) {
        addg.a(this.this$0, new adbl());
      }
      return;
      label124:
      if (!addg.a(this.this$0).ao.booleanValue()) {
        addg.a(this.this$0).Kx(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.11
 * JD-Core Version:    0.7.0.1
 */