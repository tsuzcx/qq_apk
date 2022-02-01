import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.qphone.base.util.QLog;

public class zac
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public zac(SimpleSlidingIndicator paramSimpleSlidingIndicator) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    for (;;)
    {
      this.b.tB(this.b.currentPosition);
      this.b.ET(this.b.currentPosition);
      View localView = this.b.ek.getChildAt(this.b.currentPosition);
      if (localView != null)
      {
        this.b.aYV = localView.getLeft();
        if (localView.getMeasuredWidth() == 0)
        {
          this.b.aYV = (SimpleSlidingIndicator.a(this.b) + (SimpleSlidingIndicator.b(this.b) + SimpleSlidingIndicator.c(this.b)) * this.b.currentPosition);
          if (QLog.isColorLevel()) {
            QLog.i("SimpleSlidingIndicator", 2, "onGlobalLayout, x[" + this.b.aYV + "], size[" + this.b.ek.getChildCount() + "], left[" + localView.getLeft() + "], width[" + localView.getMeasuredWidth() + "], pos[" + this.b.currentPosition + "], CPlr" + SimpleSlidingIndicator.a(this.b) + "]");
          }
        }
        this.b.invalidate();
      }
      return;
      this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zac
 * JD-Core Version:    0.7.0.1
 */