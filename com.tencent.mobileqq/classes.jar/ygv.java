import QQService.AddDiscussMemberInfo;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ygv
  extends Thread
{
  public ygv(SelectMemberActivity paramSelectMemberActivity, FriendsManager paramFriendsManager) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getCurrentAccountUin());
    int i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.size() - 1;
    ResultRecord localResultRecord;
    Object localObject2;
    String str;
    if (i >= 0)
    {
      localResultRecord = (ResultRecord)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.get(i);
      localObject2 = new AddDiscussMemberInfo();
      if (localResultRecord.jdField_a_of_type_Int == 4)
      {
        ((AddDiscussMemberInfo)localObject2).RefStr = localResultRecord.jdField_a_of_type_JavaLangString;
        ((AddDiscussMemberInfo)localObject2).Type = localResultRecord.jdField_a_of_type_Int;
        localArrayList1.add(localObject2);
        localArrayList2.add(String.valueOf(((AddDiscussMemberInfo)localObject2).Uin));
        str = (String)localObject1 + "、";
        localObject2 = null;
        if (localResultRecord.jdField_a_of_type_Int != 0) {
          break label330;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(localResultRecord.jdField_a_of_type_JavaLangString);
        if (localObject2 == null) {
          break label888;
        }
        localObject1 = ((Friends)localObject2).name;
        if (!TextUtils.isEmpty(((Friends)localObject2).remark)) {
          break label320;
        }
        localObject2 = ((Friends)localObject2).name;
      }
    }
    for (;;)
    {
      label207:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = str + localResultRecord.jdField_a_of_type_JavaLangString;
      }
      for (;;)
      {
        for (;;)
        {
          i -= 1;
          break;
          try
          {
            ((AddDiscussMemberInfo)localObject2).Uin = Long.valueOf(localResultRecord.jdField_a_of_type_JavaLangString).longValue();
            ((AddDiscussMemberInfo)localObject2).RefUin = Long.valueOf(localResultRecord.c).longValue();
          }
          catch (NumberFormatException localNumberFormatException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SelectMemberActivity", 2, "NumberFormatException!!! uin=" + localResultRecord.jdField_a_of_type_JavaLangString);
            }
          }
        }
        continue;
        label320:
        localObject3 = localNumberFormatException.remark;
        break label207;
        label330:
        Object localObject5;
        if (localResultRecord.jdField_a_of_type_Int == 1)
        {
          localObject5 = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, localResultRecord.c, localResultRecord.jdField_a_of_type_JavaLangString);
          localObject1 = localObject3;
          if (localObject5 == null) {
            break label207;
          }
          localObject1 = localObject3;
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject5).friendnick)) {
            break label207;
          }
          localObject1 = ((TroopMemberInfo)localObject5).friendnick;
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject5).autoremark))
          {
            localObject3 = ((TroopMemberInfo)localObject5).friendnick;
            break label207;
          }
          localObject3 = ((TroopMemberInfo)localObject5).autoremark;
          break label207;
        }
        if (localResultRecord.jdField_a_of_type_Int == 2)
        {
          localObject5 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(52)).a(localResultRecord.c, localResultRecord.jdField_a_of_type_JavaLangString);
          localObject1 = localObject3;
          if (localObject5 == null) {
            break label207;
          }
          localObject1 = localObject3;
          if (((DiscussionMemberInfo)localObject5).inteRemark == null) {
            break label207;
          }
          localObject1 = localObject3;
          if (((DiscussionMemberInfo)localObject5).inteRemark.length() <= 0) {
            break label207;
          }
          localObject1 = ((DiscussionMemberInfo)localObject5).inteRemark;
          localObject3 = ((DiscussionMemberInfo)localObject5).inteRemark;
          break label207;
        }
        if (localResultRecord.jdField_a_of_type_Int == 3)
        {
          localObject1 = localResultRecord.b;
          localObject3 = localResultRecord.b;
          break label207;
        }
        localObject1 = localObject3;
        if (localResultRecord.jdField_a_of_type_Int != 4) {
          break label207;
        }
        localObject1 = localResultRecord.b;
        localObject3 = localResultRecord.b;
        break label207;
        localObject1 = str + (String)localObject1;
      }
      Object localObject3 = localObject1;
      for (;;)
      {
        try
        {
          if (((String)localObject1).getBytes("utf-8").length > 48)
          {
            int j = ((String)localObject1).length();
            i = 1;
            localObject3 = localObject1;
            if (i <= j)
            {
              if (((String)localObject1).substring(0, i).getBytes("utf-8").length <= 48) {
                continue;
              }
              localObject3 = ((String)localObject1).substring(0, i - 1);
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          Object localObject4 = localObject1;
          continue;
          if (13 != this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_f_of_type_Int) {
            continue;
          }
          SelectMemberActivity.jdField_f_of_type_Boolean = false;
          continue;
          SelectMemberActivity.jdField_f_of_type_Boolean = false;
          continue;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SelectMemberActivity", 2, "add discussion member: groupCode: " + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c + " member count: " + localArrayList1.size());
          ((DiscussionHandler)localObject1).b(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c).longValue(), localArrayList1);
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.getBooleanExtra("sendToVideo", false)) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.k = localArrayList1;
        }
        localObject1 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.a(6);
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "create discussion: " + (String)localObject3 + " member count: " + localArrayList1.size());
        }
        if (10 != this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_f_of_type_Int) {
          continue;
        }
        SelectMemberActivity.jdField_f_of_type_Boolean = true;
        ((DiscussionHandler)localObject1).a((String)localObject3, localArrayList1, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e);
        return;
        i += 1;
      }
      label888:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ygv
 * JD-Core Version:    0.7.0.1
 */