import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class sgf
  implements ViewTreeObserver.OnPreDrawListener
{
  sgf(sge paramsge) {}
  
  public boolean onPreDraw()
  {
    sge.a(this.b).getViewTreeObserver().removeOnPreDrawListener(this);
    sge.a(this.b, sge.a(this.b).getLeft(), sge.a(this.b).getTop(), sge.a(this.b).getWidth(), sge.a(this.b).getHeight());
    QLog.d("TransitionAnimHelper", 4, new Object[] { "initImageEnterAnimation left:" + sge.a(this.b).getLeft(), ",top:", Integer.valueOf(sge.a(this.b).getTop()), ",width:", Integer.valueOf(sge.a(this.b).getWidth()), ",height:", Integer.valueOf(sge.a(this.b).getHeight()) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sgf
 * JD-Core Version:    0.7.0.1
 */