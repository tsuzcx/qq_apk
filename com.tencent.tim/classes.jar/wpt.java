import android.content.Context;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel;

public class wpt
  extends AccessibilityDelegateCompat
{
  public wpt(ListenPanel paramListenPanel) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if (ListenPanel.a(this.this$0) < 1000.0D) {}
    for (int i = 0;; i = (int)(ListenPanel.a(this.this$0) / 1000.0D + 0.5D))
    {
      paramAccessibilityNodeInfoCompat.setContentDescription(i + this.this$0.getContext().getString(2131692116));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wpt
 * JD-Core Version:    0.7.0.1
 */