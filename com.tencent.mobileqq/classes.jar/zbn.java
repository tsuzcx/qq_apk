import com.tencent.mobileqq.apollo.store.webview.ApolloWebDataHandler;
import com.tencent.qphone.base.util.QLog;

public final class zbn
  implements Runnable
{
  public void run()
  {
    long l = System.currentTimeMillis();
    if (!ApolloWebDataHandler.a()) {
      ApolloWebDataHandler.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "apollo_client initInAsyncThread use:" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zbn
 * JD-Core Version:    0.7.0.1
 */