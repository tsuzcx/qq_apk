package androidx.appcompat.app;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

class AppCompatDelegateImpl$3
  implements OnApplyWindowInsetsListener
{
  AppCompatDelegateImpl$3(AppCompatDelegateImpl paramAppCompatDelegateImpl) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    int i = paramWindowInsetsCompat.getSystemWindowInsetTop();
    int j = this.this$0.updateStatusGuard(i);
    WindowInsetsCompat localWindowInsetsCompat = paramWindowInsetsCompat;
    if (i != j) {
      localWindowInsetsCompat = paramWindowInsetsCompat.replaceSystemWindowInsets(paramWindowInsetsCompat.getSystemWindowInsetLeft(), j, paramWindowInsetsCompat.getSystemWindowInsetRight(), paramWindowInsetsCompat.getSystemWindowInsetBottom());
    }
    return ViewCompat.onApplyWindowInsets(paramView, localWindowInsetsCompat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.3
 * JD-Core Version:    0.7.0.1
 */