import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;

public class zoo
  implements Runnable
{
  public zoo(TroopManager paramTroopManager, TroopMemberInfo paramTroopMemberInfo, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.getEntityManagerFactory().createEntityManager();
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.getStatus() == 1000) {
      ((EntityManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo);
    }
    for (;;)
    {
      ((EntityManager)localObject).a();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_JavaLangString);
      new Handler(Looper.getMainLooper()).post(new zop(this, (ArrayList)localObject));
      return;
      ((EntityManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zoo
 * JD-Core Version:    0.7.0.1
 */