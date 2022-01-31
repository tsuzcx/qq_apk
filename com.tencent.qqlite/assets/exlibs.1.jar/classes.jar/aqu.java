import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aqu
  implements DialogInterface.OnClickListener
{
  public aqu(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = GroupManagerActivity.a(this.a).getInputValue();
    if (paramDialogInterface.equals("")) {
      paramDialogInterface = this.a.getResources().getString(2131364163);
    }
    for (;;)
    {
      if (GroupManagerActivity.a(this.a) == 0) {
        if (this.a.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          b = (byte)(((Groups)this.a.jdField_a_of_type_JavaUtilList.get(this.a.jdField_a_of_type_JavaUtilList.size() - 1)).seqid + 1);
          GroupManagerActivity.a(this.a, this.a.a(b, paramDialogInterface));
          if (QLog.isColorLevel()) {
            QLog.d(GroupManagerActivity.jdField_a_of_type_JavaLangString, 2, "AddFriendGroup needShowDialog = " + GroupManagerActivity.a(this.a));
          }
          if (GroupManagerActivity.a(this.a)) {
            this.a.a(2131363789);
          }
          ReportController.b(this.a.app, "CliOper", "", "", "category", "Add_category", 0, 0, "", "", "", "");
        }
      }
      while (1 != GroupManagerActivity.a(this.a)) {
        for (;;)
        {
          return;
          byte b = 1;
        }
      }
      GroupManagerActivity.a(this.a, this.a.b((byte)this.a.jdField_a_of_type_ComTencentMobileqqDataGroups.group_id, paramDialogInterface));
      if (QLog.isColorLevel()) {
        QLog.d(GroupManagerActivity.jdField_a_of_type_JavaLangString, 2, "EditeFriendGroup needShowDialog = " + GroupManagerActivity.a(this.a));
      }
      if (GroupManagerActivity.a(this.a)) {
        this.a.a(2131363791);
      }
      ReportController.b(this.a.app, "CliOper", "", "", "category", "Name_category", 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aqu
 * JD-Core Version:    0.7.0.1
 */