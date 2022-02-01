import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;

public class adrr
{
  private ArkAppView c;
  private int cJL;
  private ViewGroup.MarginLayoutParams mLayoutParams;
  private int mScreenHeight;
  private int mUsableHeightPrevious;
  private View qO;
  
  private adrr(Activity paramActivity, ArkAppView paramArkAppView)
  {
    FrameLayout localFrameLayout = (FrameLayout)paramActivity.findViewById(16908290);
    if (localFrameLayout == null) {
      return;
    }
    this.qO = localFrameLayout.getChildAt(0);
    if (this.qO != null) {
      this.qO.getViewTreeObserver().addOnGlobalLayoutListener(new adrs(this));
    }
    this.c = paramArkAppView;
    this.mLayoutParams = ((ViewGroup.MarginLayoutParams)paramArkAppView.getLayoutParams());
    paramArkAppView = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(paramArkAppView);
    this.mScreenHeight = paramArkAppView.heightPixels;
    this.cJL = this.mLayoutParams.topMargin;
  }
  
  public static void a(Activity paramActivity, ArkAppView paramArkAppView)
  {
    new adrr(paramActivity, paramArkAppView);
  }
  
  private void cEF()
  {
    int i = zR();
    if (i != this.mUsableHeightPrevious)
    {
      int k = this.qO.getRootView().getHeight();
      int j = k - i;
      if (j <= k / 4) {
        break label104;
      }
      Rect localRect = this.c.getInputRect();
      int[] arrayOfInt = new int[2];
      this.c.getLocationOnScreen(arrayOfInt);
      k = localRect.bottom + arrayOfInt[1];
      j = this.mScreenHeight - j;
      if (j < k)
      {
        this.mLayoutParams.topMargin = (j - k);
        this.c.requestLayout();
      }
    }
    for (;;)
    {
      this.mUsableHeightPrevious = i;
      return;
      label104:
      this.mLayoutParams.topMargin = this.cJL;
      this.c.requestLayout();
    }
  }
  
  private int zR()
  {
    Rect localRect = new Rect();
    this.qO.getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adrr
 * JD-Core Version:    0.7.0.1
 */