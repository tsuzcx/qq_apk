import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class avqz
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  avqz(avqy paramavqy) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = BaseApplicationImpl.getApplication().getRuntime();
    if (paramSharedPreferences != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged key = " + paramString);
      }
      if ((!avqy.a(this.b)) && (avqy.a(this.b) != null))
      {
        if (avqy.a(this.b, paramSharedPreferences.getAccount()).equals(paramString)) {
          avqy.a(this.b, avqy.a(this.b).getInt(paramString, 0));
        }
        if (avqy.b(this.b, paramSharedPreferences.getAccount()).equals(paramString)) {
          avqy.c(this.b, avqy.a(this.b).getString(paramString, null));
        }
        if (avqy.d(this.b, paramSharedPreferences.getAccount()).equals(paramString)) {
          avqy.e(this.b, avqy.a(this.b).getString(paramString, null));
        }
        if (QLog.isColorLevel()) {
          QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged value = " + avqy.a(this.b) + " personlizedYellowVipUrl = " + avqy.a(this.b));
        }
      }
      avqy.a(this.b, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avqz
 * JD-Core Version:    0.7.0.1
 */