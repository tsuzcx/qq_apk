package androidx.core.view;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class ViewCompat$1
  implements View.OnApplyWindowInsetsListener
{
  ViewCompat$1(OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener) {}
  
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    paramWindowInsets = WindowInsetsCompat.wrap(paramWindowInsets);
    return (WindowInsets)WindowInsetsCompat.unwrap(this.val$listener.onApplyWindowInsets(paramView, paramWindowInsets));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.view.ViewCompat.1
 * JD-Core Version:    0.7.0.1
 */