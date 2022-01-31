import QQService.AddDiscussMemberInfo;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.ResultRecord;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class evz
  extends Thread
{
  public evz(SelectMemberActivity paramSelectMemberActivity, FriendManager paramFriendManager) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.a());
    int i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c.size() - 1;
    Object localObject2;
    if (i >= 0)
    {
      SelectMemberActivity.ResultRecord localResultRecord = (SelectMemberActivity.ResultRecord)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c.get(i);
      localObject2 = new AddDiscussMemberInfo();
      label91:
      String str;
      Object localObject3;
      if (localResultRecord.jdField_a_of_type_Int == 4)
      {
        ((AddDiscussMemberInfo)localObject2).RefStr = localResultRecord.jdField_a_of_type_JavaLangString;
        ((AddDiscussMemberInfo)localObject2).Type = localResultRecord.jdField_a_of_type_Int;
        localArrayList.add(localObject2);
        str = (String)localObject1 + "、";
        localObject2 = null;
        if (localResultRecord.jdField_a_of_type_Int != 0) {
          break label272;
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c(localResultRecord.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = ((Friends)localObject3).name;
          if (!TextUtils.isEmpty(((Friends)localObject3).remark)) {
            break label262;
          }
          localObject2 = ((Friends)localObject3).name;
        }
        label189:
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label497;
        }
      }
      label262:
      label272:
      label497:
      for (localObject1 = str + localResultRecord.jdField_a_of_type_JavaLangString;; localObject1 = str + (String)localObject1)
      {
        i -= 1;
        break;
        ((AddDiscussMemberInfo)localObject2).Uin = Long.valueOf(localResultRecord.jdField_a_of_type_JavaLangString).longValue();
        ((AddDiscussMemberInfo)localObject2).RefUin = Long.valueOf(localResultRecord.c).longValue();
        break label91;
        localObject2 = ((Friends)localObject3).remark;
        break label189;
        if (localResultRecord.jdField_a_of_type_Int == 1)
        {
          localObject3 = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b, localResultRecord.c, localResultRecord.jdField_a_of_type_JavaLangString);
          localObject1 = localObject2;
          if (localObject3 == null) {
            break label189;
          }
          localObject1 = localObject2;
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject3).friendnick)) {
            break label189;
          }
          localObject1 = ((TroopMemberInfo)localObject3).friendnick;
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject3).autoremark))
          {
            localObject2 = ((TroopMemberInfo)localObject3).friendnick;
            break label189;
          }
          localObject2 = ((TroopMemberInfo)localObject3).autoremark;
          break label189;
        }
        if (localResultRecord.jdField_a_of_type_Int == 2)
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a(localResultRecord.c, localResultRecord.jdField_a_of_type_JavaLangString);
          localObject1 = localObject2;
          if (localObject3 == null) {
            break label189;
          }
          localObject1 = localObject2;
          if (((DiscussionMemberInfo)localObject3).inteRemark == null) {
            break label189;
          }
          localObject1 = localObject2;
          if (((DiscussionMemberInfo)localObject3).inteRemark.length() <= 0) {
            break label189;
          }
          localObject1 = ((DiscussionMemberInfo)localObject3).inteRemark;
          localObject2 = ((DiscussionMemberInfo)localObject3).inteRemark;
          break label189;
        }
        if (localResultRecord.jdField_a_of_type_Int == 3)
        {
          localObject1 = localResultRecord.b;
          localObject2 = localResultRecord.b;
          break label189;
        }
        localObject1 = localObject2;
        if (localResultRecord.jdField_a_of_type_Int != 4) {
          break label189;
        }
        localObject1 = localResultRecord.b;
        localObject2 = localResultRecord.b;
        break label189;
      }
    }
    label797:
    for (;;)
    {
      try
      {
        if (((String)localObject1).getBytes("utf-8").length <= 48) {
          break label797;
        }
        int j = ((String)localObject1).length();
        i = 1;
        if (i > j) {
          break label797;
        }
        if (((String)localObject1).substring(0, i).getBytes("utf-8").length <= 48) {
          continue;
        }
        localObject2 = ((String)localObject1).substring(0, i - 1);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
        SelectMemberActivity.jdField_a_of_type_Boolean = false;
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SelectMemberActivity", 2, "add discussion member: groupCode: " + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.E + " member count: " + localArrayList.size());
        localException.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.E).longValue(), localArrayList);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendToVideo", false)) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d = localArrayList;
      }
      localObject2 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.a(6);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.E == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "create discussion: " + (String)localObject1 + " member count: " + localArrayList.size());
        }
        if (10 == this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.q)
        {
          SelectMemberActivity.jdField_a_of_type_Boolean = true;
          ((DiscussionHandler)localObject2).a((String)localObject1, localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.p);
          return;
          i += 1;
          continue;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     evz
 * JD-Core Version:    0.7.0.1
 */