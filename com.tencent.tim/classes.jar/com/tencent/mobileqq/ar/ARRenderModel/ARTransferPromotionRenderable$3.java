package com.tencent.mobileqq.ar.ARRenderModel;

import adbo;
import addg;
import addi;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$3
  implements Runnable
{
  public ARTransferPromotionRenderable$3(addg paramaddg) {}
  
  public void run()
  {
    addg.a(this.this$0, adbo.a(addg.a(this.this$0).bsf));
    if (addg.a(this.this$0) != null)
    {
      QLog.d("ARTransferPromotionRenderable", 2, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo " + addg.a(this.this$0));
      return;
    }
    QLog.d("ARTransferPromotionRenderable", 1, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo value null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.3
 * JD-Core Version:    0.7.0.1
 */