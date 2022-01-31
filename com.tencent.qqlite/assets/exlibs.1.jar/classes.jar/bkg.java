import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class bkg
  implements CompoundButton.OnCheckedChangeListener
{
  public bkg(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    int k = SettingCloneUtil.readValueForInt(this.a, this.a.app.a(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.b);
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(true);
      SoundAndVibrateActivity.a(this.a).setVisibility(0);
      SoundAndVibrateActivity.b(this.a).setVisibility(0);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      SoundAndVibrateActivity.a(this.a).setVisibility(0);
      paramCompoundButton = ThemeUtil.getUserCurrentThemeId(this.a.app);
      if (paramCompoundButton.equals("1000")) {
        break label1320;
      }
      paramCompoundButton = ThemeUtil.getThemeInfo(this.a, paramCompoundButton);
      if ((paramCompoundButton == null) || (!paramCompoundButton.isVoiceTheme)) {
        break label1320;
      }
    }
    label415:
    label1315:
    label1320:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        SoundAndVibrateActivity.a(this.a).setVisibility(0);
      }
      if (k == 2131165184)
      {
        SoundAndVibrateActivity.b(this.a).setRightIcon(this.a.getResources().getDrawable(2130839426));
        SoundAndVibrateActivity.c(this.a).setRightIcon(null);
        SoundAndVibrateActivity.d(this.a).setRightIcon(null);
        SoundAndVibrateActivity.e(this.a).setRightIcon(null);
        SoundAndVibrateActivity.a(this.a, 0);
        SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131363650) + this.a.getString(2131364358));
        SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131363651) + this.a.getString(2131364359));
        SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131363652) + this.a.getString(2131364359));
        SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131363653) + this.a.getString(2131364359));
        if (this.a.app.b() != 0) {
          break label1215;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        this.a.app.e(1);
        label426:
        paramCompoundButton = this.a.app;
        if (!paramBoolean) {
          break label1315;
        }
      }
      for (i = j;; i = 0)
      {
        ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_notice_sound", 0, i, "", "", "", "");
        return;
        if (k == 2131165185)
        {
          SoundAndVibrateActivity.b(this.a).setRightIcon(null);
          SoundAndVibrateActivity.c(this.a).setRightIcon(this.a.getResources().getDrawable(2130839426));
          SoundAndVibrateActivity.d(this.a).setRightIcon(null);
          SoundAndVibrateActivity.e(this.a).setRightIcon(null);
          SoundAndVibrateActivity.a(this.a, 1);
          SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131363650) + this.a.getString(2131364359));
          SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131363651) + this.a.getString(2131364358));
          SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131363652) + this.a.getString(2131364359));
          SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131363653) + this.a.getString(2131364359));
          break;
        }
        if (k == SoundAndVibrateActivity.jdField_a_of_type_Int)
        {
          SoundAndVibrateActivity.b(this.a).setRightIcon(null);
          SoundAndVibrateActivity.c(this.a).setRightIcon(null);
          SoundAndVibrateActivity.d(this.a).setRightIcon(this.a.getResources().getDrawable(2130839426));
          SoundAndVibrateActivity.e(this.a).setRightIcon(null);
          SoundAndVibrateActivity.a(this.a, 2);
          SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131363650) + this.a.getString(2131364359));
          SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131363651) + this.a.getString(2131364359));
          SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131363652) + this.a.getString(2131364358));
          SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131363653) + this.a.getString(2131364359));
          break;
        }
        if (k != SoundAndVibrateActivity.b) {
          break;
        }
        SoundAndVibrateActivity.b(this.a).setRightIcon(null);
        SoundAndVibrateActivity.c(this.a).setRightIcon(null);
        SoundAndVibrateActivity.d(this.a).setRightIcon(null);
        SoundAndVibrateActivity.e(this.a).setRightIcon(this.a.getResources().getDrawable(2130839426));
        SoundAndVibrateActivity.a(this.a, 3);
        SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131363650) + this.a.getString(2131364359));
        SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131363651) + this.a.getString(2131364359));
        SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131363652) + this.a.getString(2131364359));
        SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131363653) + this.a.getString(2131364358));
        break;
        label1215:
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        break label415;
        SoundAndVibrateActivity.a(this.a).setVisibility(8);
        SoundAndVibrateActivity.b(this.a).setVisibility(8);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        SoundAndVibrateActivity.a(this.a).setVisibility(8);
        SoundAndVibrateActivity.a(this.a).setVisibility(8);
        SoundAndVibrateActivity.a(this.a).setVisibility(8);
        this.a.app.e(0);
        break label426;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bkg
 * JD-Core Version:    0.7.0.1
 */