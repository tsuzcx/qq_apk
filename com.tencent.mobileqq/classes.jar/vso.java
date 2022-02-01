import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqcircle.transition.QCircleTransitionImageView;
import com.tencent.qphone.base.util.QLog;

class vso
  implements ViewTreeObserver.OnPreDrawListener
{
  vso(vsn paramvsn) {}
  
  public boolean onPreDraw()
  {
    vsn.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    vsn.a(this.a);
    QLog.d("QCircleTransitionAnimHelper", 4, "initImageEnterAnimation");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vso
 * JD-Core Version:    0.7.0.1
 */