import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import com.tencent.biz.qqstory.view.widget.LeftTabBarView;

public class xwb
  extends AccessibilityDelegateCompat
{
  public xwb(LeftTabBarView paramLeftTabBarView) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if (LeftTabBarView.a(this.a, paramView) == LeftTabBarView.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      paramAccessibilityNodeInfoCompat.setSelected(bool);
      return;
    }
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    super.sendAccessibilityEvent(paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xwb
 * JD-Core Version:    0.7.0.1
 */