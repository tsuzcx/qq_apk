package dov.com.qq.im.ae.camera.core;

import android.graphics.PointF;
import awwg;

class AECameraGLSurfaceView$18
  implements Runnable
{
  AECameraGLSurfaceView$18(AECameraGLSurfaceView paramAECameraGLSurfaceView, awwg paramawwg, float paramFloat1, float paramFloat2, int paramInt) {}
  
  public void run()
  {
    this.a.addTouchPoint(new PointF(this.val$x, this.val$y), this.val$screenWidth);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.18
 * JD-Core Version:    0.7.0.1
 */