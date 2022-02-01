import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;

public class wkd
  extends View.AccessibilityDelegate
{
  public wkd(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  @TargetApi(16)
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramAccessibilityNodeInfo.setVisibleToUser(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wkd
 * JD-Core Version:    0.7.0.1
 */