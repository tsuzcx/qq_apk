package com.tencent.ttpic.openapi.filter.stylizefilter;

import android.graphics.Bitmap;
import com.microrapid.opencv.ImageAutoProcessor;
import com.tencent.ttpic.baseutils.log.LogUtils;

class BiExponetialEdgeSmooth$1
  implements Runnable
{
  BiExponetialEdgeSmooth$1(BiExponetialEdgeSmooth paramBiExponetialEdgeSmooth, Bitmap paramBitmap) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Bitmap localBitmap = this.val$src.copy(this.val$src.getConfig(), this.val$src.isMutable());
    ImageAutoProcessor.nativeDenoiseBEEPS(this.val$src, localBitmap);
    this.val$src.recycle();
    if (BiExponetialEdgeSmooth.access$000(this.this$0))
    {
      localBitmap.recycle();
      LogUtils.i("BiExponetialEdgeSmooth", "去噪完成，但是已被clear。");
    }
    for (;;)
    {
      BiExponetialEdgeSmooth.access$202(this.this$0, false);
      return;
      if (BiExponetialEdgeSmooth.access$100(this.this$0) != null) {
        BiExponetialEdgeSmooth.access$100(this.this$0).recycle();
      }
      BiExponetialEdgeSmooth.access$102(this.this$0, localBitmap);
      LogUtils.i("BiExponetialEdgeSmooth", "去噪完成，赋值成功。耗时：" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.BiExponetialEdgeSmooth.1
 * JD-Core Version:    0.7.0.1
 */