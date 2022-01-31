import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity.SoundStyle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.io.File;

public class diy
  implements View.OnClickListener
{
  public diy(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a(SoundAndVibrateActivity.SoundStyle.theme);
    SettingCloneUtil.writeValueForInt(this.a, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.jdField_b_of_type_Int);
    if (this.a.a().booleanValue())
    {
      this.a.d();
      paramView = ThemeUtil.getThemeVoiceRootPath();
      if (paramView != null)
      {
        paramView = new File(paramView + File.separatorChar + "message.mp3");
        if (paramView.exists())
        {
          this.a.d();
          this.a.a(Uri.fromFile(paramView));
        }
      }
    }
    else
    {
      return;
    }
    this.a.d();
    this.a.a(Uri.parse("android.resource://" + this.a.getApplicationContext().getPackageName() + "/" + 2131165197));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     diy
 * JD-Core Version:    0.7.0.1
 */