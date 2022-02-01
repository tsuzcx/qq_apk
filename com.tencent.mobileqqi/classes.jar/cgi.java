import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.activity.AuthDevConfirmPhoneNoActivity;
import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class cgi
  implements DialogInterface.OnClickListener
{
  public cgi(DevlockPushActivity paramDevlockPushActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.DevlockPushActivity", 2, "On Click Right Button! ");
    }
    try
    {
      ReportController.b(null, "P_CliOper", "Safe_DeviceLock", this.a.b.a(), "UserBehavior", "Push", 0, 5, "", "", "", "");
      label46:
      if ((DevlockPushActivity.a(this.a) != null) && (DevlockPushActivity.a(this.a).AllowSet == 1))
      {
        paramDialogInterface = new Intent(this.a, AuthDevActivity.class);
        if (DevlockPushActivity.a(this.a) != null)
        {
          paramDialogInterface.putExtra("phone_num", DevlockPushActivity.a(this.a).Mobile);
          paramDialogInterface.putExtra("country_code", DevlockPushActivity.a(this.a).CountryCode);
        }
        paramDialogInterface.putExtra("auth_dev_open", false);
        paramDialogInterface.putExtra("allow_set", true);
        this.a.startActivity(paramDialogInterface);
        this.a.finish();
        return;
      }
      if ((DevlockPushActivity.a(this.a) != null) && (!TextUtils.isEmpty(DevlockPushActivity.a(this.a).Mobile)))
      {
        paramDialogInterface = new Intent(this.a, AuthDevConfirmPhoneNoActivity.class);
        paramDialogInterface.putExtra("ParaTextUp", DevlockPushActivity.a(this.a));
        paramDialogInterface.putExtra("ParaTextDown", DevlockPushActivity.b(this.a));
        paramDialogInterface.putExtra("PhoneNO", DevlockPushActivity.a(this.a).Mobile);
        paramDialogInterface.putExtra("mainaccount", DevlockPushActivity.c(this.a));
        paramDialogInterface.putExtra("uin", DevlockPushActivity.d(this.a));
        paramDialogInterface.putExtra("from_where", DevlockPushActivity.e(this.a));
        paramDialogInterface.putExtra("DevlockInfo", DevlockPushActivity.a(this.a));
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
 * Qualified Name:     cgi
 * JD-Core Version:    0.7.0.1
 */