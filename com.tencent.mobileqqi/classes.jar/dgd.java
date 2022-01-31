import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.EUCountryUtils;

class dgd
  implements DialogInterface.OnClickListener
{
  dgd(dgb paramdgb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str = RegisterPhoneNumActivity.a(this.a.a).getText().toString();
    QLog.e("testt", 2, "Register cancel uin: " + str);
    EUCountryUtils.a(str, false);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dgd
 * JD-Core Version:    0.7.0.1
 */