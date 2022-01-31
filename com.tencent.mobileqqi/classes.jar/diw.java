import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity.SoundStyle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class diw
  implements View.OnClickListener
{
  public diw(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a(SoundAndVibrateActivity.SoundStyle.office);
    SettingCloneUtil.writeValueForInt(this.a, this.a.b.a(), "sound_type", "qqsetting_notify_soundtype_key", 2131165197);
    if (this.a.a().booleanValue())
    {
      this.a.d();
      this.a.a(Uri.parse("android.resource://" + this.a.getApplicationContext().getPackageName() + "/" + 2131165197));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     diw
 * JD-Core Version:    0.7.0.1
 */