import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.app.RoamSettingManager;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.RoamSettingController;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class zja
  implements Runnable
{
  public zja(RoamSettingManager paramRoamSettingManager) {}
  
  public void run()
  {
    int i = 0;
    ArrayList localArrayList = (ArrayList)this.a.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RoamSetting.class, false, null, null, null, null, null, null);
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      this.a.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    for (;;)
    {
      try
      {
        if (i < localArrayList.size())
        {
          RoamSetting localRoamSetting = (RoamSetting)localArrayList.get(i);
          if (RoamSettingController.a(localRoamSetting.path) == 1) {
            this.a.b.put(localRoamSetting.path, localRoamSetting);
          } else {
            this.a.jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.put(localRoamSetting.path, localRoamSetting);
          }
        }
      }
      finally
      {
        this.a.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      this.a.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      this.a.jdField_a_of_type_Boolean = true;
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zja
 * JD-Core Version:    0.7.0.1
 */