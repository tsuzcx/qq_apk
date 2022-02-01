import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.AEPituCameraUnit.29.1;
import dov.com.qq.im.ae.AEPituCameraUnit.29.2;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import mqq.os.MqqHandler;

public class awty
  implements awwa.a
{
  awty(awtq paramawtq) {}
  
  public void ac(boolean paramBoolean, String paramString)
  {
    axiy.i("AEPituCameraUnit", "onCameraStarted--success=" + paramBoolean + ", errMsg=" + paramString);
    if (paramBoolean) {
      axgk.a().acy("onCameraStart");
    }
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.29.1(this));
    }
    for (;;)
    {
      int i = AEBeautyProviderView.QU();
      int j = AEBeautyProviderView.QV();
      awtq.a(this.this$0).setBeautyLevel(i);
      awtq.a(this.this$0).setSharpFaceLevel(j);
      awtq.a(this.this$0).p(458753, new Object[0]);
      return;
      if (awtq.a(this.this$0) != null) {
        ThreadManager.getUIHandler().post(new AEPituCameraUnit.29.2(this));
      }
    }
  }
  
  public void eGn()
  {
    if (awtq.a(this.this$0) != null) {
      awtq.a(this.this$0).eGn();
    }
  }
  
  public void lq(int paramInt1, int paramInt2)
  {
    axiy.i("AEPituCameraUnit", "onCameraPreviewSizeChanged---width=" + paramInt1 + ", height=" + paramInt2);
    if (awtq.a(this.this$0) != null) {
      awtq.a(this.this$0).lq(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awty
 * JD-Core Version:    0.7.0.1
 */