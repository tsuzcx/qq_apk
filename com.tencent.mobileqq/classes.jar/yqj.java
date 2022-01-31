import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.qphone.base.util.QLog;

public class yqj
  implements Runnable
{
  public yqj(ApolloManager paramApolloManager, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "getApolloBaseInfoFromCache failed, to call getApolloBaseInfo");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.b(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yqj
 * JD-Core Version:    0.7.0.1
 */