package com.tencent.mobileqq.ar.arengine;

import adid;
import adie;
import android.content.Context;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class ARLocalControl$1
  implements Runnable
{
  public ARLocalControl$1(adid paramadid, int paramInt1, int paramInt2, Context paramContext, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo, long paramLong) {}
  
  public void run()
  {
    if ((adid.a(this.this$0) & 0x4) != 0L)
    {
      ??? = new ARFacePreviewResample();
      ((ARFacePreviewResample)???).init(this.val$imageWidth, this.val$imageHeight, 17);
      int i = ((ARFacePreviewResample)???).BM();
      int j = ((ARFacePreviewResample)???).BN();
      this.this$0.a = new adie();
      this.this$0.a.a((ARFacePreviewResample)???);
      if (!this.this$0.a.a(this.val$context, i, j, this.b, this.this$0)) {
        this.this$0.a = null;
      }
    }
    synchronized (adid.access$100())
    {
      adid.a(this.this$0, true);
      adid.access$100().notifyAll();
      QLog.i("AREngine_ARLocalControl", 1, String.format("initFaceRecogAsync end. time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.val$begin) }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalControl.1
 * JD-Core Version:    0.7.0.1
 */