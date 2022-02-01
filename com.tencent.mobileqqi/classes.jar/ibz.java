import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import cooperation.qzone.ServerSetting;
import cooperation.qzone.widget.RadioPreference;

public class ibz
  implements Preference.OnPreferenceClickListener
{
  public ibz(ServerSetting paramServerSetting) {}
  
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
 * Qualified Name:     ibz
 * JD-Core Version:    0.7.0.1
 */