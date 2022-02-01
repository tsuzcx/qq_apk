import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.widget.Switch;

class abev
  extends View.AccessibilityDelegate
{
  abev(abes paramabes) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    if (paramView != null)
    {
      paramView = (Switch)paramView.findViewById(2131364012);
      if ((paramView != null) && (paramView.getVisibility() != 8))
      {
        paramAccessibilityNodeInfo.setCheckable(true);
        paramAccessibilityNodeInfo.setChecked(paramView.isChecked());
        paramAccessibilityNodeInfo.setClassName(Switch.class.getName());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abev
 * JD-Core Version:    0.7.0.1
 */