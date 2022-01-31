import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;

class yrn
  implements Runnable
{
  yrn(yrm paramyrm, HttpURLConnection paramHttpURLConnection) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_JavaNetHttpURLConnection.disconnect();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("apollo_client_ApolloUrlInterceptor", 2, "disconnect error:" + localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yrn
 * JD-Core Version:    0.7.0.1
 */