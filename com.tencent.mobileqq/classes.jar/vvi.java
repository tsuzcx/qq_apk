import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqcircle.transition.QCircleTransitionImageView;
import com.tencent.qphone.base.util.QLog;

class vvi
  implements ViewTreeObserver.OnPreDrawListener
{
  vvi(vvh paramvvh) {}
  
  public boolean onPreDraw()
  {
    vvh.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    vvh.a(this.a);
    QLog.d("QCircleTransitionAnimHelper", 4, "initImageEnterAnimation");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvi
 * JD-Core Version:    0.7.0.1
 */