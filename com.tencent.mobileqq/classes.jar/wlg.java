import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.tencent.mobileqq.activity.contacts.view.SimpleSlidingIndicator;

public class wlg
  extends View.AccessibilityDelegate
{
  public wlg(SimpleSlidingIndicator paramSimpleSlidingIndicator) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 4096) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wlg
 * JD-Core Version:    0.7.0.1
 */