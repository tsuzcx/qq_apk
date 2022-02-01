import android.annotation.TargetApi;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class osz
  extends View.AccessibilityDelegate
{
  osz(osx paramosx) {}
  
  @TargetApi(14)
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 32) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osz
 * JD-Core Version:    0.7.0.1
 */