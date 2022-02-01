package dov.com.qq.im.ae.camera.core;

import awwi;

class AECameraGLSurfaceView$14
  implements Runnable
{
  AECameraGLSurfaceView$14(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void run()
  {
    if (AECameraGLSurfaceView.a(this.this$0) != null) {
      AECameraGLSurfaceView.a(this.this$0).a(true, AECameraGLSurfaceView.a(this.this$0), this.this$0);
    }
    this.this$0.requestRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.14
 * JD-Core Version:    0.7.0.1
 */