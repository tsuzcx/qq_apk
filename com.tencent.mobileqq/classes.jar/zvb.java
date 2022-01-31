import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.utils.TroopNameHelper;

public class zvb
  implements Runnable
{
  public zvb(TroopManager paramTroopManager, TroopMemberInfo paramTroopMemberInfo, Handler paramHandler, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.getEntityManagerFactory().createEntityManager();
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.getStatus() == 1000) {
      localEntityManager.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo);
    }
    for (;;)
    {
      localEntityManager.a();
      this.jdField_a_of_type_AndroidOsHandler.post(new zvc(this));
      if (this.jdField_a_of_type_Boolean) {
        TroopNameHelper.a(this.jdField_a_of_type_JavaLangString);
      }
      return;
      localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zvb
 * JD-Core Version:    0.7.0.1
 */