package android.support.v7.app;

import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;

class AppCompatDelegateImplV9$2
  implements OnApplyWindowInsetsListener
{
  AppCompatDelegateImplV9$2(AppCompatDelegateImplV9 paramAppCompatDelegateImplV9) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV9.2
 * JD-Core Version:    0.7.0.1
 */