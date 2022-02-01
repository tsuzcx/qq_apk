import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.qphone.base.util.QLog;

public class zqr
  implements DialogInterface.OnClickListener
{
  public zqr(DialogBaseActivity paramDialogBaseActivity, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.bsr)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "new user guild confirm unbind");
      }
      anot.a(this.a.app, "dc00898", "", "", "0X8006AA5", "0X8006AA5", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zqr
 * JD-Core Version:    0.7.0.1
 */