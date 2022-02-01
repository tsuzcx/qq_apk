package com.tencent.mobileqq.ar.ARRenderModel;

import addw;
import android.graphics.SurfaceTexture;

public class OnlineVideoARRenderable$2
  implements Runnable
{
  public OnlineVideoARRenderable$2(addw paramaddw) {}
  
  public void run()
  {
    if (addw.a(this.this$0)) {}
    try
    {
      addw.a(this.this$0).updateTexImage();
      addw.a(this.this$0).getTransformMatrix(addw.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.2
 * JD-Core Version:    0.7.0.1
 */