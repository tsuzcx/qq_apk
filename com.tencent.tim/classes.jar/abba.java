import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

class abba
  implements DialogInterface.OnDismissListener
{
  abba(abaz paramabaz, acsz paramacsz) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "finish all settings when dialog dismiss");
    }
    if (aqiw.isNetworkAvailable(this.jdField_a_of_type_Abaz.a))
    {
      boolean bool1 = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_Abaz.a).isChecked();
      boolean bool2 = QQSpecialFriendSettingActivity.b(this.jdField_a_of_type_Abaz.a).isChecked();
      paramDialogInterface = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_Abaz.a);
      String str = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_Abaz.a);
      int i = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_Abaz.a);
      paramDialogInterface.a(str, new int[] { 2, 3 }, new boolean[] { bool1, bool2 }, new String[] { String.valueOf(i), null });
      paramDialogInterface = this.jdField_a_of_type_Abaz.a.mHandler.obtainMessage(8193);
      paramDialogInterface.obj = this.jdField_a_of_type_Abaz.a.getString(2131701719);
      this.jdField_a_of_type_Abaz.a.mHandler.sendMessage(paramDialogInterface);
      if ((bool1) && (bool2))
      {
        paramDialogInterface = "0";
        anot.a(null, "CliOper", "", "", "0X80050E2", "0X80050E2", 0, 0, paramDialogInterface, "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Acsz.destory();
      return;
      paramDialogInterface = "1";
      break;
      paramDialogInterface = this.jdField_a_of_type_Abaz.a.mHandler.obtainMessage(8195);
      paramDialogInterface.arg1 = 0;
      paramDialogInterface.arg2 = 2131693404;
      this.jdField_a_of_type_Abaz.a.mHandler.sendMessage(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abba
 * JD-Core Version:    0.7.0.1
 */