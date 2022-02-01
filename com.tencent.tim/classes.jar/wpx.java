import android.content.Context;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;

public class wpx
  extends AccessibilityDelegateCompat
{
  public wpx(PressToSpeakPanel paramPressToSpeakPanel) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if ((AppSetting.enableTalkBack) && (PressToSpeakPanel.a(this.this$0) > 0) && (!PressToSpeakPanel.a(this.this$0)) && (PressToSpeakPanel.a(this.this$0).getCurrentItem() == 0))
    {
      PressToSpeakPanel.a(this.this$0, true);
      PressToSpeakPanel.b(this.this$0);
      aqcl.speak(this.this$0, this.this$0.getContext().getString(2131692113));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wpx
 * JD-Core Version:    0.7.0.1
 */