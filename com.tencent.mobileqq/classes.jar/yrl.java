import android.text.TextUtils;
import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor;
import com.tencent.mobileqq.apollo.store.webview.ApolloWebDataHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class yrl
  implements Runnable
{
  public yrl(ApolloUrlInterceptor paramApolloUrlInterceptor, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 1, "session(" + this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlInterceptor.a + ") onClose:cachedStream size:" + this.jdField_a_of_type_JavaIoByteArrayOutputStream.size());
    }
    try
    {
      str = this.jdField_a_of_type_JavaIoByteArrayOutputStream.toString("UTF-8");
      this.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      if ((!TextUtils.isEmpty(str)) && (!ApolloUrlInterceptor.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlInterceptor)))
      {
        long l = System.currentTimeMillis();
        ApolloWebDataHandler.a().b(ApolloUrlInterceptor.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlInterceptor), str);
        ApolloUrlInterceptor.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlInterceptor, true);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 4, "session(" + this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlInterceptor.a + ") onClose:save bridgeStream " + (System.currentTimeMillis() - l) + " ms. htmlString.length:" + str.length());
        }
      }
      ApolloUrlInterceptor.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlInterceptor).set(false);
      if ((ApolloUrlInterceptor.b(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlInterceptor)) && (QLog.isColorLevel())) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 4, "session(" + this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlInterceptor.a + ") onClose: postForceDestroyIfNeed send destroy message.");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str = null;
        QLog.e("apollo_client_ApolloUrlInterceptor", 1, "session(" + this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlInterceptor.a + ") onClose error:" + localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yrl
 * JD-Core Version:    0.7.0.1
 */