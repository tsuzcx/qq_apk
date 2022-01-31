import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.mobileqq.activity.contacts.base.CardViewController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class wmp
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  public wmp(CardViewController paramCardViewController) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = "contact_recommend_config_json_" + CardViewController.a(this.a).getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "mConfigChangelistener CONTACT_RECOMMEND_CONFIG_JSON ");
    }
    if (paramSharedPreferences.equals(paramString)) {
      CardViewController.a(this.a, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wmp
 * JD-Core Version:    0.7.0.1
 */