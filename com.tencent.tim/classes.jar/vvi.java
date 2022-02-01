import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

public class vvi
  implements View.OnClickListener
{
  public vvi(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.setVisible(3);
    SettingCloneUtil.writeValueForInt(this.a, this.a.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.bAg);
    if (this.a.j().booleanValue())
    {
      this.a.bVz();
      Object localObject = ThemeUtil.getThemeVoiceRootPath();
      if (localObject == null) {
        break label126;
      }
      localObject = new File((String)localObject + File.separatorChar + "message.mp3");
      if (!((File)localObject).exists()) {
        break label126;
      }
      this.a.bVz();
      this.a.d(Uri.fromFile((File)localObject));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label126:
      this.a.bVz();
      this.a.d(Uri.parse("android.resource://" + this.a.getApplicationContext().getPackageName() + "/" + 2131230721));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vvi
 * JD-Core Version:    0.7.0.1
 */