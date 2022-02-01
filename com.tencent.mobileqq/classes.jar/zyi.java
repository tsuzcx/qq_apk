import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class zyi
  implements ViewTreeObserver.OnPreDrawListener
{
  zyi(zyh paramzyh) {}
  
  public boolean onPreDraw()
  {
    zyh.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    zyh.a(this.a, zyh.a(this.a).getLeft(), zyh.a(this.a).getTop(), zyh.a(this.a).getWidth(), zyh.a(this.a).getHeight());
    QLog.d("TransitionAnimHelper", 4, new Object[] { "initImageEnterAnimation left:" + zyh.a(this.a).getLeft(), ",top:", Integer.valueOf(zyh.a(this.a).getTop()), ",width:", Integer.valueOf(zyh.a(this.a).getWidth()), ",height:", Integer.valueOf(zyh.a(this.a).getHeight()) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zyi
 * JD-Core Version:    0.7.0.1
 */