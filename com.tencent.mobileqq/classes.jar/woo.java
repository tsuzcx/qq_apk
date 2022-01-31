import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.contacts.view.SimpleSlidingIndicator;

public class woo
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public woo(SimpleSlidingIndicator paramSimpleSlidingIndicator) {}
  
  @SuppressLint({"NewApi"})
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    for (;;)
    {
      SimpleSlidingIndicator.a(this.a, SimpleSlidingIndicator.a(this.a));
      SimpleSlidingIndicator.b(this.a, SimpleSlidingIndicator.a(this.a));
      View localView = SimpleSlidingIndicator.a(this.a).getChildAt(SimpleSlidingIndicator.a(this.a));
      SimpleSlidingIndicator.a(this.a, localView.getLeft());
      this.a.invalidate();
      return;
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     woo
 * JD-Core Version:    0.7.0.1
 */