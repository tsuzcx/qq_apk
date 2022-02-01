import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;

final class aqcq
  extends View.AccessibilityDelegate
{
  aqcq(CharSequence paramCharSequence, String paramString) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    if (this.val$contentDesc != null) {
      paramAccessibilityNodeInfo.setContentDescription(this.val$contentDesc);
    }
    paramAccessibilityNodeInfo.setClassName(this.val$className);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqcq
 * JD-Core Version:    0.7.0.1
 */