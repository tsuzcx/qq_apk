import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class wrr
  implements ViewTreeObserver.OnPreDrawListener
{
  wrr(wrq paramwrq) {}
  
  public boolean onPreDraw()
  {
    wrq.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    wrq.a(this.a, wrq.a(this.a).getLeft(), wrq.a(this.a).getTop(), wrq.a(this.a).getWidth(), wrq.a(this.a).getHeight());
    QLog.d("TransitionAnimHelper", 4, new Object[] { "initImageEnterAnimation left:" + wrq.a(this.a).getLeft(), ",top:", Integer.valueOf(wrq.a(this.a).getTop()), ",width:", Integer.valueOf(wrq.a(this.a).getWidth()), ",height:", Integer.valueOf(wrq.a(this.a).getHeight()) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wrr
 * JD-Core Version:    0.7.0.1
 */