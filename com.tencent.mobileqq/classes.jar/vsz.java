import android.annotation.TargetApi;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class vsz
  extends View.AccessibilityDelegate
{
  vsz(vsx paramvsx) {}
  
  @TargetApi(14)
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 32) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsz
 * JD-Core Version:    0.7.0.1
 */