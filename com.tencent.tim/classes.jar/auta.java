import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager.LayoutParams;
import com.tencent.widget.BubblePopupWindow;
import java.lang.ref.WeakReference;

public class auta
  implements ViewTreeObserver.OnScrollChangedListener
{
  public auta(BubblePopupWindow paramBubblePopupWindow) {}
  
  public void onScrollChanged()
  {
    if (BubblePopupWindow.a(this.m) != null) {}
    for (View localView = (View)BubblePopupWindow.a(this.m).get();; localView = null)
    {
      if ((localView != null) && (BubblePopupWindow.a(this.m) != null))
      {
        WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)BubblePopupWindow.a(this.m).getLayoutParams();
        BubblePopupWindow.a(this.m, localView, localLayoutParams, BubblePopupWindow.a(this.m), BubblePopupWindow.b(this.m));
        this.m.update(localLayoutParams.x, localLayoutParams.y, -1, -1, true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auta
 * JD-Core Version:    0.7.0.1
 */