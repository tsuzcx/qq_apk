import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class zzr
  implements CompoundButton.OnCheckedChangeListener
{
  public zzr(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AssistantSettingActivity.a(this.a)) {
      return;
    }
    if (!badq.g(this.a))
    {
      bbmy.a(BaseApplication.getContext(), 1, 2131629009, 0).b(this.a.getTitleBarHeight());
      paramCompoundButton = this.a.e;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramCompoundButton.setChecked(paramBoolean);
        return;
      }
    }
    paramCompoundButton = amir.c();
    label194:
    label213:
    QQAppInterface localQQAppInterface;
    if ((paramBoolean) && (paramCompoundButton.a <= 1))
    {
      if (!baub.a(this.a.app, "have_show_ptt_tip", false))
      {
        QLog.e("vip_ptt.AssistantSettingActivity", 1, "open the ptt check box and tip to user");
        AssistantSettingActivity.a(this.a);
      }
      if ((!paramBoolean) && (paramCompoundButton.a <= 1)) {
        baub.b(this.a.app, "have_add_ptt_gray_msg", false);
      }
      AssistantSettingActivity.a(this.a, paramBoolean);
      ((ajfi)this.a.app.a(2)).p(paramBoolean);
      if (!paramBoolean) {
        break label297;
      }
      awqx.b(null, "dc00898", "", "", "0X8009DF4", "0X8009DF4", 1, 0, "", "", "", "");
      paramCompoundButton = "normal";
      if (!bajr.c(this.a.app)) {
        break label324;
      }
      paramCompoundButton = "vip";
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label343;
      }
    }
    label297:
    label324:
    label343:
    for (int i = 1;; i = 2)
    {
      awqx.b(localQQAppInterface, "dc00898", "", "", "", "0X800A415", i, 0, "", "", "", paramCompoundButton);
      return;
      if ((!paramBoolean) || (bajr.b(this.a.app))) {
        break;
      }
      QLog.e("vip_ptt.AssistantSettingActivity", 1, "open the ptt check box but u r not svip");
      AssistantSettingActivity.b(this.a);
      this.a.e.setChecked(false);
      return;
      awqx.b(null, "dc00898", "", "", "0X8009DF4", "0X8009DF4", 2, 0, "", "", "", "");
      break label194;
      if (!bajr.b(this.a.app)) {
        break label213;
      }
      paramCompoundButton = "svip";
      break label213;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     zzr
 * JD-Core Version:    0.7.0.1
 */