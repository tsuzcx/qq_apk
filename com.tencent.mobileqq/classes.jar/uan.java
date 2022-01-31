import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.DBUtils;
import java.util.List;

public class uan
  implements Runnable
{
  public uan(TroopMemberListActivity paramTroopMemberListActivity, FriendsManager paramFriendsManager) {}
  
  public void run()
  {
    Object localObject1 = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.v);
    DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.v);
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.v);
      synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a((TroopMemberInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.add(localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uan
 * JD-Core Version:    0.7.0.1
 */