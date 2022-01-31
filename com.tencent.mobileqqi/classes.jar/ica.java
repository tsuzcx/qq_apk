import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import cooperation.qzone.ServerSetting;
import cooperation.qzone.widget.RadioPreference;

public class ica
  implements Preference.OnPreferenceClickListener
{
  public ica(ServerSetting paramServerSetting) {}
  
  public boolean onPreferenceClick(Preference paramPreference)
  {
    ServerSetting.a(this.a);
    ((RadioPreference)paramPreference).a(true);
    paramPreference = ((RadioPreference)paramPreference).getKey();
    ServerSetting.a(this.a, paramPreference, 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ica
 * JD-Core Version:    0.7.0.1
 */