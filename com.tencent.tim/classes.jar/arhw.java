import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mobileqq.widget.QQBlurView;

public class arhw
  implements ViewTreeObserver.OnPreDrawListener
{
  public arhw(QQBlurView paramQQBlurView) {}
  
  public boolean onPreDraw()
  {
    if (!QQBlurView.a(this.d)) {}
    while (!QQBlurView.a(this.d).isCreated()) {
      return true;
    }
    return QQBlurView.a(this.d).onPreDraw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhw
 * JD-Core Version:    0.7.0.1
 */