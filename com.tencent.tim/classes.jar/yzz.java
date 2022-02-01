import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;

public class yzz
  extends View.AccessibilityDelegate
{
  public yzz(SimpleSlidingIndicator paramSimpleSlidingIndicator) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 4096) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yzz
 * JD-Core Version:    0.7.0.1
 */