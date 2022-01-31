import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class ygh
  implements ViewTreeObserver.OnPreDrawListener
{
  ygh(ygg paramygg) {}
  
  public boolean onPreDraw()
  {
    ygg.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    ygg.a(this.a, ygg.a(this.a).getLeft(), ygg.a(this.a).getTop(), ygg.a(this.a).getWidth(), ygg.a(this.a).getHeight());
    QLog.d("TransitionAnimHelper", 4, new Object[] { "initImageEnterAnimation left:" + ygg.a(this.a).getLeft(), ",top:", Integer.valueOf(ygg.a(this.a).getTop()), ",width:", Integer.valueOf(ygg.a(this.a).getWidth()), ",height:", Integer.valueOf(ygg.a(this.a).getHeight()) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ygh
 * JD-Core Version:    0.7.0.1
 */