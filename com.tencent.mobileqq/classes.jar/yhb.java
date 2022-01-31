import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.data.ApolloPandora;
import com.tencent.qphone.base.util.QLog;

public class yhb
  implements Runnable
{
  public yhb(ApolloManager paramApolloManager, String paramString) {}
  
  public void run()
  {
    ApolloPandora localApolloPandora = this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a(this.jdField_a_of_type_JavaLangString, true);
    if (localApolloPandora != null)
    {
      localApolloPandora.hadStolen = 1;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a(localApolloPandora);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "setCapsuleHadStolenAsync uin had Stolen");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloManager", 2, "setCapsuleHadStolenAsync local not save apolloPandora");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yhb
 * JD-Core Version:    0.7.0.1
 */