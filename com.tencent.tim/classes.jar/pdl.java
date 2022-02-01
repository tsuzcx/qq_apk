import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqcircle.transition.QCircleTransitionImageView;
import com.tencent.qphone.base.util.QLog;

class pdl
  implements ViewTreeObserver.OnPreDrawListener
{
  pdl(pdk parampdk) {}
  
  public boolean onPreDraw()
  {
    pdk.a(this.b).getViewTreeObserver().removeOnPreDrawListener(this);
    pdk.a(this.b);
    QLog.d("QCircleTransitionAnimHelper", 4, "initImageEnterAnimation");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdl
 * JD-Core Version:    0.7.0.1
 */