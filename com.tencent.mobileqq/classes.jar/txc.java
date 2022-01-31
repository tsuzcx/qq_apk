import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class txc
  implements Runnable
{
  public txc(TroopMemberListActivity paramTroopMemberListActivity, Intent paramIntent, FriendsManager paramFriendsManager, TroopManager paramTroopManager) {}
  
  public void run()
  {
    boolean bool2 = false;
    ??? = "";
    int i;
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("memberOperationFlag", 0);
      ??? = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("memberOperateUin");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "onActivityResult, REQUEST_CODE_SHOW_MEMBER_CARD, optFlg=" + i + ", optUin=" + (String)???);
      }
      if ((i & 0x1) != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a((String)???);
        if (((i & 0x4) != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_JavaLangString);
          ??? = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop())) {
            break label508;
          }
        }
      }
      label508:
      for (boolean bool1 = true;; bool1 = false) {
        for (;;)
        {
          ((TroopMemberListActivity)???).jdField_b_of_type_Boolean = bool1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.e = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
            }
            ??? = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app.getCurrentAccountUin())))
            {
              bool1 = bool2;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f != null)
              {
                bool1 = bool2;
                if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f.contains(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app.getCurrentAccountUin())) {}
              }
            }
            else
            {
              bool1 = true;
            }
            ((TroopMemberListActivity)???).jdField_a_of_type_Boolean = bool1;
            if (QLog.isColorLevel()) {
              QLog.d("TroopMemberListActivityget_troop_member", 2, "onActivityResult, REQUEST_CODE_SHOW_MEMBER_CARD, admins:" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f + " owner:" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.e);
            }
          }
          if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
          }
          return;
          if ((i & 0x2) == 0) {
            break;
          }
          Object localObject2 = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_JavaLangString, (String)???);
          if ((localObject2 == null) || (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager == null)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a((String)???);
          synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a((TroopMemberInfo)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager);
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.add(localObject2);
          }
        }
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     txc
 * JD-Core Version:    0.7.0.1
 */