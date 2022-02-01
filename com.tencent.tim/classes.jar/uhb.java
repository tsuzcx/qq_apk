import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uhb
  implements CompoundButton.OnCheckedChangeListener
{
  public uhb(AuthDevActivity paramAuthDevActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject;
    boolean bool;
    if (paramCompoundButton == AuthDevActivity.a(this.this$0).a())
    {
      AuthDevActivity.a(this.this$0).setOnCheckedChangeListener(null);
      localObject = AuthDevActivity.a(this.this$0);
      if (AuthDevActivity.a(this.this$0).isChecked())
      {
        bool = false;
        ((FormSwitchItem)localObject).setChecked(bool);
        AuthDevActivity.a(this.this$0).setOnCheckedChangeListener(AuthDevActivity.a(this.this$0));
        if (aqiw.isNetSupport(this.this$0)) {
          break label127;
        }
        QQToast.a(this.this$0, this.this$0.getString(2131693404), 0).show(this.this$0.getTitleBarHeight());
      }
    }
    label127:
    do
    {
      do
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        bool = true;
        break;
        localObject = (acll)this.this$0.app.getBusinessHandler(34);
      } while (localObject == null);
      if (!AuthDevActivity.a(this.this$0).isChecked()) {}
      for (bool = true;; bool = false)
      {
        ((acll)localObject).FE(bool);
        break;
      }
      if (paramCompoundButton == AuthDevActivity.b(this.this$0).a())
      {
        if (AuthDevActivity.b(this.this$0).isChecked())
        {
          localObject = "0";
          anot.a(null, "dc00898", "", "", "0X800AC54", "0X800AC54", 0, 0, (String)localObject, "", "", "");
          AuthDevActivity.b(this.this$0).setOnCheckedChangeListener(null);
          localObject = AuthDevActivity.b(this.this$0);
          if (!AuthDevActivity.b(this.this$0).isChecked()) {
            break label313;
          }
        }
        for (bool = false;; bool = true)
        {
          ((FormSwitchItem)localObject).setChecked(bool);
          AuthDevActivity.b(this.this$0).setOnCheckedChangeListener(AuthDevActivity.a(this.this$0));
          AuthDevActivity.a(this.this$0);
          break;
          localObject = "1";
          break label212;
        }
      }
    } while (paramCompoundButton != AuthDevActivity.c(this.this$0).a());
    label212:
    label350:
    int i;
    label313:
    if (AuthDevActivity.c(this.this$0).isChecked())
    {
      localObject = "1";
      anot.a(null, "dc00898", "", "", "0X800AC53", "0X800AC53", 0, 0, (String)localObject, "", "", "");
      localObject = this.this$0.app;
      if (!paramBoolean) {
        break label484;
      }
      i = 1;
      anot.a((QQAppInterface)localObject, "CliOper", "", "", "Setting_tab", "Mobile_pc_online", 0, i, "", "", "", "");
      if (!paramBoolean) {
        break label489;
      }
      anot.a(null, "dc00898", "", "", "0X800A721", "0X800A721", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      label389:
      SettingCloneUtil.writeValue(this.this$0, this.this$0.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", paramBoolean);
      this.this$0.app.cLA();
      break;
      localObject = "0";
      break label350;
      label484:
      i = 0;
      break label389;
      label489:
      anot.a(null, "dc00898", "", "", "0X800A722", "0X800A722", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uhb
 * JD-Core Version:    0.7.0.1
 */