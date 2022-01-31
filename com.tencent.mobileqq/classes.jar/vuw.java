import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;

public class vuw
  implements Runnable
{
  public vuw(HotChatPie paramHotChatPie, HotChatInfo paramHotChatInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = new TroopFeedsCenterLogic(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, HotChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie), HotChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie), this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.Q, null);
    }
    HotChatHandler localHotChatHandler = (HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35);
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.userCreate == 1) {
      localHotChatHandler.b(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid == null) {
      return;
    }
    localHotChatHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid.getBytes(), this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vuw
 * JD-Core Version:    0.7.0.1
 */