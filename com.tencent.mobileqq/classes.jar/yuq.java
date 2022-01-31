import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor;
import com.tencent.mobileqq.apollo.store.webview.ApolloWebStatistics;
import com.tencent.qphone.base.util.QLog;

public class yuq
  implements Runnable
{
  public yuq(ApolloUrlInterceptor paramApolloUrlInterceptor) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runSonicFlow in AsyncThread start!");
    }
    ApolloWebStatistics localApolloWebStatistics = ApolloUrlInterceptor.a(this.a);
    long l = System.currentTimeMillis();
    localApolloWebStatistics.g = l;
    ApolloUrlInterceptor.a(this.a);
    ApolloUrlInterceptor.b(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runSonicFlow use:" + (System.currentTimeMillis() - l));
    }
    ApolloUrlInterceptor.a(this.a).h = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yuq
 * JD-Core Version:    0.7.0.1
 */