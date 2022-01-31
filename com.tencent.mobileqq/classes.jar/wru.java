import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class wru
  implements ViewTreeObserver.OnPreDrawListener
{
  wru(wrt paramwrt) {}
  
  public boolean onPreDraw()
  {
    wrt.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    wrt.a(this.a, wrt.a(this.a).getLeft(), wrt.a(this.a).getTop(), wrt.a(this.a).getWidth(), wrt.a(this.a).getHeight());
    QLog.d("TransitionAnimHelper", 4, new Object[] { "initImageEnterAnimation left:" + wrt.a(this.a).getLeft(), ",top:", Integer.valueOf(wrt.a(this.a).getTop()), ",width:", Integer.valueOf(wrt.a(this.a).getWidth()), ",height:", Integer.valueOf(wrt.a(this.a).getHeight()) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wru
 * JD-Core Version:    0.7.0.1
 */