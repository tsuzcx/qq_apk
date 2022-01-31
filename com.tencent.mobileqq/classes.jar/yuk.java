import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class yuk
  implements BusinessObserver
{
  public yuk(ApolloSSOConfig paramApolloSSOConfig, AppInterface paramAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramBoolean, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloSSOConfig", 2, "checkRequestSendSSO, type:" + paramInt + "isSuccess:" + paramBoolean + "onReceive use:" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yuk
 * JD-Core Version:    0.7.0.1
 */