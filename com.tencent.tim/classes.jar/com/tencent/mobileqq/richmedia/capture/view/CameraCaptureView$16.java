package com.tencent.mobileqq.richmedia.capture.view;

import android.graphics.Bitmap;
import aqhq;
import aqhu;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.io.IOException;

class CameraCaptureView$16
  implements Runnable
{
  CameraCaptureView$16(CameraCaptureView paramCameraCaptureView, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str = this.this$0.a.bZj + "/" + System.currentTimeMillis() + ".jpg";
    aqhq.UD(str);
    File localFile = new File(str);
    try
    {
      aqhu.a(this.gb, localFile);
      aqhu.cn(BaseApplicationImpl.getContext(), localFile.getAbsolutePath());
      this.this$0.b(new CameraCaptureView.h(0, 0, str, null, this.this$0.orientation));
      this.gb.recycle();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        this.this$0.b(new CameraCaptureView.h(0, -1, str, null, this.this$0.orientation));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.16
 * JD-Core Version:    0.7.0.1
 */