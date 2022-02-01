import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vkk
  implements CompoundButton.OnCheckedChangeListener
{
  public vkk(NotifyPushSettingActivity paramNotifyPushSettingActivity, BubbleManager paramBubbleManager) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.a.GM(paramBoolean);
    String str2 = this.this$0.app.getCurrentAccountUin();
    if (paramBoolean) {}
    for (String str1 = "1";; str1 = "0")
    {
      VasWebviewUtil.reportCommercialDrainage(str2, "bubble_new", "change", "0", 0, 0, 0, "", "", str1, "", "", "", "", 0, 0, 0, 0);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vkk
 * JD-Core Version:    0.7.0.1
 */