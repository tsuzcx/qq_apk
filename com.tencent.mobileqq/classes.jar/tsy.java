import android.provider.Settings.System;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class tsy
  implements View.OnClickListener
{
  public tsy(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a(2);
    SettingCloneUtil.writeValueForInt(this.a, this.a.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.a);
    if (this.a.a().booleanValue())
    {
      paramView = Settings.System.DEFAULT_NOTIFICATION_URI;
      this.a.b();
      this.a.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tsy
 * JD-Core Version:    0.7.0.1
 */