import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;

public class zpu
  implements DialogInterface.OnClickListener
{
  public zpu(BindNumberActivity paramBindNumberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BindNumberActivity.a(this.this$0);
    paramDialogInterface.dismiss();
    paramDialogInterface = this.this$0.getIntent();
    if (paramDialogInterface.getBooleanExtra("kFPhoneChange", false)) {
      this.this$0.report("CliOper", "0X8005DE9", 1);
    }
    if (paramDialogInterface.getBooleanExtra("kUnityOther", false)) {
      this.this$0.report("CliOper", "0X8005DE9", 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zpu
 * JD-Core Version:    0.7.0.1
 */