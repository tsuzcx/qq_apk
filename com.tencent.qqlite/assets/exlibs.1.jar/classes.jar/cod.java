import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;

public class cod
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public cod(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onGlobalLayout()
  {
    ShortVideoPlayActivity.a(this.a, ShortVideoPlayActivity.c(this.a).getWidth());
    ShortVideoPlayActivity.b(this.a, ShortVideoPlayActivity.c(this.a).getHeight());
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onGlobalLayout,mSurfaceViewWidth:" + ShortVideoPlayActivity.b(this.a) + ",mSurfaceViewHeight:" + ShortVideoPlayActivity.c(this.a));
    }
    ShortVideoPlayActivity.c(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cod
 * JD-Core Version:    0.7.0.1
 */