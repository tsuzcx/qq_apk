import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AuthDevConfirmPhoneNoActivity;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class bvv
  implements DialogInterface.OnClickListener
{
  public bvv(AuthDevOpenUgActivity paramAuthDevOpenUgActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "On Click Right Button! ");
    }
    try
    {
      ReportController.b(null, "P_CliOper", "Safe_DeviceLock", this.a.b.a(), "UserBehavior", "Manually", 0, 5, "", "", "", "");
      label46:
      if ((AuthDevOpenUgActivity.a(this.a) != null) && (!TextUtils.isEmpty(AuthDevOpenUgActivity.a(this.a).Mobile)))
      {
        paramDialogInterface = new Intent(this.a, AuthDevConfirmPhoneNoActivity.class);
        paramDialogInterface.putExtra("ParaTextUp", AuthDevOpenUgActivity.a(this.a));
        paramDialogInterface.putExtra("ParaTextDown", AuthDevOpenUgActivity.b(this.a));
        paramDialogInterface.putExtra("PhoneNO", AuthDevOpenUgActivity.a(this.a).Mobile);
        paramDialogInterface.putExtra("mainaccount", AuthDevOpenUgActivity.c(this.a));
        paramDialogInterface.putExtra("uin", AuthDevOpenUgActivity.d(this.a));
        paramDialogInterface.putExtra("from_where", AuthDevOpenUgActivity.e(this.a));
        paramDialogInterface.putExtra("DevlockInfo", AuthDevOpenUgActivity.a(this.a));
        this.a.startActivityForResult(paramDialogInterface, 1001);
        this.a.overridePendingTransition(0, 2130968598);
        return;
      }
      EquipLockWebEntrance.a(this.a, this.a.b, 1003, null);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label46;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bvv
 * JD-Core Version:    0.7.0.1
 */