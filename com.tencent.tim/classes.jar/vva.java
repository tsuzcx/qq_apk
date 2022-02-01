import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vva
  implements CompoundButton.OnCheckedChangeListener
{
  public vva(SoundAndVibrateActivity paramSoundAndVibrateActivity, SharedPreferences paramSharedPreferences) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = this.v.edit();
    ((SharedPreferences.Editor)localObject).putBoolean("theme_voice_setting_" + this.a.app.getCurrentAccountUin(), paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
    localObject = this.a.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      anot.a((QQAppInterface)localObject, "CliOper", "", "", "ThemeSound", "SwitchTabSound", 0, i, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vva
 * JD-Core Version:    0.7.0.1
 */