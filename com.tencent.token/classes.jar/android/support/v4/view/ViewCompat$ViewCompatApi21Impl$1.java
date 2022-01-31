package android.support.v4.view;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

class ViewCompat$ViewCompatApi21Impl$1
  implements View.OnApplyWindowInsetsListener
{
  ViewCompat$ViewCompatApi21Impl$1(ViewCompat.ViewCompatApi21Impl paramViewCompatApi21Impl, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener) {}
  
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    paramWindowInsets = WindowInsetsCompat.wrap(paramWindowInsets);
    return (WindowInsets)WindowInsetsCompat.unwrap(this.val$listener.onApplyWindowInsets(paramView, paramWindowInsets));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.ViewCompatApi21Impl.1
 * JD-Core Version:    0.7.0.1
 */