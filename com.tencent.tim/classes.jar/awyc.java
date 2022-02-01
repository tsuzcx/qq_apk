import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class awyc
  implements axzv<axfz>
{
  awyc(awxv paramawxv) {}
  
  public void a(@Nullable axfz paramaxfz)
  {
    if (paramaxfz == null) {}
    do
    {
      return;
      awxv.a(this.this$0).cox();
      awxv.a(this.this$0, paramaxfz.g);
      if (awxv.a(this.this$0) == AECaptureMode.NORMAL)
      {
        awxv.a(this.this$0);
        return;
      }
      if (awxv.a(this.this$0) == AECaptureMode.GIF)
      {
        awxv.a(this.this$0).setVisibility(8);
        return;
      }
    } while (awxv.a(this.this$0) != AECaptureMode.PLAY);
    awxv.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awyc
 * JD-Core Version:    0.7.0.1
 */