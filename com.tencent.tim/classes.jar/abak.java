import android.view.SurfaceView;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class abak
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public abak(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onGlobalLayout()
  {
    this.this$0.cns = this.this$0.mSurfaceView.getWidth();
    this.this$0.cnu = this.this$0.mSurfaceView.getHeight();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "onGlobalLayout,mSurfaceViewWidth:" + this.this$0.cns + ",mSurfaceViewHeight:" + this.this$0.cnu);
    }
    this.this$0.mSurfaceView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abak
 * JD-Core Version:    0.7.0.1
 */