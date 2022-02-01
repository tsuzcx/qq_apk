package com.tencent.mobileqq.ar.ARRenderModel;

import addg;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$19
  implements Runnable
{
  public ARTransferPromotionRenderable$19(addg paramaddg, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    addg.b(this.this$0, 0);
    QLog.i("ARTransferPromotionRenderable", 1, "setRecogRes. mInsertedSparkTotalCnt = 0, sparkShaderVertFileName = , circleR = " + this.cCQ + ", circleX = " + this.cCR + ", circleY = " + this.cCS + ", clockwise = " + this.cCT + ", hasDrawedFrame = " + addg.e(this.this$0));
    if ((addg.a(this.this$0) != null) && (addg.e(this.this$0))) {
      addg.a(this.this$0).native_setRecogRes("", "", "", "", "", this.cCQ, this.cCR, this.cCS, this.cCT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.19
 * JD-Core Version:    0.7.0.1
 */