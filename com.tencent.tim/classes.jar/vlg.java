import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.qphone.base.util.QLog;

public class vlg
  implements DialogInterface.OnClickListener
{
  public vlg(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "showRecommendDialog cancel clicked!");
    }
    anot.a(this.a.app, "dc00898", "", "", "0X800A605", "0X800A605", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vlg
 * JD-Core Version:    0.7.0.1
 */