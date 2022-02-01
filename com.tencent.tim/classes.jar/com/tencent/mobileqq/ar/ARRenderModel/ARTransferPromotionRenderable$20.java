package com.tencent.mobileqq.ar.ARRenderModel;

import addg;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$20
  implements Runnable
{
  public ARTransferPromotionRenderable$20(addg paramaddg, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3) {}
  
  public void run()
  {
    addg.b(this.this$0, addg.f(this.this$0) + this.kt.length);
    QLog.i("ARTransferPromotionRenderable", 1, "insertWorldCupSpark. mInsertedSparkTotalCnt = " + addg.f(this.this$0) + ", new cnt = " + this.kt.length + ", px[0] = " + this.kt[0] + ", py[0] = " + this.ku[0] + ", degree[0] = " + this.kv[0] + ", hasDrawedFrame = " + addg.e(this.this$0));
    if ((addg.a(this.this$0) != null) && (addg.e(this.this$0))) {
      addg.a(this.this$0).native_insertWorldCupSpark(this.kt, this.ku, this.kv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.20
 * JD-Core Version:    0.7.0.1
 */