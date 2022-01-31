import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class cbe
  implements CompoundButton.OnCheckedChangeListener
{
  public cbe(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    PreferenceManager.getDefaultSharedPreferences(this.a.b.getApplication()).edit().putBoolean("setting_aio_realtime_bg_open" + this.a.b.a(), paramBoolean).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cbe
 * JD-Core Version:    0.7.0.1
 */