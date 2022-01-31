import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class cpl
  implements SurfaceHolder.Callback
{
  public cpl(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "surfaceCreated: mSavedCurPosition:" + ShortVideoPreviewActivity.c(this.a) + ",mSavedPlayState : " + ShortVideoPreviewActivity.a(this.a, ShortVideoPreviewActivity.d(this.a)));
    }
    if ((ShortVideoPreviewActivity.d(this.a) == 1) && (ShortVideoPreviewActivity.c(this.a) > 0))
    {
      ShortVideoPreviewActivity.a(this.a, ShortVideoPreviewActivity.c(this.a));
      ShortVideoPreviewActivity.c(this.a, 0);
      ShortVideoPreviewActivity.d(this.a, 0);
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "surfaceDestroyed ");
    }
    ShortVideoPreviewActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cpl
 * JD-Core Version:    0.7.0.1
 */