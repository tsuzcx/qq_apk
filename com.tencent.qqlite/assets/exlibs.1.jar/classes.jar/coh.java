import android.view.SurfaceView;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class coh
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public coh(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onGlobalLayout()
  {
    ShortVideoPreviewActivity.a(this.a, ShortVideoPreviewActivity.a(this.a).getWidth());
    ShortVideoPreviewActivity.b(this.a, ShortVideoPreviewActivity.a(this.a).getHeight());
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "onGlobalLayout,mSurfaceViewWidth:" + ShortVideoPreviewActivity.a(this.a) + ",mSurfaceViewHeight:" + ShortVideoPreviewActivity.b(this.a));
    }
    ShortVideoPreviewActivity.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     coh
 * JD-Core Version:    0.7.0.1
 */