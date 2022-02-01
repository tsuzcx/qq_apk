import android.annotation.TargetApi;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class uuz
  extends View.AccessibilityDelegate
{
  uuz(uux paramuux) {}
  
  @TargetApi(14)
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 32) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uuz
 * JD-Core Version:    0.7.0.1
 */