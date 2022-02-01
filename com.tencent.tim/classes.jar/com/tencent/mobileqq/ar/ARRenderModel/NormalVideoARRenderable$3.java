package com.tencent.mobileqq.ar.ARRenderModel;

import addt;
import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

public class NormalVideoARRenderable$3
  implements Runnable
{
  public NormalVideoARRenderable$3(addt paramaddt) {}
  
  @TargetApi(11)
  public void run()
  {
    try
    {
      addt.a(this.this$0).updateTexImage();
      addt.a(this.this$0).getTransformMatrix(addt.a(this.this$0));
      if (ScanTorchActivity.cul)
      {
        addt localaddt = this.this$0;
        localaddt.St += 1L;
        if (this.this$0.St >= 30L)
        {
          this.this$0.St = 0L;
          long l = System.currentTimeMillis();
          float f = 30000.0F / (float)(l - this.this$0.lastFrameUpdateTime);
          this.this$0.lastFrameUpdateTime = l;
          QLog.d("render", 2, "video fetch=" + f);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localThrowable.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.NormalVideoARRenderable.3
 * JD-Core Version:    0.7.0.1
 */