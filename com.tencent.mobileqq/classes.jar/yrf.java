import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public final class yrf
  extends DownloadListener
{
  public yrf(SharedPreferences paramSharedPreferences, int paramInt, ApolloSSOConfig paramApolloSSOConfig) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    QLog.i("apollo_client_ApolloSSOConfig", 1, "checkUpdateApolloWebViewConfig download file task.getStatus()->" + paramDownloadTask.a() + ", httpCode: " + paramDownloadTask.e);
    if (3 == paramDownloadTask.a())
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_apollo_webView_config_version", this.jdField_a_of_type_Int).commit();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig download version:" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig != null) {
        ApolloSSOConfig.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yrf
 * JD-Core Version:    0.7.0.1
 */