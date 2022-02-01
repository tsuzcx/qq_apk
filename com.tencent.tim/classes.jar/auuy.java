import android.annotation.TargetApi;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class auuy
  extends View.AccessibilityDelegate
{
  auuy(auuw paramauuw) {}
  
  @TargetApi(14)
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 32) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auuy
 * JD-Core Version:    0.7.0.1
 */