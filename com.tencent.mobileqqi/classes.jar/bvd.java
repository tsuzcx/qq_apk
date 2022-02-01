import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class bvd
  implements CompoundButton.OnCheckedChangeListener
{
  public bvd(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AssistantSettingActivity.b(this.a).setContentDescription(this.a.getString(2131231141));
    SettingCloneUtil.writeValue(this.a, null, this.a.getString(2131563451), "qqsetting_auto_receive_magic_face_key", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bvd
 * JD-Core Version:    0.7.0.1
 */