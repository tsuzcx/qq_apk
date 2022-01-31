import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class yb
  implements CompoundButton.OnCheckedChangeListener
{
  public yb(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AssistantSettingActivity.d(this.a).setContentDescription("内存低时自动清理内存");
    SettingCloneUtil.writeValue(this.a, null, null, "qqsetting_clear_memory_key", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     yb
 * JD-Core Version:    0.7.0.1
 */