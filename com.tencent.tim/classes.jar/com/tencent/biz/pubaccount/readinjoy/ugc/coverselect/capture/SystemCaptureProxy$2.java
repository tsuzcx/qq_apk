package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import mlu;
import mlu.a;
import mmb;

public class SystemCaptureProxy$2
  implements Runnable
{
  public SystemCaptureProxy$2(mmb parammmb, mlu parammlu, mlu.a parama) {}
  
  public void run()
  {
    if (mmb.a(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemCaptureProxy", 2, "capture return for released.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemCaptureProxy", 2, "capture captureTask:" + this.jdField_c_of_type_Mlu + "  useScaleAPI:" + mmb.b(this.this$0));
    }
    for (Object localObject = null;; localObject = localBitmap2)
    {
      try
      {
        if ((!mmb.b(this.this$0)) || (Build.VERSION.SDK_INT < 27)) {
          break label167;
        }
        localBitmap2 = mmb.a(this.this$0).getScaledFrameAtTime(this.jdField_c_of_type_Mlu.position * 1000, 0, this.jdField_c_of_type_Mlu.width, this.jdField_c_of_type_Mlu.height);
        localObject = localBitmap2;
      }
      catch (Error localError)
      {
        for (;;)
        {
          Bitmap localBitmap2;
          mmb.a(this.this$0, false);
          Bitmap localBitmap1 = mmb.a(this.this$0, mmb.a(this.this$0), this.jdField_c_of_type_Mlu);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          label167:
          QLog.e("SystemCaptureProxy", 1, "capture failed for captureTask" + this.jdField_c_of_type_Mlu, localThrowable);
        }
        this.jdField_c_of_type_Mlu$a.aPX();
      }
      if (this.jdField_c_of_type_Mlu$a == null) {
        break;
      }
      if ((localObject == null) || (localObject.isRecycled())) {
        break label256;
      }
      this.jdField_c_of_type_Mlu$a.a(localObject, this.jdField_c_of_type_Mlu);
      return;
      localBitmap2 = mmb.a(this.this$0, mmb.a(this.this$0), this.jdField_c_of_type_Mlu);
    }
    label256:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.SystemCaptureProxy.2
 * JD-Core Version:    0.7.0.1
 */