import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class yku
  implements ViewTreeObserver.OnPreDrawListener
{
  yku(ykt paramykt) {}
  
  public boolean onPreDraw()
  {
    ykt.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    ykt.a(this.a, ykt.a(this.a).getLeft(), ykt.a(this.a).getTop(), ykt.a(this.a).getWidth(), ykt.a(this.a).getHeight());
    QLog.d("TransitionAnimHelper", 4, new Object[] { "initImageEnterAnimation left:" + ykt.a(this.a).getLeft(), ",top:", Integer.valueOf(ykt.a(this.a).getTop()), ",width:", Integer.valueOf(ykt.a(this.a).getWidth()), ",height:", Integer.valueOf(ykt.a(this.a).getHeight()) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yku
 * JD-Core Version:    0.7.0.1
 */