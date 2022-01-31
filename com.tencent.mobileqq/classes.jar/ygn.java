import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class ygn
  implements Runnable
{
  public ygn(SelectMemberActivity paramSelectMemberActivity, String paramString) {}
  
  public void run()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, "dc00899", "invite_friend", "", "friend_list", this.jdField_a_of_type_JavaLangString, 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c, TroopMemberUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c) + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ygn
 * JD-Core Version:    0.7.0.1
 */