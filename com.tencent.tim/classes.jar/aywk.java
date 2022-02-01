import android.view.SurfaceView;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;

public class aywk
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public aywk(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aywk
 * JD-Core Version:    0.7.0.1
 */