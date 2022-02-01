import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class zjd
  implements ViewTreeObserver.OnPreDrawListener
{
  zjd(zjc paramzjc) {}
  
  public boolean onPreDraw()
  {
    zjc.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    zjc.a(this.a, zjc.a(this.a).getLeft(), zjc.a(this.a).getTop(), zjc.a(this.a).getWidth(), zjc.a(this.a).getHeight());
    QLog.d("TransitionAnimHelper", 4, new Object[] { "initImageEnterAnimation left:" + zjc.a(this.a).getLeft(), ",top:", Integer.valueOf(zjc.a(this.a).getTop()), ",width:", Integer.valueOf(zjc.a(this.a).getWidth()), ",height:", Integer.valueOf(zjc.a(this.a).getHeight()) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjd
 * JD-Core Version:    0.7.0.1
 */