package com.tencent.mobileqq.activity.qwallet.emoj;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openai.ttpicmodule.AEHandDetector;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class HandRecognizer$2
  implements Runnable
{
  HandRecognizer$2(HandRecognizer paramHandRecognizer, Camera paramCamera, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, HandRecognizer.OnPreviewFrameHandlerListener paramOnPreviewFrameHandlerListener) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = this.val$camera.getParameters();
      Object localObject2 = new YuvImage(this.val$data, ((Camera.Parameters)localObject1).getPreviewFormat(), this.val$imagewidth, this.val$imageheight, null);
      localObject1 = new ByteArrayOutputStream();
      ((YuvImage)localObject2).compressToJpeg(new Rect(0, 0, this.val$imagewidth, this.val$imageheight), 80, (OutputStream)localObject1);
      localObject2 = ((ByteArrayOutputStream)localObject1).toByteArray();
      localObject2 = BitmapFactory.decodeByteArray((byte[])localObject2, 0, localObject2.length);
      if (!BitmapUtils.isLegal((Bitmap)localObject2)) {
        return;
      }
      localObject2 = BitmapUtils.rotateBitmap((Bitmap)localObject2, 270);
      ((ByteArrayOutputStream)localObject1).close();
      localObject1 = HandRecognizer.access$000(this.this$0).detect((Bitmap)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i(HandRecognizer.TAG, 2, "【onPreviewFrameHandler】 index: " + this.val$index + " handType," + ((PTHandAttr)localObject1).getHandTypeIndex());
      }
      if ((localObject1 != null) && (((PTHandAttr)localObject1).getHandTypeIndex() == this.val$index))
      {
        int i = (int)(((PTHandAttr)localObject1).getConfidence() * 100.0F);
        if (QLog.isColorLevel()) {
          QLog.i(HandRecognizer.TAG, 2, "【onPreviewFrameHandler】 resultVal: " + i);
        }
        if (this.val$listener == null) {
          return;
        }
        this.val$listener.getHandRecognizeResult(i);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e(HandRecognizer.TAG, 1, "【onPreviewFrameHandler】 recognize hand error " + QLog.getStackTraceString(localThrowable));
      return;
    }
    if ((QLog.isColorLevel()) && (localThrowable != null)) {
      QLog.i(HandRecognizer.TAG, 2, "【onPreviewFrameHandler】 handType " + localThrowable.getHandTypeIndex() + " can't match the index: " + this.val$index);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.HandRecognizer.2
 * JD-Core Version:    0.7.0.1
 */