package dov.com.qq.im.ae.camera.core;

import axcm;

class AECameraGLSurfaceView$2
  implements Runnable
{
  AECameraGLSurfaceView$2(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void run()
  {
    if (AECameraGLSurfaceView.a(this.this$0) != null)
    {
      AECameraGLSurfaceView.a(this.this$0).clear();
      AECameraGLSurfaceView.a(this.this$0, null);
    }
    AECameraGLSurfaceView.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.2
 * JD-Core Version:    0.7.0.1
 */