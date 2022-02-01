import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager.LayoutParams;
import com.tencent.widget.BubblePopupWindow;
import java.lang.ref.WeakReference;

public class hvo
  implements ViewTreeObserver.OnScrollChangedListener
{
  public hvo(BubblePopupWindow paramBubblePopupWindow) {}
  
  public void onScrollChanged()
  {
    if (BubblePopupWindow.a(this.a) != null) {}
    for (View localView = (View)BubblePopupWindow.a(this.a).get();; localView = null)
    {
      if ((localView != null) && (BubblePopupWindow.a(this.a) != null))
      {
        WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)BubblePopupWindow.a(this.a).getLayoutParams();
        BubblePopupWindow.a(this.a, localView, localLayoutParams, BubblePopupWindow.a(this.a), BubblePopupWindow.b(this.a));
        this.a.a(localLayoutParams.x, localLayoutParams.y, -1, -1, true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hvo
 * JD-Core Version:    0.7.0.1
 */