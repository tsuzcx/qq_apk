import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.PhoneUnityManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;

class wvl
  implements DialogInterface.OnClickListener
{
  wvl(wvj paramwvj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.jdField_b_of_type_Int == 2) {
      ReportController.b(this.a.a.app, "CliOper", "", "", "0X8005B8A", "0X8005B8A", 1, 0, "", "", "", "");
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      if (NetworkUtil.d(this.a.a)) {
        break;
      }
      this.a.a.b(2131434613);
      return;
      if (this.a.a.jdField_b_of_type_Int == 6) {
        ReportController.b(this.a.a.app, "CliOper", "", "", "0X8005B8A", "0X8005B8A", 2, 0, "", "", "", "");
      } else if (this.a.a.jdField_b_of_type_Int == 7) {
        ReportController.b(this.a.a.app, "CliOper", "", "", "0X8005B8A", "0X8005B8A", 3, 0, "", "", "", "");
      }
    }
    paramDialogInterface = this.a.a.a.a();
    if ((paramDialogInterface == null) || (paramDialogInterface.nationCode == null) || (paramDialogInterface.mobileNo == null))
    {
      this.a.a.setResult(0);
      this.a.a.finish();
      return;
    }
    if (this.a.a.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.a.a.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new wvm(this);
      this.a.a.app.registObserver(this.a.a.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    PhoneUnityManager localPhoneUnityManager = (PhoneUnityManager)this.a.a.app.getManager(101);
    this.a.a.a.b(paramDialogInterface.nationCode, paramDialogInterface.mobileNo);
    this.a.a.a(2131434453, 0L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wvl
 * JD-Core Version:    0.7.0.1
 */