import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class aksh
  extends View.AccessibilityDelegate
{
  aksh(akrv paramakrv, ClickableSpan paramClickableSpan) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    super.sendAccessibilityEvent(paramView, paramInt);
    if ((paramInt == 1) && (this.c != null)) {
      this.c.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aksh
 * JD-Core Version:    0.7.0.1
 */