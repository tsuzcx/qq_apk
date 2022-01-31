import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

public class xwx
  implements DialogInterface.OnClickListener
{
  public xwx(SelectMemberActivity paramSelectMemberActivity, ArrayList paramArrayList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.a(20)).b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c, this.jdField_a_of_type_JavaUtilArrayList, "");
    SelectMemberActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.show();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, "dc00899", "invite_friend", "", "friend_list", "Clk_invite", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c, TroopMemberUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c) + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xwx
 * JD-Core Version:    0.7.0.1
 */