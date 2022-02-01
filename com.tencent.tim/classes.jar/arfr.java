import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mobileqq.widget.FormCommonSwitchItem;

public class arfr
  extends View.AccessibilityDelegate
{
  public arfr(FormCommonSwitchItem paramFormCommonSwitchItem) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    paramAccessibilityNodeInfo.setVisibleToUser(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arfr
 * JD-Core Version:    0.7.0.1
 */