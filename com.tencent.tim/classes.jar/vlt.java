import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.qphone.base.util.QLog;

public class vlt
  implements DialogInterface.OnClickListener
{
  public vlt(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "showRecommendDialog confirm clicked!");
    }
    PhoneUnityBindInfoActivity.b(this.a);
    anot.a(this.a.app, "dc00898", "", "", "0X800A604", "0X800A604", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vlt
 * JD-Core Version:    0.7.0.1
 */