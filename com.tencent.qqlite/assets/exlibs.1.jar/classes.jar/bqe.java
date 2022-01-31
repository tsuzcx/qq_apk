import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberItem;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;

public class bqe
  extends Thread
{
  public bqe(TroopTransferActivity paramTroopTransferActivity, Friends paramFriends, TroopTransferActivity.TroopMemberItem paramTroopMemberItem) {}
  
  public void run()
  {
    label166:
    String str;
    label187:
    boolean bool;
    if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.j))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.j = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.m))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.k = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.m, 2);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.l = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.m, 1);
      }
    }
    else
    {
      if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.g))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.g = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.g)) {
          break label290;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.h = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.g, 2);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.i = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.g, 1);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.j)) {
        break label311;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.j;
      if (Utils.a(str, this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.b)) {
        break label412;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.b = str;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.b)) {
        break label389;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.c = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.b, 2);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.d = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.b, 1);
      bool = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a(bool);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.k = "";
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.l = "";
      break;
      label290:
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.h = "";
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.i = "";
      break label166;
      label311:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.m))
      {
        str = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.m;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.g))
      {
        str = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.g;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.a))
      {
        str = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.a;
        break label187;
      }
      str = "";
      break label187;
      label389:
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.c = "";
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.d = "";
      bool = true;
      continue;
      label412:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bqe
 * JD-Core Version:    0.7.0.1
 */