import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

final class abva
  extends aquy
{
  abva(SharedPreferences paramSharedPreferences, int paramInt, abuy paramabuy) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    QLog.i("apollo_client_ApolloSSOConfig", 1, "checkUpdateApolloWebViewConfig download file task.getStatus()->" + paramaquz.getStatus() + ", httpCode: " + paramaquz.httpCode);
    if (3 == paramaquz.getStatus())
    {
      this.H.edit().putInt("sp_key_apollo_webView_config_version", this.Un).commit();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig download version:" + this.Un);
      }
      if (this.b != null) {
        abuy.a(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abva
 * JD-Core Version:    0.7.0.1
 */