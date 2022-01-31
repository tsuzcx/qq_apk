import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqcircle.transition.QCircleTransitionImageView;
import com.tencent.qphone.base.util.QLog;

class uak
  implements ViewTreeObserver.OnPreDrawListener
{
  uak(uaj paramuaj) {}
  
  public boolean onPreDraw()
  {
    uaj.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    uaj.a(this.a);
    QLog.d("QCircleTransitionAnimHelper", 4, "initImageEnterAnimation");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uak
 * JD-Core Version:    0.7.0.1
 */