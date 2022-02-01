package androidx.appcompat.app;

import android.graphics.Rect;
import androidx.appcompat.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;

class AppCompatDelegateImpl$4
  implements FitWindowsViewGroup.OnFitSystemWindowsListener
{
  AppCompatDelegateImpl$4(AppCompatDelegateImpl paramAppCompatDelegateImpl) {}
  
  public void onFitSystemWindows(Rect paramRect)
  {
    paramRect.top = this.this$0.updateStatusGuard(paramRect.top);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.4
 * JD-Core Version:    0.7.0.1
 */