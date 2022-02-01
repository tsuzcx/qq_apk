package com.tencent.jalpha.videoplayer.view;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;

class JalphaTextureView$9
  implements SurfaceTexture.OnFrameAvailableListener
{
  JalphaTextureView$9(JalphaTextureView paramJalphaTextureView) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.this$0.requestRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.view.JalphaTextureView.9
 * JD-Core Version:    0.7.0.1
 */