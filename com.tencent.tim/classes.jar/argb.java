import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.a;

public class argb
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public argb(InputMethodRelativeLayout paramInputMethodRelativeLayout) {}
  
  public void onGlobalLayout()
  {
    int i;
    if (this.d.a != null)
    {
      i = InputMethodRelativeLayout.a(this.d);
      if (i != InputMethodRelativeLayout.b(this.d))
      {
        int j = this.d.getRootView().getHeight();
        if (j - i <= j / 4) {
          break label102;
        }
        InputMethodRelativeLayout.a(this.d, true);
      }
    }
    for (;;)
    {
      this.d.a.l(InputMethodRelativeLayout.a(this.d), InputMethodRelativeLayout.b(this.d), i);
      this.d.requestLayout();
      InputMethodRelativeLayout.a(this.d, i);
      return;
      label102:
      InputMethodRelativeLayout.a(this.d, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     argb
 * JD-Core Version:    0.7.0.1
 */