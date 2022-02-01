import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vvj
  implements CompoundButton.OnCheckedChangeListener
{
  public vvj(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int k = SettingCloneUtil.readValueForInt(this.a, this.a.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.bAg);
    Object localObject;
    if (paramBoolean)
    {
      this.a.aF.setClickable(true);
      this.a.aF.setVisibility(0);
      VasWebviewUtil.reportCommercialDrainage(this.a.app.getCurrentAccountUin(), "bell", "show", "", 1, 0, 0, "", "", "");
      SoundAndVibrateActivity.b(this.a).setBackgroundResource(2130839701);
      int j = 0;
      localObject = ThemeUtil.getUserCurrentThemeId(this.a.app);
      i = j;
      if (!((String)localObject).equals("1000"))
      {
        localObject = ThemeUtil.getThemeInfo(this.a, (String)localObject);
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((ThemeUtil.ThemeInfo)localObject).isVoiceTheme) {
            i = 1;
          }
        }
      }
      if (i != 0)
      {
        SoundAndVibrateActivity.c(this.a).setBackgroundResource(2130839682);
        SoundAndVibrateActivity.c(this.a).setVisibility(0);
      }
      if (k == 2131230720)
      {
        SoundAndVibrateActivity.a(this.a).setRightIcon(this.a.getResources().getDrawable(2130851794));
        SoundAndVibrateActivity.b(this.a).setRightIcon(null);
        SoundAndVibrateActivity.c(this.a).setRightIcon(null);
        SoundAndVibrateActivity.d(this.a).setRightIcon(null);
        SoundAndVibrateActivity.a(this.a, 0);
        if (AppSetting.enableTalkBack)
        {
          SoundAndVibrateActivity.a(this.a).setContentDescription(this.a.getString(2131720389) + this.a.getString(2131691504));
          SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131720390) + this.a.getString(2131721546));
          SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131720391) + this.a.getString(2131721546));
          SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131720392) + this.a.getString(2131721546));
        }
        if (this.a.app.AG() != 0) {
          break label1293;
        }
        this.a.aF.setChecked(false);
        label455:
        this.a.app.JB(1);
        SoundAndVibrateActivity.d(this.a).setChecked(true);
        label477:
        localObject = this.a.app;
        if (!paramBoolean) {
          break label1393;
        }
      }
    }
    label1293:
    label1393:
    for (int i = 1;; i = 0)
    {
      anot.a((QQAppInterface)localObject, "CliOper", "", "", "Setting_tab", "Clk_notice_sound", 0, i, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (k == 2131230721)
      {
        SoundAndVibrateActivity.a(this.a).setRightIcon(null);
        SoundAndVibrateActivity.b(this.a).setRightIcon(this.a.getResources().getDrawable(2130851794));
        SoundAndVibrateActivity.c(this.a).setRightIcon(null);
        SoundAndVibrateActivity.d(this.a).setRightIcon(null);
        SoundAndVibrateActivity.a(this.a, 1);
        if (!AppSetting.enableTalkBack) {
          break;
        }
        SoundAndVibrateActivity.a(this.a).setContentDescription(this.a.getString(2131720389) + this.a.getString(2131721546));
        SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131720390) + this.a.getString(2131691504));
        SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131720391) + this.a.getString(2131721546));
        SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131720392) + this.a.getString(2131721546));
        break;
      }
      if (k == SoundAndVibrateActivity.bAf)
      {
        SoundAndVibrateActivity.a(this.a).setRightIcon(null);
        SoundAndVibrateActivity.b(this.a).setRightIcon(null);
        SoundAndVibrateActivity.c(this.a).setRightIcon(this.a.getResources().getDrawable(2130851794));
        SoundAndVibrateActivity.d(this.a).setRightIcon(null);
        SoundAndVibrateActivity.a(this.a, 2);
        if (!AppSetting.enableTalkBack) {
          break;
        }
        SoundAndVibrateActivity.a(this.a).setContentDescription(this.a.getString(2131720389) + this.a.getString(2131721546));
        SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131720390) + this.a.getString(2131721546));
        SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131720391) + this.a.getString(2131691504));
        SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131720392) + this.a.getString(2131721546));
        break;
      }
      if (k != SoundAndVibrateActivity.bAg) {
        break;
      }
      SoundAndVibrateActivity.a(this.a).setRightIcon(null);
      SoundAndVibrateActivity.b(this.a).setRightIcon(null);
      SoundAndVibrateActivity.c(this.a).setRightIcon(null);
      SoundAndVibrateActivity.d(this.a).setRightIcon(this.a.getResources().getDrawable(2130851794));
      SoundAndVibrateActivity.a(this.a, 3);
      if (!AppSetting.enableTalkBack) {
        break;
      }
      SoundAndVibrateActivity.a(this.a).setContentDescription(this.a.getString(2131720389) + this.a.getString(2131721546));
      SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131720390) + this.a.getString(2131721546));
      SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131720391) + this.a.getString(2131721546));
      SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131720392) + this.a.getString(2131691504));
      break;
      this.a.aF.setChecked(true);
      break label455;
      SoundAndVibrateActivity.b(this.a).setBackgroundResource(2130839682);
      this.a.aF.setVisibility(8);
      SoundAndVibrateActivity.e(this.a).setVisibility(8);
      SoundAndVibrateActivity.c(this.a).setVisibility(8);
      SoundAndVibrateActivity.c(this.a).setBackgroundResource(2130839682);
      SoundAndVibrateActivity.c(this.a).setVisibility(8);
      this.a.app.JB(0);
      break label477;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vvj
 * JD-Core Version:    0.7.0.1
 */