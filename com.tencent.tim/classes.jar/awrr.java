import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import dov.com.qq.im.QIMCameraCaptureUnit.10;
import mqq.app.AppRuntime;

public class awrr
  implements MediaScanner.OnMediaInfoScannerListener
{
  public awrr(QIMCameraCaptureUnit.10 param10) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.a.this$0.onCaptureError(101);
      return;
    }
    awrq.a(this.a.this$0, false);
    if (!BaseApplicationImpl.getApplication().getRuntime().isBackground_Pause)
    {
      this.a.this$0.a(this.a.this$0.c, paramLocalMediaInfo);
      return;
    }
    this.a.this$0.h = paramLocalMediaInfo;
    this.a.this$0.d = this.a.this$0.c;
    this.a.this$0.drp = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awrr
 * JD-Core Version:    0.7.0.1
 */