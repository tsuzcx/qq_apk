package androidx.viewpager.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

class ViewPager$4
  implements OnApplyWindowInsetsListener
{
  private final Rect mTempRect = new Rect();
  
  ViewPager$4(ViewPager paramViewPager) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    paramView = ViewCompat.onApplyWindowInsets(paramView, paramWindowInsetsCompat);
    if (paramView.isConsumed()) {
      return paramView;
    }
    paramWindowInsetsCompat = this.mTempRect;
    paramWindowInsetsCompat.left = paramView.getSystemWindowInsetLeft();
    paramWindowInsetsCompat.top = paramView.getSystemWindowInsetTop();
    paramWindowInsetsCompat.right = paramView.getSystemWindowInsetRight();
    paramWindowInsetsCompat.bottom = paramView.getSystemWindowInsetBottom();
    int i = 0;
    int j = this.this$0.getChildCount();
    while (i < j)
    {
      WindowInsetsCompat localWindowInsetsCompat = ViewCompat.dispatchApplyWindowInsets(this.this$0.getChildAt(i), paramView);
      paramWindowInsetsCompat.left = Math.min(localWindowInsetsCompat.getSystemWindowInsetLeft(), paramWindowInsetsCompat.left);
      paramWindowInsetsCompat.top = Math.min(localWindowInsetsCompat.getSystemWindowInsetTop(), paramWindowInsetsCompat.top);
      paramWindowInsetsCompat.right = Math.min(localWindowInsetsCompat.getSystemWindowInsetRight(), paramWindowInsetsCompat.right);
      paramWindowInsetsCompat.bottom = Math.min(localWindowInsetsCompat.getSystemWindowInsetBottom(), paramWindowInsetsCompat.bottom);
      i += 1;
    }
    return paramView.replaceSystemWindowInsets(paramWindowInsetsCompat.left, paramWindowInsetsCompat.top, paramWindowInsetsCompat.right, paramWindowInsetsCompat.bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.viewpager.widget.ViewPager.4
 * JD-Core Version:    0.7.0.1
 */