import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class zcb
  implements Runnable
{
  HotChatInfo jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = null;
  
  public zcb(HotChatManager paramHotChatManager, HotChatInfo paramHotChatInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = paramHotChatInfo;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.jdField_a_of_type_JavaUtilMap.get(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin)) == null) {
        break label63;
      }
      if (QLog.isColorLevel()) {
        NearbyUtils.a("HotChatManager", new Object[] { "AddHotChatInfoRunnable already exist", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin });
      }
    }
    return;
    label63:
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatManager", new Object[] { "AddHotChatInfoRunnable", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin });
    }
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, 4);
    ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zcb
 * JD-Core Version:    0.7.0.1
 */