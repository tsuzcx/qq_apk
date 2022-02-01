package com.tencent.mobileqq.ar.ARRenderModel;

import adda;
import addg;
import addi;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$13
  implements Runnable
{
  public ARTransferPromotionRenderable$13(addg paramaddg, int paramInt) {}
  
  public void run()
  {
    QLog.d("ARTransferPromotionRenderable", 2, "switchGameStatus run status " + this.cCN);
    switch (this.cCN)
    {
    }
    for (;;)
    {
      addg.e(this.this$0);
      return;
      if ((this.cCN == 1) && (addg.a(this.this$0) != null) && (addg.a(this.this$0).ao.booleanValue())) {
        addg.a(this.this$0).hg(0, 1);
      }
      if (addg.a(this.this$0) != null)
      {
        addg.a(this.this$0).native_switchGameStatusWithNoParams(this.cCN);
        continue;
        if (this.this$0.cCJ == 3)
        {
          if (addg.a(this.this$0) != null) {
            addg.a(this.this$0).native_switchGameStatusWithNoParams(this.cCN);
          }
        }
        else {
          addg.a(this.this$0, 4, addg.a(this.this$0).bsf + "360Video.mp4", false, addg.a(this.this$0).cCU, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.13
 * JD-Core Version:    0.7.0.1
 */