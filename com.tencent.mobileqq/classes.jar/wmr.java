import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class wmr
  implements Runnable
{
  public wmr(AddContactsView paramAddContactsView, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d();
    if (i != 0) {
      this.jdField_a_of_type_JavaLangStringBuilder.append(ConditionSearchManager.jdField_a_of_type_ArrayOfJavaLangString[i]).append("、");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(localObject[0], localObject[1]);
    if (!ConditionSearchManager.b[0].equals(localObject)) {
      this.jdField_a_of_type_JavaLangStringBuilder.append((String)localObject).append("、");
    }
    i = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
    if ((i != 0) && (i != ConditionSearchManager.d.length - 1)) {
      this.jdField_a_of_type_JavaLangStringBuilder.append(ConditionSearchManager.e[i]).append("、");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_Boolean) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.b)) {
        if ("-1".equals(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ArrayOfJavaLangString[0]))
        {
          localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if (localObject == null) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ArrayOfJavaLangString = ((Card)localObject).strLocationCodes.split("-");
        if (QLog.isColorLevel()) {
          QLog.d("AddContactsView", 2, "card.strLocationCodes = " + ((Card)localObject).strLocationCodes);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ArrayOfJavaLangString[3] = "0";
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ArrayOfJavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ArrayOfJavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0, (String)localObject);
          if (!"0".equals(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ArrayOfJavaLangString[0])) {
            this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b((String)localObject)).append("、");
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(1);
          if (!((String)localObject).startsWith("不限")) {
            this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b((String)localObject)).append("、");
          }
          i = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c();
          if (i != 0) {
            this.jdField_a_of_type_JavaLangStringBuilder.append(ConditionSearchManager.c[i]).append("、");
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new wms(this));
          return;
          localException1 = localException1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AddContactsView", 2, "spliteLocationString | exception: ", localException1);
          continue;
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AddContactsView", 2, "parseLocationDesc", localException2);
          continue;
        }
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0);
      if (!str.startsWith("不限")) {
        this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(str)).append("、");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wmr
 * JD-Core Version:    0.7.0.1
 */