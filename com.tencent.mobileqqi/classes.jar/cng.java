import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.permission.PermissionCallback;

class cng
  implements PermissionCallback
{
  cng(cnf paramcnf) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.a.a.a, paramInt, paramArrayOfString, new cnh(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a.a.jdField_a_of_type_AndroidNetUri = ProfileActivity.a(this.a.a.a, 5);
    ReportController.b(this.a.a.a.b, "CliOper", "", "", "0X8004176", "0X8004176", ProfileActivity.a(this.a.a.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.f), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cng
 * JD-Core Version:    0.7.0.1
 */