import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.mode.AECaptureMode;

class awtt
  implements axzv<AEVideoStoryTopBarViewModel.Ratio>
{
  awtt(awtq paramawtq) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    axiy.i("AEPituCameraUnit", "mCurrentRatio---onChanged: ratio=" + paramRatio);
    if (paramRatio == null) {}
    do
    {
      do
      {
        return;
      } while (awtq.a(this.this$0) == paramRatio);
      awtq.a(this.this$0, paramRatio);
      axis.a().aY("sp_key_ae_camera_ratio", paramRatio.code, 0);
    } while (awtq.b(this.this$0) != AECaptureMode.NORMAL);
    awtq.f(this.this$0);
    awtq.g(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awtt
 * JD-Core Version:    0.7.0.1
 */