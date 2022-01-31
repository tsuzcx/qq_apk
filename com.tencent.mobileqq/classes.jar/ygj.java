import com.tencent.ark.ark;
import com.tencent.mobileqq.apollo.ApolloGameArkHandler;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.qphone.base.util.QLog;

public class ygj
  implements Runnable
{
  public ygj(ApolloGameArkHandler paramApolloGameArkHandler, MessageForApollo paramMessageForApollo, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      ark.arkNotify(ApolloGameArkHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameArkHandler, this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo), this.jdField_a_of_type_JavaLangString, this.b, "json");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQ_CmGame", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ygj
 * JD-Core Version:    0.7.0.1
 */