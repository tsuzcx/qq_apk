package android.support.v7.app;

import android.graphics.Rect;
import android.support.v7.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;

class AppCompatDelegateImplV9$3
  implements FitWindowsViewGroup.OnFitSystemWindowsListener
{
  AppCompatDelegateImplV9$3(AppCompatDelegateImplV9 paramAppCompatDelegateImplV9) {}
  
  public void onFitSystemWindows(Rect paramRect)
  {
    paramRect.top = this.this$0.updateStatusGuard(paramRect.top);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV9.3
 * JD-Core Version:    0.7.0.1
 */