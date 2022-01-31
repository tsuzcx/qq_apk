import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.HotchatSCHelper;
import com.tencent.mobileqq.app.HotchatSCHelper.OnShowNoteListener;
import com.tencent.mobileqq.app.HotchatSCMng.HotchatNote;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.qphone.base.util.QLog;

public class vrp
  implements HotchatSCHelper.OnShowNoteListener
{
  public vrp(HotChatPie paramHotChatPie) {}
  
  public boolean a(HotchatSCMng.HotchatNote paramHotchatNote)
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("Q.aio.BaseTroopChatPie", "onShowHotchatNote", new Object[] { paramHotchatNote });
    }
    if (paramHotchatNote == null)
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, null, null);
      }
      return false;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = new TroopFeedsCenterLogic(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, HotChatPie.a(this.a), HotChatPie.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.a.Q, null);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramHotchatNote.a, paramHotchatNote.b);
    this.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vrp
 * JD-Core Version:    0.7.0.1
 */