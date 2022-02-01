import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;

public class arix
  extends View.AccessibilityDelegate
{
  public arix(SimpleSlidingIndicator paramSimpleSlidingIndicator) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 4096) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arix
 * JD-Core Version:    0.7.0.1
 */