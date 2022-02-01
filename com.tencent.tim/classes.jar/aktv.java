import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.AccessibilityDelegate;

public final class aktv
  extends View.AccessibilityDelegate
{
  public aktv(ClickableSpan paramClickableSpan) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    super.sendAccessibilityEvent(paramView, paramInt);
    if ((paramInt == 1) && (this.c != null)) {
      this.c.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aktv
 * JD-Core Version:    0.7.0.1
 */