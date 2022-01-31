import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class zer
  implements Runnable
{
  public zer(HotChatCenterManager paramHotChatCenterManager, HotChatItemData paramHotChatItemData) {}
  
  public void run()
  {
    Object localObject3 = null;
    EntityManager localEntityManager2 = null;
    localEntityManager1 = localEntityManager2;
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppHotChatCenterManager.a();
        if (localQQAppInterface != null) {
          continue;
        }
        if (0 != 0) {
          throw new NullPointerException();
        }
      }
      catch (Throwable localThrowable)
      {
        QQAppInterface localQQAppInterface;
        localObject1 = localEntityManager1;
        QLog.e("HotChatCenterManager", 1, localThrowable, new Object[0]);
        if (localEntityManager1 == null) {
          continue;
        }
        localEntityManager1.a();
        return;
      }
      finally
      {
        if (localObject1 == null) {
          continue;
        }
        ((EntityManager)localObject1).a();
      }
      return;
      localEntityManager1 = localEntityManager2;
      localObject1 = localObject3;
      localEntityManager2 = localQQAppInterface.getEntityManagerFactory().createEntityManager();
      localEntityManager1 = localEntityManager2;
      localObject1 = localEntityManager2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData.getStatus() == 1000)
      {
        localEntityManager1 = localEntityManager2;
        localObject1 = localEntityManager2;
        localEntityManager2.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData);
        localEntityManager1 = localEntityManager2;
        localObject1 = localEntityManager2;
        if (QLog.isColorLevel())
        {
          localEntityManager1 = localEntityManager2;
          localObject1 = localEntityManager2;
          QLog.d("HotChatCenterManager", 2, new Object[] { "[persist],code:", this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData.mHotChatCode });
        }
        if (localEntityManager2 != null) {
          localEntityManager2.a();
        }
      }
      else
      {
        localEntityManager1 = localEntityManager2;
        localObject1 = localEntityManager2;
        localEntityManager2.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zer
 * JD-Core Version:    0.7.0.1
 */