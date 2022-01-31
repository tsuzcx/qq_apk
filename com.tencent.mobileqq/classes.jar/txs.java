import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class txs
  implements CompoundButton.OnCheckedChangeListener
{
  public txs(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    int k = SettingCloneUtil.readValueForInt(this.a, this.a.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.b);
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(true);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      SoundAndVibrateActivity.a(this.a).setVisibility(0);
      SoundAndVibrateActivity.a(this.a).setBackgroundResource(2130838641);
      paramCompoundButton = ThemeUtil.getUserCurrentThemeId(this.a.app);
      if (paramCompoundButton.equals("1000")) {
        break label1357;
      }
      paramCompoundButton = ThemeUtil.getThemeInfo(this.a, paramCompoundButton);
      if ((paramCompoundButton == null) || (!paramCompoundButton.isVoiceTheme)) {
        break label1357;
      }
    }
    label423:
    label445:
    label1352:
    label1357:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        SoundAndVibrateActivity.b(this.a).setBackgroundResource(2130838629);
        SoundAndVibrateActivity.b(this.a).setVisibility(0);
      }
      if (k == 2131230720)
      {
        SoundAndVibrateActivity.b(this.a).setRightIcon(this.a.getResources().getDrawable(2130846361));
        SoundAndVibrateActivity.c(this.a).setRightIcon(null);
        SoundAndVibrateActivity.d(this.a).setRightIcon(null);
        SoundAndVibrateActivity.e(this.a).setRightIcon(null);
        SoundAndVibrateActivity.a(this.a, 0);
        if (AppSetting.b)
        {
          SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131435258) + this.a.getString(2131437149));
          SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131435259) + this.a.getString(2131437150));
          SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131435260) + this.a.getString(2131437150));
          SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131435261) + this.a.getString(2131437150));
        }
        if (this.a.app.a() != 0) {
          break label1252;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        this.a.app.e(1);
        SoundAndVibrateActivity.c(this.a).setChecked(true);
        paramCompoundButton = this.a.app;
        if (!paramBoolean) {
          break label1352;
        }
      }
      for (i = j;; i = 0)
      {
        ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_notice_sound", 0, i, "", "", "", "");
        return;
        if (k == 2131230721)
        {
          SoundAndVibrateActivity.b(this.a).setRightIcon(null);
          SoundAndVibrateActivity.c(this.a).setRightIcon(this.a.getResources().getDrawable(2130846361));
          SoundAndVibrateActivity.d(this.a).setRightIcon(null);
          SoundAndVibrateActivity.e(this.a).setRightIcon(null);
          SoundAndVibrateActivity.a(this.a, 1);
          if (!AppSetting.b) {
            break;
          }
          SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131435258) + this.a.getString(2131437150));
          SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131435259) + this.a.getString(2131437149));
          SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131435260) + this.a.getString(2131437150));
          SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131435261) + this.a.getString(2131437150));
          break;
        }
        if (k == SoundAndVibrateActivity.jdField_a_of_type_Int)
        {
          SoundAndVibrateActivity.b(this.a).setRightIcon(null);
          SoundAndVibrateActivity.c(this.a).setRightIcon(null);
          SoundAndVibrateActivity.d(this.a).setRightIcon(this.a.getResources().getDrawable(2130846361));
          SoundAndVibrateActivity.e(this.a).setRightIcon(null);
          SoundAndVibrateActivity.a(this.a, 2);
          if (!AppSetting.b) {
            break;
          }
          SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131435258) + this.a.getString(2131437150));
          SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131435259) + this.a.getString(2131437150));
          SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131435260) + this.a.getString(2131437149));
          SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131435261) + this.a.getString(2131437150));
          break;
        }
        if (k != SoundAndVibrateActivity.b) {
          break;
        }
        SoundAndVibrateActivity.b(this.a).setRightIcon(null);
        SoundAndVibrateActivity.c(this.a).setRightIcon(null);
        SoundAndVibrateActivity.d(this.a).setRightIcon(null);
        SoundAndVibrateActivity.e(this.a).setRightIcon(this.a.getResources().getDrawable(2130846361));
        SoundAndVibrateActivity.a(this.a, 3);
        if (!AppSetting.b) {
          break;
        }
        SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131435258) + this.a.getString(2131437150));
        SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131435259) + this.a.getString(2131437150));
        SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131435260) + this.a.getString(2131437150));
        SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131435261) + this.a.getString(2131437149));
        break;
        label1252:
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        break label423;
        SoundAndVibrateActivity.a(this.a).setBackgroundResource(2130838629);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        SoundAndVibrateActivity.a(this.a).setVisibility(8);
        SoundAndVibrateActivity.b(this.a).setVisibility(8);
        SoundAndVibrateActivity.b(this.a).setBackgroundResource(2130838629);
        SoundAndVibrateActivity.b(this.a).setVisibility(8);
        this.a.app.e(0);
        break label445;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     txs
 * JD-Core Version:    0.7.0.1
 */