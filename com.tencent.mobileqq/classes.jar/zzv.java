import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class zzv
  implements CompoundButton.OnCheckedChangeListener
{
  public zzv(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (!badq.d(this.a))
    {
      AssistantSettingActivity.a(this.a, 2131629006, 1);
      paramCompoundButton = this.a;
      if (!paramBoolean) {
        bool = true;
      }
      AssistantSettingActivity.b(paramCompoundButton, bool);
      return;
    }
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean) {}
    for (paramCompoundButton = "1";; paramCompoundButton = "2")
    {
      awqx.b(localQQAppInterface, "dc00898", "", "", "0X800A5D5", "0X800A5D5", 0, 0, paramCompoundButton, "", "", "");
      this.a.a.b(paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     zzv
 * JD-Core Version:    0.7.0.1
 */