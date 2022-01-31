import android.content.res.Resources;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class diz
  implements CompoundButton.OnCheckedChangeListener
{
  public diz(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    int k = SettingCloneUtil.readValueForInt(this.a, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "sound_type", "qqsetting_notify_soundtype_key", 2131165184);
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(true);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      SoundAndVibrateActivity.a(this.a).setBackgroundResource(2130837882);
      paramCompoundButton = ThemeUtil.getUserCurrentThemeId(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramCompoundButton.equals("1000")) {
        break label1409;
      }
      paramCompoundButton = ThemeUtil.getThemeInfo(this.a, paramCompoundButton);
      if ((paramCompoundButton == null) || (!paramCompoundButton.isVoiceTheme)) {
        break label1409;
      }
    }
    label1409:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        SoundAndVibrateActivity.b(this.a).setBackgroundResource(2130837877);
        SoundAndVibrateActivity.b(this.a).setVisibility(0);
      }
      if (k == 2131165184)
      {
        SoundAndVibrateActivity.a(this.a).setRightIcon(this.a.getResources().getDrawable(2130840346));
        SoundAndVibrateActivity.b(this.a).setRightIcon(this.a.getResources().getDrawable(2130840348));
        SoundAndVibrateActivity.c(this.a).setRightIcon(this.a.getResources().getDrawable(2130840348));
        SoundAndVibrateActivity.d(this.a).setRightIcon(this.a.getResources().getDrawable(2130840348));
        SoundAndVibrateActivity.a(this.a).setContentDescription(this.a.getString(2131561818) + this.a.getString(2131562854));
        SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131563089) + this.a.getString(2131558457));
        SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131563010) + this.a.getString(2131558457));
        SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131563096) + this.a.getString(2131558457));
        if (this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b() != 0) {
          break label1316;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        label441:
        this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(1);
        label452:
        paramCompoundButton = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!paramBoolean) {
          break label1404;
        }
      }
      label1316:
      label1404:
      for (i = j;; i = 0)
      {
        ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_notice_sound", 0, i, "", "", "", "");
        return;
        if (k == 2131165197)
        {
          SoundAndVibrateActivity.a(this.a).setRightIcon(this.a.getResources().getDrawable(2130840348));
          SoundAndVibrateActivity.b(this.a).setRightIcon(this.a.getResources().getDrawable(2130840346));
          SoundAndVibrateActivity.c(this.a).setRightIcon(this.a.getResources().getDrawable(2130840348));
          SoundAndVibrateActivity.d(this.a).setRightIcon(this.a.getResources().getDrawable(2130840348));
          SoundAndVibrateActivity.a(this.a).setContentDescription(this.a.getString(2131561818) + this.a.getString(2131558457));
          SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131563089) + this.a.getString(2131562854));
          SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131563010) + this.a.getString(2131558457));
          SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131563096) + this.a.getString(2131558457));
          break;
        }
        if (k == SoundAndVibrateActivity.jdField_a_of_type_Int)
        {
          SoundAndVibrateActivity.a(this.a).setRightIcon(this.a.getResources().getDrawable(2130840348));
          SoundAndVibrateActivity.b(this.a).setRightIcon(this.a.getResources().getDrawable(2130840348));
          SoundAndVibrateActivity.c(this.a).setRightIcon(this.a.getResources().getDrawable(2130840346));
          SoundAndVibrateActivity.d(this.a).setRightIcon(this.a.getResources().getDrawable(2130840348));
          SoundAndVibrateActivity.a(this.a).setContentDescription(this.a.getString(2131561818) + this.a.getString(2131558457));
          SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131563089) + this.a.getString(2131558457));
          SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131563010) + this.a.getString(2131562854));
          SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131563096) + this.a.getString(2131558457));
          break;
        }
        if (k != SoundAndVibrateActivity.jdField_b_of_type_Int) {
          break;
        }
        SoundAndVibrateActivity.a(this.a).setRightIcon(this.a.getResources().getDrawable(2130840348));
        SoundAndVibrateActivity.b(this.a).setRightIcon(this.a.getResources().getDrawable(2130840348));
        SoundAndVibrateActivity.c(this.a).setRightIcon(this.a.getResources().getDrawable(2130840348));
        SoundAndVibrateActivity.d(this.a).setRightIcon(this.a.getResources().getDrawable(2130840346));
        SoundAndVibrateActivity.a(this.a).setContentDescription(this.a.getString(2131561818) + this.a.getString(2131558457));
        SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131563089) + this.a.getString(2131558457));
        SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131563010) + this.a.getString(2131558457));
        SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131563096) + this.a.getString(2131562854));
        break;
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        break label441;
        SoundAndVibrateActivity.a(this.a).setBackgroundResource(2130837877);
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        SoundAndVibrateActivity.b(this.a).setBackgroundResource(2130837877);
        SoundAndVibrateActivity.b(this.a).setVisibility(8);
        this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(0);
        break label452;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     diz
 * JD-Core Version:    0.7.0.1
 */