import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class zls
  implements Runnable
{
  public zls(HotChatCenterManager paramHotChatCenterManager, HotChatItemData paramHotChatItemData) {}
  
  public void run()
  {
    EntityManager localEntityManager = null;
    Object localObject4 = null;
    localObject2 = localObject4;
    localObject1 = localEntityManager;
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
        localObject1 = localObject2;
        QLog.e("HotChatCenterManager", 1, localThrowable, new Object[0]);
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
      localObject2 = localObject4;
      localObject1 = localEntityManager;
      localEntityManager = localQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject2 = localEntityManager;
      localObject1 = localEntityManager;
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData.getStatus() == 1000)
      {
        localObject2 = localEntityManager;
        localObject1 = localEntityManager;
        localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData);
        localObject2 = localEntityManager;
        localObject1 = localEntityManager;
        if (QLog.isColorLevel())
        {
          localObject2 = localEntityManager;
          localObject1 = localEntityManager;
          QLog.d("HotChatCenterManager", 2, new Object[] { "[persist],code:", this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData.mHotChatCode });
        }
        if (localEntityManager != null) {
          localEntityManager.a();
        }
      }
      else
      {
        localObject2 = localEntityManager;
        localObject1 = localEntityManager;
        localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zls
 * JD-Core Version:    0.7.0.1
 */