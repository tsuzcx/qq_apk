import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;

public class ucn
  implements DialogInterface.OnClickListener
{
  public ucn(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.setClass(this.this$0, SubAccountBindActivity.class);
    paramDialogInterface.putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
    this.this$0.startActivity(paramDialogInterface);
    anot.a(this.this$0.app, "CliOper", "", "", "0X80040A6", "0X80040A6", 0, 0, "", "", "", "");
    this.this$0.bFr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ucn
 * JD-Core Version:    0.7.0.1
 */