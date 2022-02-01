import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.a;
import dov.com.qq.im.capture.view.CountDownView;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;

class awww
  implements axzv<AEVideoStoryTopBarViewModel.a>
{
  awww(awwq paramawwq) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.a parama)
  {
    if (parama == null) {
      return;
    }
    boolean bool = parama.getEnable();
    if (bool) {
      awwq.b(this.this$0);
    }
    for (;;)
    {
      awwq.a(this.this$0).a(bool, new awwx(this, parama));
      return;
      if (awwq.a(this.this$0) != null) {
        awwq.a(this.this$0).cjE();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awww
 * JD-Core Version:    0.7.0.1
 */