import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity.SoundStyle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class dit
  implements View.OnClickListener
{
  public dit(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a(SoundAndVibrateActivity.SoundStyle.classic);
    SettingCloneUtil.writeValueForInt(this.a, this.a.b.a(), "sound_type", "qqsetting_notify_soundtype_key", 2131165184);
    if (this.a.a().booleanValue())
    {
      this.a.d();
      this.a.a(Uri.parse("android.resource://" + this.a.getApplicationContext().getPackageName() + "/" + 2131165184));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dit
 * JD-Core Version:    0.7.0.1
 */