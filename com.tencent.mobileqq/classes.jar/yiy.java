import android.text.TextUtils;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.addon.DiyPendantFetcher.Invalidatable;
import com.tencent.mobileqq.addon.DiyPendantHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class yiy
  implements Runnable
{
  public yiy(DiyPendantFetcher paramDiyPendantFetcher, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject2;
    if (!this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("DiyPendantFetcher", 2, "now query mUnCacheDiyId: " + TextUtils.join(",", this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet));
      }
      this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty())
      {
        localObject1 = (DiyPendantHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(114);
        localObject2 = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
        while (localIterator.hasNext()) {
          ((List)localObject2).add(Long.valueOf(Long.parseLong(((java.lang.String)localIterator.next()).split("_")[0])));
        }
        ((DiyPendantHandler)localObject1).a((List)localObject2, null);
        this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.clear();
      }
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.b.isEmpty()) {
      this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.b();
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DiyPendantFetcher.Invalidatable)((Iterator)localObject1).next();
      if ((localObject2 == null) || (((DiyPendantFetcher.Invalidatable)localObject2).a() == null)) {
        this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
      }
    }
    DiyPendantFetcher.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     yiy
 * JD-Core Version:    0.7.0.1
 */