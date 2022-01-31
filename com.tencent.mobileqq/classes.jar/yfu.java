import android.text.TextUtils;
import com.tencent.mobileqq.addon.DiyPendantEntity;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.Iterator;
import java.util.List;

public class yfu
  implements Runnable
{
  public yfu(DiyPendantFetcher paramDiyPendantFetcher, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(DiyPendantEntity.class, true, null, null, null, null, null, " 20 ");
    if ((localList != null) && (localList.size() > 0))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        DiyPendantEntity localDiyPendantEntity = (DiyPendantEntity)localIterator.next();
        if (!TextUtils.isEmpty(localDiyPendantEntity.uinAndDiyId)) {
          this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.a.put(localDiyPendantEntity.uinAndDiyId, localDiyPendantEntity);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("DiyPendantFetcher", 2, "initCacheFromDB, size: " + localList.size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     yfu
 * JD-Core Version:    0.7.0.1
 */