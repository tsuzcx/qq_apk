import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.widget.immersive.ImmersiveUtils;

public class auvy
{
  Activity N;
  private int cru;
  private FrameLayout.LayoutParams d;
  private View qO;
  
  private auvy(Activity paramActivity)
  {
    this.qO = ((FrameLayout)paramActivity.findViewById(16908290)).getChildAt(0);
    this.N = paramActivity;
    this.qO.getViewTreeObserver().addOnGlobalLayoutListener(new auvz(this));
    this.d = ((FrameLayout.LayoutParams)this.qO.getLayoutParams());
  }
  
  public static void bN(Activity paramActivity)
  {
    new auvy(paramActivity);
  }
  
  private void cEF()
  {
    int i = zR();
    int j;
    int k;
    if (i != this.cru)
    {
      j = this.qO.getRootView().getHeight();
      k = j - i;
      if (k <= j / 4) {
        break label66;
      }
    }
    label66:
    for (this.d.height = (j - k + ImmersiveUtils.getStatusBarHeight(this.N));; this.d.height = j)
    {
      this.qO.requestLayout();
      this.cru = i;
      return;
    }
  }
  
  private int zR()
  {
    Rect localRect = new Rect();
    this.qO.getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auvy
 * JD-Core Version:    0.7.0.1
 */