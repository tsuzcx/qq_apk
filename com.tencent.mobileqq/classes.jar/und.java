import android.content.Context;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;
import com.tencent.mobileqq.util.AccessibilityUtil;

public class und
  extends AccessibilityDelegateCompat
{
  public und(PressToSpeakPanel paramPressToSpeakPanel) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if ((AppSetting.b) && (PressToSpeakPanel.a(this.a) > 0) && (!PressToSpeakPanel.a(this.a)) && (PressToSpeakPanel.a(this.a).a() == 1))
    {
      PressToSpeakPanel.a(this.a, true);
      PressToSpeakPanel.b(this.a);
      AccessibilityUtil.a(this.a, this.a.getContext().getString(2131427474));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     und
 * JD-Core Version:    0.7.0.1
 */