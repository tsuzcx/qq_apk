import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberItem;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class dtp
  extends Thread
{
  public dtp(TroopTransferActivity.TroopMemberListAdapter paramTroopMemberListAdapter, TroopTransferActivity paramTroopTransferActivity) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_JavaUtilArrayList.size();
    FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j)
    {
      TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (TextUtils.isEmpty(localTroopMemberItem.a)) {}
      for (;;)
      {
        i += 1;
        break;
        if (localFriendManager == null)
        {
          localObject = null;
          label108:
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
            localTroopMemberItem.g = ((Friends)localObject).name;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
            localTroopMemberItem.j = ((Friends)localObject).remark;
          }
          if (localFriendsManagerImp != null) {
            break label457;
          }
          localObject = null;
          label161:
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(localTroopMemberItem.a))) {
            break label481;
          }
          localObject = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_b_of_type_JavaLangString), localTroopMemberItem.a);
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopnick))) {
            localTroopMemberItem.m = ((TroopMemberInfo)localObject).troopnick;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopremark))) {
            localTroopMemberItem.j = ((TroopMemberInfo)localObject).troopremark;
          }
          label261:
          if (TextUtils.isEmpty(localTroopMemberItem.j)) {
            break label490;
          }
          localTroopMemberItem.jdField_b_of_type_JavaLangString = localTroopMemberItem.j;
          label282:
          if (TextUtils.isEmpty(localTroopMemberItem.jdField_b_of_type_JavaLangString)) {
            break label573;
          }
          localTroopMemberItem.c = ChnToSpell.a(localTroopMemberItem.jdField_b_of_type_JavaLangString, 2);
          localTroopMemberItem.d = ChnToSpell.a(localTroopMemberItem.jdField_b_of_type_JavaLangString, 1);
          label321:
          if (TextUtils.isEmpty(localTroopMemberItem.g)) {
            break label590;
          }
          localTroopMemberItem.h = ChnToSpell.a(localTroopMemberItem.g, 2);
          localTroopMemberItem.i = ChnToSpell.a(localTroopMemberItem.g, 1);
          label360:
          if (TextUtils.isEmpty(localTroopMemberItem.j)) {
            break label607;
          }
          localTroopMemberItem.k = ChnToSpell.a(localTroopMemberItem.j, 2);
        }
        for (localTroopMemberItem.l = ChnToSpell.a(localTroopMemberItem.j, 1);; localTroopMemberItem.l = "")
        {
          if (TextUtils.isEmpty(localTroopMemberItem.m)) {
            break label624;
          }
          localTroopMemberItem.n = ChnToSpell.a(localTroopMemberItem.m, 2);
          localTroopMemberItem.o = ChnToSpell.a(localTroopMemberItem.m, 1);
          break;
          localObject = localFriendManager.c(localTroopMemberItem.a);
          break label108;
          label457:
          localObject = localFriendsManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_b_of_type_JavaLangString, localTroopMemberItem.a);
          break label161;
          label481:
          localTroopMemberItem.m = ((String)localObject);
          break label261;
          label490:
          if (!TextUtils.isEmpty(localTroopMemberItem.m))
          {
            localTroopMemberItem.jdField_b_of_type_JavaLangString = localTroopMemberItem.m;
            break label282;
          }
          if (!TextUtils.isEmpty(localTroopMemberItem.g))
          {
            localTroopMemberItem.jdField_b_of_type_JavaLangString = localTroopMemberItem.g;
            break label282;
          }
          if (TextUtils.isEmpty(localTroopMemberItem.a)) {
            break label282;
          }
          localTroopMemberItem.jdField_b_of_type_JavaLangString = localTroopMemberItem.a;
          localArrayList.add(localTroopMemberItem.a);
          break label282;
          label573:
          localTroopMemberItem.c = "";
          localTroopMemberItem.d = "";
          break label321;
          label590:
          localTroopMemberItem.h = "";
          localTroopMemberItem.i = "";
          break label360;
          label607:
          localTroopMemberItem.k = "";
        }
        label624:
        localTroopMemberItem.n = "";
        localTroopMemberItem.o = "";
      }
    }
    Object localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.transfer", 2, "init list data, size = " + localArrayList.size() + ", frh = " + localObject);
    }
    if ((localArrayList.size() > 0) && (localObject != null)) {
      ((TroopHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.c, localArrayList);
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.runOnUiThread(new dtq(this));
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopdisband.transfer", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dtp
 * JD-Core Version:    0.7.0.1
 */