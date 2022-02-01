import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

class ahgr
  implements DialogInterface.OnClickListener
{
  ahgr(ahgq paramahgq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardBaseOption", 2, "qbShowShareResultDialog back");
      }
      if (!this.this$0.mActivity.isFinishing()) {
        ahgq.a(this.this$0).dismiss();
      }
      this.this$0.mActivity.finish();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->qbShowShareResultDialog--stay");
    }
    this.this$0.mActivity.finish();
    paramDialogInterface = new Intent(this.this$0.mActivity, SplashActivity.class);
    paramDialogInterface.addFlags(335544320);
    this.this$0.mActivity.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ahgr
 * JD-Core Version:    0.7.0.1
 */