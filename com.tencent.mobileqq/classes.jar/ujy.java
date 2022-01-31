import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberItem;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ujy
  implements Runnable
{
  public ujy(TroopTransferActivity.TroopMemberListAdapter paramTroopMemberListAdapter, TroopTransferActivity paramTroopTransferActivity) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_JavaUtilArrayList.size();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(51);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(50);
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
        if (localFriendsManager == null)
        {
          localObject = null;
          label108:
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
            localTroopMemberItem.g = ((Friends)localObject).name;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
            localTroopMemberItem.j = ((Friends)localObject).remark;
          }
          if (localTroopManager != null) {
            break label455;
          }
          localObject = null;
          label161:
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(localTroopMemberItem.a))) {
            break label479;
          }
          localObject = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a), localTroopMemberItem.a);
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopnick))) {
            localTroopMemberItem.m = ((TroopMemberInfo)localObject).troopnick;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopremark))) {
            localTroopMemberItem.j = ((TroopMemberInfo)localObject).troopremark;
          }
          label261:
          if (TextUtils.isEmpty(localTroopMemberItem.j)) {
            break label488;
          }
          localTroopMemberItem.b = localTroopMemberItem.j;
          label282:
          if (TextUtils.isEmpty(localTroopMemberItem.b)) {
            break label571;
          }
          localTroopMemberItem.c = ChnToSpell.a(localTroopMemberItem.b, 2);
          localTroopMemberItem.d = ChnToSpell.a(localTroopMemberItem.b, 1);
          label321:
          if (TextUtils.isEmpty(localTroopMemberItem.g)) {
            break label588;
          }
          localTroopMemberItem.h = ChnToSpell.a(localTroopMemberItem.g, 2);
          localTroopMemberItem.i = ChnToSpell.a(localTroopMemberItem.g, 1);
          label360:
          if (TextUtils.isEmpty(localTroopMemberItem.j)) {
            break label605;
          }
          localTroopMemberItem.k = ChnToSpell.a(localTroopMemberItem.j, 2);
        }
        for (localTroopMemberItem.l = ChnToSpell.a(localTroopMemberItem.j, 1);; localTroopMemberItem.l = "")
        {
          if (TextUtils.isEmpty(localTroopMemberItem.m)) {
            break label622;
          }
          localTroopMemberItem.n = ChnToSpell.a(localTroopMemberItem.m, 2);
          localTroopMemberItem.o = ChnToSpell.a(localTroopMemberItem.m, 1);
          break;
          localObject = localFriendsManager.c(localTroopMemberItem.a);
          break label108;
          label455:
          localObject = localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, localTroopMemberItem.a);
          break label161;
          label479:
          localTroopMemberItem.m = ((String)localObject);
          break label261;
          label488:
          if (!TextUtils.isEmpty(localTroopMemberItem.m))
          {
            localTroopMemberItem.b = localTroopMemberItem.m;
            break label282;
          }
          if (!TextUtils.isEmpty(localTroopMemberItem.g))
          {
            localTroopMemberItem.b = localTroopMemberItem.g;
            break label282;
          }
          if (TextUtils.isEmpty(localTroopMemberItem.a)) {
            break label282;
          }
          localTroopMemberItem.b = localTroopMemberItem.a;
          localArrayList.add(localTroopMemberItem.a);
          break label282;
          label571:
          localTroopMemberItem.c = "";
          localTroopMemberItem.d = "";
          break label321;
          label588:
          localTroopMemberItem.h = "";
          localTroopMemberItem.i = "";
          break label360;
          label605:
          localTroopMemberItem.k = "";
        }
        label622:
        localTroopMemberItem.n = "";
        localTroopMemberItem.o = "";
      }
    }
    Object localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.a(20);
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.transfer", 2, "init list data, size = " + localArrayList.size() + ", frh = " + localObject);
    }
    if ((localArrayList.size() > 0) && (localObject != null)) {
      ((TroopHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.b, localArrayList);
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.runOnUiThread(new ujz(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ujy
 * JD-Core Version:    0.7.0.1
 */