import android.graphics.SurfaceTexture;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.e;

class awua
  implements AECameraGLSurfaceView.e
{
  awua(awtq paramawtq) {}
  
  public void adl(int paramInt)
  {
    awtq.a(this.this$0).a(paramInt, new awub(this));
  }
  
  public void eGo()
  {
    axiy.i("AEPituCameraUnit", "onPreviewSurfaceTextureRelease---" + awtq.a(this.this$0));
    awtq.a(this.this$0, null);
  }
  
  public void eGp()
  {
    axgk.a().acy("onFirstFrameDone");
    awtq.i(this.this$0);
  }
  
  public void eGq()
  {
    awtq.a(this.this$0).c(new awuc(this));
  }
  
  public void g(SurfaceTexture paramSurfaceTexture)
  {
    awtq.a(this.this$0, paramSurfaceTexture);
    axiy.i("AEPituCameraUnit", "onPreviewSurfaceTextureCreate---" + awtq.a(this.this$0));
    awtq.g(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awua
 * JD-Core Version:    0.7.0.1
 */